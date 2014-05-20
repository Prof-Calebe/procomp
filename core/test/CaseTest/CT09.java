/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CaseTest;

import autocomp.controller.QuestoesController;
import autocomp.dao.QuestaoDAO;
import autocomp.model.Curso;
import autocomp.model.Disciplina;
import autocomp.model.Questao;
import autocomp.model.Usuario;
import org.easymock.EasyMock;
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
public class CT09 {
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
    public void CSU04FE01_01()
    {
        Questao q = new Questao("", "", "", "", "", "", 04, Questao.QuestaoDificuldade.DIFICIL, null, new Disciplina("01", "Direito", 00, new Curso(), new Usuario()));
        //Preparação
        EasyMock.anyObject();
        EasyMock.expect(questaoDaoMock.updateQuestao(q)).andReturn(Boolean.TRUE);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController m = new QuestoesController();
        boolean result = m.update(q);
        //Check
        assertEquals(false, result);
    }
    
    @Test
    public void CSU04FE01_02()
    {
        Questao q = new Questao("Direito é?", "", "", "", "", "", 04, Questao.QuestaoDificuldade.DIFICIL, null, null);
        //Preparação
        EasyMock.anyObject();
        EasyMock.expect(questaoDaoMock.updateQuestao(q)).andReturn(Boolean.TRUE);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController m = new QuestoesController();
        boolean result = m.update(q);
        //Check
        assertEquals(false, result);
    }
    
    @Test
    public void CSU04FE01_03()
    {
        Questao q = new Questao("blah", "", "", "", "", "", 04, null, null, new Disciplina("01", "Direito", 00, new Curso(), new Usuario()));
        //Preparação
        EasyMock.anyObject();
        EasyMock.expect(questaoDaoMock.updateQuestao(q)).andReturn(Boolean.TRUE);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController m = new QuestoesController();
        boolean result = m.update(q);
        //Check
        assertEquals(false, result);
    }
}
