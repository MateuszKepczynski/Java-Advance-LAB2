package pl.pjatk.jaz.request;

import pl.pjatk.jaz.entity.CategoryEntity;
import pl.pjatk.jaz.entity.SectionEntity;

public class CategoryRequest
{
    private Long id;
    private Long sectionId;
    private String name;
    private String description;

    public CategoryRequest() {
    }

    public CategoryRequest(Long id, Long sectionId, String name, String description) {
        this.id = id;
        this.sectionId = sectionId;
        this.name = name;
        this.description = description;
    }

    public CategoryRequest(CategoryEntity c) {
        this.id = c.getId();
        this.sectionId = c.getSectionId();
        this.description = c.getDescription();
        this.name = c.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
