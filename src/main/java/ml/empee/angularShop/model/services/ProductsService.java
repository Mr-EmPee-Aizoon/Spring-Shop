package ml.empee.angularShop.model.services;

import ml.empee.angularShop.exceptions.ResourceNotFound;
import ml.empee.angularShop.model.product.ProductEntity;
import ml.empee.angularShop.model.product.dto.ProductRequest;
import ml.empee.angularShop.model.product.dto.ProductResponse;
import ml.empee.angularShop.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductsService implements IProductsService {

    @Autowired
    ProductRepository repo;

    @Override
    public List<ProductResponse> findProducts() {
        return repo.findAll().stream().map(
                p -> new ProductResponse().copyFrom(p)
        ).collect(Collectors.toList());
    }

    @Override
    public ProductResponse findProductByID(Long productID) throws ResourceNotFound {
        return new ProductResponse().copyFrom(
                getProductByID(productID)
        );
    }

    @Override
    public ProductResponse saveProduct(ProductRequest request) {
        ProductEntity savedEntity = repo.save(request.copyTo(new ProductEntity()));
        return new ProductResponse().copyFrom(savedEntity);
    }

    @Override
    public ProductResponse updateProduct(Long productID, ProductRequest product) throws ResourceNotFound {
        ProductEntity target = getProductByID(productID);
        return new ProductResponse().copyFrom(
                repo.save(product.copyTo(target))
        );
    }

    @Override
    public ProductResponse deleteProduct(Long productID) throws ResourceNotFound {
        ProductEntity target = getProductByID(productID);

        repo.deleteById(productID);
        return new ProductResponse().copyFrom(target);
    }

    /**
     * @throws ResourceNotFound if that product doesn't exists
     */
    private ProductEntity getProductByID(Long prodID) throws ResourceNotFound {
        return repo.findById(prodID)
                .orElseThrow(
                        () -> new ResourceNotFound("Can't find the product " + prodID)
                );
    }

}
