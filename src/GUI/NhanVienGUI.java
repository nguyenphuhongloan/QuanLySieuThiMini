package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.NhanVienBUS;
import DTO.CheckInput;
import DTO.ProductDTO;
import DTO.StaffDTO;

public class NhanVienGUI extends JPanel {

    NhanVienGUI() throws ClassNotFoundException, SQLException {
        init();
    }
    JTextField txttenNV;
    JTextField txthoNV;
    JTextField txtdiachi;
    JTextField txtsdt;
    JTextField txttaikhoan;
    JTextField txtpass;
    JComboBox cmbPhai, cmbRole;
    JComboBox cmbsearchPhai;
    JTextField txtnamsinh;
    JTextField txttenNVsearch, Searchns;
    String ID;
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    NhanVienBUS nvBUS = new NhanVienBUS();

    public void init() throws ClassNotFoundException, SQLException {
        setBounds(0, 0, 1150, 800);
        setLayout(new BorderLayout());
        Font font = new Font("Segoe UI", 1, 17);
        list();

        JPanel marginLeftContentRight = new JPanel();
        marginLeftContentRight.setPreferredSize(new Dimension(60, 0));

        JPanel contentRightHeader1 = new JPanel();
        contentRightHeader1.setPreferredSize(new Dimension(270, 0));
        contentRightHeader1.setLayout(null);
        JLabel img = new JLabel();
        img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        img.setOpaque(true);
        img.setBounds(0, 20, 270, 300);
        img.setBackground(Color.white);
        contentRightHeader1.add(img);

        JPanel contentRightHeader2 = new JPanel();
        contentRightHeader2.setLayout(null);
        JLabel hoNV = new JLabel("Họ Tên");
        hoNV.setBounds(40, 20, 150, 30);
        hoNV.setFont(font);
        txthoNV = new JTextField();
        txthoNV.setBounds(190, 20, 130, 30);
        txttenNV = new JTextField();
        txttenNV.setBounds(340, 20, 130, 30);
        JLabel diachi = new JLabel("Địa Chỉ");
        diachi.setBounds(40, 65, 150, 30);
        diachi.setFont(font);
        txtdiachi = new JTextField();
        txtdiachi.setBounds(190, 65, 280, 30);
        JLabel sdt = new JLabel("Số Điện Thoại");
        sdt.setBounds(40, 110, 150, 30);
        sdt.setFont(font);
        txtsdt = new JTextField();
        txtsdt.setBounds(190, 110, 280, 30);
        JLabel taikhoan = new JLabel("Tên Tài Khoản");
        taikhoan.setBounds(40, 150, 150, 40);
        taikhoan.setFont(font);
        txttaikhoan = new JTextField();
        txttaikhoan.setBounds(190, 155, 280, 30);
        JLabel pass = new JLabel("Mật Khẩu");
        pass.setBounds(40, 200, 150, 30);
        pass.setFont(font);
        txtpass = new JTextField();
        txtpass.setBounds(190, 200, 280, 30);
        JLabel phai = new JLabel("Giới Tính");
        phai.setBounds(40, 245, 100, 30);
        phai.setFont(font);
        String[] selectPhai = {"Nam", "Nữ"};
        cmbPhai = new JComboBox(selectPhai);
        cmbPhai.setBounds(140, 245, 80, 30);
        cmbPhai.setFont(new Font("Tahoma", 2, 17));
        cmbPhai.setFocusable(false);
        cmbPhai.setBackground(Color.white);
        JLabel namsinh = new JLabel("Năm Sinh");
        namsinh.setBounds(250, 245, 150, 30);
        namsinh.setFont(font);
        txtnamsinh = new JTextField();
        txtnamsinh.setBounds(350, 245, 120, 30);
        JLabel role = new JLabel("Quyền Tài Khoản");
        role.setBounds(40, 290, 150, 30);
        role.setFont(font);
        ArrayList<String> dsRole = nvBUS.getRole();
        String[] ds = new String[dsRole.size()];
        for (int i = 0; i < dsRole.size(); i++) {
            ds[i] = dsRole.get(i);
        }
        cmbRole = new JComboBox(ds);
        cmbRole.setBounds(190, 290, 170, 30);
        cmbRole.setFont(new Font("Tahoma", 2, 17));
        cmbRole.setFocusable(false);
        cmbRole.setBackground(Color.white);
        contentRightHeader2.add(hoNV);
        contentRightHeader2.add(txthoNV);
        contentRightHeader2.add(txttenNV);
        contentRightHeader2.add(diachi);
        contentRightHeader2.add(txtdiachi);
        contentRightHeader2.add(sdt);
        contentRightHeader2.add(txtsdt);
        contentRightHeader2.add(taikhoan);
        contentRightHeader2.add(txttaikhoan);
        contentRightHeader2.add(pass);
        contentRightHeader2.add(txtpass);
        contentRightHeader2.add(phai);
        contentRightHeader2.add(cmbPhai);
        contentRightHeader2.add(namsinh);
        contentRightHeader2.add(txtnamsinh);
        contentRightHeader2.add(role);
        contentRightHeader2.add(cmbRole);

        JPanel contentRightHeader3 = new JPanel();
        contentRightHeader3.setPreferredSize(new Dimension(250, 0));
        contentRightHeader3.setLayout(null);
        JButton them = new JButton();
        them.setBounds(20, 20, 180, 50);
        them.setLayout(null);
        them.setFocusable(false);
        them.setBackground(new java.awt.Color(255, 215, 0));
        them.setBorder(BorderFactory.createEmptyBorder());
        them.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                try {
                    boolean check = true;
                    if (txthoNV.getText().isEmpty() || txttenNV.getText().isEmpty() || txttaikhoan.getText().isEmpty() || txtpass.getText().isEmpty()
                            || txtdiachi.getText().isEmpty() || txtsdt.getText().isEmpty() || txtnamsinh.getText().isEmpty()) {
                        check = false;
                        new ThongBaoGUI("   Vui lòng nhập đầy đủ thông tin");
                    }
                    if (check) {
                        if (CheckInput.checkString(txthoNV.getText()) == false || CheckInput.checkString(txttenNV.getText()) == false || CheckInput.checkString(txtdiachi.getText()) == false
                                || CheckInput.checkString(txttaikhoan.getText()) == false || CheckInput.checkString(txtpass.getText()) == false) {
                            check = false;
                            new ThongBaoGUI("Không được nhập ký tự đặc biệt");
                        }
                    }
                    if (check) {
                        if (CheckInput.checkPhoneNumber(txtsdt.getText()) == false) {
                            check = false;
                            new ThongBaoGUI("       Số điện thoại không hợp lệ");
                        }
                    }
                    if (check) {
                        if (nvBUS.check(txttaikhoan.getText()) == false) {
                            check = false;
                            new ThongBaoGUI("Tên tài khoản đã có người sử dụng");
                        }
                    }
                    if (check) {
                        if (CheckInput.checkBorn(txtnamsinh.getText()) == false) {
                            check = false;
                            new ThongBaoGUI("    Năm sinh không hợp lệ");
                        }
                    }
                    if (check) {
                        StaffDTO nv = new StaffDTO();
                        nv.hoNV = txthoNV.getText();
                        nv.tenNV = txttenNV.getText();
                        nv.tenTK = txttaikhoan.getText();
                        nv.matkhau = txtpass.getText();
                        nv.diachi = txtdiachi.getText();
                        nv.phone = txtsdt.getText();
                        nv.phai = (String) cmbPhai.getItemAt(cmbPhai.getSelectedIndex());
                        nv.namsinh = txtnamsinh.getText();
                        String role = (String) cmbRole.getItemAt(cmbRole.getSelectedIndex());
                        nv.role = nvBUS.getIdRole(role);
                        nvBUS.add(nv);
                        outModel(model, nvBUS.getList());
                        clearData();
                        new ThongBaoGUI("Thêm Tài Khoản Thành Công!");
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        });
        JLabel addsp = new JLabel("THÊM");
        addsp.setForeground(Color.white);
        addsp.setBounds(70, 10, 100, 30);
        addsp.setFont(new Font(Font.SERIF, 1, 27));
        ImageIcon icon8 = new ImageIcon("image/plus.png");
        JLabel iconadd = new JLabel(icon8);
        iconadd.setBounds(20, 5, 40, 40);

        JButton sua = new JButton();
        sua.setBounds(20, 80, 180, 50);
        sua.setLayout(null);
        sua.setFocusable(false);
        sua.setBackground(new java.awt.Color(30, 144, 255));
        sua.setBorder(BorderFactory.createEmptyBorder());
        sua.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int i = table.getSelectedRow();
                if (i != -1) {
                    try {
                        boolean check = true;
                        if (txthoNV.getText().isEmpty() || txttenNV.getText().isEmpty() || txtpass.getText().isEmpty()
                                || txtdiachi.getText().isEmpty() || txtsdt.getText().isEmpty() || txtnamsinh.getText().isEmpty()) {
                            check = false;
                            new ThongBaoGUI("   Vui lòng nhập đầy đủ thông tin");
                        }
                        if (check) {
                            if (CheckInput.checkString(txthoNV.getText()) == false || CheckInput.checkString(txttenNV.getText()) == false || CheckInput.checkString(txtdiachi.getText()) == false
                                    || CheckInput.checkString(txtpass.getText()) == false) {
                                check = false;
                                new ThongBaoGUI("Không được nhập ký tự đặc biệt");
                            }
                        }
                        if (check) {
                            if (CheckInput.checkPhoneNumber(txtsdt.getText()) == false) {
                                check = false;
                                new ThongBaoGUI("       Số điện thoại không hợp lệ");
                            }
                        }
                        if (check) {
                            if (CheckInput.checkBorn(txtnamsinh.getText()) == false) {
                                check = false;
                                new ThongBaoGUI("    Năm sinh không hợp lệ");
                            }
                        }
                        if (check) {
                            txttenNVsearch.setText("");
                            Searchns.setText("");
                            cmbsearchPhai.setSelectedIndex(0);
                            ArrayList<StaffDTO> dsnv = nvBUS.getList();
                            StaffDTO nv = new StaffDTO();
                            nv.maNV = Integer.parseInt(ID);
                            nv.hoNV = txthoNV.getText();
                            nv.tenNV = txttenNV.getText();
                            nv.tenTK = txttaikhoan.getText();
                            nv.matkhau = txtpass.getText();
                            nv.diachi = txtdiachi.getText();
                            nv.phai = (String) cmbPhai.getItemAt(cmbPhai.getSelectedIndex());
                            nv.phone = txtsdt.getText();
                            nv.namsinh = txtnamsinh.getText();
                            String role = (String) cmbRole.getItemAt(cmbRole.getSelectedIndex());
                            nv.role = nvBUS.getIdRole(role);
                            nvBUS.set(nv);
                            outModel(model, nvBUS.getList());
                            new ThongBaoGUI("Sửa Tài Khoản Thành Công!");
                        }
                    } catch (Exception a) {
                        // TODO: handle exception
                        System.out.print("fail");
                    }
                }
            }
        });

        JLabel suasp = new JLabel("SỬA");
        suasp.setForeground(Color.white);
        suasp.setBounds(85, 10, 100, 30);
        suasp.setFont(new Font(Font.SERIF, 1, 27));
        ImageIcon icon9 = new ImageIcon("image/fix.png");
        JLabel iconfix = new JLabel(icon9);
        iconfix.setBounds(20, 5, 40, 40);

        JButton xoa = new JButton();
        xoa.setBounds(20, 140, 180, 50);
        xoa.setLayout(null);
        xoa.setFocusable(false);
        xoa.setBackground(new java.awt.Color(220, 20, 60));
        xoa.setBorder(BorderFactory.createEmptyBorder());
        xoa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int i = table.getSelectedRow();
                if (i != -1) {
                    try {
                        txttenNVsearch.setText("");
                        Searchns.setText("");
                        cmbsearchPhai.setSelectedIndex(0);
                        ArrayList<StaffDTO> dsnv = nvBUS.getList();
                        nvBUS.delete(Integer.parseInt(ID));
                        outModel(model, nvBUS.getList());
                        clearData();
                        new ThongBaoGUI("Xóa Tài Khoản Thành Công!");
                    } catch (Exception e2) {
                        // TODO: handle exception
                    }
                }
            }
        });

        JLabel xoasp = new JLabel("XÓA");
        xoasp.setForeground(Color.white);
        xoasp.setBounds(85, 10, 100, 30);
        xoasp.setFont(new Font(Font.SERIF, 1, 27));
        ImageIcon icon10 = new ImageIcon("image/del.png");
        JLabel icondel = new JLabel(icon10);
        icondel.setBounds(20, 5, 40, 40);

        JButton export = new JButton();
        export.setBounds(20, 200, 180, 50);
        export.setLayout(null);
        export.setFocusable(false);
        export.setBackground(new java.awt.Color(128, 0, 128));
        export.setBorder(BorderFactory.createEmptyBorder());
        export.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    JFileChooser jFileChooser = new JFileChooser();
                    jFileChooser.showOpenDialog(null);
                    File saveFile = jFileChooser.getSelectedFile();

                    if (saveFile != null) {
                        saveFile = new File(saveFile.toString() + ".xlsx");
                        Workbook wb = new XSSFWorkbook();
                        Sheet sheet = wb.createSheet("customer");

                        Row rowCol = sheet.createRow(0);
                        for (int i = 0; i < table.getColumnCount(); i++) {
                            Cell cell = rowCol.createCell(i);
                            cell.setCellValue(table.getColumnName(i));
                        }

                        for (int j = 0; j < table.getRowCount(); j++) {
                            Row row = sheet.createRow(j + 1);
                            for (int k = 0; k < table.getColumnCount(); k++) {
                                Cell cell = row.createCell(k);
                                if (table.getValueAt(j, k) != null) {
                                    cell.setCellValue(table.getValueAt(j, k).toString());
                                }
                            }
                        }
                        FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                        wb.write(out);
                        wb.close();
                        out.close();
                        openFile(saveFile.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Bạn đã hủy xuất file");
                    }
                } catch (FileNotFoundException e1) {
                    System.out.println(e1);
                } catch (IOException io) {
                    System.out.println(io);
                }
            }
        });
        JLabel txtexport = new JLabel("XUẤT");
        txtexport.setForeground(Color.white);
        txtexport.setBounds(85, 10, 100, 30);
        txtexport.setFont(new Font(Font.SERIF, 1, 27));
        JLabel iconexport = new JLabel(new ImageIcon("image/export.png"));
        iconexport.setBounds(20, 5, 40, 40);

        JButton importfile = new JButton();
        importfile.setBounds(20, 260, 180, 50);
        importfile.setLayout(null);
        importfile.setFocusable(false);
        importfile.setBackground(new java.awt.Color(0, 255, 127));
        importfile.setBorder(BorderFactory.createEmptyBorder());
        importfile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //String currentDirectoryPath="C:\\Users\\Authentic\\Desktop";
                DefaultTableModel importModel = (DefaultTableModel) table.getModel();

                FileInputStream excelFIS = null;
                BufferedInputStream excelBIS = null;
                XSSFWorkbook excelImportWorkbook = null;
                JFileChooser excelFileChooserImport = new JFileChooser();
                FileNameExtensionFilter excelFileNameExtensionFilter = new FileNameExtensionFilter("EXCEL FILE", "xls", "xlsx", "xslm");
                excelFileChooserImport.setFileFilter(excelFileNameExtensionFilter);
                int excelChooser = excelFileChooserImport.showOpenDialog(null);
                if (excelChooser == JFileChooser.APPROVE_OPTION) {
                    try {
                        File excelFile = excelFileChooserImport.getSelectedFile();
                        excelFIS = new FileInputStream(excelFile);
                        excelBIS = new BufferedInputStream(excelFIS);
                        excelImportWorkbook = new XSSFWorkbook(excelBIS);
                        XSSFSheet excelSheet = excelImportWorkbook.getSheetAt(0);
                        importModel.setRowCount(0);
                        for (int i = 1; i <= excelSheet.getLastRowNum(); i++) {
                            XSSFRow excelRow = excelSheet.getRow(i);
                            XSSFCell i1 = excelRow.getCell(0);
                            XSSFCell i2 = excelRow.getCell(1);
                            XSSFCell i3 = excelRow.getCell(2);
                            XSSFCell i4 = excelRow.getCell(3);
                            XSSFCell i5 = excelRow.getCell(4);
                            XSSFCell i6 = excelRow.getCell(5);
                            XSSFCell i7 = excelRow.getCell(6);
                            XSSFCell i8 = excelRow.getCell(7);
                            importModel.addRow(new Object[]{i1, i2, i3, i4, i5, i6, i7, i8});
                        }
                        new ThongBaoGUI("     Import File Excel Thành Công!");
                    } catch (Exception e2) {
                        // TODO: handle exception
                    }
                }
            }
        });

        JLabel txtimportfile = new JLabel("NHẬP");
        txtimportfile.setForeground(Color.white);
        txtimportfile.setBounds(85, 10, 100, 30);
        txtimportfile.setFont(new Font(Font.SERIF, 1, 27));
        JLabel iconimportfile = new JLabel(new ImageIcon("image/import.png"));
        iconimportfile.setBounds(20, 5, 40, 40);

        them.add(addsp);
        them.add(iconadd);
        sua.add(suasp);
        sua.add(iconfix);
        xoa.add(xoasp);
        xoa.add(icondel);
        export.add(txtexport);
        export.add(iconexport);
        importfile.add(txtimportfile);
        importfile.add(iconimportfile);
        contentRightHeader3.add(them);
        contentRightHeader3.add(sua);
        contentRightHeader3.add(xoa);
        contentRightHeader3.add(export);
        contentRightHeader3.add(importfile);

        JPanel contentRightHeader = new JPanel();
        contentRightHeader.setPreferredSize(new Dimension(0, 320));
        contentRightHeader.setLayout(new BorderLayout());
        contentRightHeader.add(contentRightHeader1, BorderLayout.WEST);
        contentRightHeader.add(contentRightHeader2, BorderLayout.CENTER);
        contentRightHeader.add(contentRightHeader3, BorderLayout.EAST);

        JPanel contentRightCenter = new JPanel();
        contentRightCenter.setLayout(null);
        JLabel sortTitle = new JLabel("------------------------------------------------------------- TÌM KIẾM NHÂN VIÊN -------------------------------------------------------------", JLabel.CENTER); // Mỗi bên 74 dấu ( - )
        sortTitle.setBounds(0, 30, 1050, 30);
        sortTitle.setFont(new Font("Tahoma", 0, 18));
        contentRightCenter.add(sortTitle);

        JPanel contentRightFooterSearch = new JPanel();
        contentRightFooterSearch.setPreferredSize(new Dimension(0, 80));
        contentRightFooterSearch.setLayout(null);
        JLabel tenSPsearch = new JLabel("Tên NV :");
        tenSPsearch.setFont(new Font(Font.SERIF, 0, 17));
        tenSPsearch.setBounds(0, 15, 80, 50);
        txttenNVsearch = new JTextField();
        txttenNVsearch.setBounds(80, 20, 200, 40);
        contentRightFooterSearch.add(tenSPsearch);
        contentRightFooterSearch.add(txttenNVsearch);
        JLabel ns = new JLabel("Năm Sinh :");
        ns.setFont(new Font(Font.SERIF, 0, 17));
        ns.setBounds(350, 15, 150, 50);
        Searchns = new JTextField();
        Searchns.setBounds(450, 20, 100, 40);
        contentRightFooterSearch.add(ns);
        contentRightFooterSearch.add(Searchns);
        JLabel gioitinh = new JLabel("Giới Tính :");
        gioitinh.setFont(new Font(Font.SERIF, 0, 17));
        gioitinh.setBounds(630, 15, 110, 50);
        String[] searchPhai = {"Tất cả", "Nam", "Nữ"};
        cmbsearchPhai = new JComboBox(searchPhai);
        cmbsearchPhai.setBounds(720, 20, 120, 40);
        cmbsearchPhai.setFont(new Font("Tahoma", 2, 17));
        cmbsearchPhai.setFocusable(false);
        cmbsearchPhai.setBackground(Color.white);
        JLabel searchNV = new JLabel(new ImageIcon("image/searchnv.png"));
        searchNV.addMouseListener(new MouseListener() {

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
                ArrayList<StaffDTO> temp = nvBUS.getList();
                String s1 = txttenNVsearch.getText();
                String s2 = Searchns.getText();
                String s3 = (String) cmbsearchPhai.getItemAt(cmbsearchPhai.getSelectedIndex());
                if (s1.equals("") == false) {
                    temp = nvBUS.search(s1);
                }
                if (s2.equals("") == false) {
                    temp = nvBUS.SearchNS(temp, s2);
                }
                if (s3.equals("Tất cả") == false) {
                    temp = nvBUS.SearchPhai(temp, s3);
                }
                outModel(model, temp);
            }
        });
        searchNV.setBounds(920, 25, 32, 32);
        contentRightFooterSearch.add(gioitinh);
        contentRightFooterSearch.add(cmbsearchPhai);
        contentRightFooterSearch.add(searchNV);

        JPanel contentRightFooterTableTop = new JPanel();
        contentRightFooterTableTop.setPreferredSize(new Dimension(0, 40));
        contentRightFooterTableTop.setBackground(Color.black);
        contentRightFooterTableTop.setLayout(null);
        JLabel colmaNV = new JLabel("Mã NV");
        colmaNV.setForeground(Color.white);
        colmaNV.setBounds(0, 0, 70, 40);
        colmaNV.setFont(font);
        contentRightFooterTableTop.add(colmaNV);
        JLabel coltenNV = new JLabel("Tên Nhân Viên");
        coltenNV.setForeground(Color.white);
        coltenNV.setBounds(75, 0, 160, 40);
        coltenNV.setFont(font);
        contentRightFooterTableTop.add(coltenNV);
        JLabel coltaikhoan = new JLabel("Tên Tài Khoản");
        coltaikhoan.setForeground(Color.white);
        coltaikhoan.setBounds(244, 0, 160, 40);
        coltaikhoan.setFont(font);
        contentRightFooterTableTop.add(coltaikhoan);
        JLabel colpass = new JLabel("Mật Khẩu");
        colpass.setForeground(Color.white);
        colpass.setBounds(416, 0, 160, 40);
        colpass.setFont(font);
        contentRightFooterTableTop.add(colpass);
        JLabel coldiachi = new JLabel("Địa Chỉ");
        coldiachi.setForeground(Color.white);
        coldiachi.setBounds(588, 0, 160, 40);
        coldiachi.setFont(font);
        contentRightFooterTableTop.add(coldiachi);
        JLabel colsdt = new JLabel("Phone");
        colsdt.setForeground(Color.white);
        colsdt.setBounds(760, 0, 110, 40);
        colsdt.setFont(font);
        contentRightFooterTableTop.add(colsdt);
        JLabel colphai = new JLabel("Phái");
        colphai.setForeground(Color.white);
        colphai.setBounds(873, 0, 60, 40);
        colphai.setFont(font);
        contentRightFooterTableTop.add(colphai);
        JLabel colnamsinh = new JLabel("Năm Sinh");
        colnamsinh.setForeground(Color.white);
        colnamsinh.setBounds(936, 0, 90, 40);
        colnamsinh.setFont(font);
        contentRightFooterTableTop.add(colnamsinh);

        JPanel contentRightFooterTableCenter = new JPanel();
        contentRightFooterTableCenter.setLayout(null);
        table.setBounds(0, 0, 1030, 260);
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
                ID = table.getModel().getValueAt(i, 0).toString();
                ArrayList<StaffDTO> dsnv = new ArrayList<>();
                dsnv = nvBUS.getList();
                int x;
                StaffDTO nv = new StaffDTO();
                for (StaffDTO item : dsnv) {
                    if (item.maNV == Integer.parseInt(table.getModel().getValueAt(i, 0).toString())) {
                        nv = item;
                        break;
                    }
                }
                txthoNV.setText(nv.hoNV);
                txttenNV.setText(nv.tenNV);
                //txttenNV.setText(table.getModel().getValueAt(i, 1).toString());
                txtdiachi.setText(table.getModel().getValueAt(i, 4).toString());
                txtsdt.setText(table.getModel().getValueAt(i, 5).toString());
                cmbPhai.setSelectedItem(table.getModel().getValueAt(i, 6).toString());
                txttaikhoan.setText(table.getModel().getValueAt(i, 2).toString());
                txtpass.setText(table.getModel().getValueAt(i, 3).toString());
                txtnamsinh.setText(table.getModel().getValueAt(i, 7).toString());
                int id = Integer.parseInt(table.getModel().getValueAt(i, 0).toString());
                try {
                    cmbRole.setSelectedItem(nvBUS.getNameRole(id));
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                String phai = table.getModel().getValueAt(i, 6).toString();
                java.awt.Image newImage;
                if (phai.equals("Nam")) {
                    newImage = new ImageIcon("image/male.png").getImage().getScaledInstance(260, 260, 200);
                } else {
                    newImage = new ImageIcon("image/female.png").getImage().getScaledInstance(260, 260, 200);
                }
                img.setIcon(new ImageIcon(newImage));
            }
        });

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -22, 1035, 260);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5, 100));

        JButton save = new JButton();
        save.setLayout(null);
        save.setBackground(Color.black);
        save.setFocusable(false);
        save.setBorder(BorderFactory.createEmptyBorder());
        save.setBounds(945, 243, 80, 25);
        JLabel iconsave = new JLabel(new ImageIcon("image/save.png"));
        iconsave.setBounds(7, 2, 20, 20);
        JLabel txtsave = new JLabel("Save");
        txtsave.setFont(new Font("Tahoma", 1, 15));
        txtsave.setForeground(Color.white);
        txtsave.setBounds(35, 2, 40, 20);
        save.add(iconsave);
        save.add(txtsave);
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    ArrayList<StaffDTO> temp = new ArrayList<>();
                    for (int i = 0; i < table.getRowCount(); i++) {
                        StaffDTO nv = new StaffDTO();
                        String fullname = table.getModel().getValueAt(i, 1).toString();
                        String[] name = fullname.split("\\s");
                        nv.hoNV = name[0];
                        nv.tenNV = "";
                        for (int j = 1; j < name.length; j++) {
                            nv.tenNV += name[j] + " ";
                        }
                        nv.tenTK = table.getModel().getValueAt(i, 2).toString();
                        nv.matkhau = table.getModel().getValueAt(i, 3).toString();
                        nv.diachi = table.getModel().getValueAt(i, 4).toString();
                        nv.phone = table.getModel().getValueAt(i, 5).toString();
                        nv.phai = table.getModel().getValueAt(i, 6).toString();
                        nv.namsinh = table.getModel().getValueAt(i, 7).toString();
                        temp.add(nv);
                    }
                    ArrayList<StaffDTO> dsnv = nvBUS.getList();
                    for (int i = 0; i < dsnv.size(); i++) {
                        temp.get(i).maNV = dsnv.get(i).maNV;
                    }
                    nvBUS.updateData(temp);
                    outModel(model, nvBUS.getList());
                    new ThongBaoGUI("Cập nhật dữ liệu thành công!");
                } catch (Exception e1) {
                    new ThongBaoGUI("Dữ liệu không hợp lệ! Vui lòng kiểm tra lại!");
                }
            }
        });

        contentRightFooterTableCenter.add(scroll);
        contentRightFooterTableCenter.add(save);

        JPanel contentRightFooterTable = new JPanel();
        contentRightFooterTable.setPreferredSize(new Dimension(0, 320));
        contentRightFooterTable.setLayout(new BorderLayout());
        contentRightFooterTable.add(contentRightFooterTableTop, BorderLayout.NORTH);
        contentRightFooterTable.add(contentRightFooterTableCenter, BorderLayout.CENTER);

        JPanel contentRightFooter = new JPanel();
        contentRightFooter.setPreferredSize(new Dimension(0, 400));
        contentRightFooter.setLayout(new BorderLayout());
        contentRightFooter.add(contentRightFooterSearch, BorderLayout.NORTH);
        contentRightFooter.add(contentRightFooterTable, BorderLayout.SOUTH);

        JPanel contentRight1 = new JPanel();
        contentRight1.setBackground(Color.lightGray);
        contentRight1.setLayout(new BorderLayout());
        contentRight1.add(contentRightHeader, BorderLayout.NORTH);
        contentRight1.add(contentRightCenter, BorderLayout.CENTER);
        contentRight1.add(contentRightFooter, BorderLayout.SOUTH);

        JPanel marginRightContentRight = new JPanel();
        marginRightContentRight.setPreferredSize(new Dimension(60, 0));

        add(marginLeftContentRight, BorderLayout.WEST);
        add(contentRight1, BorderLayout.CENTER);
        add(marginRightContentRight, BorderLayout.EAST);

    }

    public void clearData() {
        txthoNV.setText("");
        txttenNV.setText("");
        txtdiachi.setText("");
        txtnamsinh.setText("");
        txtpass.setText("");
        txttaikhoan.setText("");
        txtsdt.setText("");
    }

    public void list() {
        if (nvBUS.getList() == null)
			try {
            nvBUS.listNV();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<StaffDTO> nv = new ArrayList<>();
        nv = nvBUS.getList();
        outModel(model, nv);
    }

    public void outModel(DefaultTableModel model, ArrayList<StaffDTO> nv) {
        Vector header = new Vector();
        header.add("Mã nhân viên");
        header.add("Tên nhân viên");
        header.add("Tên tài khoản");
        header.add("Mật khẩu");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
        header.add("Giới tính");
        header.add("Năm sinh");
        model = new DefaultTableModel(header, 0);
        for (StaffDTO staff : nv) {
            Vector row = new Vector();
            row.add(staff.maNV);
            row.add(staff.hoNV + " " + staff.tenNV);
            row.add(staff.tenTK);
            row.add(staff.matkhau);
            row.add(staff.diachi);
            row.add(staff.phone);
            row.add(staff.phai);
            row.add(staff.namsinh);
            model.addRow(row);
        }
        table.setModel(model);
        TableColumnModel col = table.getColumnModel();
        col.getColumn(0).setPreferredWidth(40);
        col.getColumn(1).setPreferredWidth(140);
        col.getColumn(2).setPreferredWidth(140);
        col.getColumn(3).setPreferredWidth(140);
        col.getColumn(4).setPreferredWidth(140);
        col.getColumn(5).setPreferredWidth(80);
        col.getColumn(6).setPreferredWidth(30);
        col.getColumn(7).setPreferredWidth(60);
    }

    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
