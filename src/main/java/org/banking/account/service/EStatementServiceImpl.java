/**
 * 
 */
package org.banking.account.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.banking.account.entity.AccountHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author ObulSubbaReddy Bhojja
 *
 */
@Service
public class EStatementServiceImpl implements EStatementService {

	@Autowired
	private EStatementRepository eStatementRepository;

	/**
	 * @return the eStatementRepository
	 */
	public EStatementRepository getAccountRepository() {
		return eStatementRepository;
	}

	/**
	 * @param eStatementRepository
	 *            the eStatementRepository to set
	 */
	public void setAccountRepository(EStatementRepository accountRepository) {
		this.eStatementRepository = accountRepository;
	}

	@Override
	public List<AccountHistory> generateEstatement(Pageable pageable, LocalDate fromDate, LocalDate toDate) {
		return eStatementRepository.findAll(pageable)
			.getContent()
			.stream()
			.filter(e -> e.getDate().compareTo(LocalTime.MIN.atDate(fromDate)) >= 0)
			.filter(e -> e.getDate().compareTo(LocalTime.MAX.atDate(toDate)) <= 0)
			.collect(Collectors.toList());
	}

}
