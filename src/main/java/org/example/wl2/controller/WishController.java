package org.example.wl2.controller;

import jakarta.servlet.http.HttpSession;
import org.example.wl2.model.WishlistModel;
import org.example.wl2.service.WishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WishController {
    private final WishService service;

    public WishController(WishService service) {
        this.service = service;
    }

    @GetMapping("/wishes")
    public String showWishes(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) return "redirect:/login";
        model.addAttribute("wishes", service.getAllWishesByUSer(userId));
        model.addAttribute("wish", new WishlistModel());
        return "wishList";
    }

    @GetMapping("/add")
    public String addWish(Model model) {
        model.addAttribute("wish", new WishlistModel());
        return "wishes";
    }

    @PostMapping("/add")
    public String addWish(HttpSession session, @ModelAttribute WishlistModel wish) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) return "redirect:/login";

        wish.setUserId(userId);
        service.addWish(wish);
        return "redirect:/wishes";
    }

   /* @GetMapping("/wishes/{id}/update")
    public String updateWish(@PathVariable int id, Model model){
        model.addAttribute("wish", service.getById(id));
        return "update";
    }

    */

    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute WishlistModel model){
        service.updateWish(model.getId(),model);
        return "redirect:/wishes";
    }

    @PostMapping("/delete/{id}")
    public String deleteWish(@PathVariable int id){
        service.delete(id);
        return "redirect:/wishes";
    }
}

