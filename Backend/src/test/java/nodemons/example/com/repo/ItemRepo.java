package nodemons.example.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nodemons.example.com.Entity.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
    
}