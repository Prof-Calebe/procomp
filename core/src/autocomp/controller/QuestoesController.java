/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.controller;

import autocomp.dao.QuestaoDAO;
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
public final class QuestoesController implements Serializable{
    
    QuestaoDAO dao = new QuestaoDAO();
    
    
    
    public int novaQuestao(){
        try{
          return dao.getAll().size();
        }
        catch(Exception e){
            return -1;
        }
    }
    
    public Questao getQuestao(int id){
        Questao questao = null;
        try{
            id -= 1;
            questao = (Questao) dao.getById(id);
        }
        catch(Exception e){
            return null;
        }
        return questao;
    }
    
    public boolean adicionar(int id, String enunciado, String alternativa1,String alternativa2, 
            String alternativa3, String alternativa4, String alternativa5,
            int alternativaCorreta, Questao.QuestaoDificuldade dificuldade, Usuario responsavel, Disciplina disciplina){
        Questao questao;
        try{
            questao = new Questao( enunciado, alternativa1, alternativa2, 
                    alternativa3, alternativa4, alternativa5, alternativaCorreta, dificuldade, 
                        responsavel, disciplina);
            dao.persist(questao);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    
    public boolean update(Questao questao){

        try{
            dao.update(questao);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    
  
}
