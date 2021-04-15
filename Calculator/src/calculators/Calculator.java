package calculators;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator {

	private JFrame frame;
	private JTextField SUMM;
	private JTextField NDS;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JTextField itog;
	
	double a;
	double b;
	double result;
	String answer;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Главный фрейм где мы будем создавать наш калькулятор
		frame = new JFrame();
		frame.setTitle("\u041A\u0430\u043B\u044C\u043A\u0443\u043B\u044F\u0442\u043E\u0440 \u041D\u0414\u0421");
		frame.setBounds(100, 100, 340, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// строка ввода данных суммы
		SUMM = new JTextField();
		SUMM.setHorizontalAlignment(SwingConstants.RIGHT);
		SUMM.setBounds(154, 11, 160, 30);
		frame.getContentPane().add(SUMM);
		SUMM.setColumns(10);
		
		// кнопка для проведения расчёта по начислению НДС
		JButton btncalc = new JButton("\u041D\u0430\u0447\u0438\u0441\u043B\u0438\u0442\u044C \u041D\u0414\u0421");
		btncalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer;
				a = Double.parseDouble(SUMM.getText());
				b = Double.parseDouble(NDS.getText());
				result = a * b / 100; //формула для начисления НДС
				answer = String.format("%.5f",result);
				itog.setText(answer);
			}
		});
		btncalc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btncalc.setBounds(10, 93, 150, 30);
		frame.getContentPane().add(btncalc);
		
		// строка ввода процента НДС
		NDS = new JTextField();
		NDS.setHorizontalAlignment(SwingConstants.RIGHT);
		NDS.setBounds(234, 52, 80, 30);
		frame.getContentPane().add(NDS);
		NDS.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0421\u0443\u043C\u043C\u0430");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(81, 8, 63, 30);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u0421\u0442\u0430\u0432\u043A\u0430 \u041D\u0414\u0421 \u0432 %");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(70, 52, 160, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		// кнопка для проведения расчёта по выделению НДС
		btnNewButton = new JButton("\u0412\u044B\u0434\u0435\u043B\u0438\u0442\u044C \u041D\u0414\u0421");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer;
				a = Double.parseDouble(SUMM.getText());
				b = Double.parseDouble(NDS.getText());
				result = -1 * (a / (1 + b / 100) - a); // формула для выделения НДС
				answer = String.format("%.5f",result);
				itog.setText(answer);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(164, 93, 150, 30);
		frame.getContentPane().add(btnNewButton);
		
		// строка для вывода ответа
		itog = new JTextField();
		itog.setBounds(70, 134, 180, 30);
		frame.getContentPane().add(itog);
		itog.setColumns(10);
	}
}
