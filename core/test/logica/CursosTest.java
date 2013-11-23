/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import autocomp.controller.CursosController;
import autocomp.controller.UsuarioController;
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

/**
 *
 * @author adriano
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({CursosController.class})
public class CursosTest {
     
    @Test
    public void ValidaCurso() throws Exception{
     
        // Cria o objeto Mock da classe ClasseExemploController
        CursoDAO controllerMock = PowerMock.createMock(CursoDAO.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(CursoDAO.class).andReturn(controllerMock);
        // E espera que a resposta pela chamada do método seja determinado
        String nome = "Ciencia da Computacao";
        int semeste = 7;
        Usuario usuario = new Usuario("3101111", "123", "TT", Grupo.COORDENADOR);
        Curso curso = new Curso(nome, semeste, usuario);
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(curso);
        EasyMock.expect(controllerMock.getByNome(nome)).andReturn(cursos);
        // "Executa" a configuração programada
        PowerMock.replay(controllerMock, CursoDAO.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        CursosController tested = new CursosController();
        List<Curso> result = tested.getCursosByName(nome);
        // Faz a verificaçao agendada
        Assert.assertFalse(result.isEmpty());
               
        Assert.assertTrue(result.contains(curso));
       
        // Executa todas as verificação
        PowerMock.verifyAll();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void CursoInvalido() throws Exception{
     
        // Cria o objeto Mock da classe ClasseExemploController
        CursoDAO controllerMock = PowerMock.createMock(CursoDAO.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(CursoDAO.class).andReturn(controllerMock);
        // E espera que a resposta pela chamada do método seja determinado
        EasyMock.expect(controllerMock.getByNome(null)).andReturn(null);
        // "Executa" a configuração programada
        PowerMock.replay(controllerMock, CursoDAO.class);
       
        // Chama a classe - internamente, a classe mockada será utilizada
        CursosController tested = new CursosController();
        List<Curso> result = tested.getCursosByName(null);
        // Executa todas as verificação
        PowerMock.verifyAll();
    }
    

}