package me.projects.cqrseventsourcing.commands.controllers;

import lombok.AllArgsConstructor;
import me.projects.cqrseventsourcing.commonApi.commands.CreateAccountCommand;
import me.projects.cqrseventsourcing.commonApi.dtos.CreateAccountRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/account")
@AllArgsConstructor
public class AccountCommandController {
    private CommandGateway commandGateway;

    @PostMapping("/create")
    private CompletableFuture<String> createAccount(@RequestBody CreateAccountRequestDTO accountDTO) {

        return commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                accountDTO.getInitialBalance(),
                accountDTO.getCurrency()));

    }
}
