package sample.payment;

public class Payment {

    protected int Amount;
    protected String currencyType ;
   protected String PayerFirstName;
   protected String  PayerLastName ;
   protected String  PayerID;

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getPayerFirstName() {
        return PayerFirstName;
    }

    public void setPayerFirstName(String payerFirstName) {
        PayerFirstName = payerFirstName;
    }

    public String getPayerLastName() {
        return PayerLastName;
    }

    public void setPayerLastName(String payerLastName) {
        PayerLastName = payerLastName;
    }

    public String getPayerID() {
        return PayerID;
    }

    public void setPayerID(String payerID) {
        PayerID = payerID;
    }
}
