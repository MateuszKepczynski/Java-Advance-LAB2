package pl.pjatk.jaz.photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PhotoController
{
    @Inject
    PhotoDAO photoDAO;

    public List<PhotoEntity> getListPhoto()
    {
        return photoDAO.getListPhoto();
    }

    public String getPhotoByAuctionId(Long auctionId)
    {
       return photoDAO.getPhotoByAuctionId(auctionId);
    }
}