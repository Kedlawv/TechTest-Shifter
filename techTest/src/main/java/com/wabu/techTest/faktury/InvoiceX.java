package com.wabu.techTest.faktury;

import java.time.LocalDate;
import java.util.List;

public class InvoiceX extends Invoice{

    public InvoiceX(String number, String issuer, String client, List<InvoiceItem> items) {
        super(number, issuer, client, items);
        setDueDate(calculateDueDate());
    }

    @Override
    public LocalDate calculateDueDate() {
        return getDate().plusDays(14L);
    }
}
