package pl.fiszki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.fiszki.dao.WordDAO;
import pl.fiszki.models.Word;

/**
 * Created by Bartek on 31.01.2017.
 */
@Controller
public class WordController {

    @Autowired
    private WordDAO wordDAO;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveNewWord(Model model) {
        model.addAttribute("wordForm");
        return "addForm";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNewWord(@RequestParam(value = "polski")String polski,
                       @RequestParam (value = "angielski") String angielski,
                       Model model){
        Word word = new Word();
        word.setPolski(polski);
        word.setAngielski(angielski);
        wordDAO.add(word);
        model.addAttribute("polski",polski);
        model.addAttribute("angielski",angielski);
        return "succAdd";
    }


}
