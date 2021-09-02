package DTO;

/**
 * @author Loan (^._.^)ﾉ
 */
public class RoleDTO {
    private int maQuyen;
    private String tenQuyen;

    public int getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(int maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "maQuyen=" + maQuyen +
                ", tenQuyen='" + tenQuyen + '\'' +
                '}';
    }
}
