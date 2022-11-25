package com.d4i.sample.movie.category.usecase;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.category.ports.CategoryRepositoryService;
import com.d4i.sample.movie.category.ports.exception.CategoryAlreadyExistException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateCategoryUseCaseTest {

    private final CategoryRepositoryService categoryRepositoryService = mock(CategoryRepositoryService.class);
    private final CreateCategoryUseCaseImpl createCategoryUseCaseImpl = new CreateCategoryUseCaseImpl(categoryRepositoryService);
    private Category category = new Category((long) 1, "romance", true);

    @Test
    void TesteSalvarCategoriaCorretamente() {
        when(categoryRepositoryService.doesCategoryNameExists(any())).thenReturn(false);

        assertDoesNotThrow(() -> createCategoryUseCaseImpl.execute(category));
        verify(categoryRepositoryService).saveCategory(any());

    }

    @Test
    void TesteSalvarCategoriaErroneamente() {
        when(categoryRepositoryService.doesCategoryNameExists(any())).thenReturn(true);

        assertThrows(CategoryAlreadyExistException.class, () -> createCategoryUseCaseImpl.execute(category));
        verify(categoryRepositoryService, times(0)).saveCategory(any());

    }
}