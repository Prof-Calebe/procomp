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
    
    public Curso getByCodigo(String codigo){
        Criteria criteria = getSession().createCriteria(Curso.class).add(Restrictions.eq("codigo", codigo));
        List<Curso> curso = criteria.list();
        if(curso != null && curso.size() > 1){
            throw new IllegalStateException("Existe mais de um curso cadastrado com o mesmo código");
        }
        return curso == null ? null : curso.get(0);
    }
    
    public List<Curso> getByQuantidadeSemestres(int quantidade){
        Criteria criteria = getSession().createCriteria(Curso.class).add(Restrictions.eq("semestres", quantidade));
        return criteria.list();
    }
}
