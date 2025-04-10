package edu.fisa.ce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fisa.ce.model.GuestEntity;
import edu.fisa.ce.repository.GuestRepository;

@Controller
public class GuestController {

    @Autowired
    private GuestRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        List<GuestEntity> entries = repository.findAll();
        model.addAttribute("entries", entries);
        System.out.println("조회된 엔트리 수: " + entries.size());
        for (GuestEntity e : entries) {
            System.out.println("▶ name: " + e.getName() + ", message: " + e.getMessage());
        }
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam("name") String name, @RequestParam("message") String message) {
        GuestEntity entry = new GuestEntity();
        entry.setName(name);
        entry.setMessage(message);
        repository.save(entry);
        return "redirect:/";
    }
    
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
    
    
}