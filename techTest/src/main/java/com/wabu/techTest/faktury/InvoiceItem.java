package com.wabu.techTest.faktury;

import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItem {
    private String name;
    private BigDecimal unitPrice;
    private int quantity;

    public InvoiceItem(String name, BigDecimal unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSum(){
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return quantity == that.quantity &&
                Objects.equals(name, that.name) &&
                Objects.equals(unitPrice, that.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unitPrice, quantity);
    }

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                '}';
    }
}
