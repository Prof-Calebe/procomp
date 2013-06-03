/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author adriano
 */
public class CursosTest {
    
    @Test
    public void testGetCurso_int() {
        int id = 0;
        Assert.assertNull(Cursos.getCurso(id));
    }

    @Test
    public void testGetCurso_String() {
        String s = null;
        Assert.assertNull(Cursos.getCurso(s));
    }
    
    @Test
    public void testGetCurso_CC_String(){
        String s = "Ciencia da Computacao";
        Assert.assertNotNull(Cursos.getCurso(s));
    }
    
    @Test
    public void testGetCurso_CC_Int(){
        int id = 1;
        Assert.assertNotNull(Cursos.getCurso(id));
    }
}