/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.controller;

import autocomp.dao.UsuarioDAO;
import autocomp.model.Usuario;
import java.io.*;

/**
 *
 * @author adriano
 */
public class UsuarioController implements Serializable{
   
    private UsuarioDAO usuarioDAO;
    
    public UsuarioController(){
        usuarioDAO = new UsuarioDAO();
    }

    public void adicionar(Usuario usuario) {
        if(usuarioDAO.getByTIA(usuario.getTia()) != null)
            throw new IllegalArgumentException("Já existe usuario cadastrado com o mesmo TIA");
        usuarioDAO.save(usuario);
    }
    
    public Usuario pesquisar(String tia){
        return usuarioDAO.getByTIA(tia);
    }
    
    public Usuario autenticar(String tia, String senha){
         Usuario usuario = usuarioDAO.autenticar(tia, senha);
         if(usuario == null) {
             throw new IllegalStateException("Não foi possível autenticar o usuário");
         }
         return usuario;
    }

}
