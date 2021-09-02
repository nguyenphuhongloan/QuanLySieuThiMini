/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.util.ArrayList;
import DTO.BillDTO;
import DTO.CustomerDTO;
import DTO.GioHangDTO;
import DTO.StaffDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
/**
 *
 * @author Loan (^._.^)ﾉ
 */
public class inbill {
    private ArrayList<GioHangDTO> cthd = new ArrayList<>();
    private String fileName;
    private BillDTO hd;
    private File folderFile;
    private File file;
    private BaseFont bf;
    public inbill(BillDTO hd, ArrayList<GioHangDTO> cthd){
        this.hd = hd;
        this.cthd = cthd;
        fileName = "./reportbill/bill"+hd.getIdBill()+".pdf";
            
       
    }
    public void print() throws Exception{
        folderFile = new File("./reportbill");
        if (!folderFile.exists()){
            folderFile.mkdir();
           
        }
        bf = BaseFont.createFont("./fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Document bill = null;
        bill = new Document(PageSize.B6, 30, 30, 30, 30);
        PdfWriter.getInstance(bill, new FileOutputStream(fileName));
        bill.open();
        
        Paragraph header = new Paragraph("HÓA ĐƠN",new Font(bf,20));
        header.setAlignment(header.ALIGN_CENTER);
        bill.add(header);
        
       
        Paragraph info1 = new Paragraph("Mã Hóa Đơn: "+ hd.getIdBill()+"               Ngày: "+hd.getDate(), new Font(bf, 15));
        bill.add(info1);
        CustomerDTO kh= new CustomerDTO();
        KhachHangBUS khachHangBUS = new KhachHangBUS();
        khachHangBUS.list();
        for (CustomerDTO customer : khachHangBUS.allkh()) {
           if(hd.getIdCustomer()== customer.getMaKH()){
            kh = customer;
            }
            
        }
        StaffDTO nv = new StaffDTO();
       
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        nhanVienBUS.listNV();
        for(StaffDTO staff : nhanVienBUS.allnv()){
            if(hd.getIdAdmin()==staff.getMaNV())
                nv = staff;
        }
        Paragraph info2 = new Paragraph("Tên Khách Hàng: "+ kh.getHoKH()+ kh.getTenKH(), new Font(bf, 15));
        bill.add(info2);
        Paragraph info3 = new Paragraph("Tên Nhân Viên: "+ nv.getHoNV()+ nv.getTenNV(), new Font(bf, 15));
        bill.add(info3);
        
        Paragraph br = new Paragraph("************", new Font(bf,18));
        br.setAlignment(Paragraph.ALIGN_CENTER);
        bill.add(br);
        
        String [] headerTable = {"Mã SP","Tên sản phẩm", "Đơn giá", "SL"};
        
        PdfPTable table = new PdfPTable(4);
        int [] relativeWidths = {40,120,50,20};
        table.setWidths(relativeWidths);
        table.setWidthPercentage(100);
        table.setSpacingAfter(50);
        //table.setSpacingAfter(0);
        int tong=0;
         for(String s : headerTable)
            {
                table.addCell(createCell(s, new Font(bf,13)));
            }    
        for(GioHangDTO item: cthd){
            table.addCell(createCell(Integer.toString(item.getMaSP()), new Font(bf,11)));
            table.addCell(createCell(item.getTenSP(), new Font(bf,11)));
            table.addCell(createCell(Integer.toString(item.getGiaSP()), new Font(bf,11)));
            table.addCell(createCell(Integer.toString(item.getSlSP()), new Font(bf,11)));
            tong=item.getGiaSP()*item.getSlSP();
        }
       
        
        
        bill.add(table);
        Paragraph tongtien = new Paragraph("Tổng tiền: "+ tong,new Font(bf,13));
        tongtien.setAlignment(Paragraph.ALIGN_RIGHT);
        bill.add(tongtien);
        bill.close();
        
    }
    public PdfPCell createCell(String s,Font font)
    {
        PdfPCell cell = new PdfPCell(new Phrase(s,font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setPaddingBottom(10);
        return cell;
    }
    
}
