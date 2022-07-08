package ml.empee.angularShop.model.services;

import ml.empee.angularShop.exceptions.ResourceNotFoundException;
import ml.empee.angularShop.model.product.ProductEntity;
import ml.empee.angularShop.model.product.dto.ProductRequest;
import ml.empee.angularShop.model.product.dto.ProductResponse;
import ml.empee.angularShop.model.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductsService implements IProductsService {
    private final ProductRepository productRepository;

    public ProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponse> findProducts() {
        return productRepository.findAll().stream().map(
                p -> new ProductResponse().copyFrom(p)
        ).collect(Collectors.toList());
    }

    @Override
    public ProductResponse findProductByID(Long productID) throws ResourceNotFoundException {
        return new ProductResponse().copyFrom(
                getProductByID(productID)
        );
    }

    @Override
    public ProductResponse saveProduct(ProductRequest request) {
        ProductEntity savedEntity = productRepository.save(request.copyTo(new ProductEntity()));
        return new ProductResponse().copyFrom(savedEntity);
    }

    @Override
    public ProductResponse updateProduct(Long productID, ProductRequest product) throws ResourceNotFoundException {
        ProductEntity target = getProductByID(productID);
        return new ProductResponse().copyFrom(
                productRepository.save(product.copyTo(target))
        );
    }

    @Override
    public ProductResponse deleteProduct(Long productID) throws ResourceNotFoundException {
        ProductEntity target = getProductByID(productID);

        productRepository.deleteById(productID);
        return new ProductResponse().copyFrom(target);
    }

    /**
     * @throws ResourceNotFoundException if that product doesn't exists
     */
    private ProductEntity getProductByID(Long prodID) throws ResourceNotFoundException {
        return productRepository.findById(prodID)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Can't find the product " + prodID)
                );
    }

}
