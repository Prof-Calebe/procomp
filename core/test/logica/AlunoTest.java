package logica;

import autocomp.controller.AlunoController;
import autocomp.controller.CursosController;
import autocomp.controller.DisciplinaController;
import autocomp.dao.AlunoDAO;
import autocomp.model.*;
import java.util.ArrayList;
import java.util.List;
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
 * @author Thabita
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AlunoController.class})
public class AlunoTest {

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
    public void ProcuraAluno() throws Exception {

        String tia = "123445";
        String nome = "nome";
        Usuario usuario = new Usuario("3101111", "123", "TT", Grupo.COORDENADOR);
        Curso curso = new Curso("CC", "Ciencia da computação", 7, usuario);

        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        Aluno aluno = new Aluno(tia, nome, curso, disciplinas);

        List<Aluno> alunos = new ArrayList<Aluno>();
        alunos.add(aluno);
        EasyMock.expect(alunoMock.getByNome(nome)).andReturn(alunos);

        applyMockReplay();

        AlunoController tested = new AlunoController();
        List<Aluno> result = tested.procurarAluno(nome);

        Assert.assertFalse(result.isEmpty());

        Assert.assertTrue(result.contains(aluno));

        PowerMock.verifyAll();

    }

    @Test
    public void ImportarInvalido() throws Exception {

        applyMockReplay();

        AlunoController tested = new AlunoController();

        Assert.assertFalse(tested.importar(null));

        PowerMock.verifyAll();
    }

    @Test
    public void ImportarValido() throws Exception {

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
