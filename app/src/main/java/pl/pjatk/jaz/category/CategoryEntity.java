package pl.pjatk.jaz.category;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
/*

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private SectionEntity sectionEntity;
*/
    @Column(name = "section_id")
    private Long sectionId;

    public CategoryEntity()
    {
    }

    public CategoryEntity(Long id, String name, String description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

/*
    public SectionEntity getSectionEntity() {
        return sectionEntity;
    }

    public void setSectionEntity(SectionEntity sectionEntity) {
        this.sectionEntity = sectionEntity;
    }
*/

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }
}
