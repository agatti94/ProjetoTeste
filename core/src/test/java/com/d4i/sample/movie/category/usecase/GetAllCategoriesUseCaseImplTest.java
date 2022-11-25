package com.d4i.sample.movie.category.usecase;

import com.d4i.sample.movie.category.ports.CategoryRepositoryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetAllCategoriesUseCaseImplTest {

    private final CategoryRepositoryService categoryRepositoryService = mock(CategoryRepositoryService.class);

    private final GetAllCategoriesUseCaseImpl getAllCategoriesUseCase = new GetAllCategoriesUseCaseImpl(categoryRepositoryService);


    @Test
    void TestaSePegaAsCategoriasCorretamente(){
        getAllCategoriesUseCase.execute();
        verify(categoryRepositoryService).getAllCategories();

    }

}