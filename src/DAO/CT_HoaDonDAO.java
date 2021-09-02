package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.GioHangDTO;

public class CT_HoaDonDAO {
	private  MySQLConnect mySQL = new MySQLConnect();
    public CT_HoaDonDAO() {
       
    }
    public ArrayList<GioHangDTO> list(int idHD) throws SQLException{
    	ArrayList<GioHangDTO> hd = new ArrayList<>();
    	String sql="select * from detail_bill where id_bill="+idHD;
    	ResultSet rs=mySQL.executeQuery(sql);
    	while(rs.next()) {
    		GioHangDTO ct=new GioHangDTO();
    		ct.maSP=rs.getInt(2);
    		ct.giaSP=rs.getInt(3);
    		ct.slSP=rs.getInt(4);
    		ct.tt=rs.getInt(5);
    		hd.add(ct);
    	}
    	String qry="";
    	for(GioHangDTO sp : hd) {
    		qry="select name from product where id="+sp.maSP;
    		rs=mySQL.executeQuery(qry);
    		rs.next();
    		sp.tenSP=rs.getString(1);
    	}
    	rs.close();
        mySQL.disConnect();
    	return hd;
    }
    
    public ArrayList<GioHangDTO> listct() throws SQLException{
        ArrayList<GioHangDTO> ct = new ArrayList<GioHangDTO>();
        String sql = sql="select * from detail_bill";
        ResultSet rs = mySQL.executeQuery(sql);
        while(rs.next()){
            GioHangDTO cthd = new GioHangDTO();
            cthd.maHD=rs.getInt(1);
            cthd.maSP=rs.getInt(2);
            cthd.giaSP=rs.getInt(3);
            cthd.slSP=rs.getInt(4);
            cthd.tt=rs.getInt(5);
            ct.add(cthd);
        }
        return ct;
    }
}
