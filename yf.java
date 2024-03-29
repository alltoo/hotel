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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;

public class yf extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField number;
	private JTextField quantity;
	private JComboBox cblevel;
	private JList list;
	Hotel s;
	String major;
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
	public yf() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 496);
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
		name.setBounds(113, 40, 129, 23);
		contentPane.add(name);
		name.setColumns(10);
		
		number = new JTextField();
		number.setBounds(113, 117, 129, 21);
		contentPane.add(number);
		number.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(113, 259, 129, 23);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JButton button = new JButton("\u4FDD\u5B58");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String le= (String) cblevel.getSelectedItem();
				s=new Hotel(name.getText(),number.getText(),le,quantity.getText());
				String path="d:/酒店文件储存/hotel.txt";
				//定义文件的储存路径；
				File f=new File(path);
				Writer out =null;
				//写文件；
				try {
					out=new FileWriter(f,true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					out.write(s.toSaveString());
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
		button_1.setBounds(177, 344, 97, 23);
		contentPane.add(button_1);
		
		 cblevel = new JComboBox();
		 cblevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		String path="d:/酒店文件储存/level.txt";
		//读文件；
		
		try {
			FileReader fr=new FileReader(path);
			BufferedReader bf=new BufferedReader(fr);
			
			
				while((major=bf.readLine())!=null) {
					cblevel.addItem(major);
				}
				//循环读文件，直到null；
			bf.close();
			fr.close();
			//关闭文件
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();//解决了文件找不到的异常；
		}
		
		/*comboBox.addItem("A");
		comboBox.addItem("B");
		comboBox.addItem("C");*/
		cblevel.setBounds(113, 184, 129, 29);
		contentPane.add(cblevel);
		
		JButton button_2 = new JButton("\u6E05\u7A7A");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 name.setText("");
				 number.setText(""); 
				// level.setText("");
				 quantity.setText("");
			}
		});
		button_2.setBounds(177, 298, 97, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("读取");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("456");
		
				String path="d:/酒店文件储存/hotel.txt";
				//读文件；
				ArrayList<String> infors =new ArrayList<String>();
				try {
					FileReader fr=new FileReader(path);
					BufferedReader bf=new BufferedReader(fr);
					String show  ; 
					
					while((show=bf.readLine())!=null) {
						infors.add(show);
					
					}
					//循环读文件，直到null；
					list.setListData(infors.toArray());
					bf.close();
					fr.close();
					//关闭文件
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();//解决了文件找不到的异常；
				}
			}
		});
		button_3.setBounds(28, 344, 97, 23);
		contentPane.add(button_3);
		
		list = new JList();
		list.setBounds(363, 79, 241, 288);
		contentPane.add(list);
	}
}
