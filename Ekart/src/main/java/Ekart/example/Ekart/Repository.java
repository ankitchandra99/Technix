package Ekart.example.Ekart;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Product,Long> {
    List<Product> findByCategory(String category);
}
