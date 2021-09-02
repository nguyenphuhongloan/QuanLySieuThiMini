package GUI;

import BUS.SanPhamBUS;
import DTO.ProductDTO;
import static GUI.BanHangGUI.image;

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

public class ChonSPGUI extends JFrame {

    ChonSPGUI() throws ClassNotFoundException, SQLException {
        init();
    }
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    SanPhamBUS spBUS = new SanPhamBUS();
    JComboBox txtDVT, txtsearchloai;
    String imageSP;

    public void init() throws ClassNotFoundException, SQLException {
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setLayout(new BorderLayout(1, 1));
        Font font = new Font("Segoe UI", Font.PLAIN, 17);
        loadSP();

        JPanel title = new JPanel();
        title.setBackground(Color.black);
        title.setPreferredSize(new Dimension(0, 40));
        title.setLayout(null);
        JLabel close = new JLabel(new ImageIcon("image/close.png"));
        close.setBounds(1150, 0, 40, 40);
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

        JPanel contetLeft = new JPanel();
        contetLeft.setLayout(null);
        contetLeft.setBackground(Color.white);
        contetLeft.setPreferredSize(new Dimension(450, 0));

        JLabel title1 = new JLabel("Thông Tin Sản Phẩm");
        title1.setBounds(70, 20, 300, 50);
        title1.setFont(new Font("Tahoma", 1, 27));
        JLabel img = new JLabel();
        img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        img.setOpaque(true);
        img.setBackground(Color.white);
        img.setBounds(85, 90, 250, 250);
        JLabel maSP = new JLabel("Mã SP");
        maSP.setBounds(40, 360, 80, 40);
        maSP.setFont(font);
        JLabel txtmaSP = new JLabel();
        txtmaSP.setBounds(110, 365, 260, 30);
        txtmaSP.setOpaque(true);
        txtmaSP.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel tenSP = new JLabel("Tên SP");
        tenSP.setBounds(40, 410, 80, 40);
        tenSP.setFont(font);
        JLabel txttenSP = new JLabel();
        txttenSP.setBounds(110, 415, 260, 30);
        txttenSP.setOpaque(true);
        txttenSP.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel giaSP = new JLabel("Giá SP");
        giaSP.setBounds(40, 460, 80, 40);
        giaSP.setFont(font);
        JLabel txtgiaSP = new JLabel();
        txtgiaSP.setBounds(110, 465, 260, 30);
        txtgiaSP.setOpaque(true);
        txtgiaSP.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel slSP = new JLabel("Số Lượng");
        slSP.setBounds(40, 510, 80, 40);
        slSP.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        JLabel txtslSP = new JLabel();
        txtslSP.setBounds(110, 515, 260, 30);
        txtslSP.setOpaque(true);
        txtslSP.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton xacnhan = new JButton();
        xacnhan.setFocusable(false);
        xacnhan.setBounds(40, 580, 150, 45);
        xacnhan.setBorder(BorderFactory.createEmptyBorder());
        xacnhan.setBackground(new java.awt.Color(255, 215, 0));
        xacnhan.setLayout(null);
        xacnhan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (BanHangGUI.txtmaSPchon1 != null) {
                   
                    BanHangGUI.txtmaSPchon1.setText(txtmaSP.getText());
                    BanHangGUI.txttenSP.setText(txttenSP.getText());
                    BanHangGUI.txtgiaSP.setText(txtgiaSP.getText());
                    java.awt.Image newImage;
                    try {
                        newImage = new ImageIcon("image/" + imageSP).getImage().getScaledInstance(330, 330, 200);
                    } catch (NullPointerException E) {
                        newImage = new ImageIcon().getImage().getScaledInstance(330, 330, 200);
                    }
                    image.setIcon(new ImageIcon(newImage));
                }
                if (NhapHangGUI.txtmaSPchon2 != null) {
                    NhapHangGUI.txtmaSPchon2.setText(txtmaSP.getText());
                }
                dispose();
            }
        });
        JLabel txtxacnhan = new JLabel("Xác Nhận");
        txtxacnhan.setBounds(48, 3, 100, 40);
        txtxacnhan.setFont(new Font("Tahoma", 1, 18));
        txtxacnhan.setForeground(Color.white);
        JLabel iconxacnhan = new JLabel(new ImageIcon("image/confirm.png"));
        iconxacnhan.setBounds(15, 10, 24, 24);
        xacnhan.add(txtxacnhan);
        xacnhan.add(iconxacnhan);
        JButton huy = new JButton();
        huy.setFocusable(false);
        huy.setBounds(220, 580, 150, 45);
        huy.setBorder(BorderFactory.createEmptyBorder());
        huy.setBackground(new java.awt.Color(220, 20, 60));
        huy.setLayout(null);
        JLabel txthuy = new JLabel("Quay Lại");
        txthuy.setBounds(54, 3, 100, 40);
        txthuy.setForeground(Color.white);
        txthuy.setFont(new Font("Tahoma", 1, 18));
        JLabel iconhuy = new JLabel(new ImageIcon("image/back.png"));
        iconhuy.setBounds(16, 11, 24, 24);
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
        contetLeft.add(img);
        contetLeft.add(maSP);
        contetLeft.add(txtmaSP);
        contetLeft.add(tenSP);
        contetLeft.add(txttenSP);
        contetLeft.add(giaSP);
        contetLeft.add(txtgiaSP);
        contetLeft.add(slSP);
        contetLeft.add(txtslSP);
        contetLeft.add(xacnhan);
        contetLeft.add(huy);

        JPanel contentRight = new JPanel();
        contentRight.setLayout(null);
        contentRight.setBackground(Color.white);

        JLabel title2 = new JLabel("Danh Sách Sản Phẩm");
        title2.setBounds(210, 20, 300, 50);
        title2.setFont(new Font("Tahoma", 1, 27));

        JPanel headerTable = new JPanel();
        headerTable.setLayout(null);
        headerTable.setBackground(Color.red);
        headerTable.setBounds(0, 150, 710, 40);
        JLabel colmaSP = new JLabel("Mã SP");
        colmaSP.setFont(new Font("Tahoma", 1, 17));
        colmaSP.setBounds(0, 5, 60, 30);
        colmaSP.setForeground(Color.white);
        JLabel coltenSP = new JLabel("Tên Sản Phẩm");
        coltenSP.setFont(new Font("Tahoma", 1, 17));
        coltenSP.setBounds(83, 5, 150, 30);
        coltenSP.setForeground(Color.white);
        JLabel colslSP = new JLabel("Số Lượng");
        colslSP.setFont(new Font("Tahoma", 1, 17));
        colslSP.setBounds(285, 5, 100, 30);
        colslSP.setForeground(Color.white);
        JLabel colgiaSP = new JLabel("Đơn Giá");
        colgiaSP.setFont(new Font("Tahoma", 1, 17));
        colgiaSP.setBounds(390, 5, 100, 30);
        colgiaSP.setForeground(Color.white);
        JLabel colloaiSP = new JLabel("Loại SP");
        colloaiSP.setFont(new Font("Tahoma", 1, 17));
        colloaiSP.setBounds(495, 5, 80, 30);
        colloaiSP.setForeground(Color.white);
        JLabel coldvt = new JLabel("Đơn Vị Tính");
        coldvt.setFont(new Font("Tahoma", 1, 17));
        coldvt.setBounds(600, 5, 110, 30);
        coldvt.setForeground(Color.white);
        headerTable.add(colmaSP);
        headerTable.add(coltenSP);
        headerTable.add(colslSP);
        headerTable.add(colgiaSP);
        headerTable.add(colloaiSP);
        headerTable.add(coldvt);
        JLabel searchtenSP = new JLabel("Tên SP");
        searchtenSP.setFont(font);
        searchtenSP.setBounds(0, 80, 60, 40);
        JTextField txtsearchtenSP = new JTextField();
        txtsearchtenSP.setBounds(70, 83, 180, 35);
        JLabel searchloaiSP = new JLabel("Loại SP");
        searchloaiSP.setFont(font);
        searchloaiSP.setBounds(290, 80, 60, 40);
        String[] LoaiSearch = {"Tất Cả", "Thức Ăn", "Nước", "Vệ Sinh", "Gia Vị", "Đồ Dùng"};
        txtsearchloai = new JComboBox(LoaiSearch);
        txtsearchloai.setBounds(360, 83, 90, 35);
        txtsearchloai.setFocusable(false);
        txtsearchloai.setBackground(Color.white);
        JLabel searchDVT = new JLabel("ĐVT");
        searchDVT.setFont(font);
        searchDVT.setBounds(495, 80, 60, 40);
        String[] DVT = {"Tất Cả", "Lon", "Hộp", "Chai", "Gói", "Cái", "Tuýp"};
        txtDVT = new JComboBox(DVT);
        txtDVT.setBounds(540, 83, 90, 35);
        txtDVT.setFocusable(false);
        txtDVT.setFont(new Font("Segoe UI", 2, 17));
        txtDVT.setBackground(Color.white);
        JLabel iconsearch = new JLabel(new ImageIcon("image/search1.png"));
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
                String s1 = txtsearchtenSP.getText();
                String s2 = (String) txtsearchloai.getItemAt(txtsearchloai.getSelectedIndex());
                String s3 = (String) txtDVT.getItemAt(txtDVT.getSelectedIndex());
                ArrayList<ProductDTO> temp = spBUS.getList();
                if (s1.equals("") == false) {
                    temp = spBUS.search(s1);
                }
                if (s2.equals("Tất Cả") == false) {
                    temp = spBUS.SearchLoai1(temp, s2);
                }
                if (s3.equals("Tất Cả") == false) {
                    temp = spBUS.SearchDVT(temp, s3);
                }
                outModel(model, temp);
            }
        });

        JPanel panelTable = new JPanel();
        panelTable.setBackground(Color.white);
        panelTable.setBounds(0, 190, 710, 450);
        panelTable.setLayout(null);
        table.setBounds(0, 0, 710, 450);
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
                ArrayList<ProductDTO> dssp = spBUS.getList();
                imageSP = dssp.get(i).image;
                txtmaSP.setText(table.getModel().getValueAt(i, 0).toString());
                txttenSP.setText(table.getModel().getValueAt(i, 1).toString());
                txtgiaSP.setText(table.getModel().getValueAt(i, 3).toString());
                txtslSP.setText(table.getModel().getValueAt(i, 2).toString());

                java.awt.Image newImage;
                try {
                    newImage = new ImageIcon("image/" + imageSP).getImage().getScaledInstance(250, 240, 200);
                } catch (NullPointerException E) {
                    newImage = new ImageIcon("image/avatar.png").getImage().getScaledInstance(250, 240, 200);
                }
                img.setIcon(new ImageIcon(newImage));
            }
        });
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -5, 710, 450);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 100));
        panelTable.add(scroll);

        contentRight.add(title2);
        contentRight.add(searchtenSP);
        contentRight.add(txtsearchtenSP);
        contentRight.add(searchloaiSP);
        contentRight.add(txtsearchloai);
        contentRight.add(searchDVT);
        contentRight.add(txtDVT);
        contentRight.add(iconsearch);
        contentRight.add(headerTable);
        contentRight.add(panelTable);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(contetLeft, BorderLayout.WEST);
        content.add(contentRight, BorderLayout.CENTER);

        add(title, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);

        setVisible(true);
    }

    public void loadSP() throws ClassNotFoundException, SQLException {
        if (spBUS.getList() == null) {
            spBUS.listSP();
        }
        ArrayList<ProductDTO> sp = new ArrayList<>();
        sp = spBUS.getList();
        outModel(model, sp);
    }

    public void outModel(DefaultTableModel model, ArrayList<ProductDTO> sp) {
        Vector header = new Vector();
        header.add("");
        header.add("");
        header.add("");
        header.add("");
        header.add("");
        header.add("");
        model = new DefaultTableModel(header, 0);
        for (ProductDTO pro : sp) {
            Vector row = new Vector();
            row.add(pro.maSP);
            row.add(pro.tenSP);
            row.add(pro.slSP);
            row.add(pro.giaSP);
            row.add(pro.loaiSP);
            row.add(pro.donviSP);
            model.addRow(row);
        }
        table.setModel(model);
        TableColumnModel col = table.getColumnModel();
        col.getColumn(0).setPreferredWidth(80);
        col.getColumn(1).setPreferredWidth(200);
        col.getColumn(2).setPreferredWidth(100);
        col.getColumn(3).setPreferredWidth(100);
        col.getColumn(4).setPreferredWidth(100);
        col.getColumn(5).setPreferredWidth(100);
    }

}
