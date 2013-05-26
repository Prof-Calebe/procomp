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
public class ImportacaoTest {
    
    @Test
    public void testImportar() {
        String file = "";
        assertFalse(Importacao.importar(file));
    }

    @Test
    public void testGetDisciplina() {
        int id = -1;
        assertNull(Importacao.getDisciplina(id));
    }
}