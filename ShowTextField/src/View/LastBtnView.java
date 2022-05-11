package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.LastBtnListener;
import Model.ClassBtnModel;

public class LastBtnView extends JFrame{
	private ClassBtnModel btnModel;
	private JLabel textOutJLabel;
	
	public LastBtnView() {
		// TODO Auto-generated constructor stub
		this.btnModel = new ClassBtnModel();
		this.init();
	}
	
	public void init() {
		this.setTitle("Last Button");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel centerJPanel = new JPanel();
		centerJPanel.setLayout(new GridLayout(2,2));
		
		ActionListener ac = new LastBtnListener(this);
		
		Font font = new Font("Poppins", Font.BOLD,30);
		
		JButton jButton_1 = new JButton("1");
		jButton_1.setFont(font);
		jButton_1.addActionListener(ac);
		JButton jButton_2 = new JButton("2");
		jButton_2.setFont(font);
		jButton_2.addActionListener(ac);
		JButton jButton_3 = new JButton("3");
		jButton_3.setFont(font);
		jButton_3.addActionListener(ac);
		JButton jButton_4 = new JButton("4");
		jButton_4.setFont(font);
		jButton_4.addActionListener(ac);
		
		centerJPanel.add(jButton_1);
		centerJPanel.add(jButton_2);
		centerJPanel.add(jButton_3);
		centerJPanel.add(jButton_4);
		
		JPanel footerJPanel = new JPanel();
		textOutJLabel = new JLabel("------------");
		textOutJLabel.setFont(font);
		footerJPanel.add(textOutJLabel);
		
		this.setLayout(new BorderLayout());
		this.add(centerJPanel,BorderLayout.CENTER);
		this.add(footerJPanel,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public void changeTo_1() {
		this.btnModel.setValue_1();
		textOutJLabel.setText("Last btn click: " + this.btnModel.getValue());
	}
	
	public void changeTo_2() {
		this.btnModel.setValue_2();
		textOutJLabel.setText("Last btn click: " + this.btnModel.getValue());
	}
	
	public void changeTo_3() {
		this.btnModel.setValue_3();
		textOutJLabel.setText("Last btn click: " + this.btnModel.getValue());
	}
	
	public void changeTo_4() {
		this.btnModel.setValue_4();
		textOutJLabel.setText("Last btn click: " + this.btnModel.getValue());
	}
}
