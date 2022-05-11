package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;

import Model.BookInformation;
import View.BookManagementView;

public class BookManagementController implements ActionListener{

	private BookManagementView bookManagementView;
	
	
	
	public BookManagementController(BookManagementView bookManagementView) {
		// TODO Auto-generated constructor stub
		this.bookManagementView = bookManagementView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String srcString = e.getActionCommand();
		System.out.println(srcString);
		if(srcString.equals("Thêm")) {
			String maSachString = this.bookManagementView.maSachJTextField.getText();
			String tenSachString = this.bookManagementView.tenSachJTextField.getText();
			String tacGiaString = this.bookManagementView.tacGiaJTextField.getText();
			String nhaXbString = this.bookManagementView.nhaXbJTextField.getText();
			Long giaSachLong = Long.parseLong(this.bookManagementView.giaSachJTextField.getText());
			
			BookInformation i = new BookInformation(maSachString,tenSachString,tacGiaString,nhaXbString,giaSachLong);
			this.bookManagementView.addTT(i);
			this.bookManagementView.delForm();
		} else if(srcString.equals("Sửa")) {
			this.bookManagementView.showInfoSelected();
		} else if(srcString.equals("Xoá")) {
			this.bookManagementView.deleteInfoSelected();
		} else if(srcString.equals("Clear")) {
			this.bookManagementView.delForm();
		}
		
	}
}
