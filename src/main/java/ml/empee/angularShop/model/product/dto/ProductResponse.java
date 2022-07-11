package ml.empee.angularShop.model.product.dto;

import lombok.Getter;
import lombok.Setter;
import ml.empee.angularShop.model.CommonDTO;
import ml.empee.angularShop.model.category.CategoryEntity;
import ml.empee.angularShop.model.product.ProductEntity;

@Getter @Setter
public class ProductResponse extends CommonDTO<ProductEntity, ProductResponse> {
    private Long id;

    private String title;

    private String description;

    private String size;

    private Double price;
    private Long categoryID;

    private String imagePath;

    public void setCategory(CategoryEntity category) {
        categoryID = category.getId();
    }

}
