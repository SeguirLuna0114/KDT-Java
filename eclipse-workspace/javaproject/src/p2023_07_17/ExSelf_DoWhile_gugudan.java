package p2023_07_17;

import java.util.Scanner;

public class ExSelf_DoWhile_gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Insert number(0:Exit): ");
		int n = sc.nextInt();
		
		do {
			System.out.println("Insert number: "+n);
			if (n==0) {
				System.out.println("Insert 2~9 number!");
			} else {
				System.out.println("["+n+"단]");
				for (int i=1; i<10; i++) {
					System.out.println(n+"*"+i+"= "+(n*i));
				}
			}
				
		} while (n==0);
		
		sc.close();
		
	}

}
