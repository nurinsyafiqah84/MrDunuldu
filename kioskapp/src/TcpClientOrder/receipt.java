package TcpClientOrder;

import java.text.DecimalFormat;
import java.util.List;

import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;


public class receipt {
	
	public static String writeReceipt(OrderTransaction orderTransaction) {
		DecimalFormat df = new DecimalFormat("0.00");
		// receipt part
		
		String receipt =  "                MC-DUNULDU RECEIPT\n"
						+ "------------------------------------------------\n"
						+ "                  RECEIPT    \n"
						+ "------------------------------------------------\n"
						+ "Qty	Item			Price(RM)\n"
						+ "------------------------------------------------\n";
		
		int x=1;
		Order orders = orderTransaction.getOrder();
		List <OrderedItem> ordered = orders.getOrderedItems();

		for(OrderedItem orderm:ordered) {
			receipt += orderm.getQuantity()+"	"+ orderm.getItemProduct() + "	RM"
		+df.format(orderm.getSubTotalAmount())+"\n";
			
		}
		
		
		receipt += 		  "------------------------------------------------\n"
						+ "Order mode: "+orderTransaction.getOrderMode()+"\n"  //take away or dine in
						
						+ "------------------------------------------------\n"
						+ "TOTAL:			      "+ df.format(orders.getTotalAmount()) +"\n"
						+ "------------------------------------------------\n"
						+ "paid with:\n"
						+ "**** **** **** "+orderTransaction.getLast4Digits()+"\n"
						+ "TRANSACTION STATUS: SUCCESSFULL"+ "\n"
						+ "------------------------------------------------\n"
						+ "------------------------------------------------\n"
						+ "                    THANK YOU         \n";
		return receipt;
	}
}