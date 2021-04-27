package ee.bcs.valiit.testcontroller;

import lahendused.Lesson4Class;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4Controller {

    private static Map<String, Double> accountBalanceMap = new HashMap<>(); //tühi map, mille taga on class

    /**
     * tee ka bodyga versioon, praegu body tühine
     */

    @PostMapping("bankaccount/addnew")
    public void createAccount(@RequestBody Lesson4Class body) { //kuna kasutame body, siis muud sisendit pole vaja, saame sealt classist
        accountBalanceMap.put(body.getAccountNr(), body.getBalance());
        //http://localhost:8080/bankaccount/addnew
    }

    @GetMapping("bankaccount/balance/{getbalance}")
    public String getBalance(@PathVariable("getbalance") String accountNr) {
        return "Your account balance is: " + accountBalanceMap.get(accountNr);
        //http://localhost:8080/bankaccount/balance/EE123
    }

    @PutMapping("bankaccount/deposit/{accountnr}/{amount}") //kui on body, siis bodysse panna ka amount - peab olema uus body
    public String deposit(@RequestBody Lesson4Class body,
                          @PathVariable("accountnr") String accountNr,
                          @PathVariable("amount") double amount) { //miks mul on siin üldse body vaja?
        if (amount > 0) {
            double newBalance = accountBalanceMap.get(accountNr) + amount;
            accountBalanceMap.put(accountNr, newBalance);
            return "Your account balance is now " + newBalance;
        } else {
            return "Try again";
        }
    }

    @PutMapping("bankaccount/withdraw/{accountnr}/{amount}") //kui on body, siis bodysse panna ka amount
    public String withdraw(@RequestBody Lesson4Class body,
                           @PathVariable("accountnr") String accountNr,
                           @PathVariable("amount") double amount) { //miks mul on siin üldse body vaja?
        if (amount > 0 && amount <= accountBalanceMap.get(accountNr)) {
            double newBalance = accountBalanceMap.get(accountNr) - amount;
            accountBalanceMap.put(accountNr, newBalance);
            return "Your account balance is now " + newBalance;
        } else {
            return "Try again";
        }
    }

    @PutMapping("bankaccount/transfer/{transferfrom}/{amount}/{transferto}")
    public String transfer(@PathVariable("transferfrom") String accountFrom,
                           @PathVariable("amount") double amount,
                           @PathVariable("transferto") String accountTo) {
        if (amount > 0 && amount <= accountBalanceMap.get(accountFrom)) {
            double newFromBalance = accountBalanceMap.get(accountFrom) - amount;
            double newToBalance = accountBalanceMap.get(accountTo) + amount;
            accountBalanceMap.put(accountFrom, newFromBalance);
            accountBalanceMap.put(accountTo, newToBalance);
            return "Your fromAccount balance is now " + newFromBalance +
                    " and your toAccount balance is now " + newToBalance;
        } else {
            return "Try again";
        }
        //http://localhost:8080/bankaccount/transfer/EE123/10/EE321
    }
}