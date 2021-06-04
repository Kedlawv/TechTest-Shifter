package com.wabu.techTest.faktury;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class InvoiceUtils {


    /*
    Implement a method that for a list of invoices and indicated day will calculate a sum that the
    company should earn to the day. Include all invoices issued to the indicated day.
     */
    public BigDecimal getTotalIncomeToDay(List<Invoice> invoices, LocalDate toDate) {
        BigDecimal sum = BigDecimal.ZERO;

        for (Invoice inv : invoices) {
            if (inv.getDate().isBefore(toDate) || inv.getDate().isEqual(toDate)) {
                BigDecimal invSum = BigDecimal.ZERO;
                for (InvoiceItem item : inv.getItems()) {
                    invSum = invSum.add(item.getSum());
                }
                sum = sum.add(invSum);
            }
        }
        return sum;
    }

    /*
        Implement a method which returns an invoice of the indicated type X or Y with the largest value
        in the indicated type of invoice
     */

    public  <T extends Invoice> T getLargestOfType(List<Invoice> invoices, Class<T> type){
        List<T> filteredList = invoices.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());

        return filteredList.stream()
                .max(Comparator.comparing(this::getTotal))
                .orElseThrow(NoSuchElementException::new);
    }

    public BigDecimal getTotal(Invoice invoice){
        return invoice.getItems().stream()
                .map(InvoiceItem::getSum)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
