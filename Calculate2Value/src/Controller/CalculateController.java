package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.CalculateView;

public class CalculateController implements ActionListener{

	private CalculateView view;
	
	public CalculateController(CalculateView view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String srcString = e.getActionCommand();
		if(srcString.equals("+")) {
			this.view.handleSum();
		} else if(srcString.equals("-")) {
			this.view.handleMinus();
		} else if(srcString.equals("*")) {
			this.view.handleMul();
		} else if(srcString.equals("/")) {
			this.view.handleDiv();
		} else if(srcString.equals("^")) {
			this.view.handlePow();
		} else if(srcString.equals("MOD")) {
			this.view.handleMod();
		}
	}

}
