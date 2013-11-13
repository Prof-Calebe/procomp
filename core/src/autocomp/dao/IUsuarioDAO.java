/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.dao;

import autocomp.model.Usuario;

/**
 *
 * @author 31041949
 */
public interface IUsuarioDAO {
    public Usuario autenticar(String tia, String senha);
}
