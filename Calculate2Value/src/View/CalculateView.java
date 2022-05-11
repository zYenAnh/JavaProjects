package View;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.CalculateController;
import Model.CalculateModel;

public class CalculateView extends JFrame{
	private CalculateModel calculateModel;
	private JTextField firstValueField;
	private JTextField secondValueField;
	private JTextField resulTextField;
	public CalculateView() {
		// TODO Auto-generated constructor stub
		this.calculateModel = new CalculateModel();
		this.init();
	}
	
	public void init() {
		this.setTitle("Calculate");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ActionListener acCalController = new CalculateController(this);
		Font font = new Font("Arial",Font.BOLD,20);
		
		JLabel value_1Jlable = new JLabel("Value 1");
		value_1Jlable.setFont(font);
		JLabel value_2Jlable = new JLabel("Value 2");
		value_2Jlable.setFont(font);
		JLabel resultJLabel = new JLabel("Result");
		resultJLabel.setFont(font);
		
		firstValueField = new JTextField(20);
		firstValueField.setFont(font);
		secondValueField = new JTextField(20);
		secondValueField.setFont(font);
		resulTextField = new JTextField(40);
		resulTextField.setFont(font);
		
		JPanel inAndOutJPanel = new JPanel();
		inAndOutJPanel.setLayout(new GridLayout(3,2));
		inAndOutJPanel.add(value_1Jlable);
		inAndOutJPanel.add(firstValueField);
		inAndOutJPanel.add(value_2Jlable);
		inAndOutJPanel.add(secondValueField);
		inAndOutJPanel.add(resultJLabel);
		inAndOutJPanel.add(resulTextField);
		
		JPanel buttonOperator = new JPanel(new GridLayout(2,4));
		JButton sumButton = new JButton("+");
		sumButton.setFont(font);
		sumButton.addActionListener(acCalController);
		JButton minusButton = new JButton("-");
		minusButton.setFont(font);
		minusButton.addActionListener(acCalController);
		JButton mulButton = new JButton("*");
		mulButton.setFont(font);
		mulButton.addActionListener(acCalController);
		JButton divButton = new JButton("/");
		divButton.setFont(font);
		divButton.addActionListener(acCalController);
		JButton powButton = new JButton("^");
		powButton.setFont(font);
		powButton.addActionListener(acCalController);
		JButton modButton = new JButton("MOD");
		modButton.setFont(font);
		modButton.addActionListener(acCalController);
		
		buttonOperator.add(sumButton);
		buttonOperator.add(minusButton);
		buttonOperator.add(mulButton);
		buttonOperator.add(divButton);
		buttonOperator.add(powButton);
		buttonOperator.add(modButton);
		
		this.setLayout(new BorderLayout());
		this.add(inAndOutJPanel,BorderLayout.NORTH);
		this.add(buttonOperator,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public void loadDataToModel() {
		int value1 = Integer.parseInt(this.firstValueField.getText());
		int value2 = Integer.parseInt(this.secondValueField.getText());
		this.calculateModel.setOperand_1(value1);
		this.calculateModel.setOperand_2(value2);
	}
	
	public void handleSum() {
		loadDataToModel();
		this.calculateModel.sum();
		this.resulTextField.setText(this.calculateModel.getResult()+"");
	}
	
	public void handleMinus() {
		loadDataToModel();
		this.calculateModel.minus();
		this.resulTextField.setText(this.calculateModel.getResult()+"");
	}
	
	public void handleMul() {
		loadDataToModel();
		this.calculateModel.mul();
		this.resulTextField.setText(this.calculateModel.getResult()+"");
	}
	
	public void handleDiv() {
		loadDataToModel();
		this.calculateModel.div();
		this.resulTextField.setText(this.calculateModel.getResult()+"");
	}
	
	public void handlePow() {
		loadDataToModel();
		this.calculateModel.pow();
		this.resulTextField.setText(this.calculateModel.getResult()+"");
	}
	
	public void handleMod() {
		loadDataToModel();
		this.calculateModel.mod();
		this.resulTextField.setText(this.calculateModel.getResult()+"");
	}
}
