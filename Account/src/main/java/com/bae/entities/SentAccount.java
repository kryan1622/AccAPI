package com.bae.entities;

public class SentAccount {

    private Long accountId;

    private String firstName;

    private String lastName;

    private String accountNumber;
    
    private String Prize;
    
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

  


    public SentAccount(){}

    public SentAccount(Account account){
        this.accountId = account.getAccountId();
        this.firstName = account.getFirstName();
        this.lastName = account.getLastName();
        this.accountNumber = account.getAccountNumber();
        this.Prize = account.getPrize();
    }

	public String getPrize() {
		return Prize;
	}

	public void setPrize(String prize) {
		Prize = prize;
	}


}
