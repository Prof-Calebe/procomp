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
public class DisciplinaController implements Serializable {

    private DisciplinaDAO dao;
    private CursosController cursoController;
    private UsuarioController usuarioController;

    public DisciplinaController() {
        dao = new DisciplinaDAO();
        cursoController = new CursosController();
        usuarioController = new UsuarioController();
    }

    public Disciplina getDisciplina(int id) {
        Disciplina disciplina = dao.getById(id);
        if (disciplina == null) {
            throw new IllegalArgumentException("Não existem disciplinas para esse id " + id);
        }
        return disciplina;
    }

    public List<Disciplina> getDisciplina(String disc) {
        List<Disciplina> disciplina = dao.getByNome(disc);
        if (disciplina == null || disciplina.isEmpty()) {
            throw new IllegalArgumentException("Não existem disciplinas para esse nome " + disc);
        }
        return disciplina;
    }

    public Disciplina getByCodigo(String codigo) {
        if (codigo == null) {
            throw new IllegalArgumentException("Código não pode ser nulo");
        }
        Disciplina disciplina = dao.getByCodigo(codigo);
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina com o codigo " + codigo + " nao encontrado!");
        }
        return disciplina;
    }

    public List<Disciplina> getAll() {
        return dao.getAll();
    }

    public boolean importar(String file) {

        if (file == null || file.trim().isEmpty()) {
            return false;
            //throw new IllegalArgumentException("Caminho invalido");
        }

        int semestre;
        String codigo, nome, tiaProfessor, grade, codCurso;

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            //Passo 1: obter o elemento raiz
            Element raiz = doc.getDocumentElement();
            //Passo 2: localizar os elementos filhos da agenda
            NodeList listaContatos = raiz.getElementsByTagName("disciplina");
            //Passo 3: obter os elementos de cada elemento contato
            for (int i = 0; i < listaContatos.getLength(); i++) {
                //como cada elemento do NodeList é um nó, precisamos fazer o cast
                Element contato = (Element) listaContatos.item(i);
                //Passo 4: obter o atributo id do contato
                NodeList listaCodigos = contato.getElementsByTagName("codigo");
                Node codigoXML = listaCodigos.item(0).getFirstChild();
                codigo = codigoXML.getNodeValue();
                NodeList listaNomes = contato.getElementsByTagName("nome");
                Node nomeXML = listaNomes.item(0).getFirstChild();
                nome = nomeXML.getNodeValue();
                NodeList listaProfessor = contato.getElementsByTagName("professor");
                Node professorXML = listaProfessor.item(0).getFirstChild();
                tiaProfessor = professorXML.getNodeValue();
                NodeList listaCurso = contato.getElementsByTagName("curso");
                Node cursoXML = listaCurso.item(0).getFirstChild();
                codCurso = cursoXML.getNodeValue();
                NodeList listaSemestre = contato.getElementsByTagName("semestre");
                Node semestreXML = listaSemestre.item(0).getFirstChild();
                semestre = Integer.parseInt(semestreXML.getNodeValue());
                NodeList listaGrade = contato.getElementsByTagName("grade");
                Node gradeXML = listaGrade.item(0).getFirstChild();
                grade = gradeXML.getNodeValue();

                Usuario professor = usuarioController.pesquisar(tiaProfessor);
                Curso curso = cursoController.getByCodigo(codCurso);
                Disciplina disciplina = new Disciplina(codigo, nome, semestre, curso, professor);
                dao.persist(disciplina);
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
