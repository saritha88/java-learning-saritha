package model;

import java.io.Serializable;
import java.time.LocalDate;
import annotations.ConsistencyCheck;
import annotations.CustomField;
import annotations.Dob;
import annotations.Document;
import annotations.NotNull;

@Document(name="BankStatement")
public class BankStatement extends DocumentType implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Value cannot be null")
	@CustomField(value = "[a-zA-Z]{8,20}",message="Name should be alteast 8 characters")
	@ConsistencyCheck(matchClass=AdhaarCard.class,matchField="fullName")
	private String fullName;
	@NotNull(message = "Value cannot be null")
	private Long accNo;
	@NotNull(message = "Value cannot be null")
	@Dob
	private LocalDate dob;
	@NotNull(message = "Value cannot be null")
	@CustomField(value = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",message="Invalid email")
	private String email;
	@NotNull(message = "Value cannot be null")
	@CustomField(value = "(^$|[0-9]{10})",message="Phone no should be 10 digits")
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
