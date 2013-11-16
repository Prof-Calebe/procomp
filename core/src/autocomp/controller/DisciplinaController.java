/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.controller;

import autocomp.dao.DisciplinaDAO;
import autocomp.model.Curso;
import autocomp.model.Disciplina;
import autocomp.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author adriano
 */
public class DisciplinaController implements Serializable{
    
    DisciplinaDAO dao = new DisciplinaDAO();
    

    
    public  Disciplina getDisciplina(int id){
      Disciplina disciplina = dao.getById(id);
      if(disciplina == null){
          throw new IllegalArgumentException("Não existem disciplinas para esse id "+ id);
      }
      return disciplina;
    }
    
    public List<Disciplina> getDisciplina(String disc){
      List<Disciplina> disciplina = dao.getByNome(disc);
      if(disciplina == null || disciplina.isEmpty()){
          throw new IllegalArgumentException("Não existem disciplinas para esse nome "+ disc);
      }
      return disciplina;
    }
    
    public  List<Disciplina> getAll(){
       return dao.getAll();
    }
}
