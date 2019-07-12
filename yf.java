package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import save.Hotel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.awt.event.ActionEvent;

public class yf extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField number;
	private JTextField level;
	private JTextField quantity;
	Hotel s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yf frame = new yf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public yf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(28, 40, 105, 23);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u623F\u53F7\uFF1A");
		label_1.setBounds(28, 103, 105, 35);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7B49\u7EA7");
		label_2.setBounds(28, 178, 105, 35);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u4EBA\u6570");
		label_3.setBounds(28, 253, 112, 35);
		contentPane.add(label_3);
		
		name = new JTextField();
		name.setBounds(285, 47, 129, 23);
		contentPane.add(name);
		name.setColumns(10);
		
		number = new JTextField();
		number.setBounds(285, 117, 129, 21);
		contentPane.add(number);
		number.setColumns(10);
		
		level = new JTextField();
		level.setBounds(285, 185, 129, 23);
		contentPane.add(level);
		level.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(285, 253, 129, 23);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JButton button = new JButton("\u4FDD\u5B58");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				s=new Hotel(name.getText(),number.getText(),level.getText(),quantity.getText());
				String path="d:/¾ÆµêÎÄ¼þ´¢´æ/hotel.txt";
				File f=new File(path);
				Writer out =null;
				
				try {
					out=new FileWriter(f);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					out.write(s.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(s.toString());
			}
		});
		button.setBounds(28, 298, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		button_1.setBounds(317, 298, 97, 23);
		contentPane.add(button_1);
	}
}
