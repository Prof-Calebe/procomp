/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.controller;

import autocomp.model.Aluno;
import autocomp.model.Curso;
import autocomp.model.Disciplina;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import autocomp.dao.AlunoDAO;
import java.util.List;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author adriano
 */
public class AlunoController implements Serializable{
    
    AlunoDAO dao = new AlunoDAO();
    
    
    public List<Aluno> procurarAluno(String nome){
       List<Aluno> listaAlunos = dao.getByNome(nome);
       return listaAlunos;
    }

    public  Aluno getAluno(int id){
        Aluno aluno = dao.getById(id);
        if(aluno==null){
            throw new IllegalArgumentException("Não foram encontrados alunos para o id "+ id);         
        }
        return aluno;
            
    }

}
