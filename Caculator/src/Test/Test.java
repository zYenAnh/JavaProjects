package Test;

import javax.swing.UIManager;

import View.CaculatorView;


public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			CaculatorView caculatorView = new CaculatorView();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
