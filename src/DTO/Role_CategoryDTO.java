package DTO;

/**
 * @author Loan (^._.^)ﾉ
 */
public class Role_CategoryDTO {
    private int maQuyen, maDM;

    public int getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(int maQuyen) {
        this.maQuyen = maQuyen;
    }

    public int getMaDM() {
        return maDM;
    }

    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }



    @Override
    public String toString() {
        return "maQuyen_maDMDTO{" +
                "maQuyen=" + maQuyen +
                ", maDM=" + maDM +
                '}';
    }
}
