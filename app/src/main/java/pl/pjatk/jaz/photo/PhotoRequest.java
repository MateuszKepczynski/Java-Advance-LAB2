package pl.pjatk.jaz.photo;

import pl.pjatk.jaz.auction.AuctionEntity;

public class PhotoRequest
{
    private Long id;
    private String url;
    private AuctionEntity auctionEntity;

    public PhotoRequest()
    {
    }

    public PhotoRequest(Long id, String url, AuctionEntity auctionEntity)
    {
        this.id = id;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}