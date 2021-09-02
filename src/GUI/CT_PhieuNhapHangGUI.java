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

import BUS.CT_PhieuNhapHangBUS;
import BUS.SanPhamBUS;
import DTO.NhapHangDTO;
import DTO.PhieuNhapHangDTO;
import DTO.ProductDTO;

public class CT_PhieuNhapHangGUI extends JFrame {
	private PhieuNhapHangDTO pnh;
	CT_PhieuNhapHangGUI(PhieuNhapHangDTO pnh) throws ClassNotFoundException, SQLException{
		this.pnh=pnh;
		init();
	}
	JLabel txtmaPNH,txtngaynhap,txttongtien;
	JTable table=new JTable();
	DefaultTableModel model = new DefaultTableModel();
	CT_PhieuNhapHangBUS ctpnhBUS=new CT_PhieuNhapHangBUS();
	public void init() throws ClassNotFoundException, SQLException {
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setUndecorated(true);
		setLayout(new BorderLayout(1, 1));
		Font font = new Font("Segoe UI",Font.PLAIN,17);
		
		JPanel title=new JPanel();
		title.setBackground(Color.black);
		title.setPreferredSize(new Dimension(0,40));
		title.setLayout(null);
		JLabel close=new JLabel(new ImageIcon("image/close.png"));
		close.setBounds(950,0,40,40);
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
		
		JLabel title1=new JLabel("CHI TIẾT PHIẾU NHẬP HÀNG");
		title1.setBounds(320, 20, 400, 50);
		title1.setFont(new Font("Tahoma", 1, 27));
		
		JLabel maPNH=new JLabel("Mã PNH");
		maPNH.setFont(font);
		maPNH.setBounds(100, 80, 100, 40);
		txtmaPNH=new JLabel();
		txtmaPNH.setBounds(180, 85, 80, 30);
		txtmaPNH.setOpaque(true);
		txtmaPNH.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel ngaynhap=new JLabel("Ngày Nhập");
		ngaynhap.setFont(font);
		ngaynhap.setBounds(290, 80, 150, 40);
		txtngaynhap=new JLabel();
		txtngaynhap.setBounds(390, 85, 200, 30);
		txtngaynhap.setOpaque(true);
		txtngaynhap.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel tongtien=new JLabel("Tổng Tiền");
		tongtien.setFont(font);
		tongtien.setBounds(620, 80, 150, 40);
		txttongtien=new JLabel();
		txttongtien.setBounds(710, 85, 200, 30);
		txttongtien.setOpaque(true);
		txttongtien.setBorder(BorderFactory.createLineBorder(Color.black));
		
		loadSP();
		
		JPanel headerTable=new JPanel();
		headerTable.setLayout(null);
		headerTable.setBackground(Color.red);
		headerTable.setBounds(100, 150, 810, 40);
		JLabel colmaSP=new JLabel("Mã SP");
		colmaSP.setFont(new Font("Tahoma", 1, 17));
		colmaSP.setBounds(0, 5, 60, 30);
		colmaSP.setForeground(Color.white);
		JLabel coltenSP=new JLabel("Tên Sản Phẩm");
		coltenSP.setFont(new Font("Tahoma", 1, 17));
		coltenSP.setBounds(85, 5, 150, 30);
		coltenSP.setForeground(Color.white);
		JLabel colslSP=new JLabel("Số Lượng");
		colslSP.setFont(new Font("Tahoma", 1, 17));
		colslSP.setBounds(293, 5, 100, 30);
		colslSP.setForeground(Color.white);
		JLabel colgiaSP=new JLabel("Giá Nhập");
		colgiaSP.setFont(new Font("Tahoma", 1, 17));
		colgiaSP.setBounds(402, 5, 100, 30);
		colgiaSP.setForeground(Color.white);
		JLabel coltotal=new JLabel("Tổng Cộng");
		coltotal.setFont(new Font("Tahoma", 1, 17));
		coltotal.setBounds(560, 5, 150, 30);
		coltotal.setForeground(Color.white);
		JLabel colmaNCC=new JLabel("Mã NCC");
		colmaNCC.setFont(new Font("Tahoma", 1, 17));
		colmaNCC.setBounds(716, 5, 110, 30);
		colmaNCC.setForeground(Color.white);
		headerTable.add(colmaSP);
		headerTable.add(coltenSP);
		headerTable.add(colslSP);
		headerTable.add(colgiaSP);
		headerTable.add(coltotal);
		headerTable.add(colmaNCC);
		
		JPanel panelTable=new JPanel();
		panelTable.setBackground(Color.white);
		panelTable.setBounds(100, 190, 810, 400);
		panelTable.setLayout(null);
		table.setBounds(0,0,810,400);
		table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		table.setRowHeight(60);
		table.setShowGrid(false);
	    table.setShowVerticalLines(false);
	    table.setShowHorizontalLines(true);
	    
	    JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -5, 810 , 400);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0,100));
        panelTable.add(scroll);
		
		
		
		JPanel content=new JPanel();
		content.setLayout(null);
		content.setBackground(Color.white);
		content.add(title1);
		content.add(maPNH);
		content.add(txtmaPNH);
		content.add(ngaynhap);
		content.add(txtngaynhap);
		content.add(tongtien);
		content.add(txttongtien);
		content.add(headerTable);
		content.add(panelTable);
		
		add(title,BorderLayout.NORTH);
		add(content,BorderLayout.CENTER);
		
		setVisible(true);
	}
	public void loadSP() throws ClassNotFoundException, SQLException {
		txtmaPNH.setText(Integer.toString(pnh.id));
		txtngaynhap.setText(pnh.date);
		txttongtien.setText(Integer.toString(pnh.total));
		ctpnhBUS.list(pnh.id);
		ArrayList<NhapHangDTO> pnh=new ArrayList<>();
		pnh=ctpnhBUS.getList();
		outModel(model,pnh);	
	}
	public void outModel(DefaultTableModel model , ArrayList<NhapHangDTO> pnh) {
		Vector header=new Vector();
		header.add("");
		header.add("");
		header.add("");
		header.add("");
		header.add("");
		header.add("");
		model = new DefaultTableModel(header,0);
		for(NhapHangDTO pro : pnh)
		{
			Vector row=new Vector();
			row.add(pro.maSP);
			row.add(pro.tenSP);
			row.add(pro.slSP);
			row.add(pro.gianhap);
			row.add(pro.tt);
			row.add(pro.maNCC);
			model.addRow(row);
		}
		table.setModel(model);
		TableColumnModel col=table.getColumnModel();
		col.getColumn(0).setPreferredWidth(80);
		col.getColumn(1).setPreferredWidth(200);
		col.getColumn(2).setPreferredWidth(100);
		col.getColumn(3).setPreferredWidth(150);
		col.getColumn(4).setPreferredWidth(150);
		col.getColumn(5).setPreferredWidth(80);
	}
}
