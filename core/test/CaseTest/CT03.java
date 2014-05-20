/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CaseTest;

import autocomp.controller.QuestoesController;
import autocomp.controller.UsuarioController;
import autocomp.dao.QuestaoDAO;
import autocomp.dao.UsuarioDAO;
import autocomp.model.Questao;
import org.easymock.EasyMock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
public class CT03 {
    
    QuestaoDAO questaoDaoMock;
    
    @Before
    public void setup() throws Exception {
        questaoDaoMock = PowerMock.createMock(QuestaoDAO.class);
        PowerMock.expectNew(QuestaoDAO.class).andReturn(questaoDaoMock);
    }

    public void applyMockReplay() {
        PowerMock.replay(questaoDaoMock, UsuarioDAO.class);
    }
    
    @Test
    public void CSU03FP_01()
    {
        //Preparação
        int id = 1234;
        Questao questao = new Questao(null, null, null, null, null, null, id, Questao.QuestaoDificuldade.FACIL, null, null);
        EasyMock.expect(questaoDaoMock.getById(id)).andReturn(questao);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController questoes = new QuestoesController();
        Questao result = questoes.getQuestao(id);
        //Check
        assertEquals(questao,result);
    }
}
