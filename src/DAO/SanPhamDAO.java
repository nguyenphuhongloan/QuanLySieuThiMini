package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ProductDTO;

public class SanPhamDAO {
	private  MySQLConnect mySQL = new MySQLConnect();
    public SanPhamDAO() {
       
    }
    public ArrayList<ProductDTO> list() throws SQLException{
    	ArrayList<ProductDTO> sp = new ArrayList<>();
    	String sql="select * from product";
    	ResultSet rs=mySQL.executeQuery(sql);
    	while(rs.next()) {
    		ProductDTO product=new ProductDTO();
    		product.maSP=rs.getInt(1);
    		product.tenSP=rs.getString(2);
    		product.image=rs.getString(3);
    		product.giaSP=rs.getInt(4);
    		product.loaiSP=rs.getString(5);
    		product.slSP=rs.getInt(6);
    		product.donviSP=rs.getString(7);
    		product.trangthai=rs.getInt(8);
    		if(product.trangthai==1)
    			sp.add(product);
    	}
    	rs.close();
        mySQL.disConnect();
    	return sp;
    }
    public ArrayList<ProductDTO> listall() throws SQLException{
    	ArrayList<ProductDTO> sp = new ArrayList<>();
    	String sql="select * from product";
    	ResultSet rs=mySQL.executeQuery(sql);
    	while(rs.next()) {
    		ProductDTO product=new ProductDTO();
    		product.maSP=rs.getInt(1);
    		product.tenSP=rs.getString(2);
    		product.image=rs.getString(3);
    		product.giaSP=rs.getInt(4);
    		product.loaiSP=rs.getString(5);
    		product.slSP=rs.getInt(6);
    		product.donviSP=rs.getString(7);
    		product.trangthai=rs.getInt(8);
    		sp.add(product);
    	}
    	rs.close();
        mySQL.disConnect();
    	return sp;
    }
    public ProductDTO add(ProductDTO sp) throws SQLException {
    	String qry="insert into product(name,image,price,id_category,amount,unit,status) values(";
		qry+="'"+sp.tenSP+"'";
		qry+=",'"+sp.image+"'";
		qry+=",'"+sp.giaSP+"'";
		qry+=",'"+sp.loaiSP+"'";
		qry+=",'"+sp.slSP+"'";
		qry+=",'"+sp.donviSP+"'";
		qry+=",'"+sp.trangthai+"')";
		mySQL.executeUpdate(qry);
		String sql="select * from product where id=(select MAX(id) from product)";
		ResultSet rs=mySQL.executeQuery(sql);
		while(rs.next())
		{
			sp.maSP=rs.getInt(1);
		}
		rs.close();
        mySQL.disConnect();
		return sp;
    }
    public void set(ProductDTO sp) {
    	String qry="update product set name='"+sp.tenSP+"',image='"+sp.image+"',price="+sp.giaSP+",id_category='"+sp.loaiSP+"'";
		qry+=",amount="+sp.slSP+",unit='"+sp.donviSP+"',status='"+sp.trangthai+"'";
		qry+=" where id="+sp.maSP;
		mySQL.executeUpdate(qry);
        mySQL.disConnect();
    }
    public void delete(int id) {
    	String qry="UPDATE product SET status = '0' WHERE id="+id;
    	mySQL.executeUpdate(qry);
        mySQL.disConnect();
    }
    public void updateData(ArrayList<ProductDTO> sp) throws SQLException {
    	for(ProductDTO pro : sp)
    	{
    		set(pro);
    	}
    }
}
