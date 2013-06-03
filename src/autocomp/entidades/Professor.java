/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.entidades;

import java.io.Serializable;

/**
 *
 * @author adriano
 */
public class Professor implements Serializable{
    
    private int id;
    private String nome;
    
    public Professor(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    
}
