import java.util.*;
import controller.*;
import kioskapp.itemproduct.ItemProduct;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello Welcome to Mc D");
		System.out.println("Please choose to dine in or take away? = ");
		System.out.println ("1. Dine in");
		System.out.println("2. Takeaway");
		System.out.println("Choose = ");
		Scanner input1 = new Scanner(System.in);
		int choose = input1.nextInt();
		
		System.out.println("\n\nThese are the list of food");
		ItemProductTable listFood = new ItemProductTable();
		ArrayList <ItemProduct> foods = listFood.selectAllProduct();
	}

}
