package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import annotations.ConsistencyCheck;
import annotations.Dob;
import annotations.Document;
import annotations.Email;
import annotations.Name;
import annotations.NotNull;
import annotations.PhoneNo;

@Document(name="BankStatement")
public class BankStatement extends DocumentType implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Name
	@ConsistencyCheck(matchClass=AdhaarCard.class,matchField="fullName")
	private String fullName;
	@NotNull
	private Long accNo;
	@NotNull
	@Dob
	private LocalDate dob;
	@NotNull
	@Email
	private String email;
	@NotNull
	@PhoneNo
	private String phNo;
	

	public BankStatement(String fullName, Long accNo, LocalDate dob, String email, String phNo) {
		super();
		this.fullName = fullName;
		this.accNo = accNo;
		this.phNo = phNo;
		this.dob = dob;
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getAccNo() {
		return accNo;
	}

	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

}
