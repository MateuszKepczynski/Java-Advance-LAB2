package pl.pjatk.jaz.webapp.category;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class CategoryDbOperations
{
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addCategory(String categoryName)
    {

    }

    @Transactional
    public void removeCategory(String categoryName)
    {

    }

    @Transactional
    public void editCategory(String categoryName, String categoryNameEdited)
    {

    }
}
