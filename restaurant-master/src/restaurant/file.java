package restaurant;

import RestaurantGUI.Main;
import restaurant.Restaurant;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;

public class file {

    private static int currentUser;
    private static Restaurant restaurant;

    public static void loadFile() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        restaurant = (Restaurant) unmarshaller.unmarshal(new java.io.File("src\\restaurant\\input.xml"));
    }
    public static void saveFile(Orders orders) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        Restaurant savedRestaurant = restaurant;
        savedRestaurant.setOrders(orders);
        marshaller.marshal(savedRestaurant, new File("input.xml"));
    }
    public static Restaurant getRestaurant(){
        return restaurant;
    }
}
