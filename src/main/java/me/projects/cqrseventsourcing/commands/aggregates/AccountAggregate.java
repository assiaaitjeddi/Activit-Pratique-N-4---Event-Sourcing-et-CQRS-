package me.projects.cqrseventsourcing.commands.aggregates;

import lombok.NoArgsConstructor;
import me.projects.cqrseventsourcing.commonApi.commands.CreateAccountCommand;
import me.projects.cqrseventsourcing.commonApi.enums.AccountStatus;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class AccountAggregate {
    @AggregateIdentifier
    private String id;
    private Double balance;
    private String currency;
    private AccountStatus accountStatus;

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand){
        if (createAccountCommand.getInitialBalance() < 0){
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

    }

}
