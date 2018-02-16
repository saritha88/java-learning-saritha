package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import annotations.ConsistencyCheck;
import annotations.Dob;
import annotations.Document;
import annotations.Name;
import annotations.NotNull;
import annotations.PhoneNo;

@Document(name = "PAN")
public class PanCard extends DocumentType implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Name
	@ConsistencyCheck(matchClass = BankStatement.class, matchField = "fullName")
	private String fullName;
	
	@NotNull
	private String number;
	@NotNull
	@Dob
	private LocalDate dob;

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

	public LocalDate getDob() {
		return dob;
	}

	public PanCard(String fullName, String number, LocalDate dob) {
		super();
		this.fullName = fullName;
		this.number = number;
		this.dob = dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
