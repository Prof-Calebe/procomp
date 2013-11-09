package autocomp.dao;

import autocomp.model.Curso;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Damião Martins
 */
public class CursoDAO extends GenericDAO<Curso> {
    
    public Curso getById(int id){
        return getById(Curso.class, id);
    }
    
    public List<Curso> getByNome(String nome){
        Criteria criteria = getSession().createCriteria(Curso.class).add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE));
        return criteria.list();
    }
    
    public List<Curso> getByQuantidadeSemestres(int quantidade){
        Criteria criteria = getSession().createCriteria(Curso.class).add(Restrictions.eq("semestres", quantidade));
        return criteria.list();
    }
}
