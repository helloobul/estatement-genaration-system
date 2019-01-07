package org.banking.account.service;

import org.banking.account.entity.AccountHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EStatementRepository extends JpaRepository<AccountHistory, Long>{

}
