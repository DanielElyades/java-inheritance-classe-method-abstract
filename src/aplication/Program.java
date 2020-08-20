package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<TaxPayer>();
		
		System.out.println("Enter the number of taxpayer: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Taxpayer #" + i + " data:");
			System.out.println("Individual or company (i/c)?");
			char type = sc.next().charAt(0);
			System.out.println("Name:");
			String name = sc.next();
			System.out.println("Anual income: ");
			Double anualIncome = sc.nextDouble();
			
			if (type == 'i') {
				System.out.println("Health expendentures: ");
				Double healthExpenditures = sc.nextDouble();
				Individual x = new Individual(name, anualIncome, healthExpenditures);
				list.add(x);
			}
			else {
				System.out.println("Number of employees:");
				Integer numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
				
				System.out.println();
				System.out.println("TAXES PAID:");
				double sum = 0.0;
				for (TaxPayer taxPayer : list) {
					System.out.println(taxPayer.getName()
							+ ": $ " + String.format("%.2f", taxPayer.tax()));
					
				}
				System.out.println();
				for (TaxPayer taxPayer : list) {
					sum += taxPayer.tax();
					
				}
				System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
				
				sc.close();
			}
		}

	}

}
