package GUI;

import BUS.CT_PhieuNhapHangBUS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import BUS.PhieuNhapHangBUS;
import BUS.inPhieuNhap;
import DTO.BillDTO;
import DTO.CheckInput;
import DTO.PhieuNhapHangDTO;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuNhapHangGUI extends JPanel{
	PhieuNhapHangGUI() throws ClassNotFoundException, SQLException{
		init();
	}
        com.toedter.calendar.JDateChooser ngaystart;
        com.toedter.calendar.JDateChooser ngayend;
	JTable table=new JTable();
	DefaultTableModel model = new DefaultTableModel();
	JPanel main;
	PhieuNhapHangBUS pnhBUS=new PhieuNhapHangBUS();
	public void init() throws ClassNotFoundException, SQLException {
		setBounds(0,0,1150,800);
		setLayout(null);
		Font font = new Font("Segoe UI",1,17);
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
		header.setPreferredSize(new Dimension(0,220));
		header.setBackground(Color.white);
		header.setLayout(null);
		JLabel maPNH=new JLabel("Mã PNH");
		maPNH.setBounds(0,20,70,50);
		maPNH.setFont(font);
		JLabel txtmaPNH=new JLabel();
		txtmaPNH.setBounds(110,30,100,32);
		txtmaPNH.setBorder(BorderFactory.createLineBorder(Color.black));
		txtmaPNH.setOpaque(true);
		txtmaPNH.setFont(font);
		JLabel maNV=new JLabel("Mã NV");
		maNV.setBounds(300,20,70,50);
		maNV.setFont(font);
		JLabel txtmaNV=new JLabel();
		txtmaNV.setBounds(390,30,100,32);
		txtmaNV.setBorder(BorderFactory.createLineBorder(Color.black));
		txtmaNV.setOpaque(true);
		txtmaNV.setFont(font);
		JLabel ngaynhap=new JLabel("Ngày Nhập");
		ngaynhap.setBounds(0,80,90,50);
		ngaynhap.setFont(font);
		JLabel txtngaynhap=new JLabel();
		txtngaynhap.setBounds(110,90,380,32);
		txtngaynhap.setBorder(BorderFactory.createLineBorder(Color.black));
		txtngaynhap.setOpaque(true);
		txtngaynhap.setFont(font);
		JLabel tongtien=new JLabel("Tổng Tiền");
		tongtien.setBounds(0,140,90,50);
		tongtien.setFont(font);
		JLabel txttongtien=new JLabel();
		txttongtien.setBounds(110,150,380,32);
		txttongtien.setBorder(BorderFactory.createLineBorder(Color.black));
		txttongtien.setOpaque(true);
		txttongtien.setFont(font);
		
		JButton in=new JButton();
		in.setFocusable(false);
		in.setBorder(BorderFactory.createEmptyBorder());
		in.setBounds(810, 120, 200, 60);
		in.setBackground(new java.awt.Color(128,0,128));
		in.setLayout(null);
		JLabel txtin=new JLabel("IN PNH");
		txtin.setForeground(Color.white);
		txtin.setFont(new Font("Tahoma", 0, 30));
		txtin.setBounds(20, 10, 140, 40);
		JLabel iconin=new JLabel(new ImageIcon("image/inbill.png"));
		iconin.setBounds(155, 14, 35, 35);
		in.add(txtin);
		in.add(iconin);
                in.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       int i = table.getSelectedRow();
                       if(i==-1){
                           new ThongBaoGUI("Vui lòng chọn hàng cần in");
                           return;
                       }
                        try {
                            String idPNH=txtmaPNH.getText();
                            int id = Integer.parseInt(idPNH);
                            String date = txtngaynhap.getText();
                            int total = Integer.parseInt(txttongtien.getText());
                            int idNV = Integer.parseInt(txtmaNV.getText());
                            PhieuNhapHangDTO pnh = new PhieuNhapHangDTO(id, total, idNV, date);
                            CT_PhieuNhapHangBUS bus = new CT_PhieuNhapHangBUS();
                            bus.list(id);
                            inPhieuNhap pn = new inPhieuNhap(pnh, bus.getList());
                            pn.print();
                            new ThongBaoGUI("In thành công");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            new ThongBaoGUI("In thất bại");
                        }
                        
                        
                    }
                });
                
		JButton chitiet=new JButton();
		chitiet.setFocusable(false);
		chitiet.setBorder(BorderFactory.createEmptyBorder());
		chitiet.setBounds(810, 35, 200, 60);
		chitiet.setBackground(new java.awt.Color(255,215,0));
		chitiet.setLayout(null);
		chitiet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String idPNH=txtmaPNH.getText();
					
					if(idPNH.equals("")==false) {
						int id=Integer.parseInt(idPNH);
						String date=txtngaynhap.getText();
						int total=Integer.parseInt(txttongtien.getText());
						PhieuNhapHangDTO pnh=new PhieuNhapHangDTO(id, total, date);
						CT_PhieuNhapHangGUI CT_PNH=new CT_PhieuNhapHangGUI(pnh);
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JLabel txtchitiet=new JLabel("CHI TIẾT");
		txtchitiet.setForeground(Color.white);
		txtchitiet.setFont(new Font("Tahoma", 0, 30));
		txtchitiet.setBounds(20, 10, 140, 40);
		JLabel iconct=new JLabel(new ImageIcon("image/more.png"));
		iconct.setBounds(155, 14, 35, 35);
		chitiet.add(txtchitiet);
		chitiet.add(iconct);
		JLabel logo=new JLabel(new ImageIcon("image/receipt.png"));
		logo.setBounds(580, 50, 128, 128);

		header.add(maPNH);
		header.add(txtmaPNH);
		header.add(maNV);
		header.add(txtmaNV);
		header.add(ngaynhap);
		header.add(txtngaynhap);
		header.add(tongtien);
		header.add(txttongtien);
		header.add(in);
		header.add(chitiet);
		header.add(logo);
		
		JLabel sortTitle = new JLabel("----------------------------------------------------------- LỌC PHIẾU NHẬP HÀNG --------------------------------------------------------------"); // Mỗi bên 74 dấu ( - )
	    sortTitle.setBounds(0,0, 1050, 30);
	    sortTitle.setFont(new Font("Tahoma", 0, 18));
	    
	    JLabel loc=new JLabel("Thời Gian:");
	    loc.setBounds(140, 50, 100, 50);
	    loc.setFont(new Font("Tahoma", 0, 20));
            ngaystart = new JDateChooser();
	    ngaystart.setBounds(250, 60, 130, 30);
	    JLabel iconloc=new JLabel(new ImageIcon("image/linego.png"));
	    iconloc.setBounds(505, 63, 30, 30);
            ngayend = new JDateChooser();
	    ngayend.setBounds(580, 60, 130, 30);
	    JLabel filter=new JLabel(new ImageIcon("image/filter.png"));
	    filter.setBounds(850, 55, 40, 40);
            filter.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    	if(ngaystart.getDate()!=null&&ngayend.getDate()!=null) {
	                        ArrayList<PhieuNhapHangDTO> s = new ArrayList<PhieuNhapHangDTO>();
	                        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	                        String dateS = date.format(ngaystart.getDate());
	                        String dateE = date.format(ngayend.getDate());
	                        if(CheckInput.xuliDate(dateS, dateE)==true) {
		                        try {
		                            pnhBUS.list();
		                            s = pnhBUS.listLocDaytoDay(dateS, dateE);
		                        } catch (SQLException ex) {
		                            Logger.getLogger(HoaDonGUI.class.getName()).log(Level.SEVERE, null, ex);
		                        } catch (Exception ex) {
		                            Logger.getLogger(HoaDonGUI.class.getName()).log(Level.SEVERE, null, ex);
		                        }
		                        outModel(model, s);
	                        }else {
	                        	ThongBaoGUI tb=new ThongBaoGUI("      Thời gian nhập không hợp lệ");
	                        }
                    	}else {
                    		ThongBaoGUI tb=new ThongBaoGUI("      Vui lòng nhập đúng định dạng");
                    	}
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        
                    }
                });
	    
		
		JPanel HeaderTable=new JPanel();
		HeaderTable.setBounds(0, 130, 1150, 40);
		HeaderTable.setBackground(Color.red);
		HeaderTable.setLayout(null);
		JLabel colmaPNH=new JLabel("Mã PNH");
		colmaPNH.setForeground(Color.white);
		colmaPNH.setBounds(0,0,200,40);
		colmaPNH.setFont(font);
		HeaderTable.add(colmaPNH);
		JLabel coltenNV=new JLabel("Mã NV");
		coltenNV.setForeground(Color.white);
		coltenNV.setBounds(255,0,200,40);
		coltenNV.setFont(font);
		HeaderTable.add(coltenNV);
		JLabel colngaynhap=new JLabel("Ngày Nhập Hàng");
		colngaynhap.setForeground(Color.white);
		colngaynhap.setBounds(514,0,200,40);
		colngaynhap.setFont(font);
		HeaderTable.add(colngaynhap);
		JLabel coltongtien=new JLabel("Tổng Tiền");
		coltongtien.setForeground(Color.white);
		coltongtien.setBounds(770,0,200,40);
		coltongtien.setFont(font);
		HeaderTable.add(coltongtien);
		
		JPanel centerTable=new JPanel();
		centerTable.setBounds(0,170,1030,350);
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
				txtmaPNH.setText(table.getModel().getValueAt(i, 0).toString());
				txtmaNV.setText(table.getModel().getValueAt(i, 1).toString());
				txtngaynhap.setText(table.getModel().getValueAt(i, 2).toString());
				txttongtien.setText(table.getModel().getValueAt(i, 3).toString());
			}
		});
	    JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -5, 1035 , 350);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5,100));
        centerTable.add(scroll);
		
		JPanel center=new JPanel();
		center.setLayout(null);
		center.setBackground(Color.white);
		center.add(sortTitle);
		center.add(loc);
		center.add(ngaystart);
		center.add(iconloc);
		center.add(ngayend);
		center.add(filter);
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
	public void load() throws ClassNotFoundException, SQLException {
		if(pnhBUS.getList()==null) pnhBUS.list();
		outModel(model,pnhBUS.getList());	
	}
	public void outModel(DefaultTableModel model , ArrayList<PhieuNhapHangDTO> dspnh) {
		Vector header=new Vector();
		header.add("");
		header.add("");
		header.add("");
		header.add("");
		model = new DefaultTableModel(header,0);
		for(int i=dspnh.size()-1;i>=0;i--)
		{
			Vector row=new Vector();
			row.add(dspnh.get(i).id);
			row.add(dspnh.get(i).idAccount);
			row.add(dspnh.get(i).date);
			row.add(dspnh.get(i).total);
			model.addRow(row);
		}
		table.setModel(model);
	}
}
