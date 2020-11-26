package com.qa.ims.persistence.domain;

public class Customer {

	private Long id;
	private String firstName;
	private String surname;

	public Customer(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
	}

	public Customer(Long id, String firstName, String surname) {
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
	}

	public Long getId() {
		return id;
	}

<<<<<<< HEAD
	public void setId(Long id) {
		this.id = id;
	}

=======
>>>>>>> 81d2584424cbeb328bae08b88e51a30db0313198
	public String getFirstName() {
		return firstName;
	}

<<<<<<< HEAD
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

=======
>>>>>>> 81d2584424cbeb328bae08b88e51a30db0313198
	public String getSurname() {
		return surname;
	}

<<<<<<< HEAD
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "id:" + id + " first name:" + firstName + " surname:" + surname;
=======

	@Override
	public String toString() {
		return "ID:" + id + " | First Name: " + firstName + " | Surname: " + surname + " |";
>>>>>>> 81d2584424cbeb328bae08b88e51a30db0313198
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
