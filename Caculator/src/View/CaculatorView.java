package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.CaculatorListener;
import Model.CaculatorModel;

public class CaculatorView extends JFrame{
	
	public CaculatorModel caculatorModel;
	private JTextField displayTextField;
	
	public CaculatorView() {
		// TODO Auto-generated constructor stub
		caculatorModel = new CaculatorModel();
		init();
	}
	
	public void init() {
		this.setTitle("Caculator");
		this.setSize(200,200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel displayJPanel = new JPanel();
		displayJPanel.setSize(new Dimension(300,40));
		displayTextField = new JTextField(this.caculatorModel.getTotal()+"",16);
		displayJPanel.add(displayTextField);
		
		ActionListener acCaculate = new CaculatorListener(this);
		
		JPanel keyBoardPanel = new JPanel();
		keyBoardPanel.setLayout(new GridLayout(4,4));
		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(acCaculate);
		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(acCaculate);
		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(acCaculate);
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(acCaculate);
		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(acCaculate);
		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(acCaculate);
		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(acCaculate);
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(acCaculate);
		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(acCaculate);
		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(acCaculate);
		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(acCaculate);
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(acCaculate);
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(acCaculate);
		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(acCaculate);
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(acCaculate);
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(acCaculate);
		
		keyBoardPanel.add(btn_1);
		keyBoardPanel.add(btn_2);
		keyBoardPanel.add(btn_3);
		keyBoardPanel.add(btnAdd);
		keyBoardPanel.add(btn_4);
		keyBoardPanel.add(btn_5);
		keyBoardPanel.add(btn_6);
		keyBoardPanel.add(btnSub);
		keyBoardPanel.add(btn_7);
		keyBoardPanel.add(btn_8);
		keyBoardPanel.add(btn_9);
		keyBoardPanel.add(btnMul);
		keyBoardPanel.add(btnClear);
		keyBoardPanel.add(btn_0);
		keyBoardPanel.add(btnDiv);
		keyBoardPanel.add(btnEqual);
		
		this.setLayout(new BorderLayout());
		this.add(displayJPanel,BorderLayout.NORTH);
		this.add(keyBoardPanel,BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void setDisplayTextField(String strCaculate) {
		this.displayTextField.setText(strCaculate);
	}
	
	public String getDisplayTextField() {
		return displayTextField.getText();
	}
	
}
