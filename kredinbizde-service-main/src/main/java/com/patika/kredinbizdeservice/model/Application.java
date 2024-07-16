package com.patika.kredinbizdeservice.model;


import com.patika.kredinbizdeservice.enums.ApplicationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Application {

    private int applicationId;
    private Loan loan;
    private CreditCard creditCard;
    private User user;
    private BigDecimal amount;
    private LocalDate localDate;
    private ApplicationStatus applicationStatus;

    private Application() {
    }


    public Application(int applicationId,CreditCard creditCard, User user,BigDecimal amount, LocalDate localDate) {
        this.applicationId = applicationId;
        this.creditCard = creditCard;
        this.user = user;
        this.amount = amount;
        this.localDate = localDate;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }

    public Application(int applicationId,Loan loan, User user,BigDecimal amount, LocalDate localDate) {
        this.applicationId = applicationId;
        this.loan = loan;
        this.user = user;
        this.amount = amount;
        this.localDate = localDate;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getLocalDateTime() {
        return localDate;
    }

    public void setLocalDateTime(LocalDate localDate) {
        this.localDate = localDate;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }



    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Application{" +
                "loan=" + loan +
                ", user=" + user +
                ", localDate=" + localDate +
                ", applicationStatus=" + applicationStatus +
                '}';
    }


    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
}
