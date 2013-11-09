package autocomp.dao;

import autocomp.model.Aluno;
import autocomp.model.Curso;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author cogumello
 */
public class AlunoDAO extends GenericDAO<Aluno>{
    
    public Aluno getById(int id) {
        return getById(Aluno.class, id);
    }

    public List<Aluno> getAll() {
        return getAll(Aluno.class);
    }
    
    public Aluno getByTIA(String tia){
        Criteria criteria = getSession().createCriteria(Aluno.class).add(Restrictions.eq("tia", tia));
        List<Aluno> list = criteria.list();
        if(list != null && list.size() > 1) {
            throw new IllegalStateException("Existe mais de um usuário cadastrado com mesmo TIA!");
        }
        return list.get(0);
    }

    public List<Aluno> getByNome(String nome){
        Criteria criteria = getSession().createCriteria(Aluno.class).add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE));
        return criteria.list();
    }
    
    public List<Aluno> getByCurso(Curso curso){
        Criteria criteria = getSession().createCriteria(Aluno.class).add(Restrictions.eq("curso", curso));
        return criteria.list();
    }

    
}
