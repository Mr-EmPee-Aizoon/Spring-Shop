package ml.empee.angularShop.model.category;

import ml.empee.angularShop.exceptions.ResourceNotFoundException;
import ml.empee.angularShop.model.category.dto.CategoryRequest;
import ml.empee.angularShop.model.category.dto.CategoryResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoriesService implements ICategoriesService {

    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<CategoryResponse> findCategories() {
        return categoriesRepository.findAll().stream().map(
                c -> new CategoryResponse().copyFrom(c)
        ).toList();
    }

    @Override
    public CategoryResponse findCategoryByID(Long categoryID) throws ResourceNotFoundException {
        return new CategoryResponse().copyFrom(getCategoryByID(categoryID));
    }

    @Override
    public CategoryResponse updateCategory(Long categoryID, CategoryRequest request) throws ResourceNotFoundException {
        CategoryEntity target = getCategoryByID(categoryID);
        return new CategoryResponse().copyFrom(
                categoriesRepository.save(request.copyTo(target))
        );
    }

    public CategoryResponse saveCategory(CategoryRequest request) {
        CategoryEntity savedEntity = categoriesRepository.save(request.copyTo(new CategoryEntity()));
        return new CategoryResponse().copyFrom(savedEntity);
    }

    @Override
    public CategoryResponse deleteCategory(Long categoryID) throws ResourceNotFoundException {
        CategoryEntity categoryEntity = getCategoryByID(categoryID);

        categoriesRepository.deleteById(categoryID);
        return new CategoryResponse().copyFrom(categoryEntity);
    }

    private CategoryEntity getCategoryByID(Long categoryID) throws ResourceNotFoundException {
        return categoriesRepository.findById(categoryID)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Can't find the category " + categoryID)
                );
    }


}
