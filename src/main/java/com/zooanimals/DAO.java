package com.zooanimals;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {

	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_ST = null;
	static ResultSet RES_SET = null; 


	public static void connToDB()
	{
		try {
			Class.forName(JDBC_Driver);

			System.out.println("Trying to conect to the Database...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database.");


		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}


	public static void readFromDB()
	{
		connToDB();
		ArrayList<Animals>zooAnimals = new ArrayList<>();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM zoo_animals.animals;");

			while(RES_SET.next()){

				Animals animalsInDB = new Animals();

				animalsInDB.setAnimalsID(RES_SET.getString("animals_id"));
				animalsInDB.setSpecies(RES_SET.getString("species"));
				animalsInDB.setName(RES_SET.getString("name"));
				animalsInDB.setHabitat(RES_SET.getString("habitat"));
				animalsInDB.setAge(RES_SET.getInt("age"));
				animalsInDB.setWeight(RES_SET.getDouble("weight"));

				zooAnimals.add(animalsInDB);

			}
			for (Animals animals : zooAnimals) {
				System.out.println(animals.toString());
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//rfdb

	public static void writeToDB(Animals animals){

		Animals animalToAdd = new Animals();

		animalToAdd = animals;

		try {

			connToDB();

			PREP_ST = CONN.prepareStatement(insertToDB);

			PREP_ST.setString(1, animalToAdd.getSpecies());
			PREP_ST.setString(2, animalToAdd.getName());
			PREP_ST.setString(3, animalToAdd.getHabitat());
			PREP_ST.setInt(4, animalToAdd.getAge());
			PREP_ST.setDouble(5, animalToAdd.getWeight());

			System.out.println(PREP_ST);

			PREP_ST.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}//wtdb

	static void delFromDB()
	{
		Scanner sc = new Scanner(System.in);

		readFromDB();

		System.out.println("Which animal would you like to delete?");
		int id  = sc.nextInt();

		try
		{

			PREP_ST = CONN.prepareStatement(delFromTable(id ));
			PREP_ST.executeUpdate();

		}catch(SQLException e)
		{
			e.printStackTrace();
		}

	}//dfdb



	private static String insertToDB = "INSERT INTO `zoo_animals`.`animals`"
			+ "(species, name, habitat, age, weight)"
			+"VALUES"
			+"(?, ?, ?,?,?);";

	private static String delFromTable(int id)
	{

		return "DELETE FROM `zoo_animals`.`animals` WHERE animals_id = " + id + ";";

	}



	public static Animals aboutTheAnimal(){
		Scanner sc = new Scanner(System.in);
		Animals animalToAdd = new Animals();

		System.out.println("What type of animal would you like to add to your fantasy zoo(i.e. Panda, Fox, etc)?");
		animalToAdd.setSpecies(sc.nextLine());

		System.out.println("What would you like to name your new animal friend?");
		animalToAdd.setName(sc.nextLine());

		System.out.println("What is your animal's habitat(i.e. Forest, Savannah, etc.)?");
		animalToAdd.setHabitat(sc.nextLine());

		System.out.println("How old is your animal friend?");
		animalToAdd.setAge(Integer.parseInt(sc.nextLine()));

		System.out.println("Finally, how much does your animal weigh?");
		animalToAdd.setWeight(Double.parseDouble(sc.nextLine()));

		sc.close();
		return animalToAdd;
	}//ata



}//class
