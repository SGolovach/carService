package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

import java.math.BigDecimal;

/**
 * The Class Invoice.
 */
public class Invoice extends Entity {
    
    /** The id invoice. */
    private long idInvoice;
    
    /** The number invoice. */
    private long numberInvoice;
    
    /** The cost. */
    private BigDecimal cost;
    
    /** The order id. */
    private long orderId;

    /**
     * Instantiates a new invoice.
     */
    public Invoice() {
    }

    /**
     * Instantiates a new invoice.
     *
     * @param idInvoice the id invoice
     * @param numberInvoice the number invoice
     * @param cost the cost
     * @param orderId the order id
     */
    public Invoice(long idInvoice, long numberInvoice, BigDecimal cost, long orderId) {
        this.idInvoice = idInvoice;
        this.numberInvoice = numberInvoice;
        this.cost = cost;
        this.orderId = orderId;
    }

    /**
     * Gets the id invoice.
     *
     * @return the id invoice
     */
    public long getIdInvoice() {
        return idInvoice;
    }

    /**
     * Sets the id invoice.
     *
     * @param idInvoice the new id invoice
     */
    public void setIdInvoice(long idInvoice) {
        this.idInvoice = idInvoice;
    }

    /**
     * Gets the number invoice.
     *
     * @return the number invoice
     */
    public long getNumberInvoice() {
        return numberInvoice;
    }

    /**
     * Sets the number invoice.
     *
     * @param numberInvoice the new number invoice
     */
    public void setNumberInvoice(long numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    /**
     * Gets the cost.
     *
     * @return the cost
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Sets the cost.
     *
     * @param cost the new cost
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * Gets the order id.
     *
     * @return the order id
     */
    public long getOrderId() {
        return orderId;
    }

    /**
     * Sets the order id.
     *
     * @param orderId the new order id
     */
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = (int) (idInvoice ^ (idInvoice >>> 32));
        result = 31 * result + (int) (numberInvoice ^ (numberInvoice >>> 32));
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
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
