package ml.empee.angularShop.model.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id @Getter @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "prod_seq", allocationSize = 1, name = "CUST_SEQ")
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter
    @Column(name = "title", nullable = false)
    private String title;

    @Getter @Setter
    @Column(name = "description", nullable = false)
    private String description;

    @Getter @Setter
    @Column(name = "size", nullable = false)
    private String size;

    @Getter @Setter
    @Column(name = "price", nullable = false)
    private Double price;

    @Getter @Setter
    @Column(name = "category", nullable = false)
    private String category; //TODO maybe an enum?

    @Getter @Setter
    @Column(name = "image_path")
    private String imagePath;

}
