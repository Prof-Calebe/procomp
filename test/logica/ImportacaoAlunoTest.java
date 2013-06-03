/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Adriano
 */
public class ImportacaoAlunoTest {

    @Test
    public void testImportarNull() {
        String file = "";
        assertFalse(ImportacaoAluno.importar(file));
    }

    @Test
    public void testGetDisciplina() {
        int id = -1;
        assertNull(ImportacaoAluno.getAluno(id));
    }
    
    @Test
    public void testImportarTrue(){
        boolean b = ImportacaoAluno.importar("aluno.xml");
        assertTrue(b);
    }
}