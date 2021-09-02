package BUS;

import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

import DAO.KhachHangDAO;
import DAO.SanPhamDAO;
import DTO.CustomerDTO;
import DTO.ProductDTO;
import DTO.StaffDTO;

public class KhachHangBUS {
	private ArrayList<CustomerDTO> dskh ;
	public KhachHangBUS()
	{ 
	        
	}
        
        public ArrayList<CustomerDTO> allkh() throws SQLException{
            KhachHangDAO khDAO=new KhachHangDAO();
            return khDAO.listall();
        }
        
	public void list() throws SQLException {
		KhachHangDAO khDAO=new KhachHangDAO();
		dskh=new ArrayList<>();
		dskh=khDAO.list();
	}
	public void add(CustomerDTO kh) throws SQLException {
		KhachHangDAO khDAO=new KhachHangDAO();
		dskh.add(khDAO.add(kh));
	}
	public void set(CustomerDTO kh) {
		KhachHangDAO khDAO=new KhachHangDAO();
		khDAO.set(kh);
		for(int i = 0 ; i < dskh.size() ; i++)
		{
			if(dskh.get(i).maKH==kh.maKH) {
				dskh.set(i, kh);
				break;
			}
		}
	}
	public void delete(int id) {
		for(CustomerDTO kh : dskh )
		{
			if(kh.maKH==id) {
				dskh.remove(kh);
				KhachHangDAO khDAO=new KhachHangDAO();
				khDAO.delete(id);
				break;
			}
		}
	}
	public ArrayList<CustomerDTO> search(String s){
		ArrayList<CustomerDTO> temp=new ArrayList<>();
		for(int i=0;i<dskh.size();i++)
		{
			String kh=removeAccent(dskh.get(i).hoKH+dskh.get(i).tenKH);
			String t=removeAccent(s);
			if(kh.indexOf(t)>=0) temp.add(dskh.get(i));
		}
		return temp;
	}
	public String removeAccent(String s) { 
		s=s.toLowerCase();
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD); 
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+"); 
		temp = pattern.matcher(temp).replaceAll(""); 
		return temp.replaceAll("đ", "d"); }
	public ArrayList<CustomerDTO> getList(){
		return dskh;
	}
	public void updateData(ArrayList<CustomerDTO> kh) throws SQLException {
    	ArrayList<CustomerDTO> temp=new ArrayList<>();
    	for(int i=0;i<dskh.size();i++)
    	{
    		temp.add(kh.get(i));
    	}
    	KhachHangDAO khDAO=new KhachHangDAO();
    	khDAO.updateData(temp);
    	dskh=temp;
    }
}
