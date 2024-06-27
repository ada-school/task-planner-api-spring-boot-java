package org.adaschool.api.service.product;

import org.adaschool.api.repository.product.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductsServiceMap implements ProductsService {

    private final Map<String, Product> productMap = new HashMap<>();

    @Override
    public Product save(Product product) {
        productMap.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.ofNullable(productMap.get(id));
    }

    @Override
    public List<Product> all() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void deleteById(String id) {
        productMap.remove(id);
    }

    @Override
    public Product update(Product product, String productId) {
        if (productMap.containsKey(productId)) {
            productMap.put(productId, product);
            return product;
        }
        return null;
    }
}