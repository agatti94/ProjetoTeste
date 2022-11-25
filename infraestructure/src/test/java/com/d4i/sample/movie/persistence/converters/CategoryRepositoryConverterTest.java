package com.d4i.sample.movie.persistence.converters;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.persistence.entities.CategoryEntity;
import com.d4i.sample.movie.persistence.impl.CategoryServiceImpl;
import com.d4i.sample.movie.persistence.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CategoryRepositoryConverterTest {
    private final CategoryRepository categoryRepository = mock(CategoryRepository.class);

    private final CategoryRepositoryConverter categoryRepositoryConverter = new CategoryRepositoryConverter();
    private final CategoryServiceImpl categoryService = new CategoryServiceImpl(categoryRepository, categoryRepositoryConverter);

    private final Category category = new Category((long) 1, "romance", true);
    private final CategoryEntity categoryEntity = new CategoryEntity((long) 1, "romance", true);

    @Test
    void TestaMapeamentoDeObjetoParaTabela(){

        CategoryEntity categoryEntity = categoryRepositoryConverter.mapToTable(category);
        assertEquals(category.getName(), categoryEntity.getName());
    }
}