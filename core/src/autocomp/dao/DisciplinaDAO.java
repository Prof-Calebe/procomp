package autocomp.dao;

import autocomp.model.Curso;
import autocomp.model.Disciplina;
import autocomp.model.Grupo;
import autocomp.model.Prova;
import autocomp.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Damião Martins
 */
public class DisciplinaDAO extends GenericDAO<Disciplina>{
    
    public Disciplina getById(int id) {
        return getById(Disciplina.class, id);
    }

    public List<Disciplina> getAll() {
        return getAll(Disciplina.class);
    }
    
    public List<Disciplina> getByCurso(Curso curso){
        Criteria criteria = getSession().createCriteria(Disciplina.class).add(Restrictions.eq("curso", curso));
        return criteria.list();
    }
    
    public List<Disciplina> getByProfessor(Usuario professor){
        if( professor == null || ! Grupo.PROFESSOR.equals(professor.getGrupo())){
            throw new IllegalArgumentException("Usuário não pertence ao grupo professor");
        }
        Criteria criteria = getSession().createCriteria(Disciplina.class).add(Restrictions.eq("professor", professor));
        return criteria.list();
    }
    
    public List<Disciplina> getByNome(String nome){
        Criteria criteria = getSession().createCriteria(Disciplina.class).add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE));
        return criteria.list();
    }
}
