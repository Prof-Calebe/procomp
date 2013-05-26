/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import autocomp.entidades.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author adriano
 */
public class Login implements Serializable{
   
    ArrayList usuarios;
    
    public Login(){
        carregar();
    }

    public boolean adicionar(String tia, String senha, int grupo) {
        Usuario user = new Usuario(tia,senha,grupo);
        if(pesquisar(tia))
            return false;
        usuarios.add(user);
        salvar();
        return true;
    }
    
    public boolean pesquisar(String tia){
        for (Iterator it = usuarios.iterator(); it.hasNext();) {
            Usuario s  = (Usuario) it.next();
            if(s.getTia().equals(tia))
                return true;
        }
        return false;
    }
    
    public boolean autenticar(String tia, String senha){
         for (Iterator it = usuarios.iterator(); it.hasNext();) {
            Usuario s  = (Usuario) it.next();
            if(s.getTia().equals(tia)&& s.getSenha().equals(senha))
                return true;
        }       
        return false;
    }
    
    private boolean salvar(){
        FileOutputStream arquivo = null;
        ObjectOutputStream out = null;
        try{
            arquivo = new FileOutputStream("usuarios");
            out = new ObjectOutputStream(arquivo);
            out.writeObject(usuarios);
        }
        catch(Exception e){
            return false;
        }
        finally{
            try{
                arquivo.close();
                out.close();
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
    }
    
    private boolean carregar(){
        FileInputStream arquivo = null;
        ObjectInputStream in = null;   
        try{
            arquivo = new FileInputStream("usuarios");
            in = new ObjectInputStream(arquivo);
            usuarios = (ArrayList) in.readObject();
        }
        catch(Exception e){
            return false;
        }
        finally{
            try{
                arquivo.close();
                in.close();
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
    }
}
