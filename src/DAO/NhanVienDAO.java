package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ProductDTO;
import DTO.StaffDTO;

public class NhanVienDAO {

    private MySQLConnect mySQL = new MySQLConnect();

    public NhanVienDAO() {

    }

    public ArrayList<StaffDTO> list() throws SQLException {
        ArrayList<StaffDTO> nv = new ArrayList<>();
        String sql = "select * from staff";
        ResultSet rs = mySQL.executeQuery(sql);
        while (rs.next()) {
            StaffDTO staff = new StaffDTO();
            staff.maNV = rs.getInt(1);
            staff.hoNV = rs.getString(2);
            staff.tenNV = rs.getString(3);
            staff.tenTK = rs.getString(4);
            staff.matkhau = rs.getString(5);
            staff.diachi = rs.getString(6);
            staff.phone = rs.getString(7);
            staff.phai = rs.getString(8);
            staff.namsinh = rs.getString(9);
            staff.setRole(rs.getInt(10));
            staff.trangthai = rs.getInt(11);
            if (staff.getTrangthai() == 1) {
                nv.add(staff);
            }
        }
        rs.close();
        mySQL.disConnect();
        return nv;
    }

    public ArrayList<StaffDTO> listall() throws SQLException {
        ArrayList<StaffDTO> nv = new ArrayList<>();
        String sql = "select * from staff";
        ResultSet rs = mySQL.executeQuery(sql);
        while (rs.next()) {
            StaffDTO staff = new StaffDTO();
            staff.maNV = rs.getInt(1);
            staff.hoNV = rs.getString(2);
            staff.tenNV = rs.getString(3);
            staff.tenTK = rs.getString(4);
            staff.matkhau = rs.getString(5);
            staff.diachi = rs.getString(6);
            staff.phone = rs.getString(7);
            staff.phai = rs.getString(8);
            staff.namsinh = rs.getString(9);
            staff.setRole(rs.getInt(10));
            staff.trangthai = rs.getInt(11);
            nv.add(staff);
        }
        rs.close();
        mySQL.disConnect();
        return nv;
    }

    public StaffDTO add(StaffDTO nv) throws SQLException {
        String qry = "insert into staff(firstname,name,username,password,address,phone,gender,born,role,status) values(";
        qry += "'" + nv.hoNV + "'";
        qry += ",'" + nv.tenNV + "'";
        qry += ",'" + nv.tenTK + "'";
        qry += ",'" + nv.matkhau + "'";
        qry += ",'" + nv.diachi + "'";
        qry += ",'" + nv.phone + "'";
        qry += ",'" + nv.phai + "'";
        qry += ",'" + nv.namsinh + "'";
        qry += ",'" + nv.role + "'";
        qry += ",'" + nv.trangthai + "')";
        mySQL.executeUpdate(qry);
        String sql = "select * from staff where id=(select MAX(id) from staff)";
        ResultSet rs = mySQL.executeQuery(sql);
        while (rs.next()) {
            nv.maNV = rs.getInt(1);
        }
        rs.close();
        mySQL.disConnect();
        return nv;
    }

    public void set(StaffDTO nv) {
        String qry = "update staff set firstname='" + nv.hoNV + "',name='" + nv.tenNV + "',password='" + nv.matkhau + "',address='" + nv.diachi + "'";
        qry += ",phone='" + nv.phone + "',gender='" + nv.phai + "',born='" + nv.namsinh + "',role=" + nv.role;
        qry += " where id=" + nv.maNV;
        mySQL.executeUpdate(qry);
        mySQL.disConnect();
    }

    public void delete(int id) {
        String qry = "UPDATE staff set status = 0 where id=" + id;
        mySQL.executeUpdate(qry);
        mySQL.disConnect();
    }

    public ArrayList<String> getRole() throws SQLException {
        ArrayList<String> role = new ArrayList<>();
        String sql = "select * from role";
        ResultSet rs = mySQL.executeQuery(sql);
        while (rs.next()) {
            role.add(rs.getString(2));
        }
        rs.close();
        mySQL.disConnect();
        return role;
    }

    public int getIdRole(String r) throws SQLException {
        int role = 0;
        String sql = "select * from role where nameRole='" + r + "'";
        ResultSet rs = mySQL.executeQuery(sql);
        while (rs.next()) {
            role = rs.getInt(1);
        }
        rs.close();
        mySQL.disConnect();
        return role;
    }

    public String getNameRole(int id) throws SQLException {
        String name = "";
        String sql = "SELECT role.nameRole FROM staff,role where staff.role=role.idRole AND staff.id=" + id;
        ResultSet rs = mySQL.executeQuery(sql);
        while (rs.next()) {
            name = rs.getString(1);
        }
        rs.close();
        mySQL.disConnect();
        return name;
    }

    public void updateData(ArrayList<StaffDTO> nv) throws SQLException {
        for (StaffDTO staff : nv) {
            set(staff);
        }
    }
}
