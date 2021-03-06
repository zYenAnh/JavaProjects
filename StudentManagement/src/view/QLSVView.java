package view;
//Testing
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import model.Province;
import model.QLSVModel;
import model.Student;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.QLSVController;
import controller.TableController;

import javax.swing.JRadioButton;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField maSoSVTextFeild;
	public JTable sinhVienTable;
	public JTextField idTextField;
	public JTextField nameTextFeild;
	public JTextField dateOfBirthTextField;
	public JTextField diemToanTextFeild;
	public JTextField diemHoaTextFeild;
	public JTextField diemLyTextFeild;
	public JTextField totalTextField;
	public ButtonGroup gioiTinh;
	public JComboBox queQuanOfInfoComboBox;
	public JRadioButton namRadioBtn;
	public JRadioButton nuRadioBtn;
	public JMenuItem menuFileOpen;
	public JComboBox queQuanComboBox;
	
	Font font = new Font("JetBrains Mono", Font.BOLD, 16);
	Font font_12 = new Font("JetBrains Mono", Font.BOLD, 12);
	Font font_10 = new Font("JetBrains Mono", Font.BOLD, 10);
	/**
	 * Create the frame.
	 */
	public QLSVView() {
		ActionListener acQLSVController = new QLSVController(this);
		ListSelectionListener lsTableController = new TableController(this);
		
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 540);
		this.setTitle("Student Management");
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(font_12);
		menuBar.add(menuFile);
		
		menuFileOpen = new JMenuItem("Open");
		menuFileOpen.setFont(font_12);
		menuFileOpen.addActionListener(acQLSVController);
//		menuFileOpen.setIcon(null);
		menuFile.add(menuFileOpen);
		
		JMenuItem menuFileClose = new JMenuItem("Close");
		menuFileClose.setFont(font_12);
		menuFile.add(menuFileClose);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuFileExit = new JMenuItem("Exit");
		menuFileExit.setFont(font_12);
		menuFile.add(menuFileExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(font_12);
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutAboutMe = new JMenuItem("About me");
		menuAboutAboutMe.setFont(font_12);
		menuAbout.add(menuAboutAboutMe);
		
		JMenuItem menuAboutHelp = new JMenuItem("Help");
		menuAboutHelp.setFont(font_12);
		menuAbout.add(menuAboutHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel queQuanJLable = new JLabel("Qu\u00EA qu\u00E1n");
		queQuanJLable.setFont(font_12);
		queQuanJLable.setBounds(36, 10, 89, 22);
		contentPane.add(queQuanJLable);
		
		queQuanComboBox = new JComboBox();
		ArrayList<Province> listTinh = Province.getDSTinh();
		for(Province tinh : listTinh) {
			queQuanComboBox.addItem(tinh.getTenTinhString());
		}
		queQuanComboBox.setSelectedIndex(-1);
		queQuanComboBox.setFont(font_12);
		queQuanComboBox.setBounds(135, 10, 121, 22);
		contentPane.add(queQuanComboBox);
		
		JLabel maSoSVJLable = new JLabel("M\u00E3 s\u1ED1 sinh vi\u00EAn");
		maSoSVJLable.setFont(font_12);
		maSoSVJLable.setBounds(288, 10, 159, 22);
		contentPane.add(maSoSVJLable);
		
		maSoSVTextFeild = new JTextField();
		maSoSVTextFeild.setText("0");
		maSoSVTextFeild.setFont(font_12);
		maSoSVTextFeild.setBounds(457, 13, 172, 20);
		contentPane.add(maSoSVTextFeild);
		maSoSVTextFeild.setColumns(10);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setFont(font_12);
		searchBtn.setBounds(639, 10, 89, 23);
		contentPane.add(searchBtn);
		
		searchBtn.addActionListener(acQLSVController);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 41, 746, 2);
		contentPane.add(separator_1);
		
		JLabel dsSinhVienLable = new JLabel("Danh s\u00E1ch sinh vi\u00EAn");
		dsSinhVienLable.setFont(font);
		dsSinhVienLable.setBounds(36, 54, 192, 14);
		contentPane.add(dsSinhVienLable);
		
		sinhVienTable = new JTable();
		sinhVienTable.setFont(font_12);
		sinhVienTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "ID", "H\u1ECD v\u00E0 t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m to\u00E1n", "\u0110i\u1EC3m ho\u00E1", "\u0110i\u1EC3m l\u00FD"
			}
		));
		JTableHeader tableSinhVienHeader = sinhVienTable.getTableHeader();
		tableSinhVienHeader.setFont(font_10);
