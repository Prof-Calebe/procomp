/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CaseTest;

/**
 *
 * @author Douglas
 */

import autocomp.controller.CursosController;
import autocomp.controller.DisciplinaController;
import autocomp.controller.UsuarioController;
import autocomp.dao.DisciplinaDAO;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DisciplinaController.class})
public class CT13 {
    
    DisciplinaDAO disciplinaMock;
    CursosController cursoMock;
    UsuarioController usuarioMock;

    @Before
    public void setup() throws Exception {
        disciplinaMock = PowerMock.createMock(DisciplinaDAO.class);
        PowerMock.expectNew(DisciplinaDAO.class).andReturn(disciplinaMock);

        cursoMock = PowerMock.createMock(CursosController.class);
        PowerMock.expectNew(CursosController.class).andReturn(cursoMock);

        usuarioMock = PowerMock.createMock(UsuarioController.class);
        PowerMock.expectNew(UsuarioController.class).andReturn(usuarioMock);
    }

    public void applyMockReplay() {
        PowerMock.replay(disciplinaMock, DisciplinaDAO.class);
        PowerMock.replay(cursoMock, CursosController.class);
        PowerMock.replay(usuarioMock, UsuarioController.class);
    }
    
    @Test
    public void ImportarInvalido() throws Exception {
        
        applyMockReplay();

        DisciplinaController tested = new DisciplinaController();

        Assert.assertFalse(tested.importar(null));

        PowerMock.verifyAll();
    }

}

