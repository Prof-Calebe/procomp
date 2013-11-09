package autocomp.dao;

import autocomp.model.Grupo;
import autocomp.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Damiao Martins
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public Usuario getById(int id) {
        return getById(Usuario.class, id);
    }

    public List<Usuario> getAll() {
        return getAll(Usuario.class);
    }
    
    public Usuario getByTIA(String tia){
        Criteria criteria = getSession().createCriteria(Usuario.class).add(Restrictions.eq("tia", tia));
        List<Usuario> list = criteria.list();
        if(list != null && list.size() > 1) {
            throw new IllegalStateException("Existe mais de um usuário cadastrado com mesmo TIA!");
        }
        return list.get(0);
    }
    
    public List<Usuario> getByNome(String nome){
        Criteria criteria = getSession().createCriteria(Usuario.class).add(Restrictions.like("nome", nome));
        return criteria.list();
    }
    
    public List<Usuario> getByGrupo(Grupo grupo){
        Criteria criteria = getSession().createCriteria(Usuario.class).add(Restrictions.eq("grupo", grupo.name()));
        return criteria.list();
    }

}
