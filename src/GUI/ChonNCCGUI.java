package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import BUS.NhaCungCapBUS;
import BUS.SanPhamBUS;
import DTO.ProductDTO;
import DTO.SupplierDTO;

public class ChonNCCGUI extends JFrame{
	ChonNCCGUI() throws ClassNotFoundException, SQLException{
		init();
	}
	JTable table=new JTable();
	DefaultTableModel model = new DefaultTableModel();
	NhaCungCapBUS nccBUS=new NhaCungCapBUS();
	public void init() throws ClassNotFoundException, SQLException {
		setSize(1200, 750);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setUndecorated(true);
		setLayout(new BorderLayout(1, 1));
		Font font = new Font("Segoe UI",Font.PLAIN,17);
		load();
		
		JPanel title=new JPanel();
		title.setBackground(Color.black);
		title.setPreferredSize(new Dimension(0,40));
		title.setLayout(null);
		JLabel close=new JLabel(new ImageIcon("image/close.png"));
		close.setBounds(1150,0,40,40);
		close.addMouseListener(new MouseListener() {
			
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
				dispose();
			}
		});
		title.add(close);
		
		JPanel contetLeft=new JPanel();
		contetLeft.setLayout(null);
		contetLeft.setBackground(Color.white);
		contetLeft.setPreferredSize(new Dimension(450,0));
		
		JLabel title1=new JLabel("Thông Tin Nhà Cung Cấp");
		title1.setBounds(60, 20, 350, 50);
		title1.setFont(new Font("Tahoma", 1, 27));
		
