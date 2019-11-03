package pl.pjatk.jaz.webapp;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.beans.Statement;

@ApplicationScoped
public class UserToDatabase
{
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addUserToDb(String name, String lastName, String username, String password, String userEmail, String dateOfBirth)
    {
        var profile = new ProfileEntity(name,lastName,username,password,userEmail,dateOfBirth);

        em.persist(profile); // adding profile to db
    }

    @Transactional
    public void getUsername(String userInputUsername)
    {
        final ProfileEntity profileEntity = em.find(ProfileEntity.class, 7L);

        var list = em.createQuery("from ProfileEntity where username = :username", ProfileEntity.class)
                .setParameter("username", userInputUsername).getResultList(); // searching db for nickname given by user
    }
}