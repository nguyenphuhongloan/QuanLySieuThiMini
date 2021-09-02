package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CustomerDTO;
import DTO.ProductDTO;

public class KhachHangDAO {
private  MySQLConnect mySQL = new MySQLConnect();
    public KhachHangDAO() {
       
    }
    public ArrayList<CustomerDTO> list() throws SQLException{
    	ArrayList<CustomerDTO> kh = new ArrayList<>();
    	String sql="select * from customer where status=1";
    	ResultSet rs=mySQL.executeQuery(sql);
    	while(rs.next()) {
    		CustomerDTO customer=new CustomerDTO();
    		customer.maKH=rs.getInt(1);
    		customer.hoKH=rs.getString(2);
    		customer.tenKH=rs.getString(3);
    		customer.diachi=rs.getString(4);
    		customer.phone=rs.getString(5);
    		kh.add(customer);
    	}
    	rs.close();
        mySQL.disConnect();
    	return kh;
    }
    public ArrayList<CustomerDTO> listall() throws SQLException{
    	ArrayList<CustomerDTO> kh = new ArrayList<>();
    	String sql="select * from customer";
    	ResultSet rs=mySQL.executeQuery(sql);
    	while(rs.next()) {
    		CustomerDTO customer=new CustomerDTO();
    		customer.maKH=rs.getInt(1);
    		customer.hoKH=rs.getString(2);
    		customer.tenKH=rs.getString(3);
    		customer.diachi=rs.getString(4);
    		customer.phone=rs.getString(5);
    		kh.add(customer);
    	}
    	rs.close();
        mySQL.disConnect();
    	return kh;
    }
    public CustomerDTO add(CustomerDTO kh) throws SQLException {
    	String qry="insert into customer(firstname,name,address,phone,status) values(";
    	qry+="'"+kh.hoKH+"'";
		qry+=",'"+kh.tenKH+"'";
		qry+=",'"+kh.diachi+"'";
		qry+=",'"+kh.phone+"'";
		qry+=",'"+kh.trangthai+"')";
		mySQL.executeUpdate(qry);
		String sql="select * from customer where id=(select MAX(id) from customer)";
		ResultSet rs=mySQL.executeQuery(sql);
		while(rs.next())
		{
			kh.maKH=rs.getInt(1);
		}
		rs.close();
        mySQL.disConnect();
		return kh;
    }
    public void set(CustomerDTO kh) {
    	String qry="update customer set firstname='"+kh.hoKH+"',name='"+kh.tenKH+"',address='"+kh.diachi+"',phone='"+kh.phone+"'";
		qry+=" where id="+kh.maKH;
		mySQL.executeUpdate(qry);
        mySQL.disConnect();
    }
    public void delete(int id) {
    	String qry="update customer set status=0 where id="+id;
    	mySQL.executeUpdate(qry);
        mySQL.disConnect();
    }
    public void updateData(ArrayList<CustomerDTO> kh) throws SQLException {
    	for(CustomerDTO cus : kh)
    	{
    		set(cus);
    	}
    }
}
