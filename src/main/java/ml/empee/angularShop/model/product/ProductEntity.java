package ml.empee.angularShop.model.product;

import lombok.Getter;
import lombok.Setter;
import ml.empee.angularShop.model.category.CategoryEntity;

import javax.persistence.*;

@Entity @Getter @Setter
@Table(name = "products")
public class ProductEntity {

    @Id @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne()
    @JoinColumn(name="category_id", nullable=false)
    private CategoryEntity category;

    @Column(name = "image_path")
    private String imagePath;

}
