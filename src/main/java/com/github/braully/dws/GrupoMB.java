
package com.github.braully.dws;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("view")
@Component

public class GrupoMB {
    
    @Autowired
    GroupDAO grupoDao;
    
    Grupo grupo = new Grupo();

    public Grupo getGrupo() {
        return grupo;
    }
    
    public void salvarGrupo(){
    
        grupoDao.save(grupo);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grupo salvo com sucesso"));

        grupo = new Grupo();
    
    }
    
   
}
