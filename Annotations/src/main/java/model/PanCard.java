package model;

import java.io.Serializable;
import java.time.LocalDate;
import annotations.ConsistencyCheck;
import annotations.CustomField;
import annotations.Dob;
import annotations.Document;
import annotations.NotNull;

@Document(name = "PAN")
public class PanCard extends DocumentType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Value cannot be null")
	@CustomField(value = "[a-zA-Z]{8,20}", message = "Name should be alteast 8 characters")
	@ConsistencyCheck(matchClass = BankStatement.class, matchField = "fullName")
	private String fullName;

	@NotNull(message = "Value cannot be null")
	private String number;
	@NotNull(message = "Value cannot be null")
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
