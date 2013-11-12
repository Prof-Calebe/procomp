/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import autocomp.controller.Questoes;
import autocomp.controller.UsuarioController;
import autocomp.controller.ImportacaoProf;
import autocomp.model.Usuario;
import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author adriano
 */
public class QuestoesTest extends TestCase{

    @Override
    protected void setUp() throws Exception {
        Questoes questoes = new Questoes();
        UsuarioController login = new UsuarioController();
        ImportacaoProf.importar("prof.xml");
        questoes.adicionar(1, "Direito é...", "Lado da rua", "Contrario de errado", "Materia",
                "Todas as anteriores", "Nenhuma das anteriores", 4, 0, new Usuario(),ImportacaoProf.getDisciplina(3));
    }
    
    @Test
    public void testGetQuestao(){
        int id = 0;
        Questoes questoes = new Questoes();
        assertNull(questoes.getQuestao(id));
    }
    
    @Test
    public void testGetQuestao1(){
        int id = 1;
        Questoes questoes = new Questoes();
        assertNotNull(questoes.getQuestao(id));
    }
    
    @Test 
    public void testDuplicadaQuestao(){
        Questoes questoes = new Questoes();
        UsuarioController login = new UsuarioController();
        ImportacaoProf.importar("prof.xml");
        boolean b = questoes.adicionar(1, "Direito é...", "Lado da rua", "Contrario de errado", "Materia",
                "Todas as anteriores", "Nenhuma das anteriores", 4, 0, new Usuario(),ImportacaoProf.getDisciplina(3));
        assertFalse(b);
    }
    
    @Test 
    public void testAlteraQuestao(){
        Questoes questoes = new Questoes();
        UsuarioController login = new UsuarioController();
        ImportacaoProf.importar("prof.xml");
        boolean b = questoes.update(1, "Direito é?", "Lado da rua", "Contrario de errado", "Materia",
                "Todas as anteriores", "Nenhuma das anteriores", 4, 0, new Usuario(),ImportacaoProf.getDisciplina(3));
        assertTrue(b);
    }
}