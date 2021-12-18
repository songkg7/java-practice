package com.example.test.objects.chapter01;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {

    private List<Ticket> tickets = new ArrayList<>();
    private Long amount;

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

}
