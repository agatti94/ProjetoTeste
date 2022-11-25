package com.d4i.sample.movie.persistence.impl;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.category.ports.CategoryRepositoryService;
import com.d4i.sample.movie.persistence.converters.CategoryRepositoryConverter;
import com.d4i.sample.movie.persistence.entities.CategoryEntity;
import com.d4i.sample.movie.persistence.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceImplTest {
    private final CategoryRepository categoryRepository = mock(CategoryRepository.class);

    private final CategoryRepositoryConverter categoryRepositoryConverter = mock(CategoryRepositoryConverter.class);
    private final CategoryServiceImpl categoryService = new CategoryServiceImpl(categoryRepository, categoryRepositoryConverter);

    private final Category category = new Category((long) 1, "romance", true);
    private final CategoryEntity categoryEntity = new CategoryEntity((long) 1, "romance", true);

    @Test
    void TestarPegarTodasAsCategoriasCorretamente(){
        List<CategoryEntity> categoryEntityList = List.of(categoryEntity);
        when(categoryRepository.findAll()).thenReturn(categoryEntityList);
        when(categoryRepositoryConverter.mapToEntity(ArgumentMatchers.any())).thenReturn(category);

        Collection<Category> categories =  categoryService.getAllCategories();
        assertEquals(categoryEntity.getName(), categories.stream().findFirst().get().getName());
        assertEquals(categoryEntity.getAvailable(), categories.stream().findFirst().get().getAvailable());

    }

    @Test
    void TesteSalvaCategoriaCorretamente(){
        when(categoryRepositoryConverter.mapToTable(category)).thenReturn(categoryEntity);
        categoryService.saveCategory(category);
        verify(categoryRepository, times(1)).save(any());
        verify(categoryRepositoryConverter, times(1)).mapToTable(any());


    }
}