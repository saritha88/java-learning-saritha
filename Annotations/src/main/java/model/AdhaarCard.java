package model;

import java.io.Serializable;
import java.util.Date;
import annotations.ConsistencyCheck;
import annotations.Dob;
import annotations.Document;
import annotations.Email;
import annotations.NotNull;
import annotations.PhoneNo;

@Document(name = "AdhaarCard")
@ConsistencyCheck(baseField = "fullName", matchClass = PanCard.class, matchField = "fullName")
public class AdhaarCard implements Serializable, DocumentType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private String fullName;

	@NotNull
	private Long adhaarNo;
	@Dob
	private Date dob;
	@Email
	private String email;
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

	public AdhaarCard(String fullName, Long adhaarNo, Date dob, String email, String phNo) {
		super();
		this.fullName = fullName;
		this.adhaarNo = adhaarNo;
		this.dob = dob;
		this.email = email;
		this.phNo = phNo;
	}

}
