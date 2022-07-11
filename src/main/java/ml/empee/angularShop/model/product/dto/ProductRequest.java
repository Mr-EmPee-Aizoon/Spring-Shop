package ml.empee.angularShop.model.product.dto;

import lombok.Getter;
import lombok.Setter;
import ml.empee.angularShop.model.CommonDTO;
import ml.empee.angularShop.model.category.CategoryEntity;
import ml.empee.angularShop.model.product.ProductEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter @Setter
public class ProductRequest extends CommonDTO<ProductEntity, ProductRequest>  {
    @NotBlank(message = "The title can't be blank")
    @Pattern(message = "The title must start with a letter and not longer then 22 chars", regexp = "[a-z|A-Z].{0,21}")
    private String title;

    @NotBlank(message = "The description can't be blank")
    @Pattern(message = "The description can't be longer then 151 chars", regexp = ".{0,151}")
    private String description;

    @NotBlank(message = "The size can't be blank")
    private String size;

    @Min(message = "The price can't be lower the 0", value = 0)
    @NotNull(message = "The price can't be null")
    private Double price;
    @NotNull
    private Long categoryID;

    private String imagePath;
    public CategoryEntity getCategory() {
        CategoryEntity category = new CategoryEntity();
        category.setId(categoryID);
        return category;
    }

}
