package br.com.tasknow.workitemcommandservice.handler;

import br.com.tasknow.workitemcommandservice.commands.CreateWorkItemCommand;
import br.com.tasknow.workitemcommandservice.domain.WorkItem;
import br.com.tasknow.workitemcommandservice.dtos.NotificationDTO;
import br.com.tasknow.workitemcommandservice.repository.NotificationRepository;
import br.com.tasknow.workitemcommandservice.repository.WorkItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateWorkItemCommandHandler implements CommandHandler<CreateWorkItemCommand> {

    private final RabbitTemplate rabbitTemplate;
    private final WorkItemRepository workItemRepository;
    private final NotificationRepository notificationRepository;

    @Override
    public void handle(CreateWorkItemCommand command) {
        WorkItem workItem = workItemRepository.save(WorkItem
                .builder()
                .id(UUID.randomUUID())
                .name(command.name())
                .description(command.description())
                .user_id(command.user_id())
                .board_id(command.board_id())
                .build());

        //Como estou mandando pra essa routing key, deve cair na fila de criar e de atualizar
        rabbitTemplate.convertAndSend("tasknow.create.v1.r", workItem);

        notificationRepository.sendNotification(NotificationDTO
                .builder()
                .tipo(1)
                .userId("")
                .build());
    }
}
