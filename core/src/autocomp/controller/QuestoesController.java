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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author adriano
 */
public class QuestoesController implements Serializable {

    private QuestaoDAO questaoDAO;

    public QuestoesController() {
        questaoDAO = new QuestaoDAO();
    }

    public int novaQuestao() {
        try {
            return questaoDAO.getAll().size();
        } catch (Exception e) {
            return -1;
        }
    }

    public List<Questao> getAll() {
        return questaoDAO.getAll();
    }

    public Questao getQuestao(int id) {
        Questao questao = null;
        try {

            questao = (Questao) questaoDAO.getById(id);
        } catch (Exception e) {
            return null;
        }
        return questao;
    }

    public List<Questao> getByParam(Questao questao) {
        List<Questao> list = new LinkedList<Questao>();
        try {
            list = questaoDAO.getByParam(questao);
        } catch (Exception e) {
            return null;
        }
        return list;
    }

    public boolean adicionar(String enunciado, String alternativa1, String alternativa2,
            String alternativa3, String alternativa4, String alternativa5,
            int alternativaCorreta, Questao.QuestaoDificuldade dificuldade, Usuario responsavel, Disciplina disciplina) {
        Questao questao;
        questao = new Questao(enunciado, alternativa1, alternativa2,
                alternativa3, alternativa4, alternativa5, alternativaCorreta, dificuldade,
                responsavel, disciplina);
        return questaoDAO.add(questao);
    }

    public boolean update(Questao questao) {

        return questaoDAO.updateQuestao(questao);

    }

}
