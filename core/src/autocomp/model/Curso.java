package autocomp.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.AccessType;

/**
 *
 * @author 31032109
 */
@Entity
public class Curso implements DomainObject, Serializable{
    
    @Id
    @GeneratedValue
    private int cursoId;
    
    @Column(nullable = false)
    private String codigo;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private int semestres;
    
    @ManyToOne(optional = false)
    @AccessType("field")
    private Usuario coordenador;
    
    public Curso(){
        
    }
    
    public Curso(String codigo, String nome, int semestres, Usuario coordenador){
        this.codigo = codigo;
        this.nome = nome;
        this.semestres = semestres;
        this.coordenador = coordenador;
    }

    public int getCursoId() {
        return cursoId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestres() {
        return semestres;
    }

    public void setSemestres(int semestres) {
        this.semestres = semestres;
    }

    public Usuario getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Usuario coordenador) {
        this.coordenador = coordenador;
    }
    
}
