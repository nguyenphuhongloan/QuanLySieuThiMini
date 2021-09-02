package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.PhieuNhapHangDTO;

public class PhieuNhapHangDAO {
	private  MySQLConnect mySQL = new MySQLConnect();
    public PhieuNhapHangDAO() {
       
    }
    public ArrayList<PhieuNhapHangDTO> list() throws SQLException{
    	ArrayList<PhieuNhapHangDTO> dspnh = new ArrayList<>();
    	String sql="select * from import";
    	ResultSet rs=mySQL.executeQuery(sql);
    	while(rs.next()) {
    		PhieuNhapHangDTO pnh=new PhieuNhapHangDTO();
    		pnh.id=rs.getInt(1);
    		pnh.idAccount=rs.getInt(2);
    		pnh.date=rs.getString(3);
    		pnh.total=rs.getInt(4);
    		dspnh.add(pnh);
    	}
    	rs.close();
        mySQL.disConnect();
    	return dspnh;
    }
}
