package autocomp.dao;

import autocomp.model.Disciplina;
import autocomp.model.Questao;
import autocomp.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Damião Martins
 */
public class QuestaoDAO extends GenericDAO<Questao> {
    
    public Questao getById(int id){
        return getById(Questao.class, id);
    }
    public List<Questao> getAll(){
        return super.getAll(Questao.class);
    }

    public List<Questao> getByEnunciado(String enunciado){
        Criteria criteria = getSession().createCriteria(Questao.class)
                .add(Restrictions.ilike("enunciado", enunciado, MatchMode.ANYWHERE));
        return criteria.list();
    }
    
    public List<Questao> getByDificuldade(Questao.QuestaoDificuldade dificuldade){
        Criteria criteria = getSession().createCriteria(Questao.class)
                .add(Restrictions.eq("dificuldade", dificuldade));
        return criteria.list();
    }
    
    public List<Questao> getByResponsavel(Usuario responsavel){
        Criteria criteria = getSession().createCriteria(Questao.class)
                .add(Restrictions.eq("responsavel", responsavel));
        return criteria.list();
    }
    
    public List<Questao> getByDisciplina(Disciplina disciplina){
        Criteria criteria = getSession().createCriteria(Questao.class)
                .add(Restrictions.eq("disciplina", disciplina));
        return criteria.list();
    }
    
    public Boolean updateQuestao(Questao questao){
          try{
            super.update(questao);
            return true;
          }catch(Exception e){
              return false;
          }
    }
}
