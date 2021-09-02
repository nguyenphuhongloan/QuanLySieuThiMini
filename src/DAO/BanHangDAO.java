package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.BillDTO;
import DTO.GioHangDTO;
import DTO.NhapHangDTO;
import DTO.ProductDTO;

public class BanHangDAO {
	private  MySQLConnect mySQL = new MySQLConnect();
	public BanHangDAO() {
		
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
	public void banhang(ArrayList<GioHangDTO> giohang, BillDTO bill) throws SQLException {
		String sql="insert into bill(id_admin,id_customer,date,total) values(";
		sql+="'"+bill.idAdmin+"'";
		sql+=",'"+bill.idCustomer+"'";
		sql+=",'"+bill.date+"'";
		sql+=",'"+bill.total+"')";
		mySQL.executeUpdate(sql);
		sql="select id from bill where id=(select MAX(id) from bill)";
		ResultSet rs=mySQL.executeQuery(sql);
		rs.next();
		int id_bill=rs.getInt(1);
		for(GioHangDTO sp : giohang) {
			sql="insert into detail_bill(id_bill,id_product,price,amount,total) values(";
			sql+="'"+id_bill+"'";
			sql+=",'"+sp.maSP+"'";
			sql+=",'"+sp.giaSP+"'";
			sql+=",'"+sp.slSP+"'";
			sql+=",'"+sp.tt+"')";
			mySQL.executeUpdate(sql);	
		}
		for(GioHangDTO sp : giohang) {
			sql="UPDATE product SET amount=amount-"+sp.slSP+" WHERE id="+sp.maSP;
			mySQL.executeUpdate(sql);	
		}
		rs.close();
        mySQL.disConnect();
	}
}
