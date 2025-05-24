package br.com.tasknow.workitemcommandservice.controller;

import br.com.tasknow.workitemcommandservice.bus.CommandBus;
import br.com.tasknow.workitemcommandservice.commands.CreateWorkItemCommand;
import br.com.tasknow.workitemcommandservice.handler.UpdateWorkItemCommandHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/work-items")
public class WorkItemController {

    private final CommandBus commandBus;

    @PostMapping
    public void create(@Valid @RequestBody CreateWorkItemCommand command) {
        commandBus.dispatch(command);
    }

    @PatchMapping("move")
    public void moveBoard(@RequestBody UpdateWorkItemCommandHandler command) {

    }

    @PatchMapping("assign")
    public void assign(@RequestBody UpdateWorkItemCommandHandler command) {

    }
}
