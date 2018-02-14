package model;

import java.io.Serializable;
import java.util.Date;

import annotations.ConsistencyCheck;
import annotations.Dob;
import annotations.Document;
import annotations.Email;
import annotations.NotNull;
import annotations.PhoneNo;

@Document(name="BankStatement")
@ConsistencyCheck(baseField="fullName", matchClass=AdhaarCard.class,matchField="fullName")

public class BankStatement implements Serializable,DocumentType {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private String fullName;
	@NotNull
	private Long accNo;
	@Dob
	private Date dob;
	@Email
	private String email;
	@PhoneNo
	private String phNo;
	

	public BankStatement(String fullName, Long accNo, Date dob, String email, String phNo) {
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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
