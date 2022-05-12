package controller;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Province;
import model.Student;
import view.QLSVView;

public class QLSVController implements ActionListener{

	private QLSVView view;
	
	public QLSVController(QLSVView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String srcString = e.getActionCommand();
		if(srcString.equals("Thêm")) {
			try {
				this.addStudent(this.getDataInputBox());
				this.clearFormInput();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(srcString.equals("Xoá")) {
			if(this.view.sinhVienTable.getSelectedRow()!=-1) {
				this.removeStudent();
				this.view.sinhVienTable.clearSelection();				
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn sinh viên cần xoá!");
			}
				
		} else if(srcString.equals("Sửa")) {
			if(this.view.sinhVienTable.getSelectedRow()!=-1) {
				loadDataTableToInput();
				this.view.idTextField.disable();				
			}
			else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn sinh viên cần sửa!");
			}
		} else if(srcString.equals("Open")) {
			this.loadData();
		} else if(srcString.equals("Lưu")) {
			if(this.view.sinhVienTable.getSelectedRow()!=-1) {
				this.updateStudent();		
				this.view.idTextField.enable();
			}
		} else if(srcString.equals("Search")) {
			
			this.search();
		} else if(srcString.equals("Cancel")) {
			this.clearFormInput();
			this.view.idTextField.enable();
			this.loadData();
		}
	
	}
	
	// Xoá trắng các ô input
	public void clearFormInput() {
		this.view.idTextField.setText("");
		this.view.nameTextFeild.setText("");
		this.view.diemToanTextFeild.setText("");
		this.view.diemLyTextFeild.setText("");
		this.view.diemHoaTextFeild.setText("");
		this.view.dateOfBirthTextField.setText("");
		this.view.gioiTinh.clearSelection();
		this.view.totalTextField.setText("");
		this.view.queQuanOfInfoComboBox.setSelectedIndex(-1);
	}
	
	
	public Student getDataInputBox() {
		if(this.view.idTextField.getText() == "" || this.view.nameTextFeild.getText()== "" || this.view.queQuanOfInfoComboBox.getSelectedIndex()==-1 
				|| this.view.dateOfBirthTextField.getText()=="") {
			JOptionPane.showMessageDialog(view, "Dữ liệu nhập vào không đúng. vui lòng nhập lại!");
		} else {
			int id = Integer.valueOf(this.view.idTextField.getText());
			String tenSV = this.view.nameTextFeild.getText();
			int idQueQuanSelected = this.view.queQuanOfInfoComboBox.getSelectedIndex();
			Province queQuan = Province.getTinhById(idQueQuanSelected);
			Date ngaySinh = new Date(this.view.dateOfBirthTextField.getText());
			boolean gioiTinh = this.view.namRadioBtn.isSelected();
			float diemToan = Float.valueOf(this.view.diemToanTextFeild.getText());
			float diemHoa = Float.valueOf(this.view.diemHoaTextFeild.getText());
			float diemLy = Float.valueOf(this.view.diemLyTextFeild.getText());
			return new Student(id,tenSV,queQuan,ngaySinh,gioiTinh,diemToan,diemLy,diemHoa);
		}
		return null;
	}
	
	public Student getValueSelectedTable(int row_index) {
		DefaultTableModel tableModel = (DefaultTableModel) this.view.sinhVienTable.getModel();
		
		int id = Integer.valueOf(tableModel.getValueAt(row_index, 1)+"");
		String tenSinhVien = tableModel.getValueAt(row_index, 2)+"";
		Province queQuan = Province.getTinhByName(tableModel.getValueAt(row_index, 3)+"");
		Date ngaySinh = new Date(tableModel.getValueAt(row_index, 4)+"");
		boolean gioiTinh = (this.view.sinhVienTable.getValueAt(row_index, 5)=="Nam");
		float diemToan = Float.valueOf(this.view.sinhVienTable.getValueAt(row_index,6)+"");
		float diemHoa = Float.valueOf(this.view.sinhVienTable.getValueAt(row_index, 7)+"");
		float diemLy = Float.valueOf(this.view.sinhVienTable.getValueAt(row_index, 8)+"");
		
		return new Student(id,tenSinhVien,queQuan,ngaySinh,gioiTinh,diemToan,diemLy,diemHoa);
	}
	
	public void addStudent(Student st) {
		if(st!=null) {
			if(!this.view.model.kiemTraStudentTonTai(st)) {
				this.view.model.insert(st);
				loadData();
			} else {
				this.view.sinhVienTable.clearSelection();
			}
		}
	}
	
	public void removeStudent() {
		DefaultTableModel modelTable = (DefaultTableModel) this.view.sinhVienTable.getModel();
		int row_index = this.view.sinhVienTable.getSelectedRow();
		Student studentSelected = getValueSelectedTable(row_index);
		int choose = JOptionPane.showConfirmDialog(this.view, "Bạn có chắc chắn xoá sinh viên " + studentSelected.getMaSinhVienInt() + " không?");
		if(choose == JOptionPane.YES_OPTION) {
			this.view.model.remove(studentSelected);			
		}
		loadData();
	}
	
	public void updateStudent() {
		DefaultTableModel tableModel = (DefaultTableModel) this.view.sinhVienTable.getModel();
		int row_index = this.view.sinhVienTable.getSelectedRow();
	
		int numbersOfLineTale = this.view.sinhVienTable.getRowCount();
		for(int i=0; i <numbersOfLineTale;i++) {
			if(tableModel.getValueAt(i, 1)==tableModel.getValueAt(row_index, 1)) {
				Student t = getDataInputBox();
				tableModel.setValueAt(t.getTenSinhVienString(), row_index, 2);
				tableModel.setValueAt(t.getQueQuanProvince().getTenTinhString(), row_index, 3);
				tableModel.setValueAt(t.getNgaySinhDate().getDate()+"/"+(t.getNgaySinhDate().getMonth()+1)+"/"+ (t.getNgaySinhDate().getYear() +1900), row_index, 4);
				tableModel.setValueAt(t.isGioiTinh()?"Nam":"Nữ", row_index, 5);
				tableModel.setValueAt(t.getDiemToan(), row_index, 6);
				tableModel.setValueAt(t.getDiemHoa(), row_index, 7);
				tableModel.setValueAt(t.getDiemLy(), row_index, 8);
				this.view.model.update(t);
			}
		}
	}
	
	public void loadData() {
		DefaultTableModel modelTable = (DefaultTableModel) this.view.sinhVienTable.getModel();
		modelTable.getDataVector().removeAllElements();
		for(Student st: this.view.model.getDsSinhVien()) {
			modelTable.addRow(new Object[] {
					modelTable.getRowCount()+1,
					st.getMaSinhVienInt() + "",
					st.getTenSinhVienString(),
					st.getQueQuanProvince().getTenTinhString(),
					st.getNgaySinhDate().getDate()+"/"+(st.getNgaySinhDate().getMonth())+"/"+ (st.getNgaySinhDate().getYear()),
					st.isGioiTinh()?"Nam":"Nữ",
					st.getDiemToan()+"",
					st.getDiemHoa() + "",
					st.getDiemLy() +""
			});
		}
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
	
	public void search() {
		String queQuan = this.view.queQuanComboBox.getSelectedItem() +"";
		int mssv = Integer.valueOf(this.view.maSoSVTextFeild.getText());
		
		// Xoá trắng table
		DefaultTableModel tableModel = (DefaultTableModel) this.view.sinhVienTable.getModel();
		tableModel.getDataVector().removeAllElements();
		
		// Ghi lại table khi tìm thấy
		for(Student st: this.view.model.getDsSinhVien()) {
			if(st.getMaSinhVienInt()==mssv || queQuan.equals((st.getQueQuanProvince().getTenTinhString())+"")) {
				tableModel.addRow(new Object[] {
						tableModel.getRowCount()+1,
						st.getMaSinhVienInt() + "",
						st.getTenSinhVienString(),
						st.getQueQuanProvince().getTenTinhString(),
						st.getNgaySinhDate().getDate()+"/"+(st.getNgaySinhDate().getMonth())+"/"+ (st.getNgaySinhDate().getYear()),
						st.isGioiTinh()?"Nam":"Nữ",
						st.getDiemToan()+"",
						st.getDiemHoa() + "",
						st.getDiemLy() +""
				});
			}
		}
	}
	
}
