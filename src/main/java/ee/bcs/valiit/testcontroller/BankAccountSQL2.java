package ee.bcs.valiit.testcontroller;

import ee.bcs.valiit.serviceMinu.BankAccountSQL2Serv;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lahendused.BankAccountClass;
import lahendused.LoginRequest;
import lahendused.MoveMoney;
//import lahendused.TransactionClass;
import lahendused.Transfer;
import liquibase.pro.packaged.D;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RequestMapping("/banksql2")
//@CrossOrigin //vajalik, et htmlis olev script töötaks ka mujalt kui localhost:8080-st, kui pole RequestMappingut classi kohal
@RestController
public class BankAccountSQL2 {

    LocalDateTime localDateTime = LocalDateTime.now();
//    Timestamp timestamp = new Timestamp(localDateTime);

    @Autowired
    private BankAccountSQL2Serv bankAccountSQL2Serv;

    @PostMapping("public/login") //login ja createnew eraldi teenused; login, kui on parool olemas
    public String login(@RequestBody LoginRequest body) {
        return bankAccountSQL2Serv.login(body);
    }

    @PostMapping("public/createuser")
    public void createUser(@RequestBody LoginRequest body) {
        bankAccountSQL2Serv.createUser(body);
    }

    @PostMapping("public/create")
    public void create(@RequestBody BankAccountClass body) {
        bankAccountSQL2Serv.create(body);
    }

    @GetMapping("public/check/{accountnr}") //GetMappinguga ei saa kasutada body
    public String checkBalance(@PathVariable("accountnr") String accountNr) {
        return bankAccountSQL2Serv.checkBalance(accountNr);
    }

    @PutMapping("public/deposit")
    public String deposit(@RequestBody MoveMoney body) {
        return bankAccountSQL2Serv.deposit(body);
    }

    @PutMapping("public/withdraw")
    public String withdraw(@RequestBody MoveMoney body) {
        return bankAccountSQL2Serv.withdraw(body);
    }

    @PutMapping("public/transfer")
    public String transfer(@RequestBody Transfer body) {
        return bankAccountSQL2Serv.transfer(body);
    }

    @PutMapping("/lock/{accountnr}") //nõuab eelnevat logini
    public String lock(@PathVariable("accountnr") String accountNr) {
        return bankAccountSQL2Serv.lock(accountNr);
    }

    @PutMapping("/unlock/{accountnr}") //nõuab eelnevat logini
    public String unLock(@PathVariable("accountnr") String accountNr) {
        return bankAccountSQL2Serv.unLock(accountNr);
    }

    @GetMapping("/list") //nõuab eelnevat logini
    public List<BankAccountClass> getAll() {
        return bankAccountSQL2Serv.getAll();
    }

//    @GetMapping("banksql2/history/{accountnr}")
//    public List<TransactionClass> getHistory(@PathVariable("accountnr") String accountNr) {
//        return bankAccountSQL2Serv.getHistory(accountNr);
//    }
}

