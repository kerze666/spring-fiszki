package pl.fiszki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.fiszki.dao.WordDAO;
import pl.fiszki.models.words.Category;
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


    public List<Word> findListOfWordsByIdCategory(long idcat) {
        return wordDAO.findAllByCategory_Id(idcat);
    }

    public Word findWordById(long id) {
        return wordDAO.findOne(id);
    }

    public List<Word> findListOfWordsByCategory(Category category) {
        return (List<Word>) wordDAO.findAll();
    }

    public void deleteWord(long idWord) {
        wordDAO.delete(idWord);
    }

    public Word createWord(Word word) {
        return wordDAO.save(word);
    }

    public Word updateWord(Word word, long idWord) {
        Word oldWord = wordDAO.findOne(idWord);
        oldWord.setPolski(word.getPolski());
        oldWord.setAngielski(word.getAngielski());
        oldWord.setCategory(word.getCategory());
        return wordDAO.save(oldWord);
    }
}
