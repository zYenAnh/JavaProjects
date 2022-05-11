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
		this.loadDataTableToInput();
	}
	
	public void loadDataTableToInput() {
		DefaultTableModel modelTable = (DefaultTableModel) this.view.sinhVienTable.getModel();
		int row_index;
		try {
			row_index = this.view.sinhVienTable.getSelectedRow();
			String id = modelTable.getValueAt(row_index, 1)+"";
			String tenSinhVien = modelTable.getValueAt(row_index, 2)+"";
			Province queQuan = Province.getTinhByName(modelTable.getValueAt(row_index, 3)+"");
			String ngaySinh = modelTable.getValueAt(row_index, 4)+"";
			String gioiTinhString = modelTable.getValueAt(row_index, 5)+"";
			boolean gioiTinh = gioiTinhString.equals("Nam");
			String diemToan = modelTable.getValueAt(row_index,6)+"";
			String diemHoa = modelTable.getValueAt(row_index,7)+"";
			String diemLy = modelTable.getValueAt(row_index,8)+"";
			String total = (Float.parseFloat(diemToan)+Float.parseFloat(diemLy)+Float.parseFloat(diemHoa))+"";
			
			this.view.idTextField.setText(id);
			this.view.nameTextFeild.setText(tenSinhVien);
			this.view.diemToanTextFeild.setText(diemToan);
			this.view.diemLyTextFeild.setText(diemLy);
			this.view.diemHoaTextFeild.setText(diemHoa);
			this.view.dateOfBirthTextField.setText(ngaySinh);
			if(gioiTinh)
				this.view.namRadioBtn.setSelected(true);
			else
				this.view.nuRadioBtn.setSelected(true);
			this.view.totalTextField.setText(total);
			this.view.queQuanOfInfoComboBox.setSelectedItem(queQuan.getTenTinhString());;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
