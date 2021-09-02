package GUI;

import BUS.DangNhapBUS;
import BUS.NhapHangBUS;
import DTO.CheckInput;
import DTO.NhapHangDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;


public class NhapHangGUI extends JPanel {
	public static JLabel txtmaSPchon2;
	public static JLabel txtchonmaNCC;
	NhapHangGUI() throws ClassNotFoundException, SQLException{
		init();
	}
	JTable table=new JTable();
	DefaultTableModel model = new DefaultTableModel();
	JPanel main;
	JTextField txtgianhap,txtsoluong;
	JLabel txttenSP;
	NhapHangBUS nhBUS=new NhapHangBUS();
	public void init() throws ClassNotFoundException, SQLException {
		setBounds(0,0,1150,800);
		setLayout(null);
		Font font = new Font("Segoe UI",1,17);
		Font font1 = new Font("Tahoma",0,17);
		LocalDateTime date=java.time.LocalDateTime.now();
        String day=date.toString();
        String[]  d= day.split("T");
		
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
		
		JLabel ngaynhap=new JLabel("Ngày Nhập Hàng");
		ngaynhap.setBounds(0,35,150,50);
		ngaynhap.setFont(font);
		JLabel txtngaynhap=new JLabel(d[0]);
		txtngaynhap.setBounds(170,45,370,32);
		txtngaynhap.setBorder(BorderFactory.createLineBorder(Color.black));
		txtngaynhap.setOpaque(true);
		txtngaynhap.setFont(font1);
		JLabel tenNV=new JLabel("Tên NV");
		tenNV.setBounds(0,85,150,50);
		tenNV.setFont(font);
                
		txttenSP=new JLabel(DangNhapBUS.login.tenNV);
		txttenSP.setBounds(170,95,370,32);
		txttenSP.setBorder(BorderFactory.createLineBorder(Color.black));
		txttenSP.setOpaque(true);
		txttenSP.setFont(font1);
		JLabel maSP=new JLabel("Mã SP");
		maSP.setBounds(0,135,150,50);
		maSP.setFont(font);
		txtmaSPchon2=new JLabel();
		txtmaSPchon2.setBounds(90,145,100,32);
		txtmaSPchon2.setBorder(BorderFactory.createLineBorder(Color.black));
		txtmaSPchon2.setOpaque(true);
		txtmaSPchon2.setFont(font1);
		JButton selectmaSP=new JButton("...");
		selectmaSP.setBounds(190, 148, 25, 25);
		selectmaSP.setFocusable(false);
		selectmaSP.setBorder(BorderFactory.createLineBorder(Color.black));
		selectmaSP.setFont(new Font("Tahoma", 0, 17));
		selectmaSP.setBackground(Color.lightGray);
		selectmaSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					try {
						txtgianhap.setText("");
						txtsoluong.setText("");
						
						ChonSPGUI selectSP=new ChonSPGUI();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		JLabel maNCC=new JLabel("Mã NCC");
		maNCC.setBounds(320,135,150,50);
		maNCC.setFont(font);
		txtchonmaNCC=new JLabel();
		txtchonmaNCC.setBounds(415,145,100,32);
		txtchonmaNCC.setBorder(BorderFactory.createLineBorder(Color.black));
		txtchonmaNCC.setOpaque(true);
		txtchonmaNCC.setFont(font1);
		JButton selectmaNCC=new JButton("...");
		selectmaNCC.setBounds(515, 148, 25, 25);
		selectmaNCC.setFocusable(false);
		selectmaNCC.setBorder(BorderFactory.createLineBorder(Color.black));
		selectmaNCC.setFont(new Font("Tahoma", 0, 17));
		selectmaNCC.setBackground(Color.lightGray);
		selectmaNCC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						ChonNCCGUI selectNCC=new ChonNCCGUI();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		JLabel gianhap=new JLabel("Giá Nhập");
		gianhap.setBounds(0,185,150,50);
		gianhap.setFont(font);
		txtgianhap=new JTextField();
		txtgianhap.setBounds(90,195,180,32);
		txtgianhap.setBorder(BorderFactory.createLineBorder(Color.black));
		txtgianhap.setOpaque(true);
		txtgianhap.setFont(font1);
		JLabel soluong=new JLabel("Số Lượng");
		soluong.setBounds(325,185,150,50);
		soluong.setFont(font);
		txtsoluong=new JTextField();
		txtsoluong.setBounds(430,195,110,32);
		txtsoluong.setBorder(BorderFactory.createLineBorder(Color.black));
		txtsoluong.setOpaque(true);
		txtsoluong.setFont(font1);
		
		JButton them=new JButton();
		them.setFocusable(false);
		them.setBorder(BorderFactory.createEmptyBorder());
		them.setBounds(820, 30, 200, 60);
		them.setBackground(new java.awt.Color(255,215,0));
		them.setLayout(null);
		them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					boolean check=true;
					if(txtmaSPchon2.getText().equals("")||txtsoluong.getText().equals("")||txtchonmaNCC.getText().equals("")||txtgianhap.getText().equals(""))
					{
						ThongBaoGUI tb=new ThongBaoGUI("Vui Lòng Nhập Đầy Đủ Các Trường !");
						check=false;
					}
					if(check) {
						if(CheckInput.checkStringNumber(txtsoluong.getText())==false) {
							check=false;
							ThongBaoGUI tb=new ThongBaoGUI("     Số Lượng Nhập Không Phù Hợp !");
						}
						if(CheckInput.checkStringNumber(txtgianhap.getText())==false&&check==true) {
							check=false;
							ThongBaoGUI tb=new ThongBaoGUI("          Giá Nhập Không Phù Hợp !");
						}
						if(CheckInput.checkInt(txtsoluong.getText())==false&&check==true) {
							check=false;
							ThongBaoGUI tb=new ThongBaoGUI("          Số Lượng Không Phù Hợp !");
						}
						if(CheckInput.checkInt(txtgianhap.getText())==false&&check==true) {
							check=false;
							ThongBaoGUI tb=new ThongBaoGUI("          Giá Nhập Không Phù Hợp !");
						}
						if(check)
						{
							int sl=Integer.parseInt(txtsoluong.getText());
							int price=Integer.parseInt(txtgianhap.getText());
							if(sl<=0) {
								check=false;
								ThongBaoGUI tb=new ThongBaoGUI("     Số Lượng Nhập Không Phù Hợp !");
							}
							if(price<=0&&check==true) {
								check=false;
								ThongBaoGUI tb=new ThongBaoGUI("          Giá Nhập Không Phù Hợp !");
							}
						}
						
					}
					if(check) {
						int idSP=Integer.parseInt(txtmaSPchon2.getText());
						int sl=Integer.parseInt(txtsoluong.getText());
						int idNCC=Integer.parseInt(txtchonmaNCC.getText());
						int gianhap=Integer.parseInt(txtgianhap.getText());
						nhBUS.add(idSP,sl,idNCC,gianhap);
						outModel(model, nhBUS.getList());
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.print("That bai");
				}
				
			}
		});
		JLabel txtthem=new JLabel("THÊM");
		txtthem.setForeground(Color.white);
		txtthem.setFont(new Font("Tahoma", 0, 30));
		txtthem.setBounds(90, 10, 80, 40);
		JLabel iconct=new JLabel(new ImageIcon("image/plus.png"));
		iconct.setBounds(10, 12, 40, 40);
		them.add(txtthem);
		them.add(iconct);
		
		
		JButton sua=new JButton();
		sua.setFocusable(false);
		sua.setBorder(BorderFactory.createEmptyBorder());
		sua.setBounds(820, 105, 200, 60);
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
					if(txtmaSPchon2.getText().equals("")||txtsoluong.getText().equals("")||txtchonmaNCC.getText().equals("")||txtgianhap.getText().equals(""))
					{
						ThongBaoGUI tb=new ThongBaoGUI("Vui Lòng Nhập Đầy Đủ Các Trường !");
						check=false;
					}
					if(check) {
						if(CheckInput.checkStringNumber(txtsoluong.getText())==false) {
							check=false;
							ThongBaoGUI tb=new ThongBaoGUI("     Số Lượng Nhập Không Phù Hợp !");
						}
						if(CheckInput.checkStringNumber(txtgianhap.getText())==false&&check==true) {
							check=false;
							ThongBaoGUI tb=new ThongBaoGUI("          Giá Nhập Không Phù Hợp !");
						}
						if(CheckInput.checkInt(txtsoluong.getText())==false&&check==true) {
							check=false;
							ThongBaoGUI tb=new ThongBaoGUI("          Số Lượng Không Phù Hợp !");
						}
						if(CheckInput.checkInt(txtgianhap.getText())==false&&check==true) {
							check=false;
							ThongBaoGUI tb=new ThongBaoGUI("          Giá Nhập Không Phù Hợp !");
						}
						if(check)
						{
							int sl=Integer.parseInt(txtsoluong.getText());
							int price=Integer.parseInt(txtgianhap.getText());
							if(sl<=0) {
								check=false;
								ThongBaoGUI tb=new ThongBaoGUI("     Số Lượng Nhập Không Phù Hợp !");
							}
							if(price<=0&&check==true) {
								check=false;
								ThongBaoGUI tb=new ThongBaoGUI("          Giá Nhập Không Phù Hợp !");
							}
						}
						
					}
					if(check) {
						ArrayList<NhapHangDTO> dssp=nhBUS.getList();
						int idSP=Integer.parseInt(txtmaSPchon2.getText());
						int sl=Integer.parseInt(txtsoluong.getText());
						int idNCC=Integer.parseInt(txtchonmaNCC.getText());
						int gianhap=Integer.parseInt(txtgianhap.getText());
						nhBUS.set(i,idSP,idNCC,gianhap,sl);
						outModel(model,nhBUS.getList());	
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
		txtsua.setFont(new Font("Tahoma", 0, 30));
		txtsua.setBounds(90, 10, 80, 40);
		JLabel iconsua=new JLabel(new ImageIcon("image/fix.png"));
	    iconsua.setBounds(14, 12, 35, 35);
		sua.add(txtsua);
		sua.add(iconsua);
		
		JButton xoa=new JButton();
		xoa.setFocusable(false);
		xoa.setBorder(BorderFactory.createEmptyBorder());
		xoa.setBounds(820, 177, 200, 60);
		xoa.setBackground(new java.awt.Color(220,20,60));
		xoa.setLayout(null);
		xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=table.getSelectedRow();
				if(i!=-1) {
					nhBUS.delete(i);
					ArrayList<NhapHangDTO> nh= nhBUS.getList();
					outModel(model, nhBUS.getList());
					clearData();
				}
			}
		});
		JLabel txtxoa=new JLabel("XÓA");
		txtxoa.setForeground(Color.white);
		txtxoa.setFont(new Font("Tahoma", 0, 30));
		txtxoa.setBounds(90, 10, 80, 40);
		JLabel iconxoa=new JLabel(new ImageIcon("image/del.png"));
		iconxoa.setBounds(13, 12, 35, 35);
		xoa.add(txtxoa);
		xoa.add(iconxoa);
		
		JLabel icon=new JLabel(new ImageIcon("image/importLogo.png"));
		icon.setBounds(620, 70, 128, 128);

		header.add(ngaynhap);
		header.add(txtngaynhap);
		header.add(tenNV);
		header.add(txttenSP);
		header.add(maSP);
		header.add(txtmaSPchon2);
		header.add(selectmaSP);
		header.add(maNCC);
		header.add(txtchonmaNCC);
		header.add(selectmaNCC);
		header.add(gianhap);
		header.add(txtgianhap);
		header.add(soluong);
		header.add(txtsoluong);
		header.add(them);
		header.add(sua);
		header.add(xoa);
		header.add(icon);
	    
	 
	    
		
		JPanel HeaderTable=new JPanel();
		HeaderTable.setBounds(0, 40, 1150, 40);
		HeaderTable.setBackground(Color.red);
		HeaderTable.setLayout(null);
		JLabel colmaSP=new JLabel("Mã SP");
		colmaSP.setForeground(Color.white);
		colmaSP.setBounds(0,0,100,40);
		colmaSP.setFont(font);
		HeaderTable.add(colmaSP);
		JLabel coltenSP=new JLabel("Tên SP");
		coltenSP.setForeground(Color.white);
		coltenSP.setBounds(123,0,200,40);
		coltenSP.setFont(font);
		HeaderTable.add(coltenSP);
		JLabel colmaNCC=new JLabel("Mã NCC");
		colmaNCC.setForeground(Color.white);
		colmaNCC.setBounds(343,0,100,40);
		colmaNCC.setFont(font); 
		HeaderTable.add(colmaNCC);
		JLabel colgianhap=new JLabel("Giá Nhập");
		colgianhap.setForeground(Color.white);
		colgianhap.setBounds(464,0,200,40);
		colgianhap.setFont(font);
		HeaderTable.add(colgianhap);
		JLabel colsoluong=new JLabel("Số Lượng");
		colsoluong.setForeground(Color.white);
		colsoluong.setBounds(684,0,100,40);
		colsoluong.setFont(font);
		HeaderTable.add(colsoluong);
		JLabel coltongtien=new JLabel("Tổng Tiền");
		coltongtien.setForeground(Color.white);
		coltongtien.setBounds(806,0,200,40);
		coltongtien.setFont(font);
		HeaderTable.add(coltongtien);
		
		
		JPanel centerTable=new JPanel();
		centerTable.setBounds(0,80,1030,320);
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
				txtmaSPchon2.setText(table.getModel().getValueAt(i, 0).toString());
				txttenSP.setText(table.getModel().getValueAt(i, 1).toString());
				txtchonmaNCC.setText(table.getModel().getValueAt(i, 2).toString());
				txtgianhap.setText(table.getModel().getValueAt(i, 3).toString());
				txtsoluong.setText(table.getModel().getValueAt(i, 4).toString());
	
			}
		});
	    
	    JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -5, 1035 , 320);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5,100));
        centerTable.add(scroll);
		
        JButton nhaphang=new JButton("Nhập Hàng");
        nhaphang.setBounds(250, 430, 180, 40);
        nhaphang.setFocusable(false);
        nhaphang.setBackground(Color.LIGHT_GRAY);
        nhaphang.setFont(new Font("Tahoma", 1, 17));
        nhaphang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String date=txtngaynhap.getText();
				int idAcc=DangNhapBUS.login.maNV;
				try {
					nhBUS.nhaphang(date,idAcc);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				outModel(model, nhBUS.getList());
			}
		});
        JButton huy=new JButton("Hủy Tất Cả");
        huy.setBounds(600, 430, 180, 40);
        huy.setFocusable(false);
        huy.setBackground(Color.LIGHT_GRAY);
        huy.setFont(new Font("Tahoma", 1, 17));
        
        JPanel center=new JPanel();
		center.setLayout(null);
		center.setBackground(Color.white);
		center.add(HeaderTable);
		center.add(centerTable);
		center.add(nhaphang);
		center.add(huy);
		
		
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
		txttenSP.setText("");
		txtmaSPchon2.setText("");
		txtchonmaNCC.setText("");
		txtgianhap.setText("");
		txtsoluong.setText("");
	}
	public void outModel(DefaultTableModel model , ArrayList<NhapHangDTO> sp) {
		Vector header=new Vector();
		header.add("");
		header.add("");
		header.add("");
		header.add("");
		header.add("");
		header.add("");
		model = new DefaultTableModel(header,0);
		for(NhapHangDTO pro : sp)
		{
			Vector row=new Vector();
			row.add(pro.maSP);
			row.add(pro.tenSP);
			row.add(pro.maNCC);
			row.add(pro.gianhap);
			row.add(pro.slSP);
			row.add(pro.tt);
			model.addRow(row);
		}
		table.setModel(model);
		TableColumnModel col=table.getColumnModel();
		col.getColumn(0).setPreferredWidth(100);
		col.getColumn(1).setPreferredWidth(200);
		col.getColumn(2).setPreferredWidth(100);
		col.getColumn(3).setPreferredWidth(200);
		col.getColumn(4).setPreferredWidth(100);
		col.getColumn(5).setPreferredWidth(200);
	}
}

