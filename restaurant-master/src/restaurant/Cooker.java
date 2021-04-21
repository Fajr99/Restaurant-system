package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Cooker extends Employee{
    @Override
    public List<String> printOrderData() {
        List<String> orders = new ArrayList<String>();
        for (Order order : file.getRestaurant().getOrders().getOrders())
            for(dish plate : order.getDishes().getDishes())
                for(int i=0;i<plate.getQuantity();i++)
                    orders.add("Name: " + plate.getName() + "\t\tTable: " + order.getTableNumber());

        return orders;
    }
}
