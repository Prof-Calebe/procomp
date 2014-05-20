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
public class CT10 {

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
    public void CSU05FP_01() {

        alunoMock.persist(EasyMock.anyObject(Aluno.class));
        EasyMock.expectLastCall().anyTimes();

        String codCurso = "CC";
        Usuario coordenador = new Usuario("12345678", "123456", "Coordenador", Grupo.COORDENADOR);
        Curso curso = new Curso(codCurso, "Ciencia da computacao", 8, coordenador);

        EasyMock.expect(cursoMock.getByCodigo(codCurso)).andReturn(curso);

        String codDisc = "DIR";
        Disciplina disciplina = new Disciplina(codDisc, "Direito para computação", 7, curso, coordenador);

        EasyMock.expect(disciplinaMock.getByCodigo(codDisc)).andReturn(disciplina);

        applyMockReplay();

        AlunoController tested = new AlunoController();

        Assert.assertTrue(tested.importar("aluno.xml"));

        PowerMock.verifyAll();
    }
}
