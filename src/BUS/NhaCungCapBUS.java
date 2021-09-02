package BUS;

import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

import DAO.NhaCungCapDAO;
import DTO.CustomerDTO;
import DTO.SupplierDTO;

public class NhaCungCapBUS {
	private ArrayList<SupplierDTO> dsncc ;
	public NhaCungCapBUS()
	{
	        
	}
	public void list() throws SQLException {
		NhaCungCapDAO nccDAO=new NhaCungCapDAO();
		dsncc=new ArrayList<>();
		dsncc=nccDAO.list();
	}
	public void add(SupplierDTO ncc) throws SQLException {
		NhaCungCapDAO nccDAO=new NhaCungCapDAO();
		dsncc.add(nccDAO.add(ncc));
	}
	public void set(SupplierDTO ncc) {
		NhaCungCapDAO nccDAO=new NhaCungCapDAO();
		nccDAO.set(ncc);
		for(int i = 0 ; i < dsncc.size() ; i++)
		{
			if(dsncc.get(i).maNCC==ncc.maNCC) {
				dsncc.set(i, ncc);
				break;
			}
		}
	}
	public void delete(int id) {
		for(SupplierDTO ncc : dsncc )
		{
			if(ncc.maNCC==id) {
				dsncc.remove(ncc);
				NhaCungCapDAO nccDAO=new NhaCungCapDAO();
				nccDAO.delete(id);
				break;
			}
		}
	}
	public ArrayList<SupplierDTO> search(String s){
		ArrayList<SupplierDTO> temp=new ArrayList<>();
		for(int i=0;i<dsncc.size();i++)
		{
			String ncc=removeAccent(dsncc.get(i).tenNCC);
			String t=removeAccent(s);
			if(ncc.indexOf(t)>=0) temp.add(dsncc.get(i));
		}
		return temp;
	}
	public String removeAccent(String s) { 
		s=s.toLowerCase();
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD); 
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+"); 
		temp = pattern.matcher(temp).replaceAll(""); 
		return temp.replaceAll("đ", "d"); }
	public ArrayList<SupplierDTO> getList(){
		return dsncc;
	}
}
