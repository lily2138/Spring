package banking.test;

import banking.Account;
import banking.Customer;

public class BankClientTest {

	public static void main(String[] args) {
		/*
		 * James라는 이름의 고객을 생성...주민번호는 1234
		 * James가 잔액 10000원을 가진 계좌를 하나 개설
		 * 새로 만든 계좌를 통해서
		 * 5000원, 12000원을 입금합니다
		 * 7000원 출금
		 * 최종적으로 James통장의 잔액을 출금
		 */

		Customer custom1 = new Customer("James",1234);
		
		/*Account acc = new Account(10000);
		custom1.setAccount(acc);*/
		custom1.setAccount(new Account(10000));
		
		Account james = custom1.getAccount();
		
		james.deposit(5000);
		james.deposit(12000);
		james.withdraw(7000);
		
		System.out.println(james.getBalance());
		
/*		acc.deposit(5000);
		acc.deposit(12000);
		acc.withdraw(7000);
		
		System.out.println(acc.getBalance());*/
		
		
		
		
		
		
	}

}
