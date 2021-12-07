/**
 * this is server order function as:
 * receive card credit number and ordered item from client order and send status transaction ro client order.
 * save data to localhost after successful transaction
 * receive status transaction from card server
 * send data order item to kitchen client
 */
package TcpServerOrder;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import controller.OrderTable;
import controller.OrdereTransactionTable;
import controller.OrderedItemTable;
import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

/**
 * This class launch the server side application using TCP.
 * The server generates current date.
 * Each connected client will received current date from the server.
 * 
 * @author emalianakasmuri
 *
 */

public class ServerOrderApplication {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// Launch the server frame
				ServerOrderFrame serverFrame = new ServerOrderFrame();
				serverFrame.setVisible(true);
				
				// Binding to a port or any other port no you are fancy of
				int portNo = 8001;
				ServerSocket serverSocket = new ServerSocket(portNo);
				
				
				// Counter to keep track the number of requested connection
				int totalRequest = 0;
				
				ServerSocket kitchenSocket = new ServerSocket(2000);
				// Accept client request for connection
				Socket kitchenClient = kitchenSocket.accept();
				
				// Server needs to be alive forever
				while (true) {
		
					// Accept client request for connection
					Socket clientSocket = serverSocket.accept();
					// Message to indicate server is alive
					serverFrame.updateServerStatus(clientSocket.isConnected());
					
					//Receive data transaction and card creadit from kiosk client
					ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream()); //(2)
					OrderTransaction orderTransaction = (OrderTransaction)inputStream.readObject();
					String creditCardNo = inputStream.readUTF();
					serverFrame.updateRequestStatus(creditCardNo);
					
					
					//server card
					//open a new socket to send a request for card server
					Socket cc = new Socket("localhost", 4884);
					
					//to send data to card server
					ObjectOutputStream outputStream = new ObjectOutputStream(cc.getOutputStream());
					outputStream.writeUTF(creditCardNo);
					
					//to send order to transaction order
					outputStream.writeObject(orderTransaction);
					
					outputStream.flush();
					
					//receive data from card server after update status card
					ObjectInputStream cardStream = new ObjectInputStream(cc.getInputStream());
					orderTransaction = (OrderTransaction)cardStream.readObject();

					
					Order orders = orderTransaction.getOrder();
					
					//update to jdbc/localhost
					if(orderTransaction.isTransactionStatus()) {
						OrderTable orderList = new OrderTable();
						orderList.referenceNumber(orderTransaction);
						int numIndex = orderList.ordeId();
						orderTransaction.setOrderTransactionId(numIndex);
						OrderedItemTable orderedItemList = new OrderedItemTable();
						orderedItemList.orderedSave(orders, numIndex);
						OrdereTransactionTable orderTransList = new OrdereTransactionTable();
						orderTransList.orderedTransSave(orderTransaction, numIndex);
						
						
						//to send data to card server
						ObjectOutputStream kitchenStream = new ObjectOutputStream(kitchenClient.getOutputStream());
						kitchenStream.writeObject(orderTransaction);
						kitchenStream.flush();
					}
					
					//send status to client order
					ObjectOutputStream statusStream = new ObjectOutputStream(clientSocket.getOutputStream());
					statusStream.writeObject(orderTransaction);
					statusStream.flush();
					
					clientSocket.close();
				
					// Update the request status
					serverFrame.updateRequestStatus(
							"Data sent to the client: " + creditCardNo);
					serverFrame.updateRequestStatus("Accepted connection to from the "
							+ "client. Total request = " + ++totalRequest );
				}
		
		

	}

}





