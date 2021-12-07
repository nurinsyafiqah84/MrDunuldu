package controller;

import java.sql.*;
import java.util.*;

import kioskapp.itemproduct.*;
import kioskapp.order.Order;
import kioskapp.ordertransaction.OrderTransaction;

public class OrderTable {

	private DbController dbCtrl;
	
	public OrderTable() {
		dbCtrl = new DbController();
	}
	
	/**
	 * This method will get 
	 */
	public void referenceNumber(OrderTransaction orderTransaction){
		//Form SQL statement
		String sql = "INSERT INTO `order`(`TotalAmount`, `OrderReferenceNumber`) VALUES (?, ?)";
		int row = 0;		
		try {

			//Establish connection
			Connection conn = dbCtrl.getConnection();
			
			//Create prepared statement and set parameter
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setFloat(1, orderTransaction.getAmountCharged());
			ps.setInt(2, 1);
			
			//Execute SQL
			row = ps.executeUpdate();
			
			//Close all connections
			ps.close();
			conn.close();
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
	}
	
	public int ordeId(){
		//Form SQL statement
		String sql = "SELECT `OrderId` from `order`";
		int row = 0;
		int num=0;
		try {

			//Establish connection
			Connection conn = dbCtrl.getConnection();
			
			// Wrap SQL in object
			Statement stat = conn.createStatement();
			
			//Execute the SQL Statement
			ResultSet rs = stat.executeQuery(sql);
			
			//Display the result
			while(rs.next()) {
				num = rs.getInt(1);
			}
			
			
			//Close all database related object
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return num;
	}
		
	
}