/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.entidades;

import java.util.List;

/**
 *
 * @author 31032109
 */
public class Aluno {
    
    private int id;
    private String tia;
    private String nome;
    private Curso curso;
    private List<TurmaDisciplina> turmasDisciplinas;
    private List<Prova> provas;

    public List<TurmaDisciplina> getTurmasDisciplinas() {
        return turmasDisciplinas;
    }

    public void setTurmasDisciplinas(List<TurmaDisciplina> turmasDisciplinas) {
        this.turmasDisciplinas = turmasDisciplinas;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
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

    public void setGradeCurso(Curso curso) {
        this.curso = curso;
    }
}
