package GUI;

import BUS.CT_HoaDonBUS;
import BUS.HoaDonBUS;
import BUS.inbill;
import DTO.BillDTO;
import DTO.CheckInput;
import DTO.GioHangDTO;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonGUI extends JPanel {
    private JLabel txtmaHD, txtmaNV, txtmaKH;
    HoaDonGUI() throws SQLException, Exception {
        init();
    }
    com.toedter.calendar.JDateChooser ngaystart;
    com.toedter.calendar.JDateChooser ngayend;
    HoaDonBUS hdBUS = new HoaDonBUS();
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JPanel main;

    public void init() throws ClassNotFoundException, SQLException, Exception {
        setBounds(0, 0, 1150, 800);
        setLayout(null);
        Font font = new Font("Segoe UI", 1, 17);
        load();

        main = new JPanel();
        main.setBounds(0, 0, 1150, 800);
        main.setLayout(new BorderLayout());

        JPanel marginLeft = new JPanel();
        marginLeft.setPreferredSize(new Dimension(60, 0));
        marginLeft.setBackground(Color.white);
        JPanel marginRight = new JPanel();
        marginRight.setPreferredSize(new Dimension(60, 0));
        marginRight.setBackground(Color.white);

        JPanel header = new JPanel();
        header.setPreferredSize(new Dimension(0, 220));
        header.setBackground(Color.white);
        header.setLayout(null);
        JLabel maNV = new JLabel("Mã NV");
        maNV.setBounds(0, 20, 70, 50);
        maNV.setFont(font);
        txtmaNV = new JLabel();
        txtmaNV.setBounds(65, 30, 80, 32);
        txtmaNV.setBorder(BorderFactory.createLineBorder(Color.black));
        txtmaNV.setOpaque(true);
        txtmaNV.setFont(font);
        JLabel maHD = new JLabel("Mã HD");
        maHD.setBounds(175, 20, 70, 50);
        maHD.setFont(font);
        txtmaHD = new JLabel();
        txtmaHD.setBounds(240, 30, 80, 32);
        txtmaHD.setBorder(BorderFactory.createLineBorder(Color.black));
        txtmaHD.setOpaque(true);
        txtmaHD.setFont(font);
        JLabel maKH = new JLabel("Mã KH");
        maKH.setBounds(345, 20, 70, 50);
        maKH.setFont(font);
        txtmaKH = new JLabel();
        txtmaKH.setBounds(410, 30, 80, 32);
        txtmaKH.setBorder(BorderFactory.createLineBorder(Color.black));
        txtmaKH.setOpaque(true);
        txtmaKH.setFont(font);
        JLabel ngayHD = new JLabel("Ngày HD");
        ngayHD.setBounds(0, 80, 90, 50);
        ngayHD.setFont(font);
        JLabel txtngayHD = new JLabel();
        txtngayHD.setBounds(90, 90, 400, 32);
        txtngayHD.setBorder(BorderFactory.createLineBorder(Color.black));
        txtngayHD.setOpaque(true);
        txtngayHD.setFont(font);
        JLabel tongtien = new JLabel("Tổng Tiền");
        tongtien.setBounds(0, 140, 90, 50);
        tongtien.setFont(font);
        JLabel txttongtien = new JLabel();
        txttongtien.setBounds(90, 150, 400, 32);
        txttongtien.setBorder(BorderFactory.createLineBorder(Color.black));
        txttongtien.setOpaque(true);
        txttongtien.setFont(font);

        JButton in = new JButton();
        in.setFocusable(false);
        in.setBorder(BorderFactory.createEmptyBorder());
        in.setBounds(810, 120, 200, 60);
        in.setBackground(new java.awt.Color(128, 0, 128));
        in.setLayout(null);
        JLabel txtin = new JLabel("IN BILL");
        txtin.setForeground(Color.white);
        txtin.setFont(new Font("Tahoma", 0, 30));
        txtin.setBounds(20, 10, 140, 40);
        JLabel iconin = new JLabel(new ImageIcon("image/inbill.png"));
        iconin.setBounds(155, 14, 35, 35);
        in.add(txtin);
        in.add(iconin);
        in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if (i == -1) {
                    new ThongBaoGUI("Vui lòng chọn hàng cần in");
                    return;
                }
                try {
                    String idHD = txtmaHD.getText() ;
                    BillDTO hd = new BillDTO();
                    hd.idBill = Integer.parseInt(idHD);
                    hd.idCustomer = Integer.parseInt(txtmaKH.getText());
                    hd.setIdAdmin(Integer.parseInt(txtmaNV.getText()));
                    hd.date = txtngayHD.getText();
                    hd.total = Integer.parseInt(txttongtien.getText());
                    CT_HoaDonBUS bus = new CT_HoaDonBUS(hd.getIdBill());
                    ArrayList<GioHangDTO> cthd = new ArrayList<>();
                    cthd = bus.getList();
                    inbill bill = new inbill(hd,cthd);
                    bill.print();
                    new ThongBaoGUI("In thành công");
                } catch (Exception ex) {
                    new ThongBaoGUI("In thất bại");
                    ex.printStackTrace();
                }
            }
        });

        JButton chitiet = new JButton();
        chitiet.setFocusable(false);
        chitiet.setBorder(BorderFactory.createEmptyBorder());
        chitiet.setBounds(810, 35, 200, 60);
        chitiet.setBackground(new java.awt.Color(255, 215, 0));
        chitiet.setLayout(null);
        chitiet.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    String idHD = txtmaHD.getText();
                    if (idHD.equals("") == false) {
                        BillDTO hd = new BillDTO();
                        hd.idBill = Integer.parseInt(idHD);
                        hd.date = txtngayHD.getText();
                        hd.total = Integer.parseInt(txttongtien.getText());
                        CT_HoaDonGUI CT_HD = new CT_HoaDonGUI(hd);
                    }
                } catch (ClassNotFoundException | SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        JLabel txtchitiet = new JLabel("CHI TIẾT");
        txtchitiet.setForeground(Color.white);
        txtchitiet.setFont(new Font("Tahoma", 0, 30));
        txtchitiet.setBounds(20, 10, 140, 40);
        JLabel iconct = new JLabel(new ImageIcon("image/more.png"));
        iconct.setBounds(155, 14, 35, 35);
        chitiet.add(txtchitiet);
        chitiet.add(iconct);
        JLabel logo = new JLabel(new ImageIcon("image/billLogo.png"));
        logo.setBounds(580, 50, 128, 128);

        header.add(maNV);
        header.add(txtmaNV);
        header.add(maHD);
        header.add(txtmaHD);
        header.add(maKH);
        header.add(txtmaKH);
        header.add(ngayHD);
        header.add(txtngayHD);
        header.add(tongtien);
        header.add(txttongtien);
        header.add(in);
        header.add(chitiet);
        header.add(logo);

        JLabel sortTitle = new JLabel("---------------------------------------------------------------- LỌC HÓA ĐƠN --------------------------------------------------------------"); // Mỗi bên 74 dấu ( - )
        sortTitle.setBounds(0, 0, 1050, 30);
        sortTitle.setFont(new Font("Tahoma", 0, 18));

        JLabel loc = new JLabel("Thời Gian:");
        loc.setBounds(140, 50, 100, 50);
        loc.setFont(new Font("Tahoma", 0, 20));
        ngaystart = new JDateChooser();
        ngaystart.setBounds(250, 60, 130, 30);

        JLabel iconloc = new JLabel(new ImageIcon("image/linego.png"));
        iconloc.setBounds(505, 63, 30, 30);
        ngayend = new JDateChooser();
        ngayend.setBounds(580, 60, 130, 30);

        JLabel filter = new JLabel(new ImageIcon("image/filter.png"));
        filter.setBounds(850, 55, 40, 40);
        filter.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (ngaystart.getDate() != null && ngayend.getDate() != null) {
                    ArrayList<BillDTO> s = new ArrayList<BillDTO>();
                    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                    String dateS = date.format(ngaystart.getDate());
                    String dateE = date.format(ngayend.getDate());
                    //System.out.print(dateS+" "+dateE);
                    if (CheckInput.xuliDate(dateS, dateE) == true) {
                        try {
                            hdBUS.list();
                            s = hdBUS.listLocDaytoDay(dateS, dateE);
                        } catch (SQLException ex) {
                            Logger.getLogger(HoaDonGUI.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(HoaDonGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        outModel(model, s);
                    } else {
                        ThongBaoGUI tb = new ThongBaoGUI("      Thời gian nhập không hợp lệ");
                    }
                } else {
                    ThongBaoGUI tb = new ThongBaoGUI("      Vui lòng nhập đúng định dạng");
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

        JPanel HeaderTable = new JPanel();
        HeaderTable.setBounds(0, 130, 1150, 40);
        HeaderTable.setBackground(Color.red);
        HeaderTable.setLayout(null);
        JLabel colmaHD = new JLabel("Mã Hóa Đơn");
        colmaHD.setForeground(Color.white);
        colmaHD.setBounds(0, 0, 200, 40);
        colmaHD.setFont(font);
        HeaderTable.add(colmaHD);
        JLabel colmaKH = new JLabel("Mã Khách Hàng");
        colmaKH.setForeground(Color.white);
        colmaKH.setBounds(205, 0, 200, 40);
        colmaKH.setFont(font);
        HeaderTable.add(colmaKH);
        JLabel colmaNV = new JLabel("Mã Nhân Viên");
        colmaNV.setForeground(Color.white);
        colmaNV.setBounds(410, 0, 200, 40);
        colmaNV.setFont(font);
        HeaderTable.add(colmaNV);
        JLabel colinHD = new JLabel("Ngày In Hóa Đơn");
        colinHD.setForeground(Color.white);
        colinHD.setBounds(615, 0, 200, 40);
        colinHD.setFont(font);
        HeaderTable.add(colinHD);
        JLabel coltongtien = new JLabel("Tổng Tiền");
        coltongtien.setForeground(Color.white);
        coltongtien.setBounds(820, 0, 200, 40);
        coltongtien.setFont(font);
        HeaderTable.add(coltongtien);

        JPanel centerTable = new JPanel();
        centerTable.setBounds(0, 170, 1030, 350);
        centerTable.setLayout(null);
        centerTable.setBackground(Color.white);

        table.setBounds(0, 0, 1030, 350);
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
                txtmaHD.setText(table.getModel().getValueAt(i, 0).toString());
                txtmaKH.setText(table.getModel().getValueAt(i, 1).toString());
                txtmaNV.setText(table.getModel().getValueAt(i, 2).toString());
                txtngayHD.setText(table.getModel().getValueAt(i, 3).toString());
                txttongtien.setText(table.getModel().getValueAt(i, 4).toString());
            }
        });
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -5, 1035, 350);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5, 100));
        centerTable.add(scroll);

        JPanel center = new JPanel();
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

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(header, BorderLayout.NORTH);
        content.add(center, BorderLayout.CENTER);

        main.add(marginLeft, BorderLayout.WEST);
        main.add(content, BorderLayout.CENTER);
        main.add(marginRight, BorderLayout.EAST);

        add(main);
    }

    public void load() throws ClassNotFoundException, SQLException, Exception {
        if (hdBUS.getList() == null) {
            hdBUS.list();
        }
//		outModel(model,hdBUS.getList());
//                outModel(model,hdBUS.dshd);

        outModel(model, hdBUS.getList());
    }

    public void outModel(DefaultTableModel model, ArrayList<BillDTO> dshd) {
        Vector header = new Vector();
        header.add("");
        header.add("");
        header.add("");
        header.add("");
        header.add("");
        model = new DefaultTableModel(header, 0);
        for (int i = dshd.size() - 1; i >= 0; i--) {
            Vector row = new Vector();
            row.add(dshd.get(i).idBill);
            row.add(dshd.get(i).idCustomer);
            row.add(dshd.get(i).idAdmin);
            row.add(dshd.get(i).date);
            row.add(dshd.get(i).total);
            model.addRow(row);
        }
        table.setModel(model);
    }
}
