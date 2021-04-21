package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Waiter extends Employee{
    @Override
    public List<String> printOrderData() {
        List<String> orders = new ArrayList<String>();
        for (Order order : file.getRestaurant().getOrders().getOrders()) {
            orders.add("Name: " + order.getCustomerName() + "\t\tTable: " + order.getTableNumber());
        }
        return orders;
    }
}
