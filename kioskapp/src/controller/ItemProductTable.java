package controller;

import java.sql.*;
import java.util.*;

import kioskapp.itemproduct.*;

public class ItemProductTable {

	private DbController dbCtrl;
	
	public ItemProductTable() {
		dbCtrl = new DbController();
	}
	
	/**
	 * This method will get id, name and price for display the food
	 */
	public ArrayList<ItemProduct> selectAllProduct(){
		//Form SQL statement
		String sql = "SELECT * FROM itemproduct";
		
		//An object to store a list of product
		ArrayList <ItemProduct> foods= new ArrayList<ItemProduct>();
		
		try {
			//Establish connection
			Connection conn = dbCtrl.getConnection();
			
			// Wrap SQL in object
			Statement stat = conn.createStatement();
			
			//Execute the SQL Statement
			ResultSet rs = stat.executeQuery(sql);
			
			//Display the result
			while(rs.next()) {
				
				//Wrap a record into an object
				ItemProduct food = new ItemProduct();
				food.setItemProduct(rs.getInt(1));
				food.setName(rs.getString(2));
				food.setPrice(rs.getFloat(3));
				
				//Add into the list
				foods.add(food);
			}
			//Close all database related object
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return foods;
	}
}
