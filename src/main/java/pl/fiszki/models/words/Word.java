package pl.fiszki.models.words;

import javax.persistence.*;

/**
 * Created by Bartek on 30.01.2017.
 */
@Table(name = "words")
@Entity
public class Word {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "angielski", nullable = false)
    private String angielski;

    @Column(name = "polski", nullable = false)
    private String polski;

    @Column(name = "id_user")
    private long userid;

    @Column(name = "id_cat")
    private long catId;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAngielski() {
        return angielski;
    }

    public void setAngielski(String angielski) {
        this.angielski = angielski;
    }

    public String getPolski() {
        return polski;
    }

    public void setPolski(String polski) {
        this.polski = polski;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long id_cat) {
        this.catId = id_cat;
    }

}

