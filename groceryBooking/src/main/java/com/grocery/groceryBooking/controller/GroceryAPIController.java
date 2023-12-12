package com.grocery.groceryBooking.controller;

import com.grocery.groceryBooking.model.Grocery;
import com.grocery.groceryBooking.model.GroceryAPIModel;
import com.grocery.groceryBooking.service.GroceryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/grocery")
public class GroceryAPIController {

    @Autowired
    GroceryDetailsService groceryDetailsService;

    @PostMapping("/add")
    public Grocery addGrocery(@RequestBody GroceryAPIModel grocery) {
        return groceryDetailsService.addDetails(grocery);
    }

    @GetMapping("/get")
    public List<Grocery> getGroceries() {
        return groceryDetailsService.getGroceries();
    }

    @PutMapping("/update/{id}")
    public Grocery updateGrocery(@PathVariable int id,@RequestParam String columnName,@RequestParam String value){
        return groceryDetailsService.updateGrocery(id,columnName,value);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        groceryDetailsService.delete(id);
        return "record deleted successfully";
    }

    //create order api..


}
