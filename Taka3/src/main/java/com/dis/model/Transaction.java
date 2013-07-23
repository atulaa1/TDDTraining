package com.dis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * User: dungpx
 * Date: 6/27/13
 * Time: 1:32 PM
 */
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column
    private Long id;

    @Column(name = "account_number", length = 255)
    private String accountNumber;

    @Column(length = 1000)
    private String description;

    @Column
    private Long amount;

    @Column
    private Date timeExecute;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getTimeExecute() {
        return timeExecute;
    }

    public void setTimeExecute(Date timeExecute) {
        this.timeExecute = timeExecute;
    }
}
