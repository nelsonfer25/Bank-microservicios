package com.vobi.bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vobi.bank.domain.Account;
import com.vobi.bank.dto.AccountDTO;
import com.vobi.bank.dto.CustomerDTO;
import com.vobi.bank.feignclient.CustomerFeignClient;
import com.vobi.bank.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Override
	@Transactional(readOnly = true)
	public Optional<AccountDTO> findById(String id) throws Exception {
		if(accountRepository.findById(id).isPresent()==false) {
			return Optional.empty();
		}
		
		Account account = accountRepository.findById(id).get();
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccoId(account.getAccoId());
		accountDTO.setBalance(account.getBalance());
		accountDTO.setCustId(account.getCustId());
		accountDTO.setEnable(account.getEnable());
		accountDTO.setPassword(account.getPassword());
		accountDTO.setVersion(account.getVersion());
		
		//TODO Consultar Customer
		CustomerDTO customerDTO = customerService.getCustomerDTOById(account.getCustId());
		accountDTO.setCustomer(customerDTO);
		
		return Optional.of(accountDTO);
	}

}
