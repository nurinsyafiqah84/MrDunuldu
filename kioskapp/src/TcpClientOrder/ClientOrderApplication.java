/**
 * client order/kiosk is function as :
 * accept data(number card and ordered item) from kiosk frame then send to server order
 * receive status of card from server order
 */

package TcpClientOrder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;

import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

public class ClientOrderApplication {

	public static void main(String[] args) throws Exception
	{
		Socket c = new Socket("localhost",8001);
		
		ClientOrderFrame window = new ClientOrderFrame();
		window.setVisible(true);
		// Create stream to write data on the network
		ObjectOutputStream dout = new ObjectOutputStream(c.getOutputStream());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		// Update the status of the connection
		//window.updateConnectionStatus(c.isConnected());
		
		while(true)
		{

			
			//get data from order frame
			OrderTransaction orderTransaction = window.getOrderTransaction();
			String creaditNumber = window.getCardCreadit();

			//send creadit number to order server
			dout.writeObject(orderTransaction);
			dout.writeUTF(creaditNumber);
			dout.flush();
			
			//receive status from order server
			ObjectInputStream inputStream = new ObjectInputStream(c.getInputStream());
			orderTransaction = (OrderTransaction)inputStream.readObject();
			
			if(orderTransaction.isTransactionStatus()) {
				//System.out.println("Client = Successfull");
				JOptionPane.showMessageDialog(null, "Transaction successfull and receipt will be printed");
				window.dispose();
				
				//take transaction id and order id as file name 
				String targetSource = Integer.toString(orderTransaction.getOrderTransactionId()) + ".txt";

				receipt printed = new receipt();
				String receiptContent = receipt.writeReceipt(orderTransaction);
				FileWriter fileWriter = new FileWriter (targetSource);
				fileWriter.write(receiptContent);
				fileWriter.flush();
				fileWriter.close();
			}
			else {
				//System.out.println("Client = nope");
				JOptionPane.showMessageDialog(null, "Invalid Number Card Creadit!!");
				window.dispose();
			}			
			
			if(creaditNumber.equalsIgnoreCase("exit"))
			{
				break;
			}
		}
	c.close();
	} 

}