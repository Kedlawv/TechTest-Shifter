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

    /*
    Implement a method that will return a sum of all invoices where to the value of invoice of type X
    will be added tax 7% and to the invoice of type Y will be added tax 18%

    I added tax rate to the child classes of Invoice instead of external calculations in case in the
    future we would add for example an invoice with different tax rate.
    In that eventuality this method would not need to change
     */

    public BigDecimal getSumWithTaxForEach(List<Invoice> invoices){
        BigDecimal sumWithTax = BigDecimal.ZERO;
        for(Invoice i : invoices){
            sumWithTax = sumWithTax.add(this.getTotal(i).multiply(BigDecimal.ONE.add(i.taxRate)));
        }

        return sumWithTax;
    }

    /*
    for T reduce(T identity, java.util.function.BinaryOperator<T> accumulator)
    in the case below we need to use a Combiner. The types of the Accumulator and the types of the lambda do not match
    Accumulator is Invoice acc(Invoice,Invoice) it cannot infer the types correctly
    as BigDecimal acc(BigDecimal,Invoice) even though Identity is a BigDecimal
    Without the combiner BigDecimal::add the sum is of type invoice and return type is Invoice
     */

    public BigDecimal getSumWithTaxStream(List<Invoice> invoices){
        return invoices.stream()
                .reduce(BigDecimal.ZERO,
                        (sum,invoice) -> sum.add(this.getTotal(invoice)
                                .multiply(BigDecimal.ONE.add(invoice.taxRate))), BigDecimal::add);
    }






}
