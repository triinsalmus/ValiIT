package ee.bcs.valiit.testcontroller;

import ee.bcs.valiit.serviceMinu.BankAccountSQL2Serv;
import lahendused.BankAccountClass;
import lahendused.MoveMoney;
import lahendused.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@RestController
public class BankAccountSQL2 {

    Date date=new Date();
    Timestamp timestamp=new Timestamp(date.getTime());

    @Autowired
    private BankAccountSQL2Serv bankAccountSQL2Serv;

    @CrossOrigin //vajalik, et htmlis olev script töötaks ka mujalt kui localhost:8080-st
    @PostMapping("banksql2/create")
    public void create(@RequestBody BankAccountClass body) {
        bankAccountSQL2Serv.create(body);
    }

    @CrossOrigin
    @GetMapping("banksql2/check/{accountnr}") //GetMappinguga ei saa kasutada body
    public String checkBalance(@PathVariable("accountnr") String accountNr) {
        return bankAccountSQL2Serv.checkBalance(accountNr);
    }

    @CrossOrigin
    @PutMapping("banksql2/deposit")
    public String deposit(@RequestBody MoveMoney body) {
        return bankAccountSQL2Serv.deposit(body);
    }

    @CrossOrigin
    @PutMapping("banksql2/withdraw")
    public String withdraw(@RequestBody MoveMoney body) {
        return bankAccountSQL2Serv.withdraw(body);
    }

    @CrossOrigin
    @PutMapping("banksql2/transfer")
    public String transfer(@RequestBody Transfer body) {
        return bankAccountSQL2Serv.transfer(body);
    }

    @CrossOrigin
    @PutMapping("banksql2/lock/{accountnr}")
    public String lock(@PathVariable("accountnr") String accountNr) {
        return bankAccountSQL2Serv.lock(accountNr);
    }

    @CrossOrigin
    @PutMapping("banksql2/unlock/{accountnr}")
    public String unLock(@PathVariable("accountnr") String accountNr) {
        return bankAccountSQL2Serv.unLock(accountNr);
    }

    @CrossOrigin
    @GetMapping("banksql2/list")
    public List<BankAccountClass> getAll() {
        return bankAccountSQL2Serv.getAll();
    }
}

