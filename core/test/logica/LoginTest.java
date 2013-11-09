/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import autocomp.controller.Login;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author adriano
 */
public class LoginTest {
    

    @Test
    public void AdicionarDuplicadoTeste() {
        String tia = "31088211";
        String senha = "123";
        int grupo = 3;
        Login l = new Login();
        l.adicionar(tia, senha, grupo);
        Assert.assertFalse(l.adicionar(tia,senha,grupo));
    }
    
    @Test
    public void AutenticaErrado(){
        String tia = "31088211";
        String senha = "123";
        int grupo = 1;  
        Login l = new Login();
        l.adicionar(tia, senha, grupo);
        senha = "321";
        Assert.assertFalse(l.autenticar(tia, senha));
    }
    
    @Test
    public void AutenticaCerto(){
        String tia = "31088211";
        String senha = "123";
        int grupo = 1;  
        Login l = new Login();
        l.adicionar(tia, senha, grupo);
        Assert.assertTrue(l.autenticar(tia, senha));
    }
    
    @Test
    public void SalvaUsuarios(){
        String tia = "31088211";
        String senha = "123";
        Login l = new Login();
        l.adicionar(tia, senha, 3);
        Login l2 = new Login();
        Assert.assertTrue(l2.autenticar(tia, senha));
    }
}