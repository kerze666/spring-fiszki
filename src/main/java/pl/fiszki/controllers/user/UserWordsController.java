package pl.fiszki.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.fiszki.models.user.User;
import pl.fiszki.models.words.Word;
import pl.fiszki.service.UserService;
import pl.fiszki.service.WordService;
import pl.fiszki.service.impl.CategoryServiceImpl;

import java.util.List;
import java.util.Random;

/**
 * Created by Bartek on 08.05.2017.
 */
@Controller
@Secured("ROLE_USER")
@RequestMapping("user")
public class UserWordsController {

    @Autowired
    private WordService wordService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @RequestMapping(value = "addword", method = RequestMethod.GET)
    public String addWordToCategorySite(Model model, @RequestParam("idCat") long idCat) {

        model.addAttribute("idCat", idCat);
//        model.addAttribute("listOfWords", // motoda na pobranie aktualnych słowek z danej kategorii )
//                model.addAttribute("category", //metoda na popranie nazwy kategorii)

        return "user/addword";
    }
    @RequestMapping(value = "addword", method = RequestMethod.POST)
    public String addWordToCategorySite(Model model,
                                        @RequestParam(value = "idCat") long idCat,
                                        @RequestParam(value = "polish") String polish,
                                        @RequestParam(value = "english") String english) {

        User user = userService.getUserByUserNameAndStatus(SecurityContextHolder.getContext().getAuthentication().getName());
        Word word = new Word();
        word.setAngielski(english);
        word.setPolski(polish);
        word.setCatId(idCat);
        word.setUserid(user.getId());

        wordService.createWord(word);

        model.addAttribute("idCat", idCat);
        return "redirect:/user/addword";
    }


    @RequestMapping(value = "wordslist", method = RequestMethod.GET)
    public String listOfWordsSite(Model model, @RequestParam("idCat") long idCat) {

        model.addAttribute("listOfWords", wordService.getListOfWordsByIdCategory(idCat));
        return "user/wordslist";
    }

    @RequestMapping(value = "testcategory", method = RequestMethod.GET)
    public String testWithFlashcardSite(Model model, @RequestParam(value = "idCat")long catId){
        List<Word> wordList = wordService.getListOfWordsByIdCategory(catId);
        Random random = new Random();
        model.addAttribute("word",wordList.get(random.nextInt(wordList.size())));

        return "user/flashcards/flashcards";
    }
    @RequestMapping(value = "/checkanswer", method = RequestMethod.POST)
    public String checkFlashcard(Model model,
                                 @RequestParam("answer") String answer,
                                 @RequestParam("id") long id) {

        model.addAttribute("answer", answer);
        Word word = wordService.findWordById(id);
        model.addAttribute("word", word);

        if (word.getAngielski().equals(answer.toLowerCase())) {
            return "/user/flashcards/successEng";
        } else {
            return "/user/flashcards/faultEng";
        }
    }

}
