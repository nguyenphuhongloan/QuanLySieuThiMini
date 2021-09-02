package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.HoaDonDAO;
import DAO.PhieuNhapHangDAO;
import DTO.BillDTO;
import DTO.PhieuNhapHangDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonBUS {
	public ArrayList<BillDTO> dshd;
        HoaDonDAO hdDAO;
        
	public HoaDonBUS()
	{
	        this.hdDAO=new HoaDonDAO();
	}
	public void list() throws SQLException {
		
            this.dshd = new ArrayList<BillDTO>();
            this.dshd = hdDAO.list();
           
	}
        
        public ArrayList<BillDTO> allHD() throws SQLException{
            this.hdDAO=new HoaDonDAO();
            return this.hdDAO.list();
        }
        
	public ArrayList<BillDTO> getList(){
		return this.dshd;
	}
        public ArrayList listLocDaytoDay(String sDate, String eDate) throws Exception
        {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(eDate);

             ArrayList<BillDTO> listdaytoday = new ArrayList<BillDTO>();
             for (BillDTO listdaytoday1 : getList()) {
                 Date date = new SimpleDateFormat("yyyy-MM-dd").parse(listdaytoday1.getDate().toString());
                if((date1.compareTo(date)) <= 0 && (date2.compareTo(date) >= 0))  // date phải lớn hơn = sDate và date < = eDate 
                //date1.compareTo(date) < 0 date1 < date và date1.compareTo(date) > 0 thì date1 > date
                {    
                    listdaytoday.add(listdaytoday1);
                }
            }
                
           return listdaytoday;
        }
        
        public ArrayList arrLocNam(int nam) throws ParseException
    {
        ArrayList<BillDTO> listSearchY = new ArrayList<BillDTO>();
//        System.out.println("năm chọn "+nam);
        
        for(int i = 0; i < getList().size(); i++)
        {
            Calendar c = Calendar.getInstance();
            
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(getList().get(i).getDate().toString());
            
            c.setTime(date);
            
            if(c.get(Calendar.YEAR) == nam)
            {
                  listSearchY.add(getList().get(i));
            }
        } 
        return listSearchY;
    }
        
        public ArrayList listQuy1(int nam) throws ParseException
    {
        ArrayList<BillDTO> listQuy1 = new ArrayList<BillDTO>();
        
        for(int i = 0; i< getList().size(); i++)
        {
            Calendar c = Calendar.getInstance();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(getList().get(i).getDate().toString());
            c.setTime(date);
//            System.out.println("thang quý " + c.get(Calendar.MONTH));
            
            if(c.get(Calendar.YEAR) == nam && (c.get(Calendar.MONTH)+1) >= 1 && (c.get(Calendar.MONTH)+1) <= 3 )
            {
                listQuy1.add(getList().get(i));
            }
        }
        
        return listQuy1;
    }
        
        public ArrayList listQuy2(int nam) throws ParseException
    {
        ArrayList<BillDTO> listQuy2 = new ArrayList<BillDTO>();
        
        for(int i = 0; i< getList().size(); i++)
        {
            Calendar c = Calendar.getInstance();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(getList().get(i).getDate().toString());
            c.setTime(date);
//            System.out.println("thang quý " + c.get(Calendar.MONTH));
            
            if(c.get(Calendar.YEAR) == nam && (c.get(Calendar.MONTH)+1) >= 4 && (c.get(Calendar.MONTH)+1) <= 6 )
            {
                listQuy2.add(getList().get(i));
            }
        }
        
        return listQuy2;
    } 
    
    public ArrayList listQuy3(int nam) throws ParseException
    {
        ArrayList<BillDTO> listQuy3 = new ArrayList<BillDTO>();
        
        for(int i = 0; i< getList().size(); i++)
        {
            Calendar c = Calendar.getInstance();
            
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(getList().get(i).getDate().toString());
            c.setTime(date);
//            System.out.println("thang quý " + c.get(Calendar.MONTH));
            
            if(c.get(Calendar.YEAR) == nam && (c.get(Calendar.MONTH)+1) >= 7 && (c.get(Calendar.MONTH)+1) <= 9 )
            {
                listQuy3.add(getList().get(i));
            }
        }
        
        return listQuy3;
    } 
    
    public ArrayList listQuy4(int nam) throws ParseException
    {
        ArrayList<BillDTO> listQuy4 = new ArrayList<BillDTO>();
        
        for(int i = 0; i< getList().size(); i++)
        {
            Calendar c = Calendar.getInstance();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(getList().get(i).getDate().toString());
            c.setTime(date);
//            System.out.println("thang quý " + c.get(Calendar.MONTH));
            
            if(c.get(Calendar.YEAR) == nam && (c.get(Calendar.MONTH)+1) >= 10 && (c.get(Calendar.MONTH)+1) <= 12 )
            {
                listQuy4.add(getList().get(i));
            }
        }
        
        return listQuy4;
    }
}
