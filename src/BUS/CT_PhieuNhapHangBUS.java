package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.CT_PhieuNhapHangDAO;
import DAO.SanPhamDAO;
import DTO.NhapHangDTO;
import DTO.ProductDTO;

public class CT_PhieuNhapHangBUS {
	private ArrayList<NhapHangDTO> CT_pnh ;
	public CT_PhieuNhapHangBUS()
	{
	        
	}
	public void list(int idPNH) throws SQLException {
		CT_PhieuNhapHangDAO ctpnhDAO=new CT_PhieuNhapHangDAO();
		CT_pnh=new ArrayList<>();
		CT_pnh=ctpnhDAO.list(idPNH);
	}
	public ArrayList<NhapHangDTO> getList(){
		return CT_pnh;
	}
}
