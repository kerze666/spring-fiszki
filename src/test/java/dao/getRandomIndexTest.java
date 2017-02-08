package dao;

import org.junit.Assert;
import org.junit.Test;
import pl.fiszki.dao.WordDAO;
import pl.fiszki.dao.WordDAOimpl;
import pl.fiszki.models.Word;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Bartek on 01.02.2017.
 */
public class getRandomIndexTest {

    public static void main(String[] args) {
        Random random = new Random();

        Map<Integer,String> map = new HashMap<Integer, String>();
        int sizeOfDB = 19;
//        for (int i = 0; i <= 10; i++) {
//            int randomIndex = random.nextInt(sizeOfDB);
//            map.put(randomIndex, "record :" +i);
//            System.out.println(randomIndex + ", record :" +i);
//        }
        int i = 0;
        while (true){
            if(map.size()==10){
                break;
            }else{
                int randomIndex = random.nextInt(sizeOfDB);
                map.put(randomIndex, "record :" +i);
                System.out.println(randomIndex + ", record :" +i);
                i++;
            }
        }
        System.out.println(map);
    }
}
