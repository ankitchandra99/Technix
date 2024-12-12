package Ekart.example.Ekart;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;
    public String addProduct(Product product) {
        repository.save(product);

        return "product saved";

    }

    public Optional<Product> getProductById(Long id) {
       Optional<Product> p1=repository.findById(id);

       return p1;
    }

    public List<Product> getAllProducts() {
        List<Product> p1=repository.findAll();
        return p1;
    }

    public List<Product> getProductsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        // Retrieve the existing product
        Optional<Product> optionalProduct = repository.findById(id);
        Product product = optionalProduct.get();


            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setCategory(updatedProduct.getCategory());
            return repository.save(product);

    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
