package DTO;

public class GioHangDTO {
	public int maHD, maSP,giaSP,slSP,tt;
	public String tenSP,image;
	public GioHangDTO() {
		
	}
public GioHangDTO(int maHD , int maSP,String tenSP,int giaSP,int sl,String image) {
        this.maHD=maHD;
		this.maSP=maSP;
		this.tenSP=tenSP;
		this.giaSP=giaSP;
		this.slSP=sl;
		this.image=image;
		this.tt=giaSP*sl;
	}
public GioHangDTO(int maSP,String tenSP,int giaSP,int sl,String image) {
	this.maSP=maSP;
	this.tenSP=tenSP;
	this.giaSP=giaSP;
	this.slSP=sl;
	this.image=image;
	this.tt=giaSP*sl;
}

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(int giaSP) {
        this.giaSP = giaSP;
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

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
