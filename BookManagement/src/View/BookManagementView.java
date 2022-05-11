package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.BookManagementController;
import Controller.RowSelectionListener;
import Model.BookInformation;
import Model.BookManagementModel;

public class BookManagementView extends JFrame{
	private BookManagementModel bookManagementModel;
	private String data;
	public JTextField maSachJTextField;
	public JTextField tacGiaJTextField;
	public JTextField tenSachJTextField;
	public JTextField nhaXbJTextField;
	public JTextField giaSachJTextField;
	public JTable thongTinSachJTable;
	public JButton themButton;
	public JButton xoaButton;
	public JButton suaButton;
	public JButton luuButton;
	public JButton timButton;
	public JButton clearButton;
	public JButton thoatButton;
	
	public BookManagementView() {
		// TODO Auto-generated constructor stub
		bookManagementModel = new BookManagementModel();
		init();
	}
	
	public void init() {
		ActionListener ac = new BookManagementController(this);
		ListSelectionListener lEvent = new RowSelectionListener(this);
		this.setTitle("Book Management");
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel headingJLabel = new JLabel("Thông tin sách");
		
		JPanel contentJPanel = new JPanel();
		contentJPanel.setLayout(new BorderLayout());
		
		JPanel inputInfoJPanel = new JPanel();
		inputInfoJPanel.setLayout(new GridLayout(3,2));
		
		JPanel maSachJPanel = new JPanel();
		maSachJPanel.setLayout(new GridLayout(1,2));
		JLabel maSachJLabel = new JLabel("Mã sách");
		maSachJTextField = new JTextField();
		maSachJPanel.add(maSachJLabel);
		maSachJPanel.add(maSachJTextField);
		
		JPanel tacGiaJPanel = new JPanel();
		tacGiaJPanel.setLayout(new GridLayout(1,2));
		JLabel tacGiaJLabel = new JLabel("Tác giá sách");
		tacGiaJTextField = new JTextField();
		tacGiaJPanel.add(tacGiaJLabel);
		tacGiaJPanel.add(tacGiaJTextField);
		
		
		JPanel tenSachJPanel = new JPanel();
		tenSachJPanel.setLayout(new GridLayout(1,2));
		JLabel tenSachJLabel = new JLabel("Tên sách");
		tenSachJTextField = new JTextField();
		tenSachJPanel.add(tenSachJLabel);
		tenSachJPanel.add(tenSachJTextField);
		
		JPanel nhaXBhJPanel = new JPanel();
		nhaXBhJPanel.setLayout(new GridLayout(1,2));
		JLabel nhaXbJLabel = new JLabel("NXB sách");
		nhaXbJTextField = new JTextField();
		nhaXBhJPanel.add(nhaXbJLabel);
		nhaXBhJPanel.add(nhaXbJTextField);
		
		JPanel giaSachJPanel = new JPanel();
		giaSachJPanel.setLayout(new GridLayout(1,2));
		JLabel giaSachJLabel = new JLabel("Giá sách");
		giaSachJTextField = new JTextField();
		giaSachJPanel.add(giaSachJLabel);
		giaSachJPanel.add(giaSachJTextField);
		
		inputInfoJPanel.add(maSachJPanel);
		inputInfoJPanel.add(tacGiaJPanel);
		inputInfoJPanel.add(tenSachJPanel);
		inputInfoJPanel.add(nhaXBhJPanel);
		inputInfoJPanel.add(giaSachJPanel);
		
		String data[][] = {
				{"1","Abc","sss","aaa","2000"},
				{"2","Abc","sss","aaa","2000"},
				};
		String column[] = {"Mã sách","Tên sách","Tác giá","NXB","Giá"};
		JPanel tableJPanel = new JPanel(new BorderLayout());
		thongTinSachJTable = new JTable();
		thongTinSachJTable.setModel(new DefaultTableModel(
				new Object[][] {
					
				}, new String[] {"Mã sách","Tên sách","Tác giá","NXB","Giá"}));
		tableJPanel.add(thongTinSachJTable,BorderLayout.CENTER);
		tableJPanel.add(thongTinSachJTable.getTableHeader(),BorderLayout.NORTH);
		thongTinSachJTable.getSelectionModel().addListSelectionListener(lEvent);
		
		loadData();
		
		contentJPanel.add(inputInfoJPanel,BorderLayout.NORTH);
		contentJPanel.add(tableJPanel,BorderLayout.CENTER);
		
		JPanel footerJPanel =new JPanel();
		footerJPanel.setLayout(new GridLayout(1,7));
		
		themButton = new JButton("Thêm");
		themButton.addActionListener(ac);
		xoaButton = new JButton("Xoá");
		xoaButton.addActionListener(ac);
		suaButton = new JButton("Sửa");
		suaButton.addActionListener(ac);
		luuButton = new JButton("Lưu");
		luuButton.addActionListener(ac);
		timButton = new JButton("Tìm");
		timButton.addActionListener(ac);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(ac);
		thoatButton = new JButton("Thoát");
		thoatButton.addActionListener(ac);
		
		footerJPanel.add(themButton);
		footerJPanel.add(xoaButton);
		footerJPanel.add(suaButton);
		footerJPanel.add(luuButton);
		footerJPanel.add(timButton);
		footerJPanel.add(clearButton);
		footerJPanel.add(thoatButton);

		this.setLayout(new BorderLayout());
		this.add(headingJLabel,BorderLayout.NORTH);
		this.add(contentJPanel,BorderLayout.CENTER);
		this.add(footerJPanel,BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void delForm() {
		maSachJTextField.setText("");
		tacGiaJTextField.setText("");
		tenSachJTextField.setText("");
		nhaXbJTextField.setText("");
		giaSachJTextField.setText("");
	}
	
	public void addTT(BookInformation bIn) {
		this.bookManagementModel.insert(bIn);
		DefaultTableModel model = (DefaultTableModel)thongTinSachJTable.getModel();
		model.addRow(new Object[] {
				bIn.getMaSach()+""
				,bIn.getTenSach()+""
				,bIn.getTacGia()+""
				,bIn.getNhaXuatBan()+""
				,bIn.getGiaSach()+""			
		});
	}
	
	public void showInfoSelected() {
		DefaultTableModel modelTable = (DefaultTableModel) thongTinSachJTable.getModel();
		int i_row;
		try {
			i_row = thongTinSachJTable.getSelectedRow();
			String maSachString = modelTable.getValueAt(i_row, 0)+"";
			String tenSachString = modelTable.getValueAt(i_row, 1)+"";
			String tacGiaString = modelTable.getValueAt(i_row, 2)+"";
			String nhaXbString = modelTable.getValueAt(i_row, 3)+"";
			Long giaSachLong = Long.parseLong(modelTable.getValueAt(i_row, 4)+"");
			
			maSachJTextField.setText(maSachString);
			tacGiaJTextField.setText(tacGiaString);
			tenSachJTextField.setText(tenSachString);
			nhaXbJTextField.setText(nhaXbString);
			giaSachJTextField.setText(giaSachLong+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteInfoSelected() {
		DefaultTableModel modelTableModel = (DefaultTableModel) thongTinSachJTable.getModel();
		int i_row = thongTinSachJTable.getSelectedRow();
		this.bookManagementModel.getArrBookInformations().remove(i_row);
		System.out.println(this.bookManagementModel.getArrBookInformations().size());
		modelTableModel.removeRow(i_row);
	}
	
	public void loadData() {
		//String maSach, String tenSach, String tacGia, String nhaXuatBan, Long giaSach
		ArrayList<BookInformation> listTempArrayList = new ArrayList<BookInformation>();
		listTempArrayList.add(new BookInformation("1AX", "Đấu phá thương khung", "Vân Chi", "Kim Đồng", Long.parseLong("321000")));
		listTempArrayList.add(new BookInformation("2AX", "Đấu la đại lục", "Yến Anh", "Việt Nam", Long.parseLong("200000")));
		listTempArrayList.add(new BookInformation("A22", "Thế giới hoàn mỹ", "Tiểu Trang", "Kim Đồng", Long.parseLong("400000")));
		listTempArrayList.add(new BookInformation("M21", "Tần thời minh nguyệt", "Cái Nhiếp", "Việt Nam", Long.parseLong("3200000")));
		listTempArrayList.add(new BookInformation("M22", "Thiên hành cửu ca", "Vệ Trang", "Taiwan", Long.parseLong("399999")));
		this.bookManagementModel.setArrBookInformations(listTempArrayList);
		for(int i=0;i<this.bookManagementModel.getArrBookInformations().size();i++) {
			BookInformation temp = this.bookManagementModel.getArrBookInformations().get(i);
			DefaultTableModel model = (DefaultTableModel)thongTinSachJTable.getModel();
			model.addRow(new Object[] {
					temp.getMaSach()+""
					,temp.getTenSach()+""
					,temp.getTacGia()+""
					,temp.getNhaXuatBan()+""
					,temp.getGiaSach()+""			
			});
			
		}
	}
}
