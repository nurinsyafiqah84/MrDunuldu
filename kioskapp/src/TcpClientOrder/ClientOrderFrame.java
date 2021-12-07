package TcpClientOrder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import controller.ItemProductTable;
import controller.OrderTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.ServerSocket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import kioskapp.itemproduct.ItemProduct;
import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeListener;

import cardCreaditValidation.CreditCardValidation;

import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class ClientOrderFrame extends JFrame{

	//private JFrame frame;
	private JTextField CardFill;
	private JTextField txtHello;
	private float totalOrder=0;
	private float newTotal=0;
	private float totalPrice=0;
	private String CardCreadit;
	private String orderMode;
	private boolean statusTrans;
	
	
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	JPanel MenuPanel = new JPanel();
	JPanel CartPanel = new JPanel();
	JPanel PaymentPanel = new JPanel();
	JPanel HomePanel = new JPanel();

	private OrderTransaction orderTransaction;
	ItemProductTable itemProductMgr = new ItemProductTable();
	ArrayList<ItemProduct> items = itemProductMgr.selectAllProduct();
	ArrayList<OrderedItem> orderItems = new ArrayList<OrderedItem>();;
	Order order = new Order();
	
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	//declare array for name, price and path
	String name[] = new String[13];
	float price[] = new float[13];
	String pathMenu[] ={
			"src/gambar/mc chicken.png",
			"src/gambar/ayam mcd 2pc.png",
			"src/gambar/spicy chic deluxe.png",
			"src/gambar/ayam mcd 5pc.png",
			"src/gambar/nugget.jfif.png",
			"src/gambar/product-double-cheeseburger.png",
			"src/gambar/product-big-mac.png",
			"src/gambar/filet-o-fish.png",
			"src/gambar/mc chcken meal.png",
			"src/gambar/mcd-meals-chicken-mcnuggets.png",
			"src/gambar/fof meal.png",
			"src/gambar/product-hot-fudge-sundae.png",
			"src/gambar/product-strawberry-sundae.png"
			
		};

	boolean listed[]=new boolean[13];
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientOrderFrame window = new ClientOrderFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	private static final long serialVersionUID = 1L;
	private JTextField textField_3;
	private JTextField ErrorMessage;
	private JTextArea textField;
	
	/**
	 * Create the application.
	 */
	public ClientOrderFrame() {
		//frame = new JFrame();
		//frame.setVisible(true);
		setBackground(Color.RED);
		getContentPane().setBackground(Color.PINK);
		setBounds(100, 100, 1160, 843);
		
		//Must close on X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//Cannot resize the frame
		setResizable(false);

		//Center the frame on the screen
		setLocationRelativeTo(null);
		
		//array list
		int i=0;
		for(ItemProduct item: items) {
			//item.getName();
			price[i] = item.getPrice();
			name[i] = item.getName();
			//System.out.println(name[i] + "\n" + price[i] + "\n" );
			i++;
		}
		
		
		//Display next content
		loadComponent();
	}
	
	/**
	 * this is for menu panel page
	 */
	public JPanel getMenuPanel() {			//done

		JLabel lblNewLabel_1 = new JLabel(name[0]);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 165, 152, 35);
		MenuPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(name[1]);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setBounds(202, 165, 152, 35);
		MenuPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel(name[2]);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_2.setBounds(386, 165, 152, 35);
		MenuPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel(name[3]);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_3.setBounds(568, 165, 152, 35);
		MenuPanel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel(name[5]);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_4.setBounds(753, 165, 152, 35);
		MenuPanel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel(name[4]);
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_5.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_5.setBounds(935, 165, 152, 35);
		MenuPanel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel(name[6]);
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_6.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_6.setBounds(20, 416, 152, 35);
		MenuPanel.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(name[7]);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1.setBounds(202, 416, 152, 35);
		MenuPanel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel(name[8]);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_2_1.setBounds(386, 416, 152, 35);
		MenuPanel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel(name[9]);
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_3_1.setBounds(568, 416, 152, 35);
		MenuPanel.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel(name[10]);
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_4_1.setBounds(753, 416, 152, 35);
		MenuPanel.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel(name[11]);
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_5_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_5_1.setBounds(935, 416, 152, 35);
		MenuPanel.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_6_1 = new JLabel(name[12]);
		lblNewLabel_1_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_6_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_6_1.setBounds(20, 675, 152, 35);
		MenuPanel.add(lblNewLabel_1_6_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 602, 1141, -596);
		MenuPanel.add(scrollPane);
		
		JLabel lblNewLabel_1_7 = new JLabel(Float.toString(price[0]));
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7.setBounds(84, 198, 54, 35);
		MenuPanel.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_7_1 = new JLabel(Float.toString(price[1]));
		lblNewLabel_1_7_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_1.setBounds(266, 198, 54, 35);
		MenuPanel.add(lblNewLabel_1_7_1);
		
		JLabel lblNewLabel_1_7_2 = new JLabel(Float.toString(price[2]));
		lblNewLabel_1_7_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_2.setBounds(450, 198, 54, 35);
		MenuPanel.add(lblNewLabel_1_7_2);
		
		JLabel lblNewLabel_1_7_3 = new JLabel(Float.toString(price[3]));
		lblNewLabel_1_7_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_3.setBounds(631, 198, 54, 35);
		MenuPanel.add(lblNewLabel_1_7_3);
		
		JLabel lblNewLabel_1_7_4 = new JLabel(Float.toString(price[4]));
		lblNewLabel_1_7_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_4.setBounds(806, 198, 54, 35);
		MenuPanel.add(lblNewLabel_1_7_4);
		
		JLabel lblNewLabel_1_7_5 = new JLabel(Float.toString(price[5]));
		lblNewLabel_1_7_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_5.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_5.setBounds(1000, 198, 54, 35);
		MenuPanel.add(lblNewLabel_1_7_5);
		
		JLabel lblNewLabel_1_7_6 = new JLabel(Float.toString(price[6]));
		lblNewLabel_1_7_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_6.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_6.setBounds(84, 446, 54, 35);
		MenuPanel.add(lblNewLabel_1_7_6);
		
		JLabel lblNewLabel_1_7_1_1 = new JLabel(Float.toString(price[7]));
		lblNewLabel_1_7_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_1_1.setBounds(266, 446, 54, 35);
		MenuPanel.add(lblNewLabel_1_7_1_1);
		
		JLabel lblNewLabel_1_7_2_1 = new JLabel(Float.toString(price[8]));
		lblNewLabel_1_7_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_2_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_2_1.setBounds(450, 446, 54, 35);
		MenuPanel.add(lblNewLabel_1_7_2_1);
		
		JLabel lblNewLabel_1_7_3_1 = new JLabel(Float.toString(price[9]));
		lblNewLabel_1_7_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_3_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_3_1.setBounds(631, 446, 54, 35);
		MenuPanel.add(lblNewLabel_1_7_3_1);
		
		JLabel lblNewLabel_1_7_4_1 = new JLabel(Float.toString(price[10]));
		lblNewLabel_1_7_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_4_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_4_1.setBounds(806, 446, 54, 35);
		MenuPanel.add(lblNewLabel_1_7_4_1);
		
		JLabel lblNewLabel_1_7_5_1 = new JLabel(Float.toString(price[11]));
		lblNewLabel_1_7_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_5_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_5_1.setBounds(1000, 446, 54, 35);
		MenuPanel.add(lblNewLabel_1_7_5_1);
		
		JLabel lblNewLabel_1_7_6_1 = new JLabel(Float.toString(price[12]));
		lblNewLabel_1_7_6_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_6_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_6_1.setBounds(84, 710, 54, 35);
		MenuPanel.add(lblNewLabel_1_7_6_1);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 35, 900, 660);
		CartPanel.add(scrollPane_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_7.setBackground(new Color(255, 235, 205));
		panel_7.setPreferredSize(new Dimension (500,1800));
		scrollPane_1.setViewportView(panel_7);
		panel_7.setLayout(new GridLayout(13, 0, 0, 0));
		
		JPanel ap_1_1 = new JPanel();
		ap_1_1.setLayout(null);
		ap_1_1.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1_1);1
		
		JLabel al_1_1 = new JLabel("New label");
		al_1_1.setIcon(new ImageIcon(pathMenu[0]));
		al_1_1.setBounds(1, 0, 155, 160);
		ap_1_1.add(al_1_1);
		
		JLabel al2_1_1 = new JLabel(name[0]);		
		al2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_1.setBounds(181, 15, 201, 130);
		ap_1_1.add(al2_1_1);
		
		JLabel al3_1_4_1 = new JLabel("RM" + df.format(price[0]));	
		al3_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_4_1.setBounds(584, 11, 130, 130);
		ap_1_1.add(al3_1_4_1);

		JSpinner as_1_1 = new JSpinner();
		as_1_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {		
				newTotal= price[0] * (Integer)as_1_1.getValue();			
				al3_1_4_1.setText("RM " + df.format(newTotal));		
			}
		});
		
		as_1_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_1.setBounds(448, 54, 103, 46);
		ap_1_1.add(as_1_1);

		JButton btnNewButton_4 = new JButton("REMOVE");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1_1);
				listed[0]=false;
				panel_7.repaint();
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		btnNewButton_4.setBounds(727, 55, 124, 40);
		ap_1_1.add(btnNewButton_4);

		JPanel ap_1_4 = new JPanel();			
		ap_1_4.setLayout(null);
		ap_1_4.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1_4);
		
		JLabel al_1_4 = new JLabel("New label");
		al_1_4.setIcon(new ImageIcon(pathMenu[1]));
		al_1_4.setBounds(0, -22, 155, 160);
		ap_1_4.add(al_1_4);		
		
		JLabel al2_1_4 = new JLabel(name[1]);
		al2_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_4.setBounds(181, 15, 201, 130);
		ap_1_4.add(al2_1_4);
		
		JLabel al3_1_4 = new JLabel("RM" + df.format(price[1]));
		al3_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_4.setBounds(587, 11, 130, 130);
		ap_1_4.add(al3_1_4);
		
		JSpinner as_1_4 = new JSpinner();
		as_1_4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				newTotal = price[1] * (Integer)as_1_4.getValue();
				al3_1_4.setText("RM " + df.format(newTotal));		
			}
		});
		as_1_4.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_4.setBounds(448, 54, 103, 46);
		ap_1_4.add(as_1_4);
		
		
		
		JButton btnNewButton_4_1 = new JButton("REMOVE");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1_4);
				listed[1]=false;	
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1.setBounds(727, 55, 124, 40);
		ap_1_4.add(btnNewButton_4_1);
		
		JPanel ap_1_3 = new JPanel();
		ap_1_3.setLayout(null);
		ap_1_3.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1_3);
		
		JLabel al_1_3 = new JLabel("New label");
		al_1_3.setIcon(new ImageIcon(pathMenu[3]));
		al_1_3.setBounds(0, -15, 155, 160);
		ap_1_3.add(al_1_3);
		
		JLabel al2_1_3 = new JLabel(name[2]);
		al2_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_3.setBounds(181, 15, 201, 130);
		ap_1_3.add(al2_1_3);
		
		JLabel al3_1_3 = new JLabel("RM" + df.format(price[2]));
		al3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_3.setBounds(587, 11, 130, 130);
		ap_1_3.add(al3_1_3);
		
		JSpinner as_1_3 = new JSpinner();
		as_1_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				newTotal = price[2] * (Integer)as_1_3.getValue();	
				al3_1_3.setText("RM " + df.format(newTotal));		
			}
		});
		as_1_3.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_3.setBounds(448, 54, 103, 46);
		ap_1_3.add(as_1_3);
		
		
		
		
		JButton btnNewButton_4_1_1 = new JButton("REMOVE");
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1_3);
				listed[2]=false;
				panel_7.repaint();
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		btnNewButton_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1_1.setBounds(727, 55, 124, 40);
		ap_1_3.add(btnNewButton_4_1_1);
		
		JPanel ap_1_3_1 = new JPanel();
		ap_1_3_1.setLayout(null);
		ap_1_3_1.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1_3_1);
		
		JLabel al_1_3_1 = new JLabel("New label");
		al_1_3_1.setIcon(new ImageIcon(pathMenu[2]));
		al_1_3_1.setBounds(0, -15, 155, 160);
		ap_1_3_1.add(al_1_3_1);
		
		JLabel al2_1_3_1 = new JLabel(name[3]);
		al2_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_3_1.setBounds(181, 15, 201, 130);
		ap_1_3_1.add(al2_1_3_1);
		
		JLabel al3_1_3_1 = new JLabel("RM" + df.format(price[3]));
		al3_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_3_1.setBounds(587, 11, 130, 130);
		ap_1_3_1.add(al3_1_3_1);
		
		JSpinner as_1_3_1 = new JSpinner();
		as_1_3_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				newTotal = price[3] * (Integer)as_1_3_1.getValue();	
				al3_1_3_1.setText("RM " + df.format(newTotal));		
			}
		});
		as_1_3_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_3_1.setBounds(448, 54, 103, 46);
		ap_1_3_1.add(as_1_3_1);
		
		
		
		JButton btnNewButton_4_1_1_1 = new JButton("REMOVE");
		btnNewButton_4_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1_3_1);
				listed[3]=false;
				panel_7.repaint();
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		btnNewButton_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1_1_1.setBounds(727, 55, 124, 40);
		ap_1_3_1.add(btnNewButton_4_1_1_1);
		
		JPanel ap_1_2_1 = new JPanel();
		ap_1_2_1.setLayout(null);
		ap_1_2_1.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1_2_1);
		
		JLabel al_1_2_1 = new JLabel("New label");
		al_1_2_1.setIcon(new ImageIcon(pathMenu[4]));
		al_1_2_1.setBounds(0, -22, 155, 160);
		ap_1_2_1.add(al_1_2_1);
		
		JLabel al2_1_2_1 = new JLabel(name[4]);
		al2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_2_1.setBounds(181, 15, 201, 130);
		ap_1_2_1.add(al2_1_2_1);
		
		JLabel al3_1_2_1 = new JLabel("RM" + df.format(price[4]));
		al3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_2_1.setBounds(587, 11, 130, 130);
		ap_1_2_1.add(al3_1_2_1);
		
		JSpinner as_1_2_1 = new JSpinner();
		as_1_2_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				newTotal = price[4] * (Integer)as_1_2_1.getValue();	
				al3_1_2_1.setText("RM " + df.format(newTotal));		
			}
		});
		as_1_2_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_2_1.setBounds(448, 54, 103, 46);
		ap_1_2_1.add(as_1_2_1);
		
		
		
		JButton btnNewButton_4_1_1_1_1 = new JButton("REMOVE");
		btnNewButton_4_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1_2_1);
				listed[4]=false;
				panel_7.repaint();
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		btnNewButton_4_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1_1_1_1.setBounds(727, 55, 124, 40);
		ap_1_2_1.add(btnNewButton_4_1_1_1_1);
		
		JPanel ap_1_2 = new JPanel();
		ap_1_2.setLayout(null);
		ap_1_2.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1_2);
		
		JLabel al_1_2 = new JLabel("New label");
		al_1_2.setIcon(new ImageIcon(pathMenu[5]));
		al_1_2.setBounds(0, -22, 155, 160);
		ap_1_2.add(al_1_2);
		
		JLabel al2_1_2 = new JLabel(name[5]);
		al2_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_2.setBounds(181, 15, 201, 130);
		ap_1_2.add(al2_1_2);
		
		JLabel al3_1_2 = new JLabel("RM" + df.format(price[5]));
		al3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_2.setBounds(587, 11, 130, 130);
		ap_1_2.add(al3_1_2);
		
		JSpinner as_1_2 = new JSpinner();
		as_1_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				newTotal = price[5] * (Integer)as_1_2.getValue();	
				al3_1_2.setText("RM " + df.format(newTotal));		
			}
		});
		as_1_2.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_2.setBounds(448, 54, 103, 46);
		ap_1_2.add(as_1_2);
		
		
		
		JButton btnNewButton_4_1_1_1_1_1 = new JButton("REMOVE");
		btnNewButton_4_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1_2);
				listed[5]=false;	
				panel_7.repaint();
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		btnNewButton_4_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1_1_1_1_1.setBounds(727, 55, 124, 40);
		ap_1_2.add(btnNewButton_4_1_1_1_1_1);
		
		JPanel ap_1_5_1_1_1_1_1 = new JPanel();
		ap_1_5_1_1_1_1_1.setLayout(null);
		ap_1_5_1_1_1_1_1.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1_5_1_1_1_1_1);
		
		JLabel al_1_5_1_1_1_1_1 = new JLabel("New label");
		al_1_5_1_1_1_1_1.setIcon(new ImageIcon(pathMenu[6]));
		al_1_5_1_1_1_1_1.setBounds(0, -11, 155, 160);
		ap_1_5_1_1_1_1_1.add(al_1_5_1_1_1_1_1);
		
		JLabel al2_1_5_1_1_1_1_1 = new JLabel(name[6]);
		al2_1_5_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_5_1_1_1_1_1.setBounds(181, 15, 216, 130);
		ap_1_5_1_1_1_1_1.add(al2_1_5_1_1_1_1_1);
		
		JLabel al3_1_5_1_1_1_1_1 = new JLabel("RM" + df.format(price[6]));
		al3_1_5_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_5_1_1_1_1_1.setBounds(587, 11, 130, 130);
		ap_1_5_1_1_1_1_1.add(al3_1_5_1_1_1_1_1);
		
		JSpinner as_1_5_1_1_1_1_1 = new JSpinner();
		as_1_5_1_1_1_1_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				newTotal = price[6] * (Integer)as_1_5_1_1_1_1_1.getValue();	
				al3_1_5_1_1_1_1_1.setText("RM " + df.format(newTotal));		
			}
		});
		as_1_5_1_1_1_1_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1_5_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_5_1_1_1_1_1.setBounds(448, 54, 103, 46);
		ap_1_5_1_1_1_1_1.add(as_1_5_1_1_1_1_1);
		
		
		
		JButton btnNewButton_4_1_1_1_1_1_1 = new JButton("REMOVE");
		btnNewButton_4_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1_5_1_1_1_1_1);
				listed[6]=false;
				panel_7.repaint();
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		btnNewButton_4_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1_1_1_1_1_1.setBounds(727, 55, 124, 40);
		ap_1_5_1_1_1_1_1.add(btnNewButton_4_1_1_1_1_1_1);
		
		JPanel ap_1_5_1_1_1_1 = new JPanel();
		ap_1_5_1_1_1_1.setLayout(null);
		ap_1_5_1_1_1_1.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1_5_1_1_1_1);
		
		JLabel al_1_5_1_1_1_1 = new JLabel("New label");
		al_1_5_1_1_1_1.setIcon(new ImageIcon(pathMenu[7]));
		al_1_5_1_1_1_1.setBounds(0, -11, 155, 160);
		ap_1_5_1_1_1_1.add(al_1_5_1_1_1_1);
		
		JLabel al2_1_5_1_1_1_1 = new JLabel(name[7]);
		al2_1_5_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_5_1_1_1_1.setBounds(181, 15, 216, 130);
		ap_1_5_1_1_1_1.add(al2_1_5_1_1_1_1);
		
		JLabel al3_1_5_1_1_1_1 = new JLabel("RM" + df.format(price[7]));
		al3_1_5_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_5_1_1_1_1.setBounds(587, 11, 130, 130);
		ap_1_5_1_1_1_1.add(al3_1_5_1_1_1_1);
		
		JSpinner as_1_5_1_1_1_1 = new JSpinner();
		as_1_5_1_1_1_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				newTotal = price[7] * (Integer)as_1_5_1_1_1_1.getValue();	
				al3_1_5_1_1_1_1.setText("RM " + df.format(newTotal));		//tukar sini
			}
		});
		as_1_5_1_1_1_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1_5_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_5_1_1_1_1.setBounds(448, 54, 103, 46);
		ap_1_5_1_1_1_1.add(as_1_5_1_1_1_1);
		
		
		
		JButton btnNewButton_4_1_1_1_1_1_1_1 = new JButton("REMOVE");
		btnNewButton_4_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1_5_1_1_1_1);
				listed[7]=false;	
				panel_7.repaint();
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		
				
		
		btnNewButton_4_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1_1_1_1_1_1_1.setBounds(727, 55, 124, 40);
		ap_1_5_1_1_1_1.add(btnNewButton_4_1_1_1_1_1_1_1);
		
		JPanel ap_1_5_1_1_1 = new JPanel();
		ap_1_5_1_1_1.setLayout(null);
		ap_1_5_1_1_1.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1_5_1_1_1);
		
		JLabel al_1_5_1_1_1 = new JLabel("New label");
		al_1_5_1_1_1.setIcon(new ImageIcon(pathMenu[8]));
		al_1_5_1_1_1.setBounds(0, -11, 155, 160);
		ap_1_5_1_1_1.add(al_1_5_1_1_1);
		
		JLabel al2_1_5_1_1_1 = new JLabel(name[8]);
		al2_1_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_5_1_1_1.setBounds(181, 15, 216, 130);
		ap_1_5_1_1_1.add(al2_1_5_1_1_1);
		
		JLabel al3_1_5_1_1_1 = new JLabel("RM" + df.format(price[8]));
		al3_1_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_5_1_1_1.setBounds(587, 11, 130, 130);
		ap_1_5_1_1_1.add(al3_1_5_1_1_1);
		
		JSpinner as_1_5_1_1_1 = new JSpinner();
		as_1_5_1_1_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				newTotal = price[8] * (Integer)as_1_5_1_1_1.getValue();	
				al3_1_5_1_1_1.setText("RM " + df.format(newTotal));		//tukar sini
			}
		});
		as_1_5_1_1_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_5_1_1_1.setBounds(448, 54, 103, 46);
		ap_1_5_1_1_1.add(as_1_5_1_1_1);
		
		
		
		JButton btnNewButton_4_1_1_1_1_1_1_2 = new JButton("REMOVE");
		btnNewButton_4_1_1_1_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1_5_1_1_1);
				listed[8]=false;
				panel_7.repaint();
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		btnNewButton_4_1_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1_1_1_1_1_1_2.setBounds(727, 55, 124, 40);
		ap_1_5_1_1_1.add(btnNewButton_4_1_1_1_1_1_1_2);
		
		JPanel ap_1_5_1_1 = new JPanel();
		ap_1_5_1_1.setLayout(null);
		ap_1_5_1_1.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1_5_1_1);
		
		JLabel al_1_5_1_1 = new JLabel("New label");
		al_1_5_1_1.setIcon(new ImageIcon(pathMenu[9]));
		al_1_5_1_1.setBounds(0, -11, 155, 160);
		ap_1_5_1_1.add(al_1_5_1_1);
		
		JLabel al2_1_5_1_1 = new JLabel(name[9]);
		al2_1_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_5_1_1.setBounds(181, 15, 201, 130);
		ap_1_5_1_1.add(al2_1_5_1_1);
		
		JLabel al3_1_5_1_1 = new JLabel("RM" + df.format(price[9]));
		al3_1_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_5_1_1.setBounds(587, 11, 130, 130);
		ap_1_5_1_1.add(al3_1_5_1_1);
		
		JSpinner as_1_5_1_1 = new JSpinner();
		as_1_5_1_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				newTotal = price[9] * (Integer)as_1_5_1_1.getValue();	
				al3_1_5_1_1.setText("RM " + df.format(newTotal));		//tukar sini
			}
		});
		as_1_5_1_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_5_1_1.setBounds(448, 54, 103, 46);
		ap_1_5_1_1.add(as_1_5_1_1);
		
		
		
		JButton btnNewButton_4_1_1_1_1_1_1_3 = new JButton("REMOVE");
		btnNewButton_4_1_1_1_1_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1_5_1_1);
				listed[9]=false;
				panel_7.repaint();
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		btnNewButton_4_1_1_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1_1_1_1_1_1_3.setBounds(727, 55, 124, 40);
		ap_1_5_1_1.add(btnNewButton_4_1_1_1_1_1_1_3);
		
		JPanel ap_1_5_1 = new JPanel();
		ap_1_5_1.setLayout(null);
		ap_1_5_1.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1_5_1);
		
		JLabel al_1_5_1 = new JLabel("New label");
		al_1_5_1.setIcon(new ImageIcon(pathMenu[10]));
		al_1_5_1.setBounds(0, -11, 155, 160);
		ap_1_5_1.add(al_1_5_1);
		
		JLabel al2_1_5_1 = new JLabel(name[10]);
		al2_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_5_1.setBounds(181, 15, 201, 130);
		ap_1_5_1.add(al2_1_5_1);
		
		JLabel al3_1_5_1 = new JLabel("RM" + df.format(price[10]));
		al3_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_5_1.setBounds(587, 11, 130, 130);
		ap_1_5_1.add(al3_1_5_1);
		
		JSpinner as_1_5_1 = new JSpinner();
		as_1_5_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				newTotal = price[10] * (Integer)as_1_5_1.getValue();	
				al3_1_5_1.setText("RM " + df.format(newTotal));		//tukar sini
			}
		});
		as_1_5_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_5_1.setBounds(448, 54, 103, 46);
		ap_1_5_1.add(as_1_5_1);
		
		
		
		JButton btnNewButton_4_1_1_1_1_1_1_4 = new JButton("REMOVE");
		btnNewButton_4_1_1_1_1_1_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1_5_1);
				listed[10]=false;
				panel_7.repaint();
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		btnNewButton_4_1_1_1_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1_1_1_1_1_1_4.setBounds(727, 55, 124, 40);
		ap_1_5_1.add(btnNewButton_4_1_1_1_1_1_1_4);
		
		JPanel ap_1_5 = new JPanel();
		ap_1_5.setLayout(null);
		ap_1_5.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1_5);
		
		JLabel al_1_5 = new JLabel("New label");
		al_1_5.setIcon(new ImageIcon(pathMenu[12]));
		al_1_5.setBounds(0, -15, 155, 160);
		ap_1_5.add(al_1_5);
		
		JLabel al2_1_5 = new JLabel(name[11]);
		al2_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_5.setBounds(181, 15, 201, 130);
		ap_1_5.add(al2_1_5);
		
		JLabel al3_1_5 = new JLabel("RM" + df.format(price[11]));
		al3_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_5.setBounds(587, 11, 130, 130);
		ap_1_5.add(al3_1_5);
		
		JSpinner as_1_5 = new JSpinner();
		as_1_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				newTotal = price[11] * (Integer)as_1_5.getValue();	//tukar sini
				al3_1_5.setText("RM " + df.format(newTotal));		//tukar sini
			}
		});
		as_1_5.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_5.setBounds(448, 54, 103, 46);
		ap_1_5.add(as_1_5);
		
		
		
		JButton btnNewButton_4_1_1_1_1_1_1_5 = new JButton("REMOVE");
		btnNewButton_4_1_1_1_1_1_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1_5);
				listed[11]=false;
				panel_7.repaint();
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		btnNewButton_4_1_1_1_1_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1_1_1_1_1_1_5.setBounds(727, 55, 124, 40);
		ap_1_5.add(btnNewButton_4_1_1_1_1_1_1_5);
		
		JPanel ap_1 = new JPanel();
		ap_1.setLayout(null);
		ap_1.setBackground(new Color(245, 222, 179));
		//panel_7.add(ap_1);
		
		JLabel al_1 = new JLabel("New label");
		al_1.setIcon(new ImageIcon(pathMenu[11]));
		al_1.setBounds(1, 0, 155, 160);
		ap_1.add(al_1);
		
		JLabel al2_1 = new JLabel(name[12]);
		al2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1.setBounds(181, 15, 201, 130);
		ap_1.add(al2_1);
		
		JLabel al3_1 = new JLabel("RM" + df.format(price[12]));
		al3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1.setBounds(587, 11, 130, 130);
		ap_1.add(al3_1);
		
		JSpinner as_1 = new JSpinner();
		as_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				newTotal = price[12] * (Integer)as_1.getValue();
				al3_1.setText("RM " + df.format(newTotal));		//tukar sini
			}
		});
		as_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		as_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1.setBounds(448, 54, 103, 46);
		ap_1.add(as_1);
		
		
		JButton btnNewButton_4_1_1_1_1_1_1_6 = new JButton("REMOVE");
		btnNewButton_4_1_1_1_1_1_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.remove(ap_1);
				listed[12]=false;
				panel_7.repaint();
				panel_7.invalidate();
				panel_7.revalidate();
			}
		});
		btnNewButton_4_1_1_1_1_1_1_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1_1_1_1_1_1_6.setBounds(727, 55, 124, 40);
		ap_1.add(btnNewButton_4_1_1_1_1_1_1_6);
		
		
		
		//this is for picture label
				JButton btnNewButton = new JButton("");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1_1);			
						listed[0]=true;
					}
				});
				btnNewButton.setIcon(new ImageIcon(pathMenu[0]));
				btnNewButton.setBounds(20, 10, 152, 145);
				MenuPanel.add(btnNewButton);		
				
				JButton btnNewButton_1 = new JButton("");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1_4);
						listed[1]=true;
					}
				});
				btnNewButton_1.setIcon(new ImageIcon(pathMenu[1]));
				btnNewButton_1.setBounds(202, 10, 152, 145);
				MenuPanel.add(btnNewButton_1);
				
				JButton btnNewButton_1_1 = new JButton("");
				btnNewButton_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1_3_1);
						listed[3]=true;
					}
				});
				btnNewButton_1_1.setIcon(new ImageIcon(pathMenu[2]));
				btnNewButton_1_1.setBounds(568, 10, 152, 145);
				MenuPanel.add(btnNewButton_1_1);
				
				JButton btnNewButton_2 = new JButton("");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1_3);
						listed[2]=true;
						
					}
				});
				btnNewButton_2.setIcon(new ImageIcon(pathMenu[3]));
				btnNewButton_2.setBounds(386, 10, 152, 145);
				MenuPanel.add(btnNewButton_2);
				
				JButton btnNewButton_1_1_1 = new JButton("");
				btnNewButton_1_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1_2_1);
						listed[4]=true;
					}
				});
				btnNewButton_1_1_1.setIcon(new ImageIcon(pathMenu[4]));
				btnNewButton_1_1_1.setBounds(935, 10, 152, 145);
				MenuPanel.add(btnNewButton_1_1_1);
				
				JButton btnNewButton_2_1 = new JButton("");
				btnNewButton_2_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1_2);
						listed[5]=true;
					}
				});
				btnNewButton_2_1.setIcon(new ImageIcon(pathMenu[5]));
				btnNewButton_2_1.setBounds(753, 10, 152, 145);
				MenuPanel.add(btnNewButton_2_1);
				
				JButton btnNewButton_3 = new JButton("");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1_5_1_1_1_1_1);
						listed[6]=true;
					}
				});
				btnNewButton_3.setIcon(new ImageIcon(pathMenu[6]));
				btnNewButton_3.setBounds(20, 261, 152, 145);
				MenuPanel.add(btnNewButton_3);
				
				JButton btnNewButton_1_2 = new JButton("");
				btnNewButton_1_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1_5_1_1_1_1);
						listed[7]=true;
					}
				});
				btnNewButton_1_2.setIcon(new ImageIcon(pathMenu[7]));
				btnNewButton_1_2.setBounds(202, 261, 152, 145);
				MenuPanel.add(btnNewButton_1_2);
				
				JButton btnNewButton_2_2 = new JButton("");
				btnNewButton_2_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1_5_1_1_1);
						listed[8]=true;
					}
				});
				btnNewButton_2_2.setIcon(new ImageIcon(pathMenu[8]));
				btnNewButton_2_2.setBounds(386, 261, 152, 145);
				MenuPanel.add(btnNewButton_2_2);
				
				JButton btnNewButton_1_1_2 = new JButton("");
				btnNewButton_1_1_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1_5_1_1);
						listed[9]=true;
					}
				});
				btnNewButton_1_1_2.setIcon(new ImageIcon(pathMenu[9]));
				btnNewButton_1_1_2.setBounds(568, 261, 152, 145);
				MenuPanel.add(btnNewButton_1_1_2);
				
				JButton btnNewButton_2_1_1 = new JButton("");
				btnNewButton_2_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1_5_1);
						listed[10]=true;
					}
				});
				btnNewButton_2_1_1.setIcon(new ImageIcon(pathMenu[10]));
				btnNewButton_2_1_1.setBounds(753, 261, 152, 145);
				MenuPanel.add(btnNewButton_2_1_1);
				
				JButton btnNewButton_1_1_1_1_1 = new JButton("");
				btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1_5);
						listed[11]=true;
					}
				});
				btnNewButton_1_1_1_1_1.setIcon(new ImageIcon(pathMenu[11]));
				btnNewButton_1_1_1_1_1.setBounds(20, 520, 152, 145);
				MenuPanel.add(btnNewButton_1_1_1_1_1);
				
				JButton btnNewButton_2_1_1_1 = new JButton("");
				btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_7.add(ap_1);
						listed[12]=true;
					}
				});
				btnNewButton_2_1_1_1.setIcon(new ImageIcon(pathMenu[12]));
				btnNewButton_2_1_1_1.setBounds(935, 261, 152, 145);
				MenuPanel.add(btnNewButton_2_1_1_1);
				
				
				orderTransaction = new OrderTransaction();
				//button checkout
				JButton btnNewButton_5 = new JButton("CHECK OUT");
				btnNewButton_5.addActionListener(new ActionListener() {
					

					public void actionPerformed(ActionEvent e) {
						for(int i=0; i<13; i++) {
							if(listed[i]==true) {
								OrderedItem order = new OrderedItem();
								if(i==0) {
									order.setQuantity((Integer)as_1_1.getValue());
									order.setOrderedItem(1);
									order.setItemProduct(name[0]);
									totalOrder = order.getQuantity() * price[0];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
								if(i==1) {
									order.setQuantity((Integer)as_1_4.getValue());
									order.setOrderedItem(2);
									order.setItemProduct(name[1]);
									totalOrder = order.getQuantity() * price[1];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
								if(i==2) {
									order.setQuantity((Integer)as_1_3.getValue());
									order.setOrderedItem(3);
									order.setItemProduct(name[2]);
									totalOrder = order.getQuantity() * price[2];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
								if(i==3) {
									order.setQuantity((Integer)as_1_3_1.getValue());
									order.setOrderedItem(4);
									order.setItemProduct(name[3]);
									totalOrder = order.getQuantity() * price[3];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
								if(i==4) {
									order.setQuantity((Integer)as_1_2_1.getValue());
									order.setOrderedItem(5);
									order.setItemProduct(name[4]);
									totalOrder = order.getQuantity() * price[4];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
								if(i==5) {
									order.setQuantity((Integer)as_1_2.getValue());
									order.setOrderedItem(6);
									order.setItemProduct(name[5]);
									totalOrder = order.getQuantity() * price[5];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
								if(i==6) {
									order.setQuantity((Integer)as_1_5_1_1_1_1_1.getValue());
									order.setOrderedItem(7);
									order.setItemProduct(name[6]);
									totalOrder = order.getQuantity() * price[6];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
								if(i==7) {
									order.setQuantity((Integer)as_1_5_1_1_1_1.getValue());
									order.setOrderedItem(8);
									order.setItemProduct(name[7]);
									totalOrder = order.getQuantity() * price[7];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
								if(i==8) {
									order.setQuantity((Integer)as_1_5_1_1_1.getValue());
									order.setOrderedItem(9);
									order.setItemProduct(name[8]);
									totalOrder = order.getQuantity() * price[8];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
								if(i==9) {
									order.setQuantity((Integer)as_1_5_1_1.getValue());
									order.setOrderedItem(10);
									order.setItemProduct(name[9]);
									totalOrder = order.getQuantity() * price[9];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
								if(i==10) {
									order.setQuantity((Integer)as_1_5_1.getValue());
									order.setOrderedItem(11);
									order.setItemProduct(name[10]);
									totalOrder = order.getQuantity() * price[10];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
								if(i==11) {
									order.setQuantity((Integer)as_1_5.getValue());
									order.setOrderedItem(12);
									order.setItemProduct(name[11]);
									totalOrder = order.getQuantity() * price[11];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
								if(i==12) {
									order.setQuantity((Integer)as_1.getValue());
									order.setOrderedItem(13);
									order.setItemProduct(name[12]);
									totalOrder = order.getQuantity() * price[12];
									totalPrice+=totalOrder;
									order.setSubTotalAmount(totalOrder);
									orderItems.add(order);
								}
							}
						}
						order.setOrderedItems(orderItems);
						order.setTotalAmount(totalPrice);
						
						orderTransaction.setOrder(order);
						orderTransaction.setAmountCharged(totalPrice);
						orderTransaction.setOrderMode(orderMode);
						
						
						tabbedPane.setSelectedIndex(3);
						tabbedPane.setEnabledAt(1,false);
						tabbedPane.setEnabledAt(2,false);
						tabbedPane.setEnabledAt(3,true);
						int x=1;
						for(OrderedItem order:orderItems) {
							textField.append("\n" + x + ". Number Item Product = " + order.getOrderedItem());
							textField.append("\n  Name product = " + order.getItemProduct());
							textField.append("\n  Quantity = " + order.getQuantity());
							textField.append("\n  Price = RM" + df.format(order.getSubTotalAmount()));
							x++;
						}
						
						JLabel lblNewLabel_2 = new JLabel("RM" + df.format(totalPrice));
						lblNewLabel_2.setBounds(889, 256, 242, 39);
						PaymentPanel.add(lblNewLabel_2);
					}
				});
				btnNewButton_5.setBounds(976, 654, 155, 41);
				btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
				CartPanel.add(btnNewButton_5);
				this.orderTransaction = orderTransaction;
				
		
		return MenuPanel;
	}
	public JPanel getPaymentPanel() {
		
		textField = new JTextArea();
		textField.setBackground(SystemColor.text);
		textField.setEditable(false);
		textField.setBounds(120, 35, 470, 670);
		PaymentPanel.add(textField);
		textField.setColumns(10);
		
		
		
		textField.setText("List Order = \n");
		
		
		JLabel lblNewLabel_3 = new JLabel("TOTAL PAYMENT");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(644, 243, 225, 53);
		PaymentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("ENTER CARD NUMBER :");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(644, 331, 178, 53);
		PaymentPanel.add(lblNewLabel_3_1);
		
		CardFill = new JTextField(20);
		CardFill.setBounds(889, 339, 242, 42);
		//CardFill.setOpaque(false)
		PaymentPanel.add(CardFill);
		CardFill.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("CONFIRM");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						release();

						
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_6.setBounds(809, 424, 178, 42);
		PaymentPanel.add(btnNewButton_6);
		
		
		
		return PaymentPanel;
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @param pathMenu2 
	 * @param NameFood2 
	 * @param price2 
	 */
	private void loadComponent() {		//done
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		ItemProduct listFood = new ItemProduct();
		
		tabbedPane.setBackground(Color.PINK);
		tabbedPane.setBounds(0, 0, 1146, 796);
		getContentPane().add(tabbedPane);
		
		//Add panel into frame
		tabbedPane.addTab("HOME", getHomeTab());
		getHomeTab().setLayout(null);
		
		tabbedPane.addTab("MENU", getMenuPanel());
		
		
		tabbedPane.addTab("CART",CartPanel);
		CartPanel.setLayout(null);
		getMenuPanel().setLayout(null);
		
		tabbedPane.addTab("PAYMENT", PaymentPanel);
		getPaymentPanel().setLayout(null);
		
		

		//to set Enabled the home page only
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setEnabledAt(1,false);
		tabbedPane.setEnabledAt(2,false);
		tabbedPane.setEnabledAt(3,false);	
		
		
		
	}


	private JPanel getHomeTab() {	//done
		/**
		 * this is for home panel page
		 */
		JButton DineInButton = new JButton("");
		DineInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				orderMode = "Dine In";
				tabbedPane.setSelectedIndex(1);
				tabbedPane.setEnabledAt(0, false);
				tabbedPane.setEnabledAt(1,true);
				tabbedPane.setEnabledAt(2,true);
			}
		});
		DineInButton.setIcon(new ImageIcon("src/gambar/eat-in.png"));
		DineInButton.setBounds(201, 291, 240, 251);
		HomePanel.add(DineInButton);
		
		JButton TakeAwayButton = new JButton("");
		TakeAwayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				orderMode = "Take Away";
				tabbedPane.setSelectedIndex(1);
				tabbedPane.setEnabledAt(0, false);
				tabbedPane.setEnabledAt(1,true);
				tabbedPane.setEnabledAt(2,true);
				//getMenuPanel();	////go to menu panel
				//System.out.println(orderTrans.getOrderMode());
			}
		});
		TakeAwayButton.setIcon(new ImageIcon("src/gambar/take-away.png"));
		TakeAwayButton.setBounds(657, 291, 240, 251);
		HomePanel.add(TakeAwayButton);
		
		JLabel lblNewLabel = new JLabel("Mc DUNULDU");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
		lblNewLabel.setBounds(320, 44, 491, 95);
		HomePanel.add(lblNewLabel);
		return HomePanel;
		
	}


	public String getCardCreadit() throws InterruptedException {
		waitForInput(); //bila tekan confirm baru jalan
		return CardFill.getText();
	}

	public void setCardCreadit() {
		CardFill.getText();
		//this.CardCreadit = cardCreadit;
	}

	//wait for input
    public void waitForInput() throws InterruptedException {
        synchronized(this) {
            wait();
        }
    }

    //release after button clicked
    public void release() throws InterruptedException {
        synchronized(this) {
            notifyAll();
        }
    }
    public OrderTransaction getOrderTransaction() {
		return this.orderTransaction;
	}

	public void setStatus(boolean status) {
		statusTrans = status;
	}
	
}
