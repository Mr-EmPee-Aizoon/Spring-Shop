package ml.empee.angularShop.model.category;

import ml.empee.angularShop.exceptions.ResourceNotFoundException;
import ml.empee.angularShop.model.category.dto.CategoryRequest;
import ml.empee.angularShop.model.category.dto.CategoryResponse;

import java.util.List;

public interface ICategoriesService {

    List<CategoryResponse> findCategories();
    CategoryResponse findCategoryByID(Long categoryID) throws ResourceNotFoundException;
    CategoryResponse updateCategory(Long categoryID, CategoryRequest product) throws ResourceNotFoundException;
    CategoryResponse saveCategory(CategoryRequest request);
    CategoryResponse deleteCategory(Long categoryID) throws ResourceNotFoundException;

}
