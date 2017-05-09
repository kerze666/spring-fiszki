package pl.fiszki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.fiszki.dao.WordDAO;
import pl.fiszki.models.words.Word;
import pl.fiszki.service.WordService;

import java.util.List;
import java.util.Random;

/**
 * Created by Bartek on 14.04.2017.
 */
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordDAO wordDAO;

    public Word findWordById(long id) {
        return wordDAO.findWordById(id);
    }

    public List<Word> getWordsByIdBetween(long start, long stop) {
        return wordDAO.getWordsByIdBetween(start, stop);
    }

    public List<Word> getListOfWordsByIdCategory(long catId)
    {
        return wordDAO.findAllByCatId(catId);
    }

    public void deleteWordsByCatId(long catId) {
        wordDAO.deleteWordsByCatId(catId);
    }

    @Transactional
    public void createWord(Word word) {
        wordDAO.save(word);
    }

    public Word getRandomWord(int boundary) {
        Random random = new Random();
        return wordDAO.findWordById(random.nextInt(boundary));
    }

}
