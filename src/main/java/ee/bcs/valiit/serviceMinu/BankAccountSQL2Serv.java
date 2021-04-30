package ee.bcs.valiit.serviceMinu;

//import ee.bcs.valiit.exceptionMinu.BankAccountSQLException;

import ee.bcs.valiit.exceptionMinu.BankAccountSQLException;
import ee.bcs.valiit.repositoryMinu.BankAccountSQL2Repo;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lahendused.BankAccountClass;
import lahendused.LoginRequest;
import lahendused.MoveMoney;
//import lahendused.TransactionClass;
import lahendused.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class BankAccountSQL2Serv {

    LocalDateTime localDateTime = LocalDateTime.now();
//    Date date = new Date();
//    Timestamp timestamp = new Timestamp(date.getTime());

    @Autowired
    private BankAccountSQL2Repo bankAccountSQL2Repo;

    public void createUser(LoginRequest body) {
        try {
            if (body.getUsername() != null && body.getPassword() != null) {
                bankAccountSQL2Repo.createUser(body);
            }
        } catch (Exception exception) {
            throw new BankAccountSQLException("This user already exists");
        }
    }

    public String login(LoginRequest body) {
        try {
        if (bankAccountSQL2Repo.isUser(body.getUsername()) != null &&
                bankAccountSQL2Repo.returnPassword(body.getUsername()).equals(body.getPassword())) {
            Date today = new Date();
            Date tokenExpirationDate = new Date(today.getTime() + 1000 * 60 * 60 * 24);
            JwtBuilder jwtBuilder = Jwts.builder()
                    .setExpiration(tokenExpirationDate)
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "c2vjcmV0") //password on Base64 encode-st läbi lastud; kasutame vaid logini genereerimiseks
                    .claim("username", body.getUsername());
            return jwtBuilder.compact();
        } else {
            return "Try again";
        }
        } catch (Exception exception) {
            throw new BankAccountSQLException("This user doesn't exist");
        }
    }

    public void create(BankAccountClass body) {
        if (body.getBalance() < 0) {
            throw new BankAccountSQLException("Negative balance is not allowed");
        }
        bankAccountSQL2Repo.create(body);
    }

    public String checkBalance(String accountNr) {
        try {
            return "Balance is " + bankAccountSQL2Repo.getBalance(accountNr);
        } catch (Exception exception) {
            throw new BankAccountSQLException("This account doesn't exist");
        }
    }

    public String deposit(MoveMoney body) {
        try {
            if (bankAccountSQL2Repo.isLocked(body.getAccountNr())) {
                return "The account is locked";
            } else if (body.getAmount() > 0) {
                double newBalance = body.getAmount() + bankAccountSQL2Repo.getBalance(body.getAccountNr());
                bankAccountSQL2Repo.updateBalance(body.getAccountNr(), newBalance);
                bankAccountSQL2Repo.updateTime(body.getAccountNr(), body.getAmount(), localDateTime);
                return "Your balance is now " + newBalance;
            } else {
                return "Try again";
            }
        } catch (Exception exception) {
            throw new BankAccountSQLException("This account doesn't exist");
        }
    }

    public String withdraw(MoveMoney body) {
        try {
            if (bankAccountSQL2Repo.isLocked(body.getAccountNr())) {
                return "The account is locked";
            } else if (body.getAmount() > 0) {
                if (body.getAmount() <= bankAccountSQL2Repo.getBalance(body.getAccountNr())) {
                    double newBalance = bankAccountSQL2Repo.getBalance(body.getAccountNr()) - body.getAmount();
                    bankAccountSQL2Repo.updateBalance(body.getAccountNr(), newBalance);
                    bankAccountSQL2Repo.updateTime(body.getAccountNr(), body.getAmount(), localDateTime);
                    return "Your balance is now " + newBalance;
                } else {
                    return "Not enough money on your bankaccount";
                }
            } else {
                return "Try again";
            }
        } catch (Exception exception) {
            throw new BankAccountSQLException("This account doesn't exist");
        }
    }

    public String transfer(Transfer body) {
        try {
            if (bankAccountSQL2Repo.isLocked(body.getAccountFromNr())) {
                return "The fromAccount is locked";
            } else if (!bankAccountSQL2Repo.isLocked(body.getAccountFromNr())) {
                if (bankAccountSQL2Repo.isLocked(body.getAccountToNr())) {
                    return "The toAccount is locked";
                } else if (body.getAmount() > 0) {
                    if (body.getAmount() <= bankAccountSQL2Repo.getBalance(body.getAccountFromNr())) {
                        double newBalanceFrom = bankAccountSQL2Repo.getBalance(body.getAccountFromNr()) - body.getAmount();
                        bankAccountSQL2Repo.updateBalance(body.getAccountFromNr(), newBalanceFrom);
                        bankAccountSQL2Repo.updateTime(body.getAccountFromNr(), body.getAmount(), localDateTime);

                        double newBalanceTo = bankAccountSQL2Repo.getBalance(body.getAccountToNr()) + body.getAmount();
                        bankAccountSQL2Repo.updateBalance(body.getAccountToNr(), newBalanceTo);
                        bankAccountSQL2Repo.updateTime(body.getAccountToNr(), body.getAmount(), localDateTime);

                        return "Your balance is now " + newBalanceFrom;
                    } else {
                        return "Not enough money on your bankaccount";
                    }
                } else {
                    return "Try again";
                }
            }
        } catch (Exception exception) {
            throw new BankAccountSQLException("This account doesn't exist");
        }
        return "";
    }

    public String lock(String accountnr) {
        try {
            if (!bankAccountSQL2Repo.isLocked(accountnr)) {
                bankAccountSQL2Repo.lock(accountnr, true);
                return "Your account is now locked";
            } else {
                return "Your account was already locked";
            }
        } catch (Exception exception) {
            throw new BankAccountSQLException("This account doesn't exist");
        }
    }

    public String unLock(String accountnr) {
        try {
            if (bankAccountSQL2Repo.isLocked(accountnr)) {
                bankAccountSQL2Repo.lock(accountnr, false);
                return "Your account is not locked anymore";
            } else {
                return "Your account wasn't locked";
            }
        } catch (Exception exception) {
            throw new BankAccountSQLException("This account doesn't exist");
        }
    }

    public List<BankAccountClass> getAll() {
        return bankAccountSQL2Repo.getAll();
    }

//    public List<TransactionClass> getHistory(String accountNr) {
//        return bankAccountSQL2Repo.getHistory(accountNr);
//    }
}
