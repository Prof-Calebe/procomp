/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import autocomp.entidades.Curso;
import autocomp.entidades.Disciplina;
import autocomp.entidades.Professor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
public class ImportacaoProf implements Serializable{
    
    private static ArrayList disciplinas, professores;
    
    public static boolean isImported(){
        if(disciplinas == null)
            return false;
        return true;
    }
    public static boolean importar(String file){
        disciplinas = new ArrayList();
        professores = new ArrayList();
        int id, semestre;
        String nome, professor, grade, curso;
        Professor p;
        Curso c;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            //Passo 1: obter o elemento raiz
            Element raiz = doc.getDocumentElement();
            //Passo 2: localizar os elementos filhos da agenda
            NodeList listaContatos = raiz.getElementsByTagName("disciplina");
            //Passo 3: obter os elementos de cada elemento contato
            for (int i=0; i<listaContatos.getLength(); i++){
                //como cada elemento do NodeList é um nó, precisamos fazer o cast
                Element contato = (Element) listaContatos.item(i);
                //Passo 4: obter o atributo id do contato
                Attr idXML = contato.getAttributeNode("id");
                id = Integer.parseInt(idXML.getNodeValue());
                NodeList listaNomes = contato.getElementsByTagName("nome");
                Node nomeXML = listaNomes.item(0).getFirstChild();
                nome = nomeXML.getNodeValue();
                NodeList listaProfessor = contato.getElementsByTagName("professor");
                Node professorXML = listaProfessor.item(0).getFirstChild();
                professor = professorXML.getNodeValue();
                NodeList listaCurso = contato.getElementsByTagName("curso");
                Node cursoXML = listaCurso.item(0).getFirstChild();
                curso = cursoXML.getNodeValue();                
                NodeList listaSemestre = contato.getElementsByTagName("semestre");
                Node semestreXML = listaSemestre.item(0).getFirstChild();
                semestre = Integer.parseInt(semestreXML.getNodeValue());
                NodeList listaGrade = contato.getElementsByTagName("grade");
                Node gradeXML = listaGrade.item(0).getFirstChild();
                grade = gradeXML.getNodeValue();
                
                int index = procurarProfessor(professor);
                if(index == -1){
                    index = professores.size();
                    p = new Professor(index, professor);
                    professores.add(p);
                }
                p = (Professor) professores.get(index);
                c = Cursos.getCurso(nome);
                disciplinas.add(new Disciplina(id-1, nome, c, p));
        }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    private static int procurarProfessor(String nome){
        int i = -1;
        for(Iterator it = professores.iterator(); it.hasNext();){
            i++;
            Professor prof = (Professor) it.next();
            if(nome.equals(prof.getNome()))              
                return i;
        }
        return -1;
    }
    
    public static Disciplina getDisciplina(int id){
        Disciplina d;
        try{
            d = (Disciplina) disciplinas.get(id);
            return d;
        }
        catch(Exception e){
            return null;
        }
    }
    
    public static Disciplina getDisciplina(String disc){
        Disciplina d = null;       
        try{
            String[] nomes = getNomeDisciplinas();
            for(int i=0; i < nomes.length; i++){
                if(disc.equals(nomes[i]))
                    d = getDisciplina(i);
            }
            return d;
        }
        catch(Exception e){
            return null;
        }
    }
    
    public static String[] getNomeDisciplinas(){
        String[] nomes = {null};
        try{
            nomes = new String[disciplinas.size()];
            for(int i = 0; i < disciplinas.size(); i++){
                nomes[i] = getDisciplina(i).getNome();
            }
            return nomes;
        }
        catch(Exception e){
            return null;
        }
    }
}
