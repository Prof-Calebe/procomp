/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.entidades;

/**
 *
 * @author 31032109
 */
public class Disciplina {
    
    private int id;
    private String nome;
    private GradeCurso gradeCurso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GradeCurso getGradeCurso() {
        return gradeCurso;
    }

    public void setGradeCurso(GradeCurso gradeCurso) {
        this.gradeCurso = gradeCurso;
    }
    
}
