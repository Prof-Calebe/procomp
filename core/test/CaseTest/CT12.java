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

import autocomp.controller.AlunoController;
import autocomp.controller.CursosController;
import autocomp.controller.DisciplinaController;
import autocomp.controller.UsuarioController;
import autocomp.dao.DisciplinaDAO;
import autocomp.model.Curso;
import autocomp.model.Disciplina;
import autocomp.model.Grupo;
import autocomp.model.Usuario;
import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DisciplinaController.class})
public class CT12 {
    
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
    public void ImportarValido() throws Exception {

        disciplinaMock.persist(EasyMock.anyObject(Disciplina.class));
        EasyMock.expectLastCall().anyTimes();

        String codCurso = "CC";
        String tiaProf = "31041949";
        Usuario professor = new Usuario(tiaProf, "123456", "Professor", Grupo.PROFESSOR);
        Curso curso = new Curso(codCurso, "Ciencia da computacao", 8, professor);

        EasyMock.expect(cursoMock.getByCodigo(codCurso)).andReturn(curso);
        
        EasyMock.expect(usuarioMock.pesquisar(tiaProf)).andReturn(professor);

        applyMockReplay();

        DisciplinaController tested = new DisciplinaController();

        Assert.assertTrue(tested.importar("prof.xml"));

        PowerMock.verifyAll();
    }
}

