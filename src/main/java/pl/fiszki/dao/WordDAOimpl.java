package pl.fiszki.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.fiszki.models.Word;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
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
            if(map.size()==count){
                break;
            }else{
                long randomIndex = random.nextInt(sizeOfDB);
                map.put(randomIndex,getWordById(randomIndex));
            }
        }
        return map;
    }

    @Transactional
    public void addAllWordsFromFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("1000slow_remaded.txt").getFile());
        InputStream is;
        try {
            is = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(is,"UTF-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String text = null;
            while ((text = reader.readLine()) != null) {
                String [] tab = text.split("\t");
                Word word = new Word();
                word.setAngielski(tab[0]);
                word.setPolski(tab[1]);
                System.out.println(tab[1]);
                entityManager.persist(word);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Word> getListOfWords(long min, long max){
        List<Word> list = entityManager.createQuery("SELECT w from Word w where w.id between ?1 and ?2", Word.class)
                .setParameter(1,min)
                .setParameter(2,max)
                .getResultList();
        return list;
    }


}
