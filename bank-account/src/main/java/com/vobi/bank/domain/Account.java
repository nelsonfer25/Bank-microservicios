package com.vobi.bank.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */
@Entity
@Table(name = "account", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "acco_id", unique = true, nullable = false)
	private String accoId;

	@Column(name = "cust_id", unique = true, nullable = false)
	@NotNull
	private Integer custId;

	@Column(name = "balance", nullable = false)
	private Double balance;

	@Column(name = "enable", nullable = false)
	private String enable;

	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "version", nullable = true)
	private Long version;

	
}