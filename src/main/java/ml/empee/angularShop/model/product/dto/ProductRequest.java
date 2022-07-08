package ml.empee.angularShop.model.product.dto;

import lombok.Getter;
import lombok.Setter;
import ml.empee.angularShop.model.CommonDTO;
import ml.empee.angularShop.model.product.ProductEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ProductRequest extends CommonDTO<ProductEntity, ProductRequest>  {
    @Getter @Setter
    @NotBlank(message = "The title can't be blank")
    @Pattern(message = "The title must start with a letter and not longer then 22 chars", regexp = "[a-z|A-Z].{0,21}")
    private String title;

    @Getter @Setter
    @NotBlank(message = "The description can't be blank")
    @Pattern(message = "The description can't be longer then 151 chars", regexp = ".{0,151}")
    private String description;

    @NotBlank(message = "The size can't be blank")
    @Getter @Setter
    private String size;

    @Min(message = "The price can't be lower the 0", value = 0)
    @NotNull(message = "The price can't be null")
    @Getter @Setter
    private Double price;

    @NotBlank(message = "The category can't be blank")
    @Getter @Setter
    private String category;

    @Getter @Setter
    private String imagePath;
}
