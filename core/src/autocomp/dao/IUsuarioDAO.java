
package autocomp.dao;

import autocomp.model.Grupo;
import autocomp.model.Usuario;
import java.util.List;


public interface IUsuarioDAO extends IGenericDAO<Usuario> {
    
    public Usuario getById(int id);

    public List<Usuario> getAll();
    
    public Usuario autenticar(String tia, String senha);
    
    public Usuario getByTIA(String tia);
    
    public List<Usuario> getByNome(String nome);
    
    public List<Usuario> getByGrupo(Grupo grupo);
}
