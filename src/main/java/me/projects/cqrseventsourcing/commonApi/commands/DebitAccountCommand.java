package me.projects.cqrseventsourcing.commonApi.commands;

public class DebitAccountCommand extends BaseCommand<String> {
    private Double amount;
    private String currency;

    public DebitAccountCommand(String id, Double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
