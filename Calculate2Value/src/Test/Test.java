package Test;

import javax.swing.UIManager;

import View.CalculateView;


public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			CalculateView view = new CalculateView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
