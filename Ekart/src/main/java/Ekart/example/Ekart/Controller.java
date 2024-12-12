package Ekart.example.Ekart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/createProduct")

    public String addProduct(@RequestBody Product product){

        return service.addProduct(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product=service.getProductById(id);
        return new ResponseEntity(product, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
       List<Product> l1=service.getAllProducts();
       return  new ResponseEntity(l1,HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        List<Product> l1=service.getProductsByCategory(category);
        return new ResponseEntity(l1, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product) {
        return ResponseEntity.ok(service.updateProduct(id, product));
    }

  @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return service.deleteProduct(id);

    }
}


