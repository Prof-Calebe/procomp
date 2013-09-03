/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.entidades;

import java.io.Serializable;

/**
 *
 * @author 31032109
 */
public class Usuario implements Serializable{
    
    private String tia;
    private String senha;
    private int grupo;

    public Usuario(String tia, String senha, int grupo) {
        this.tia = tia;
        this.senha = senha;
        this.grupo = grupo;
    }
    
    

    public String getTia() {
        return tia;
    }

    public void setTia(String tia) {
        this.tia = tia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
}
