package integrationPkg;

import java.util.Scanner;

//Wyatt Byroade
//Integration Project - COP 2006
//Fall 2017

public class Integration {
	public static Scanner scan;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stubtest
		System.out.println("Welcome to my Integration Project.");

		Scanner scan = new Scanner(System.in);

		System.out.println("Would you like to encode or decode text?:\n1-encode\n2-decode");
		int encodeDecodeChoice = scan.nextInt();
		
		if (encodeDecodeChoice == 1) {
			System.out.println("You selected to encode text.\nEnter text to encode:");
			String encodeInput = scan.nextLine();
		}
		else if (encodeDecodeChoice == 2) {
			System.out.println("You selected to decode text.\nEnter text to encode:");
			String decodeInput = scan.nextLine();
		}
		
		
		System.out.println("Program Completed Successfully. Modified.");
		scan.close();
	}

}
