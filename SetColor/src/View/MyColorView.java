package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.MyColorController;
import Model.MyColorModel;

public class MyColorView extends JFrame{
	public MyColorModel colorModel;
	private JLabel showTextJLabel;
	private JButton redColorTextButton;
	private JButton greenColorTextButton;
	private JButton blueColorTextButton;
	private JButton redColorBackgroundButton;
	private JButton greenColorBackgroundButton;
	private JButton blueColorBackground;
	
	public MyColorView() {
		// TODO Auto-generated constructor stub
		this.colorModel = new MyColorModel();
		this.init();
	}
	
	public void init() {
		this.setTitle("My Color");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ActionListener acColorController = new MyColorController(this);
		
		Font font = new Font("Arial",Font.BOLD,40);
		Font fontButton = new Font("Arial",Font.BOLD,24);
		
		showTextJLabel = new JLabel("My Color");
		showTextJLabel.setFont(font);
		
		JPanel listButtonJPanel = new JPanel(new GridLayout(2,3));
		
		redColorTextButton = new JButton("Red Text");
		redColorTextButton.setFont(fontButton);
		redColorTextButton.setForeground(Color.red);
		
		greenColorTextButton = new JButton("Green Text");
		greenColorTextButton.setFont(fontButton);
		greenColorTextButton.setForeground(Color.green);
		
		blueColorTextButton = new JButton("Blue Text");
		blueColorTextButton.setFont(fontButton);
		blueColorTextButton.setForeground(Color.blue);
		
		redColorBackgroundButton = new JButton("Red BG");
		redColorBackgroundButton.setFont(fontButton);
		redColorBackgroundButton.setOpaque(true);
		redColorBackgroundButton.setBorderPainted(false);
		redColorBackgroundButton.setBackground(Color.RED);
		
		greenColorBackgroundButton = new JButton("Green BG");
		greenColorBackgroundButton.setFont(fontButton);
		greenColorBackgroundButton.setOpaque(true);
		greenColorBackgroundButton.setBorderPainted(false);
		greenColorBackgroundButton.setBackground(Color.GREEN);
				
		blueColorBackground = new JButton("Blue BG");
		blueColorBackground.setFont(fontButton);
		blueColorBackground.setOpaque(true);
		blueColorBackground.setBorderPainted(false);
		blueColorBackground.setBackground(Color.BLUE);
		
		redColorTextButton.addActionListener(acColorController);
		greenColorTextButton.addActionListener(acColorController);
		blueColorTextButton.addActionListener(acColorController);
		redColorBackgroundButton.addActionListener(acColorController);
		greenColorBackgroundButton.addActionListener(acColorController);
		blueColorBackground.addActionListener(acColorController);
		
		listButtonJPanel.add(redColorTextButton);
		listButtonJPanel.add(greenColorTextButton);
		listButtonJPanel.add(blueColorTextButton);
		listButtonJPanel.add(redColorBackgroundButton);
		listButtonJPanel.add(greenColorBackgroundButton);
		listButtonJPanel.add(blueColorBackground);
		
		this.setLayout(new BorderLayout());
		
		this.add(showTextJLabel,BorderLayout.NORTH);
		this.add(listButtonJPanel,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public void changeTextColor(Color newColor) {
		this.colorModel.setForeground(newColor);
		this.showTextJLabel.setForeground(this.colorModel.getForeground());
	}
	
	public void changeBackgroundColor(Color newColor) {
		this.colorModel.setBackground(newColor);
		this.showTextJLabel.setBackground(newColor);
		this.showTextJLabel.setOpaque(true);
	}
}