		JLabel maNCC=new JLabel("Mã NCC");
		maNCC.setBounds(40,160,80,40);
		maNCC.setFont(font);
		JLabel txtmaNCC=new JLabel();
		txtmaNCC.setBounds(130,165,240,30);
		txtmaNCC.setOpaque(true);
		txtmaNCC.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel tenNCC=new JLabel("Tên NCC");
		tenNCC.setBounds(40,210,80,40);
		tenNCC.setFont(font);
		JLabel txttenNCC=new JLabel();
		txttenNCC.setBounds(130,215,240,30);
		txttenNCC.setOpaque(true);
		txttenNCC.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel diachi=new JLabel("Địa Chỉ");
		diachi.setBounds(40,260,80,40);
		diachi.setFont(font);
		JLabel txtdiachi=new JLabel();
		txtdiachi.setBounds(130,265,240,30);
		txtdiachi.setOpaque(true);
		txtdiachi.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel fax=new JLabel("Số FAX");
		fax.setBounds(40,310,80,40);
		fax.setFont(font);
		JLabel txtfax=new JLabel();
		txtfax.setBounds(130,315,240,30);
		txtfax.setOpaque(true);
		txtfax.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton xacnhan=new JButton();
		xacnhan.setFocusable(false);
		xacnhan.setBounds(40, 380, 150, 45);
		xacnhan.setBorder(BorderFactory.createEmptyBorder());
		xacnhan.setBackground(new java.awt.Color(255,215,0));
		xacnhan.setLayout(null);
		xacnhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(NhapHangGUI.txtchonmaNCC != null) NhapHangGUI.txtchonmaNCC.setText(txtmaNCC.getText());
				dispose();
			}
		});
		JLabel txtxacnhan=new JLabel("Xác Nhận");
		txtxacnhan.setBounds(48, 3, 100, 40);
		txtxacnhan.setFont(new Font("Tahoma", 1, 18));
		txtxacnhan.setForeground(Color.white);
		JLabel iconxacnhan=new JLabel(new ImageIcon("image/confirm.png"));
		iconxacnhan.setBounds(15,10, 24, 24);
		xacnhan.add(txtxacnhan);
		xacnhan.add(iconxacnhan);
		JButton huy=new JButton();
		huy.setFocusable(false);
		huy.setBounds(220, 380, 150, 45);
		huy.setBorder(BorderFactory.createEmptyBorder());
		huy.setBackground(new java.awt.Color(220,20,60));
		huy.setLayout(null);
		JLabel txthuy=new JLabel("Quay Lại");
		txthuy.setBounds(54, 3, 100, 40);
		txthuy.setForeground(Color.white);
		txthuy.setFont(new Font("Tahoma", 1, 18));
		JLabel iconhuy=new JLabel(new ImageIcon("image/back.png"));
		iconhuy.setBounds(16,11, 24, 24);
		huy.add(txthuy);
		huy.add(iconhuy);
		huy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		contetLeft.add(title1);
		contetLeft.add(maNCC);
		contetLeft.add(txtmaNCC);
		contetLeft.add(tenNCC);
		contetLeft.add(txttenNCC);
		contetLeft.add(diachi);
		contetLeft.add(txtdiachi);
		contetLeft.add(fax);
		contetLeft.add(txtfax);
		contetLeft.add(xacnhan);
		contetLeft.add(huy);
		
		JPanel contentRight=new JPanel();
		contentRight.setLayout(null);
		contentRight.setBackground(Color.white);
		
		JLabel title2=new JLabel("Danh Sách Nhà Cung Cấp");
		title2.setBounds(210, 20, 400, 50);
		title2.setFont(new Font("Tahoma", 1, 27));
		
		JPanel headerTable=new JPanel();
		headerTable.setLayout(null);
		headerTable.setBackground(Color.red);
		headerTable.setBounds(0, 150, 710, 40);
		JLabel colmaSP=new JLabel("Mã NCC");
		colmaSP.setFont(new Font("Tahoma", 1, 17));
		colmaSP.setBounds(0, 5, 80, 30);
		colmaSP.setForeground(Color.white);
		JLabel coltenSP=new JLabel("Tên NCC");
		coltenSP.setFont(new Font("Tahoma", 1, 17));
		coltenSP.setBounds(90, 5, 150, 30);
		coltenSP.setForeground(Color.white);
		JLabel colslSP=new JLabel("Địa Chỉ");
		colslSP.setFont(new Font("Tahoma", 1, 17));
		colslSP.setBounds(315, 5, 100, 30);
		colslSP.setForeground(Color.white);
		JLabel colgiaSP=new JLabel("Số FAX");
		colgiaSP.setFont(new Font("Tahoma", 1, 17));
		colgiaSP.setBounds(542, 5, 100, 30);
		colgiaSP.setForeground(Color.white);
		headerTable.add(colmaSP);
		headerTable.add(coltenSP);
		headerTable.add(colslSP);
		headerTable.add(colgiaSP);
		JLabel searchtenNCC=new JLabel("Tên NCC");
		searchtenNCC.setFont(font);
		searchtenNCC.setBounds(0, 80, 120, 40);
		JTextField txtsearchtenNCC=new JTextField();
		txtsearchtenNCC.setBounds(100, 83, 300, 35);
		JLabel iconsearch=new JLabel(new ImageIcon("image/search1.png"));
		iconsearch.setBounds(660, 77, 48, 48);
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
				if(txtsearchtenNCC.getText().equals("")==false) {
					outModel(model, nccBUS.search(txtsearchtenNCC.getText()));
				}else {
					outModel(model, nccBUS.getList());
				}
			}
		});
		
		JPanel panelTable=new JPanel();
		panelTable.setBackground(Color.white);
		panelTable.setBounds(0, 190, 710, 450);
		panelTable.setLayout(null);
		table.setBounds(0,0,710,450);
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
				ArrayList<SupplierDTO> dsncc=nccBUS.getList();
				txtmaNCC.setText(table.getModel().getValueAt(i, 0).toString());
				txttenNCC.setText(table.getModel().getValueAt(i, 1).toString());
				txtdiachi.setText(table.getModel().getValueAt(i, 2).toString());
				txtfax.setText(table.getModel().getValueAt(i, 3).toString());
			}
		});
	    JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -5, 710 , 450);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0,100));
        panelTable.add(scroll);
		
		contentRight.add(title2);
		contentRight.add(searchtenNCC);
		contentRight.add(txtsearchtenNCC);
		contentRight.add(iconsearch);
		contentRight.add(headerTable);
		contentRight.add(panelTable);
		
		JPanel content=new JPanel();
		content.setLayout(null);
		content.setLayout(new BorderLayout());
		content.add(contetLeft,BorderLayout.WEST);
		content.add(contentRight,BorderLayout.CENTER);
		
		add(title,BorderLayout.NORTH);
		add(content,BorderLayout.CENTER);
		
		setVisible(true);
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
