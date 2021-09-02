package DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MySQLConnect {
	private String user = "admin";
    private String password="admin";
    private String url="jdbc:mysql://localhost:3306/newdb?useUnicode=true&characterEncoding=UTF-8";
    private Connection conn = null;
    private Statement st = null;
    
    public void Connect()
    {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= (Connection) DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void disConnect()
    { 
        try{
            st.close();
            conn.close();
        }catch (SQLException E){}
    }
    
    public ResultSet executeQuery(String sql)
    {
        ResultSet rs = null;
        try {
            Connect();
            st = (Statement) conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            //Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
//    public void executeUpdate(String sql)
//    {
//        try {
//            Connect();
//            st = (Statement) conn.createStatement();
//            st.executeUpdate(sql);
//            disConnect();
//        } catch (SQLException ex) {
//            //Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public int executeUpdate(String sql)
    {
        try {
            Connect();
            st = (Statement) conn.createStatement();
            return st.executeUpdate(sql);

        } catch (SQLException ex) {
            //Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return -999;
    }
}
