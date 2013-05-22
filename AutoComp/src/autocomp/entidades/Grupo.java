/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.entidades;

/**
 *
 * @author 31032109
 */
public class Grupo {
    
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

    public boolean isCadastrarQuestao() {
        return cadastrarQuestao;
    }

    public void setCadastrarQuestao(boolean cadastrarQuestao) {
        this.cadastrarQuestao = cadastrarQuestao;
    }

    public boolean isConsultarQuestao() {
        return consultarQuestao;
    }

    public void setConsultarQuestao(boolean consultarQuestao) {
        this.consultarQuestao = consultarQuestao;
    }

    public boolean isEditarQuestao() {
        return editarQuestao;
    }

    public void setEditarQuestao(boolean editarQuestao) {
        this.editarQuestao = editarQuestao;
    }

    public boolean isImportarAlunos() {
        return importarAlunos;
    }

    public void setImportarAlunos(boolean importarAlunos) {
        this.importarAlunos = importarAlunos;
    }

    public boolean isImportarProfessores() {
        return importarProfessores;
    }

    public void setImportarProfessores(boolean importarProfessores) {
        this.importarProfessores = importarProfessores;
    }

    public boolean isCadastrarUsuario() {
        return cadastrarUsuario;
    }

    public void setCadastrarUsuario(boolean cadastrarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
    }

    public boolean isConfigurarProva() {
        return configurarProva;
    }

    public void setConfigurarProva(boolean configurarProva) {
        this.configurarProva = configurarProva;
    }

    public boolean isGerarProva() {
        return gerarProva;
    }

    public void setGerarProva(boolean gerarProva) {
        this.gerarProva = gerarProva;
    }
    
}
