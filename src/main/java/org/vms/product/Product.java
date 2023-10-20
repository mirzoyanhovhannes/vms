package org.vms.product;

public class Product {
    private final ProductId productId;
    private final String description;

    public Product(ProductId productId, String description) {
        this.productId = productId;
        this.description = description;
    }

    public ProductId getProductId() {
        return productId;
    }

    public String getDescription() {
        return description;
    }
}
