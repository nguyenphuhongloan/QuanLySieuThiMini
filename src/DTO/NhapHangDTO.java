package DTO;

public class NhapHangDTO {
	public int maSP,gianhap,slSP,tt,maNCC;
	public String tenSP;
	public NhapHangDTO() {
		
	}
public NhapHangDTO(int maSP,String tenSP,int gianhap,int sl,int maNCC) {
		this.maSP=maSP;
		this.tenSP=tenSP;
		this.gianhap=gianhap;
		this.slSP=sl;
		this.tt=gianhap*sl;
		this.maNCC=maNCC;
	}

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public int getSlSP() {
        return slSP;
    }

    public void setSlSP(int slSP) {
        this.slSP = slSP;
    }

    public int getTt() {
        return tt;
    }

    public void setTt(int tt) {
        this.tt = tt;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

}
