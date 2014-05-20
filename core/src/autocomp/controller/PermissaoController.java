/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.controller;

import autocomp.model.Grupo;
import java.io.Serializable;

/**
 *
 * @author adriano
 */
public class PermissaoController implements Serializable{
    
    /**
     *
     * @param id id do grupo
     * @return objeto Grupo localizado
     */
    public static Grupo permissoes(int id){
        if(id == 1)
            return Grupo.ADMINISTRADOR;
        else if(id == 3)
            return Grupo.EDITOR;
        else if(id == 2)
            return Grupo.PROFESSOR;
        else 
            return Grupo.COORDENADOR;
    }
    
}
