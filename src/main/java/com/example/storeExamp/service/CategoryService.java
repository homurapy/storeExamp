package com.example.storeExamp.service;


import com.example.storeExamp.dto.CategoryDto;
import com.example.storeExamp.model.Category;
import com.example.storeExamp.repository.CategoryRepository;
import com.example.storeExamp.utils.MappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public List<CategoryDto> findAll() {
        return repository.findAll().stream()
                .map(MappingUtil::categoryDto)
                .collect(Collectors.toList());
    }
    public  void deleteById(Long id){
        repository.deleteById(id);
    }
    public Category save(CategoryDto dto){
        Category category = MappingUtil.dtoToCategory(dto);
        return repository.save(category);
    }
}

