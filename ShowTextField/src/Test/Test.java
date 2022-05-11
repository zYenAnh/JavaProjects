package Test;

import javax.swing.UIManager;

import View.LastBtnView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			LastBtnView view = new LastBtnView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
