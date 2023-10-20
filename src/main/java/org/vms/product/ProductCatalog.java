package org.vms.product;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private final Map<ProductId, Product> products;

    public ProductCatalog() {
        ProductId productId1 = new ProductId(1);
        ProductId productId2 = new ProductId(2);
        products = new HashMap<>();

        products.put(productId1, new Product(productId1, "Product1"));
        products.put(productId2, new Product(productId2, "Product2"));
    }

    public Product getProduct(ProductId productId) {
        return products.get(productId);
    }
}
