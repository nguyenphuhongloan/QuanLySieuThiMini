package BUS;

import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

import DAO.NhanVienDAO;
import DAO.SanPhamDAO;
import DTO.ProductDTO;
import DTO.StaffDTO;

public class NhanVienBUS {
	ArrayList<StaffDTO> dsnv;
	public NhanVienBUS() {
		
	}
        
        public ArrayList<StaffDTO> allnv() throws SQLException{
            NhanVienDAO nvDAO=new NhanVienDAO();
            return nvDAO.listall();
        }
        
	public void listNV() throws SQLException {
		NhanVienDAO nvDAO=new NhanVienDAO();
		dsnv=new ArrayList<>();
		dsnv=nvDAO.list();
	}
	public void add(StaffDTO nv) throws SQLException {
		NhanVienDAO nvDAO=new NhanVienDAO();
		dsnv.add(nvDAO.add(nv));
	}
	public void set(StaffDTO nv) {
		NhanVienDAO nvDAO=new NhanVienDAO();
		nvDAO.set(nv);
		for(int i = 0 ; i < dsnv.size() ; i++)
		{
			if(dsnv.get(i).maNV==nv.maNV) {
				dsnv.set(i, nv);
				break;
			}
		}
	}
	public void delete(int id) {
		for(StaffDTO nv : dsnv)
		{
			if(nv.maNV==id) {
				dsnv.remove(nv);
				NhanVienDAO nvDAO=new NhanVienDAO();
				nvDAO.delete(id);
				break;
			}
		}
	}
	public boolean check(String tk) {
		for(StaffDTO nv : dsnv)
		{
			if(nv.tenTK.equals(tk)) return false;
		}
		return true;
	}
	public ArrayList<StaffDTO> search(String s){
		ArrayList<StaffDTO> temp=new ArrayList<>();
		for(int i=0;i<dsnv.size();i++)
		{
			String nv=removeAccent(dsnv.get(i).hoNV+" "+dsnv.get(i).tenNV);
			String t=removeAccent(s);
			if(nv.indexOf(t)>=0) temp.add(dsnv.get(i));
		}
		return temp;
	}
	public ArrayList<StaffDTO> searchId(int s){
		ArrayList<StaffDTO> temp=new ArrayList<>();
		for(int i=0;i<dsnv.size();i++)
		{
			if(dsnv.get(i).maNV==s) temp.add(dsnv.get(i));
		}
		return temp;
	}
	public ArrayList<StaffDTO> SearchNS(ArrayList<StaffDTO> nvSeach,String s){
		ArrayList<StaffDTO> temp=new ArrayList<>();
		for(int i=0;i<nvSeach.size();i++)
		{
			if(nvSeach.get(i).namsinh.equals(s)) temp.add(nvSeach.get(i));
		}
		return temp;
	}
	public ArrayList<StaffDTO> SearchPhai(ArrayList<StaffDTO> nvSeach,String s){
		ArrayList<StaffDTO> temp=new ArrayList<>();
		for(int i=0;i<nvSeach.size();i++)
		{
			if(nvSeach.get(i).phai.equals(s)) temp.add(nvSeach.get(i));
		}
		return temp;
	}
	public ArrayList<StaffDTO> getList(){
		return dsnv;
	}
	public String removeAccent(String s) { 
		s=s.toLowerCase();
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD); 
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+"); 
		temp = pattern.matcher(temp).replaceAll(""); 
		return temp.replaceAll("đ", "d"); }
	public ArrayList<String> getRole() throws SQLException {
		NhanVienDAO nvDAO=new NhanVienDAO();
		return nvDAO.getRole();
	}
	public int getIdRole(String role) throws SQLException {
		NhanVienDAO nvDAO=new NhanVienDAO();
		return nvDAO.getIdRole(role);
	}
	public String getNameRole(int id) throws SQLException {
		NhanVienDAO nvDAO=new NhanVienDAO();
		return nvDAO.getNameRole(id);
	}
	public void updateData(ArrayList<StaffDTO> nv) throws SQLException {
    	ArrayList<StaffDTO> temp=new ArrayList<>();
    	for(int i=0;i<dsnv.size();i++)
    	{
    		StaffDTO staff=new StaffDTO();
    		staff.maNV=nv.get(i).maNV;
    		staff.hoNV=nv.get(i).hoNV;
    		staff.tenNV=nv.get(i).tenNV;
    		staff.diachi=nv.get(i).diachi;
    		staff.phone=nv.get(i).phone;
    		staff.phai=nv.get(i).phai;
    		staff.namsinh=nv.get(i).namsinh;
    		staff.tenTK=nv.get(i).tenTK;
    		staff.matkhau=nv.get(i).matkhau;
    		staff.role=dsnv.get(i).role;
    		temp.add(staff);
    	}
    	NhanVienDAO nvDAO=new NhanVienDAO();
    	nvDAO.updateData(temp);
    	dsnv=temp;
    }
}
