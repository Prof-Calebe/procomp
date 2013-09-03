/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.entidades;

import java.io.Serializable;

/**
 *
 * @author 31032109
 */
public class Grupo implements Serializable{
    
    private int id;
    private String nome;
    private boolean cadastrarQuestao;
    private boolean consultarQuestao;
    private boolean editarQuestao;
    private boolean importarAlunos;
    private boolean importarProfessores;
    private boolean cadastrarUsuario;
    private boolean configurarProva;
    private boolean gerarProva;


    public Grupo(int id, String nome, boolean cadQues, boolean consulQues, 
            boolean editQues, boolean importAlu, boolean importProf, boolean cadUser,
                boolean configProva, boolean gerarProva){
        this.id = id;
        this.nome = nome;
        cadastrarQuestao = cadQues;
        consultarQuestao = consulQues;
        editarQuestao = editQues;
        importarAlunos = importAlu;
        importarProfessores = importProf;
        cadastrarUsuario = cadUser;
        configurarProva = configProva;
        this.gerarProva = gerarProva;
        
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isCadastrarQuestao() {
        return cadastrarQuestao;
    }

    public boolean isConsultarQuestao() {
        return consultarQuestao;
    }

    public boolean isEditarQuestao() {
        return editarQuestao;
    }

    public boolean isImportarAlunos() {
        return importarAlunos;
    }

    public boolean isImportarProfessores() {
        return importarProfessores;
    }

    public boolean isCadastrarUsuario() {
        return cadastrarUsuario;
    }

    public boolean isConfigurarProva() {
        return configurarProva;
    }

    public boolean isGerarProva() {
        return gerarProva;
    }    
}
