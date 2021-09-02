/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.BillDTO;
import DTO.CustomerDTO;
import DTO.GioHangDTO;
import DTO.ProductDTO;
import DTO.StaffDTO;
import DTO.ThongKe;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author My name is Hoang
 */
public class ThongKeBUS {
    //sanpham
    ArrayList<ProductDTO> listsp = new ArrayList<ProductDTO>();
    ArrayList<GioHangDTO> listCTHD = new ArrayList<GioHangDTO>();
    CT_HoaDonBUS cthdbus;
    SanPhamBUS spbus;
    
    
    ArrayList<BillDTO> listHD = new ArrayList<BillDTO>();
    HoaDonBUS hdbus;    
    
    //khachhang
    ArrayList<CustomerDTO> listKH = new ArrayList<CustomerDTO>();
    KhachHangBUS khbus;
    
    //Nhanvien
    ArrayList<StaffDTO> listNV = new ArrayList<StaffDTO>();
    NhanVienBUS nvbus;
    
    public ThongKeBUS() throws SQLException{
        cthdbus = new CT_HoaDonBUS();
        spbus = new SanPhamBUS();
        hdbus = new HoaDonBUS();
        
        listsp = spbus.allsp();
        listHD = hdbus.allHD();
        listCTHD = cthdbus.allCTHD();
        
        khbus = new KhachHangBUS();
        listKH = khbus.allkh();
        
        nvbus = new NhanVienBUS();
        listNV = nvbus.allnv();
    }
    
    public ArrayList<ThongKe> ThongKeKhachHang()
    {
        ArrayList<ThongKe> kh = new ArrayList<ThongKe>();
        for(CustomerDTO cus : listKH){
            ThongKe mkh = new ThongKe();
            int makh = cus.getMaKH();
            String hokh = cus.getHoKH();
            String tenkh = cus.getTenKH();
            
            mkh.setMa(String.valueOf(makh));
            mkh.setTen(hokh+" "+tenkh);
            mkh.setSoluong(" ");
            
            long Tongtien = 0;
            for(BillDTO hd : listHD){
                    if(hd.getIdCustomer()== makh )
                    {
                        Tongtien+=hd.getTotal();
                    }
                }
               mkh.setTongtien((int) Tongtien);
               kh.add(mkh);
            }           
        return kh;
    }
    
    public ArrayList thongkesp(ArrayList<GioHangDTO> ct){
        ArrayList<ThongKe> ListTkSpXuat = new ArrayList<>();

        for (ProductDTO sanPhamDTO : listsp) {
            ThongKe tksp = new ThongKe();
            tksp.setMa(String.valueOf(sanPhamDTO.maSP));
            String masp = String.valueOf(String.valueOf(sanPhamDTO.maSP));
            int sl = 0;

            for (GioHangDTO cthd : ct) {
                if (masp.endsWith(String.valueOf(cthd.maSP))) {
                    sl += cthd.slSP;
                }
            }

            tksp.soluong = String.valueOf(sl);
            ListTkSpXuat.add(tksp);
        }
        return ListTkSpXuat;
    }
    
    public ArrayList ThongKeSpXuat(ArrayList<BillDTO> hd) {
        ArrayList<ThongKe> listThongKeSpXuatDaytoDay = new ArrayList<ThongKe>();
        for (BillDTO hdDTO : hd) {

            int sl = 0;
            for (GioHangDTO cthd : listCTHD) {
                if (hdDTO.getIdBill() == cthd.maHD) {
                    ThongKe tk = new ThongKe();
                    tk.setMa(String.valueOf(cthd.maSP));
                    tk.setSoluong(String.valueOf(cthd.slSP));
                    tk.setTongtien(cthd.tt);
                    for(ProductDTO pd : listsp){
                        if(cthd.maSP == pd.maSP)
                            tk.setTen(pd.tenSP);
                    }
                    listThongKeSpXuatDaytoDay.add(tk);
                }
            }

        }

        return listThongKeSpXuatDaytoDay = this.GopSPLoop(listThongKeSpXuatDaytoDay);
    }
    
