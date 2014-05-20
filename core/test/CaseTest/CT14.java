/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaseTest;

import autocomp.controller.CursosController;
import autocomp.controller.UsuarioController;
import autocomp.dao.DisciplinaDAO;
import autocomp.dao.UsuarioDAO;
import autocomp.model.Grupo;
import autocomp.model.Usuario;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author Douglas
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UsuarioController.class})
public class CT14 {

    UsuarioController usuarioMock;
    UsuarioDAO usuarioDAOMock;

    @Before
    public void setup() throws Exception {
        //usuarioMock = PowerMock.createMock(UsuarioController.class);
        //PowerMock.expectNew(UsuarioController.class).andReturn(usuarioMock);

        usuarioDAOMock = PowerMock.createMock(UsuarioDAO.class);
        PowerMock.expectNew(UsuarioDAO.class).andReturn(usuarioDAOMock);
    }

    public void applyMockReplay() {
        //PowerMock.replay(usuarioMock, UsuarioController.class);
        PowerMock.replay(usuarioDAOMock, UsuarioDAO.class);
    }

    @Test
    public void CSU07FP_01() {

        String tia = "31041949";
        Usuario usuario = new Usuario(tia, "123", "nome", Grupo.EDITOR);
        EasyMock.anyObject();
        EasyMock.expect(usuarioDAOMock.add(usuario)).andReturn(true);
        EasyMock.expect(usuarioDAOMock.getByTIA(tia)).andReturn(null);
        applyMockReplay();
        
        UsuarioController uc = new UsuarioController();
        Assert.assertTrue(uc.adicionar(usuario));
        PowerMock.verifyAll();
    }
    
    @Test
    public void CSU07FP_02() {

        String tia = "10000000";
        Usuario usuario = new Usuario(tia, "123", "nome", Grupo.ADMINISTRADOR);
        EasyMock.anyObject();
        EasyMock.expect(usuarioDAOMock.add(usuario)).andReturn(true);
        EasyMock.expect(usuarioDAOMock.getByTIA(tia)).andReturn(null);
        applyMockReplay();
        
        UsuarioController uc = new UsuarioController();
        Assert.assertTrue(uc.adicionar(usuario));
        PowerMock.verifyAll();
    }
    
    @Test
    public void CSU07FP_03() {

        String tia = "31032354";
        Usuario usuario = new Usuario(tia, "123", "nome", Grupo.PROFESSOR);
        EasyMock.anyObject();
        EasyMock.expect(usuarioDAOMock.add(usuario)).andReturn(true);
        EasyMock.expect(usuarioDAOMock.getByTIA(tia)).andReturn(null);
        applyMockReplay();
        
        UsuarioController uc = new UsuarioController();
        Assert.assertTrue(uc.adicionar(usuario));
        PowerMock.verifyAll();
    }
}
