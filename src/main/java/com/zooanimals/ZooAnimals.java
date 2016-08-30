package com.zooanimals;

import java.util.Scanner;

public class ZooAnimals {
	
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		boolean menuCorrect = false;
		
		System.out.println("Welcome to the Fantasy Zoo App!!!");
	
	do
	{
		System.out.println("Press 1 to read from DB" + "\nPress 2 to add to DB" + "\nPress 3 to delete from DB");
		String userMenuInput = sc.nextLine();


 
		switch (userMenuInput) { 
		case "1":
			DAO.readFromDB();

			break;
		case "2":
			//DAO.writeToDB();
			
			break;	
		case "3":
			DAO.delFromDB();
			
			break;
		default:
			System.out.println("You've entered an invalid option");
			menuCorrect = true;
			break;
		}
	}while(menuCorrect);
	
	sc.close();

	}
	
}
