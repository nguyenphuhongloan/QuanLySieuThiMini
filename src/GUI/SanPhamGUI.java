package GUI;

import BUS.SanPhamBUS;
import DTO.CheckInput;
import DTO.ProductDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class SanPhamGUI extends JPanel {
	private SanPhamBUS spBUS = new SanPhamBUS();
	String ID;
	SanPhamGUI() throws ClassNotFoundException, SQLException{
		init();
	}
	JTextField txtimgSP;
	JTextField search;
	JTextField txttenSP;
	JTextField txtslSP;
	JTextField txtgiaSP;
	JTextField txtdonviSP;
	JTextField giatu;
	JTextField giaden;
	JComboBox cmbDVT,cmbLoai,cmbLoaiSearch; 
	JTextField txtmaNSX;
	JTextField txtloai; 
	JTable table=new JTable();
	DefaultTableModel model = new DefaultTableModel();
	public void init() throws ClassNotFoundException, SQLException {
		setBounds(0,0,1150,800);
		setLayout(new BorderLayout());
		Font font = new Font("Segoe UI",1,17);
		loadSP();
		
		JPanel marginLeftContentRight=new JPanel();
		marginLeftContentRight.setPreferredSize(new Dimension(60,0));
		
		JPanel contentRightHeader1=new JPanel();
		contentRightHeader1.setPreferredSize(new Dimension(270,0));
		contentRightHeader1.setLayout(null);
		JLabel img=new JLabel();
		img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		img.setOpaque(true);
		img.setBounds(0,20,270,300);
		img.setBackground(Color.white);
		contentRightHeader1.add(img);
		
		JPanel contentRightHeader2=new JPanel();
		contentRightHeader2.setLayout(null);
		JLabel imgSP=new JLabel("Ảnh Sản Phẩm");
		imgSP.setBounds(40,20,150,40);
		imgSP.setFont(font);
		txtimgSP=new JTextField();
		txtimgSP.setBounds(190,20,180,40);
		JButton choose=new JButton("Chọn File");
		choose.setBounds(390, 20, 80, 40);
		choose.setFocusable(false);
		choose.setFont(font);
		choose.setFont(new Font("Tahoma", 0, 11));
		choose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser file = new JFileChooser("Image/");
				int status = file.showOpenDialog(null);
				if(status == JFileChooser.APPROVE_OPTION){
					File dir = file.getSelectedFile();
					txtimgSP.setText(dir.getName());
				}
			}
		});
		JLabel tenSP=new JLabel("Tên Sản Phẩm");
		tenSP.setBounds(40,70,150,40);
		tenSP.setFont(font);
		txttenSP=new JTextField();
		txttenSP.setBounds(190,70,280,40);
		JLabel slSP=new JLabel("Số Lượng");
		slSP.setBounds(40,120,150,40);
		slSP.setFont(font);
		txtslSP=new JTextField();
		txtslSP.setBounds(190,120,280,40);
		JLabel giaSP=new JLabel("Đơn Giá (VNĐ)");
		giaSP.setBounds(40,170,150,40);
		giaSP.setFont(font);
		txtgiaSP=new JTextField();
		txtgiaSP.setBounds(190,170,280,40);
		JLabel donviSP=new JLabel("Đơn Vị Tính");
		donviSP.setBounds(40,220,150,40);
		donviSP.setFont(font);
		String[] DVT ={"Lon","Hộp","Chai","Gói","Cái","Tuýp"};
		cmbDVT = new JComboBox(DVT);
        cmbDVT.setBounds(190,220,280,40);
        cmbDVT.setFont(new Font("Segoe UI",2,17));
        cmbDVT.setFocusable(false);
        cmbDVT.setBackground(Color.white);
		JLabel loai=new JLabel("Loại Sản Phẩm");
		loai.setBounds(40,270,150,40);
		loai.setFont(font);
		String[] Loai ={"Thức Ăn","Nước","Vệ Sinh","Gia Vị","Đồ Dùng"};
		cmbLoai = new JComboBox(Loai);
		cmbLoai.setBounds(190,270,280,40);
		cmbLoai.setFont(new Font("Segoe UI",2,15));
		cmbLoai.setFocusable(false);
		cmbLoai.setBackground(Color.white);
		contentRightHeader2.add(imgSP);
		contentRightHeader2.add(txtimgSP);
		contentRightHeader2.add(choose);
		contentRightHeader2.add(tenSP);
		contentRightHeader2.add(txttenSP);
		contentRightHeader2.add(slSP);
		contentRightHeader2.add(txtslSP);
		contentRightHeader2.add(giaSP);
		contentRightHeader2.add(txtgiaSP);
		contentRightHeader2.add(donviSP);
		contentRightHeader2.add(cmbDVT);
		contentRightHeader2.add(loai);
		contentRightHeader2.add(cmbLoai);
		
		
		JPanel contentRightHeader3=new JPanel();
		contentRightHeader3.setPreferredSize(new Dimension(250,0));
		contentRightHeader3.setLayout(null);
		JButton them=new JButton();
		them.setBounds(20,20,180,50);
		them.setLayout(null);
		them.setFocusable(false);
		them.setBackground(new java.awt.Color(255,215,0));
		them.setBorder(BorderFactory.createEmptyBorder());
		them.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							boolean check=true;
							ProductDTO sp=new ProductDTO();
							if(txttenSP.getText().isEmpty()||txtgiaSP.getText().isEmpty()||txtslSP.getText().isEmpty()){
								new ThongBaoGUI("Vui lòng nhập tên/giá/số lượng sản phẩm");
								check=false;
							}
							if(check) {
								if(CheckInput.checkStringNumber(txtgiaSP.getText())==false||CheckInput.checkStringNumber(txtslSP.getText())==false)
								{
									new ThongBaoGUI("Giá hoặc số lượng sản phẩm không hợp lệ");
									check=false;
								}
								if((CheckInput.checkInt(txtgiaSP.getText())==false||CheckInput.checkInt(txtslSP.getText())==false)&&check==true)
								{
									new ThongBaoGUI("Giá hoặc số lượng sản phẩm không hợp lệ");
									check=false;
								}
								if(CheckInput.checkString(txttenSP.getText())==false&&check==true) {
									new ThongBaoGUI("Tên sản phẩm không được chứa ký tự đặc biệt");
									check=false;
								}
							}
							if(check){
								sp.tenSP=txttenSP.getText();
								sp.image=txtimgSP.getText();
								sp.giaSP=Integer.parseInt(txtgiaSP.getText());
								sp.slSP=Integer.parseInt(txtslSP.getText());
								sp.donviSP=(String) cmbDVT.getItemAt(cmbDVT.getSelectedIndex());
								sp.loaiSP=(String) cmbLoai.getItemAt(cmbLoai.getSelectedIndex());
								spBUS.add(sp);
								outModel(model,spBUS.getList());
								clearData();
								new ThongBaoGUI("     Thêm sản phẩm thành công!");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
		JLabel addsp=new JLabel("THÊM");
		addsp.setForeground(Color.white);
		addsp.setBounds(70,10,100,30);
		addsp.setFont(new Font(Font.SERIF, 1, 27));
		ImageIcon icon8=new ImageIcon("image/plus.png");
		JLabel iconadd=new JLabel(icon8);
		iconadd.setBounds(20, 5, 40, 40);
		
		JButton sua=new JButton();
		sua.setBounds(20,80,180,50);
		sua.setLayout(null);
		sua.setFocusable(false);
		sua.setBackground(new java.awt.Color(30,144,255));
		sua.setBorder(BorderFactory.createEmptyBorder());
		sua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=table.getSelectedRow();
				if(i!=-1) {
					try {
						boolean check=true;
						if(txttenSP.getText().isEmpty()||txtgiaSP.getText().isEmpty()||txtslSP.getText().isEmpty()){
							new ThongBaoGUI("Vui lòng nhập tên/giá/số lượng sản phẩm");
							check=false;
						}
						if(check) {
							if(CheckInput.checkStringNumber(txtgiaSP.getText())==false||CheckInput.checkStringNumber(txtslSP.getText())==false)
							{
								new ThongBaoGUI("Giá hoặc số lượng sản phẩm không hợp lệ");
								check=false;
							}
							if((CheckInput.checkInt(txtgiaSP.getText())==false||CheckInput.checkInt(txtslSP.getText())==false)&&check==true)
							{
								new ThongBaoGUI("Giá hoặc số lượng sản phẩm không hợp lệ");
								check=false;
							}
							if(CheckInput.checkString(txttenSP.getText())==false&&check==true) {
								new ThongBaoGUI("Tên sản phẩm không được chứa ký tự đặc biệt");
								check=false;
							}
						}
						if(check){
							cmbLoaiSearch.setSelectedIndex(0);
							giatu.setText("");
							giaden.setText("");
							search.setText("");
							ArrayList<ProductDTO> dssp=spBUS.getList();
							ProductDTO sp=new ProductDTO();
							sp.maSP=Integer.parseInt(ID);
							sp.tenSP=txttenSP.getText();
							sp.image=txtimgSP.getText();
							sp.giaSP=Integer.parseInt(txtgiaSP.getText());
							sp.slSP=Integer.parseInt(txtslSP.getText());
							sp.donviSP=(String) cmbDVT.getItemAt(cmbDVT.getSelectedIndex());
							sp.loaiSP=(String) cmbLoai.getItemAt(cmbLoai.getSelectedIndex());
							spBUS.set(sp);
							outModel(model,spBUS.getList());
							new ThongBaoGUI("       Sửa sản phẩm thành công!");
						}
					}catch (Exception a) {
						// TODO: handle exception
						System.out.print("fail");
					}
				}else {
					new ThongBaoGUI("Vui lòng chọn hàng cần sửa!");
				}
			}
		});
		JLabel suasp=new JLabel("SỬA");
		suasp.setForeground(Color.white);
		suasp.setBounds(85,10,100,30);
		suasp.setFont(new Font(Font.SERIF, 1, 27));
		ImageIcon icon9=new ImageIcon("image/fix.png");
		JLabel iconfix=new JLabel(icon9);
		iconfix.setBounds(20, 5, 40, 40);
		
		JButton xoa=new JButton();
		xoa.setBounds(20,140,180,50);
		xoa.setLayout(null);
		xoa.setFocusable(false);
		xoa.setBackground(new java.awt.Color(220,20,60));
		xoa.setBorder(BorderFactory.createEmptyBorder());
		xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=table.getSelectedRow();
				if(i!=-1) {
					try {
						cmbLoaiSearch.setSelectedIndex(0);
						giatu.setText("");
						giaden.setText("");
						search.setText("");
						ArrayList<ProductDTO> dssp=spBUS.getList();
						spBUS.delete(Integer.parseInt(ID));
						outModel(model, spBUS.getList());
						clearData();
						new ThongBaoGUI("       Xóa sản phẩm thành công!");
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				else {
					new ThongBaoGUI("Chọn dòng cần xóa");
				}
			}
		});
		JLabel xoasp=new JLabel("XÓA");
		xoasp.setForeground(Color.white);
		xoasp.setBounds(85,10,100,30);
		xoasp.setFont(new Font(Font.SERIF, 1, 27));
		ImageIcon icon10=new ImageIcon("image/del.png");
		JLabel icondel=new JLabel(icon10);
		icondel.setBounds(20, 5, 40, 40);
		
		JButton export=new JButton();
		export.setBounds(20,200,180,50);
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
		
		JButton importfile=new JButton();
		importfile.setBounds(20,260,180,50);
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
							XSSFCell excelImportedID=excelRow.getCell(0);
							XSSFCell excelImportedName=excelRow.getCell(1);
							XSSFCell excelImportedAmount=excelRow.getCell(2);
							XSSFCell excelImportedPrice=excelRow.getCell(3);
							XSSFCell excelImportedUnit=excelRow.getCell(4);
							XSSFCell excelImportedType=excelRow.getCell(5);
							XSSFCell excelImportedImage=excelRow.getCell(6);
							importModel.addRow(new Object[] {excelImportedID,excelImportedName,excelImportedAmount,excelImportedPrice,excelImportedUnit,excelImportedType,excelImportedImage});
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
		
		them.add(addsp);
		them.add(iconadd);
		sua.add(suasp);
		sua.add(iconfix);
		xoa.add(xoasp);
		xoa.add(icondel);
		export.add(txtexport);
		export.add(iconexport);
		importfile.add(txtimportfile);
		importfile.add(iconimportfile);
		contentRightHeader3.add(them);
		contentRightHeader3.add(sua);
		contentRightHeader3.add(xoa);
		contentRightHeader3.add(export);
		contentRightHeader3.add(importfile);
		
		JPanel contentRightHeader=new JPanel();
		contentRightHeader.setPreferredSize(new Dimension(0,320));
		contentRightHeader.setLayout(new BorderLayout());
		contentRightHeader.add(contentRightHeader1,BorderLayout.WEST);
		contentRightHeader.add(contentRightHeader2,BorderLayout.CENTER);
		contentRightHeader.add(contentRightHeader3,BorderLayout.EAST);
		
		JPanel contentRightCenter=new JPanel();
		contentRightCenter.setLayout(null);
        JLabel sortTitle = new JLabel("------------------------------------------------------------- TÌM KIẾM SẢN PHẨM -------------------------------------------------------------",JLabel.CENTER); // Mỗi bên 74 dấu ( - )
        sortTitle.setBounds(0, 30, 1050, 30);
        sortTitle.setFont(new Font("Tahoma", 0, 18));
        contentRightCenter.add(sortTitle);
		
		JPanel contentRightFooterSearch=new JPanel();
		contentRightFooterSearch.setPreferredSize(new Dimension(0,80));
		contentRightFooterSearch.setLayout(null);
		JLabel tenSPsearch=new JLabel("Tên SP :");
		tenSPsearch.setFont(new Font(Font.SERIF, 0, 20));
		tenSPsearch.setBounds(10,17,100,50);
		search=new JTextField();
		search.setBounds(90,30,150,30);
		contentRightFooterSearch.add(tenSPsearch);
		contentRightFooterSearch.add(search);
		JLabel loaiSPsearch=new JLabel("Loại :");
		loaiSPsearch.setFont(new Font(Font.SERIF, 0, 20));
		loaiSPsearch.setBounds(300,17,55,50);
		String[] LoaiSearch ={"Tất Cả","Thức Ăn","Nước","Vệ Sinh","Gia Vị","Đồ Dùng"};
		cmbLoaiSearch = new JComboBox(LoaiSearch);
		cmbLoaiSearch.setBounds(370,30,110,30);
		cmbLoaiSearch.setFont(new Font("Segoe UI",2,15));
		cmbLoaiSearch.setFocusable(false);
		cmbLoaiSearch.setBackground(Color.white);
		contentRightFooterSearch.add(loaiSPsearch);
		contentRightFooterSearch.add(cmbLoaiSearch);
		JLabel locgia=new JLabel("Giá (VNĐ) :");
		locgia.setFont(new Font(Font.SERIF, 0, 20));
		locgia.setBounds(530,17,110,50);
		giatu=new JTextField();
		giatu.setBounds(644,30,110,30);
		JLabel line=new JLabel(new ImageIcon("image/line.png"));
		line.setBounds(775,32, 24, 24);
		giaden=new JTextField();
		giaden.setBounds(820,30,110,30);
		JLabel iconsearch=new JLabel(new ImageIcon("image/searchgia.png"));
		iconsearch.setBounds(990, 25, 32, 32);
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
				if(search.getText().equals("")==false&&giatu.getText().equals("")&&giaden.getText().equals(""))
				{
					ArrayList<ProductDTO> temp=new ArrayList<>();
					String s=search.getText();
					temp=spBUS.search(s);
					String loai=(String) cmbLoaiSearch.getItemAt(cmbLoaiSearch.getSelectedIndex());
					if(loai.equals("Tất Cả")==false) {
						temp=spBUS.SearchLoai1(temp, loai);
					}
					outModel(model, temp);
				}
				if(search.getText().equals("")&&(giatu.getText().equals("")==false||giaden.getText().equals("")==false))
				{
					boolean check=true;
					ArrayList<ProductDTO> temp=spBUS.getList();
					String p1=giatu.getText(); 
					String p2=giaden.getText(); 
					if(p1.equals("")==false&&p2.equals("")==false) {
						if(CheckInput.checkInt(p1)==true&&CheckInput.checkStringNumber(p1)==true&&CheckInput.checkInt(p2)==true&&CheckInput.checkStringNumber(p2)==true)
						{
							if(Integer.parseInt(p1)>Integer.parseInt(p2)) { 
								giatu.setText(p2);
							    giaden.setText(p1); 
							} 
							temp=spBUS.SearchGia1(temp,Integer.parseInt(p1),Integer.parseInt(p2)); 
						}else {
							new ThongBaoGUI("     Giá nhập không hợp lệ");
							check=false;
						}
					} 
					else if(p1.equals("")==false&&p2.equals("")==true){ 
						if(CheckInput.checkInt(p1)==true&&CheckInput.checkStringNumber(p1)==true) {
							temp=spBUS.SearchGia2(temp,Integer.parseInt(p1)); 
						}else {
							new ThongBaoGUI("     Giá nhập không hợp lệ");
							check=false;
						}
					} 
					else if(p1.equals("")==true&&p2.equals("")==false) {
						if(CheckInput.checkInt(p2)==true&&CheckInput.checkStringNumber(p2)==true) {
							temp=spBUS.SearchGia3(temp,Integer.parseInt(p2)); 
						}else {
							new ThongBaoGUI("     Giá nhập không hợp lệ");
							check=false;
						}
					}
					String loai=(String) cmbLoaiSearch.getItemAt(cmbLoaiSearch.getSelectedIndex());
					if(loai.equals("Tất Cả")==false) {
						temp=spBUS.SearchLoai1(temp, loai);
					}
					if(check) {
						outModel(model, temp); 
					}
				}
				if(search.getText().equals("")==false&&(giatu.getText().equals("")==false||giaden.getText().equals("")==false))
				{
					boolean check=true;
					ArrayList<ProductDTO> temp=new ArrayList<>();
					String s=search.getText();
					temp=spBUS.search(s);
					String p1=giatu.getText(); 
					String p2=giaden.getText(); 
					if(p1.equals("")==false&&p2.equals("")==false) {
						if(CheckInput.checkInt(p1)==true&&CheckInput.checkStringNumber(p1)==true&&CheckInput.checkInt(p2)==true&&CheckInput.checkStringNumber(p2)==true)
						{
							if(Integer.parseInt(p1)>Integer.parseInt(p2)) { 
								giatu.setText(p2);
							    giaden.setText(p1); 
							} 
							temp=spBUS.SearchGia1(temp,Integer.parseInt(p1),Integer.parseInt(p2)); 
						}else {
							new ThongBaoGUI("     Giá nhập không hợp lệ");
							check=false;
						}
					} 
					else if(p1.equals("")==false&&p2.equals("")==true){ 
						if(CheckInput.checkInt(p1)==true&&CheckInput.checkStringNumber(p1)==true) {
							temp=spBUS.SearchGia2(temp,Integer.parseInt(p1)); 
						}else {
							new ThongBaoGUI("     Giá nhập không hợp lệ");
							check=false;
						}
					} 
					else if(p1.equals("")==true&&p2.equals("")==false) {
						if(CheckInput.checkInt(p2)==true&&CheckInput.checkStringNumber(p2)==true) {
							temp=spBUS.SearchGia3(temp,Integer.parseInt(p2)); 
						}else {
							new ThongBaoGUI("     Giá nhập không hợp lệ");
							check=false;
						}
					}
					String loai=(String) cmbLoaiSearch.getItemAt(cmbLoaiSearch.getSelectedIndex());
					if(loai.equals("Tất Cả")==false) {
						temp=spBUS.SearchLoai1(temp, loai);
					}
					if(check) {
						outModel(model, temp);
					}
				}
				if(search.getText().equals("")&&giatu.getText().equals("")&&giaden.getText().equals(""))
				{
					ArrayList<ProductDTO> temp=spBUS.getList();
					String loai=(String) cmbLoaiSearch.getItemAt(cmbLoaiSearch.getSelectedIndex());
					if(loai.equals("Tất Cả")==false) {
						temp=spBUS.SearchLoai1(temp, loai);
					}
					outModel(model, temp);
				}
			}
		});
		contentRightFooterSearch.add(locgia);
		contentRightFooterSearch.add(giatu);
		contentRightFooterSearch.add(line);
		contentRightFooterSearch.add(giaden);
		contentRightFooterSearch.add(iconsearch);
		
		JPanel contentRightFooterTableTop=new JPanel();
		contentRightFooterTableTop.setPreferredSize(new Dimension(0,40));
		contentRightFooterTableTop.setBackground(Color.black);
		contentRightFooterTableTop.setLayout(null);
		JLabel colmaSP=new JLabel("Mã SP");
		colmaSP.setForeground(Color.white);
		colmaSP.setBounds(0,0,80,40);
		colmaSP.setFont(new Font("Tahoma", 1, 17));
		contentRightFooterTableTop.add(colmaSP);
		JLabel coltenSP=new JLabel("Tên Sản Phẩm");
		coltenSP.setForeground(Color.white);
		coltenSP.setBounds(102,0,300,40);
		coltenSP.setFont(new Font("Tahoma", 1, 17));
		contentRightFooterTableTop.add(coltenSP);
		JLabel colslSP=new JLabel("Số Lượng");
		colslSP.setForeground(Color.white);
		colslSP.setBounds(418,0,120,40);
		colslSP.setFont(new Font("Tahoma", 1, 17));
		contentRightFooterTableTop.add(colslSP);
		JLabel colgiaSP=new JLabel("Đơn Giá");
		colgiaSP.setForeground(Color.white);
		colgiaSP.setBounds(550,0,150,40);
		colgiaSP.setFont(new Font("Tahoma", 1, 17));
		contentRightFooterTableTop.add(colgiaSP);
		JLabel coldonviSP=new JLabel("Đơn Vị");
		coldonviSP.setForeground(Color.white);
		coldonviSP.setBounds(717,0,110,40);
		coldonviSP.setFont(new Font("Tahoma", 1, 17));
		contentRightFooterTableTop.add(coldonviSP);
		JLabel colloaiSP=new JLabel("Loại");
		colloaiSP.setForeground(Color.white);
		colloaiSP.setBounds(840,0,70,40);
		colloaiSP.setFont(new Font("Tahoma", 1, 17));
		contentRightFooterTableTop.add(colloaiSP);
		JLabel colimgSP=new JLabel("IMG");
		colimgSP.setForeground(Color.white);
		colimgSP.setBounds(927,0,90,40);
		colimgSP.setFont(new Font("Tahoma", 1, 17));
		contentRightFooterTableTop.add(colimgSP);
		
		
		JPanel contentRightFooterTableCenter=new JPanel();
		contentRightFooterTableCenter.setLayout(null);
		table.setBounds(0,0,1030,260);
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
				String imageSP=table.getModel().getValueAt(i, 6).toString();
				txtimgSP.setText(imageSP);
				txttenSP.setText(table.getModel().getValueAt(i, 1).toString());
				txtslSP.setText(table.getModel().getValueAt(i, 2).toString());
				txtgiaSP.setText(table.getModel().getValueAt(i, 3).toString());
				cmbDVT.setSelectedItem(table.getModel().getValueAt(i, 4).toString());
				cmbLoai.setSelectedItem(table.getModel().getValueAt(i, 5).toString());
				java.awt.Image newImage ;
				try{
				newImage = new ImageIcon("image/"+imageSP).getImage().getScaledInstance(260, 260, 200);
				}catch(NullPointerException E)
                {
                    newImage = new ImageIcon("image/avatar.png").getImage().getScaledInstance(260, 260, 200); 
                }
				img.setIcon(new ImageIcon(newImage));
			}
		});
	    JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -22, 1035 , 260);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5,100));

        JButton save=new JButton();
        save.setLayout(null);
        save.setBackground(Color.black);
        save.setFocusable(false);
        save.setBorder(BorderFactory.createEmptyBorder());
        save.setBounds(945, 243, 80, 25);
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
					ArrayList<ProductDTO> temp=new ArrayList<>();
					for(int i=0;i<table.getRowCount();i++)
					{
						ProductDTO sp=new ProductDTO();
						sp.tenSP=table.getModel().getValueAt(i, 1).toString();
						sp.slSP=Integer.parseInt(table.getModel().getValueAt(i, 2).toString());
						sp.giaSP=Integer.parseInt(table.getModel().getValueAt(i, 3).toString());
						sp.donviSP=table.getModel().getValueAt(i, 4).toString();
						sp.loaiSP=table.getModel().getValueAt(i, 5).toString();
						sp.image=table.getModel().getValueAt(i, 6).toString();
						temp.add(sp);
					}
					ArrayList<ProductDTO> dssp=spBUS.getList();
					for(int i=0;i<dssp.size();i++)
					{
						temp.get(i).maSP=dssp.get(i).maSP;
					}
					spBUS.updateData(temp);
					outModel(model, spBUS.getList());
					new ThongBaoGUI("Cập nhật dữ liệu thành công!");
				}catch (Exception e1) {
					new ThongBaoGUI("Dữ liệu không hợp lệ! Vui lòng kiểm tra lại!");
				}
			}
		});
        
        contentRightFooterTableCenter.add(scroll);
        contentRightFooterTableCenter.add(save);
		
		
		JPanel contentRightFooterTable=new JPanel();
		contentRightFooterTable.setPreferredSize(new Dimension(0,320));
		contentRightFooterTable.setLayout(new BorderLayout());
		contentRightFooterTable.add(contentRightFooterTableTop,BorderLayout.NORTH);
		contentRightFooterTable.add(contentRightFooterTableCenter,BorderLayout.CENTER);
		
		JPanel contentRightFooter=new JPanel();
		contentRightFooter.setPreferredSize(new Dimension(0,400));
		contentRightFooter.setLayout(new BorderLayout());
		contentRightFooter.add(contentRightFooterSearch,BorderLayout.NORTH);
		contentRightFooter.add(contentRightFooterTable,BorderLayout.SOUTH);
		
		JPanel contentRight1=new JPanel();
		contentRight1.setBackground(Color.lightGray);
		contentRight1.setLayout(new BorderLayout());
		contentRight1.add(contentRightHeader, BorderLayout.NORTH);
		contentRight1.add(contentRightCenter, BorderLayout.CENTER);
		contentRight1.add(contentRightFooter,BorderLayout.SOUTH);
		
		JPanel marginRightContentRight=new JPanel();
		marginRightContentRight.setPreferredSize(new Dimension(60,0));
		

		add(marginLeftContentRight,BorderLayout.WEST);
		add(contentRight1,BorderLayout.CENTER);
		add(marginRightContentRight,BorderLayout.EAST);


	}
	public void clearData() {
		txtimgSP.setText("");
		txttenSP.setText("");
		txtslSP.setText("");
		txtgiaSP.setText("");
		//txtloai.setText("");
		//txtmaNSX.setText("");
	}
	public void loadSP() throws ClassNotFoundException, SQLException {
		if(spBUS.getList()==null) spBUS.listSP();
		ArrayList<ProductDTO> sp=new ArrayList<>();
		sp=spBUS.getList();
		outModel(model,sp);	
	}
	public void outModel(DefaultTableModel model , ArrayList<ProductDTO> sp) {
		Vector header=new Vector();
		header.add("Mã sản phẩm");
		header.add("Tên sản phẩm");
		header.add("Số lượng");
		header.add("Đơn giá");
		header.add("Đơn vị");
		header.add("Loại sản phẩm");
		header.add("Ảnh sản phẩm");
		model = new DefaultTableModel(header,0);
		for(ProductDTO pro : sp)
		{
			Vector row=new Vector();
			row.add(pro.maSP);
			row.add(pro.tenSP);
			row.add(pro.slSP);
			row.add(pro.giaSP);
			row.add(pro.donviSP);
			row.add(pro.loaiSP);
			row.add(pro.image);
			model.addRow(row);
		}
		table.setModel(model);
		TableColumnModel col=table.getColumnModel();
		col.getColumn(0).setPreferredWidth(45);
		col.getColumn(1).setPreferredWidth(260);
		col.getColumn(2).setPreferredWidth(75);
		col.getColumn(3).setPreferredWidth(110);
		col.getColumn(4).setPreferredWidth(65);
		col.getColumn(5).setPreferredWidth(30);
		col.getColumn(6).setPreferredWidth(45);	
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

