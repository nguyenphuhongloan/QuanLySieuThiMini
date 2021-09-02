package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.PhieuNhapHangDAO;
import DTO.NhapHangDTO;
import DTO.PhieuNhapHangDTO;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhieuNhapHangBUS {
	private ArrayList<PhieuNhapHangDTO> dspnh ;
	public PhieuNhapHangBUS()
	{
	        
	}
	public void list() throws SQLException {
		PhieuNhapHangDAO pnhDAO=new PhieuNhapHangDAO();
		dspnh=new ArrayList<>();
		dspnh=pnhDAO.list();
	}
	public ArrayList<PhieuNhapHangDTO> getList(){
		return dspnh;
	}
        public ArrayList listLocDaytoDay(String sDate, String eDate) throws Exception
        {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(eDate);

             ArrayList<PhieuNhapHangDTO> listdaytoday = new ArrayList<PhieuNhapHangDTO>();
             for (PhieuNhapHangDTO listdaytoday1 : getList()) {
                 Date date = new SimpleDateFormat("yyyy-MM-dd").parse(listdaytoday1.date.toString());
                if((date1.compareTo(date)) <= 0 && (date2.compareTo(date) >= 0))  // date phải lớn hơn = sDate và date < = eDate 
                //date1.compareTo(date) < 0 date1 < date và date1.compareTo(date) > 0 thì date1 > date
                {    
                    listdaytoday.add(listdaytoday1);
                }
            }
                
           return listdaytoday;
        }
}
