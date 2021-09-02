package GUI;

import BUS.BanHangBUS;
import BUS.DangNhapBUS;
import DTO.BillDTO;
import DTO.CheckInput;
import DTO.GioHangDTO;

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

public class BanHangGUI extends JPanel {

    public static JLabel txtmaSPchon1, txtmaKH1, txttenSP, txtgiaSP, image;

    BanHangGUI() throws ClassNotFoundException, SQLException {
        init();
    }
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JPanel main1, main2;
    JLabel txtngayHD1, txttongtien;
    JTextField txtsl;
    BanHangBUS bhBUS = new BanHangBUS();

    public void init() throws ClassNotFoundException, SQLException {
        setBounds(0, 0, 1150, 800);
        setLayout(null);
        Font font = new Font("Segoe UI", Font.PLAIN, 17);

        main1 = new JPanel();
        main1.setBounds(0, 0, 1150, 800);
        main1.setLayout(new BorderLayout());
        main2 = new JPanel();
        main2.setBounds(0, 0, 1150, 800);
        main2.setLayout(new BorderLayout());

        JPanel marginLeft = new JPanel();
        marginLeft.setPreferredSize(new Dimension(60, 0));
        marginLeft.setBackground(Color.white);
        JPanel marginRight = new JPanel();
        marginRight.setPreferredSize(new Dimension(60, 0));
        marginRight.setBackground(Color.white);

        JPanel header1 = new JPanel();
        header1.setPreferredSize(new Dimension(0, 160));
        header1.setBackground(Color.white);
        header1.setLayout(null);
        JLabel maNV = new JLabel("Mã NV");
        maNV.setBounds(0, 20, 70, 50);
        maNV.setFont(font);
        JLabel txtmaNV = new JLabel(Integer.toString(DangNhapBUS.login.maNV));
        txtmaNV.setBounds(70, 30, 150, 32);
        txtmaNV.setBorder(BorderFactory.createLineBorder(Color.black));
        txtmaNV.setOpaque(true);
        txtmaNV.setFont(font);
        JLabel maKH = new JLabel("Mã KH");
        maKH.setBounds(310, 20, 70, 50);
        maKH.setFont(font);
        JLabel txtmaKH = new JLabel();
        txtmaKH.setBounds(380, 30, 150, 32);
        txtmaKH.setBorder(BorderFactory.createLineBorder(Color.black));
        txtmaKH.setOpaque(true);
        txtmaKH.setFont(font);
        JLabel tongtien = new JLabel("Tổng Tiền (VNĐ)");
        tongtien.setBounds(620, 20, 150, 50);
        tongtien.setFont(font);
        txttongtien = new JLabel();
        txttongtien.setBounds(770, 30, 220, 32);
        txttongtien.setBorder(BorderFactory.createLineBorder(Color.black));
        txttongtien.setOpaque(true);
        txttongtien.setFont(font);
        JLabel ngayHD = new JLabel("Ngày HD");
        ngayHD.setBounds(0, 80, 90, 50);
        ngayHD.setFont(font);
        JLabel txtngayHD = new JLabel();
        txtngayHD.setBounds(90, 90, 300, 32);
        txtngayHD.setBorder(BorderFactory.createLineBorder(Color.black));
        txtngayHD.setOpaque(true);
        txtngayHD.setFont(font);
        JButton taohd = new JButton("Tạo Hóa Đơn");
        taohd.setFocusable(false);
        taohd.setBounds(600, 95, 200, 30);
        taohd.setBackground(new java.awt.Color(220, 220, 220));
        taohd.setFont(font);
        taohd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                createHD();
            }
        });
        JPanel line = new JPanel();
        line.setBounds(0, 157, 1050, 1);
        line.setBackground(Color.black);

        header1.add(maNV);
        header1.add(txtmaNV);
        header1.add(maKH);
        header1.add(txtmaKH);
        header1.add(tongtien);
        header1.add(txttongtien);
        header1.add(ngayHD);
        header1.add(txtngayHD);
        header1.add(taohd);
        header1.add(line);

        JPanel center1 = new JPanel();
        center1.setLayout(null);
        center1.setBackground(Color.white);
        JLabel icon = new JLabel(new ImageIcon("image/shopping.png"));
        icon.setBounds(50, 100, 300, 300);
        JPanel line1 = new JPanel();
        line1.setBounds(360, 280, 590, 1);
        line1.setBackground(Color.black);
        JLabel title = new JLabel("TẠO HÓA ĐƠN");
        title.setBounds(360, 200, 300, 80);
        title.setForeground(new java.awt.Color(178, 34, 34));
        title.setFont(new Font("Tahoma", 1, 40));
        center1.add(line1);
        center1.add(icon);
        center1.add(title);

        JPanel content1 = new JPanel();
        content1.setLayout(new BorderLayout());
        content1.add(header1, BorderLayout.NORTH);
        content1.add(center1, BorderLayout.CENTER);

        main1.add(marginLeft, BorderLayout.WEST);
        main1.add(content1, BorderLayout.CENTER);
        main1.add(marginRight, BorderLayout.EAST);

