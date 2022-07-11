package ml.empee.angularShop.model.services;

import ml.empee.angularShop.exceptions.ResourceNotFoundException;
import ml.empee.angularShop.model.product.dto.ProductRequest;
import ml.empee.angularShop.model.product.dto.ProductResponse;

import java.util.List;

public interface IProductsService {
    List<ProductResponse> findProducts();
    ProductResponse findProductByID(Long productID) throws ResourceNotFoundException;
    List<ProductResponse> findProductsByCategory(Long categoryID);
    ProductResponse updateProduct(Long productID, ProductRequest product) throws ResourceNotFoundException;
    ProductResponse saveProduct(ProductRequest request);
    ProductResponse deleteProduct(Long productID) throws ResourceNotFoundException;
}
