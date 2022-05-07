package com.vobi.bank.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vobi.bank.dto.CustomerDTO;
import com.vobi.bank.feignclient.CustomerFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	long count = 1;
	
	@Autowired
	CustomerFeignClient customerFeignClient;

	@Override
	@CircuitBreaker(name = "customerService", fallbackMethod = "fallbackGetCustomerDTOById")
	
	public CustomerDTO getCustomerDTOById(Integer id)throws Exception {
		log.info("Count:" +count);
		count++;
		return customerFeignClient.findById(id);
	}

	@Override
	public CustomerDTO fallbackGetCustomerDTOById(Integer id, Throwable th)throws Exception {
		log.error("Error:"+th);
		return new CustomerDTO();
	}

}
