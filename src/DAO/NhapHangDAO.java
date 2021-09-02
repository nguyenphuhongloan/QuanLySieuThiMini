package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.GioHangDTO;
import DTO.NhapHangDTO;
import DTO.ProductDTO;

public class NhapHangDAO {
	private  MySQLConnect mySQL = new MySQLConnect();
	public NhapHangDAO() {
		
	}
	public ProductDTO add(int id) throws SQLException {
		ProductDTO product=new ProductDTO();
		String sql="select * from product where id="+id;
    	ResultSet rs=mySQL.executeQuery(sql);
    	while(rs.next()) {
    		product.maSP=rs.getInt(1);
    		product.tenSP=rs.getString(2);
    		product.image=rs.getString(3);
    		product.giaSP=rs.getInt(4);
    		product.loaiSP=rs.getString(5);
    		product.slSP=rs.getInt(6);
    		product.donviSP=rs.getString(7);
    	}
    	rs.close();
        mySQL.disConnect();
    	return product;
	}
	public void nhaphang(ArrayList<NhapHangDTO> dssp,String date, int id) throws SQLException {
		int total=0,id_import = 0;
		for(NhapHangDTO sp : dssp) {
			total+=(sp.gianhap*sp.slSP);
		}
		String qry="insert into import(id_account,date_import,total) values(";
		qry+="'"+id+"'";
		qry+=",'"+date+"'";
		qry+=",'"+total+"')";
		mySQL.executeUpdate(qry);
		String sql="select * from import where id=(select MAX(id) from import)";
		ResultSet rs=mySQL.executeQuery(sql);
		while(rs.next())
		{
			id_import=rs.getInt(1);
		}
		for(NhapHangDTO sp : dssp) {
			sql="insert into detail_import(id_import,id_product,amount,price,total,id_supplier) values(";
			sql+="'"+id_import+"'";
			sql+=",'"+sp.maSP+"'";
			sql+=",'"+sp.slSP+"'";
			sql+=",'"+sp.gianhap+"'";
			sql+=",'"+sp.tt+"'";
			sql+=",'"+sp.maNCC+"')";
			mySQL.executeUpdate(sql);	
		}
		for(NhapHangDTO sp : dssp) {
			sql="UPDATE product SET amount=amount+"+sp.slSP+" WHERE id="+sp.maSP;
			mySQL.executeUpdate(sql);	
		}
		rs.close();
        mySQL.disConnect();
	}
}
