package pl.pjatk.jaz.photo;

import pl.pjatk.jaz.auction.AuctionEntity;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class PhotoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "photo")
    private String photo;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="auction_id")
    private AuctionEntity auctionEntity;

    public PhotoEntity()
    {
    }

    public PhotoEntity(PhotoEntity photoEntity)
    {
        this.id = photoEntity.getId();
        this.photo = photoEntity.getPhoto();
        this.auctionEntity = photoEntity.getAuctionEntity();
    }

    public PhotoEntity(Long id, String photo)
    {
        this.id = id;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public AuctionEntity getAuctionEntity()
    {
        return auctionEntity;
    }

    public void setAuctionEntity(AuctionEntity auctionEntity) {
        this.auctionEntity = auctionEntity;
    }


}
