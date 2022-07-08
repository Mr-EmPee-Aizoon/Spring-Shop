package ml.empee.angularShop.model.product.dto;

import lombok.Getter;
import lombok.Setter;
import ml.empee.angularShop.model.CommonDTO;
import ml.empee.angularShop.model.product.ProductEntity;

public class ProductResponse extends CommonDTO<ProductEntity, ProductResponse> {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private String size;

    @Getter @Setter
    private Double price;

    @Getter @Setter
    private String category;

    @Getter @Setter
    private String imagePath;


}
