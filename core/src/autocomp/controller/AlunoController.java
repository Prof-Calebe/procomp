/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.controller;

import autocomp.dao.AlunoDAO;
import autocomp.model.Aluno;
import autocomp.model.Curso;
import autocomp.model.Disciplina;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author adriano
 */
public class AlunoController implements Serializable{
    
    private AlunoDAO dao;
    private CursosController cursoController;
    private DisciplinaController disciplinaController;
    
    public AlunoController(){
        dao = new AlunoDAO();
        cursoController = new CursosController();
        disciplinaController = new DisciplinaController();
    }
    
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
    
    public boolean importar(String file){
        
        if(file == null || file.trim().isEmpty()){
            throw new IllegalArgumentException("Caminho invalido");
        }
        
        String nome, tia, grade, codCurso, codDisciplina;
        Disciplina disciplina;
        Curso curso = null;
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            //Passo 1: obter o elemento raiz
            Element raiz = doc.getDocumentElement();
            //Passo 2: localizar os elementos filhos da agenda
            NodeList listaAlunos = raiz.getElementsByTagName("aluno");
            //Passo 3: obter os elementos de cada elemento contato
            for (int k=0; k < listaAlunos.getLength(); k++){
                //como cada elemento do NodeList é um nó, precisamos fazer o cast
                Element aluno = (Element) listaAlunos.item(k);
                NodeList listaNomes = aluno.getElementsByTagName("nome");
                Node nomeXML = listaNomes.item(0).getFirstChild();
                nome = nomeXML.getNodeValue();
                NodeList listaTias = aluno.getElementsByTagName("tia");
                Node tiaXML = listaTias.item(0).getFirstChild();
                tia = tiaXML.getNodeValue();
                NodeList listaCursos = aluno.getElementsByTagName("curso");
                Node cursoXML = listaCursos.item(0).getFirstChild();
                codCurso = cursoXML.getNodeValue();      
                NodeList listaGrades = aluno.getElementsByTagName("grade");
                Node gradeXML = listaGrades.item(0).getFirstChild();
                grade = gradeXML.getNodeValue();   
                
                NodeList listaDisciplinas = aluno.getElementsByTagName("disciplinas");
                for(int i = 0; i < listaDisciplinas.getLength();i++){
                    Element disciplin = (Element) listaDisciplinas.item(i);
                    NodeList listaDisciplin = disciplin.getElementsByTagName("codigo");
                    ArrayList disciplinas = new ArrayList();
                    for(int j = 0; j< listaDisciplin.getLength(); j++){
                        Node disciplinXML = listaDisciplin.item(j).getFirstChild();
                        codDisciplina = disciplinXML.getNodeValue();                  
                        curso = cursoController.getByCodigo(codCurso);
                        disciplina = disciplinaController.getByCodigo(codDisciplina);
                        disciplinas.add(disciplina);
                    }
                    Aluno alun = new Aluno(tia, nome, curso, disciplinas);
                    dao.persist(alun);
                }
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

}
