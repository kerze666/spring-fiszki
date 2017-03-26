package pl.fiszki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.fiszki.dao.WordDAO;
import pl.fiszki.models.Word;

import java.util.List;

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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String show200Words(Model model){
        List<Word> list = wordDAO.getListOfWords(0,200);
        model.addAttribute("list", list);
        return "list200";
    }
    @RequestMapping(value = "/200_400", method = RequestMethod.GET)
    public String show400Words(Model model){
        List<Word> list = wordDAO.getListOfWords(200, 400);
        model.addAttribute("list", list);
        return "list400";
    }
    @RequestMapping(value = "/400_600", method = RequestMethod.GET)
    public String show600Words(Model model){
        List<Word> list = wordDAO.getListOfWords(400, 600);
        model.addAttribute("list", list);
        return "list600";
    }
    @RequestMapping(value = "/600_800", method = RequestMethod.GET)
    public String show800Words(Model model){
        List<Word> list = wordDAO.getListOfWords(600, 800);
        model.addAttribute("list", list);
        return "list800";
    }
    @RequestMapping(value = "/800_1000", method = RequestMethod.GET)
    public String show1000Words(Model model){
        List<Word> list = wordDAO.getListOfWords(800, 1000);
        model.addAttribute("list", list);
        return "list1000";
    }
}
