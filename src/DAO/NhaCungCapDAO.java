package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.SupplierDTO;

public class NhaCungCapDAO {
	private  MySQLConnect mySQL = new MySQLConnect();
    public NhaCungCapDAO() {
       
    }
    public ArrayList<SupplierDTO> list() throws SQLException{
    	ArrayList<SupplierDTO> ncc = new ArrayList<>();
    	String sql="select * from supplier";
    	ResultSet rs=mySQL.executeQuery(sql);
    	while(rs.next()) {
    		SupplierDTO supplier=new SupplierDTO();
    		supplier.maNCC=rs.getInt(1);
    		supplier.tenNCC=rs.getString(2);
    		supplier.diachi=rs.getString(3);
    		supplier.soFAX=rs.getString(4);
    		ncc.add(supplier);
    	}
    	rs.close();
        mySQL.disConnect();
    	return ncc;
    }
    public SupplierDTO add(SupplierDTO ncc) throws SQLException {
    	String qry="insert into supplier(name,address,phone) values(";
		qry+="'"+ncc.tenNCC+"'";
		qry+=",'"+ncc.diachi+"'";
		qry+=",'"+ncc.soFAX+"')";
		mySQL.executeUpdate(qry);
		String sql="select * from supplier where id=(select MAX(id) from supplier)";
		ResultSet rs=mySQL.executeQuery(sql);
		while(rs.next())
		{
			ncc.maNCC=rs.getInt(1);
		}
		rs.close();
        mySQL.disConnect();
		return ncc;
    }
    public void set(SupplierDTO ncc) {
    	String qry="update supplier set name='"+ncc.tenNCC+"',address='"+ncc.diachi+"',phone='"+ncc.soFAX+"'";
		qry+=" where id="+ncc.maNCC;
		mySQL.executeUpdate(qry);
        mySQL.disConnect();
    }
    public void delete(int id) {
    	String qry="delete from supplier where id="+id;
    	mySQL.executeUpdate(qry);
        mySQL.disConnect();
    }
}
