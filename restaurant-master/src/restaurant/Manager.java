package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee{

    @Override
    public List<String> printOrderData() {
        List<String> orders = new ArrayList<String>();
        for (Order order : file.getRestaurant().getOrders().getOrders()) {
            orders.add("Name: " + order.getCustomerName() + "\tTable: " + order.getTableNumber() + "\tCheck: " + order.getTotalCheck());
        }
        return orders;
    }
    public List<Dishes> printOrderDishes(){

        List<Dishes> dishes = new ArrayList<Dishes>();
        for(Order order : file.getRestaurant().getOrders().getOrders()){
            dishes.add(order.getDishes());
        }
        return dishes;
    }
}
