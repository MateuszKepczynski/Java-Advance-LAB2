package pl.pjatk.jaz.user;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@RequestScoped
public class FindUserDAOImpl implements FindUserDAO
{
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Long getUserByUsername(String username) {
        return em.createQuery("from ProfileEntity where username = : username", ProfileEntity.class)
                .setParameter("username", username).getSingleResult().getId();
    }
}
