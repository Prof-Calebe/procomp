/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import autocomp.entidades.Professor;
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
public class Importacao {
    
    ArrayList disciplinas, professores;
    
    public Importacao(){
        disciplinas = new ArrayList();
        professores = new ArrayList();
        int id, semestre;
        String nome, professor, grade;
        Professor p;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("prof.xml");
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
                NodeList listaSemestre = contato.getElementsByTagName("semestre");
                Node semestreXML = listaSemestre.item(0).getFirstChild();
                semestre = Integer.parseInt(semestreXML.getNodeValue());
                NodeList listaGrade = contato.getElementsByTagName("grade");
                Node gradeXML = listaGrade.item(0).getFirstChild();
                grade = gradeXML.getNodeValue();
                
                int index = procurarProfessor(professor);
                if(index >= 0){
                    p = new Professor(professores.size()+1, professor);
                    professores.add(p);
                }
                p = (Professor) professores.get(index);
                
        }
        } catch (Exception ex) {
            System.out.println("ERRO nessa porra");
        }

    }
    
    public int procurarProfessor(String nome){
        int i = -1;
        for(Iterator it = professores.iterator(); it.hasNext();){
            i++;
            Professor prof = (Professor) it.next();
            if(nome.equals(prof.getNome()))              
                return i;
        }
        return -1;
    }
    
    public static void main(String[] args){
        new Importacao();
    }
}
