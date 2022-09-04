package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Main {

	private JFrame frmCalculadora;
	private JButton btn0;
	private JButton btndot;
	private JButton btnporc;
	private JButton btnadd;
	private JButton btneq;
	private JTextField textField;
		
	double firstNumber;
	double secondNumber;
	double result;
	String operation;
	private JTextField showResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmCalculadora.setVisible(true);
					window.frmCalculadora.setResizable(false);
					window.frmCalculadora.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadora = new JFrame();
		frmCalculadora.setTitle("Calculadora");
		frmCalculadora.getContentPane().setBackground(Color.BLACK);
		frmCalculadora.setBounds(100, 100, 344, 460);
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadora.getContentPane().setLayout(null);
		
		btn0 = new JButton("0");
		btn0.setForeground(Color.WHITE);
		btn0.setBackground(Color.BLACK);
		btn0.setBorderPainted(false);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField.getText() + btn0.getText(); 
				textField.setText(number);
			}
		});
		btn0.setBounds(24, 340, 46, 48);
		frmCalculadora.getContentPane().add(btn0);
		
		btndot = new JButton(".");
		btndot.setFont(new Font("Dialog", Font.BOLD, 14));
		btndot.setBackground(Color.BLACK);
		btndot.setForeground(Color.WHITE);
		btndot.setBorderPainted(false);
		btndot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField.getText() + btndot.getText(); 
				textField.setText(number);
			}
		});
		btndot.setBounds(102, 340, 46, 48);
		frmCalculadora.getContentPane().add(btndot);
		
		btnporc = new JButton("%");
		btnporc.setFont(new Font("Dialog", Font.BOLD, 12));
		btnporc.setForeground(Color.WHITE);
		btnporc.setBackground(Color.BLACK);
		btnporc.setBorderPainted(false);
		btnporc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText("");
				
				operation = "%";
			}
		});
		btnporc.setBounds(102, 93, 46, 48);
		frmCalculadora.getContentPane().add(btnporc);
		
		btnadd = new JButton("+");
		btnadd.setFont(new Font("Dialog", Font.BOLD, 14));
		btnadd.setForeground(Color.WHITE);
		btnadd.setBackground(Color.BLACK);
		btnadd.setBorderPainted(false);
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText("");
				
				operation = "+";
			}
		});
		btnadd.setBounds(180, 93, 46, 48);
		frmCalculadora.getContentPane().add(btnadd);
		
		btneq = new JButton("=");
		btneq.setFont(new Font("Dialog", Font.BOLD, 14));
		btneq.setForeground(Color.WHITE);
		btneq.setBackground(Color.BLACK);
		btneq.setBorderPainted(false);
		btneq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				secondNumber = Double.parseDouble(textField.getText());
				
				if(operation == "+") {
					result = firstNumber + secondNumber;
					String answer = String.format("%.2f", firstNumber) +
									" + " +
									String.format("%.2f", secondNumber) +
									" = " +
									String.format("%.2f", result);
					
					showResult.setText(answer);
					textField.setText(String.format("%.2f", result));
			
				}
				if(operation == "-") {
					result = firstNumber - secondNumber;
					String answer = String.format("%.2f", firstNumber) +
									" - " +
									String.format("%.2f", secondNumber) +
									" = " +
									String.format("%.2f", result);
					
					showResult.setText(answer);
					textField.setText(String.format("%.2f", result));
				}
				if(operation == "*") {
					result = firstNumber * secondNumber;
					String answer = String.format("%.2f", firstNumber) +
									" * " +
									String.format("%.2f", secondNumber) +
									" = " +
									String.format("%.2f", result);
					
					showResult.setText(answer);
					textField.setText(String.format("%.2f", result));
				}
				if(operation == "/") {
					result = firstNumber / secondNumber;
					String answer = String.format("%.2f", firstNumber) +
									" / " +
									String.format("%.2f", secondNumber) +
									" = " +
									String.format("%.2f", result);
					
					showResult.setText(answer);
					textField.setText(String.format("%.2f", result));
				}
				if(operation == "%") {
					result = (firstNumber / 100) * secondNumber;
					String answer = String.format("%.2f", firstNumber) +
									" % " +
									String.format("%.2f", secondNumber) +
									" = " +
									String.format("%.2f", result);
					
					showResult.setText(answer);
					textField.setText(String.format("%.2f", result));
				}
				
			}
		});
		btneq.setBounds(180, 340, 46, 48);
		frmCalculadora.getContentPane().add(btneq);
		
		textField = new JTextField();
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(24, 23, 98, 34);
		textField.setBorder(null);
		frmCalculadora.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Dialog", Font.BOLD, 14));
		btn1.setForeground(Color.WHITE);
		btn1.setBackground(Color.BLACK);
		btn1.setBorderPainted(false);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField.getText() + btn1.getText(); 
				textField.setText(number);
			}
		});
		btn1.setBounds(24, 274, 46, 48);
		frmCalculadora.getContentPane().add(btn1);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Dialog", Font.BOLD, 14));
		btn4.setForeground(Color.WHITE);
		btn4.setBackground(Color.BLACK);
		btn4.setBorderPainted(false);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField.getText() + btn4.getText(); 
				textField.setText(number);
			}
		});
		btn4.setBounds(24, 211, 46, 48);
		frmCalculadora.getContentPane().add(btn4);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Dialog", Font.BOLD, 14));
		btn7.setForeground(Color.WHITE);
		btn7.setBackground(Color.BLACK);
		btn7.setBorderPainted(false);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField.getText() + btn7.getText(); 
				textField.setText(number);
			}
		});
		btn7.setBounds(24, 153, 46, 48);
		frmCalculadora.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Dialog", Font.BOLD, 14));
		btn8.setForeground(Color.WHITE);
		btn8.setBackground(Color.BLACK);
		btn8.setBorderPainted(false);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField.getText() + btn8.getText(); 
				textField.setText(number);
			}
		});
		btn8.setBounds(102, 153, 46, 48);
		frmCalculadora.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Dialog", Font.BOLD, 14));
		btn9.setBackground(Color.BLACK);
		btn9.setForeground(Color.WHITE);
		btn9.setBorderPainted(false);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField.getText() + btn9.getText(); 
				textField.setText(number);
			}
		});
		btn9.setBounds(180, 153, 46, 48);
		frmCalculadora.getContentPane().add(btn9);
		
		JButton btndiv = new JButton("/");
		btndiv.setFont(new Font("Dialog", Font.BOLD, 14));
		btndiv.setForeground(Color.WHITE);
		btndiv.setBackground(Color.BLACK);
		btndiv.setBorderPainted(false);
		btndiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText("");
				
				operation = "/";
			}
		});
		btndiv.setBounds(247, 93, 46, 48);
		frmCalculadora.getContentPane().add(btndiv);
		
		JButton btn2 = new JButton("2");
		
		btn2.setForeground(Color.WHITE);
		btn2.setBackground(Color.BLACK);
		btn2.setBorderPainted(false);
		btn2.setFont(new Font("Dialog", Font.BOLD, 14));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField.getText() + btn2.getText(); 
				textField.setText(number);
			}
		});
		btn2.setBounds(102, 274, 46, 48);
		frmCalculadora.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Dialog", Font.BOLD, 14));
		btn3.setForeground(Color.WHITE);
		btn3.setBackground(Color.BLACK);
		btn3.setBorderPainted(false);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField.getText() + btn3.getText(); 
				textField.setText(number);
			}
		});
		btn3.setBounds(180, 274, 46, 48);
		frmCalculadora.getContentPane().add(btn3);
		
		JButton btnsub = new JButton("-");
		btnsub.setFont(new Font("Dialog", Font.BOLD, 14));
		btnsub.setForeground(Color.WHITE);
		btnsub.setBackground(Color.BLACK);
		btnsub.setBorderPainted(false);
		btnsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText("");
				
				operation = "-";
			}
		});
		btnsub.setBounds(247, 211, 46, 48);
		frmCalculadora.getContentPane().add(btnsub);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Dialog", Font.BOLD, 14));
		btn5.setForeground(Color.WHITE);
		btn5.setBackground(Color.BLACK);
		btn5.setBorderPainted(false);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField.getText() + btn5.getText(); 
				textField.setText(number);
			}
		});
		btn5.setBounds(102, 211, 46, 48);
		frmCalculadora.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setForeground(Color.WHITE);
		btn6.setBackground(Color.BLACK);
		btn6.setBorderPainted(false);
		btn6.setFont(new Font("Dialog", Font.BOLD, 14));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField.getText() + btn6.getText(); 
				textField.setText(number);
			}
		});
		btn6.setBounds(180, 211, 46, 48);
		frmCalculadora.getContentPane().add(btn6);
		
		JButton btnmult = new JButton("*");
		btnmult.setFont(new Font("Dialog", Font.BOLD, 14));
		btnmult.setForeground(Color.WHITE);
		btnmult.setBackground(Color.BLACK);
		btnmult.setBorderPainted(false);
		btnmult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText("");
				operation = "*";
			}
		});
		btnmult.setBounds(247, 153, 46, 48);
		frmCalculadora.getContentPane().add(btnmult);
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Dialog", Font.BOLD, 14));
		btnC.setForeground(Color.WHITE);
		btnC.setBackground(Color.BLACK);
		btnC.setBorderPainted(false);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
			}
		});
		btnC.setBounds(24, 93, 46, 48);
		frmCalculadora.getContentPane().add(btnC);
		
		showResult = new JTextField();
		showResult.setForeground(Color.WHITE);
		showResult.setBackground(Color.BLACK);
		showResult.setFont(new Font("Dialog", Font.PLAIN, 14));
		showResult.setBounds(140, 23, 192, 34);
		showResult.setBorder(null);
		frmCalculadora.getContentPane().add(showResult);
		showResult.setColumns(10);
	}
}