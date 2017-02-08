package pl.fiszki.models;

import javax.persistence.*;

/**
 * Created by Bartek on 30.01.2017.
 */
@Table(name = "words")
@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "angielski",nullable = false)
    private String angielski;
    @Column(name = "polski",nullable = false)
    private String polski;

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
}

