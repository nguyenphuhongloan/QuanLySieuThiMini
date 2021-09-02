package GUI;

import BUS.HoaDonBUS;
import BUS.ThongKeBUS;
import DTO.BillDTO;
import DTO.CheckInput;
import DTO.ThongKe;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ThongKeGUI extends JPanel{
        ThongKeBUS tkbus = new ThongKeBUS();
        HoaDonBUS hdbus = new HoaDonBUS();
        public static JLabel total;
	ThongKeGUI() throws SQLException{
		init();
	}
	JPanel selectDay,selectDay1,selectDay2,selectDay3;
	JTable table=new JTable();
	DefaultTableModel model = new DefaultTableModel();
        com.toedter.calendar.JDateChooser ngaystart;
        com.toedter.calendar.JDateChooser ngayend;
        com.toedter.calendar.JYearChooser namChooser;
        com.toedter.calendar.JYearChooser quyChooser;
	public void init() throws SQLException {
//                tkbus = new ThongKeBUS();
//                hdbus = new  HoaDonBUS();
		setBounds(0,0,1150,800);
		setLayout(null);
		setBackground(Color.white);
		Font font = new Font("Segoe UI",1,15);
		Font font1 = new Font("Tahoma",1,17);
		
		JLabel title=new JLabel("THỐNG KÊ");
		title.setFont(new Font("Tahoma", 1, 40));
		title.setForeground(Color.red);
		title.setBounds(500, 0, 800, 100);
		
		JPanel HeaderTable1=new JPanel();
		HeaderTable1.setBounds(0, 0, 500, 40);
		HeaderTable1.setBackground(Color.red);
		HeaderTable1.setLayout(null);
		JLabel colmaSP=new JLabel("Mã SP");
		colmaSP.setForeground(Color.white);
		colmaSP.setBounds(0,0,100,40);
		colmaSP.setFont(font);
		HeaderTable1.add(colmaSP);
		JLabel coltenSP=new JLabel("Tên SP");
		coltenSP.setForeground(Color.white);
		coltenSP.setBounds(63,0,150,40);
		coltenSP.setFont(font);
		HeaderTable1.add(coltenSP);
		JLabel colsoluong=new JLabel("SL Bán");
		colsoluong.setForeground(Color.white);
		colsoluong.setBounds(230,0,200,40);
		colsoluong.setFont(font);
		HeaderTable1.add(colsoluong);
		JLabel coltongtien=new JLabel("Tổng Tiền");
		coltongtien.setForeground(Color.white);
		coltongtien.setBounds(315,0,200,40);
		coltongtien.setFont(font);
		HeaderTable1.add(coltongtien);
		
		JPanel HeaderTable2=new JPanel();
		HeaderTable2.setBounds(0, 0, 500, 40);
		HeaderTable2.setBackground(Color.red);
		HeaderTable2.setLayout(null);
		JLabel colmaSP2=new JLabel("Mã NV");
		colmaSP2.setForeground(Color.white);
		colmaSP2.setBounds(0,0,100,40);
		colmaSP2.setFont(font);
		HeaderTable2.add(colmaSP2);
		JLabel coltenSP2=new JLabel("Tên NV");
		coltenSP2.setForeground(Color.white);
		coltenSP2.setBounds(63,0,150,40);
		coltenSP2.setFont(font);
		HeaderTable2.add(coltenSP2);
		JLabel colsoluong2=new JLabel("HD Bán");
		colsoluong2.setForeground(Color.white);
		colsoluong2.setBounds(230,0,200,40);
		colsoluong2.setFont(font);
		HeaderTable2.add(colsoluong2);
		JLabel coltongtien2=new JLabel("Tổng Tiền");
		coltongtien2.setForeground(Color.white);
		coltongtien2.setBounds(315,0,200,40);
		coltongtien2.setFont(font);
		HeaderTable2.add(coltongtien2);
		
		JPanel HeaderTable3=new JPanel();
		HeaderTable3.setBounds(0, 0, 500, 40);
		HeaderTable3.setBackground(Color.red);
		HeaderTable3.setLayout(null);
		JLabel colmaSP3=new JLabel("Mã KH");
		colmaSP3.setForeground(Color.white);
		colmaSP3.setBounds(0,0,100,40);
		colmaSP3.setFont(font);
		HeaderTable3.add(colmaSP3);
		JLabel coltenSP3=new JLabel("Tên KH");
		coltenSP3.setForeground(Color.white);
		coltenSP3.setBounds(63,0,150,40);
		coltenSP3.setFont(font);
		HeaderTable3.add(coltenSP3);
		JLabel colsoluong3=new JLabel("HD Mua");
		colsoluong3.setForeground(Color.white);
		colsoluong3.setBounds(230,0,200,40);
		colsoluong3.setFont(font);
		HeaderTable3.add(colsoluong3);
		JLabel coltongtien3=new JLabel("Tổng Tiền");
		coltongtien3.setForeground(Color.white);
		coltongtien3.setBounds(315,0,200,40);
		coltongtien3.setFont(font);
		HeaderTable3.add(coltongtien3);
		
		JPanel HeaderTable=new JPanel();
		HeaderTable.setBounds(0, 0, 500, 40);
		HeaderTable.setBackground(Color.red);
		HeaderTable.setLayout(null);
		
		JLabel control1=new JLabel("Thống Kê Theo");
		control1.setBounds(10, 20, 150, 50);
		control1.setFont(font);
		JLabel control2=new JLabel("Chọn Thời Gian");
		control2.setBounds(10, 80, 150, 50);
		control2.setFont(font);
		ButtonGroup selectLoai = new ButtonGroup();
		JRadioButton select1=new JRadioButton("Sản Phẩm");
		select1.setBounds(160, 30, 100, 30);
		select1.setFont(new Font("Tahoma", 0, 15));
		select1.setFocusable(false);
                select1.setSelected(true);
		select1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HeaderTable.removeAll();
				HeaderTable.add(HeaderTable1);
				HeaderTable.repaint();
				HeaderTable.revalidate();
				reset();
			}
		});
		selectLoai.add(select1);
		JRadioButton select2=new JRadioButton("Nhân Viên");
		select2.setBounds(280, 30, 100, 30);
		select2.setFont(new Font("Tahoma", 0, 15));
		select2.setFocusable(false);
		select2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HeaderTable.removeAll();
				HeaderTable.add(HeaderTable2);
				HeaderTable.repaint();
				HeaderTable.revalidate();
				reset();
			}
		});
		selectLoai.add(select2);
		JRadioButton select3=new JRadioButton("Khách Hàng");
		select3.setBounds(400, 30, 110, 30);
		select3.setFont(new Font("Tahoma", 0, 15));
		select3.setFocusable(false);
		select3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HeaderTable.removeAll();
				HeaderTable.add(HeaderTable3);
				HeaderTable.repaint();
				HeaderTable.revalidate();
				reset();
			}
		});
		selectLoai.add(select3);
                
                
		ButtonGroup selecDate = new ButtonGroup();
		JRadioButton select4=new JRadioButton("Ngày");
                select4.setSelected(true);
		select4.setBounds(160, 90, 100, 30);
		select4.setFont(new Font("Tahoma", 0, 15));
		select4.setFocusable(false);
		select4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectDay.removeAll();
				selectDay.add(selectDay1);
				selectDay.repaint();
				selectDay.revalidate();
			}
		});
		selecDate.add(select4);
		JRadioButton select5=new JRadioButton("Năm");
		select5.setBounds(400, 90, 100, 30);
		select5.setFont(new Font("Tahoma", 0, 15));
		select5.setFocusable(false);
		select5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectDay.removeAll();
				selectDay.add(selectDay2);
				selectDay.repaint();
				selectDay.revalidate();
			}
		});
		selecDate.add(select5);
		JRadioButton select6=new JRadioButton("Quý");
		select6.setBounds(280, 90, 110, 30);
		select6.setFont(new Font("Tahoma", 0, 15));
		select6.setFocusable(false);
		select6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectDay.removeAll();
				selectDay.add(selectDay3);
				selectDay.repaint();
				selectDay.revalidate();
			}
		});
		selecDate.add(select6);
		
		JPanel control=new JPanel();
		control.setBounds(0, 0, 530, 160);
		control.setLayout(null);
		control.add(control1);
		control.add(control2);
		control.add(select1);
		control.add(select2);
		control.add(select3);
		control.add(select4);
		control.add(select5);
		control.add(select6);
		
		selectDay=new JPanel();
		selectDay.setBounds(0, 210, 530, 120);
		selectDay.setLayout(null);
		selectDay.setBackground(Color.white);
		
		selectDay1=new JPanel();
		selectDay1.setBounds(0, 0, 530, 120);
		selectDay1.setLayout(null);
		selectDay1.setBackground(Color.white);
		JLabel ngay1=new JLabel("Từ Ngày");
		ngay1.setFont(font1);
		ngay1.setBounds(75, 10, 100, 50);
        ngaystart = new com.toedter.calendar.JDateChooser();
		ngaystart.setBounds(175, 20, 200, 30);
		
		JLabel ngay2=new JLabel("Đến Ngày");
		ngay2.setFont(font1);
		ngay2.setBounds(75, 60, 100, 50);
        ngayend = new com.toedter.calendar.JDateChooser();
		ngayend.setBounds(175, 70, 200, 30);
		
		selectDay1.add(ngay1);
        selectDay1.add(ngaystart);
		selectDay1.add(ngay2);
        selectDay1.add(ngayend);
		
		selectDay2=new JPanel();
		selectDay2.setBounds(0, 0, 530, 120);
		selectDay2.setLayout(null);
		selectDay2.setBackground(Color.white);
		JLabel nam=new JLabel("Năm");
		nam.setFont(font1);
		nam.setBounds(135, 40, 100, 30);
		String[] year ={"2021"};
		namChooser = new com.toedter.calendar.JYearChooser();
		namChooser.setBounds(250,40,100,30);
		namChooser.setBackground(Color.white);
		namChooser.setFont(new Font("Tahoma", 0, 19));
		selectDay2.add(nam);
		selectDay2.add(namChooser);
		
		selectDay3=new JPanel();
		selectDay3.setBounds(0, 0, 530, 120);
		selectDay3.setLayout(null);
		selectDay3.setBackground(Color.white);
		JLabel quy=new JLabel("Quý");
		quy.setFont(font1);
		quy.setBounds(40, 40, 100, 30);
		String[] QUY ={"Quý 1 (tháng 1-3)","Quý 2 (tháng 3-6)","Quý 3 (tháng 6-9)","Quý 4 (tháng 9-12)"};
		JComboBox selectquy = new JComboBox(QUY);
		selectquy.setBounds(100,40,180,30);
		selectquy.setBackground(Color.white);
		selectquy.setFont(new Font("Tahoma", 0, 17));
		JLabel nam1=new JLabel("Năm");
		nam1.setFont(font1);
		nam1.setBounds(310, 40, 100, 30);
		quyChooser = new com.toedter.calendar.JYearChooser();
		quyChooser.setBounds(370,40,100,30);
		quyChooser.setBackground(Color.white);
		quyChooser.setFont(new Font("Tahoma", 0, 19));
		selectDay3.add(quy);
		selectDay3.add(selectquy);
		selectDay3.add(nam1);
		selectDay3.add(quyChooser);

		JButton thongke=new JButton("Thống Kê");
		thongke.setFont(new Font("Tahoma", 1, 22));
		thongke.setBounds(120, 430, 300, 40);
		thongke.setBackground(Color.lightGray);
		thongke.setFocusable(false);
        thongke.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  if((select1.isSelected()||select2.isSelected()||select3.isSelected())&&(select4.isSelected()||select5.isSelected()||select6.isSelected())) {
                      //ArrayList<BillDTO> listdaytoday = new ArrayList<BillDTO>();
                      ArrayList<BillDTO> listyear = new ArrayList<BillDTO>();
                      ArrayList<BillDTO> listquy1 = new ArrayList<BillDTO>();
                      ArrayList<BillDTO> listquy2 = new ArrayList<BillDTO>();
                      ArrayList<BillDTO> listquy3 = new ArrayList<BillDTO>();
                      ArrayList<BillDTO> listquy4 = new ArrayList<BillDTO>();
                      
//                      SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//                      String dateS = date.format(ngaystart.getDate());
//                      String dateE = date.format(ngayend.getDate());
                      
                      int namchooser1 = namChooser.getYear();
                      
                      int quychooser1=quyChooser.getYear();
                      String getquy= selectquy.getSelectedItem().toString();
                      


                      try {
                          //if(hdbus.getList()==null) 
                              hdbus.list();
//                          listdaytoday = hdbus.listLocDaytoDay(dateS, dateE);
                          
                          listyear = hdbus.arrLocNam(namchooser1);
                          
                          listquy1 = hdbus.listQuy1(quychooser1);
                          listquy2 = hdbus.listQuy2(quychooser1);
                          listquy3 = hdbus.listQuy3(quychooser1);
                          listquy4 = hdbus.listQuy4(quychooser1);
                      } catch (SQLException ex) {
                          Logger.getLogger(ThongKeGUI.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (Exception ex) {
                          Logger.getLogger(ThongKeGUI.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      if(select3.isSelected()){
			if(select5.isSelected()){                            
                            outModel(model, tkbus.ThongKeKhachHangDaytoDay(listyear));                                                           
                        }
                        if(select4.isSelected()){
                        	if(ngaystart.getDate()!=null&&ngayend.getDate()!=null) {
	                                ArrayList<BillDTO> listdaytoday = new ArrayList<BillDTO>();
	                                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	                                String dateS = date.format(ngaystart.getDate());
	                                String dateE = date.format(ngayend.getDate());
	                                if(CheckInput.xuliDate(dateS, dateE)==true) {
			                            try {
			                                hdbus.list();
			                                listdaytoday = hdbus.listLocDaytoDay(dateS, dateE);
			                            } catch (SQLException ex) {
			                                Logger.getLogger(ThongKeGUI.class.getName()).log(Level.SEVERE, null, ex);
			                            } catch (Exception ex) {
			                                Logger.getLogger(ThongKeGUI.class.getName()).log(Level.SEVERE, null, ex);
			                            }                               
			                                outModel(model, tkbus.ThongKeKhachHangDaytoDay(listdaytoday));
	                                }else {
	    	                        	ThongBaoGUI tb=new ThongBaoGUI("      Thời gian nhập không hợp lệ");
	                                }
                        	}else {
                        		ThongBaoGUI tb=new ThongBaoGUI("      Vui lòng nhập đúng định dạng");
                        	}
                            } 
                        if(select6.isSelected()){
                            if(getquy.equals("Quý 1 (tháng 1-3)"))
                            {
                                outModel(model, tkbus.ThongKeKhachHangDaytoDay(listquy1));
                            }
                            if(getquy.equals("Quý 2 (tháng 3-6)"))
                            {
                                outModel(model, tkbus.ThongKeKhachHangDaytoDay(listquy2));
                            }
                            if(getquy.equals("Quý 3 (tháng 6-9)"))
                            {
                                outModel(model, tkbus.ThongKeKhachHangDaytoDay(listquy3));
                            }
                            if(getquy.equals("Quý 4 (tháng 9-12)"))
                            {
                                outModel(model, tkbus.ThongKeKhachHangDaytoDay(listquy4));
                            }
                        }
                      }
                      if(select1.isSelected()){
			if(select5.isSelected()){                            
                            outModel(model, tkbus.ThongKeSpXuat(listyear));                                                           
                        }
                        if(select4.isSelected()){
                        	if(ngaystart.getDate()!=null&&ngayend.getDate()!=null) {
                               ArrayList<BillDTO> listdaytoday = new ArrayList<BillDTO>();
                                   SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                                   String dateS = date.format(ngaystart.getDate());
                                   String dateE = date.format(ngayend.getDate());
                                   if(CheckInput.xuliDate(dateS, dateE)==true) {
		                               try {
		                                   hdbus.list();
		                                   listdaytoday = hdbus.listLocDaytoDay(dateS, dateE);
		                               } catch (SQLException ex) {
		                                   Logger.getLogger(ThongKeGUI.class.getName()).log(Level.SEVERE, null, ex);
		                               } catch (Exception ex) {
		                                   Logger.getLogger(ThongKeGUI.class.getName()).log(Level.SEVERE, null, ex);
		                               }
		                                outModel(model, tkbus.ThongKeSpXuat(listdaytoday));
                                   }else {
       	                        	ThongBaoGUI tb=new ThongBaoGUI("      Thời gian nhập không hợp lệ");
       	                        }
                        	}else {
                        		ThongBaoGUI tb=new ThongBaoGUI("      Vui lòng nhập đúng định dạng");
                        	}
                            } 
                        if(select6.isSelected()){
                            if(getquy.equals("Quý 1 (tháng 1-3)"))
                            {
                                outModel(model, tkbus.ThongKeSpXuat(listquy1));
                            }
                            if(getquy.equals("Quý 2 (tháng 3-6)"))
                            {
                                outModel(model, tkbus.ThongKeSpXuat(listquy2));
                            }
                            if(getquy.equals("Quý 3 (tháng 6-9)"))
                            {
                                outModel(model, tkbus.ThongKeSpXuat(listquy3));
                            }
                            if(getquy.equals("Quý 4 (tháng 9-12)"))
                            {
                                outModel(model, tkbus.ThongKeSpXuat(listquy4));
                            }
                        }
                      }
                      if(select2.isSelected()){
			if(select5.isSelected()){                            
                            outModel(model, tkbus.ThongKeNhanvien(listyear));                                                           
                        }
                        if(select4.isSelected()){
                        	if(ngaystart.getDate()!=null&&ngayend.getDate()!=null) {
                                ArrayList<BillDTO> listdaytoday = new ArrayList<BillDTO>();
                                   SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                                   String dateS = date.format(ngaystart.getDate());
                                   String dateE = date.format(ngayend.getDate());
                                   if(CheckInput.xuliDate(dateS, dateE)==true) {
		                               try {
		                                   hdbus.list();
		                                   listdaytoday = hdbus.listLocDaytoDay(dateS, dateE);
		                               } catch (SQLException ex) {
		                                   Logger.getLogger(ThongKeGUI.class.getName()).log(Level.SEVERE, null, ex);
		                               } catch (Exception ex) {
		                                   Logger.getLogger(ThongKeGUI.class.getName()).log(Level.SEVERE, null, ex);
		                               }
		                                outModel(model, tkbus.ThongKeNhanvien(listdaytoday));
                                   }else {
       	                        	ThongBaoGUI tb=new ThongBaoGUI("      Thời gian nhập không hợp lệ");
       	                        }
                        	}else {
                        		ThongBaoGUI tb=new ThongBaoGUI("      Vui lòng nhập đúng định dạng");
                        	}
                            } 
                        if(select6.isSelected()){
                            if(getquy.equals("Quý 1 (tháng 1-3)"))
                            {
                                outModel(model, tkbus.ThongKeNhanvien(listquy1));
                            }
                            if(getquy.equals("Quý 2 (tháng 3-6)"))
                            {
                                outModel(model, tkbus.ThongKeNhanvien(listquy2));
                            }
                            if(getquy.equals("Quý 3 (tháng 6-9)"))
                            {
                                outModel(model, tkbus.ThongKeNhanvien(listquy3));
                            }
                            if(getquy.equals("Quý 4 (tháng 9-12)"))
                            {
                                outModel(model, tkbus.ThongKeNhanvien(listquy4));
                            }
                        }
                      }
			  }else {
				  ThongBaoGUI tb=new ThongBaoGUI("Vui lòng chọn đầy đủ loại thống kê");
			  }
		  }
		});
		
		JPanel left=new JPanel();
		left.setBounds(50, 130, 530, 500);
		left.setBackground(Color.white);
		left.setLayout(null);
		left.add(control);
		left.add(selectDay);
		left.add(thongke);
		
		
		
		JPanel centerTable=new JPanel();
		centerTable.setBounds(0,40,505,500);
		centerTable.setLayout(null);
		centerTable.setBackground(Color.white);
		table.setBounds(0,0,505,500);
		table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		table.setRowHeight(60);
		table.setShowGrid(false);
	    table.setShowVerticalLines(false);
	    table.setShowHorizontalLines(true);
	    JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -5, 505 , 500);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5,100));
        centerTable.add(scroll);
        
        JLabel tongtien=new JLabel("Tổng Doanh Thu:");
	    tongtien.setBounds(0,555,150,40);
	    tongtien.setFont(font1);
	    total=new JLabel();
	    total.setBounds(170, 560, 250, 30);
	    total.setOpaque(true);
	    total.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel right=new JPanel();
		right.setBounds(620, 130, 500, 600);
		right.setBackground(Color.white);
		right.setLayout(null);
		right.add(HeaderTable);
		right.add(centerTable);
		right.add(tongtien);
		right.add(total);
		
		add(title);
		add(left);
		add(right);
	}
        
        public void outModel(DefaultTableModel model , ArrayList<ThongKe> sp) {
		Vector header=new Vector();
		header.add("");
		header.add("");
		header.add("");
		header.add("");
		
		int tt=0;
		
		model = new DefaultTableModel(header,0);
		for(ThongKe pro : sp)
		{
			Vector row=new Vector();
			row.add(pro.getMa());
			row.add(pro.getTen());
			row.add(pro.getSoluong());
			row.add(pro.getTongtien());
			tt+=pro.getTongtien();
			model.addRow(row);
		}
	table.setModel(model);
	TableColumnModel col=table.getColumnModel();
	total.setText(Integer.toString(tt));

	col.getColumn(0).setPreferredWidth(75);
	col.getColumn(1).setPreferredWidth(200);
	col.getColumn(2).setPreferredWidth(100);
	col.getColumn(3).setPreferredWidth(220);
	
	}
        
	public void reset() {
		Vector header=new Vector();
		header.add("");
		header.add("");
		header.add("");
		header.add("");
		model = new DefaultTableModel(header,0);
		table.setModel(model);
		total.setText("");
		/*
		 * TableColumnModel col=table.getColumnModel();
		 * col.getColumn(0).setPreferredWidth(75);
		 * col.getColumn(1).setPreferredWidth(200);
		 * col.getColumn(2).setPreferredWidth(100);
		 * col.getColumn(3).setPreferredWidth(220);
		 */
	}
        
}
