package BUS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.text.Normalizer;
import java.util.regex.Pattern;

import DAO.SanPhamDAO;
import DTO.ProductDTO;

public class SanPhamBUS {
	private ArrayList<ProductDTO> dssp ;
	public SanPhamBUS()
	{
	        
	}
	public void listSP() throws SQLException {
		SanPhamDAO spDAO=new SanPhamDAO();
		dssp=new ArrayList<>();
		dssp=spDAO.list();
	}
	public void listall() throws SQLException {
		SanPhamDAO spDAO=new SanPhamDAO();
		dssp=new ArrayList<>();
		dssp=spDAO.listall();
	}    
        
        
	public void add(ProductDTO sp) throws SQLException {
		SanPhamDAO spDAO=new SanPhamDAO();
		dssp.add(spDAO.add(sp));
	}
	public void set(ProductDTO sp) {
		SanPhamDAO spDAO=new SanPhamDAO();
		spDAO.set(sp);
		for(int i = 0 ; i < dssp.size() ; i++)
		{
			if(dssp.get(i).maSP==sp.maSP) {
				dssp.set(i, sp);
				break;
			}
		}
	}
	public void delete(int id) {
		for(ProductDTO sp : dssp )
		{
			if(sp.maSP==id) {
				dssp.remove(sp);
				SanPhamDAO spDAO=new SanPhamDAO();
				spDAO.delete(id);
				break;
			}
		}
	}
	public ArrayList<ProductDTO> search(String s){
		ArrayList<ProductDTO> temp=new ArrayList<>();
		for(int i=0;i<dssp.size();i++)
		{
			String sp=removeAccent(dssp.get(i).tenSP);
			String t=removeAccent(s);
			if(sp.indexOf(t)>=0) temp.add(dssp.get(i));
		}
		return temp;
	}
	public ArrayList<ProductDTO> SearchLoai1(ArrayList<ProductDTO> spSeach,String s){
		ArrayList<ProductDTO> temp=new ArrayList<>();
		for(int i=0;i<spSeach.size();i++)
		{
			if(spSeach.get(i).loaiSP.equals(s)) temp.add(spSeach.get(i));
		}
		return temp;
	}
	public ArrayList<ProductDTO> SearchDVT(ArrayList<ProductDTO> spSeach,String s){
		ArrayList<ProductDTO> temp=new ArrayList<>();
		for(int i=0;i<spSeach.size();i++)
		{
			if(spSeach.get(i).donviSP.equals(s)) temp.add(spSeach.get(i));
		}
		return temp;
	}
	public ArrayList<ProductDTO> SearchGia1(ArrayList<ProductDTO> spSeach, int giatu, int giaden){
		ArrayList<ProductDTO> temp=new ArrayList<>();
		for(int i=0;i<spSeach.size();i++)
		{
			if((spSeach.get(i).giaSP>=giatu&&spSeach.get(i).giaSP<=giaden)||(spSeach.get(i).giaSP<=giatu&&spSeach.get(i).giaSP>=giaden)) {
				temp.add(spSeach.get(i));
			}
		}
		return temp;
	}
	public ArrayList<ProductDTO> SearchGia2(ArrayList<ProductDTO> spSeach, int giatu){
		ArrayList<ProductDTO> temp=new ArrayList<>();
		for(int i=0;i<spSeach.size();i++)
		{
			if(spSeach.get(i).giaSP>=giatu) {
				temp.add(spSeach.get(i));
			}
		}
		return temp;
	}
	public ArrayList<ProductDTO> SearchGia3(ArrayList<ProductDTO> spSeach, int giaden){
		ArrayList<ProductDTO> temp=new ArrayList<>();
		for(int i=0;i<spSeach.size();i++)
		{
			if(spSeach.get(i).giaSP<=giaden) {
				temp.add(spSeach.get(i));
			}
		}
		return temp;
	}
	public String removeAccent(String s) { 
		s=s.toLowerCase();
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD); 
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+"); 
		temp = pattern.matcher(temp).replaceAll(""); 
		return temp.replaceAll("đ", "d"); }
	public ArrayList<ProductDTO> getList(){
		return dssp;
	}
        
    public ArrayList<ProductDTO> allsp() throws SQLException
    {
       SanPhamDAO spDAO=new SanPhamDAO();
       return spDAO.list();
    }
    public void updateData(ArrayList<ProductDTO> sp) throws SQLException {
    	ArrayList<ProductDTO> temp=new ArrayList<>();
    	for(int i=0;i<dssp.size();i++)
    	{
    		temp.add(sp.get(i));
    	}
    	SanPhamDAO spDAO=new SanPhamDAO();
    	spDAO.updateData(temp);
    	dssp=temp;
    }
}
