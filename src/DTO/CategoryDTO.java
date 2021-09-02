package DTO;

/**
 * @author Loan (^._.^)ﾉ
 */
public class CategoryDTO {
    private int maDM;
    private String tenDM;

    public int getMaDM() {
        return maDM;
    }

    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "maDM=" + maDM +
                ", tenDM='" + tenDM + '\'' +
                '}';
    }
}
