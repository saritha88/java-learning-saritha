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

@Document(name = "AdhaarCard")
public class AdhaarCard extends DocumentType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@NotNull
	@Name
	@ConsistencyCheck(matchClass = PanCard.class, matchField = "fullName")
	private String fullName;

	@NotNull
	private Long adhaarNo;
	@NotNull
	@Dob
	private LocalDate dob;
	@NotNull
	@Email
	private String email;
	@NotNull
	@PhoneNo
	private String phNo;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getAdhaarNo() {
		return adhaarNo;
	}

	public void setAdhaarNo(Long adhaarNo) {
		this.adhaarNo = adhaarNo;
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

	public AdhaarCard(String fullName, Long adhaarNo, LocalDate dob, String email, String phNo) {
		super();
		this.fullName = fullName;
		this.adhaarNo = adhaarNo;
		this.dob = dob;
		this.email = email;
		this.phNo = phNo;
	}

}
