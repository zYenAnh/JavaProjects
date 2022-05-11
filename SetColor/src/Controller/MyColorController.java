package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.MyColorView;

public class MyColorController implements ActionListener{

	private MyColorView view;
	
	public MyColorController(MyColorView view) {
		// TODO Auto-generated constructor stub
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String srcString = e.getActionCommand();
		if(srcString.equals("Red Text")) {
			this.view.changeTextColor(Color.red);
		} else if(srcString.equals("Green Text")) {
			this.view.changeTextColor(Color.green);
		} else if(srcString.equals("Blue Text")) {
			this.view.changeTextColor(Color.BLUE);
		} else if(srcString.equals("Red BG")) {
			this.view.changeBackgroundColor(Color.RED);
		} else if(srcString.equals("Green BG")) {
			this.view.changeBackgroundColor(Color.GREEN);
		} else if(srcString.equals("Blue BG")) {
			this.view.changeBackgroundColor(Color.blue);
		}
		
	}

}
