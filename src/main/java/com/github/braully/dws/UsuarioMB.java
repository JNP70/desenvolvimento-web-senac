package com.github.braully.dws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("view")
@Component
public class UsuarioMB {

    @Autowired
    UsuarioDAO usuarioDao;

    @Autowired
    GroupDAO groupDAO;

    Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void salvarUsuario() {
        
        for (Grupo g : gruposSelecionados.keySet()) {
            Boolean selct = gruposSelecionados.get(g);
            if (selct) {
                usuario.adicionaGrupo(g);
            }
        }
        
        
        
        usuarioDao.save(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario salvo com sucesso"));

        usuario = new Usuario();
    }
    List<Grupo> listaGrupos;

    public List<Grupo> getListaGrupos() {
        if (listaGrupos == null) {
            listaGrupos = new ArrayList<>();
            for (Grupo g : groupDAO.findAll()) {
                listaGrupos.add(g);
            }
        }

        return listaGrupos;
    }
    
    Map<Grupo, Boolean> gruposSelecionados = new HashMap<>();
    
    public Map<Grupo, Boolean> getGruposSelecionados() {
        return gruposSelecionados;
    }
    
}
