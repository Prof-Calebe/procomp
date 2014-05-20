/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.controller;

import autocomp.dao.CursoDAO;
import autocomp.model.Curso;
import java.io.Serializable;
import java.util.List;


public class CursosController implements Serializable {

    CursoDAO cursoDAO = new CursoDAO();

    public Curso getCurso(int id) {
        Curso curso = cursoDAO.getById(id);
        if (curso == null) {
            throw new IllegalArgumentException("Curso com o id " + id + " nao encontrado!");
        }
        return curso;
    }

    public List<Curso> getCursosByName(String nome) {
        List<Curso> curso = cursoDAO.getByNome(nome);
        if (curso == null) {
            throw new IllegalArgumentException("Curso com o nome " + nome + " nao encontrado!");
        }
        return curso;
    }

    public Curso getByCodigo(String codigo) {
        if (codigo == null) {
            throw new IllegalArgumentException("Código não pode ser nulo");
        }
        Curso curso = cursoDAO.getByCodigo(codigo);
        if (curso == null) {
            throw new IllegalArgumentException("Curso com o codigo " + codigo + " nao encontrado!");
        }
        return curso;
    }
}
