/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import autocomp.entidades.Curso;

/**
 *
 * @author adriano
 */
public final class Cursos {
    
    public static Curso getCurso(int id){
        Login l = new Login();
        if(id == 1){
            return new Curso(id, "Ciencia da Computacao", 8, l.pesquisar("1126910"));
        }
        else if(id == 2){
            return new Curso(id, "Sistemas de Informacao", 8, l.pesquisar("1091981"));
        }
        else if(id == 3){
            return new Curso(id, "Analise e Desenvolvimento de Sistemas", 4, l.pesquisar("1126910"));
        }
        else return null;
    }
    
        public static Curso getCurso(String nome){
        Login l = new Login();
        if("Ciencia da Computacao".equals(nome)){
            return new Curso(1, "Ciencia da Computacao", 8, l.pesquisar("1126910"));
        }
        else if("Sistemas de Informacao".equals(nome)){
            return new Curso(2, "Sistemas de Informacao", 8, l.pesquisar("1091981"));
        }
        else if("Analise e Desenvolvimento de Sistemas".equals(nome)){
            return new Curso(3, "Analise e Desenvolvimento de Sistemas", 4, l.pesquisar("1126910"));
        }
        else 
            return null;
    }
}
