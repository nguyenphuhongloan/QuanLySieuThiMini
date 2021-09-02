package BUS;

import DAO.CategoryDAO;
import DAO.RoleDAO;
import DAO.Role_CategoryDAO;
import DTO.CategoryDTO;
import DTO.RoleDTO;
import DTO.Role_CategoryDTO;
import java.util.ArrayList;

/**
 * @author Loan (^._.^)ﾉ
 */
public class Role_CategoryBUS {
    private   ArrayList<Role_CategoryDTO> list = new ArrayList<>();
    private Role_CategoryDAO dao = new Role_CategoryDAO();
    private RoleBUS roleBUS = new RoleBUS();
    private CategoryBUS categoryBUS = new CategoryBUS();
    public Role_CategoryBUS(){
        try {
            readList();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Role_CategoryDTO> readList() throws Exception{
        list = dao.getList();
        return list;
    }
    public ArrayList<Role_CategoryDTO> getList(){
        return list;
    }
    public ArrayList<CategoryDTO> getListCategoryOfRole(RoleDTO r){
        ArrayList<CategoryDTO> allListOfCategory;
        ArrayList<CategoryDTO> listOfCategory = new ArrayList<>();
        allListOfCategory = categoryBUS.getList();
        for (Role_CategoryDTO item : list) {
            if(item.getMaQuyen()==r.getMaQuyen()){
                for (CategoryDTO dm : allListOfCategory) {
                    if(item.getMaDM()==dm.getMaDM()){
                        listOfCategory.add(dm);
                        break;
                    }
                }
            }
        }
        return listOfCategory;
    }
    public void add(Role_CategoryDTO rc){
        dao.add(rc);
        list.add(rc);
    }

    public void delete(int idRole){
        dao.deleteOfIdRole(idRole);
       /* for (Role_CategoryDTO item : list) {
            if(item.getMaQuyen() == idRole){
                list.remove(item);
            }
        }*/
        list.removeIf(role_categoryDTO -> role_categoryDTO.getMaQuyen()==idRole);
    }
}
