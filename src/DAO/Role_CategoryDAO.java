package DAO;

import BUS.RoleBUS;
import DTO.Role_CategoryDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Loan (^._.^)ﾉ
 */
public class Role_CategoryDAO {
    MySQLConnect conn = new MySQLConnect();
    public ArrayList<Role_CategoryDTO> getList() throws SQLException {
        ArrayList <Role_CategoryDTO> list = new ArrayList<>();
        String qry = "SELECT * FROM role_category";
        ResultSet rs = conn.executeQuery(qry);
        while (rs.next()){
            Role_CategoryDTO role_category = new Role_CategoryDTO();
            role_category.setMaQuyen(rs.getInt(1));
            role_category.setMaDM(rs.getInt(2));
            list.add(role_category);
        }
        return list;
    }
    public boolean add(Role_CategoryDTO rc){
        try {
            String qry = "INSERT INTO role_category VALUES(";
            qry+=rc.getMaQuyen()+", ";
            qry+=rc.getMaDM()+")";
            return conn.executeUpdate(qry)>0;
        }catch (Exception e){
            return false;
        }
    }
    public void deleteOfIdRole(int id){
        String qry = "DELETE FROM role_category WHERE idRole = "+ id;
        conn.executeUpdate(qry);

    }
}
