package pl.fiszki.models.words;

import pl.fiszki.models.user.User;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Word> words;


    public Category() {
    }

    public Category(String category, User user) {
        this.category = category;
        this.user = user;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
