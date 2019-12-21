package pl.pjatk.jaz.photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
public class PhotoDAOImpl implements PhotoDAO
{
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public List<PhotoEntity> getListPhoto()
    {
        return em.createQuery("FROM PhotoEntity").getResultList();
    }

    @Override
    @Transactional
    public String getPhotoByAuctionId(Long auctionId)
    {
        try
        {
            List<PhotoEntity> test = em.createNativeQuery("SELECT * FROM photo WHERE auction_id = " + auctionId,PhotoEntity.class).getResultList();
            return test.get(0).getPhoto();

            //return em.createNativeQuery("SELECT photo FROM photo WHERE auction_id = " + auctionId).getSingleResult().toString();;
            //return em.createQuery("FROM PhotoEntity  WHERE auctionEntity.id =: auctionId",PhotoEntity.class).setParameter("auctionId",auctionId).getSingleResult().getPhoto(); //CZEMU TO NIE DZIALA?
        }
        catch (Exception e)
        {
            return "https://as2.ftcdn.net/jpg/02/34/81/33/500_F_234813383_bE3zVSXclqYEDKxRtDazfB54jfSRsHCK.jpg";
        }
    }

    @Override
    @Transactional
    public PhotoEntity getPhotoEntityByAuctionId(Long auctionId)
    {
        try
        {
            return (PhotoEntity) em.createNativeQuery("SELECT * FROM photo WHERE auction_id = " + auctionId).getSingleResult();
        }
        catch (Exception e)
        {
            return new PhotoEntity();
        }
    }

    @Override
    public List<PhotoEntity> getByAuctionId(Long auctionId)
    {
        try {
            return em.createNativeQuery("SELECT * FROM photo WHERE auction_id = " + auctionId, PhotoEntity.class).getResultList();
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
