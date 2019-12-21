package pl.pjatk.jaz.auction;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public class AuctionDAOImpl implements AuctionDAO
{
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public List<AuctionEntity> getAuctionList()
    {
        return em.createQuery("FROM AuctionEntity ORDER BY id ASC ").getResultList();
    }

    @Override
    @Transactional
    public Optional<AuctionEntity> getAuctionById(Long auctionId)
    {
        return Optional.ofNullable(em.find(AuctionEntity.class, auctionId));
    }

    @Override
    @Transactional
    public void save(AuctionEntity auctionEntity)
    {
        if (auctionEntity.getId() == null)
        {
            em.persist(auctionEntity);
        } else {
            em.merge(auctionEntity);
        }
    }

    @Override
    @Transactional
    public void delete(Long id)
    {
        if (id != null)
        {
            em.remove(em.find(AuctionEntity.class, id));
        }
        else
        {
            System.out.println("lel");
        }
    }
}
