/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.entidades;

/**
 *
 * @author adriano
 */
public class Professor {
    
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
