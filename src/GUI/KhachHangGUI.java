package GUI;

import BUS.KhachHangBUS;
import DTO.CheckInput;
import DTO.CustomerDTO;
import DTO.StaffDTO;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class KhachHangGUI extends JPanel {
	KhachHangGUI() throws ClassNotFoundException, SQLException{
		init();
	}
	String ID;
	JTextField search;
	JTextField txttenKH,txthoKH,txtdiachi,txtsdt;
	JTable table=new JTable();
	DefaultTableModel model = new DefaultTableModel();
	JPanel main;
	KhachHangBUS khBUS=new KhachHangBUS();
	public void init() throws ClassNotFoundException, SQLException {
		setBounds(0,0,1150,800);
		setLayout(null);
		Font font = new Font("Segoe UI",1,17);
		Font font1 = new Font("Tahoma",0,17);
		loadSP();
		
		main=new JPanel();
		main.setBounds(0,0,1150,800);
		main.setLayout(new BorderLayout());
		
		JPanel marginLeft=new JPanel();
		marginLeft.setPreferredSize(new Dimension(60,0));
		marginLeft.setBackground(Color.white);
		JPanel marginRight=new JPanel();
		marginRight.setPreferredSize(new Dimension(60,0));
		marginRight.setBackground(Color.white);
		
		JPanel header=new JPanel();
		header.setPreferredSize(new Dimension(0,250));
		header.setBackground(Color.white);
		header.setLayout(null);
		
		JLabel maKH=new JLabel("Mã Khách Hàng");
		maKH.setBounds(0,20,150,50);
		maKH.setFont(font);
		JLabel txtmaKH=new JLabel();
		txtmaKH.setBounds(150,30,200,32);
		txtmaKH.setBorder(BorderFactory.createLineBorder(Color.black));
		txtmaKH.setOpaque(true);
		txtmaKH.setFont(font1);
		
		JLabel hoKH=new JLabel("Họ Và Tên");
		hoKH.setBounds(0,80,150,50);
		hoKH.setFont(font);
		txthoKH=new JTextField();
		txthoKH.setBounds(150,90,170,32);
		txthoKH.setBorder(BorderFactory.createLineBorder(Color.black));
		txthoKH.setOpaque(true);
		txthoKH.setFont(font1);
		txthoKH.setBackground(Color.white);
		txttenKH=new JTextField();
		txttenKH.setBounds(380,90,170,32);
		txttenKH.setBorder(BorderFactory.createLineBorder(Color.black));
		txttenKH.setOpaque(true);
		txttenKH.setFont(font1);
		txttenKH.setBackground(Color.white);
		JLabel diachi=new JLabel("Địa Chỉ");
		diachi.setBounds(0,140,150,50);
		diachi.setFont(font);
		txtdiachi=new JTextField();
		txtdiachi.setBounds(150,150,400,32);
		txtdiachi.setBorder(BorderFactory.createLineBorder(Color.black));
		txtdiachi.setOpaque(true);
		txtdiachi.setFont(font1);
		txtdiachi.setBackground(Color.white);
		JLabel sdt=new JLabel("Số Điện Thoại");
		sdt.setBounds(0,200,150,50);
		sdt.setFont(font);
		txtsdt=new JTextField();
		txtsdt.setBounds(150,210,400,32);
		txtsdt.setBorder(BorderFactory.createLineBorder(Color.black));
		txtsdt.setOpaque(true);
		txtsdt.setFont(font1);
		txtsdt.setBackground(Color.white);
		
		JButton them=new JButton();
		them.setFocusable(false);
		them.setBorder(BorderFactory.createEmptyBorder());
		them.setBounds(820, 20,180,50);
		them.setBackground(new java.awt.Color(255,215,0));
		them.setLayout(null);
		them.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							boolean check=true;
							if(txthoKH.getText().isEmpty()||txttenKH.getText().isEmpty()||txtdiachi.getText().isEmpty()||txtsdt.getText().isEmpty())
							{
								new ThongBaoGUI("   Vui lòng nhập đầy đủ thông tin");
								check=false;
							}
							if(check) {
								if(CheckInput.checkString(txthoKH.getText())==false||CheckInput.checkString(txttenKH.getText())==false||CheckInput.checkString(txtdiachi.getText())==false)
								{
									new ThongBaoGUI("   Không được nhập ký tự đặc biệt");
									check=false;
								}
								if(check==true&&CheckInput.checkPhoneNumber(txtsdt.getText())==false) {
									new ThongBaoGUI("   Số điện thoại không hợp lệ");
									check=false;
								}
							}
							if(check) {
								CustomerDTO kh=new CustomerDTO();
								kh.hoKH=txthoKH.getText();
								kh.tenKH=txttenKH.getText();
								kh.diachi=txtdiachi.getText();
								kh.phone=txtsdt.getText();
								khBUS.add(kh);
								outModel(model,khBUS.getList());	
								clearData();
								new ThongBaoGUI("Thêm Thông Tin Khách Hàng Thành Công!");
							}
						} catch (Exception e) {
							// TODO: handle exception
						}	
						
					}
				});
		JLabel txtthem=new JLabel("THÊM");
		txtthem.setForeground(Color.white);
		txtthem.setFont(new Font(Font.SERIF, 1, 27));
		txtthem.setBounds(70,10,100,30);
		JLabel iconct=new JLabel(new ImageIcon("image/plus.png"));
		iconct.setBounds(20, 5, 40, 40);
		them.add(txtthem);
		them.add(iconct);
		JButton sua=new JButton();
		sua.setFocusable(false);
		sua.setBorder(BorderFactory.createEmptyBorder());
		sua.setBounds(820, 80,180,50);
		sua.setBackground(new java.awt.Color(30,144,255));
		sua.setLayout(null);
		sua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=table.getSelectedRow();
				if(i!=-1) {
				try {
					boolean check=true;
					if(txthoKH.getText().isEmpty()||txttenKH.getText().isEmpty()||txtdiachi.getText().isEmpty()||txtsdt.getText().isEmpty())
					{
						new ThongBaoGUI("   Vui lòng nhập đầy đủ thông tin");
						check=false;
					}
					if(check) {
						if(CheckInput.checkString(txthoKH.getText())==false||CheckInput.checkString(txttenKH.getText())==false||CheckInput.checkString(txtdiachi.getText())==false)
						{
							new ThongBaoGUI("   Không được nhập ký tự đặc biệt");
							check=false;
						}
						if(check==true&&CheckInput.checkPhoneNumber(txtsdt.getText())==false) {
							new ThongBaoGUI("   Số điện thoại không hợp lệ");
							check=false;
						}
					}
					if(check) {
						search.setText("");
						ArrayList<CustomerDTO> dskh=khBUS.getList();
						CustomerDTO kh=new CustomerDTO();
						kh.maKH=Integer.parseInt(ID);
						kh.hoKH=txthoKH.getText();
						kh.tenKH=txttenKH.getText();
						kh.diachi=txtdiachi.getText();
						kh.phone=txtsdt.getText();
						khBUS.set(kh);
						outModel(model,khBUS.getList());	
						new ThongBaoGUI("Sửa Thông Tin Khách Hàng Thành Công!");
					}
				}catch (Exception a) {
					// TODO: handle exception
					System.out.print("fail");
				}	
				}
			}
		});
		JLabel txtsua=new JLabel("SỬA");
		txtsua.setForeground(Color.white);
		txtsua.setFont(new Font(Font.SERIF, 1, 27));
		txtsua.setBounds(85,10,100,30);
		JLabel iconsua=new JLabel(new ImageIcon("image/fix.png"));
	    iconsua.setBounds(20, 5, 40, 40);
		sua.add(txtsua);
		sua.add(iconsua);
		JButton xoa=new JButton();
		xoa.setFocusable(false);
		xoa.setBorder(BorderFactory.createEmptyBorder());
		xoa.setBounds(820, 140,180,50);
		xoa.setBackground(new java.awt.Color(220,20,60));
		xoa.setLayout(null);
		xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=table.getSelectedRow();
				if(i!=-1) {
					try {
						search.setText("");
						ArrayList<CustomerDTO> dskh=khBUS.getList();
						khBUS.delete(Integer.parseInt(ID));
						outModel(model, khBUS.getList());
						clearData();
						new ThongBaoGUI("Xóa Thông Tin Khách Hàng Thành Công!");
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		JLabel txtxoa=new JLabel("XÓA");
		txtxoa.setForeground(Color.white);
		txtxoa.setFont(new Font(Font.SERIF, 1, 27));
		txtxoa.setBounds(85,10,100,30);
		JLabel iconxoa=new JLabel(new ImageIcon("image/del.png"));
		iconxoa.setBounds(20, 5, 40, 40);
		xoa.add(txtxoa);
		xoa.add(iconxoa);
		
		JButton export=new JButton();
		export.setBounds(820,200,180,50);
		export.setLayout(null);
		export.setFocusable(false);
		export.setBackground(new java.awt.Color(128,0,128));
		export.setBorder(BorderFactory.createEmptyBorder());
		export.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
			           JFileChooser jFileChooser = new JFileChooser();
			           jFileChooser.showOpenDialog(null);
			           File saveFile = jFileChooser.getSelectedFile();
			           
			           if(saveFile != null){
			               saveFile = new File(saveFile.toString()+".xlsx");
			               Workbook wb = new XSSFWorkbook();
			               Sheet sheet = wb.createSheet("customer");
			               
			               Row rowCol = sheet.createRow(0);
			               for(int i=0;i<table.getColumnCount();i++){
			                   Cell cell = rowCol.createCell(i);
			                   cell.setCellValue(table.getColumnName(i));
			               }
			               
			               for(int j=0;j<table.getRowCount();j++){
			                   Row row = sheet.createRow(j+1);
			                   for(int k=0;k<table.getColumnCount();k++){
			                       Cell cell = row.createCell(k);
			                       if(table.getValueAt(j, k)!=null){
			                           cell.setCellValue(table.getValueAt(j, k).toString());
			                       }
			                   }
			               }
			               FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
			               wb.write(out);
			               wb.close();
			               out.close();
			               openFile(saveFile.toString());
			           }else{
			               JOptionPane.showMessageDialog(null,"Bạn đã hủy xuất file");
			           }
			       }catch(FileNotFoundException e1){
			           System.out.println(e1);
			       }catch(IOException io){
			           System.out.println(io);
			       }
			}
		});
		JLabel txtexport=new JLabel("XUẤT");
		txtexport.setForeground(Color.white);
		txtexport.setBounds(85,10,100,30);
		txtexport.setFont(new Font(Font.SERIF, 1, 27));
		JLabel iconexport=new JLabel(new ImageIcon("image/export.png"));
		iconexport.setBounds(20, 5, 40, 40);
		export.add(txtexport);
		export.add(iconexport);
		
		JButton importfile=new JButton();
		importfile.setBounds(620,200,180,50);
		importfile.setLayout(null);
		importfile.setFocusable(false);
		importfile.setBackground(new java.awt.Color(0,255,127));
		importfile.setBorder(BorderFactory.createEmptyBorder());
		importfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//String currentDirectoryPath="C:\\Users\\Authentic\\Desktop";
				DefaultTableModel importModel=(DefaultTableModel) table.getModel();
				
				FileInputStream excelFIS=null;
				BufferedInputStream excelBIS=null;
				XSSFWorkbook excelImportWorkbook=null;
				JFileChooser excelFileChooserImport=new JFileChooser();
				FileNameExtensionFilter excelFileNameExtensionFilter=new FileNameExtensionFilter("EXCEL FILE", "xls","xlsx","xslm");
				excelFileChooserImport.setFileFilter(excelFileNameExtensionFilter);
				int excelChooser=excelFileChooserImport.showOpenDialog(null);
				if(excelChooser==JFileChooser.APPROVE_OPTION) {
					try {
						File excelFile=excelFileChooserImport.getSelectedFile();
						excelFIS=new FileInputStream(excelFile);
						excelBIS=new BufferedInputStream(excelFIS);
						excelImportWorkbook=new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheet=excelImportWorkbook.getSheetAt(0);
						importModel.setRowCount(0);
						for(int i=1;i<=excelSheet.getLastRowNum();i++) {
							XSSFRow excelRow=excelSheet.getRow(i);
							XSSFCell i1=excelRow.getCell(0);
							XSSFCell i2=excelRow.getCell(1);
							XSSFCell i3=excelRow.getCell(2);
							XSSFCell i4=excelRow.getCell(3);
							XSSFCell i5=excelRow.getCell(4);
							importModel.addRow(new Object[] {i1,i2,i3,i4,i5});
						}
						new ThongBaoGUI("     Import File Excel Thành Công!");
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		
		JLabel txtimportfile=new JLabel("NHẬP");
		txtimportfile.setForeground(Color.white);
		txtimportfile.setBounds(85,10,100,30);
		txtimportfile.setFont(new Font(Font.SERIF, 1, 27));
		JLabel iconimportfile=new JLabel(new ImageIcon("image/import.png"));
		iconimportfile.setBounds(20, 5, 40, 40);
		importfile.add(txtimportfile);
		importfile.add(iconimportfile);
		
		JLabel icon=new JLabel(new ImageIcon("image/rating.png"));
		icon.setBounds(620, 30, 128, 128);

		header.add(maKH);
		header.add(txtmaKH);
		header.add(hoKH);
		header.add(txthoKH);
		header.add(txttenKH);
		header.add(diachi);
		header.add(txtdiachi);
		header.add(sdt);
		header.add(txtsdt);
		header.add(them);
		header.add(sua);
		header.add(xoa);
		header.add(export);
		header.add(importfile);
		header.add(icon);
	    
	 
	    
		
		JPanel HeaderTable=new JPanel();
		HeaderTable.setBounds(0, 150, 1150, 40);
		HeaderTable.setBackground(Color.red);
		HeaderTable.setLayout(null);
		JLabel colmaKH=new JLabel("Mã KH");
		colmaKH.setForeground(Color.white);
		colmaKH.setBounds(0,0,200,40);
		colmaKH.setFont(font);
		HeaderTable.add(colmaKH);
		JLabel colhoKH=new JLabel("Họ Khách Hàng");
		colhoKH.setForeground(Color.white);
		colhoKH.setBounds(110,0,200,40);
		colhoKH.setFont(font);
		HeaderTable.add(colhoKH);
		JLabel coltenKH=new JLabel("Tên Khách Hàng");
		coltenKH.setForeground(Color.white);
		coltenKH.setBounds(324,0,200,40);
		coltenKH.setFont(font);
		HeaderTable.add(coltenKH);
		JLabel coldiachi=new JLabel("Địa Chỉ");
		coldiachi.setForeground(Color.white);
		coldiachi.setBounds(532,0,200,40);
		coldiachi.setFont(font); 
		HeaderTable.add(coldiachi);
		JLabel colsdt=new JLabel("Số Điện Thoại");
		colsdt.setForeground(Color.white);
		colsdt.setBounds(817,0,200,40);
		colsdt.setFont(font);
		HeaderTable.add(colsdt);
		
		JPanel centerTable=new JPanel();
		centerTable.setBounds(0,190,1030,350);
		centerTable.setLayout(null);
		centerTable.setBackground(Color.white);
		
		table.setBounds(0,0,1030,350);
		table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		table.setRowHeight(60);
		table.setShowGrid(false);
	    table.setShowVerticalLines(false);
	    table.setShowHorizontalLines(true);
	    table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int i = table.getSelectedRow(); 
				ID=table.getModel().getValueAt(i, 0).toString();
				txtmaKH.setText(table.getModel().getValueAt(i, 0).toString());
				txthoKH.setText(table.getModel().getValueAt(i, 1).toString());
				txttenKH.setText(table.getModel().getValueAt(i, 2).toString());
				txtdiachi.setText(table.getModel().getValueAt(i, 3).toString());
				txtsdt.setText(table.getModel().getValueAt(i, 4).toString());
			}
		});
	    JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -22, 1035 , 320);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5,100));
        
        JButton save=new JButton();
        save.setLayout(null);
        save.setBackground(Color.black);
        save.setFocusable(false);
        save.setBorder(BorderFactory.createEmptyBorder());
        save.setBounds(945, 305, 80, 25);
        JLabel iconsave=new JLabel(new ImageIcon("image/save.png"));
        iconsave.setBounds(7, 2, 20, 20);
        JLabel txtsave=new JLabel("Save");
        txtsave.setFont(new Font("Tahoma", 1, 15));
        txtsave.setForeground(Color.white);
        txtsave.setBounds(35, 2, 40, 20);
        save.add(iconsave);
        save.add(txtsave);
        save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ArrayList<CustomerDTO> temp=new ArrayList<>();
					for(int i=0;i<table.getRowCount();i++)
					{
						CustomerDTO kh=new CustomerDTO();
						kh.hoKH=table.getModel().getValueAt(i, 1).toString();
						kh.tenKH=table.getModel().getValueAt(i, 2).toString();
						kh.diachi=table.getModel().getValueAt(i, 3).toString();
						kh.phone=table.getModel().getValueAt(i, 4).toString();
						temp.add(kh);
					}
					ArrayList<CustomerDTO> dskh=khBUS.getList();
					for(int i=0;i<dskh.size();i++)
					{
						temp.get(i).maKH=dskh.get(i).maKH;
					}
					khBUS.updateData(temp);
					outModel(model, khBUS.getList());
					new ThongBaoGUI("Cập nhật dữ liệu thành công!");
				}catch (Exception e1) {
					new ThongBaoGUI("Dữ liệu không hợp lệ! Vui lòng kiểm tra lại!");
				}
			}
		});
        
        centerTable.add(scroll);
        centerTable.add(save);
		
		JPanel line=new JPanel();
		line.setBounds(0, 40, 1150, 1);
		line.setBackground(Color.black);
		JLabel searchtenKH=new JLabel("Tìm Kiếm Theo Tên");
		searchtenKH.setBounds(180, 80, 200, 40);
		searchtenKH.setFont(new Font("Tahoma", 0, 20));
		search=new JTextField();
		search.setBounds(370, 85, 350, 30);
		JLabel iconsearch=new JLabel(new ImageIcon("image/search.png"));
		iconsearch.setBounds(750, 80, 40, 40);
		iconsearch.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(search.getText().equals("")==false) {
					String s=search.getText();
					outModel(model, khBUS.search(s));
				}else {
					outModel(model, khBUS.getList());
				}
			}
		});
        
        JPanel center=new JPanel();
		center.setLayout(null);
		center.setBackground(Color.white);
		center.add(line);
		center.add(searchtenKH);
		center.add(search);
		center.add(iconsearch);
		center.add(HeaderTable);
		center.add(centerTable);
		
		
		JPanel content=new JPanel();
		content.setLayout(new BorderLayout());
		content.add(header,BorderLayout.NORTH);
		content.add(center,BorderLayout.CENTER);
		
		main.add(marginLeft,BorderLayout.WEST);
		main.add(content,BorderLayout.CENTER);
		main.add(marginRight,BorderLayout.EAST);
		
		add(main);		
	}
	public void clearData() {
		txthoKH.setText("");
		txttenKH.setText("");
		txtdiachi.setText("");
		txtsdt.setText("");
	}
	public void loadSP() throws ClassNotFoundException, SQLException {
		if(khBUS.getList()==null) khBUS.list();
		ArrayList<CustomerDTO> kh=new ArrayList<>();
		kh=khBUS.getList();
		outModel(model,kh);	
	}
	public void outModel(DefaultTableModel model , ArrayList<CustomerDTO> kh) {
		Vector header=new Vector();
		header.add("Mã khách hàng");
		header.add("Họ khách hàng");
		header.add("Tên khách hàng");
		header.add("Địa chỉ");
		header.add("Số điện thoại");
		model = new DefaultTableModel(header,0);
		for(CustomerDTO cus : kh)
		{
			Vector row=new Vector();
			row.add(cus.maKH);
			row.add(cus.hoKH);
			row.add(cus.tenKH);
			row.add(cus.diachi);
			row.add(cus.phone);
			model.addRow(row);
		}
		table.setModel(model);
		TableColumnModel col=table.getColumnModel();
		col.getColumn(0).setPreferredWidth(80);
		col.getColumn(1).setPreferredWidth(180);
		col.getColumn(2).setPreferredWidth(180);
		col.getColumn(3).setPreferredWidth(250);
		col.getColumn(4).setPreferredWidth(180);
	}
	public void openFile(String file){
        try{
            File path = new File(file);
            Desktop.getDesktop().open(path);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
}

