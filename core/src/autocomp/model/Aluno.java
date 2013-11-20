package autocomp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.AccessType;

/**
 *
 * @author 31032109
 */
@Entity
public class Aluno implements DomainObject, Serializable {

    @Id
    @GeneratedValue
    private int alunoId;
    
    @Column(nullable = false, length = 8, unique = true)
    private String tia;
    
    @Column(nullable = false)
    private String nome;
    
    @ManyToOne
    @AccessType("field")
    private Curso curso;
    
    @OneToMany
    @JoinTable(
            name = "aluno_disciplina", 
            joinColumns = @JoinColumn(name = "alunoId"), 
            inverseJoinColumns = @JoinColumn(name = "disciplinaId"))
    private List<Disciplina> disciplinas;

    public Aluno() {
    }

    public Aluno(
            String tia, 
            String nome,
            Curso curso, 
            List<Disciplina> disciplinas) 
    {
        this.tia = tia;
        this.nome = nome;
        this.curso = curso;
        setDisciplinas(disciplinas);
    }

    public int getAlunoId() {
        return alunoId;
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
    
    public List<Disciplina> getDisciplinas() {
        return new ArrayList<Disciplina>(disciplinas);
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        if (this.disciplinas == null) {
            this.disciplinas = new ArrayList<Disciplina>();
        }
        this.disciplinas.clear();
        this.disciplinas.addAll(disciplinas);
    }
}
