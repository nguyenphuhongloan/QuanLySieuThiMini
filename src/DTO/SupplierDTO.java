package DTO;

public class SupplierDTO {
	public int maNCC;
	public String tenNCC,soFAX,diachi;

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getSoFAX() {
        return soFAX;
    }

    public void setSoFAX(String soFAX) {
        this.soFAX = soFAX;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
