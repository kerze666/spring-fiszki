package pl.fiszki.dao;

        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;
        import pl.fiszki.models.Word;

        import java.util.List;


/**
 * Created by Bartek on 14.04.2017.
 */
@Repository
public interface WordDAO extends CrudRepository<Word, Long> {

    Word findWordById(long id);

    @Query("SELECT w from Word w where w.id between ?1 and ?2")
    List<Word> getWordsByIdBetween(long start, long stop);

}
