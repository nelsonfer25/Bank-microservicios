package com.vobi.bank.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String accoId;

	@NotNull
	private Integer custId;

	@NotNull
	private Double balance;

	@NotNull
	private String enable;

	@NotNull
	private String password;
	
	@NotNull
	private Long version;
	
	private CustomerDTO customer;

}