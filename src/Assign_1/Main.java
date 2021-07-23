package Assign_1;
// import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;


public class Main extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		File f=new File("./temp.txt");
		if(f.exists()){
			System.out.println("File exist");
			if(f.length()==0)
			{
				
				try {
				FileWriter fw = new FileWriter(f);
					fw.write("0");
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
		{
			try {
				f.createNewFile();
				FileWriter fw=new FileWriter(f);
				fw.write("0");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("in withdraw");
				int userdata=0;
				userdata=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Amount To withdraw"));
			
				File f=new File("./temp.txt");
				int data=0;
				try {
					Scanner sc=new Scanner(f);
					while(sc.hasNextLine()){
							data=Integer.parseInt(sc.nextLine());
					}
					sc.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(userdata>=data){
					JOptionPane.showMessageDialog(null, "Insufficent Balance!");
				}
				else
				{
					int temp=data-userdata;
					try {
						FileWriter fw = new FileWriter(f);
							fw.write(Integer.toString(temp));
							fw.close();
							JOptionPane.showMessageDialog(null, "your Withdraw:"+userdata);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
				
			}
		});
		btnWithdraw.setBounds(54, 63, 133, 23);
		panel.add(btnWithdraw);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("in deposit");
				int depositedata=0;
				depositedata=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Amount To deposit"));
				
				File f=new File("./temp.txt");
				int data=0;
				try {
					Scanner sc=new Scanner(f);
					while(sc.hasNextLine()){
							data=Integer.parseInt(sc.nextLine());
					}
					sc.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int temp=depositedata+data;
				try {
					FileWriter fw = new FileWriter(f);
						fw.write(Integer.toString(temp));
						fw.close();
						JOptionPane.showMessageDialog(null, "you Deposited: "+depositedata);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		});
		btnDeposit.setBounds(54, 158, 127, 23);
		panel.add(btnDeposit);
		
		JButton btnCheckBalance = new JButton("Check Balance");
		btnCheckBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("in check balance");
				File f=new File("./temp.txt");
				int datatoshow=0;
				try {
					Scanner sc=new Scanner(f);
					while(sc.hasNextLine()){
							datatoshow=Integer.parseInt(sc.nextLine());
					}
					sc.close();
					JOptionPane.showMessageDialog(null, "your Balance is: "+datatoshow);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnCheckBalance.setBounds(228, 63, 133, 23);
		panel.add(btnCheckBalance);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("in Exit");
				Start.main(null);
				JFrame frame=new JFrame();
				frame.dispose();
			}
		});
		btnExit.setBounds(228, 158, 133, 23);
		panel.add(btnExit);
	}

}
