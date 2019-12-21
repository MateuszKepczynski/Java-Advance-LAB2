package pl.pjatk.jaz.section;

import pl.pjatk.jaz.section.SectionEntity;

public class SectionRequest
{
    private Long id;
    private String name;

    public SectionRequest()
    {

    }

    public SectionRequest(SectionEntity s)
    {
        this.id = s.getId();
        this.name = s.getName();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}