package br.com.tasknow.workitemcommandservice.handler;

import br.com.tasknow.workitemcommandservice.commands.CreateWorkItemCommand;
import br.com.tasknow.workitemcommandservice.domain.WorkItem;
import br.com.tasknow.workitemcommandservice.repository.WorkItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UpdateWorkItemCommandHandler implements CommandHandler<CreateWorkItemCommand> {

    private final WorkItemRepository workItemRepository;

    @Override
    public void handle(CreateWorkItemCommand command) {
        workItemRepository.save(WorkItem
                .builder()
                .id(UUID.randomUUID())
                .name(command.name())
                .description(command.description())
                .user_id(command.user_id())
                .board_id(command.board_id())
                .build());

        // Emite evento após o comando ser executado

    }
}
