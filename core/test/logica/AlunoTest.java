/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import autocomp.controller.AlunoController;
import autocomp.dao.AlunoDAO;
import autocomp.model.*;
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
 * @author Thabita
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AlunoController.class})
public class AlunoTest {
    
    @Test
    public void ProcuraAluno() throws Exception{
     
        // Cria o objeto Mock da classe ClasseExemploController
        AlunoDAO controllerMock = PowerMock.createMock(AlunoDAO.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(AlunoDAO.class).andReturn(controllerMock);
        // E espera que a resposta pela chamada do método seja determinado
        String tia = "123445";
        String nome = "nome";
        
        Usuario usuario = new Usuario("3101111", "123", "TT", Grupo.COORDENADOR);
        Curso curso = new Curso("Usuario", 7, usuario);
        
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        Aluno aluno = new Aluno(tia, nome, curso, disciplinas);
        
        List<Aluno> alunos = new ArrayList<Aluno>();
        alunos.add(aluno);
        EasyMock.expect(controllerMock.getByNome(nome)).andReturn(alunos);
        
        
        // "Executa" a configuração programada
        PowerMock.replay(controllerMock, AlunoDAO.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        AlunoController tested = new AlunoController();
        List<Aluno> result = tested.procurarAluno(nome);
        
        // Faz a verificaçao agendada
        Assert.assertFalse(result.isEmpty());
               
        Assert.assertTrue(result.contains(aluno));
       
        // Executa todas as verificação
        PowerMock.verifyAll();
       
        
        
    }
    
}
