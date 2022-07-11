package ml.empee.angularShop.model.category.dto;

import lombok.Getter;
import lombok.Setter;
import ml.empee.angularShop.model.CommonDTO;
import ml.empee.angularShop.model.category.CategoryEntity;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class CategoryRequest extends CommonDTO<CategoryEntity, CategoryRequest>  {

    @NotBlank
    private String name;

}
