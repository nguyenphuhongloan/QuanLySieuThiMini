package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.NhapHangDTO;

public class CT_PhieuNhapHangDAO {
	private  MySQLConnect mySQL = new MySQLConnect();
    public CT_PhieuNhapHangDAO() {
       
    }
    public ArrayList<NhapHangDTO> list(int idPNH) throws SQLException{
    	ArrayList<NhapHangDTO> pnh = new ArrayList<>();
    	String sql="select * from detail_import where id_import="+idPNH;
    	ResultSet rs=mySQL.executeQuery(sql);
    	while(rs.next()) {
    		NhapHangDTO ct=new NhapHangDTO();
    		ct.maSP=rs.getInt(2);
    		ct.slSP=rs.getInt(3);
    		ct.gianhap=rs.getInt(4);
    		ct.tt=rs.getInt(5);
    		ct.maNCC=rs.getInt(6);
    		pnh.add(ct);
    	}
    	String qry="";
    	for(NhapHangDTO sp : pnh) {
    		qry="select name from product where id="+sp.maSP;
    		rs=mySQL.executeQuery(qry);
    		rs.next();
    		sp.tenSP=rs.getString(1);
    	}
    	rs.close();
        mySQL.disConnect();
    	return pnh;
    }
}
