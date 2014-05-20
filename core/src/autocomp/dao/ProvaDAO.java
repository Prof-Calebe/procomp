package autocomp.dao;

import autocomp.model.Prova;
import autocomp.model.Usuario;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Damião Martins
 */
public class ProvaDAO extends GenericDAO<Prova> {

    public Prova getById(int id) {
        return getById(Prova.class, id);
    }

    public List<Prova> getAll() {
        return getAll(Prova.class);
    }
    
    public List<Prova> getByNome(String nome){
        Criteria criteria = getSession().createCriteria(Prova.class).add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE));
        return criteria.list();
    }
    
    public List<Prova> getByResponsavel(Usuario responsavel){
        Criteria criteria = getSession().createCriteria(Prova.class).add(Restrictions.eq("responsavel", responsavel));
        return criteria.list();
    }
    
    public List<Prova> getByDataCriacao(Date inicio, Date fim){
        return getByIntervaloDatas("dataCriacao", inicio, fim);
    }
    
    public List<Prova> getByDataAlteracao(Date inicio, Date fim){
        return getByIntervaloDatas("dataAlteracao", inicio, fim);
    }
    
    private List<Prova> getByIntervaloDatas(String coluna, Date inicio, Date fim) {
        Criteria criteria = getSession().createCriteria(Prova.class)
                .add(Restrictions.between(coluna, inicio, fim));
        criteria.addOrder(Order.asc(coluna));
        return criteria.list();
    }
}
