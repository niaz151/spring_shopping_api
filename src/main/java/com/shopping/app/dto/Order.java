package com.shopping.app.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

    int id;
    int customer_id;
    String payment_type;
    LocalDateTime date_time;
    String status;
    BigDecimal total;

    public Order(int id, int customer_id, String payment_type, LocalDateTime date_time, String status, BigDecimal total) {
        this.id = id;
        this.customer_id = customer_id;
        this.payment_type = payment_type;
        this.date_time = date_time;
        this.status = status;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


}
