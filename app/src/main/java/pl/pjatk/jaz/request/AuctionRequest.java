package pl.pjatk.jaz.request;

import pl.pjatk.jaz.entity.AuctionEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionRequest
{
    private Long id;
    private String title;
    private String description;
    private double price;
    private Long profileId;
    private Long categoryId;
    private String photo;

    public AuctionRequest()
    {
    }

    public AuctionRequest(Long id, String title, double price, Long profileId, Long auctionId, String description, String photo)
    {
        this.id = id;
        this.title = title;
        this.price = price;
        this.profileId = profileId;
        this.categoryId = auctionId;
        this.description= description;
        this.photo = photo;
    }

    public AuctionRequest(AuctionEntity auction) {
        this.id = auction.getId();
        this.title = auction.getTitle();
        this.price = auction.getPrice();
        this.profileId = auction.getProfileId();
        this.categoryId = auction.getCategoryId();
        this.description = auction.getDescription();
        this.photo = auction.getPhoto();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
