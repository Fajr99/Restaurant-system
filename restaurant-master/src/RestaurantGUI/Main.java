package RestaurantGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import restaurant.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main extends Application {
//    Restaurant static restaurant = loadFile("D:\\Desktop\\Pro2\\restaurant-master\\src\\restaurant\\input.xml");
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Reservation");
        primaryStage.setScene(new Scene(root, 1386, 752));
        primaryStage.show();
    }

    public static Restaurant loadFile(String fileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Restaurant restaurant = (Restaurant) unmarshaller.unmarshal(new File(fileName));
        return restaurant;
    }


    public static void main(String[] args) throws JAXBException {
//        Restaurant restaurant = Main.loadFile("D:\\Desktop\\Pro2\\restaurant-master\\src\\restaurant\\input.xml");
//        for(User users : restaurant.getUsers().getUsers()) {
//                System.out.println(users.getName());
//            }
        file.loadFile();
        launch(args);
    }
}
