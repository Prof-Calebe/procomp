package autocomp.dao;

import autocomp.model.DomainObject;


public interface IGenericDAO<T extends DomainObject> {
    
    public void save(T object);

    public void delete(T object);

    public void merge(T object);
    
    public void persist(T object);

    public void update(T object);
}
