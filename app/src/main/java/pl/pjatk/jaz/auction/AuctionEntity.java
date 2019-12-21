package pl.pjatk.jaz.auction;

import pl.pjatk.jaz.photo.PhotoEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="auction")
public class AuctionEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "profile_id")//FOREIGN KEY one to one
    private Long profileId;

    @Column(name = "category_id")//FOREIGN KEY one to one
    private Long categoryId;


    @Column(name = "photo")//DO USUNIĘCIA
    private String photo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="auctionEntity",
            cascade= {CascadeType.ALL})
    private List<PhotoEntity> photoEntities;

    public AuctionEntity()
    {
    }

    public AuctionEntity(Long id,String title, double price, String description, String photo)
    {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<PhotoEntity> getPhotoEntities() {
        return photoEntities;
    }

    public void setPhotoEntities(List<PhotoEntity> photoEntities) {
        this.photoEntities = photoEntities;
    }

    public void addPhoto(PhotoEntity pE)
    {
        if(photoEntities == null)
        {
            photoEntities = new ArrayList<>();
        }
        photoEntities.add(pE);
    }

}