package br.com.tasknow.workitemcommandservice.repository;

import br.com.tasknow.workitemcommandservice.dtos.NotificationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "NotificacaoClient", url = "${feign.apis.notification.base.url}")
public interface NotificationRepository {

    @PostMapping("/notification")
    ResponseEntity<NotificationDTO> sendNotification(NotificationDTO notificationDTO);
}
