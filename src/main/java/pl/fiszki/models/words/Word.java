package pl.fiszki.models.words;

import javax.persistence.*;

/**
 * Created by Bartek on 30.01.2017.
 */
@Table(name = "words")
@Entity
public class Word {

    @Id
    @Column(name = "id_word")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "english", nullable = false)
    private String angielski;

    @Column(name = "polish", nullable = false)
    private String polski;

    @ManyToOne
    @JoinColumn(name = "id_cat", referencedColumnName = "id_cat")
    private Category category;

    public Word() {
    }

    public Word(String angielski, String polski) {
        this.angielski = angielski;
        this.polski = polski;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", angielski='" + angielski + '\'' +
                ", polski='" + polski + '\'' +
                '}';
    }
}

