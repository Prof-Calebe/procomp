/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.AccessType;

/**
 *
 * @author 31032109
 */
@Entity
public class Disciplina implements DomainObject, Serializable{
    
    @Id
    @GeneratedValue
    private int disciplinaId;
    
    @Column(nullable = false)
    private String nome;
    
    @ManyToOne(optional = false)
    @AccessType("field")
    private Curso curso;
    
    @ManyToOne(optional = false)
    @AccessType("field")
    private Usuario professor;

    public Disciplina(){
        
    }
    
    public Disciplina(String nome,Curso curso, Usuario professor){
        this.nome = nome;
        this.curso = curso;
        this.professor = professor;   
    }
    
    public int getDisciplinaId() {
        return disciplinaId;
    }
    
    public Usuario getProfessor() {
        return professor;
    }

    public void setProfessor(Usuario professor) {
        this.professor = professor;
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
