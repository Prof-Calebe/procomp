/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author adriano
 */
public class QuestoesTest {
    
    @Test
    public void testGetQuestao(){
        int id = 0;
        Questoes questoes = new Questoes();
        assertNull(questoes.getQuestao(id));
    }
}