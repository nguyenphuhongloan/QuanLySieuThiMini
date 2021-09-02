package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import BUS.CT_HoaDonBUS;
import DTO.BillDTO;
import DTO.GioHangDTO;

public class CT_HoaDonGUI extends JFrame{
	private BillDTO hd;
	CT_HoaDonGUI(BillDTO hd) throws ClassNotFoundException, SQLException{
		this.hd=hd;
		init();
	}
	JLabel txtmaHD,txtngayHD,txttongtien;
	JTable table=new JTable();
	DefaultTableModel model = new DefaultTableModel();
	CT_HoaDonBUS cthdBUS=new CT_HoaDonBUS();
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
		
		JLabel title1=new JLabel("CHI TIẾT HÓA ĐƠN");
		title1.setBounds(360, 20, 400, 50);
		title1.setFont(new Font("Tahoma", 1, 27));
		
		JLabel maHD=new JLabel("Mã HD");
		maHD.setFont(font);
		maHD.setBounds(100, 80, 100, 40);
		txtmaHD=new JLabel();
		txtmaHD.setBounds(180, 85, 80, 30);
		txtmaHD.setOpaque(true);
		txtmaHD.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel ngayHD=new JLabel("Ngày HD");
		ngayHD.setFont(font);
		ngayHD.setBounds(305, 80, 150, 40);
		txtngayHD=new JLabel();
		txtngayHD.setBounds(390, 85, 200, 30);
		txtngayHD.setOpaque(true);
		txtngayHD.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel tongtien=new JLabel("Tổng Tiền");
		tongtien.setFont(font);
		tongtien.setBounds(620, 80, 150, 40);
		txttongtien=new JLabel();
		txttongtien.setBounds(710, 85, 200, 30);
		txttongtien.setOpaque(true);
		txttongtien.setBorder(BorderFactory.createLineBorder(Color.black));
		
		load();
		
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
		coltenSP.setBounds(103, 5, 150, 30);
		coltenSP.setForeground(Color.white);
		JLabel colslSP=new JLabel("Số Lượng");
		colslSP.setFont(new Font("Tahoma", 1, 17));
		colslSP.setBounds(326, 5, 100, 30);
		colslSP.setForeground(Color.white);
		JLabel colgiaSP=new JLabel("Giá Nhập");
		colgiaSP.setFont(new Font("Tahoma", 1, 17));
		colgiaSP.setBounds(453, 5, 100, 30);
		colgiaSP.setForeground(Color.white);
		JLabel coltotal=new JLabel("Tổng Cộng");
		coltotal.setFont(new Font("Tahoma", 1, 17));
		coltotal.setBounds(630, 5, 150, 30);
		coltotal.setForeground(Color.white);
		headerTable.add(colmaSP);
		headerTable.add(coltenSP);
		headerTable.add(colslSP);
		headerTable.add(colgiaSP);
		headerTable.add(coltotal);
		
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
		content.add(maHD);
		content.add(txtmaHD);
		content.add(ngayHD);
		content.add(txtngayHD);
		content.add(tongtien);
		content.add(txttongtien);
		content.add(headerTable);
		content.add(panelTable);
		
		add(title,BorderLayout.NORTH);
		add(content,BorderLayout.CENTER);
		
		setVisible(true);
	}
	public void load() throws ClassNotFoundException, SQLException {
		txtmaHD.setText(Integer.toString(hd.idBill));
		txtngayHD.setText(hd.date);
		txttongtien.setText(Integer.toString(hd.total));
		cthdBUS.list(hd.idBill);
		ArrayList<GioHangDTO> bill=new ArrayList<>();
		bill=cthdBUS.getList();
		outModel(model,bill);	
	}
	public void outModel(DefaultTableModel model , ArrayList<GioHangDTO> hd) {
		Vector header=new Vector();
		header.add("");
		header.add("");
		header.add("");
		header.add("");
		header.add("");
		model = new DefaultTableModel(header,0);
		for(GioHangDTO pro : hd)
		{
			Vector row=new Vector();
			row.add(pro.maSP);
			row.add(pro.tenSP);
			row.add(pro.slSP);
			row.add(pro.giaSP);
			row.add(pro.tt);
			model.addRow(row);
		}
		table.setModel(model);
		TableColumnModel col=table.getColumnModel();
		col.getColumn(0).setPreferredWidth(80);
		col.getColumn(1).setPreferredWidth(200);
		col.getColumn(2).setPreferredWidth(100);
		col.getColumn(3).setPreferredWidth(150);
		col.getColumn(4).setPreferredWidth(150);
	}
}
