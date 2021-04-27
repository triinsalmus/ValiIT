package ee.bcs.valiit.hibernate;

import javax.persistence.*;

@Table(name = "bankaccount")
@Entity
public class BankAccount {

//    @Id //ID käib alati koos GeneratedValuega, kui on tabelis ID, mis igal real erinev
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // käib koos IDga ja suurendab iga kord peatingimust
    private String name;
    @Id
    private String accountnr;
    private Double balance;
    private Boolean lock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountnr() {
        return accountnr;
    }

    public void setAccountnr(String accountnr) {
        this.accountnr = accountnr;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }
}
