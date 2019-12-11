package pl.pjatk.jaz.controller;

import pl.pjatk.jaz.ParamRetriever;
import pl.pjatk.jaz.dao.SectionDAO;
import pl.pjatk.jaz.entity.SectionEntity;
import pl.pjatk.jaz.request.SectionRequest;

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
        var section = new SectionEntity(sectionRequest.getId(),sectionRequest.getName());
        sectionDAO.save(section);

        return "true";
    }
}
