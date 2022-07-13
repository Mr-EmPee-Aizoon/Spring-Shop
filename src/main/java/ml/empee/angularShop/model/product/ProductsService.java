package ml.empee.angularShop.model.product;

import ml.empee.angularShop.exceptions.ResourceNotFoundException;
import ml.empee.angularShop.model.product.dto.ProductRequest;
import ml.empee.angularShop.model.product.dto.ProductResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductsService implements IProductsService {
    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<ProductResponse> findProducts() {
        return productsRepository.findAll().stream().map(
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
        ProductEntity savedEntity = productsRepository.save(request.copyTo(new ProductEntity()));
        return new ProductResponse().copyFrom(savedEntity);
    }

    @Override
    public ProductResponse updateProduct(Long productID, ProductRequest product) throws ResourceNotFoundException {
        ProductEntity target = getProductByID(productID);
        return new ProductResponse().copyFrom(
                productsRepository.save(product.copyTo(target))
        );
    }

    @Override
    public ProductResponse deleteProduct(Long productID) throws ResourceNotFoundException {
        ProductEntity target = getProductByID(productID);

        productsRepository.deleteById(productID);
        return new ProductResponse().copyFrom(target);
    }

    public List<ProductResponse> findProductsByCategory(Long categoryID) {
        return productsRepository.findProductsByCategory(categoryID).stream().map(
                productEntity -> new ProductResponse().copyFrom(productEntity)
        ).collect(Collectors.toList());
    }

    /**
     * @throws ResourceNotFoundException if that product doesn't exists
     */
    private ProductEntity getProductByID(Long prodID) throws ResourceNotFoundException {
        return productsRepository.findById(prodID)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Can't find the product " + prodID)
                );
    }

}
