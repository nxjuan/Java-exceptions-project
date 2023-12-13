package programs;

import java.util.Locale;
import java.util.Scanner;

import models.entities.Account;
import models.exceptions.DomainException;

public class Aplication {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try {
			// Instanciando as variaveis temporarias que vão alimentar o construtor
			System.out.println("Enter account data:");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.next();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			// Instanciando o objeto
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			// Realizando saque
			System.out.print("\nEnter amount for a withdraw: ");
			double withdraw = sc.nextDouble();
			account.withdraw(withdraw);
			
			System.out.println(account.toString());;
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("Invalid data imputed!");
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unespected Error!");
		}		
		
		
		sc.close();
	}

}
