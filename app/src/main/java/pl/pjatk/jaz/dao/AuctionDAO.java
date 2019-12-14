package pl.pjatk.jaz.dao;

import pl.pjatk.jaz.entity.AuctionEntity;

import java.util.List;
import java.util.Optional;

public interface AuctionDAO
{
    List<AuctionEntity> getAuctionList();
    Optional<AuctionEntity> getAuctionById(Long auctionId);
    void save(AuctionEntity auctionEntity);
    void delete(AuctionEntity auctionEntity);
}
