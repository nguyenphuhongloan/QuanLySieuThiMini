package GUI;

import BUS.NhaCungCapBUS;
import DTO.CheckInput;
import DTO.SupplierDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;


public class NhaCungCapGUI extends JPanel {
	NhaCungCapGUI() throws ClassNotFoundException, SQLException{
		init();
	}
	JTextField txttenNCC,txtdiachi,txtFAX;
	JTable table=new JTable();
	DefaultTableModel model = new DefaultTableModel();
	JPanel main;
	NhaCungCapBUS nccBUS=new NhaCungCapBUS();
	public void init() throws ClassNotFoundException, SQLException {
		setBounds(0,0,1150,800);
		setLayout(null);
		Font font = new Font("Segoe UI",1,17);
		Font font1 = new Font("Tahoma",0,17);
		load();
		
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
		
		JLabel maNCC=new JLabel("Mã NCC");
		maNCC.setBounds(0,20,150,50);
		maNCC.setFont(font);
		JLabel txtmaNCC=new JLabel();
		txtmaNCC.setBounds(150,30,200,32);
		txtmaNCC.setBorder(BorderFactory.createLineBorder(Color.black));
		txtmaNCC.setOpaque(true);
		txtmaNCC.setFont(font1);
		
		JLabel tenNCC=new JLabel("Tên NCC");
		tenNCC.setBounds(0,80,150,50);
		tenNCC.setFont(font);
		txttenNCC=new JTextField();
		txttenNCC.setBounds(150,90,400,32);
		txttenNCC.setBorder(BorderFactory.createLineBorder(Color.black));
		txttenNCC.setOpaque(true);
		txttenNCC.setFont(font1);
		txttenNCC.setBackground(Color.white);
		JLabel diachi=new JLabel("Địa Chỉ");
		diachi.setBounds(0,140,150,50);
		diachi.setFont(font);
		txtdiachi=new JTextField();
		txtdiachi.setBounds(150,150,400,32);
		txtdiachi.setBorder(BorderFactory.createLineBorder(Color.black));
		txtdiachi.setOpaque(true);
		txtdiachi.setFont(font1);
		txtdiachi.setBackground(Color.white);
		JLabel sdt=new JLabel("Số FAX");
		sdt.setBounds(0,200,150,50);
		sdt.setFont(font);
		txtFAX=new JTextField();
		txtFAX.setBounds(150,210,400,32);
		txtFAX.setBorder(BorderFactory.createLineBorder(Color.black));
		txtFAX.setOpaque(true);
		txtFAX.setFont(font1);
		txtFAX.setBackground(Color.white);
		
		JButton them=new JButton();
		them.setFocusable(false);
		them.setBorder(BorderFactory.createEmptyBorder());
		them.setBounds(820, 30, 200, 60);
		them.setBackground(new java.awt.Color(255,215,0));
		them.setLayout(null);
		them.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							boolean check=true;
							if(txttenNCC.getText().isEmpty()||txtdiachi.getText().isEmpty()||txtFAX.getText().isEmpty()) {
								check=false;
								new ThongBaoGUI("Vui lòng nhập đầy đủ thông tin");
							}
							if(check) {
								if(CheckInput.checkString(txttenNCC.getText())==false||CheckInput.checkString(txtdiachi.getText())==false)
								{
									check=false;
									new ThongBaoGUI("Không được nhập ký tự đặc biệt");
								}
								if(check==true&&CheckInput.checkFAX(txtFAX.getText())==false)
								{
									check=false;
									new ThongBaoGUI("Số FAX không hợp lệ");
								}
							}
							if(check) {
								SupplierDTO ncc=new SupplierDTO();
								ncc.tenNCC=txttenNCC.getText();
								ncc.diachi=txtdiachi.getText();
								ncc.soFAX=txtFAX.getText();
								nccBUS.add(ncc);
								outModel(model,nccBUS.getList());	
								clearData();
								new ThongBaoGUI("Thêm Nhà Cung Cấp Thành Công");
							}
						} catch (Exception e) {
							// TODO: handle exception
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
					if(txttenNCC.getText().isEmpty()||txtdiachi.getText().isEmpty()||txtFAX.getText().isEmpty()) {
						check=false;
						new ThongBaoGUI("Vui lòng nhập đầy đủ thông tin");
					}
					if(check) {
						if(CheckInput.checkString(txttenNCC.getText())==false||CheckInput.checkString(txtdiachi.getText())==false)
						{
							check=false;
							new ThongBaoGUI("Không được nhập ký tự đặc biệt");
						}
						if(check==true&&CheckInput.checkFAX(txtFAX.getText())==false)
						{
							check=false;
							new ThongBaoGUI("Số FAX không hợp lệ");
						}
					}
					if(check) {
						ArrayList<SupplierDTO> dsncc=nccBUS.getList();
						SupplierDTO ncc=new SupplierDTO();
						ncc.maNCC=dsncc.get(i).maNCC;
						ncc.tenNCC=txttenNCC.getText();
						ncc.diachi=txtdiachi.getText();
						ncc.soFAX=txtFAX.getText();
						nccBUS.set(ncc);
						outModel(model,nccBUS.getList());
						new ThongBaoGUI("Sửa Nhà Cung Cấp Thành Công");
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
					try {
						ArrayList<SupplierDTO> dsncc=nccBUS.getList();
						nccBUS.delete(dsncc.get(i).maNCC);
						outModel(model, nccBUS.getList());
						clearData();
						new ThongBaoGUI("Xóa Nhà Cung Cấp Thành Công");
					} catch (Exception e2) {
						// TODO: handle exception
					}
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
		
		JLabel icon=new JLabel(new ImageIcon("image/warehouse.png"));
		icon.setBounds(620, 80, 128, 128);

		header.add(maNCC);
		header.add(txtmaNCC);
		header.add(tenNCC);
		header.add(txttenNCC);
		header.add(diachi);
		header.add(txtdiachi);
		header.add(sdt);
		header.add(txtFAX);
		header.add(them);
		header.add(sua);
		header.add(xoa);
		header.add(icon);
		
		
		JPanel HeaderTable=new JPanel();
		HeaderTable.setBounds(0, 150, 1150, 40);
		HeaderTable.setBackground(Color.red);
		HeaderTable.setLayout(null);
		JLabel colmaNCC=new JLabel("Mã NCC");
		colmaNCC.setForeground(Color.white);
		colmaNCC.setBounds(0,0,200,40);
		colmaNCC.setFont(font);
		HeaderTable.add(colmaNCC);
		JLabel coltenNCC=new JLabel("Tên NCC");
		coltenNCC.setForeground(Color.white);
		coltenNCC.setBounds(163,0,200,40);
		coltenNCC.setFont(font);
		HeaderTable.add(coltenNCC);
		JLabel coldiachi=new JLabel("Địa Chỉ");
		coldiachi.setForeground(Color.white);
		coldiachi.setBounds(477,0,200,40);
		coldiachi.setFont(font); 
		HeaderTable.add(coldiachi);
		JLabel colFAX=new JLabel("Số FAX");
		colFAX.setForeground(Color.white);
		colFAX.setBounds(788,0,200,40);
		colFAX.setFont(font);
		HeaderTable.add(colFAX);
		
		JPanel centerTable=new JPanel();
		centerTable.setBounds(0,190,1030,320);
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
				txtmaNCC.setText(table.getModel().getValueAt(i, 0).toString());
				txttenNCC.setText(table.getModel().getValueAt(i, 1).toString());
				txtdiachi.setText(table.getModel().getValueAt(i, 2).toString());
				txtFAX.setText(table.getModel().getValueAt(i, 3).toString());
			}
		});
	    JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -5, 1035 , 320);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5,100));
        centerTable.add(scroll);
		
		JPanel line=new JPanel();
		line.setBounds(0, 40, 1150, 1);
		line.setBackground(Color.black);
		JLabel searchtenKH=new JLabel("Tìm Kiếm Theo Tên");
		searchtenKH.setBounds(180, 80, 200, 40);
		searchtenKH.setFont(new Font("Tahoma", 0, 20));
		JTextField search=new JTextField();
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
					outModel(model, nccBUS.search(s));
				}else {
					outModel(model, nccBUS.getList());
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
		txttenNCC.setText("");
		txtdiachi.setText("");
		txtFAX.setText("");
	}
	public void load() throws ClassNotFoundException, SQLException {
		if(nccBUS.getList()==null) nccBUS.list();
		ArrayList<SupplierDTO> ncc=new ArrayList<>();
		ncc=nccBUS.getList();
		outModel(model,ncc);	
	}
	public void outModel(DefaultTableModel model , ArrayList<SupplierDTO> ncc) {
		Vector header=new Vector();
		header.add("");
		header.add("");
		header.add("");
		header.add("");
		model = new DefaultTableModel(header,0);
		for(SupplierDTO supp : ncc)
		{
			Vector row=new Vector();
			row.add(supp.maNCC);
			row.add(supp.tenNCC);
			row.add(supp.diachi);
			row.add(supp.soFAX);
			model.addRow(row);
		}
		table.setModel(model);
		TableColumnModel col=table.getColumnModel();
		col.getColumn(0).setPreferredWidth(100);
		col.getColumn(1).setPreferredWidth(250);
		col.getColumn(2).setPreferredWidth(250);
		col.getColumn(3).setPreferredWidth(180);
	}
}

