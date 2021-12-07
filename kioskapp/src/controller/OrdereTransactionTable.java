package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

public class OrdereTransactionTable {
private DbController dbCtrl;
	
	public OrdereTransactionTable() {
		dbCtrl = new DbController();
	}
	
	/**
	 * This method will get 
	 */
	public void orderedTransSave(OrderTransaction orderm, int numberIndex){
		//Form SQL statement
		String sql = "INSERT INTO `ordertransaction`(`TransactionDate`, `Order`, "
				+ "`AmountCharged`, `TransactionStatus`, `Last4Digits`, `OrderMode`) VALUES (LOCALTIMESTAMP(), ?, ?, ?, ?, ?)";
		int row = 0;

		
		try {

			//Establish connection
			Connection conn = dbCtrl.getConnection();
			
			//Create prepared statement and set parameter
			PreparedStatement ps = conn.prepareStatement(sql);
			
				ps.setInt(1, numberIndex);
				ps.setFloat(2, orderm.getAmountCharged());
				ps.setInt(3, 1);
				ps.setInt(4, orderm.getLast4Digits());
				ps.setString(5, orderm.getOrderMode());
				
				//Execute SQL
				row = ps.executeUpdate();
		
					
			//Close all connections
			ps.close();
			conn.close();
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
	}
}

