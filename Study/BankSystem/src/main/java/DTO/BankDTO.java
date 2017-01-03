package DTO;

//DTO는 DB의 테이블을 근간으로 만든다.
public class BankDTO {
	
	String username;
	int balance;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
