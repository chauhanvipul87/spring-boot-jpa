package com.iana.sdata.domain;

import javax.persistence.*;

@SqlResultSetMapping(name="PersonDTOMapping",
		classes = {
				@ConstructorResult(targetClass = PersonDTO.class,
						columns = {@ColumnResult(name="fName"), @ColumnResult(name="lName")}
				)}
)
@Entity
public class Person {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}