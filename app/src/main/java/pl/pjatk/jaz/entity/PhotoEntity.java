package pl.pjatk.jaz.entity;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class PhotoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "photo")
    private String photo;

    public PhotoEntity()
    {
    }

    public PhotoEntity(Long id, String photo)
    {
        this.id = id;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
