package ml.empee.angularShop.model.repository;

import ml.empee.angularShop.model.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value = "from ProductEntity where category_id = ?1")
    List<ProductEntity> findProductsByCategory(Long categoryID);

}
