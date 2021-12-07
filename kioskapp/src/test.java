import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;

import java.awt.ScrollPane;

public class test {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.RED);
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 1160, 843);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.PINK);
		tabbedPane.setBounds(0, 0, 1146, 796);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("HOME", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\eat-in.png"));
		btnNewButton_4.setBounds(201, 291, 240, 251);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("");
		btnNewButton_4_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\take-away.png"));
		btnNewButton_4_1.setBounds(657, 291, 240, 251);
		panel.add(btnNewButton_4_1);
		
		JLabel lblNewLabel = new JLabel("Mc DUNULDU");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
		lblNewLabel.setBounds(320, 44, 491, 95);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("MENU", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\ayam mcd 2pc.png"));
		btnNewButton.setBounds(20, 10, 152, 145);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\ayam mcd 5pc.png"));
		btnNewButton_1.setBounds(202, 10, 152, 145);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\filet-o-fish.png"));
		btnNewButton_1_1.setBounds(568, 10, 152, 145);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\mc chicken.png"));
		btnNewButton_2.setBounds(386, 10, 152, 145);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\product-double-cheeseburger.png"));
		btnNewButton_1_1_1.setBounds(935, 10, 152, 145);
		panel_1.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\product-big-mac.png"));
		btnNewButton_2_1.setBounds(753, 10, 152, 145);
		panel_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\spicy chic deluxe.png"));
		btnNewButton_3.setBounds(20, 261, 152, 145);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\fof meal.png"));
		btnNewButton_1_2.setBounds(202, 261, 152, 145);
		panel_1.add(btnNewButton_1_2);
		
		JButton btnNewButton_2_2 = new JButton("");
		btnNewButton_2_2.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\mc chcken meal.png"));
		btnNewButton_2_2.setBounds(386, 261, 152, 145);
		panel_1.add(btnNewButton_2_2);
		
		JButton btnNewButton_1_1_2 = new JButton("");
		btnNewButton_1_1_2.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\nugget.jfif.png"));
		btnNewButton_1_1_2.setBounds(568, 261, 152, 145);
		panel_1.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_2_1_1 = new JButton("");
		btnNewButton_2_1_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\mcd-meals-chicken-mcnuggets.png"));
		btnNewButton_2_1_1.setBounds(753, 261, 152, 145);
		panel_1.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\product-strawberry-sundae.png"));
		btnNewButton_1_1_1_1_1.setBounds(20, 520, 152, 145);
		panel_1.add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("");
		btnNewButton_2_1_1_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\product-hot-fudge-sundae.png"));
		btnNewButton_2_1_1_1.setBounds(935, 261, 152, 145);
		panel_1.add(btnNewButton_2_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ayam Goreng McD 2pcs");
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 165, 142, 35);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ayam Goreng McD 5pcs");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setBounds(212, 165, 142, 35);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("McChicken");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_2.setBounds(426, 165, 95, 35);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Filet-O-Fish");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_3.setBounds(608, 165, 87, 35);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Big Mac");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_4.setBounds(793, 165, 69, 35);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Double Cheeseburger");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_5.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_5.setBounds(945, 165, 142, 35);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Spicy Chicken McDeluxe");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_6.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_6.setBounds(30, 405, 142, 35);
		panel_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Filet-O-Fish Meal (Medium)");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1.setBounds(212, 405, 142, 35);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("McChicken Meal (Medium)");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_2_1.setBounds(396, 405, 142, 35);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Chicken McNuggets(6pcs)");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_3_1.setBounds(578, 405, 142, 35);
		panel_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Chicken McNuggets Meal");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_4_1.setBounds(753, 405, 172, 35);
		panel_1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Chocolate Sundae");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_5_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_5_1.setBounds(945, 405, 142, 35);
		panel_1.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Strawberry Sundae");
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_6_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_6_1.setBounds(30, 663, 142, 35);
		panel_1.add(lblNewLabel_1_6_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 602, 1141, -596);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_1_7 = new JLabel("RM11.9");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7.setBounds(68, 198, 54, 35);
		panel_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("RM30.2");
		lblNewLabel_1_7_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_1.setBounds(255, 198, 54, 35);
		panel_1.add(lblNewLabel_1_7_1);
		
		JLabel lblNewLabel_1_7_2 = new JLabel("RM8.1");
		lblNewLabel_1_7_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_2.setBounds(440, 198, 54, 35);
		panel_1.add(lblNewLabel_1_7_2);
		
		JLabel lblNewLabel_1_7_3 = new JLabel("RM8.45");
		lblNewLabel_1_7_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_3.setBounds(620, 198, 54, 35);
		panel_1.add(lblNewLabel_1_7_3);
		
		JLabel lblNewLabel_1_7_4 = new JLabel("RM10.4");
		lblNewLabel_1_7_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_4.setBounds(806, 198, 54, 35);
		panel_1.add(lblNewLabel_1_7_4);
		
		JLabel lblNewLabel_1_7_5 = new JLabel("RM9.45");
		lblNewLabel_1_7_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_5.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_5.setBounds(987, 198, 54, 35);
		panel_1.add(lblNewLabel_1_7_5);
		
		JLabel lblNewLabel_1_7_6 = new JLabel("RM11.9");
		lblNewLabel_1_7_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_6.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_6.setBounds(68, 433, 54, 35);
		panel_1.add(lblNewLabel_1_7_6);
		
		JLabel lblNewLabel_1_7_1_1 = new JLabel("RM13");
		lblNewLabel_1_7_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_1_1.setBounds(255, 433, 54, 35);
		panel_1.add(lblNewLabel_1_7_1_1);
		
		JLabel lblNewLabel_1_7_2_1 = new JLabel("RM13.2");
		lblNewLabel_1_7_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_2_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_2_1.setBounds(440, 433, 54, 35);
		panel_1.add(lblNewLabel_1_7_2_1);
		
		JLabel lblNewLabel_1_7_3_1 = new JLabel("RM9.4");
		lblNewLabel_1_7_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_3_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_3_1.setBounds(620, 433, 54, 35);
		panel_1.add(lblNewLabel_1_7_3_1);
		
		JLabel lblNewLabel_1_7_4_1 = new JLabel("RM13.2");
		lblNewLabel_1_7_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_4_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_4_1.setBounds(806, 433, 54, 35);
		panel_1.add(lblNewLabel_1_7_4_1);
		
		JLabel lblNewLabel_1_7_5_1 = new JLabel("RM4.15");
		lblNewLabel_1_7_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_5_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_5_1.setBounds(987, 433, 54, 35);
		panel_1.add(lblNewLabel_1_7_5_1);
		
		JLabel lblNewLabel_1_7_6_1 = new JLabel("RM4.15");
		lblNewLabel_1_7_6_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7_6_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_7_6_1.setBounds(68, 689, 54, 35);
		panel_1.add(lblNewLabel_1_7_6_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("CART", null, panel_2, null);
		panel_2.setLayout(null);
		
	
		
		JButton btnNewButton_5 = new JButton("CHECK OUT");
		btnNewButton_5.setBounds(899, 654, 155, 41);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(btnNewButton_5);
		
		JScrollPane CartScrollPanel = new JScrollPane();
		CartScrollPanel.setBounds(29, 35, 767, 660);
		panel_2.add(CartScrollPanel);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_7.setBackground(new Color(255, 235, 205));
		panel_7.setPreferredSize(new Dimension (500,1800));
		CartScrollPanel.setViewportView(panel_7);
		panel_7.setLayout(new GridLayout(13, 0, 0, 0));
		
		JPanel ap_1_1 = new JPanel();
		ap_1_1.setLayout(null);
		ap_1_1.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1_1);
		
		JLabel al_1_1 = new JLabel("New label");
		al_1_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\ayam mcd 2pc.png"));
		al_1_1.setBounds(1, 0, 155, 160);
		ap_1_1.add(al_1_1);
		
		JLabel al2_1_1 = new JLabel("Ayam Goreng Mcd 2pcs");
		al2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_1.setBounds(181, 15, 201, 130);
		ap_1_1.add(al2_1_1);
		
		JSpinner as_1_1 = new JSpinner();
		as_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_1.setBounds(448, 54, 103, 46);
		ap_1_1.add(as_1_1);
		
		JLabel al3_1_1 = new JLabel("RM 11.90");
		al3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_1.setBounds(587, 11, 130, 130);
		ap_1_1.add(al3_1_1);
		
		JPanel ap_1_4 = new JPanel();
		ap_1_4.setLayout(null);
		ap_1_4.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1_4);
		
		JLabel al_1_4 = new JLabel("New label");
		al_1_4.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\ayam mcd 5pc.png"));
		al_1_4.setBounds(0, -22, 155, 160);
		ap_1_4.add(al_1_4);
		
		JLabel al2_1_4 = new JLabel("Ayam Goreng Mcd 5pcs");
		al2_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_4.setBounds(181, 15, 201, 130);
		ap_1_4.add(al2_1_4);
		
		JSpinner as_1_4 = new JSpinner();
		as_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_4.setBounds(448, 54, 103, 46);
		ap_1_4.add(as_1_4);
		
		JLabel al3_1_4 = new JLabel("RM 30.20");
		al3_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_4.setBounds(587, 11, 130, 130);
		ap_1_4.add(al3_1_4);
		
		JPanel ap_1_3 = new JPanel();
		ap_1_3.setLayout(null);
		ap_1_3.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1_3);
		
		JLabel al_1_3 = new JLabel("New label");
		al_1_3.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\mc chicken.png"));
		al_1_3.setBounds(0, -15, 155, 160);
		ap_1_3.add(al_1_3);
		
		JLabel al2_1_3 = new JLabel("McChicken");
		al2_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_3.setBounds(181, 15, 201, 130);
		ap_1_3.add(al2_1_3);
		
		JSpinner as_1_3 = new JSpinner();
		as_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_3.setBounds(448, 54, 103, 46);
		ap_1_3.add(as_1_3);
		
		JLabel al3_1_3 = new JLabel("RM 8.10");
		al3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_3.setBounds(587, 11, 130, 130);
		ap_1_3.add(al3_1_3);
		
		JPanel ap_1_3_1 = new JPanel();
		ap_1_3_1.setLayout(null);
		ap_1_3_1.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1_3_1);
		
		JLabel al_1_3_1 = new JLabel("New label");
		al_1_3_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\product-double-cheeseburger.png"));
		al_1_3_1.setBounds(0, -15, 155, 160);
		ap_1_3_1.add(al_1_3_1);
		
		JLabel al2_1_3_1 = new JLabel("Double Cheeseburger");
		al2_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_3_1.setBounds(181, 15, 201, 130);
		ap_1_3_1.add(al2_1_3_1);
		
		JSpinner as_1_3_1 = new JSpinner();
		as_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_3_1.setBounds(448, 54, 103, 46);
		ap_1_3_1.add(as_1_3_1);
		
		JLabel al3_1_3_1 = new JLabel("RM 9.45");
		al3_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_3_1.setBounds(587, 11, 130, 130);
		ap_1_3_1.add(al3_1_3_1);
		
		JPanel ap_1_2_1 = new JPanel();
		ap_1_2_1.setLayout(null);
		ap_1_2_1.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1_2_1);
		
		JLabel al_1_2_1 = new JLabel("New label");
		al_1_2_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\spicy chic deluxe.png"));
		al_1_2_1.setBounds(0, -22, 155, 160);
		ap_1_2_1.add(al_1_2_1);
		
		JLabel al2_1_2_1 = new JLabel("Chicken McDeluxe");
		al2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_2_1.setBounds(181, 15, 201, 130);
		ap_1_2_1.add(al2_1_2_1);
		
		JSpinner as_1_2_1 = new JSpinner();
		as_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_2_1.setBounds(448, 54, 103, 46);
		ap_1_2_1.add(as_1_2_1);
		
		JLabel al3_1_2_1 = new JLabel("RM 11.90");
		al3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_2_1.setBounds(587, 11, 130, 130);
		ap_1_2_1.add(al3_1_2_1);
		
		JPanel ap_1_2 = new JPanel();
		ap_1_2.setLayout(null);
		ap_1_2.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1_2);
		
		JLabel al_1_2 = new JLabel("New label");
		al_1_2.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\filet-o-fish.png"));
		al_1_2.setBounds(0, -22, 155, 160);
		ap_1_2.add(al_1_2);
		
		JLabel al2_1_2 = new JLabel("Fillet-O-Fish");
		al2_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_2.setBounds(181, 15, 201, 130);
		ap_1_2.add(al2_1_2);
		
		JSpinner as_1_2 = new JSpinner();
		as_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_2.setBounds(448, 54, 103, 46);
		ap_1_2.add(as_1_2);
		
		JLabel al3_1_2 = new JLabel("RM 8.45");
		al3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_2.setBounds(587, 11, 130, 130);
		ap_1_2.add(al3_1_2);
		
		JPanel ap_1_5_1_1_1_1_1 = new JPanel();
		ap_1_5_1_1_1_1_1.setLayout(null);
		ap_1_5_1_1_1_1_1.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1_5_1_1_1_1_1);
		
		JLabel al_1_5_1_1_1_1_1 = new JLabel("New label");
		al_1_5_1_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\product-big-mac.png"));
		al_1_5_1_1_1_1_1.setBounds(0, -11, 155, 160);
		ap_1_5_1_1_1_1_1.add(al_1_5_1_1_1_1_1);
		
		JLabel al2_1_5_1_1_1_1_1 = new JLabel("Big Mac");
		al2_1_5_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_5_1_1_1_1_1.setBounds(181, 15, 216, 130);
		ap_1_5_1_1_1_1_1.add(al2_1_5_1_1_1_1_1);
		
		JSpinner as_1_5_1_1_1_1_1 = new JSpinner();
		as_1_5_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_5_1_1_1_1_1.setBounds(448, 54, 103, 46);
		ap_1_5_1_1_1_1_1.add(as_1_5_1_1_1_1_1);
		
		JLabel al3_1_5_1_1_1_1_1 = new JLabel("RM 10.40");
		al3_1_5_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_5_1_1_1_1_1.setBounds(587, 11, 130, 130);
		ap_1_5_1_1_1_1_1.add(al3_1_5_1_1_1_1_1);
		
		JPanel ap_1_5_1_1_1_1 = new JPanel();
		ap_1_5_1_1_1_1.setLayout(null);
		ap_1_5_1_1_1_1.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1_5_1_1_1_1);
		
		JLabel al_1_5_1_1_1_1 = new JLabel("New label");
		al_1_5_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\fof meal.png"));
		al_1_5_1_1_1_1.setBounds(0, -11, 155, 160);
		ap_1_5_1_1_1_1.add(al_1_5_1_1_1_1);
		
		JLabel al2_1_5_1_1_1_1 = new JLabel("Fillet-O-fish Meal (Medium)");
		al2_1_5_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_5_1_1_1_1.setBounds(181, 15, 216, 130);
		ap_1_5_1_1_1_1.add(al2_1_5_1_1_1_1);
		
		JSpinner as_1_5_1_1_1_1 = new JSpinner();
		as_1_5_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_5_1_1_1_1.setBounds(448, 54, 103, 46);
		ap_1_5_1_1_1_1.add(as_1_5_1_1_1_1);
		
		JLabel al3_1_5_1_1_1_1 = new JLabel("RM 13.00");
		al3_1_5_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_5_1_1_1_1.setBounds(587, 11, 130, 130);
		ap_1_5_1_1_1_1.add(al3_1_5_1_1_1_1);
		
		JPanel ap_1_5_1_1_1 = new JPanel();
		ap_1_5_1_1_1.setLayout(null);
		ap_1_5_1_1_1.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1_5_1_1_1);
		
		JLabel al_1_5_1_1_1 = new JLabel("New label");
		al_1_5_1_1_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\mc chcken meal.png"));
		al_1_5_1_1_1.setBounds(0, -11, 155, 160);
		ap_1_5_1_1_1.add(al_1_5_1_1_1);
		
		JLabel al2_1_5_1_1_1 = new JLabel("McChicken Meal (Medium)");
		al2_1_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_5_1_1_1.setBounds(181, 15, 216, 130);
		ap_1_5_1_1_1.add(al2_1_5_1_1_1);
		
		JSpinner as_1_5_1_1_1 = new JSpinner();
		as_1_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_5_1_1_1.setBounds(448, 54, 103, 46);
		ap_1_5_1_1_1.add(as_1_5_1_1_1);
		
		JLabel al3_1_5_1_1_1 = new JLabel("RM 13.20");
		al3_1_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_5_1_1_1.setBounds(587, 11, 130, 130);
		ap_1_5_1_1_1.add(al3_1_5_1_1_1);
		
		JPanel ap_1_5_1_1 = new JPanel();
		ap_1_5_1_1.setLayout(null);
		ap_1_5_1_1.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1_5_1_1);
		
		JLabel al_1_5_1_1 = new JLabel("New label");
		al_1_5_1_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\nugget.jfif.png"));
		al_1_5_1_1.setBounds(0, -11, 155, 160);
		ap_1_5_1_1.add(al_1_5_1_1);
		
		JLabel al2_1_5_1_1 = new JLabel("Chicken McNugget 6pcs");
		al2_1_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_5_1_1.setBounds(181, 15, 201, 130);
		ap_1_5_1_1.add(al2_1_5_1_1);
		
		JSpinner as_1_5_1_1 = new JSpinner();
		as_1_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_5_1_1.setBounds(448, 54, 103, 46);
		ap_1_5_1_1.add(as_1_5_1_1);
		
		JLabel al3_1_5_1_1 = new JLabel("RM 9.40");
		al3_1_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_5_1_1.setBounds(587, 11, 130, 130);
		ap_1_5_1_1.add(al3_1_5_1_1);
		
		JPanel ap_1_5_1 = new JPanel();
		ap_1_5_1.setLayout(null);
		ap_1_5_1.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1_5_1);
		
		JLabel al_1_5_1 = new JLabel("New label");
		al_1_5_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\mcd-meals-chicken-mcnuggets.png"));
		al_1_5_1.setBounds(0, -11, 155, 160);
		ap_1_5_1.add(al_1_5_1);
		
		JLabel al2_1_5_1 = new JLabel("Chicken McNugget Meal");
		al2_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_5_1.setBounds(181, 15, 201, 130);
		ap_1_5_1.add(al2_1_5_1);
		
		JSpinner as_1_5_1 = new JSpinner();
		as_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_5_1.setBounds(448, 54, 103, 46);
		ap_1_5_1.add(as_1_5_1);
		
		JLabel al3_1_5_1 = new JLabel("RM 13.20");
		al3_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_5_1.setBounds(587, 11, 130, 130);
		ap_1_5_1.add(al3_1_5_1);
		
		JPanel ap_1_5 = new JPanel();
		ap_1_5.setLayout(null);
		ap_1_5.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1_5);
		
		JLabel al_1_5 = new JLabel("New label");
		al_1_5.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\product-hot-fudge-sundae.png"));
		al_1_5.setBounds(0, -15, 155, 160);
		ap_1_5.add(al_1_5);
		
		JLabel al2_1_5 = new JLabel("Chocolate Sundae");
		al2_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1_5.setBounds(181, 15, 201, 130);
		ap_1_5.add(al2_1_5);
		
		JSpinner as_1_5 = new JSpinner();
		as_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1_5.setBounds(448, 54, 103, 46);
		ap_1_5.add(as_1_5);
		
		JLabel al3_1_5 = new JLabel("RM 4.15");
		al3_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1_5.setBounds(587, 11, 130, 130);
		ap_1_5.add(al3_1_5);
		
		JPanel ap_1 = new JPanel();
		ap_1.setLayout(null);
		ap_1.setBackground(new Color(245, 222, 179));
		panel_7.add(ap_1);
		
		JLabel al_1 = new JLabel("New label");
		al_1.setIcon(new ImageIcon("C:\\Users\\Nur Fatin\\assignment2\\picture\\product-strawberry-sundae.png"));
		al_1.setBounds(1, 0, 155, 160);
		ap_1.add(al_1);
		
		JLabel al2_1 = new JLabel("Strawberry Sundae");
		al2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		al2_1.setBounds(181, 15, 201, 130);
		ap_1.add(al2_1);
		
		JSpinner as_1 = new JSpinner();
		as_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		as_1.setBounds(448, 54, 103, 46);
		ap_1.add(as_1);
		
		JLabel al3_1 = new JLabel("RM 4.15");
		al3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al3_1.setBounds(587, 11, 130, 130);
		ap_1.add(al3_1);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL PRICE :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(806, 286, 185, 41);
		panel_2.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(962, 286, 155, 34);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("PAYMENT", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(31, 46, 544, 646);
		panel_3.add(textPane_1);
		
		JLabel lblNewLabel_3 = new JLabel("TOTAL PAYMENT");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(691, 215, 225, 53);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("4 DIGIT CARD NUMBER :");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(773, 352, 178, 53);
		panel_3.add(lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(773, 407, 166, 42);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("PROCEED PAYMENT");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_6.setBounds(773, 513, 178, 27);
		panel_3.add(btnNewButton_6);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(895, 215, 166, 42);
		panel_3.add(textField_2);
		
		JButton btnNewButton_6_1 = new JButton("CANCEL ORDER");
		btnNewButton_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_6_1.setBounds(773, 557, 178, 27);
		panel_3.add(btnNewButton_6_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("RECEIPT", null, panel_4, null);
		panel_4.setLayout(null);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(236, 42, 633, 614);
		panel_4.add(textPane_2);
		
		JButton btnNewButton_7 = new JButton("EXIT");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_7.setBounds(957, 717, 161, 42);
		panel_4.add(btnNewButton_7);
	}
}
