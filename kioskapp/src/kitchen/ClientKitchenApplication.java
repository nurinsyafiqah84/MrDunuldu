package kitchen;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

public class ClientKitchenApplication {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		int portNo = 2000;
		Socket kitchen = new Socket("localhost", portNo);
		
		ClientKitchenFrame window = new ClientKitchenFrame();
		window.setVisible(true);
		

		while(true) {
			//Receive data transaction from kiosk client
			ObjectInputStream inputStream = new ObjectInputStream(kitchen.getInputStream()); //(2)
			OrderTransaction orderTransaction = (OrderTransaction)inputStream.readObject();
			

			Order orders = orderTransaction.getOrder();
			List <OrderedItem> ordered = orders.getOrderedItems();

			String currentDate = new Date().toString();
			window.updateRequestStatus("Date = " + currentDate);
			window.updateRequestStatus("Order Mode = "+orderTransaction.getOrderMode());
			for(OrderedItem orderm:ordered) {
				window.updateRequestStatus(String.valueOf(orderm.getQuantity())+ " " 
						+ orderm.getItemProduct() + "\n");
			}
			
		}
		
		
		
		
		
	}

}
