/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.controller;

import autocomp.model.Curso;
import java.io.Serializable;

/**
 *
 * @author adriano
 */
public final class Cursos implements Serializable{
    
    public static Curso getCurso(int id){
        Login l = new Login();
        if(id == 1){
            return new Curso();
        }
        else if(id == 2){
            return new Curso();
        }
        else if(id == 3){
            return new Curso();
        }
        else return null;
    }
    
        public static Curso getCurso(String nome){
        Login l = new Login();
        if("Ciencia da Computacao".equals(nome)){
            return new Curso();
        }
        else if("Sistemas de Informacao".equals(nome)){
            return new Curso();
        }
        else if("Analise e Desenvolvimento de Sistemas".equals(nome)){
            return new Curso();
        }
        else 
            return null;
    }
}
