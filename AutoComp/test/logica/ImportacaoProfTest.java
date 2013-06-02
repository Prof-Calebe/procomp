/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adriano
 */
public class ImportacaoProfTest {
    
    @Test
    public void testImportarNull() {
        String file = "";
        assertFalse(ImportacaoProf.importar(file));
    }

    @Test
    public void testGetDisciplina() {
        int id = -1;
        assertNull(ImportacaoProf.getDisciplina(id));
    }
    
    @Test
    public void testImportarTrue(){
        boolean b = ImportacaoProf.importar("prof.xml");
        assertTrue(b);
    }
}