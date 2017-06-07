package pl.fiszki.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fiszki.models.words.Word;

import java.util.List;


/**
 * Created by Bartek on 14.04.2017.
 */
@Repository
public interface WordDAO extends CrudRepository<Word, Long> {

    List<Word> findAllByCategory_Id(long category_id);

}

