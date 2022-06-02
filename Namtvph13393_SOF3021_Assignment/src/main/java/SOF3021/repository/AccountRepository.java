package SOF3021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import SOF3021.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	@Query(name = "Account.findByUsername")
	public Account findByUsername(@Param("username") String username);
	
}
