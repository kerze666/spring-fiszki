package pl.fiszki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.fiszki.dao.WordDAO;
import pl.fiszki.models.Word;

import java.util.Random;

/**
 * Created by Bartek on 25.02.2017.
 */

@Controller
public class TestController {

    @Autowired
    private WordDAO wordDAO;

    // fiszki wyświetlają polski ządają odpowiedzi angielskiej
    @RequestMapping(value = "/testcard", method = RequestMethod.GET)
    public String getRandomFlashCard(Model model) {
        Random random = new Random();
        model.addAttribute("word", wordDAO.getWordById(random.nextInt(1000)));
        return "testEng";
    }

    @RequestMapping(value = "/checkanswer", method = RequestMethod.POST)
    public String checkFlashcard(Model model,
                                 @RequestParam("answer") String answer,
                                 @RequestParam("id") long id){

        model.addAttribute("answer", answer);
        Word word = wordDAO.getWordById(id);
        model.addAttribute("word",word);

        if (word.getAngielski().equals(answer.toLowerCase())) {
            return "successEng";
        } else {
            return "faultEng";
        }
    }

    // fiszki wyświetlają 4 fiszki i żądają odpowiedzi
//    @RequestMapping(value = "/testcardpol")
//    public String getPolandRandomFlashcards(Model model){
//        model.addAttribute("list",wordDAO.getRandomFlashcards(4));
//        return "testPol";
//    }
//
//    @RequestMapping(value = "/checkanswerPol")
//    public String checkFlashcards(Model model){
//        model.addAttribute("list",wordDAO.getRandomFlashcards(4));
//        return "testPol";
//    }


}
