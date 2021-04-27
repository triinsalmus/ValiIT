package ee.bcs.valiit.testcontroller;

import lahendused.BankAccountClass;
//import lahendused.DepositBody;
import lahendused.MoveMoney;
import lahendused.Transfer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankAccount {

    private static Map<String, BankAccountClass> bankMap = new HashMap<>();

    @PostMapping("bank/create") //ainult Post- ja PutMappinguga saab kasutada body
    public void create(@RequestBody BankAccountClass body) {
        bankMap.put(body.getAccountNr(), body);
    }

    @GetMapping("bank/check/{accountnr}") //GetMappinguga ei saa kasutada body
    public String checkBalance(@PathVariable("accountnr") String accountNr) {
        double balance = bankMap.get(accountNr).getBalance();
        return "Balance is " + balance;
    }

    @PutMapping("bank/deposit")
    // iga tegevuse jaoks uus class, et kasutaja ei kirjutaks alusclassi üle
    public String deposit(@RequestBody MoveMoney body) {
        if (body.getAmount() > 0) { //kuidas kontrollida, kas on lukus?
            double newBalance = bankMap.get(body.getAccountNr()).getBalance() + body.getAmount(); //tekitan double väärtuse ehk uue balance'i
            BankAccountClass balance = bankMap.get(body.getAccountNr()); //loon põhiclassist uue objekti , mis on see konto
            balance.setBalance(newBalance); //panen classi ka uue balance'i
            bankMap.put(body.getAccountNr(), balance); //seab mapi uue balance'i
            return "Your balance is now " + newBalance;
        } else {
            return "Try again";
        }
    }

    @PutMapping("bank/withdraw")
    public String withdraw(@RequestBody MoveMoney body) {
        if (body.getAmount() > 0 && body.getAmount() <= bankMap.get(body.getAccountNr()).getBalance()) { //kuidas kontrollida, kas on lukus?
            double newBalance = bankMap.get(body.getAccountNr()).getBalance() - body.getAmount();
            BankAccountClass balance = bankMap.get(body.getAccountNr()); //võtan selle objekti, mis classis on
            balance.setBalance(newBalance); //panen sellele objektile classis uue saldo
            bankMap.put(body.getAccountNr(), balance); //salvestab uue balance'i mapi
            return "Your balance is now " + newBalance;
        } else {
            return "Try again";
        }
    }

    @PutMapping("bank/transfer")
    public String transfer(@RequestBody Transfer body) {
        if (body.getAmount() > 0 && body.getAmount() <= bankMap.get(body.getAccountFromNr()).getBalance()) {
            double newBalanceFrom = bankMap.get(body.getAccountFromNr()).getBalance() - body.getAmount();
            BankAccountClass balanceFrom = bankMap.get(body.getAccountFromNr());
            balanceFrom.setBalance(newBalanceFrom); //liigun läbi classi mappi
            bankMap.put(body.getAccountFromNr(), balanceFrom);

            double newBalanceTo = bankMap.get(body.getAccountToNr()).getBalance() + body.getAmount();
            BankAccountClass balanceTo = bankMap.get(body.getAccountToNr());
            balanceTo.setBalance(newBalanceTo);
            bankMap.put(body.getAccountToNr(), balanceTo); //salvestab uue balance'i mapi
            return "Your fromAccount balance is now " + newBalanceFrom;
        } else {
            return "Try again";
        }
    }

    @PutMapping("bank/lock/{accountnr}") //siin pole body vaja, kuna veebileht ongi teenusena
    public String lock(@PathVariable("accountnr") String accountNr) {
        BankAccountClass lock = bankMap.get(accountNr);
        lock.setLocked(true);
        bankMap.put(accountNr, lock);
        return "Your account is now locked";
    }

    @PutMapping("bank/unlock/{accountnr}") //siin pole body vaja, kuna veebileht ongi teenusena
    public String unLock(@PathVariable("accountnr") String accountNr) {
        BankAccountClass unlock = bankMap.get(accountNr);
        unlock.setLocked(false);
        bankMap.put(accountNr, unlock);
        return "Your account is not locked anymore";
    }

    /**
     * tee getAll ka
     */
}
