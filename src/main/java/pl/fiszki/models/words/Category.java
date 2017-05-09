package pl.fiszki.models.words;

import javax.persistence.*;

/**
 * Created by Bartek on 04.05.2017.
 */
@Entity
@Table(name = "words_category")
public class Category {
    @Id
    @Column(name = "id_cat")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "category")
    private String category;

    @Column(name = "id_user")
    private long userid;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

}
