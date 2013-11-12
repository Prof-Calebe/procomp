/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import autocomp.controller.UsuarioController;
import autocomp.dao.IUsuarioDAO;
import autocomp.dao.UsuarioDAO;
import autocomp.model.Grupo;
import autocomp.model.Usuario;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;

/**
 *
 * @author adriano
 */
public class LoginTest {
    

    @Test
    public void AdicionarDuplicadoTeste() {
//        String tia = "31088211";
//        String senha = "123";
//        String nome = "Teste";
//        Grupo grupo = Grupo.ADMINISTRADOR;
//        UsuarioController l = new UsuarioController();
//        l.adicionar(tia, senha, nome, grupo);
//        Assert.assertFalse(l.adicionar(tia,senha,nome,grupo));
    }
    
    @Test
    public void AutenticaErrado(){
//        String tia = "31088211";
//        String senha = "123";
//        String nome = "Teste";
//        Grupo grupo = Grupo.ADMINISTRADOR;
//        UsuarioController l = new UsuarioController();
//        l.adicionar(tia, senha, nome, grupo);
//        senha = "321";
//        Assert.assertFalse(l.autenticar(tia, senha));
    }
    
    @Test
    public void AutenticaCerto() throws Exception{
        
        // Cria o objeto Mock da classe ClasseExemploController
        UsuarioDAO controllerMock = PowerMock.createMock(UsuarioDAO.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(UsuarioDAO.class).andReturn(controllerMock);
        // E espera que a resposta pela chamada do método seja determinado
        String tia = "12345678";
        String senha = "123";
        Usuario usuario = new Usuario(tia, senha, "nome",Grupo.ADMINISTRADOR);

        EasyMock.expect(controllerMock.autenticar(tia, senha)).andReturn(usuario);
        // "Executa" a configuração programada
        PowerMock.replay(controllerMock, UsuarioDAO.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        UsuarioController tested = new UsuarioController();
        Usuario result = tested.autenticar(tia, senha);
        
        // Faz a verificaçao agendada
        Assert.assertEquals(usuario, result);
        // Executa todas as verificação
        PowerMock.verifyAll();
    }
    
    @Test
    public void SalvaUsuarios(){
//        String tia = "31088211";
//        String senha = "123";
//        String nome = "Teste";
//        Grupo grupo = Grupo.ADMINISTRADOR;
//        UsuarioController l = new UsuarioController();
//        l.adicionar(tia, senha, nome, grupo);
//        UsuarioController l2 = new UsuarioController();
//        Assert.assertTrue(l2.autenticar(tia, senha));
    }
}