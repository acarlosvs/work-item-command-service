package br.com.tasknow.workitemcommandservice.commands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateWorkItemCommand(@NotNull String name, @NotBlank String description, @NotNull UUID user_id, @NotNull UUID board_id) implements Command {

}
