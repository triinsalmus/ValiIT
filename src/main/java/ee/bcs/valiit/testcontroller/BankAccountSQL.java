package ee.bcs.valiit.testcontroller;

import lahendused.BankAccountClass;
import lahendused.BankAccountClassRowMapper;
import lahendused.MoveMoney;
import lahendused.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankAccountSQL {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping("banksql/create") //ainult Post- ja PutMappinguga saab kasutada body
    public void create(@RequestBody BankAccountClass body) {
        String sql1 = "INSERT INTO bankaccount(name, accountnr, balance, lock) VALUES (:name,:accountnr, :balance, :lock)";
        Map<String, Object> createMap = new HashMap<>();
        createMap.put("name", body.getOwnerName());
        createMap.put("accountnr", body.getAccountNr());
        createMap.put("balance", body.getBalance());
        createMap.put("lock", body.isLocked());
        jdbcTemplate.update(sql1, createMap);
    }

    @GetMapping("banksql/check/{accountnr}") //GetMappinguga ei saa kasutada body
    public String checkBalance(@PathVariable("accountnr") String accountNr) {
        String sql2 = "SELECT balance FROM bankaccount WHERE accountnr=:dbaccountNr"; //teen sqli Stringi
        Map<String, Object> checkMap = new HashMap<>(); //teen uue mapi
        checkMap.put("dbaccountNr", accountNr); //panen uude mapi sqli tingimusele vastava väärtuse
        Double balance = jdbcTemplate.queryForObject(sql2, checkMap, Double.class); //leian balance'i sqlist vastavalt uuele mapile
        return "Balance is " + balance;
    }

    @PutMapping("banksql/deposit")
    public String deposit(@RequestBody MoveMoney body) {
        String getLock = "SELECT lock FROM bankaccount WHERE accountnr=:dbaccountnr";
        Map<String, Object> isLockedMap = new HashMap<>();
        isLockedMap.put("dbaccountnr", body.getAccountNr());
        Boolean isLocked = jdbcTemplate.queryForObject(getLock, isLockedMap, Boolean.class);
        if (isLocked) {
            return "The account is locked";
        } else if (body.getAmount() > 0) {
            String getBalance = "SELECT balance FROM bankaccount WHERE accountnr=:dbaccountnr"; //leian konto info
            Map<String, Object> getBalanceMap = new HashMap<>(); //loon uue mapi
            getBalanceMap.put("dbaccountnr", body.getAccountNr()); //panen mapi selle konto
            Double currentBalance = jdbcTemplate.queryForObject(getBalance, getBalanceMap, Double.class); //teen uue muutuja selle mapis asukoha SQLi

            String setBalance = "UPDATE bankaccount SET balance=:dbbalance WHERE accountnr=:dbaccountnr";
            Map<String, Object> setBalanceMap = new HashMap<>(); //teen veel ühe mapi
            setBalanceMap.put("dbaccountnr", body.getAccountNr()); //sean sama konto mapi
            double newBalance = body.getAmount() + currentBalance; //loon uue muutuja, mis on uus saldo (amount+enne leitud balance)
            setBalanceMap.put("dbbalance", newBalance); //panen mapi uus balance'i
            jdbcTemplate.update(setBalance, setBalanceMap); //uuendan SQLis sellel Stringil uue infoga selles mapis

            return "Your balance is now " + newBalance;
        } else {
            return "Try again";
        }
    }

    @PutMapping("banksql/withdraw")
    public String withdraw(@RequestBody MoveMoney body) {
        String getLock = "SELECT lock FROM bankaccount WHERE accountnr=:dbaccountnr";
        Map<String, Object> isLockedMap = new HashMap<>();
        isLockedMap.put("dbaccountnr", body.getAccountNr());
        Boolean isLocked = jdbcTemplate.queryForObject(getLock, isLockedMap, Boolean.class);
        if (isLocked) {
            return "The account is locked";
        } else if (body.getAmount() > 0) {
            String getBalance = "SELECT balance FROM bankaccount WHERE accountnr=:dbaccountnr";
            Map<String, Object> getBalanceMap = new HashMap<>();
            getBalanceMap.put("dbaccountnr", body.getAccountNr());
            Double currentBalance = jdbcTemplate.queryForObject(getBalance, getBalanceMap, Double.class);
            if (body.getAmount() <= (double) currentBalance) {
                String setBalance = "UPDATE bankaccount SET balance=:dbbalance WHERE accountnr=:dbaccountnr";
                Map<String, Object> setBalanceMap = new HashMap<>();
                setBalanceMap.put("dbaccountnr", body.getAccountNr());
                double newBalance = currentBalance - body.getAmount();
                setBalanceMap.put("dbbalance", newBalance);
                jdbcTemplate.update(setBalance, setBalanceMap);

                return "Your balance is now " + newBalance;
            } else {
                return "Not enough money on your bankaccount";
            }
        } else {
            return "Try again";
        }
    }

    @PutMapping("banksql/transfer")
    public String transfer(@RequestBody Transfer body) {
        String fromLock = "SELECT lock FROM bankaccount WHERE accountnr=:dbaccountnr";
        Map<String, Object> fromLockMap = new HashMap<>();
        fromLockMap.put("dbaccountnr", body.getAccountFromNr());
        Boolean isFromLocked = jdbcTemplate.queryForObject(fromLock, fromLockMap, Boolean.class);
        if (isFromLocked) {
            return "The fromAccount is locked";
        } else if (!isFromLocked) {
            String toLock = "SELECT lock FROM bankaccount WHERE accountnr=:dbaccountnr";
            Map<String, Object> toLockMap = new HashMap<>();
            toLockMap.put("dbaccountnr", body.getAccountToNr());
            Boolean isToLocked = jdbcTemplate.queryForObject(toLock, toLockMap, Boolean.class);
            if (isToLocked) {
                return "The toAccount is locked";
            } else if (body.getAmount() > 0) {
                String getBalance = "SELECT balance FROM bankaccount WHERE accountnr=:dbaccountfrom";
                Map<String, Object> getBalanceMap = new HashMap<>();
                getBalanceMap.put("dbaccountfrom", body.getAccountFromNr());
                Double currentBalance = jdbcTemplate.queryForObject(getBalance, getBalanceMap, Double.class);
                if (body.getAmount() <= (double) currentBalance) {
                    String setBalanceFrom = "UPDATE bankaccount SET balance=:dbbalancefrom WHERE accountnr=:dbaccountfrom";
                    Map<String, Object> setBalanceFromMap = new HashMap<>();
                    setBalanceFromMap.put("dbaccountfrom", body.getAccountFromNr());
                    double newBalanceFrom = currentBalance - body.getAmount();
                    setBalanceFromMap.put("dbbalancefrom", newBalanceFrom);
                    jdbcTemplate.update(setBalanceFrom, setBalanceFromMap);


                    String getBalanceTo = "SELECT balance FROM bankaccount WHERE accountnr=:dbaccountto";
                    Map<String, Object> getBalanceMapTo = new HashMap<>();
                    getBalanceMapTo.put("dbaccountto", body.getAccountToNr());
                    Double currentBalanceTo = jdbcTemplate.queryForObject(getBalanceTo, getBalanceMapTo, Double.class);

                    String setBalanceTo = "UPDATE bankaccount SET balance=:dbbalanceto WHERE accountnr=:dbaccountto";
                    Map<String, Object> setBalanceToMap = new HashMap<>();
                    setBalanceToMap.put("dbaccountto", body.getAccountToNr());
                    double newBalanceTo = body.getAmount() + currentBalanceTo;
                    setBalanceToMap.put("dbbalanceto", newBalanceTo);
                    jdbcTemplate.update(setBalanceTo, setBalanceToMap);

                    return "Your fromAccount balance is now " + newBalanceFrom;
                } else {
                    return "Not enough money on your bankaccount";
                }
            } else {
                return "Try again";
            }
        }
        return "";
    }

    @PutMapping("banksql/lock/{accountnr}") //siin pole body vaja, kuna veebileht ongi teenusena
    public String lock(@PathVariable("accountnr") String accountNr) {
        String lock = "SELECT lock FROM bankaccount WHERE accountnr=:dbaccountnr";
        Map<String, Object> lockMap = new HashMap<>();
        lockMap.put("dbaccountnr", accountNr);
        Boolean isLocked = jdbcTemplate.queryForObject(lock, lockMap, Boolean.class);

        if (!isLocked) {
            String setlock = "UPDATE bankaccount SET lock=:dblock WHERE accountnr=:dbaccountnr";
            Map<String, Object> setLockedMap = new HashMap<>();
            setLockedMap.put("dbaccountnr", accountNr);
            boolean toLock = true;
            setLockedMap.put("dblock", toLock);
            jdbcTemplate.update(setlock, setLockedMap);
            return "Your account is now locked";
        } else {
            return "Your account was already locked";
        }
    }

    @PutMapping("banksql/unlock/{accountnr}") //siin pole body vaja, kuna veebileht ongi teenusena
    public String unLock(@PathVariable("accountnr") String accountNr) {
        String unLock = "SELECT lock FROM bankaccount WHERE accountnr=:dbaccountnr";
        Map<String, Object> unLockMap = new HashMap<>();
        unLockMap.put("dbaccountnr", accountNr);
        Boolean isLocked = jdbcTemplate.queryForObject(unLock, unLockMap, Boolean.class);

        if (isLocked) {
            String setUnLock = "UPDATE bankaccount SET lock=:dblock WHERE accountnr=:dbaccountnr";
            Map<String, Object> setUnLockedMap = new HashMap<>();
            setUnLockedMap.put("dbaccountnr", accountNr);
            boolean isUnLocked = false;
            setUnLockedMap.put("dblock", isUnLocked);
            jdbcTemplate.update(setUnLock, setUnLockedMap);
            return "Your account is not locked anymore";
        } else {
            return "Your account wasn't locked";
        }
    }

    @GetMapping("banksql/list")
    public List<BankAccountClass> getAll() {
        String getAll = "SELECT * FROM bankaccount";
        return jdbcTemplate.query(getAll, new HashMap<>(), new BankAccountClassRowMapper());
    }
}
