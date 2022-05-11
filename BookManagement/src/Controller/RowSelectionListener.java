package Controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import View.BookManagementView;

public class RowSelectionListener implements ListSelectionListener{

	private BookManagementView view;
	
	public RowSelectionListener(BookManagementView view) {
		// TODO Auto-generated constructor stub
		this.view = view;
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		this.view.showInfoSelected();
	}

}
