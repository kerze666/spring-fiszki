package pl.fiszki.dao;

import pl.fiszki.models.Word;

import java.util.Map;

/**
 * Created by Bartek on 30.01.2017.
 */
public interface WordDAO {
    void add(Word word);
    Word getWordById(long id);
    Map<Long, Word> getRandomFlashcards(int count);

}
