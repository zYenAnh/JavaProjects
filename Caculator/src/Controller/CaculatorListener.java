package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.CaculatorView;

public class CaculatorListener implements ActionListener{
	private CaculatorView caculatorView;
	private String operand;
	public CaculatorListener(CaculatorView caculatorView) {
		this.caculatorView = caculatorView;
		operand = "";
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("1")){
			operand += src;
			this.caculatorView.setDisplayTextField(operand);
		} 
		else if (src.equals("2")) {
			operand += src;
			this.caculatorView.setDisplayTextField(operand);
		}
		else if (src.equals("3")) {
			operand += src;
			this.caculatorView.setDisplayTextField(operand);
		}
		else if (src.equals("4")) {
			operand += src;
			this.caculatorView.setDisplayTextField(operand);
		}
		else if (src.equals("5")) {
			operand += src;
			this.caculatorView.setDisplayTextField(operand);
		}
		else if (src.equals("6")) {
			operand += src;
			this.caculatorView.setDisplayTextField(operand);
		}
		else if (src.equals("7")) {
			operand += src;
			this.caculatorView.setDisplayTextField(operand);
		}
		else if (src.equals("8")) {
			operand += src;
			this.caculatorView.setDisplayTextField(operand);
		}
		else if (src.equals("9")) {
			operand += src;
			this.caculatorView.setDisplayTextField(operand);
		}
		else if (src.equals("0")) {
			operand += src;
			this.caculatorView.setDisplayTextField(operand);
		}
		else if (src.equals("+")) {
			if(this.caculatorView.caculatorModel.getOperator()=="")
				this.caculatorView.caculatorModel.setTotal(Integer.parseInt(operand));
			this.caculatorView.caculatorModel.setOperand(Integer.parseInt(operand));
			this.caculatorView.caculatorModel.setOperator(src);
			operand = "";
//			this.caculatorView.caculatorModel.caculate();
		}
		else if (src.equals("-")) {
			if(this.caculatorView.caculatorModel.getOperator()=="")
				this.caculatorView.caculatorModel.setTotal(Integer.parseInt(operand));
			this.caculatorView.caculatorModel.setOperand(Integer.parseInt(operand));
			this.caculatorView.caculatorModel.setOperator(src);
			operand = "";
		}
		else if (src.equals("*")) {
			if(this.caculatorView.caculatorModel.getOperator()=="")
				this.caculatorView.caculatorModel.setTotal(Integer.parseInt(operand));
			this.caculatorView.caculatorModel.setOperand(Integer.parseInt(operand));
			this.caculatorView.caculatorModel.setOperator(src);
			operand = "";
		}
		else if (src.equals("/")) {
			if(this.caculatorView.caculatorModel.getOperator()=="")
				this.caculatorView.caculatorModel.setTotal(Integer.parseInt(operand));
			this.caculatorView.caculatorModel.setOperand(Integer.parseInt(operand));
			this.caculatorView.caculatorModel.setOperator(src);
			operand = "";
		}
		else if (src.equals("=")) {
			this.caculatorView.caculatorModel.setOperand(Integer.parseInt(operand));
			this.caculatorView.caculatorModel.caculate();
			this.caculatorView.setDisplayTextField(this.caculatorView.caculatorModel.getTotal()+"");
		}
		else if (src.equals("C")) {
			this.caculatorView.caculatorModel.setOperand(0);
			this.caculatorView.caculatorModel.setTotal(0);
			this.caculatorView.caculatorModel.setOperator("");
			operand = "";
			this.caculatorView.setDisplayTextField("0");
		}
	}
}
