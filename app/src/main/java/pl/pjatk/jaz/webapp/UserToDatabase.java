package pl.pjatk.jaz.webapp;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserToDatabase
{
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addUserToDb(String name, String lastName, String username, String password, String userEmail, String dateOfBirth)
    {

            var profile = new ProfileEntity(name, lastName, username, password, userEmail, dateOfBirth);
            em.persist(profile); // adding profile to db
    }

    @Transactional
    public String getUsername(String userInputUsername) // searching db for nickname given by user and returning it
    {
        final ProfileEntity profileEntity = em.find(ProfileEntity.class, 7L);

        try
        {
            var list = em.createQuery("from ProfileEntity where username = :username", ProfileEntity.class)
                    .setParameter("username", userInputUsername).getSingleResult().getUsername();
            return list;
        }
        catch (NoResultException e)
        {
            return "nothing";
        }

    }

    @Transactional
    public String getPassword(String userInputUsername) // searching db for user and returning password
    {
        final ProfileEntity profileEntity = em.find(ProfileEntity.class, 7L);

            try
            {
                var list = em.createQuery("from ProfileEntity where username = :username", ProfileEntity.class)
                        .setParameter("username", userInputUsername).getSingleResult().getPassword();
                return list;
            }catch (NoResultException e)
            {
                return "nothing";
            }
    }

    @Transactional
    public boolean checkIfNickIsUnique(String username)
    {
        try
        {
            var list = em.createQuery("from ProfileEntity where username = :username", ProfileEntity.class)
                    .setParameter("username", username).getSingleResult().getUsername();
            return false;
        }
        catch (RollbackException e)
        {
            return true;
        }
        catch (NoResultException e)
        {
            return true;
        }
    }

    @Transactional
    public boolean checkIfEmailIsUnique(String email)
    {
        try
        {
            var list = em.createQuery("from ProfileEntity where email = :email", ProfileEntity.class)
                    .setParameter("email", email).getSingleResult().getEmail();
            return false;
        }
        catch (RollbackException e)
        {
            return true;
        }
        catch (NoResultException e)
        {
            return true;
        }
    }
}