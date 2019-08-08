package com.bae.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	

	    @Id
	    @GeneratedValue
	    private Long accountId;

	    private String firstName;

	    private String lastName;

	    private String accountNumber;

		private String prizeWon;
 
		
	    public Long getAccountId() {
			return accountId;
		}

		public void setAccountId(Long accountId) {
			this.accountId = accountId;
		}

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

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public Account(Long accountId, String firstName, String lastName, String accountNumber) {
			super();
			this.accountId = accountId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.accountNumber = accountNumber;
			this.prizeWon = prizeWon;
		}

		public Account() {
			super();
		}

		public void setPrize(String prizeWon) {
			this.prizeWon = prizeWon;
			
		}
	    
}
