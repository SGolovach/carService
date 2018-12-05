package by.htp.carservice.entity;

public class Invoice {
    private long idInvoice;
    private long numberInvoice;
    private double cost;
    private long order_id;

    public Invoice() {
    }

    public Invoice(long idInvoice, long numberInvoice, double cost, long order_id) {
        this.idInvoice = idInvoice;
        this.numberInvoice = numberInvoice;
        this.cost = cost;
        this.order_id = order_id;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (idInvoice != invoice.idInvoice) return false;
        if (numberInvoice != invoice.numberInvoice) return false;
        if (Double.compare(invoice.cost, cost) != 0) return false;
        return order_id == invoice.order_id;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (idInvoice ^ (idInvoice >>> 32));
        result = 31 * result + (int) (numberInvoice ^ (numberInvoice >>> 32));
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (order_id ^ (order_id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "idInvoice=" + idInvoice +
                ", numberInvoice=" + numberInvoice +
                ", cost=" + cost +
                ", order_id=" + order_id +
                '}';
    }
}
