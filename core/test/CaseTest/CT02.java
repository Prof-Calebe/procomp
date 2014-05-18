/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CaseTest;

import autocomp.controller.UsuarioController;
import autocomp.dao.UsuarioDAO;
import autocomp.model.Grupo;
import autocomp.model.Usuario;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author Douglas
 */
@RunWith(PowerMockRunner.class)
public class CT02 {
    
    UsuarioController usuarioControllerMock;
    UsuarioDAO usuarioDAOMock;
    String TIA;
    String Senha;
    
    @Before
    public void setup() throws Exception {
        usuarioDAOMock = PowerMock.createMock(UsuarioDAO.class);
        PowerMock.expectNew(UsuarioDAO.class).andReturn(usuarioDAOMock);

        usuarioControllerMock = PowerMock.createMock(UsuarioController.class);
        PowerMock.expectNew(UsuarioController.class).andReturn(usuarioControllerMock);
        
        TIA = "12345678";
        Senha = "123";
    }

    public void applyMockReplay() {
        PowerMock.replay(usuarioDAOMock, UsuarioDAO.class);
        PowerMock.replay(usuarioControllerMock, UsuarioDAO.class);
    }
    
    @Test
    public void CSU01FE01_01() {
        Usuario usuario = new Usuario(TIA, Senha, "nome",Grupo.ADMINISTRADOR);
        
        EasyMock.expect(usuarioControllerMock.autenticar("", "")).andReturn(null);
        applyMockReplay();
        
        Usuario result = usuarioControllerMock.autenticar("", "");
        
        Assert.assertNotSame(result, usuario);
            
    }

    @Test
    public void CSU01FE01_02() {
        Usuario usuario = new Usuario(TIA, Senha, "nome",Grupo.ADMINISTRADOR);
        
        EasyMock.expect(usuarioControllerMock.autenticar("", Senha)).andReturn(null);
        applyMockReplay();
        
        Usuario result = usuarioControllerMock.autenticar("", Senha);
        
        Assert.assertNotSame(result, usuario);
            
    }

    @Test
    public void CSU01FE01_03() {
        Usuario usuario = new Usuario(TIA, Senha, "nome",Grupo.ADMINISTRADOR);
        
        EasyMock.expect(usuarioControllerMock.autenticar(TIA, "")).andReturn(null);
        applyMockReplay();
        
        Usuario result = usuarioControllerMock.autenticar(TIA, "");
        
        Assert.assertNotSame(result, usuario);
            
    }
}
