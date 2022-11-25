package com.d4i.sample.movie.category.usecase;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.category.ports.exception.CategoryAlreadyExistException;

public interface CreateCategoryUseCase {

	public void execute(Category category) throws CategoryAlreadyExistException ;

}
