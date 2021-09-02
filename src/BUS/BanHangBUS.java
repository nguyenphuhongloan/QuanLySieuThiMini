package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.BanHangDAO;
import DTO.BillDTO;
import DTO.GioHangDTO;
import DTO.ProductDTO;
import GUI.ThongBaoGUI;

public class BanHangBUS {
	private ArrayList<GioHangDTO> giohang=new ArrayList<>(); ;
	public BanHangBUS()
	{
	        
	}
	public void add(int id,int sl) throws SQLException {
		BanHangDAO bhDAO=new BanHangDAO();
		ProductDTO sp=bhDAO.add(id);
		boolean check=true;
		for(GioHangDTO pro : giohang) {
			if(pro.maSP==id) {
				if(pro.slSP+sl>sp.slSP) {
					ThongBaoGUI tb=new ThongBaoGUI("Cửa hàng hiện không có đủ số lượng                     sản phẩm yêu cầu!");
				}else {
				pro.slSP+=sl;
				pro.tt=pro.slSP*pro.giaSP;
				}
				check=false;
				break;
			}
		}
		if(check==true) {
			if(sp.slSP>=sl) {
				GioHangDTO itemgh=new GioHangDTO(sp.maSP, sp.tenSP, sp.giaSP, sl, sp.image);
				giohang.add(itemgh);
			}
			else {
				ThongBaoGUI tb=new ThongBaoGUI("Cửa hàng hiện không có đủ số lượng                     sản phẩm yêu cầu!");
			}
		}
	}
	public void set(int index,int idSP,int sl) throws SQLException {
		BanHangDAO bhDAO=new BanHangDAO();
		ProductDTO sp=bhDAO.add(idSP);
		for(int i=0;i<giohang.size();i++)
		{
			if(i==index) {
				if(sl<=sp.slSP) {
					giohang.get(i).maSP=idSP;
					giohang.get(i).slSP=sl;
					giohang.get(i).tenSP=sp.tenSP;
					giohang.get(i).giaSP=sp.giaSP;
					giohang.get(i).image=sp.image;
					giohang.get(i).tt=giohang.get(i).giaSP*sl;
				}else {
					ThongBaoGUI tb=new ThongBaoGUI("Cửa hàng hiện không có đủ số lượng                     sản phẩm yêu cầu!");
				}
				break;
			}
		}
	}
	public void delete(int index) {
		for(int i=0;i<giohang.size();i++)
		{
			if(i==index) {
				giohang.remove(i);
				break;
			}
		}
	}
	public int total() {
		int total=0;
		for(GioHangDTO sp : giohang)
		{
			total+=sp.tt;
		}
		return total;
	}
	public void banhang(BillDTO bill) throws SQLException {
		if(giohang.size()>0) {
			BanHangDAO bhDAO=new BanHangDAO();
			bhDAO.banhang(giohang, bill);
			giohang.removeAll(giohang);
			ThongBaoGUI tb=new ThongBaoGUI("           Giao Dịch Thành Công!!");
		}else {
			ThongBaoGUI tb=new ThongBaoGUI("       Vui lòng chọn sản phẩm bán");
		}
	}
	public ArrayList<GioHangDTO> getList(){
		return giohang;
	}
}
