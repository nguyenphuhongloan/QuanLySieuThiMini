package BUS;

import DAO.CategoryDAO;
import DTO.CategoryDTO;
import DTO.RoleDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Loan (^._.^)ﾉ
 */
public class CategoryBUS {
    private static ArrayList <CategoryDTO> list = new ArrayList<>();
    CategoryDAO dao = new CategoryDAO();
    public CategoryBUS(){
        try {
            readList();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<CategoryDTO> readList() throws Exception{
        list = dao.getList();
        return list;
    }
    public ArrayList<CategoryDTO> getList(){
        return list;
    }
    public ArrayList<CategoryDTO> getListCategoryOfRole(RoleDTO r) throws Exception{
        ArrayList<CategoryDTO> listCategortOfRole = new ArrayList<>();
        dao.getListCategoryOfRole(r);
        return listCategortOfRole;
    }
}
