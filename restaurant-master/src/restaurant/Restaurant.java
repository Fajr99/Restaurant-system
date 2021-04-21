package restaurant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Restaurant {

    @XmlElement(name = "users")
    private Users users = new Users();

    @XmlElement(name = "tables")
    private Tables tables = new Tables();

    @XmlElement(name = "dishes")
    private Dishes dishes = new Dishes();

    @XmlElement(name = "orders")
    private Orders orders = new Orders;

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Orders getOrders() {
        return orders;
    }

    public Users getUsers() {
        return users;
    }

    public Tables getTables() {
        return tables;
    }

    public Dishes getDishes() {
        return dishes;
    }
//    public void setUsers(Users users) {
//        this.users = users;
//    }
}
