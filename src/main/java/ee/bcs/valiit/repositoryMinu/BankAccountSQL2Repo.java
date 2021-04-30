package ee.bcs.valiit.repositoryMinu;

import lahendused.BankAccountClass;
import lahendused.BankAccountClassRowMapper;
//import lahendused.TransactionClass;
import lahendused.LoginRequest;
import liquibase.pro.packaged.O;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BankAccountSQL2Repo {

    LocalDateTime localDateTime = LocalDateTime.now();
//    Date date = new Date();
//    Timestamp timestamp = new Timestamp(date.getTime());

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createUser(LoginRequest body) {
        String userSQL = "INSERT INTO user_info(username, password) VALUES (:username,:password)";
        Map<String, Object> createUserMap = new HashMap<>();
        createUserMap.put("username", body.getUsername());
        createUserMap.put("password", body.getPassword());
        jdbcTemplate.update(userSQL, createUserMap);
    }

    public String isUser(String username) {
        String userSQL = "SELECT username FROM user_info WHERE username=:dbusername";
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("dbusername", username);
        String isUser = jdbcTemplate.queryForObject(userSQL, userMap, String.class);
        return isUser;
    }

    public String returnPassword(String username) {
        String passwSQL = "SELECT password FROM user_info WHERE username=:dbusername";
        Map<String, Object> returnUserMap = new HashMap<>();
        returnUserMap.put("dbusername", username);
        String getPassword = jdbcTemplate.queryForObject(passwSQL, returnUserMap, String.class);
        return getPassword;
    }

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

//    public List<TransactionClass> getHistory(String accountNr) {
//        String getHistory="SELECT * FROM transfer_history WHERE accountnr=:dbaccountnr";
//        return jdbcTemplate.query(getHistory,new HashMap<>(),new TransactionHistoryRepo(accountNr));
//    }

//    public String getAccountNr(String accountnr) {
//        String getAccount = "SELECT accountnr FROM bankaccount WHERE accountnr=:dbaccountnr";
//        Map<String, Object> getAccountMap = new HashMap<>();
//        getAccountMap.put("dbaccountnr", accountnr);
//        String getAccountNr = jdbcTemplate.queryForObject(getAccount, getAccountMap, String.class);
//        return getAccountNr;
//    }

    public void updateTime(String accountnr, Double amount, LocalDateTime localDateTime) {
        String updateTime = "INSERT INTO transfer_history(accountnr, amount, date) VALUES (:dbaccountnr,:dbamount, :dbdate)";
        Map<String, Object> updateTimeMap = new HashMap<>();
        updateTimeMap.put("dbaccountnr", accountnr);
        updateTimeMap.put("dbamount", amount);
        updateTimeMap.put("dbdate", localDateTime);
        jdbcTemplate.update(updateTime, updateTimeMap);
    }


}
