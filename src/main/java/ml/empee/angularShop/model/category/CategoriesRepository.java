package ml.empee.angularShop.model.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CategoriesRepository extends JpaRepository<CategoryEntity, Long> {
}
