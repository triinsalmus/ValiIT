package lahendused;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountClassRowMapper implements RowMapper<BankAccountClass> {

    @Override
    public BankAccountClass mapRow(ResultSet resultSet, int i) throws SQLException {
        BankAccountClass response = new BankAccountClass();
        response.setOwnerName(resultSet.getString("name"));
        response.setAccountNr(resultSet.getString("accountnr"));
        response.setBalance(resultSet.getDouble("balance"));
        response.setLocked(resultSet.getBoolean("lock"));
        return response;
    }

}
