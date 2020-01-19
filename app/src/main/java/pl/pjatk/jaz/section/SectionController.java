package pl.pjatk.jaz.section;

import pl.pjatk.jaz.ParamRetriever;
import pl.pjatk.jaz.session.SessionUtils;
import pl.pjatk.jaz.user.FindUserDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class SectionController
{
    private SectionRequest sectionRequest;

    @Inject
    FindUserDAO findUserDAO;

    @Inject
    SectionDAO sectionDAO;

    @Inject
    ParamRetriever paramRetriever;

    public List<SectionEntity> getSectionList()
    {
        return sectionDAO.getSectionList();
    }

    public SectionRequest getSectionRequest()
    {
        if (sectionRequest == null)
        {
            sectionRequest = createSectionRequest();
        }
        return sectionRequest;
    }

    private SectionRequest createSectionRequest()
    {
        if (paramRetriever.contains("sectionId"))
        {
            var sectionId = paramRetriever.getLong("sectionId");
            var section = sectionDAO.getSectionById(sectionId).orElseThrow();
            return new SectionRequest(section);
        }
        return new SectionRequest();
    }

    public String save()
    {
        String session = SessionUtils.getUserName();
        System.out.println("############# " + findUserDAO.getUserByUsername(session));
        if(session.equals("kepes12"))
        {
            var section = new SectionEntity(sectionRequest.getId(), sectionRequest.getName());
            sectionDAO.save(section);

            return "/list-section.xhtml?faces-redirect=true";
        }
        else
        {
            return "/index.xhtml?faces-redirect=true";
        }
    }

    public String delete(){
        String session = SessionUtils.getUserName();
        System.out.println("############# " + findUserDAO.getUserByUsername(session));
        if(session.equals("kepes12"))
        {
            var section = new SectionEntity(sectionRequest.getId(), sectionRequest.getName());
            sectionDAO.delete(section);
            return "/list-section.xhtml?faces-redirect=true";
        }
        else
        {
            return "/index.xhtml?faces-redirect=true";
        }
    }
}
