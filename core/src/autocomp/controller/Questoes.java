/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.controller;

import autocomp.model.Disciplina;
import autocomp.model.Questao;
import autocomp.model.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author adriano
 */
public final class Questoes implements Serializable{
    
    private static ArrayList questoes;
    
    public Questoes(){
       if(!carregar()){
            questoes = new ArrayList();
        }
    }
    
    public int novaQuestao(){
        try{
            return questoes.size()+1;
        }
        catch(Exception e){
            return -1;
        }
    }
    
    public Questao getQuestao(int id){
        Questao questao = null;
        try{
            id -= 1;
            questao = (Questao) questoes.get(id);
        }
        catch(Exception e){
            return null;
        }
        return questao;
    }
    
    public boolean adicionar(int id, String enunciado, String alternativa1,String alternativa2, 
            String alternativa3, String alternativa4, String alternativa5,
            int alternativaCorreta, int dificuldade, Usuario responsavel, Disciplina disciplina){
        Questao questao;
        if(this.getQuestao(id) != null)
            return false;
        try{
            //questao = new Questao(id, enunciado, alternativa1, alternativa2, 
            //        alternativa3, alternativa4, alternativa5, alternativaCorreta, dificuldade, 
            //            responsavel, disciplina);
            questoes.add(new Questao());
            salvar();
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    
    public boolean update(int id, String enunciado, String alternativa1,String alternativa2, 
            String alternativa3, String alternativa4, String alternativa5,
            int alternativaCorreta, int dificuldade, Usuario responsavel, Disciplina disciplina){
        Questao questao = new Questao();
        try{
            //questao = new Questao(id, enunciado, alternativa1, alternativa2, 
            //        alternativa3, alternativa4, alternativa5, alternativaCorreta, dificuldade, 
            //            responsavel, disciplina);
            questoes.set(id - 1, questao);
            salvar();
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    
        public boolean salvar(){
        FileOutputStream arquivo = null;
        ObjectOutputStream out = null;
        try{
            arquivo = new FileOutputStream("questoes");
            out = new ObjectOutputStream(arquivo);
            out.writeObject(questoes);
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
    
    public boolean carregar(){
        FileInputStream arquivo = null;
        ObjectInputStream in = null;   
        try{
            arquivo = new FileInputStream("questoes");
            in = new ObjectInputStream(arquivo);
            questoes = (ArrayList) in.readObject();
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
