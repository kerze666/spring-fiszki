package pl.fiszki.controllers.flashcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.fiszki.models.words.Word;
import pl.fiszki.service.CategoryService;
import pl.fiszki.service.WordService;

import java.util.List;
import java.util.Random;

/**
 * Created by Bartek on 25.02.2017.
 */

@Controller
public class TestController {

    @Autowired
    private WordService wordService;

    // fiszki wyświetlają polski ządają odpowiedzi angielskiej
    @RequestMapping(value = "/testcard", method = RequestMethod.GET)
    public String getRandomFlashCard(Model model) {
        List<Word> wordList = wordService.findListOfWordsByIdCategory(1);
        Random random = new Random();
        model.addAttribute("word",wordList.get(random.nextInt(wordList.size())));
        return "testEng";
    }

    @RequestMapping(value = "/checkanswer", method = RequestMethod.POST)
    public String checkFlashcard(Model model,
                                 @RequestParam("answer") String answer,
                                 @RequestParam("id") long id) {

        model.addAttribute("answer", answer);
        Word word = wordService.findWordById(id);
        model.addAttribute("word", word);

        if (word.getAngielski().equals(answer.toLowerCase())) {
            return "successEng";
        } else {
            return "faultEng";
        }
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listOfWords(Model model){
        List<Word> list = wordService.findListOfWordsByIdCategory(1);
        model.addAttribute("list", list);
        return "list";
    }


}
