/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CaseTest;

import autocomp.controller.QuestoesController;
import autocomp.dao.QuestaoDAO;
import autocomp.dao.UsuarioDAO;
import autocomp.model.Curso;
import autocomp.model.Disciplina;
import autocomp.model.Grupo;
import autocomp.model.Questao;
import autocomp.model.Usuario;
import java.util.List;
import org.easymock.EasyMock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author Douglas
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({QuestoesController.class})
public class CT05 {
    QuestaoDAO questaoDaoMock;
    QuestoesController questoesMock;
    @Before
    public void setup() throws Exception {
        questaoDaoMock = PowerMock.createMock(QuestaoDAO.class);
        PowerMock.expectNew(QuestaoDAO.class).andReturn(questaoDaoMock);
    }

    public void applyMockReplay() {
        PowerMock.replay(questaoDaoMock, QuestaoDAO.class);
    }
    
    @Test
    public void CSU02FP_01(){
        Questao q = new Questao("De acordo com a lei 000 a pessoa pode?", "Pular", "Correr", "Ficar Parada", "Pedir Ajuda", "NDA", 04, Questao.QuestaoDificuldade.FACIL, new Usuario(), new Disciplina());
        //Preparação
        EasyMock.anyObject();
        EasyMock.expect(questaoDaoMock.add(q)).andReturn(Boolean.TRUE);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController m = new QuestoesController();
        boolean result = m.adicionar("De acordo com a lei 000 a pessoa pode?", "Pular", "Correr", "Ficar Parada", "Pedir Ajuda", "NDA", 04, Questao.QuestaoDificuldade.FACIL, new Usuario(), new Disciplina());
        //Check
        assertEquals(true, result);
    }
    @Test
    public void CSU02FP_02(){
        Questao q = new Questao("Direito é?", "Lado da rua", "Contrário de errado", "Matéria", "Todas as alternativas", "NDA", 04, Questao.QuestaoDificuldade.FACIL, new Usuario(), new Disciplina());
        //Preparação
        EasyMock.anyObject();
        EasyMock.expect(questaoDaoMock.add(q)).andReturn(Boolean.TRUE);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController m = new QuestoesController();
        boolean result = m.adicionar("Direito é?", "Lado da rua", "Contrário de errado", "Matéria", "Todas as alternativas", "NDA", 04, Questao.QuestaoDificuldade.FACIL, new Usuario(), new Disciplina());
        //Check
        assertEquals(true, result);
    }
    @Test
    public void CSU02FP_03(){
        Questao q = new Questao("1+1 = ?", "2", "99", "43128", "2.5", "1.3", 1, Questao.QuestaoDificuldade.FACIL, new Usuario(), new Disciplina());
        //Preparação
        EasyMock.anyObject();
        EasyMock.expect(questaoDaoMock.add(q)).andReturn(Boolean.TRUE);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController m = new QuestoesController();
        boolean result = m.adicionar("1+1 = ?", "2", "99", "43128", "2.5", "1.3", 04, Questao.QuestaoDificuldade.FACIL, new Usuario(), new Disciplina());
        //Check
        assertEquals(true, result);
    }
    @Test
    public void CSU02FP_04(){
        Questao q = new Questao("Qual o comando de impressão do Java?", "imprima", "System.out.print", "printf", "prt", ">>", 02, Questao.QuestaoDificuldade.FACIL, new Usuario(), new Disciplina());
        //Preparação
        EasyMock.anyObject();
        EasyMock.expect(questaoDaoMock.add(q)).andReturn(Boolean.TRUE);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController m = new QuestoesController();
        boolean result = m.adicionar("Qual o comando de impressão do Java?", "imprima", "System.out.print", "printf", "prt", ">>", 02, Questao.QuestaoDificuldade.FACIL, new Usuario(), new Disciplina());
        //Check
        assertEquals(true, result);
    }
    @Test
    public void CSU02FP_05(){
        Questao q = new Questao("Numero do prédio do FCI", "100", "43", "14", "não tem prédio", "NDA", 03, Questao.QuestaoDificuldade.FACIL, new Usuario(), new Disciplina());
        //Preparação
        EasyMock.anyObject();
        EasyMock.expect(questaoDaoMock.add(q)).andReturn(Boolean.TRUE);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController m = new QuestoesController();
        boolean result = m.adicionar("Numero do prédio do FCI", "100", "43", "14", "não tem prédio", "NDA", 03, Questao.QuestaoDificuldade.FACIL, new Usuario(), new Disciplina());
        //Check
        assertEquals(true, result);
    }
}
