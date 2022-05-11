package Test;

import javax.swing.UIManager;

import View.MyColorView;


public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			MyColorView view = new MyColorView();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
