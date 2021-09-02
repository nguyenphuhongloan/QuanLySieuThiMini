package DTO;

public class PhieuNhapHangDTO {
	public int id,total,idAccount;
	public String date;
	public PhieuNhapHangDTO() {
		
	}
	public PhieuNhapHangDTO(int id,int total,String date) {
		this.id=id;
		this.total=total;
		this.date=date;
	}

    public PhieuNhapHangDTO(int id, int total, int idAccount, String date) {
        this.id = id;
        this.total = total;
        this.idAccount = idAccount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
