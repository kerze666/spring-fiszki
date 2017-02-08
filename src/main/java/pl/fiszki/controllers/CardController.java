package pl.fiszki.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.fiszki.dao.WordDAO;
import pl.fiszki.models.Word;

import java.util.Map;

/**
 * Created by Bartek on 05.02.2017.
 */
@Controller
@RequestMapping(value = "/fiszki")
public class CardController {

    @Autowired
    private WordDAO wordDAO;

    // pobiera od użyszkodnika ilość fiszek
    @RequestMapping(method = RequestMethod.GET)
    public String setCountRandomFlashcards(Model model){
        model.addAttribute("fiszkiForm");
        return "fiszkiForm";
    }

    // pobrać kolekcję fiszek wylosowanych getRandomFlashcards
    // metoda otrzyma od użyszkodnika liczbę fiszek i przekaże Map'e fiszek do fiszki.jsp
    // sukcesywnie pokazywać użyszkodnikowi fiszki z pomocą JavaScriptu
    // dodać @Valid na liczbę fiszek
    @RequestMapping(method = RequestMethod.POST)
    public String getCountRandomFlashcards(@RequestParam int count, Model model){
        Map<Long,Word> map = wordDAO.getRandomFlashcards(count);
        model.addAttribute("map", map);
        return "fiszki";
    }

}
