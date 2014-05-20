package logica;

import autocomp.controller.UsuarioController;
import autocomp.dao.UsuarioDAO;
import autocomp.model.Grupo;
import autocomp.model.Usuario;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({UsuarioController.class})
public class UsuarioTest {
    
    @Test
    public void AutenticaCerto() throws Exception{
        
        UsuarioDAO controllerMock = PowerMock.createMock(UsuarioDAO.class);
        PowerMock.expectNew(UsuarioDAO.class).andReturn(controllerMock);

        String tia = "12345678";
        String senha = "123";
        Usuario usuario = new Usuario(tia, senha, "nome",Grupo.ADMINISTRADOR);

        EasyMock.expect(controllerMock.autenticar(tia, senha)).andReturn(usuario);
        PowerMock.replay(controllerMock, UsuarioDAO.class);
        
        UsuarioController tested = new UsuarioController();
        Usuario result = tested.autenticar(tia, senha);
        
        Assert.assertEquals(usuario, result);

        PowerMock.verifyAll();
    }
   
    @Test
    public void AutenticaErrado() throws Exception{
        
        UsuarioDAO controllerMock = PowerMock.createMock(UsuarioDAO.class);
        PowerMock.expectNew(UsuarioDAO.class).andReturn(controllerMock);

        String tia = "12345678";
        String senha = "123";
        Usuario usuario = new Usuario(tia, senha, "nome",Grupo.ADMINISTRADOR);
        Usuario usuario2 = new Usuario("87654", "987", "nome",Grupo.ADMINISTRADOR);

        EasyMock.expect(controllerMock.autenticar(tia, senha)).andReturn(usuario);
        PowerMock.replay(controllerMock, UsuarioDAO.class);
        
        UsuarioController tested = new UsuarioController();
        Usuario result = tested.autenticar(tia, senha);
        
        Assert.assertNotSame(result, usuario2);
            
        PowerMock.verifyAll();
    }
   
    
    @Test
    public void AdicionaCerto() throws Exception{
        
        UsuarioDAO controllerMock = PowerMock.createMock(UsuarioDAO.class);
        PowerMock.expectNew(UsuarioDAO.class).andReturn(controllerMock);

        String tia = "31041949";
        Usuario usuario = new Usuario(tia, "123456", "nome", Grupo.ADMINISTRADOR);

        controllerMock.save(usuario);
        EasyMock.expectLastCall().anyTimes();
        
        EasyMock.expect(controllerMock.getByTIA(tia)).andReturn(null);
        EasyMock.expect(controllerMock.getByTIA(tia)).andReturn(usuario);
        
        PowerMock.replay(controllerMock, UsuarioDAO.class);
        
        UsuarioController tested = new UsuarioController();
        tested.adicionar(usuario);

        Usuario result = tested.pesquisar(tia);
        
        Assert.assertEquals(usuario, result);

        PowerMock.verifyAll();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void AdicionaErrado() throws Exception{
        
        UsuarioDAO controllerMock = PowerMock.createMock(UsuarioDAO.class);
        PowerMock.expectNew(UsuarioDAO.class).andReturn(controllerMock);

        String tia = "31041949";
        Usuario usuario = new Usuario(tia, "123456", "nome", Grupo.ADMINISTRADOR);
 
        EasyMock.expect(controllerMock.getByTIA(tia)).andReturn(usuario);
        
        PowerMock.replay(controllerMock, UsuarioDAO.class);
        
        UsuarioController tested = new UsuarioController();
        tested.adicionar(usuario);
        PowerMock.verifyAll();
    }
  
   
    @Test(expected=IllegalArgumentException.class)
    public void AdicionarNulo() throws Exception{
        
        UsuarioDAO controllerMock = PowerMock.createMock(UsuarioDAO.class);
        PowerMock.expectNew(UsuarioDAO.class).andReturn(controllerMock);
        PowerMock.replay(controllerMock, UsuarioDAO.class);

        UsuarioController tested = new UsuarioController();
        tested.adicionar(null);
        
        PowerMock.verifyAll();

    }
}