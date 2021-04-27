package lahendused;

public class Transfer {
    private String accountFromNr;
    private String accountToNr;
    private double amount;

    public String getAccountFromNr() {
        return accountFromNr;
    }

    public void setAccountFromNr(String accountFromNr) {
        this.accountFromNr = accountFromNr;
    }

    public String getAccountToNr() {
        return accountToNr;
    }

    public void setAccountToNr(String accountToNr) {
        this.accountToNr = accountToNr;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
