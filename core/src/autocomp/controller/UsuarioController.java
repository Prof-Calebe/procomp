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
public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean adicionar(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário recebido é nulo");
        } else if (usuario.getTia().isEmpty() || usuario.getSenha().isEmpty() || usuario.getGrupo() == null || Integer.parseInt(usuario.getTia()) == 0) {
            return false;
        } else if (usuarioDAO.getByTIA(usuario.getTia()) != null) {
            throw new IllegalArgumentException("Já existe usuario cadastrado com o mesmo TIA");
        }
        return usuarioDAO.add(usuario);
    }

    public Usuario pesquisar(String tia) {
        return usuarioDAO.getByTIA(tia);
    }

    public Usuario autenticar(String tia, String senha) {
        return usuarioDAO.autenticar(tia, senha);
    }

}
