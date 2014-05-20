/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import autocomp.controller.CursosController;
import autocomp.dao.CursoDAO;
import autocomp.model.Curso;
import autocomp.model.Grupo;
import autocomp.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({CursosController.class})
public class CursosTest {
     
    @Test
    public void ValidaCurso() throws Exception{
     
        CursoDAO controllerMock = PowerMock.createMock(CursoDAO.class);
        PowerMock.expectNew(CursoDAO.class).andReturn(controllerMock);
        
        String codigo = "CC";
        String nome = "Ciencia da Computacao";
        int semeste = 7;
        Usuario usuario = new Usuario("3101111", "123", "TT", Grupo.COORDENADOR);
        Curso curso = new Curso(codigo, nome, semeste, usuario);
        
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(curso);
        
        EasyMock.expect(controllerMock.getByNome(nome)).andReturn(cursos);
        PowerMock.replay(controllerMock, CursoDAO.class);
        
        CursosController tested = new CursosController();
        List<Curso> result = tested.getCursosByName(nome);

        Assert.assertFalse(result.isEmpty());
               
        Assert.assertTrue(result.contains(curso));
       
        PowerMock.verifyAll();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void CursoInvalido() throws Exception{
     
        CursoDAO controllerMock = PowerMock.createMock(CursoDAO.class);
        PowerMock.expectNew(CursoDAO.class).andReturn(controllerMock);
        EasyMock.expect(controllerMock.getByNome(null)).andReturn(null);
        PowerMock.replay(controllerMock, CursoDAO.class);
       
        CursosController tested = new CursosController();
        List<Curso> result = tested.getCursosByName(null);

        PowerMock.verifyAll();
    }
    

}