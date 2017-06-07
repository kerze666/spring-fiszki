package pl.fiszki.controllers.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.fiszki.models.words.Word;
import pl.fiszki.service.CategoryService;
import pl.fiszki.service.WordService;

import java.util.List;
import java.util.Random;

/**
 * Created by Bartek on 08.05.2017.
 */
@Controller
@PreAuthorize("hasRole('USER')")
@RequestMapping("/user")
public class UserWordsController {

    @Autowired
    private WordService wordService;

    @Autowired
    private CategoryService categoryService;

    private static Logger logger = Logger.getLogger(UserWordsController.class);


    @RequestMapping(value = "addword", method = RequestMethod.GET)
    public String addWordToCategorySite(Model model,
                                        @RequestParam("idCat") long idCat) {

        model.addAttribute("idCat", idCat);
        model.addAttribute("listOfWords", wordService.findListOfWordsByIdCategory(idCat));


        return "user/addword";
    }

    @RequestMapping(value = "addword", method = RequestMethod.POST)
    public String addWordToCategorySite(Model model,
                                        @RequestParam(value = "idCat") long idCat,
                                        @RequestParam(value = "polish") String polish,
                                        @RequestParam(value = "english") String english) {

        Word word = new Word();
        word.setAngielski(english);
        word.setPolski(polish);
        word.setCategory(categoryService.findCategoryById(idCat));

        wordService.createWord(word);

        logger.warn("Add word: "+english+ " - "+polish);

        model.addAttribute("idCat", idCat);
        model.addAttribute("message", word);

        return "redirect:/user/addword";
    }


    @RequestMapping(value = "wordslist", method = RequestMethod.GET)
    public String listOfWordsSite(Model model,
                                  @RequestParam("idCat") long idCat,
                                  RedirectAttributes redirectAttributes) {

        List<Word> wordList = wordService.findListOfWordsByIdCategory(idCat);
        if (!wordList.isEmpty()) {
            model.addAttribute("listOfWords", wordService.findListOfWordsByIdCategory(idCat));
            return "user/wordslist";
        } else {
            redirectAttributes.addFlashAttribute("message",
                    " Nie masz jeszcze słówek katalogu " + categoryService.findCategoryById(idCat).getCategory() + " ! ");
            return "redirect:/user";
        }
    }

    @RequestMapping(value = "testcategory", method = RequestMethod.GET)
    public String testWithFlashcardSite(Model model,
                                        @RequestParam(value = "idCat") long catId,
                                        RedirectAttributes redirectAttributes) {
        List<Word> wordList = wordService.findListOfWordsByIdCategory(catId);
        if (!wordList.isEmpty()) {
            Random random = new Random();
            model.addAttribute("word", wordList.get(random.nextInt(wordList.size())));
            return "user/flashcards/flashcards";
        } else {
            redirectAttributes.addFlashAttribute("message",
                    " Nie masz jeszcze słówek do testowania w katalogu " + categoryService.findCategoryById(catId).getCategory() + " ! ");
            return "redirect:/user";
        }
    }

    @RequestMapping(value = "/checkanswer", method = RequestMethod.POST)
    public String checkFlashcard(Model model,
                                 @RequestParam("answer") String answer,
                                 @RequestParam("id") long id) {

        model.addAttribute("answer", answer);
        Word word = wordService.findWordById(id);
        model.addAttribute("word", word);

        logger.warn("Result : "+word.getAngielski()+"-"+(answer.toLowerCase().trim()));
        if (word.getAngielski().toLowerCase().trim().equals(answer.toLowerCase().trim())) {
            return "/user/flashcards/successEng";
        } else {
            return "/user/flashcards/faultEng";
        }
    }

    @RequestMapping(value = "addword/delete/{idWord}", method = RequestMethod.GET)
    public String deleteWordFromAddingSite(Model model,
                                 @PathVariable("idWord") long id,
                                 @RequestParam("idCat") long idCat) {

        wordService.deleteWord(id);
        model.addAttribute("message", "Słówko zostało usunięte");
        model.addAttribute("idCat", idCat);
        return "redirect:/user/addword";
    }

    @RequestMapping(value = "wordslist/delete/{idWord}", method = RequestMethod.GET)
    public String deleteUserPost(Model model,
                                 @PathVariable("idWord") long id,
                                 @RequestParam("idCat") long idCat) {

        wordService.deleteWord(id);
        model.addAttribute("message", "Słówko zostało usunięte");
        model.addAttribute("idCat", idCat);
        return "redirect:/user/wordslist";
    }
}
