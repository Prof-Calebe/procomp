/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaseTest;

import autocomp.controller.AlunoController;
import autocomp.controller.CursosController;
import autocomp.controller.DisciplinaController;
import autocomp.dao.AlunoDAO;
import autocomp.model.Aluno;
import autocomp.model.Curso;
import autocomp.model.Disciplina;
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
@PrepareForTest({AlunoController.class})
public class CT11 {

    AlunoDAO alunoMock;
    CursosController cursoMock;
    DisciplinaController disciplinaMock;

    @Before
    public void setup() throws Exception {
        alunoMock = PowerMock.createMock(AlunoDAO.class);
        PowerMock.expectNew(AlunoDAO.class).andReturn(alunoMock);

        cursoMock = PowerMock.createMock(CursosController.class);
        PowerMock.expectNew(CursosController.class).andReturn(cursoMock);

        disciplinaMock = PowerMock.createMock(DisciplinaController.class);
        PowerMock.expectNew(DisciplinaController.class).andReturn(disciplinaMock);
    }

    public void applyMockReplay() {
        PowerMock.replay(alunoMock, AlunoDAO.class);
        PowerMock.replay(cursoMock, CursosController.class);
        PowerMock.replay(disciplinaMock, DisciplinaController.class);
    }

    @Test
    public void CSU05FE01_01() {

        applyMockReplay();

        AlunoController tested = new AlunoController();

        boolean result = tested.importar(null);
        Assert.assertFalse(result);
        PowerMock.verifyAll();
    }
}
