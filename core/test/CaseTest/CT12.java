/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CaseTest;

import autocomp.controller.CursosController;
import autocomp.controller.DisciplinaController;
import autocomp.controller.UsuarioController;
import autocomp.dao.AlunoDAO;
import autocomp.dao.UsuarioDAO;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author Douglas
 */
@RunWith(PowerMockRunner.class)
public class CT12 {

    UsuarioController usuarioControllerMock;
    UsuarioDAO usuarioDAOMock;     
    
    @Before
    public void setup() throws Exception {
        usuarioDAOMock = PowerMock.createMock(UsuarioDAO.class);
        PowerMock.expectNew(UsuarioDAO.class).andReturn(usuarioDAOMock);        
        
        usuarioControllerMock = PowerMock.createMock(UsuarioController.class);
        PowerMock.expectNew(UsuarioController.class).andReturn(usuarioControllerMock);
    }
    
    
}
