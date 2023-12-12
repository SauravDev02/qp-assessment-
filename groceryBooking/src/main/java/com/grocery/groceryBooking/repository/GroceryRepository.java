package com.grocery.groceryBooking.repository;

import com.grocery.groceryBooking.model.Grocery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery,Integer> {
    public List<Grocery> findAll();

    public Grocery save(Grocery entity);


}
