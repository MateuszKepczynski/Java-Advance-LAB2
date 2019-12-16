package pl.pjatk.jaz.controller;

import pl.pjatk.jaz.ParamRetriever;
import pl.pjatk.jaz.dao.AuctionDAO;
import pl.pjatk.jaz.dao.FindUserDAO;
import pl.pjatk.jaz.entity.AuctionEntity;
import pl.pjatk.jaz.request.AuctionRequest;
import pl.pjatk.jaz.session.SessionUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AuctionController
{
    @Inject
    FindUserDAO findUserDAO;

    @Inject
    AuctionDAO auctionDAO;

    @Inject
    ParamRetriever paramRetriever;

    private AuctionRequest auctionRequest;

    public List<AuctionEntity> getAuctionList()
    {
        return auctionDAO.getAuctionList();
    }

    public AuctionRequest getAuctionRequest()
    {
        if(auctionRequest == null)
        {
            auctionRequest = createCategoryRequest();
        }
        return auctionRequest;
    }

    private AuctionRequest createCategoryRequest()
    {
        if(paramRetriever.contains("auctionId"))
        {
            var auctionId = paramRetriever.getLong("auctionId");
            var auction = auctionDAO.getAuctionById(auctionId).orElseThrow();
            return new AuctionRequest(auction);
        }
        return new AuctionRequest();
    }

    public String save()
    {
        String username = SessionUtils.getUserName();

        var auction = new AuctionEntity(auctionRequest.getId(),auctionRequest.getTitle(),auctionRequest.getPrice(), auctionRequest.getDescription(), auctionRequest.getPhoto());
        assert username != null;
        auction.setProfileId(findUserDAO.getUserByUsername(username));
        auction.setCategoryId(auctionRequest.getCategoryId());
        auctionDAO.save(auction);
        return "/auction-form.xhtml?faces-redirect=true";
    }

    public String delete(){
        auctionDAO.delete(auctionRequest.getId());
        return "/list-section.xhtml?faces-redirect=true";
    }
}