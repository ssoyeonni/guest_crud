package edu.fisa.ce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fisa.ce.model.GuestEntity;
import edu.fisa.ce.repository.GuestRepository;

@RestController
@RequestMapping("/api")
public class GuestController {

    @Autowired
    private GuestRepository repository;

    // 방명록 전체 조회 (JSON 반환)
    @GetMapping("/guests")
    public List<GuestEntity> getGuests() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody GuestEntity request) {
        GuestEntity entry = new GuestEntity();
        entry.setName(request.getName());
        entry.setMessage(request.getMessage());
        repository.save(entry);
    }

    // 방명록 삭제
    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}