package me.projects.cqrseventsourcing.commonApi.commands;

public class CreditAccountCommand extends BaseCommand<String> {
    private Double amount;
    private String currency;

    public CreditAccountCommand(String id, Double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }


}
