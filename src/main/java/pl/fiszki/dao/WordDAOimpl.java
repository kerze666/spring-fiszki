package pl.fiszki.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.fiszki.models.Word;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Bartek on 30.01.2017.
 */
@Repository
public class WordDAOimpl implements WordDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void add(Word word) {
        entityManager.persist(word);
    }

    public Word getWordById(long id) {
        return entityManager.find(Word.class, id);
    }


    public Map<Long, Word> getRandomFlashcards(int count) {
        Random random = new Random();
        Map<Long ,Word> map = new HashMap<Long, Word>(count);
        int sizeOfDB = entityManager.createQuery("SELECT id from Word ").getResultList().size();
        while (true){
            if(map.size()==10){
                break;
            }else{
                long randomIndex = random.nextInt(sizeOfDB);
                map.put(randomIndex,getWordById(randomIndex));
            }
        }
        return map;
    }

}
