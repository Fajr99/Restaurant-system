package restaurant;

import restaurant.Dishes;
import restaurant.User;
import restaurant.Table;
import restaurant.dish;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
    @XmlElement(name = "tableNumber")
    private int tableNumber;

    @XmlElement(name = "customerName")
    private String customerName;

    @XmlElement(name = "dishes" )
    private Dishes dishes;

    @XmlElement(name = "totalCheck")
    private float totalCheck;

    public Order(int tableNumber, String customerName, Dishes dishes, float totalCheck) {
        this.tableNumber = tableNumber;
        this.customerName = customerName;
        this.dishes = dishes;
        this.totalCheck = totalCheck;
    }

    public float getTotalCheck() {
        return totalCheck;
    }

    public Dishes getDishes() {
        return dishes;
    }
    public String getCustomerName(){
        return customerName;
    }
    public int getTableNumber() {
        return tableNumber;
    }
}
