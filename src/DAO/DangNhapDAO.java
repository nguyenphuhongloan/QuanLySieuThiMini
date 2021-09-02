package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.StaffDTO;

public class DangNhapDAO {
	private  MySQLConnect mySQL = new MySQLConnect();
	public DangNhapDAO() {
		
	}
	public boolean DangNhap(String tk,String mk) throws SQLException {
		String sql="select * from staff";
		ResultSet rs=mySQL.executeQuery(sql);
		while(rs.next()) {
			if(tk.equals(rs.getString(4)) && mk.equals(rs.getString(5)) && rs.getInt(11)==1) return true;
		}
		rs.close();
        mySQL.disConnect();
		return false;
	}
	public StaffDTO profile(String tk) throws SQLException {
		StaffDTO login=new StaffDTO();
		String sql="select * from staff where username='"+tk+"'";
		ResultSet rs=mySQL.executeQuery(sql);
		rs.next();
		login.maNV=rs.getInt(1);
		login.hoNV=rs.getString(2);
		login.tenNV=rs.getString(3);
		login.tenTK=rs.getString(4);
		login.matkhau=rs.getString(5);
		login.diachi=rs.getString(6);
		login.phone=rs.getString(7);
		login.phai=rs.getString(8);
		login.namsinh=rs.getString(9);
		login.role=rs.getInt(10);
		login.trangthai=rs.getShort(11);
		rs.close();
        mySQL.disConnect();
        return login;
	}
}