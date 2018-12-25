package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

import java.math.BigDecimal;

public class Invoice extends Entity {
    private long idInvoice;
    private long numberInvoice;
    private BigDecimal cost;
    private long orderId;

    public Invoice() {
    }

    public Invoice(long idInvoice, long numberInvoice, BigDecimal cost, long orderId) {
        this.idInvoice = idInvoice;
        this.numberInvoice = numberInvoice;
        this.cost = cost;
        this.orderId = orderId;
    }

    public long getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(long idInvoice) {
        this.idInvoice = idInvoice;
    }

    public long getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(long numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (idInvoice != invoice.idInvoice) return false;
        if (numberInvoice != invoice.numberInvoice) return false;
        if (orderId != invoice.orderId) return false;
        return cost != null ? cost.equals(invoice.cost) : invoice.cost == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idInvoice ^ (idInvoice >>> 32));
        result = 31 * result + (int) (numberInvoice ^ (numberInvoice >>> 32));
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "idInvoice=" + idInvoice +
                ", numberInvoice=" + numberInvoice +
                ", cost=" + cost +
                ", orderId=" + orderId +
                '}';
    }
}
