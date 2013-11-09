/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author 31032109
 */
@Entity
public class Questao implements DomainObject, Serializable{
    
    public enum QuestaoDificuldade {
        FACIL("Fácil"), MEDIO("Médio"), DIFICIL("Difícil");
        
        private String text;
        
        private QuestaoDificuldade(String text){
            this.text = text;
        }
        
        public String getText(){
            return this.text;
        }
    }
    
    @Id
    @GeneratedValue
    private int questaoId;
    
    @Column(nullable = false)
    private String enunciado;
    
    @Column(nullable = false)
    private String alternativa1;
    
    @Column(nullable = false)
    private String alternativa2;
    
    @Column(nullable = false)
    private String alternativa3;
    
    @Column(nullable = false)
    private String alternativa4;
    
    @Column(nullable = false)
    private String alternativa5;
    
    @Column(nullable = false)
    private int alternativaCorreta;
    
    @Enumerated(EnumType.STRING)
    private QuestaoDificuldade dificuldade;
    
    @ManyToOne
    private Usuario responsavel;
    
    @ManyToOne
    private Disciplina disciplina;

    public Questao(){
        
    }
    
    public Questao(
            String enunciado, 
            String alternativa1, 
            String alternativa2, 
            String alternativa3, 
            String alternativa4, 
            String alternativa5, 
            int alternativaCorreta, 
            QuestaoDificuldade dificuldade, 
            Usuario responsavel, 
            Disciplina disciplina) 
    {
        this.enunciado = enunciado;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.alternativa3 = alternativa3;
        this.alternativa4 = alternativa4;
        this.alternativa5 = alternativa5;
        this.alternativaCorreta = alternativaCorreta;
        this.dificuldade = dificuldade;
        this.responsavel = responsavel;
        this.disciplina = disciplina;
    }

    public int getId() {
        return questaoId;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getAlternativa1() {
        return alternativa1;
    }

    public void setAlternativa1(String alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public String getAlternativa2() {
        return alternativa2;
    }

    public void setAlternativa2(String alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public String getAlternativa3() {
        return alternativa3;
    }

    public void setAlternativa3(String alternativa3) {
        this.alternativa3 = alternativa3;
    }

    public String getAlternativa4() {
        return alternativa4;
    }

    public void setAlternativa4(String alternativa4) {
        this.alternativa4 = alternativa4;
    }

    public String getAlternativa5() {
        return alternativa5;
    }

    public void setAlternativa5(String alternativa5) {
        this.alternativa5 = alternativa5;
    }

    public int getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(int alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }    

    public QuestaoDificuldade getDificuldade() {
        return dificuldade;
    }

    public String getDificuldadeText() {
        return dificuldade.getText();
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
