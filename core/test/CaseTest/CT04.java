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
import java.util.LinkedList;
import java.util.List;
import org.easymock.EasyMock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
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
public class CT04 {
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
    public void CSU03FE01_01()
    {
        //Preparação
        Questao questao = new Questao(null, null, null, null, null, null, 00, null, null, null);
        EasyMock.expect(questaoDaoMock.getByParam(questao)).andReturn(null);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController questoes = new QuestoesController();
        List<Questao> result = questoes.getByParam(questao);
        //Check
        assertEquals(null,result);
    }
    
    @Test
    public void CSU03FE01_02()
    {
        //Preparação
        Questao questao = new Questao(null, null, null, null, null, null, 00, null, null, new Disciplina("01", "Reatores", 01, new Curso(), new Usuario()));
        EasyMock.expect(questaoDaoMock.getByParam(questao)).andReturn(null);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController questoes = new QuestoesController();
        List<Questao> result = questoes.getByParam(questao);
        //Check
        assertEquals(null,result);
    }
    
    @Test
    public void CSU03FE01_03()
    {
    //Preparação
        Questao questao = new Questao(null, null, null, null, null, null, 00, null,  new Usuario("Teste","0123", "Professor", Grupo.PROFESSOR), new Disciplina("01", "Reatores", 01, new Curso(), new Usuario()));
        EasyMock.expect(questaoDaoMock.getByParam(questao)).andReturn(null);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController questoes = new QuestoesController();
        List<Questao> result = questoes.getByParam(questao);
        //Check
        assertEquals(null,result);
    }
    
    @Test
    public void CSU03FE01_04()
    {
    //Preparação
        Questao questao = new Questao(null, null, null, null, null, null, 00, null, null, new Disciplina("01", "Matemagica", 01, new Curso(), new Usuario()));
        EasyMock.expect(questaoDaoMock.getByParam(questao)).andReturn(null);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController questoes = new QuestoesController();
        List<Questao> result = questoes.getByParam(questao);
        //Check
        assertEquals(null,result);
    }
    
    @Test
    public void CSU03FE01_05()
    {
    //Preparação
        Questao questao = new Questao(null, null, null, null, null, null, 00, null, new Usuario("Admin","0123", "Admin", Grupo.ADMINISTRADOR), null);
        EasyMock.expect(questaoDaoMock.getByParam(questao)).andReturn(null);
        PowerMock.replay(questaoDaoMock,QuestaoDAO.class);
        //Execução
        QuestoesController questoes = new QuestoesController();
        List<Questao> result = questoes.getByParam(questao);
        //Check
        assertEquals(null,result);
    }
    
}
