package ee.bcs.valiit.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountHibernateRepo extends JpaRepository<BankAccount, String> {
}
