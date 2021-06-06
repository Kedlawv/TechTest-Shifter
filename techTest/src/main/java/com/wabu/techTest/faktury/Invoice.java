package com.wabu.techTest.faktury;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public abstract class Invoice {
    private String number;
    private String issuer;
    private LocalDate date;
    private LocalDate dueDate;
    private String client;
    private List<InvoiceItem> items;
    protected BigDecimal taxRate;

    public Invoice(String number, String issuer, String client, List<InvoiceItem> items) {
        this.number = number;
        this.issuer = issuer;
        this.date = LocalDate.now();
        this.client = client;
        this.items = items;
    }

    public abstract LocalDate calculateDueDate();

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void addItem(InvoiceItem item) {
        this.items.add(item);
    }

    public void removeItem(InvoiceItem item){
        this.items.remove(item);
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getTaxRate(){
        return taxRate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "number='" + number + '\'' +
                ", issuer='" + issuer + '\'' +
                ", date=" + date +
                ", dueDate=" + dueDate +
                ", client='" + client + '\'' +
                ", items=" + items +
                '}';
    }
}
