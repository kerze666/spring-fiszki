package pl.fiszki.service;

import pl.fiszki.models.words.Category;
import pl.fiszki.models.words.Word;

import java.util.List;

/**
 * Created by Bartek on 14.04.2017.
 */
public interface WordService {

    List<Word> findListOfWordsByIdCategory(long idcat);

    Word findWordById(long id);

    List<Word> findListOfWordsByCategory(Category category);

    void deleteWord(long idWord);

    Word createWord(Word word);

    Word updateWord(Word word, long idWord);

}
