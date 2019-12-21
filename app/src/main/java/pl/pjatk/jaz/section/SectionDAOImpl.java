package pl.pjatk.jaz.section;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class SectionDAOImpl implements SectionDAO
{
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public List<SectionEntity> getSectionList()
    {
        return em.createQuery("FROM SectionEntity ORDER BY id ASC").getResultList(); // TO WYŚWIETLA
    }

    @Override
    @Transactional
    public SectionRequest getSection()
    {
        return null;
    } // TO NIC NIE ROBI

    @Override
    @Transactional
    public Optional<SectionEntity> getSectionById(Long sectionId)
    {
        var section = em.find(SectionEntity.class, sectionId);
        return Optional.ofNullable(section); //TO ZWRACA PO ID
    }

    @Override
    @Transactional
    public void save(SectionEntity sectionEntity)
    {
        if (sectionEntity.getId() == null)
        {
            em.persist(sectionEntity); // TO ZAPISUJE
        } else {
            em.merge(sectionEntity);
        }
    }

    @Override
    @Transactional
    public void delete(SectionEntity sectionEntity)
    {
        if (sectionEntity.getId() != null)
        {
            var section = em.find(SectionEntity.class,sectionEntity.getId());
            em.remove(section);
        }
        else
        {
            System.out.println("lel");
        }
    }
}
