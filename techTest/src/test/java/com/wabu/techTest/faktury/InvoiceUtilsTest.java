package com.wabu.techTest.faktury;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceUtilsTest {

    List<Invoice> testInvoices;

    @BeforeEach
    public void createInvoices(){
        testInvoices = new ArrayList<>();

        testInvoices.add(new InvoiceX("RZ001","W.Bus", "TTSW",
                Arrays.asList(
                        new InvoiceItem("T-Shirt",BigDecimal.valueOf(10.00D),1000),
                        new InvoiceItem("Pen",BigDecimal.valueOf(1.50D),10000),
                        new InvoiceItem("Hat",BigDecimal.valueOf(5.50D),500),
                        new InvoiceItem("Cup",BigDecimal.valueOf(7.00D),200)
                )));
        testInvoices.add(new InvoiceX("RZ002","W.Bus", "Oracle",
                Arrays.asList(
                        new InvoiceItem("T-Shirt",BigDecimal.valueOf(10.00D),101),
                        new InvoiceItem("Pen",BigDecimal.valueOf(1.50D),50),
                        new InvoiceItem("Hat",BigDecimal.valueOf(5.50D),70),
                        new InvoiceItem("Cup",BigDecimal.valueOf(7.00D),5)
                )));
        testInvoices.add(new InvoiceX("RZ003","W.Bus", "Sun Microsystems",
                Arrays.asList(
                        new InvoiceItem("T-Shirt",BigDecimal.valueOf(10.00D),50),
                        new InvoiceItem("Pen",BigDecimal.valueOf(1.50D),40),
                        new InvoiceItem("Hat",BigDecimal.valueOf(5.50D),20),
                        new InvoiceItem("Cup",BigDecimal.valueOf(7.00D),10)
                )));

        testInvoices.add(new InvoiceY("RZ004","W.Bus", "Sun Microsystems",
                Arrays.asList(
                        new InvoiceItem("T-Shirt",BigDecimal.valueOf(10.00D),100),
                        new InvoiceItem("Pen",BigDecimal.valueOf(1.50D),40),
                        new InvoiceItem("Hat",BigDecimal.valueOf(5.50D),100),
                        new InvoiceItem("Cup",BigDecimal.valueOf(7.00D),10)
                )));
        testInvoices.add(new InvoiceY("RZ005","W.Bus", "Google",
                Arrays.asList(
                        new InvoiceItem("T-Shirt",BigDecimal.valueOf(10.00D),100),
                        new InvoiceItem("Pen",BigDecimal.valueOf(1.50D),40000),
                        new InvoiceItem("Hat",BigDecimal.valueOf(5.50D),100),
                        new InvoiceItem("Cup",BigDecimal.valueOf(7.00D),10)
                )));
        testInvoices.get(0).setDate(LocalDate.of(2021,5,16));
        testInvoices.get(1).setDate(LocalDate.of(2021,5,13));
        testInvoices.get(2).setDate(LocalDate.of(2021,4,1));
        testInvoices.get(3).setDate(LocalDate.of(2021,6,1));
        testInvoices.get(4).setDate(LocalDate.of(2021,6,1));



    }

    @Test
    void getTotalIncomeToDay() {
        BigDecimal expectedSum = BigDecimal.valueOf(2245);

        BigDecimal actual = new InvoiceUtils().getTotalIncomeToDay(testInvoices,
                LocalDate.of(2021,5,15));

        assertEquals(0,expectedSum.compareTo(actual));
    }

    @Test
    void getTotalForInvoice(){
        BigDecimal expected = BigDecimal.valueOf(740);
        BigDecimal actual = new InvoiceUtils().getTotal(testInvoices.get(2));

        assertEquals(0, expected.compareTo(actual));
    }

    @Test
    void getLargestOfTypeForInvoiceX(){
        Class<InvoiceX> type = InvoiceX.class;
        Invoice expected = testInvoices.get(0);
        InvoiceX actual = new InvoiceUtils().getLargestOfType(testInvoices,type);

        assertSame(expected, actual);
    }

    @Test
    void getLargestOfTypeForInvoiceY(){
        Class<InvoiceY> type = InvoiceY.class;
        Invoice expected = testInvoices.get(4);
        InvoiceY actual = new InvoiceUtils().getLargestOfType(testInvoices,type);

        assertSame(expected, actual);
    }

    @Test
    void givenInvoiceXDueDate14Days(){
        LocalDate issueDate = testInvoices.get(0).getDate();
        LocalDate expectedDueDate = LocalDate.of(2021,5,30);

        LocalDate actual = testInvoices.get(0).getDueDate();
        System.out.println(issueDate);
        System.out.println(actual);

        assertTrue(expectedDueDate.isEqual(actual));
    }

    @Test
    void givenInvoiceYDueDateLastDayOfMonth(){
        LocalDate issueDate = testInvoices.get(0).getDate();
        LocalDate expectedDueDate = LocalDate.of(2021,6,30);

        LocalDate actual = testInvoices.get(4).getDueDate();
        System.out.println(issueDate);
        System.out.println(actual);

        assertTrue(expectedDueDate.isEqual(actual));
    }
}
