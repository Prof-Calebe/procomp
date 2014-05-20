/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import autocomp.controller.QuestoesController;
import autocomp.dao.QuestaoDAO;
import autocomp.model.Curso;
import autocomp.model.Disciplina;
import autocomp.model.Questao;
import autocomp.model.Usuario;
import org.easymock.EasyMock;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author adriano
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({QuestoesController.class})
public class QuestoesTest {

    @Test
    public void testGetQuestao() throws Exception{
         // Cria o objeto Mock da classe ClasseExemploController
        QuestaoDAO controlerMock = PowerMock.createMock(QuestaoDAO.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(QuestaoDAO.class).andReturn(controlerMock);
        // E espera que a resposta pela chamada do método seja determinado
        int id = 1234;
        Questao questao = new Questao(null, null, null, null, null, null, id, Questao.QuestaoDificuldade.FACIL, null, null);

        EasyMock.expect(controlerMock.getById(id)).andReturn(questao);
        // "Executa" a configuração programada
        PowerMock.replay( controlerMock,QuestaoDAO.class);
        QuestoesController questoes = new QuestoesController();
        Questao questao2 = questoes.getQuestao(id);
        assertNotNull(questao2);
        assertEquals(questao,questao2);
         PowerMock.verifyAll();
    }

    @Test 
    public void testAlteraQuestao() throws Exception{
        QuestaoDAO questaoDaoMock = PowerMock.createMock(QuestaoDAO.class);
        PowerMock.expectNew(QuestaoDAO.class).andReturn(questaoDaoMock);
        Questao q = new Questao("Direito é?", "", "", "", "", "", 04, Questao.QuestaoDificuldade.MEDIO, new Usuario(), new Disciplina("01", "Direito", 00, new Curso(), new Usuario()));
        //Preparação
        EasyMock.anyObject();
        EasyMock.expect(questaoDaoMock.updateQuestao(q)).andReturn(Boolean.TRUE);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController m = new QuestoesController();
        boolean result = m.update(q);
        //Check
        assertEquals(true, result);

    }
}