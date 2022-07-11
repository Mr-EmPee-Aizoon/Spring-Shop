package ml.empee.angularShop.model.category.dto;

import lombok.Getter;
import lombok.Setter;
import ml.empee.angularShop.model.CommonDTO;
import ml.empee.angularShop.model.category.CategoryEntity;

@Getter @Setter
public class CategoryResponse extends CommonDTO<CategoryEntity, CategoryResponse> {

    private Long id;
    private String name;

}
