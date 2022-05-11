package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.LastBtnView;

public class LastBtnListener implements ActionListener{

	private LastBtnView vLastBtn;
	
	public LastBtnListener(LastBtnView vLastBtn) {
		// TODO Auto-generated constructor stub
		this.vLastBtn = vLastBtn;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String srcString = e.getActionCommand();
		if(srcString.equals("1")) {
			vLastBtn.changeTo_1();
		} else if(srcString.equals("2")) {
			vLastBtn.changeTo_2();
		} else if(srcString.equals("3")) {
			vLastBtn.changeTo_3();
		} else if(srcString.equals("4")) {
			vLastBtn.changeTo_4();
		}
	}

}
