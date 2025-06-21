package br.com.tasknow.workitemcommandservice.dtos;

import lombok.Builder;

@Builder
public record NotificationDTO (String userId, Integer tipo) {

}
