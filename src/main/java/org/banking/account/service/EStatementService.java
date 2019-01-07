/**
 * 
 */
package org.banking.account.service;

import java.time.LocalDate;
import java.util.List;

import org.banking.account.entity.AccountHistory;
import org.springframework.data.domain.Pageable;

/**
 * @author ObulSubbaReddy Bhojja
 *
 */
public interface EStatementService {

	List<AccountHistory> generateEstatement(Pageable pageable, LocalDate fromDate, LocalDate toDate);


}
