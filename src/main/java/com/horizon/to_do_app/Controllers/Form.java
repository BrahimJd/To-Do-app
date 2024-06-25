package com.horizon.to_do_app.Controllers;

import com.horizon.to_do_app.Models.Item;
import com.horizon.to_do_app.Services.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Form {
    @Autowired
    private ItemService itemService;

    @GetMapping("/create-item")
    public String showForm(Model model) {
        model.addAttribute("item", new Item());
        return "create-item";
    }

    @PostMapping("/todo")
    public String createItem(@Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "create-item";
        }
        itemService.saveItem(item);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Item item = itemService.getItem(id);
        model.addAttribute("item", item);
        return "edit-item";
    }

    @PostMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, @Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            item.setId(id);
            return "edit-item";
        }
        itemService.saveItem(item);
        return "redirect:/";
    }
}
