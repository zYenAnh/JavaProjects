package controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Province;
import view.QLSVView;

public class TableController implements ListSelectionListener{

	private QLSVView view;
	
	public TableController(QLSVView view) {
		this.view = view;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
//		this.loadDataTableToInput();
	}

}
