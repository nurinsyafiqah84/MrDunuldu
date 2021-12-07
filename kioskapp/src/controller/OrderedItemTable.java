package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

public class OrderedItemTable {
private DbController dbCtrl;
	
	public OrderedItemTable() {
		dbCtrl = new DbController();
	}
	
	/**
	 * This method will get 
	 */
	public void orderedSave(Order orders, int numberIndex){
		//Form SQL statement
		String sql = "INSERT INTO `orderedItem`(`ItemProduct`, `Quantity`, `SubTotalAmount`, `Order`) VALUES (?, ?, ?, ?)";
		int row = 0;
		
		List <OrderedItem> ordered = orders.getOrderedItems();
		
		try {

			//Establish connection
			Connection conn = dbCtrl.getConnection();
			
			//Create prepared statement and set parameter
			PreparedStatement ps = conn.prepareStatement(sql);
			for(OrderedItem orderm:ordered) {
				ps.setInt(1, orderm.getOrderedItem());
				ps.setInt(2, orderm.getQuantity());
				ps.setFloat(3, orderm.getSubTotalAmount());
				ps.setInt(4, numberIndex);
				
				//Execute SQL
				row = ps.executeUpdate();
			}
					
			//Close all connections
			ps.close();
			conn.close();
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
	}
}
