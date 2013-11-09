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
import static autocomp.controller.ImportacaoProf.getNomeDisciplinas;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author adriano
 */
public class ImportacaoAluno implements Serializable{
    
    private static ArrayList alunos;
    
    public static boolean isImported(){
        if(alunos == null)
            return false;
        return true;
    }
    
    private static int procurarAluno(String nome){
        int i = -1;
        for(Iterator it = alunos.iterator(); it.hasNext();){
            i++;
            Aluno alun = (Aluno) it.next();
            if(nome.equals(alun.getNome()))              
                return i;
        }
        return -1;
    }

    public static Aluno getAluno(int id){
        Aluno a;
        try{
            a = (Aluno) alunos.get(id);
            return a;
        }
        catch(Exception e){
            return null;
        }
    }
    public static String[] getNomeAlunos(){
        String[] nomes = {null};
        try{
            nomes = new String[alunos.size()];
            for(int i = 0; i < alunos.size(); i++){
                nomes[i] = getAluno(i).getNome();
            }
            return nomes;
        }
        catch(Exception e){
            return null;
        }
    }
    
    public static Aluno getAluno(String alun){
        Aluno a = null;       
        try{
            String[] nomes = getNomeDisciplinas();
            for(int i=0; i < nomes.length; i++){
                if(alun.equals(nomes[i]))
                    a = getAluno(i);
            }
            return a;
        }
        catch(Exception e){
            return null;
        }
    }
        
    public static boolean importar(String file){
        alunos = new ArrayList();
        int id;
        String nome, tia, grade, curso, disciplina;
        Disciplina d = null;
        Curso c = null;
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
                //Passo 4: obter o atributo id do contato
                Attr idXML = aluno.getAttributeNode("id");
                id = Integer.parseInt(idXML.getNodeValue());
                NodeList listaNomes = aluno.getElementsByTagName("nome");
                Node nomeXML = listaNomes.item(0).getFirstChild();
                nome = nomeXML.getNodeValue();
                NodeList listaTias = aluno.getElementsByTagName("tia");
                Node tiaXML = listaTias.item(0).getFirstChild();
                tia = tiaXML.getNodeValue();
                NodeList listaCursos = aluno.getElementsByTagName("curso");
                Node cursoXML = listaCursos.item(0).getFirstChild();
                curso = cursoXML.getNodeValue();      
                NodeList listaGrades = aluno.getElementsByTagName("grade");
                Node gradeXML = listaGrades.item(0).getFirstChild();
                grade = gradeXML.getNodeValue();   
                
                NodeList listaDisciplinas = aluno.getElementsByTagName("disciplinas");
                for(int i = 0; i < listaDisciplinas.getLength();i++){
                    Element disciplin = (Element) listaDisciplinas.item(i);
                    NodeList listaDisciplin = disciplin.getElementsByTagName("nome");
                    ArrayList disciplinas = new ArrayList();
                    for(int j = 0; j< listaDisciplin.getLength(); j++){
                        Node disciplinXML = listaDisciplin.item(j).getFirstChild();
                        disciplina = disciplinXML.getNodeValue();                  
                        c = Cursos.getCurso(curso);
                        d = ImportacaoProf.getDisciplina(disciplina);
                        disciplinas.add(d);
                    }
                    Aluno alun = new Aluno(tia, nome, c, disciplinas);
                    alunos.add(alun);
                }
            }
        } catch (Exception ex) {
            return false;
        }
    return true;
    }
}
