package ee.bcs.valiit.solution.repository;

import ee.bcs.valiit.solution.controller.SampleAccount2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SampleAccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNr, Double balance) {
        String sql = "INSERT INTO account(account_number, balance) VALUES(:dbAccNo, :dbAmount)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        paramMap.put("dbAmount", balance);
        jdbcTemplate.update(sql, paramMap);
    }

    public Double getBalance(String accountNr){
        String sql = "SELECT balance FROM account WHERE account_number = :dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, Double.class);
    }

    public List<SampleAccount2> getAllAccounts(){
        String sql = "SELECT * FROM account";
        return jdbcTemplate.query(sql, new HashMap(), new SampleAccount2RowMapper());
    }
}
