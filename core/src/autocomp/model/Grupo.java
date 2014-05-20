/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.model;

/**
 *
 * @author 31032109
 */
public enum Grupo{
    
    ADMINISTRADOR(true, true, true, true, true, true, true, true),
    EDITOR(false, false, false, false, false, false, true, true),
    PROFESSOR(false, false, false, true, true, true, false, false),
    COORDENADOR(false, false, false, true, true, true, false, true),
    ALUNO(false, false, false, false, false, false, false, false);
    
    private boolean importarAlunos;
    private boolean importarProfessores;
    private boolean cadastrarUsuario;
    private boolean cadastrarQuestao;
    private boolean alterarQuestao;
    private boolean consultarQuestao;
    private boolean gerarProva;
    private boolean configurarProva;

    private Grupo(
            boolean importarAlunos, 
            boolean importarProfessores, 
            boolean cadastrarUsuario, 
            boolean cadastrarQuestao,
            boolean alterarQuestao,
            boolean consultarQuestao,
            boolean gerarProva,
            boolean configurarProva)
    {
        this.importarAlunos = importarAlunos;
        this.importarProfessores = importarProfessores;
        this.cadastrarUsuario = cadastrarUsuario;
        this.cadastrarQuestao = cadastrarQuestao;
        this.alterarQuestao = alterarQuestao;
        this.consultarQuestao = consultarQuestao;
        this.gerarProva = gerarProva;
        this.configurarProva = configurarProva;
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

    public boolean isCadastrarQuestao() {
        return cadastrarQuestao;
    }

    public boolean isAlterarQuestao() {
        return alterarQuestao;
    }

    public boolean isConsultarQuestao() {
        return consultarQuestao;
    }

    public boolean isGerarProva() {
        return gerarProva;
    }

    public boolean isConfigurarProva() {
        return configurarProva;
    }

}
