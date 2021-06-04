package com.wabu.techTest.faktury;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class InvoiceY extends Invoice{

    public InvoiceY(String number, String issuer, String client, List<InvoiceItem> items) {
        super(number, issuer, client, items);
        setDueDate(calculateDueDate());
    }

    @Override
    public LocalDate calculateDueDate() {
        return getDate().with(TemporalAdjusters.lastDayOfMonth());
    }
}
