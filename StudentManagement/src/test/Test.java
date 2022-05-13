package test;

import javax.swing.UIManager;

import view.QLSVView;


public class Test {
	public static void main(String[] args) {
		new QLSVView();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			new QLSVView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
