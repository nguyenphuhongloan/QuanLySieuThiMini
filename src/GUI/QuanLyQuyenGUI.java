package GUI;

import BUS.*;
import DAO.CategoryDAO;
import DTO.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author Loan (^._.^)ﾉ
 */
public class QuanLyQuyenGUI extends JPanel implements ActionListener {
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JPanel content;
    JTextField txtQuyen;
    Font font = new Font("Segoe UI", 1, 17);
    JTextField search;
    ArrayList<RoleDTO> listRole;
    CategoryBUS busCategory = new CategoryBUS();
    RoleBUS busRole = new RoleBUS();
    ArrayList<CategoryDTO> listDM;
    Role_CategoryBUS roleCategoryBUS = new Role_CategoryBUS();
    ArrayList<JCheckBox> listCB = new ArrayList<>();
    JButton them, sua, xoa;

    QuanLyQuyenGUI() {
        init();
    }

    public void init() {
        setBounds(0, 0, 1150, 800);
        setLayout(null);
        setBackground(Color.white);
        Font font = new Font("Segoe UI", 1, 17);
        Font font1 = new Font("Tahoma", 1, 17);

        JLabel title = new JLabel("QUẢN LÝ QUYỀN");
        title.setFont(new Font("Tahoma", 1, 40));
        title.setForeground(Color.red);
        title.setBounds(500, 0, 800, 100);

        JPanel left = new JPanel();
        left.setBounds(0, 130, 620, 800);
        left.setBackground(Color.WHITE);
        left.setLayout(null);

        JLabel lbQuyen = new JLabel("Tên Quyền");
        lbQuyen.setFont(font);
        lbQuyen.setBounds(50, 20, 120, 40);
        txtQuyen = new JTextField();
        txtQuyen.setBounds(140, 20, 180, 40);
        left.add(lbQuyen);
        left.add(txtQuyen);

        ImageIcon icon11 = new ImageIcon("image/search.png");
        JLabel iconsearch = new JLabel(icon11);
        iconsearch.setBounds(185, 0, 40, 40);
        search = new JTextField();
        search.setBounds(330, 20, 230, 40);
        search.add(iconsearch);

        iconsearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String s = search.getText();
                listRole = busRole.search(s);
                tbdsQuyen(listRole);
                cleanView();

            }
        });


        left.add(search);

        content = new JPanel();
        content.setBounds(30, 70, 550, 350);
        //content.setPreferredSize(new Dimension(500,700));
        content.setBackground(Color.white);
        content.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 10));
        left.add(content);

        them = new JButton();
        them.setBounds(60, 440, 150, 50);
        them.setLayout(null);
        them.setFocusable(false);
        them.setBackground(new java.awt.Color(255, 215, 0));
        them.setBorder(BorderFactory.createEmptyBorder());

        JLabel add = new JLabel("THÊM");
        add.setForeground(Color.white);
        add.setBounds(60, 10, 100, 30);
        add.setFont(new Font(Font.SERIF, 1, 27));
        ImageIcon icon8 = new ImageIcon("image/plus.png");
        JLabel iconadd = new JLabel(icon8);
        iconadd.setBounds(10, 5, 40, 40);
        them.add(add);
        them.add(iconadd);
        them.addActionListener(this);

        sua = new JButton();
        sua.setBounds(230, 440, 150, 50);
        sua.setLayout(null);
        sua.setFocusable(false);
        sua.setBackground(new java.awt.Color(30,144,255));
        sua.setBorder(BorderFactory.createEmptyBorder());

        JLabel edit = new JLabel("SỬA");
        edit.setForeground(Color.white);
        edit.setBounds(60, 10, 100, 30);
        edit.setFont(new Font(Font.SERIF, 1, 27));
        ImageIcon icon9 = new ImageIcon("image/fix.png");
        JLabel iconedit = new JLabel(icon9);
        iconedit.setBounds(10, 5, 40, 40);
        sua.add(edit);
        sua.add(iconedit);
        sua.addActionListener(this);

        xoa = new JButton();
        xoa.setBounds(400, 440, 150, 50);
        xoa.setLayout(null);
        xoa.setFocusable(false);
        xoa.setBackground(new java.awt.Color(220,20,60));
        xoa.setBorder(BorderFactory.createEmptyBorder());

        JLabel delete = new JLabel("XÓA");
        delete.setForeground(Color.white);
        delete.setBounds(60, 10, 100, 30);
        delete.setFont(new Font(Font.SERIF, 1, 27));
        ImageIcon icon10 = new ImageIcon("image/del.png");
        JLabel icondelete = new JLabel(icon10);
        icondelete.setBounds(10, 5, 40, 40);
        xoa.add(delete);
        xoa.add(icondelete);
        xoa.addActionListener(this);

        left.add(them);
        left.add(sua);
        left.add(xoa);

        JPanel HeaderTable = new JPanel();
        HeaderTable.setBounds(0, 0, 500, 40);
        HeaderTable.setBackground(Color.red);
        HeaderTable.setLayout(null);
        JLabel colmaSP = new JLabel("Mã Quyền");
        colmaSP.setForeground(Color.white);
        colmaSP.setBounds(0, 0, 100, 40);
        colmaSP.setFont(font);
        HeaderTable.add(colmaSP);
        JLabel coltenSP = new JLabel("Tên Quyền");
        coltenSP.setForeground(Color.white);
        coltenSP.setBounds(100, 0, 120, 40);
        coltenSP.setFont(font);
        HeaderTable.add(coltenSP);
        JLabel colsoluong = new JLabel("Mã Danh Mục Thuộc Quyền");
        colsoluong.setForeground(Color.white);
        colsoluong.setBounds(220, 0, 280, 40);
        colsoluong.setFont(font);
        HeaderTable.add(colsoluong);

        JPanel centerTable = new JPanel();
        centerTable.setBounds(0, 40, 505, 500);
        centerTable.setLayout(null);
        centerTable.setBackground(Color.white);
        table.setBounds(0, 0, 505, 500);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table.setRowHeight(60);
        table.setShowGrid(false);
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(true);

        Vector header = new Vector();
        header.add("");
        header.add("");
        header.add("");
        model = new DefaultTableModel(header, 0);


        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, -5, 505, 500);
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5, 100));
        centerTable.add(scroll);


        JPanel right = new JPanel();
        right.setBounds(620, 130, 500, 600);
        right.setBackground(Color.white);
        right.setLayout(null);
        right.add(HeaderTable);
        right.add(centerTable);


        add(title);
        add(left);
        add(right);
        listRole = busRole.getList();
        try {
            danhsachDM();
            tbdsQuyen(busRole.getList());

        } catch (Exception e) {
            e.printStackTrace();
        }
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                display();
            }
        });

        TableColumnModel col = table.getColumnModel();
        col.getColumn(0).setPreferredWidth(100);
        col.getColumn(1).setPreferredWidth(120);
        col.getColumn(2).setPreferredWidth(280);
    }

    public void danhsachDM() {
        ArrayList<JCheckBox> cbQuyen = new ArrayList<>();
        listDM = busCategory.getList();
        for (CategoryDTO dm : listDM) {
            boolean selected;
            JCheckBox cb = new JCheckBox(dm.getMaDM() + ". " + dm.getTenDM());
            cb.setPreferredSize(new Dimension(220, 50));
            cb.setFont(font);
            cb.setBackground(Color.white);
            listCB.add(cb);
            content.add(cb);
        }
    }

    public void tbdsQuyen(ArrayList<RoleDTO> listRole) {
        model.setRowCount(0);
        for (RoleDTO r : listRole) {

            StringBuilder maDM = new StringBuilder();
            listDM = roleCategoryBUS.getListCategoryOfRole(r);

            for (CategoryDTO item : listDM) {
                maDM.append(item.getMaDM() + ", ");
            }
            if (maDM.length()!=0)
                maDM.delete(maDM.length() - 2, maDM.length() - 1);

            Vector row = new Vector();
            row.add(r.getMaQuyen());
            row.add(r.getTenQuyen());
            row.add(maDM);
            model.addRow(row);
        }
        table.setModel(model);

    }

    public void display() {
        int i = table.getSelectedRow();
        if (i != -1) {
            txtQuyen.setText(table.getModel().getValueAt(i, 1).toString());
            for (RoleDTO r : listRole) {
                if (r.getMaQuyen() == Integer.parseInt(model.getValueAt(i, 0).toString())) {
                    listDM = roleCategoryBUS.getListCategoryOfRole(r);
                    break;
                }
            }
            for (JCheckBox cb : listCB) {
                cb.setSelected(false);
            }
            for (CategoryDTO dm : listDM) {
                listCB.get(dm.getMaDM() - 1).setSelected(true);
            }
        }
    }

    public boolean checkListCheckboxSelected(){
        boolean checkcb = false;
        for (JCheckBox cb : listCB) {
            if (cb.isSelected() == true) {
                checkcb = true;
                break;
            }
        }
        if (checkcb == false) {
            new ThongBaoGUI("Vui lòng chọn ít nhất 1 danh mục");
        }
        return checkcb;
    }

    public void cleanView(){
        txtQuyen.setText("");
        for (JCheckBox cb : listCB) {
            cb.setSelected(false);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == them) {
            if (txtQuyen.getText().isEmpty()) {
                new ThongBaoGUI("Vui lòng nhập tên quyền");
                return;
            }
            if(!checkListCheckboxSelected())
                return;
            RoleDTO role = new RoleDTO();
            role.setTenQuyen(txtQuyen.getText());
            role.setMaQuyen(busRole.add(role));
            for (int i = 0; i < listCB.size(); i++) {
                if (listCB.get(i).isSelected()) {
                    Role_CategoryDTO rc = new Role_CategoryDTO();
                    rc.setMaQuyen(role.getMaQuyen());
                    rc.setMaDM(i + 1);
                    roleCategoryBUS.add(rc);
                }
            }
            tbdsQuyen(busRole.getList());
            cleanView();
        }
        if (e.getSource() == sua) {
            int i = table.getSelectedRow();
            if(i==-1){
                new ThongBaoGUI("Vui lòng chọn hàng cần sửa");
                return;
            }
            if(txtQuyen.getText().isEmpty()){
                new ThongBaoGUI("Vui lòng nhập tên quyền");
                return;
            }
            if(!checkListCheckboxSelected())
                return;
            RoleDTO newRole = new RoleDTO();
            newRole.setMaQuyen(Integer.parseInt(model.getValueAt(i,0).toString()));
            newRole.setTenQuyen(txtQuyen.getText());
            busRole.update(newRole);
            roleCategoryBUS.delete(newRole.getMaQuyen());
            for (int j = 0; j < listCB.size(); j++) {
                if (listCB.get(j).isSelected()) {
                    Role_CategoryDTO rc = new Role_CategoryDTO();
                    rc.setMaQuyen(newRole.getMaQuyen());
                    rc.setMaDM(j + 1);
                    roleCategoryBUS.add(rc);
                }
            }
            tbdsQuyen(busRole.getList());
            cleanView();
        }
        if (e.getSource() == xoa) {
            int i = table.getSelectedRow();
            if(i==0 || i == 1){
                new ThongBaoGUI("Không thể xóa quyền mặc định");
                return;
            }
            if(i==-1){
                new ThongBaoGUI("Chọn hàng cần xóa");
                return;
            }

            int idRole = Integer.parseInt(model.getValueAt(i,0 ).toString());
            NhanVienBUS nvBUS = new NhanVienBUS();
            ArrayList<StaffDTO> listnv = new ArrayList<>();
            try {
                nvBUS.listNV();
                listnv = nvBUS.getList();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            for (StaffDTO nv : listnv) {

                if (nv.getRole() == idRole) {
                    new ThongBaoGUI("Không thể xóa quyền này vì có nhân viên thuộc quyền này");
                    return;
                }
            }
            busRole.delete(idRole);
            tbdsQuyen(busRole.getList());
            cleanView();
        }
    }

}
