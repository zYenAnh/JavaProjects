package Model;

public class CalculateModel {
	private int operand_1;
	private int operand_2;
	private double result;
	
	public CalculateModel() {
		// TODO Auto-generated constructor stub
		this.operand_1 = 0;
		this.operand_2 = 0;
		this.result = 0;
	}
		
	public int getOperand_1() {
		return operand_1;
	}

	public void setOperand_1(int operand_1) {
		this.operand_1 = operand_1;
	}

	public int getOperand_2() {
		return operand_2;
	}

	public void setOperand_2(int operand_2) {
		this.operand_2 = operand_2;
	}

	public double getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}
	
	public void sum() {
		this.result = this.operand_1 + this.operand_2;
	}
	
	public void minus() {
		this.result = this.operand_1 - this.operand_2;
	}
	
	public void mul() {
		this.result = this.operand_1 * this.operand_2;
	}
	
	public void div() {
		this.result = this.operand_1 / this.operand_2;
	}
	
	public void pow() {
		this.result = Math.pow(this.operand_1, this.operand_2);
	}
	
	public void mod() {
		this.result = this.operand_1 % this.operand_2;
	}
}
