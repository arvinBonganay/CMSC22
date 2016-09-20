
/** 
 * by Arvin 
 */

public class Account{
	private int accountNumber;
	private double balance = 0.0;

	public Account(int accountNumber, double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public Account(int accountNumber){
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber(){
		return accountNumber;
	}

	public double getBalance(){
		return balance;
	}
	
	public void setBalance(double balance){
		error(balance);
		this.balance = balance;
	}

	public void credit(double amount){
		error(amount);
		this.balance = balance + amount;
	}

	public void debit(double amount){
		error(amount);
		if (balance >= amount){
			balance = balance - amount;
		} else {
			System.out.println("amount withdrawn exceeds the current balance");
		}
	}
	private void error(double amount){
		if (amount <= 0.0){
			throw new IllegalArgumentException("Illgeal value of money");
		}
	}
	public String toString(){
		return String.format("A/C no: %d, Balance = $ %.2f", accountNumber, balance);
	}


}
