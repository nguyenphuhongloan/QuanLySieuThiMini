package DTO;

public class ProductDTO {
	public int maSP;
	public int slSP;
	public int giaSP;
	public String tenSP;
	public String donviSP;
	public String image;
	public String loaiSP;
	public int trangthai=1;

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public int getSlSP() {
		return slSP;
	}

	public void setSlSP(int slSP) {
		this.slSP = slSP;
	}

	public int getGiaSP() {
		return giaSP;
	}

	public void setGiaSP(int giaSP) {
		this.giaSP = giaSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getDonviSP() {
		return donviSP;
	}

	public void setDonviSP(String donviSP) {
		this.donviSP = donviSP;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLoaiSP() {
		return loaiSP;
	}

	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	@Override
	public String toString() {
		return "maSP="+maSP+"/tenSP="+tenSP;
	}
}
