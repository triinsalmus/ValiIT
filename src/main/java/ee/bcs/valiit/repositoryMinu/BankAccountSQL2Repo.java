package ee.bcs.valiit.repositoryMinu;

import lahendused.BankAccountClass;
import lahendused.BankAccountClassRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BankAccountSQL2Repo {

    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void create(BankAccountClass body) {
        String sql1 = "INSERT INTO bankaccount(name, accountnr, balance, lock) VALUES (:name,:accountnr, :balance, :lock)";
        Map<String, Object> createMap = new HashMap<>();
        createMap.put("name", body.getOwnerName());
        createMap.put("accountnr", body.getAccountNr());
        createMap.put("balance", body.getBalance());
        createMap.put("lock", body.isLocked());
        jdbcTemplate.update(sql1, createMap);
    }

    public Boolean isLocked(String accountnr) {
        String getLock = "SELECT lock FROM bankaccount WHERE accountnr=:dbaccountnr";
        Map<String, Object> isLockedMap = new HashMap<>();
        isLockedMap.put("dbaccountnr", accountnr);
        Boolean isLocked = jdbcTemplate.queryForObject(getLock, isLockedMap, Boolean.class);
        return isLocked;
    }

    public Double getBalance(String accountnr) {
        String getBalance = "SELECT balance FROM bankaccount WHERE accountnr=:dbaccountnr";
        Map<String, Object> getBalanceMap = new HashMap<>();
        getBalanceMap.put("dbaccountnr", accountnr);
        Double currentBalance = jdbcTemplate.queryForObject(getBalance, getBalanceMap, Double.class);
        return currentBalance;
    }

    public void updateBalance(String accountnr, Double newBalance) {
        String setBalance = "UPDATE bankaccount SET balance=:dbbalance WHERE accountnr=:dbaccountnr";
        Map<String, Object> setBalanceMap = new HashMap<>();
        setBalanceMap.put("dbaccountnr", accountnr);
        setBalanceMap.put("dbbalance", newBalance);
        jdbcTemplate.update(setBalance, setBalanceMap);
    }

    public void lock(String accountnr, boolean toLock) {
        String setlock = "UPDATE bankaccount SET lock=:dblock WHERE accountnr=:dbaccountnr";
        Map<String, Object> setLockedMap = new HashMap<>();
        setLockedMap.put("dbaccountnr", accountnr);
        setLockedMap.put("dblock", toLock);
        jdbcTemplate.update(setlock, setLockedMap);
    }

    public List<BankAccountClass> getAll() {
        String getAll = "SELECT * FROM bankaccount";
        return jdbcTemplate.query(getAll, new HashMap<>(), new BankAccountClassRowMapper());
    }

    public String getAccountNr(String accountnr) {
        String getAccount = "SELECT accountnr FROM bankaccount WHERE accountnr=:dbaccountnr";
        Map<String, Object> getAccountMap = new HashMap<>();
        getAccountMap.put("dbaccountnr", accountnr);
        String getAccountNr = jdbcTemplate.queryForObject(getAccount, getAccountMap, String.class);
        return getAccountNr;
    }

    public void updateTime(String accountnr, Double amount, Timestamp timestamp) {
        String updateTime = "INSERT INTO transfer_history(accountnr, amount, date) VALUES (:dbaccountnr,:dbamount, :dbdate)";
        Map<String, Object> updateTimeMap = new HashMap<>();
        updateTimeMap.put("dbaccountnr", accountnr);
        updateTimeMap.put("dbamount", amount);
        updateTimeMap.put("dbdate", timestamp);
        jdbcTemplate.update(updateTime, updateTimeMap);
    }


}