    public ArrayList ThongKeKhachHangDaytoDay(ArrayList<BillDTO> hd) {
        ArrayList<ThongKe> listKhachHangDaytoDay = new ArrayList<ThongKe>();
        
        for (BillDTO hdDTO : hd) {
            ThongKe tk = new ThongKe();            
            tk.setMa(String.valueOf(hdDTO.getIdCustomer()));
            tk.setSoluong("1");
            for(CustomerDTO cus : listKH){
                if(cus.getMaKH() == hdDTO.getIdCustomer())
                    tk.setTen(cus.getHoKH()+" "+ cus.getTenKH());       
            }
//            int sl=0;
//            for(GioHangDTO gh : listCTHD)
//            {
//                if(gh.maHD == hdDTO.getIdBill())
//                    sl+=gh.slSP;
//                    tk.setSoluong(String.valueOf(sl));
//            }
//            tk.setSoluong(String.valueOf(tong));
            tk.setTongtien(hdDTO.getTotal());
            
            listKhachHangDaytoDay.add(tk);
        }
        listKhachHangDaytoDay = this.GopSPLoop(listKhachHangDaytoDay);
        return listKhachHangDaytoDay;
    }
    
    public ArrayList ThongKeNhanvien(ArrayList<BillDTO> hd) {
        ArrayList<ThongKe> listKhachHangDaytoDay = new ArrayList<ThongKe>();
        
        for (BillDTO hdDTO : hd) {
            ThongKe tk = new ThongKe();            
            tk.setMa(String.valueOf(hdDTO.getIdAdmin()));
                       
            for(StaffDTO cus : listNV){
                if(cus.maNV == hdDTO.getIdAdmin())
                    tk.setTen(cus.hoNV+" "+cus.tenNV);           
            }
            tk.setSoluong("1");
//            int sl=0;
//            for(GioHangDTO gh : listCTHD){
//                if(gh.maHD == hdDTO.getIdBill())
//                    sl+=gh.slSP;
//                    tk.setSoluong(String.valueOf(sl));
//            }           
            
            tk.setTongtien(hdDTO.getTotal());
            
            listKhachHangDaytoDay.add(tk);
        }
        listKhachHangDaytoDay = this.GopSPLoop(listKhachHangDaytoDay);
        return listKhachHangDaytoDay;
    }
    
//    public ArrayList removeLap(ArrayList<ThongKe> tk) {
//        ArrayList<ThongKe> temp = new ArrayList<ThongKe>();
//        for(int i=0;i< tk.size();i++){
//            for(int j=0;j<temp.size();j++){
//                if(!tk.get(i).getMa().equals(temp.get(i).getMa()))                    
//                temp.add(tk.get(j));
//            }
//        }
//        tk.clear();
//        tk.addAll(temp);
//        return tk;
//    }
    
    public ArrayList removeLap(ArrayList<ThongKe> tk) {
        int h=0, k=0;
        for (h= 0; h < tk.size(); h++) {
            for (k = 0; k < tk.size(); k++) {                
                if (Integer.parseInt(tk.get(k).getMa()) == Integer.parseInt(tk.get(h).getMa())) { // getma(k) không bằng h;
                    if(k>h){
                        tk.remove(tk.get(k));       
                        k--;
                    }              
                }
            }
        }   

        return tk;
    }

    public ArrayList GopSPLoop(ArrayList<ThongKe> tk) {
        
        for (int i = 0; i < tk.size(); i++) {
            String Ma = tk.get(i).getMa();
            int tt = tk.get(i).getTongtien();
            int sl = Integer.parseInt(tk.get(i).getSoluong());
            for (int j = i + 1; j < tk.size(); j++) {
                if (tk.get(j).getMa().equals(Ma)) {
                    tt += tk.get(j).getTongtien();
                    sl+= Integer.parseInt(tk.get(j).getSoluong());
                }

            }
            tk.get(i).setTongtien(tt);
            tk.get(i).setSoluong(String.valueOf(sl));
        }

        return this.removeLap(tk);            
    }
    
    
}
