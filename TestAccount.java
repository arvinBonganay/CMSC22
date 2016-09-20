/*
 * A Test Driver for the Account class.
 */
public class TestAccount{
	public static void main(String[] args){
		Account a = new Account(100);
		Account b = new Account(100, 5000.0);
		
		System.out.println(a);
		System.out.println(b);

		a.setBalance(100);
		a.getBalance();


		a.credit(5000.0);
		a.debit(2000.0);

		b.setBalance(-124.00);
		b.setBalance(1000.0);
		
		a.debit(5000.0);
			
		System.out.println(a);
		System.out.println(b);
	}

}