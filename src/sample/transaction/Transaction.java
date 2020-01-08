package sample.transaction;

import sample.payment.Payment;

import java.util.Date;

public class Transaction {

    protected Payment payment;
     protected Date TransactionDate;
     protected String PayeeFirstName ;
     protected String PayeeLastName ;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }

    public String getPayeeFirstName() {
        return PayeeFirstName;
    }

    public void setPayeeFirstName(String payeeFirstName) {
        PayeeFirstName = payeeFirstName;
    }

    public String getPayeeLastName() {
        return PayeeLastName;
    }

    public void setPayeeLastName(String payeeLastName) {
        PayeeLastName = payeeLastName;
    }
}