//---------------------------------------------------------------------------------------------------------------------------------------------------------
        JPanel marginLeft1 = new JPanel();
        marginLeft1.setPreferredSize(new Dimension(60, 0));
        marginLeft1.setBackground(Color.white);
        JPanel marginRight1 = new JPanel();
        marginRight1.setPreferredSize(new Dimension(60, 0));
        marginRight1.setBackground(Color.white);

        JPanel header2 = new JPanel();
        header2.setPreferredSize(new Dimension(0, 160));
        header2.setBackground(Color.white);
        header2.setLayout(null);
        JLabel maNV1 = new JLabel("Mã NV");
        maNV1.setBounds(0, 20, 70, 50);
        maNV1.setFont(font);
        JLabel txtmaNV1 = new JLabel(Integer.toString(DangNhapBUS.login.maNV));
        txtmaNV1.setBounds(70, 30, 150, 32);
        txtmaNV1.setBorder(BorderFactory.createLineBorder(Color.black));
        txtmaNV1.setOpaque(true);
        txtmaNV1.setFont(font);
        JLabel maKH1 = new JLabel("Mã KH");
        maKH1.setBounds(280, 20, 70, 50);
        maKH1.setFont(font);
        txtmaKH1 = new JLabel();
        txtmaKH1.setBounds(350, 30, 150, 32);
        txtmaKH1.setBorder(BorderFactory.createLineBorder(Color.black));
        txtmaKH1.setOpaque(true);
        txtmaKH1.setFont(font);
        JButton selectmaKH = new JButton("...");
        selectmaKH.setBounds(500, 35, 25, 25);
        selectmaKH.setFocusable(false);
        selectmaKH.setBorder(BorderFactory.createLineBorder(Color.black));
        selectmaKH.setFont(new Font("Tahoma", 0, 17));
        selectmaKH.setBackground(Color.lightGray);
        selectmaKH.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    new ChonKHGUI();
                } catch (ClassNotFoundException | SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        JLabel tongtien1 = new JLabel("Tổng Tiền (VNĐ)");
        tongtien1.setBounds(620, 20, 150, 50);
        tongtien1.setFont(font);
        JLabel txttongtien1 = new JLabel();
        txttongtien1.setBounds(770, 30, 220, 32);
        txttongtien1.setBorder(BorderFactory.createLineBorder(Color.black));
        txttongtien1.setOpaque(true);
        txttongtien1.setFont(font);
        JLabel ngayHD1 = new JLabel("Ngày HD");
        ngayHD1.setBounds(0, 80, 90, 50);
        ngayHD1.setFont(font);
        txtngayHD1 = new JLabel();
        txtngayHD1.setBounds(90, 90, 300, 32);
        txtngayHD1.setBorder(BorderFactory.createLineBorder(Color.black));
        txtngayHD1.setOpaque(true);
        txtngayHD1.setFont(font);
        JPanel line2 = new JPanel();
        line2.setBounds(0, 157, 1050, 1);
        line2.setBackground(Color.black);
        JButton huy = new JButton("Hủy");
        huy.setFocusable(false);
        huy.setBounds(800, 95, 150, 30);
        huy.setBackground(new java.awt.Color(220, 220, 220));
        huy.setFont(font);
        huy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                txtmaSPchon1.setText("");
                table.removeAll();
                model.getDataVector().removeAllElements();
                image.setIcon(new ImageIcon());
                txttenSP.setText("");
                txtgiaSP.setText("");
                txtsl.setText("");
                txttongtien1.setText("");
                cancelHD();
            }
        });
        JButton xacnhan = new JButton("Xác Nhận");
        xacnhan.setFocusable(false);
        xacnhan.setBounds(600, 95, 150, 30);
        xacnhan.setBackground(new java.awt.Color(220, 220, 220));
        xacnhan.setFont(font);
        xacnhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                BillDTO bill = new BillDTO();
                bill.idAdmin = Integer.parseInt(txtmaNV1.getText());
                if (txtmaKH1.getText().equals("")) {
                    new ThongBaoGUI("Vui lòng chọn mã khách hàng");
                    return;
                } else {
                    bill.idCustomer = Integer.parseInt(txtmaKH1.getText());
                }
                bill.date = txtngayHD1.getText();
                if (txttongtien1.getText().equals("") == false) {
                    bill.total = Integer.parseInt(txttongtien1.getText());
                }
                try {
                    bhBUS.banhang(bill);
                    outModel(model, bhBUS.getList());
                    txtmaKH1.setText("");
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        header2.add(maNV1);
        header2.add(txtmaNV1);
        header2.add(maKH1);
        header2.add(txtmaKH1);
        header2.add(selectmaKH);
        header2.add(tongtien1);
        header2.add(txttongtien1);
        header2.add(ngayHD1);
        header2.add(txtngayHD1);
        header2.add(xacnhan);
        header2.add(huy);
        header2.add(line2);

        JPanel center2 = new JPanel();
        center2.setLayout(new BorderLayout());

        JPanel center2Left = new JPanel();
        center2Left.setBackground(Color.white);
        center2Left.setPreferredSize(new Dimension(330, 0));
        center2Left.setLayout(null);
        image = new JLabel();
        image.setBounds(0, 30, 330, 330);
        image.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel maSP = new JLabel("Mã SP");
        maSP.setFont(font);
        maSP.setBounds(0, 373, 70, 40);
        txtmaSPchon1 = new JLabel();
        txtmaSPchon1.setBounds(70, 380, 70, 30);
        txtmaSPchon1.setBorder(BorderFactory.createLineBorder(Color.black));
        txtmaSPchon1.setOpaque(true);
        txtmaSPchon1.setFont(font);
        txtmaSPchon1.addMouseListener(new MouseListener() {

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
                txttenSP.setText("");
                txtgiaSP.setText("");
                txtsl.setText("");
            }
        });
        JButton selectmaSP = new JButton("...");
        selectmaSP.setBounds(140, 383, 25, 25);
        selectmaSP.setFocusable(false);
        selectmaSP.setBorder(BorderFactory.createLineBorder(Color.black));
        selectmaSP.setFont(new Font("Tahoma", 0, 17));
        selectmaSP.setBackground(Color.lightGray);
        selectmaSP.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    txttenSP.setText("");
                    txtgiaSP.setText("");
                    txtsl.setText("");
                    java.awt.Image newImage = new ImageIcon("image/noimage.png").getImage().getScaledInstance(330, 330, 200);
                    image.setIcon(new ImageIcon(newImage));
                    ChonSPGUI selectSP = new ChonSPGUI();
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JLabel sl = new JLabel("Số lượng");
        sl.setFont(font);
        sl.setBounds(190, 373, 80, 40);
        txtsl = new JTextField();
        txtsl.setBounds(270, 380, 58, 30);
        txtsl.setBorder(BorderFactory.createLineBorder(Color.black));
        txtsl.setOpaque(true);
        txtsl.setBackground(Color.white);
        txtsl.setFont(font);
        JLabel tenSP = new JLabel("Tên SP");
        tenSP.setFont(font);
        tenSP.setBounds(0, 420, 70, 40);
        txttenSP = new JLabel();
        txttenSP.setBounds(70, 425, 257, 30);
        txttenSP.setBorder(BorderFactory.createLineBorder(Color.black));
        txttenSP.setOpaque(true);
        txttenSP.setFont(font);
        JLabel giaSP = new JLabel("Giá SP");
        giaSP.setFont(font);
        giaSP.setBounds(0, 467, 70, 40);
        txtgiaSP = new JLabel();
        txtgiaSP.setBounds(70, 472, 257, 30);
        txtgiaSP.setBorder(BorderFactory.createLineBorder(Color.black));
        txtgiaSP.setOpaque(true);
        txtgiaSP.setFont(font);
        JButton them = new JButton("Thêm");
        them.setBackground(new java.awt.Color(220, 220, 220));
        them.setFont(font);
        them.setFocusable(false);
        them.setBounds(120, 520, 100, 40);
        them.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    if (txtmaSPchon1.getText().equals("") == false) {
                        if (txtsl.getText().equals("") == false) {
                            boolean check = true;
                            if (CheckInput.checkStringNumber(txtsl.getText()) == false) {
                                check = false;
                                ThongBaoGUI tb = new ThongBaoGUI("     Số Lượng Nhập Không Phù Hợp !");
                            }
                            if (check == true) {
                                if (CheckInput.checkInt(txtsl.getText()) == false) {
                                    check = false;
                                    ThongBaoGUI tb = new ThongBaoGUI("     Số Lượng Nhập Không Phù Hợp !");
                                }
                            }
                            if (check == true) {
                                int id = Integer.parseInt(txtmaSPchon1.getText());
                                int sl = Integer.parseInt(txtsl.getText());
                                if (sl <= 0) {
                                    check = false;
                                    ThongBaoGUI tb = new ThongBaoGUI("     Số Lượng Nhập Không Phù Hợp !");
                                }
                            }
                            if (check == true) {
                                int id = Integer.parseInt(txtmaSPchon1.getText());
                                int sl = Integer.parseInt(txtsl.getText());
                                bhBUS.add(id, sl);
                                int total = bhBUS.total();
                                txttongtien1.setText(Integer.toString(total));
                                outModel(model, bhBUS.getList());
                                cleanView();
                            }
                        } else {
                            ThongBaoGUI tb = new ThongBaoGUI("         Vui Lòng Nhập Số Lượng !");
                        }
                    }
                } catch (Exception e2) {
                    // TODO: handle exception
                    System.out.print("That bai");
                }

            }
        });

        center2Left.add(image);
        center2Left.add(maSP);
        center2Left.add(txtmaSPchon1);
        center2Left.add(selectmaSP);
        center2Left.add(sl);
        center2Left.add(txtsl);
        center2Left.add(tenSP);
        center2Left.add(txttenSP);
        center2Left.add(giaSP);
        center2Left.add(txtgiaSP);
        center2Left.add(them);

        JPanel center2Right = new JPanel();
        center2Right.setBackground(Color.white);
        center2Right.setLayout(null);
        JPanel headerTable = new JPanel();
        headerTable.setLayout(null);
        headerTable.setBackground(Color.red);
        headerTable.setBounds(20, 30, 700, 40);
        JLabel maSP1 = new JLabel("Mã SP");
        maSP1.setFont(new Font("Tahoma", 1, 16));
        maSP1.setBounds(0, 5, 170, 30);
        maSP1.setForeground(Color.white);
        JLabel tenSP1 = new JLabel("Tên Sản Phẩm");
        tenSP1.setFont(new Font("Tahoma", 1, 16));
        tenSP1.setBounds(73, 5, 280, 30);
        tenSP1.setForeground(Color.white);
        JLabel giaSP1 = new JLabel("Đơn Giá");
        giaSP1.setFont(new Font("Tahoma", 1, 16));
        giaSP1.setBounds(278, 5, 130, 30);
        giaSP1.setForeground(Color.white);
        JLabel slSP1 = new JLabel("Số Lượng");
        slSP1.setFont(new Font("Tahoma", 1, 16));
        slSP1.setBounds(397, 5, 100, 30);
        slSP1.setForeground(Color.white);
        JLabel tt = new JLabel("Tổng Tiền");
        tt.setFont(new Font("Tahoma", 1, 16));
        tt.setBounds(486, 5, 100, 30);
        tt.setForeground(Color.white);
        JLabel img = new JLabel("IMG");
        img.setFont(new Font("Tahoma", 1, 16));
        img.setBounds(604, 5, 100, 30);
        img.setForeground(Color.white);
        headerTable.add(maSP1);
        headerTable.add(tenSP1);
        headerTable.add(giaSP1);
        headerTable.add(slSP1);
        headerTable.add(tt);
        headerTable.add(img);

        JPanel panelTable = new JPanel();
        panelTable.setLayout(null);
        panelTable.setBounds(20, 70, 680, 430);
        panelTable.setBackground(Color.white);
        table.setBounds(0, 0, 680, 430);
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
                String imageSP = table.getModel().getValueAt(i, 5).toString();
                txtmaSPchon1.setText(table.getModel().getValueAt(i, 0).toString());
                txttenSP.setText(table.getModel().getValueAt(i, 1).toString());
                txtgiaSP.setText(table.getModel().getValueAt(i, 2).toString());
                txtsl.setText(table.getModel().getValueAt(i, 3).toString());
                java.awt.Image newImage;
                try {
                    newImage = new ImageIcon("image/" + imageSP).getImage().getScaledInstance(330, 330, 200);
                } catch (NullPointerException E) {
                    newImage = new ImageIcon().getImage().getScaledInstance(330, 330, 200);
                }
                image.setIcon(new ImageIcon(newImage));
            }
        });
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -5, 685, 430);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5, 100));
        panelTable.add(scroll);

        JButton sua = new JButton("Sửa");
        sua.setBackground(new java.awt.Color(220, 220, 220));
        sua.setFont(font);
        sua.setFocusable(false);
        sua.setBounds(200, 520, 130, 40);
        sua.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int i = table.getSelectedRow();
                if (i != -1) {
                    try {
                        if (txtmaSPchon1.getText().equals("") == false) {
                            if (txtsl.getText().equals("") == false) {
                                boolean check = true;
                                if (CheckInput.checkStringNumber(txtsl.getText()) == false) {
                                    check = false;
                                    ThongBaoGUI tb = new ThongBaoGUI("     Số Lượng Nhập Không Phù Hợp !");
                                }
                                if (check == true) {
                                    int id = Integer.parseInt(txtmaSPchon1.getText());
                                    int sl = Integer.parseInt(txtsl.getText());
                                    if (sl <= 0) {
                                        check = false;
                                        ThongBaoGUI tb = new ThongBaoGUI("     Số Lượng Nhập Không Phù Hợp !");
                                    }
                                }
                                if (check == true) {
                                    ArrayList<GioHangDTO> dssp = bhBUS.getList();
                                    int idSP = Integer.parseInt(txtmaSPchon1.getText());
                                    int sl = Integer.parseInt(txtsl.getText());
                                    bhBUS.set(i, idSP, sl);
                                    int total = bhBUS.total();
                                    txttongtien1.setText(Integer.toString(total));
                                    outModel(model, bhBUS.getList());
                                    cleanView();
                                }
                            } else {
                                ThongBaoGUI tb = new ThongBaoGUI("         Vui Lòng Nhập Số Lượng !");
                            }
                        }
                    } catch (Exception a) {
                        // TODO: handle exception
                        System.out.print("fail");
                    }
                }
            }
        });
        JButton xoa = new JButton("Xóa");
        xoa.setBackground(new java.awt.Color(220, 220, 220));
        xoa.setFont(font);
        xoa.setFocusable(false);
        xoa.setBounds(380, 520, 130, 40);
        xoa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int i = table.getSelectedRow();
                if (i != -1) {
                    bhBUS.delete(i);
                    int total = bhBUS.total();
                    txttongtien1.setText(Integer.toString(total));
                    outModel(model, bhBUS.getList());
                    cleanView();
                }
            }
        });
        center2Right.add(headerTable);
        center2Right.add(panelTable);
        center2Right.add(sua);
        center2Right.add(xoa);

        center2.add(center2Left, BorderLayout.WEST);
        center2.add(center2Right, BorderLayout.CENTER);

        JPanel content2 = new JPanel();
        content2.setLayout(new BorderLayout());
        content2.add(header2, BorderLayout.NORTH);
        content2.add(center2, BorderLayout.CENTER);

        main2.add(marginLeft1, BorderLayout.WEST);
        main2.add(content2, BorderLayout.CENTER);
        main2.add(marginRight1, BorderLayout.EAST);

        add(main1);
    }

    public void createHD() {
        removeAll();
        add(main2);
        repaint();
        revalidate();
        LocalDateTime date = java.time.LocalDateTime.now();
        String day = date.toString();
        String[] d = day.split("T");
        txtngayHD1.setText(d[0]);
    }

    public void cancelHD() {
        removeAll();
        add(main1);
        repaint();
        revalidate();
    }

    public void outModel(DefaultTableModel model, ArrayList<GioHangDTO> sp) {
        Vector header = new Vector();
        header.add("");
        header.add("");
        header.add("");
        header.add("");
        header.add("");
        header.add("");
        model = new DefaultTableModel(header, 0);
        for (GioHangDTO pro : sp) {
            Vector row = new Vector();
            row.add(pro.maSP);
            row.add(pro.tenSP);
            row.add(pro.giaSP);
            row.add(pro.slSP);
            row.add(pro.tt);
            row.add(pro.image);
            model.addRow(row);
        }
        table.setModel(model);
        TableColumnModel col = table.getColumnModel();

        col.getColumn(0).setPreferredWidth(80);
        col.getColumn(1).setPreferredWidth(230);
        col.getColumn(2).setPreferredWidth(130);
        col.getColumn(3).setPreferredWidth(100);
        col.getColumn(4).setPreferredWidth(130);
        col.getColumn(5).setPreferredWidth(80);
    }
    
    public void cleanView(){
        txtmaSPchon1.setText("");
        txttenSP.setText("");
        txtsl.setText("");
        txtgiaSP.setText("");
        java.awt.Image newImage = new ImageIcon("image/noimage.png").getImage().getScaledInstance(330, 330, 200);
        image.setIcon(new ImageIcon(newImage));
    }
}
