package com.grocery.groceryBooking.service;

import com.grocery.groceryBooking.model.Grocery;
import com.grocery.groceryBooking.model.GroceryAPIModel;
import com.grocery.groceryBooking.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GroceryDetailsServiceImpl implements GroceryDetailsService{

    @Autowired
    private GroceryRepository groceryRepository;

    @Override
    public Grocery addDetails(GroceryAPIModel grocery) {
        Grocery groceryObject=new Grocery();
        groceryObject.setName(grocery.getName());
        groceryObject.setPrice(grocery.getPrice());
        groceryObject.setQuantity(grocery.getQuantity());

        return groceryRepository.save(groceryObject);
    }

    @Override
    public List<Grocery> getGroceries() {
        return groceryRepository.findAll();
    }

    @Override
    public Grocery updateGrocery(int id,String columnName,String value) {
        Grocery groceryObject=new Grocery();
        Optional<Grocery> groceryResult=groceryRepository.findById(id);
        Grocery groceryRecord=null;
        if(groceryResult.isPresent()){
            groceryRecord=groceryResult.get();
            if(columnName.equals("name"))
                groceryRecord.setName(value);
            else if(columnName.equals("price"))
                groceryRecord.setPrice(Double.parseDouble(value));
            else if(columnName.equals("quantity"))
                groceryRecord.setQuantity(Double.parseDouble(value));
            return groceryRepository.save(groceryRecord);
        }
        else{
            return new Grocery();
        }

    }

    @Override
    public void delete(int id) {
         groceryRepository.deleteById(id);
    }
}
