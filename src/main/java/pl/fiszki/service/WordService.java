package pl.fiszki.service;

import pl.fiszki.models.Word;

import java.util.List;

/**
 * Created by Bartek on 14.04.2017.
 */
public interface WordService {

    Word findWordById(long id);

    List<Word> getWordsByIdBetween(long start, long stop);

    void createWord(Word word);

    Word getRandomWord(int boundary);

}