//		loadData();
		sinhVienTable.getSelectionModel().addListSelectionListener(lsTableController);
		
		JScrollPane tableSinhVienScrollPane = new JScrollPane(sinhVienTable);
		tableSinhVienScrollPane.setBounds(36, 79, 692, 145);
		contentPane.add(tableSinhVienScrollPane);
		
		JLabel infoSinhVienLable = new JLabel("Th\u00F4ng tin sinh vi\u00EAn");
		infoSinhVienLable.setBounds(36, 248, 192, 22);
		infoSinhVienLable.setFont(font);
		contentPane.add(infoSinhVienLable);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 243, 746, 2);
		contentPane.add(separator_2);
		
		JLabel idLable = new JLabel("ID");
		idLable.setFont(font_12);
		idLable.setBounds(36, 281, 49, 14);
		contentPane.add(idLable);
		
		idTextField = new JTextField();
		idTextField.setFont(font_12);
		idTextField.setBounds(135, 278, 232, 20);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel nameLable = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		nameLable.setFont(font_12);
		nameLable.setBounds(36, 306, 73, 14);
		contentPane.add(nameLable);
		
		nameTextFeild = new JTextField();
		nameTextFeild.setFont(font_12);
		nameTextFeild.setBounds(135, 303, 232, 20);
		contentPane.add(nameTextFeild);
		nameTextFeild.setColumns(10);
		
		JLabel ngaySinhLable = new JLabel("Ng\u00E0y sinh");
		ngaySinhLable.setFont(font_12);
		ngaySinhLable.setBounds(36, 330, 73, 14);
		contentPane.add(ngaySinhLable);
		
		dateOfBirthTextField = new JTextField();
		dateOfBirthTextField.setFont(font_12);
		dateOfBirthTextField.setBounds(135, 327, 232, 20);
		contentPane.add(dateOfBirthTextField);
		dateOfBirthTextField.setColumns(10);
		
		JLabel queQuanLable = new JLabel("Qu\u00EA qu\u00E1n");
		queQuanLable.setFont(font_12);
		queQuanLable.setBounds(36, 355, 73, 14);
		contentPane.add(queQuanLable);
		
		JLabel diemToanLable = new JLabel("\u0110i\u1EC3m to\u00E1n");
		diemToanLable.setFont(font_12);
		diemToanLable.setBounds(398, 281, 73, 14);
		contentPane.add(diemToanLable);
		
		diemToanTextFeild = new JTextField();
		diemToanTextFeild.setText("0");
		diemToanTextFeild.setFont(font_12);
		diemToanTextFeild.setBounds(496, 278, 232, 20);
		contentPane.add(diemToanTextFeild);
		diemToanTextFeild.setColumns(10);
		
		JLabel diemHoaLable = new JLabel("\u0110i\u1EC3m ho\u00E1");
		diemHoaLable.setFont(font_12);
		diemHoaLable.setBounds(398, 306, 60, 14);
		contentPane.add(diemHoaLable);
		
		diemHoaTextFeild = new JTextField();
		diemHoaTextFeild.setText("0");
		diemHoaTextFeild.setFont(font_12);
		diemHoaTextFeild.setBounds(496, 303, 232, 20);
		contentPane.add(diemHoaTextFeild);
		diemHoaTextFeild.setColumns(10);
		
		JLabel diemLyLable = new JLabel("\u0110i\u1EC3m l\u00FD");
		diemLyLable.setFont(font_12);
		diemLyLable.setBounds(398, 330, 73, 14);
		contentPane.add(diemLyLable);
		
		diemLyTextFeild = new JTextField();
		diemLyTextFeild.setText("0");
		diemLyTextFeild.setFont(font_12);
		diemLyTextFeild.setBounds(496, 327, 232, 20);
		contentPane.add(diemLyTextFeild);
		diemLyTextFeild.setColumns(10);
		
		JLabel totalLable = new JLabel("T\u1ED5ng \u0111i\u1EC3m");
		totalLable.setFont(font_12);
		totalLable.setBounds(398, 355, 73, 14);
		contentPane.add(totalLable);
		
		totalTextField = new JTextField();
		totalTextField.setFont(font_12);
		totalTextField.setBounds(496, 352, 232, 20);
		contentPane.add(totalTextField);
		totalTextField.setColumns(10);
		
		JLabel gioiTinhLable = new JLabel("Gi\u1EDBi t\u00EDnh");
		gioiTinhLable.setFont(font_12);
		gioiTinhLable.setBounds(36, 380, 73, 14);
		contentPane.add(gioiTinhLable);
		
		namRadioBtn = new JRadioButton("Nam");
		namRadioBtn.setFont(font_12);
		namRadioBtn.setBounds(135, 376, 49, 23);
		contentPane.add(namRadioBtn);
		
		nuRadioBtn = new JRadioButton("N\u1EEF");
		nuRadioBtn.setFont(font_12);
		nuRadioBtn.setBounds(211, 376, 60, 23);
		contentPane.add(nuRadioBtn);
		
		gioiTinh = new ButtonGroup();
		gioiTinh.add(namRadioBtn);
		gioiTinh.add(nuRadioBtn);
		
		queQuanOfInfoComboBox = new JComboBox();
		queQuanOfInfoComboBox.setFont(font_12);
		for(Province tinh : listTinh) {
			queQuanOfInfoComboBox.addItem(tinh.getTenTinhString());
		}
		queQuanOfInfoComboBox.setSelectedIndex(-1);
		queQuanOfInfoComboBox.setBounds(135, 352, 232, 22);
		contentPane.add(queQuanOfInfoComboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 430, 692, 40);
		panel.setLayout(new GridLayout(1,5,1,5));
		contentPane.add(panel);
		
		JButton insertBtn = new JButton("Th\u00EAm");
		insertBtn.addActionListener(acQLSVController);
		insertBtn.setFont(font_12);
		panel.add(insertBtn);
		
		JButton removeBtn = new JButton("Xo\u00E1");
		removeBtn.addActionListener(acQLSVController);
		removeBtn.setFont(font_12);
		panel.add(removeBtn);
		
		JButton editBtn = new JButton("S\u1EEDa");
		editBtn.addActionListener(acQLSVController);
		editBtn.setFont(font_12);
		panel.add(editBtn);
		
		JButton okBtn = new JButton("L??u");
		okBtn.addActionListener(acQLSVController);
		okBtn.setFont(font_12);
		panel.add(okBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(acQLSVController);
		cancelBtn.setFont(font_12);
		panel.add(cancelBtn);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 405, 746, 2);
		contentPane.add(separator_3);
		
		this.setVisible(true);
	}
	
}
