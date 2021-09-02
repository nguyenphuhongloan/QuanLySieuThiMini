package BUS;

import DAO.RoleDAO;
import DTO.RoleDTO;

import java.util.ArrayList;
import java.util.SplittableRandom;

/**
 * @author Loan (^._.^)ﾉ
 */
public class RoleBUS {
    private static ArrayList <RoleDTO> list = new ArrayList<>();
    private RoleDAO dao = new RoleDAO();
    public RoleBUS(){
        try {
            readList();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<RoleDTO> readList() throws Exception {
        list = dao.getList();
        return list;
    }
    public ArrayList<RoleDTO> getList(){
        return list;
    }
    public int add(RoleDTO role){
        role.setMaQuyen(dao.add(role));
        list.add(role);
        return role.getMaQuyen();
    }
    public void update(RoleDTO newRole){
        dao.update(newRole);
        for(int i = 0 ; i<list.size(); i++){
            if(list.get(i).getMaQuyen()==newRole.getMaQuyen()){
                list.set(i,newRole);
                break;
            }
        }
    }
    public void delete(int idRole){
        dao.delete(idRole);
        for (RoleDTO item : list) {
            if(item.getMaQuyen()==idRole){
                list.remove(item);
                break;
            }
        }
    }
    public ArrayList<RoleDTO> search(String name){
        ArrayList<RoleDTO> searchlist = new ArrayList<>();
        for (RoleDTO item : list) {
            if(item.getTenQuyen().contains(name)){
                searchlist.add(item);
            }
        }
        return searchlist;
    }
}
