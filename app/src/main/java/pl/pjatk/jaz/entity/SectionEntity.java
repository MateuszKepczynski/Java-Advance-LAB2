package pl.pjatk.jaz.entity;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class SectionEntity
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    public SectionEntity(String name)
    {
        this.name = name;
    }

    public SectionEntity()
    {
        name = "";
    }

    public SectionEntity(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
