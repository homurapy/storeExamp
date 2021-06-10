package com.example.storeExamp.service;

import com.example.storeExamp.dto.ItemDto;
import com.example.storeExamp.model.Item;
import com.example.storeExamp.repository.CategoryRepository;
import com.example.storeExamp.repository.ItemRepository;
import com.example.storeExamp.utils.MappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.storeExamp.service.spec.ItemSpec;


@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository repository;
    private final CategoryRepository categoryRepository;

    public Page<ItemDto> findAll(Map<String, String> params, Integer pageNumber, Integer pageSize) {
        final Specification<Item> specification = ItemSpec.build(params);
        return repository.findAll(specification, PageRequest.of(pageNumber-1,pageSize)).map(MappingUtil::itemDto);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public Item save(ItemDto dto){
        return repository.save(MappingUtil.dtoToItem(dto,categoryRepository.getByName(dto.getCategory())));
    }
    public Item getById(Long id){
        return repository.getById(id);
    }
}
