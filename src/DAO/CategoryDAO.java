package DAO;

import DTO.CategoryDTO;
import DTO.RoleDTO;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Loan (^._.^)ﾉ
 */
public class CategoryDAO {
    private MySQLConnect conn = new MySQLConnect();
    public ArrayList<CategoryDTO> getList() throws Exception{
        ArrayList<CategoryDTO> list = new ArrayList<>();
        String qry = "SELECT * FROM category";
        ResultSet rs = conn.executeQuery(qry);
        while (rs.next()){
            CategoryDTO dm = new CategoryDTO();
            dm.setMaDM(rs.getInt(1));
            dm.setTenDM(rs.getString(2));
            list.add(dm);
        }
        return list;
    }

    public ArrayList<CategoryDTO> getListCategoryOfRole(RoleDTO r) throws Exception{
        ArrayList<CategoryDTO> list = new ArrayList<>();
        String qry = "SELECT * FROM category   WHERE idrole = "+r.getMaQuyen();
        ResultSet rs = conn.executeQuery(qry);
        while (rs.next()){
            CategoryDTO dm = new CategoryDTO();
            dm.setMaDM(rs.getInt(1));
            dm.setTenDM(rs.getString(2));
            list.add(dm);
        }
        return list;
    }

}
