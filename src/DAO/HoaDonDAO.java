package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.BillDTO;
import DTO.GioHangDTO;
import DTO.PhieuNhapHangDTO;

public class HoaDonDAO {
	private  MySQLConnect mySQL = new MySQLConnect();
    public HoaDonDAO() {
       
    }
    public ArrayList list() throws SQLException{
    	ArrayList<BillDTO> dshd = new ArrayList<>();
    	String sql="select * from bill";
    	ResultSet rs=mySQL.executeQuery(sql);
    	while(rs.next()) {
    		BillDTO hd=new BillDTO();
    		hd.setIdBill(rs.getInt(1));
                hd.setIdAdmin(rs.getInt(2));
                hd.setIdCustomer(rs.getInt(3));
                hd.setDate(rs.getString(4));
                hd.setTotal(rs.getInt(5));
    		
    		dshd.add(hd);
    	}
    	rs.close();
        mySQL.disConnect();
    	return dshd;
    }
}
