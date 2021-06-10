package com.example.storeExamp.utils;

import com.example.storeExamp.dto.CategoryDto;
import com.example.storeExamp.dto.ItemDto;
import com.example.storeExamp.model.Category;
import com.example.storeExamp.model.Item;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MappingUtil {
    public static ItemDto itemDto(Item item) {
        return new ItemDto(item.getId(), item.getName(),item.getPrice(), item.getCategory().getName());
    }
    public static CategoryDto categoryDto(Category category) {
        return new CategoryDto(category.getId(), category.getName());
    }

    public static Item dtoToItem(ItemDto dto, Category category) {
        return new Item(dto.getId(), dto.getName(), dto.getPrice(), 0, category);
    }
    public static Category dtoToCategory(CategoryDto categoryDto) {
        return new Category(categoryDto.getId(), categoryDto.getName(), new ArrayList<>());
    }

}
