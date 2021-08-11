package com.credera.customer.dto;

public class CreateCustomerRequest {
    private String name;
    private Integer initialBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Integer initialBalance) {
        this.initialBalance = initialBalance;
    }

    @Override
    public String toString() {
        return "CreateCustomerRequest{" +
                "name='" + name + '\'' +
                ", initialBalance=" + initialBalance +
                '}';
    }
}
