package autocomp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author 31032109
 */
@Entity
public class Prova implements DomainObject, Serializable {
    
    @Id
    @GeneratedValue
    private int provaId;
    
    @Column(nullable = false)
    private String nome;
 
    @Column(columnDefinition="TEXT")
    private String descricao;
    
    @Temporal(value = TemporalType.DATE)
    private Date dataCriacao;
    
    @Temporal(value = TemporalType.DATE)
    private Date dataAlteracao;
    
    @ManyToOne(optional = false)
    private Usuario responsavel;
    
    @OneToMany
    @JoinTable(
            name = "prova_questao", 
            joinColumns = @JoinColumn(name = "provaId"), 
            inverseJoinColumns = @JoinColumn(name = "questaoId"))
    private List<Questao> questoes;
    
    public Prova(){
        questoes = new ArrayList<Questao>();
    }

    public int getProvaId() {
        return provaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public List<Questao> getQuestoes() {
        return new ArrayList<Questao>(questoes);
    }

    public void setQuestoes(List<Questao> questoes) {
        if(questoes == null){
            questoes = new ArrayList<Questao>();
        }
        this.questoes.clear();
        this.questoes.addAll(questoes);
    }
}
