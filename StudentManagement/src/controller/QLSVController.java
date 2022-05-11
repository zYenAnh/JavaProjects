package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

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
		System.out.println("Click: " +srcString);
		if(srcString.equals("Thêm")) {
			try {
				this.addStudent(this.getDataInputBox());
				this.clearFormInput();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(srcString.equals("Xoá")) {
			try {
				this.removeStudent();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if(srcString.equals("Sửa")) {
			this.updateStudent();
		} else if(srcString.equals("Open")) {
			this.loadData();
		}
	}
	
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
	
	public Student getValueSelectedTable(int row_index) {
		DefaultTableModel tableModel = (DefaultTableModel) this.view.sinhVienTable.getModel();
		
		int id = Integer.valueOf(tableModel.getValueAt(row_index, 1)+"");
		String tenSinhVien = tableModel.getValueAt(row_index, 2)+"";
		Province queQuan = Province.getTinhByName(tableModel.getValueAt(row_index, 3)+"");
		Date ngaySinh = new Date(tableModel.getValueAt(row_index, 4)+"");
		boolean gioiTinh = this.view.namRadioBtn.isSelected();
		float diemToan = Float.valueOf(this.view.diemToanTextFeild.getText());
		float diemHoa = Float.valueOf(this.view.diemHoaTextFeild.getText());
		float diemLy = Float.valueOf(this.view.diemLyTextFeild.getText());
		
		return new Student(id,tenSinhVien,queQuan,ngaySinh,gioiTinh,diemToan,diemLy,diemHoa);
	}
	
	public void addStudent(Student st) {
		if(!this.view.model.kiemTraStudentTonTai(st)) {
			this.view.model.insert(st);
			DefaultTableModel modelTable = (DefaultTableModel) this.view.sinhVienTable.getModel();
			modelTable.addRow(new Object[] {
					modelTable.getRowCount()+1,
					st.getMaSinhVienInt() + "",
					st.getTenSinhVienString(),
					st.getQueQuanProvince().getTenTinhString(),
					st.getNgaySinhDate().getDate()+"/"+(st.getNgaySinhDate().getMonth()+1)+"/"+ (st.getNgaySinhDate().getYear()+1900) ,
					(st.isGioiTinh())?"Nam":"Nữ",
							st.getDiemToan()+"",
							st.getDiemHoa() + "",
							st.getDiemLy() +""
			});	
		} else {
			this.view.sinhVienTable.clearSelection();
		}
	}
	
	public void removeStudent() {
		DefaultTableModel modelTable = (DefaultTableModel) this.view.sinhVienTable.getModel();
		int row_index = this.view.sinhVienTable.getSelectedRow();
		modelTable.removeRow(row_index);
		Student studentSelected = getValueSelectedTable(row_index);
		this.view.model.remove(studentSelected);
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
	
}
