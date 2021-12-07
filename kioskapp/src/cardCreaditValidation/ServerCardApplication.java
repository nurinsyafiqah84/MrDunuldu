/**
 * this server card function as :
 * validation number card 
 * receive card number and send status transaction
 */

package cardCreaditValidation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

public class ServerCardApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//binding portNo 4229 to server socket
		int portNo = 4884;
		ServerSocket serverSocket = new ServerSocket(portNo);
			
		ServerCardFrame frame = new ServerCardFrame();
		frame.setVisible(true);
		
		int totalRequest = 0;
		OrderTransaction orderTransaction = null;
		
		//OrderTransaction orderTransaction = null;
		while(true) {
			// Message to indicate server is alive
			frame.updateServerStatus(true);
			
			// Accept client request for connection
			Socket kioskSocket = serverSocket.accept();
			
			//Receive data card creadit from kiosk client
			ObjectInputStream inputStream = new ObjectInputStream(kioskSocket.getInputStream()); //(2)
			String creditCardNo = inputStream.readUTF();
			frame.updateRequestStatus(creditCardNo);
			
			//receive order from server
			orderTransaction = (OrderTransaction)inputStream.readObject();
				
			//to get validation card
			CreditCardValidation authorization = new CreditCardValidation(creditCardNo);
			orderTransaction.setTransactionStatus(authorization.getValidate());
			if(orderTransaction.isTransactionStatus()) {
				orderTransaction.setLast4Digits(Integer.parseInt(creditCardNo.substring(creditCardNo.length() - 4)));
			}
			
			//to send validation status to server
			ObjectOutputStream outputStream = new ObjectOutputStream(kioskSocket.getOutputStream());
			outputStream.writeObject(orderTransaction);
			outputStream.flush();
			
			kioskSocket.close();	
			inputStream.close();
			outputStream.close();
			
			// Update the request status
			frame.updateRequestStatus(
					"Data sent to the client: " + creditCardNo + "\n Order trans = " + orderTransaction.isTransactionStatus());
			frame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
		}
	}
}
