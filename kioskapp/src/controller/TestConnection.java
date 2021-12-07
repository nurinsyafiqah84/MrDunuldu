package controller;

import java.sql.Connection;

/**
 * This class test the connection to the database
 * @author User
 *
 */
public class TestConnection{

	/**
	 * Main entry point to the program
	 * @param args
	 */
	public static void main(String[] args) {
		DbController dbCtrl = new DbController();
		
		try {
			
			Connection connection = dbCtrl.getConnection();
			System.out.println("Durin Tunggal...connection to RDBMS is successfully");
		
		} catch(Exception e) {
			//TODO Auto-generated catch Block
			e.printStackTrace();
		}
	}
}

