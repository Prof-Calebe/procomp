package autocomp.dao;

import autocomp.model.DomainObject;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Damião Martins
 */
public abstract class GenericDAO<T extends DomainObject> implements IGenericDAO<T> {
    
    private Session session;
    private Transaction currentTransaction;
    
    protected GenericDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("procomp");
        session = (Session) emf.createEntityManager().getDelegate();
    }
    
    protected void before(){
        currentTransaction = session.getTransaction();
        currentTransaction.begin();
    }
    
    protected void after(){
        currentTransaction.commit();
        currentTransaction = null;
    }

    @Override
    public void save(T object) {
        before();
        getSession().save(object);
        after();
    }

    @Override
    public void delete(T object) {
        before();
        getSession().delete(object);
        after();
    }

    @Override
    public void merge(T object) {
        before();
        getSession().merge(object);
        after();
    }
    
    @Override
    public void persist(T object) {
        before();
        getSession().persist(object);
        after();
    }

    @Override
    public void update(T object) {
        before();
        getSession().update(object);
        after();
    }

    protected T getById(Class<? extends T> clazz, int objectID) {
        return (T) getSession().load(clazz, objectID);
    }

    protected List<T> getAll(Class<?> classType) {
        return getSession().createCriteria(classType).list();
    }
    
    protected Session getSession(){
        return session;
    }
}
