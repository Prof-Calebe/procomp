/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.entidades;

import java.util.ArrayList;

/**
 *
 * @author 31032109
 */
public class Aluno {
    
    private int id;
    private String tia;
    private String nome;
    private Curso curso;
    private ArrayList disciplinas;

    public Aluno(int id, String tia, String nome, 
            Curso curso, ArrayList disciplinas){
        this.id = id;
        this.tia = tia;
        this.nome = nome;
        this.curso = curso;
        this.disciplinas = disciplinas;
    }
    public ArrayList getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList disciplinas) {
        this.disciplinas = disciplinas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTia() {
        return tia;
    }

    public void setTia(String tia) {
        this.tia = tia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
