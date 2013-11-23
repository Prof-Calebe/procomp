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
    private String codigo;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private int semestre;
    
    @ManyToOne(optional = false)
    @AccessType("field")
    private Curso curso;
    
    @ManyToOne(optional = false)
    @AccessType("field")
    private Usuario professor;

    public Disciplina(){
        
    }
    
    public Disciplina(String codigo, String nome, int semestre, Curso curso, Usuario professor){
        this.codigo = codigo;
        this.nome = nome;
        this.semestre = semestre;
        this.curso = curso;
        this.professor = professor;   
    }
    
    public int getDisciplinaId() {
        return disciplinaId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
}
