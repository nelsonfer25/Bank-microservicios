package com.vobi.bank.service;

import com.vobi.bank.dto.CustomerDTO;

public interface CustomerService {
	
	CustomerDTO getCustomerDTOById(Integer id)throws Exception;
	
	CustomerDTO fallbackGetCustomerDTOById(Integer id,Throwable th)throws Exception;
	
}
