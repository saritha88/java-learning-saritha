package model;

import java.io.Serializable;
import java.util.Date;

import annotations.ConsistencyCheck;
import annotations.Dob;
import annotations.Document;
import annotations.NotNull;
import annotations.PhoneNo;

@Document(name = "PAN")
@ConsistencyCheck(baseField = "fullName", matchClass = BankStatement.class, matchField = "fullName")

public class PanCard implements Serializable, DocumentType {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private String fullName;
	@NotNull
	private String number;
	@Dob
	private Date dob;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDob() {
		return dob;
	}

	public PanCard(String fullName, String number, Date dob) {
		super();
		this.fullName = fullName;
		this.number = number;
		this.dob = dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
