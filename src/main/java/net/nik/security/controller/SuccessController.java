package net.nik.security.controller;


import net.nik.security.domain.Book;
import net.nik.security.domain.Genres;
import net.nik.security.service.BookService;
import net.nik.security.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/auth/")
public class SuccessController {

    private final BookService bookService;
    private final GenreService genreService;

    @Autowired
    public SuccessController(BookService bookService, GenreService genreService) {
        this.bookService = bookService;
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public String allGenres(Model model){
        List<Genres> genresList=genreService.listAll();
        model.addAttribute("genreList",genresList);
        return "genres";
    }

    @GetMapping("/success")
    public String getSuccessPage(Model model) {
        List<Book> bookList=bookService.listAll();
        model.addAttribute("bookList",bookList);
        return "success";
    }
}
