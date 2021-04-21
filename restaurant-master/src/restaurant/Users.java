package restaurant;

import RestaurantGUI.Main;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    @XmlElement(name = "user")
    private List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static int checkUsernameAndPassword(String username,String password) throws JAXBException {
        for(User users : file.getRestaurant().getUsers().getUsers()) {
            if(username.equals(users.getUsername()) && password.equals(users.getPassword())) {
                switch (users.getRole()){
                    case "Client":
                        Customer.setName(users.getName());
                        return 1;
                    case "Manager":
                        return 2;
                    case "Waiter":
                        return 3;
                    case "Cooker":
                        return 4;
                }
            }
        }
        return 0;
    }
}


