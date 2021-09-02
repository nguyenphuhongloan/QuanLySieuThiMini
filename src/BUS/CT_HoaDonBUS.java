package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.CT_HoaDonDAO;
import DTO.GioHangDTO;

public class CT_HoaDonBUS {
	private ArrayList<GioHangDTO> CT_hd ;
        public CT_HoaDonDAO cthd;
	public CT_HoaDonBUS()
	{
	        
	}
        public CT_HoaDonBUS(int idHD) throws SQLException{
            CT_HoaDonDAO cthdDAO=new CT_HoaDonDAO();
            CT_hd=new ArrayList<>();
            CT_hd=cthdDAO.list(idHD);
        }
	public void list(int idHD) throws SQLException {
		CT_HoaDonDAO cthdDAO=new CT_HoaDonDAO();
		CT_hd=new ArrayList<>();
		CT_hd=cthdDAO.list(idHD);
	}
        
        public ArrayList allCTHD() throws SQLException{
            cthd = new CT_HoaDonDAO();
            return  cthd.listct();
        }
        
	public ArrayList<GioHangDTO> getList(){
               // CT_hd = new ArrayList<GioHangDTO>();
		return CT_hd;
	}
}
