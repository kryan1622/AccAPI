package com.bae.entities;

public class SentAccount {

	   private Long accountId;

	    private String firstName;

	    private String lastName;

	    private String accountNumber;

	    private String Prize;

	    public SentAccount() {
	    }

	    public SentAccount(Long accountId, String firstName, String lastName, String accountNumber, String Prize) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.accountNumber = accountNumber;
	        this.accountId = accountId;
	        this.Prize = Prize;
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

		public Long getAccountId() {
			return accountId;
		}

		public void setAccountId(Long accountId) {
			this.accountId = accountId;
		}

		public String getPrize() {
			return Prize;
		}

		public void setPrize(String prize) {
			Prize = prize;
		}

	 
}
