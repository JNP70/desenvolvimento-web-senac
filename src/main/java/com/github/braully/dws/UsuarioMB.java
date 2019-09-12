
package com.github.braully.dws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("view")
@Component
public class UsuarioMB {
    
    @Autowired
    UsuarioDAO usuarioDao;
    
    Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void salvarUsuario(){
        usuarioDao.save(usuario);
        usuario = new Usuario();
    }
}
