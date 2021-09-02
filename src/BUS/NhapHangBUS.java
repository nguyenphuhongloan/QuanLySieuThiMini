package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.NhapHangDAO;
import DTO.GioHangDTO;
import DTO.NhapHangDTO;
import DTO.PhieuNhapHangDTO;
import DTO.ProductDTO;
import GUI.ThongBaoGUI;

public class NhapHangBUS {
	private ArrayList<NhapHangDTO> nhaphang=new ArrayList<>(); 
	public NhapHangBUS()
	{
	        
	}
	public void add(int idSP,int sl,int idNCC,int gianhap) throws SQLException {
		NhapHangDAO nhDAO=new NhapHangDAO();
		ProductDTO sp=nhDAO.add(idSP);
		boolean check=true;
		for(NhapHangDTO pro : nhaphang) {
			if(pro.maSP==idSP && pro.getMaNCC()==idNCC) {
				pro.slSP+=sl;
				pro.tt=pro.slSP*pro.gianhap;
				check=false;
				break;
			}
		}
		if(check==true) {
			NhapHangDTO itemnh=new NhapHangDTO(idSP, sp.tenSP, gianhap, sl, idNCC);
			nhaphang.add(itemnh);
			
		}
	}
	public ArrayList<NhapHangDTO> getList(){
		return nhaphang;
	}
	public void set(int index,int idSP,int idNCC,int gianhap,int sl) throws SQLException {
		NhapHangDAO nhDAO=new NhapHangDAO();
		ProductDTO sp=nhDAO.add(idSP);
		for(int i=0;i<nhaphang.size();i++)
		{
			if(i==index) {
				nhaphang.get(i).maSP=idSP;
				nhaphang.get(i).maNCC=idNCC;
				nhaphang.get(i).gianhap=gianhap;
				nhaphang.get(i).slSP=sl;
				nhaphang.get(i).tenSP=sp.tenSP;
				nhaphang.get(i).tt=gianhap*sl;
			}
		}
	}
	public void delete(int index) {
		nhaphang.remove(index);
	}
	public void nhaphang(String date,int id) throws SQLException {
		if(nhaphang.size()>0) {
			NhapHangDAO nhDAO=new NhapHangDAO();
			nhDAO.nhaphang(nhaphang, date, id);
			nhaphang.removeAll(nhaphang);
		}else {
			ThongBaoGUI tb=new ThongBaoGUI("Không có sản phẩm nào để nhập hàng");
		}
	}
}
