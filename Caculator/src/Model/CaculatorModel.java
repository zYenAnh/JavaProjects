package Model;

public class CaculatorModel {
	private float total;
	private int operand;
	public int getOperand() {
		return operand;
	}

	public void setOperand(int operand) {
		this.operand = operand;
	}

	private String operator;
	
	public CaculatorModel() {
		this.total =0;
		this.operator = "";
	}
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public void caculate() {
		System.out.println("phep: " + this.operator);
		System.out.println("total 1: " +total);
		if(this.operator == "") {
			this.total = operand;
		} else if(this.operator.equals("+"))
			this.total += operand;
		else if(this.operator.equals("-")) {
			this.total -= operand;
		}
		else if(this.operator.equals("*")) {
			this.total *= operand;
		}
		else if(this.operator.equals("/")) {
			this.total /= operand;
		}
		System.out.println("total 2: " +total);
	}
}
