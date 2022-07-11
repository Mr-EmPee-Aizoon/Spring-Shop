package ml.empee.angularShop.controller;

import ml.empee.angularShop.exceptions.ResourceNotFoundException;
import ml.empee.angularShop.model.category.dto.CategoryRequest;
import ml.empee.angularShop.model.category.dto.CategoryResponse;
import ml.empee.angularShop.model.services.CategoriesService;
import ml.empee.angularShop.model.services.ICategoriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class CategoriesController {

    private final ICategoriesService categoriesService;
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> findCategories() {
        return ResponseEntity.ok(categoriesService.findCategories());
    }

    @GetMapping(value = "/categories", params = "categoryID")
    public ResponseEntity<CategoryResponse> findCategoryByID(@RequestParam Long categoryID) throws ResourceNotFoundException {
        return ResponseEntity.ok(categoriesService.findCategoryByID(categoryID));
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoriesService.saveCategory(request));
    }

}
