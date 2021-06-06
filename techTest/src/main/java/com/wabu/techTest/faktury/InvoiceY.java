package com.wabu.techTest.faktury;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class InvoiceY extends Invoice{

    public InvoiceY(String number, String issuer, String client, List<InvoiceItem> items) {
        super(number, issuer, client, items);
        super.taxRate = BigDecimal.valueOf(0.18D);
        setDueDate(calculateDueDate());
    }

    @Override
    public LocalDate calculateDueDate() {
        return getDate().with(TemporalAdjusters.lastDayOfMonth());
    }
}
