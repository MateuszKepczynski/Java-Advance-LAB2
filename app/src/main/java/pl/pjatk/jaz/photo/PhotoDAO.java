package pl.pjatk.jaz.photo;

import java.util.List;

public interface PhotoDAO
{
    List<PhotoEntity> getListPhoto();
    String getPhotoByAuctionId(Long auctionId);
    PhotoEntity getPhotoEntityByAuctionId(Long auctionId);
    List<PhotoEntity> getByAuctionId(Long auctionId);
}
