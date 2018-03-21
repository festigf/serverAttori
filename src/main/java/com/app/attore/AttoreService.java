package com.app.attore;
import java.util.List;
import org.springframework.stereotype.Service;

import com.app.util.ClsnRownPages;

import org.springframework.beans.factory.annotation.Autowired;
@Service 
public class AttoreService {
    @Autowired
    private AttoreDAO attoreDAO;
    
    public List<Attore> getAttori(){
        return attoreDAO.getAttori();
    }
    
    public List<Attore> getData(String tableName, Integer pageIndex , Integer pageSize){
        return attoreDAO.getDataRows( tableName,  pageIndex ,  pageSize);
    }    
    
    public ClsnRownPages getnRowsnPages(String tableName, Integer pageIndex , Integer pageSize) {
        return attoreDAO.getnRowsnPages(tableName, pageIndex, pageSize);
    }
    
    public Attore getAttore(Long codAttore){
        return attoreDAO.getAttore(codAttore);
    }
    
    public void modAttore(Attore attore){
         attoreDAO.modAttore(attore);
    }
    
    public void delAttore(Long codAttore){
        attoreDAO.delAttore(codAttore);
   }
}