package com.dis.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/18/13
 * Time: 1:47 PM
 */
@Entity
@Table(name = "account")
public class BankAccount {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "account_number",length = 255)
    private String accountNumber;

    @Column(name = "balance")
    private Long balance;
    @Column(name = "open_date")
    private Date openTime;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }
}
