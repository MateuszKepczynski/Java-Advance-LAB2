package pl.pjatk.jaz.dao;

import pl.pjatk.jaz.entity.SectionEntity;
import pl.pjatk.jaz.request.SectionRequest;

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
        return em.createQuery("FROM SectionEntity ORDER BY id ASC").getResultList();
    }

    @Override
    @Transactional
    public SectionRequest getSection()
    {
        return null;
    }

    @Override
    @Transactional
    public Optional<SectionEntity> getSectionById(Long sectionId)
    {
        var door = em.find(SectionEntity.class, sectionId);
        return Optional.ofNullable(door);
    }

    @Override
    @Transactional
    public void save(SectionEntity sectionEntity)
    {
        if (sectionEntity.getId() == null)
        {
            em.persist(sectionEntity);
        } else {
            em.merge(sectionEntity);
        }
    }
}
