package DAO;

import DTO.RoleDTO;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Loan (^._.^)ﾉ
 */
public class RoleDAO {
    private MySQLConnect conn = new MySQLConnect();

    public ArrayList<RoleDTO> getList() throws Exception {
        ArrayList<RoleDTO> list = new ArrayList<>();
        String qry = "SELECT * FROM role";
        ResultSet rs = conn.executeQuery(qry);
        while (rs.next()) {
            RoleDTO role = new RoleDTO();
            role.setMaQuyen(rs.getInt(1));
            role.setTenQuyen(rs.getString(2));
            list.add(role);
        }
        return list;
    }
    public int add(RoleDTO role){
        try {
            String qry = "INSERT INTO role(nameRole) VALUES('";
            qry+= role.getTenQuyen()+"')";
            if(conn.executeUpdate(qry)>0){
                String getMaxID = "SELECT MAX(idRole) FROM role ";
                ResultSet id = conn.executeQuery(getMaxID);
                while (id.next()){
                    return id.getInt(1);
                }
            }
            return -1;
        }catch (Exception e){
            return -1;
        }
    }

    public void update(RoleDTO role){
        String qry = "UPDATE role SET nameRole = '"+role.getTenQuyen()+ "' WHERE idRole = "+role.getMaQuyen();
        conn.executeUpdate(qry);
    }
    public void delete(int idRole){
        String qry = "DELETE FROM role WHERE idRole = "+idRole;
        conn.executeUpdate(qry);
    }
}
