package BUS;

import java.sql.SQLException;

import DAO.DangNhapDAO;
import DTO.StaffDTO;

public class DangNhapBUS {
	public static StaffDTO login;
	public DangNhapBUS() {
		
	}
	public boolean DangNhap(String tk,String mk) throws SQLException {
		DangNhapDAO dnDAO=new DangNhapDAO();
		if(dnDAO.DangNhap(tk, mk)==true) {
			login=dnDAO.profile(tk);
			return true;
		}
		return false;
	}
}
