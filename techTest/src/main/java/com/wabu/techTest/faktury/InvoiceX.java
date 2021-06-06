package com.wabu.techTest.faktury;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class InvoiceX extends Invoice{



    public InvoiceX(String number, String issuer, String client, List<InvoiceItem> items) {
        super(number, issuer, client, items);
        super.taxRate = BigDecimal.valueOf(0.07D);
        setDueDate(calculateDueDate());
    }

    @Override
    public LocalDate calculateDueDate() {
        return getDate().plusDays(14L);
    }

    @Override
    public void setDate(LocalDate date) {
        super.setDate(date);
        setDueDate(calculateDueDate());
    }
}



