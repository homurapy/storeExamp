package com.example.storeExamp.controller;

import com.example.storeExamp.dto.ItemDto;
import com.example.storeExamp.model.Item;
import com.example.storeExamp.service.ItemService;
import com.example.storeExamp.service.spec.ItemSpec;
import com.example.storeExamp.utils.MappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;
    @GetMapping
    public Page<ItemDto> findAll(@RequestParam(required = false) Map<String, String> params,
                                 @RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                 @RequestParam(name = "page-size", defaultValue = "5") Integer pageSize) {
        return service.findAll(params, pageNumber, pageSize);
    }

    @PostMapping
    public Item save(@RequestBody ItemDto dto){
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
