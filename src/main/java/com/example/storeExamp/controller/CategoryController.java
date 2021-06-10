package com.example.storeExamp.controller;

import com.example.storeExamp.dto.CategoryDto;
import com.example.storeExamp.model.Category;
import com.example.storeExamp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.storeExamp.service.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public List<CategoryDto> findAll(){
        return service.findAll();
    }
    @PostMapping
    public Category save(CategoryDto dto){
        return service.save(dto);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
