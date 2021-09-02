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
import DTO.NhapHangDTO;
import DTO.PhieuNhapHangDTO;
import DTO.StaffDTO;
import DTO.SupplierDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.BidiOrder;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
/**
 *
 * @author Loan (^._.^)ﾉ
 */
public class inPhieuNhap {
    private ArrayList<NhapHangDTO> ctpn = new ArrayList<>();
    private String fileName;
    private PhieuNhapHangDTO pn;
    private File folderFile;
    private File file;
    private BaseFont bf;
    public inPhieuNhap(PhieuNhapHangDTO pn, ArrayList<NhapHangDTO> ctpn){
        this.pn = pn;
        this.ctpn = ctpn;
        fileName = "./reportphieunhap/bill"+pn.getId()+".pdf";
            
       
    }
    public void print() throws Exception{
        folderFile = new File("./reportphieunhap");
        if (!folderFile.exists()){
            folderFile.mkdir();
        }
        bf = BaseFont.createFont("./fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Document bill = null;
        bill = new Document(PageSize.A4, 30, 30, 30, 30);
        PdfWriter.getInstance(bill, new FileOutputStream(fileName));
        bill.open();
        
        Paragraph header = new Paragraph("PHIẾU NHẬP",new Font(bf,20));
        header.setAlignment(header.ALIGN_CENTER);
        bill.add(header);
        
       
        Paragraph info1 = new Paragraph("Mã Phiếu Nhập: "+ pn.getId()+"                                Ngày: "+pn.getDate(), new Font(bf, 15));
        bill.add(info1);
        
        
        StaffDTO nv = new StaffDTO();
       
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        nhanVienBUS.listNV();
        System.out.println(pn.getIdAccount());
        for(StaffDTO staff : nhanVienBUS.allnv()){
            if(pn.getIdAccount()==staff.getMaNV())
                nv = staff;
        }
        
        Paragraph info3 = new Paragraph("Tên Nhân Viên: "+ nv.getHoNV()+ nv.getTenNV(), new Font(bf, 15));
        bill.add(info3);
        
        Paragraph br = new Paragraph("************", new Font(bf,18));
        br.setAlignment(Paragraph.ALIGN_CENTER);
        bill.add(br);
        
        String [] headerTable = {"Mã SP","Tên sản phẩm", "Số lượng", "Giá nhập","Tông cộng", "Tên nhà cung cấp"};
        
       
        
        
        PdfPTable table = new PdfPTable(6);
        int [] relativeWidths = {40,100,50,70,70,80};
        table.setWidths(relativeWidths);
        table.setWidthPercentage(100);
        table.setSpacingAfter(50);
        //table.setSpacingAfter(0);
        int tong=0;
         for(String s : headerTable)
            {
                table.addCell(createCell(s, new Font(bf,13)));
            }    
         
         
        for(NhapHangDTO item : ctpn){
            table.addCell(createCell(Integer.toString(item.getMaSP()), new Font(bf,11)));
            table.addCell(createCell(item.getTenSP(), new Font(bf,11)));
            table.addCell(createCell(Integer.toString(item.getSlSP()), new Font(bf,11)));
            table.addCell(createCell(Integer.toString(item.getGianhap()), new Font(bf,11)));
            table.addCell(createCell(Integer.toString(item.getTt()), new Font(bf,11)));
            String tenncc = "";
            NhaCungCapBUS nccbus = new NhaCungCapBUS();
            nccbus.list();
            for(SupplierDTO ncc : nccbus.getList()){
                if(ncc.getMaNCC() == item.getMaNCC()){
                    tenncc = ncc.getTenNCC();
                    System.out.println(tenncc);
                    break;
                }
            }
            table.addCell(createCell(tenncc, new Font(bf,11)));
            tong+=item.getTt();
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
