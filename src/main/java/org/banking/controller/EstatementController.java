/**
 * 
 */
package org.banking.controller;

import java.time.LocalDate;
import java.util.List;

import org.banking.account.entity.AccountHistory;
import org.banking.account.service.EStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ObulSubbaReddy Bhojja
 *
 */
@RestController
public class EstatementController {

	@Autowired
	private EStatementService eStatementService;

	@GetMapping(path = "/estatement")
	public ResponseEntity<List<AccountHistory>> generateEstatement(Pageable pageable,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {

		return new ResponseEntity<List<AccountHistory>>(
				(List<AccountHistory>) eStatementService.generateEstatement(pageable, fromDate, toDate), HttpStatus.OK);
	}

}
