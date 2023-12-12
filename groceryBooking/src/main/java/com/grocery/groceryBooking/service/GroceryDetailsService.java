package com.grocery.groceryBooking.service;

import com.grocery.groceryBooking.model.Grocery;
import com.grocery.groceryBooking.model.GroceryAPIModel;

import java.util.List;

public interface GroceryDetailsService {
    public Grocery addDetails(GroceryAPIModel grocery);
    public List<Grocery> getGroceries();

    Grocery updateGrocery(int id,String columnName,String data);
    void delete(int id);
}
