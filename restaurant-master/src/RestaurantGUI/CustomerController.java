package RestaurantGUI;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import restaurant.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    public VBox root;
    public Rectangle black;
    public JFXButton backbtn,t1,t2,t3,t4,t5,t6,t7,t8,t9,resConfirmbtn;
    public Label resCustomer,resSeats,resSmoking,resTable,
                 mName,mPrice,mTaxes,mTable;
    List<JFXButton> tables;
    public Group blurLayer;
    public Group twoBtnsMenu;
    public Group menuLayer;
    public Group resConfirmLayer;
    public Spinner sA1,sA2,sA3,sM1,sM2,sM3,sD1,sD2,sD3;
    private int tableToReserve=0;
//    private float price;
//    private float

    GaussianBlur gblur = new GaussianBlur();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        black.setVisible(true);
        twoBtnsMenu.setVisible(true);
        backbtn.setVisible(false);
        resConfirmLayer.setVisible(false);
        menuLayer.setVisible(false);
        resConfirmbtn.setDisable(true);
        gblur.setRadius(10);
        blurLayer.setEffect(gblur);
        mPrice.setText("Price : 0");
        mTaxes.setText("Price After Taxes : 0");
        mTable.setText("Take Away");
        tables = Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8,t9);
        for(Table t : file.getRestaurant().getTables().getTables()) {
            if(t.isAvailable()){
                    tables.get(t.getNumber()-1).setRipplerFill(Paint.valueOf("#00ff1a"));
                }else{
                tables.get(t.getNumber()-1).setRipplerFill(Paint.valueOf("#ff0000"));
                }
            }
    }

    public void goToTables(ActionEvent actionEvent) {
        twoBtnsMenu.setVisible(false);
        black.setVisible(false);
        gblur.setRadius(0);
        blurLayer.setEffect(gblur);
        backbtn.setVisible(true);
        resConfirmLayer.setVisible(true);
        resConfirmLayer.setTranslateY(-262);
        TranslateTransition translateToTables = new TranslateTransition(Duration.seconds(1),resConfirmLayer);
        translateToTables.setToY(0);
        translateToTables.play();
    }

    public void goToMenu(ActionEvent actionEvent) {
        mName.setText(Customer.getName());
        twoBtnsMenu.setVisible(false);
        backbtn.setVisible(true);
        menuLayer.setTranslateY(608);
        menuLayer.setVisible(true);
        TranslateTransition translateToMenu = new TranslateTransition(Duration.seconds(1),menuLayer);
        translateToMenu.setToY(0);
        translateToMenu.play();
    }

    public void goBack(ActionEvent actionEvent) {

        if(menuLayer.getTranslateY()==0 && menuLayer.isVisible()==true){
            TranslateTransition translateFromMenu = new TranslateTransition(Duration.seconds(1),menuLayer);
            translateFromMenu.setToY(608);
            translateFromMenu.play();
            backbtn.setVisible(false);
            twoBtnsMenu.setVisible(true);
        }else if(resConfirmLayer.getTranslateY()==0 && resConfirmLayer.isVisible()==true){
            TranslateTransition translateFromTables = new TranslateTransition(Duration.seconds(1),resConfirmLayer);
            translateFromTables.setToY(-262);
            translateFromTables.play();
            backbtn.setVisible(false);
            twoBtnsMenu.setVisible(true);
            black.setVisible(true);
            gblur.setRadius(10);
            blurLayer.setEffect(gblur);
        }
    }

    public void spinnerChange(MouseEvent mouseEvent) {

        int i=0;
        List<Spinner> spinners = Arrays.asList(sA1,sA2,sA3,sM1,sM2,sM3,sD1,sD2,sD3);
        for (dish plate : file.getRestaurant().getDishes().getDishes()) {
            plate.setQuantity((int) spinners.get(i++).getValue());
        }
        float price=file.getRestaurant().getDishes().calculatePrice();
        float withTaxes=file.getRestaurant().getDishes().calculatePriceWithTaxes();


        System.out.println("price = "+ price+"  after Taxes = "+withTaxes);
        mPrice.setText("Price : "+price);
        mTaxes.setText("Price After Taxes : "+withTaxes);
    }

    //Tables Buttons
    public void t1(ActionEvent actionEvent) {displayTableData(0);}
    public void t2(ActionEvent actionEvent) {displayTableData(1);}
    public void t3(ActionEvent actionEvent) {displayTableData(2);}
    public void t4(ActionEvent actionEvent) {displayTableData(3);}
    public void t5(ActionEvent actionEvent) {displayTableData(4);}
    public void t6(ActionEvent actionEvent) {displayTableData(5);}
    public void t7(ActionEvent actionEvent) {displayTableData(6);}
    public void t8(ActionEvent actionEvent) {displayTableData(7);}
    public void t9(ActionEvent actionEvent) {displayTableData(8);}

    public void displayTableData(int tableNo){
        resCustomer.setText(Customer.getName());
        resSeats.setText(String.valueOf(file.getRestaurant().getTables().getTables().get(tableNo).getNumberOfSeats()));
        resSmoking.setText(String.valueOf(file.getRestaurant().getTables().getTables().get(tableNo).isSmoking()));
        resTable.setText(String.valueOf(file.getRestaurant().getTables().getTables().get(tableNo).getNumber()));
        if(file.getRestaurant().getTables().getTables().get(tableNo).isAvailable()){
            resConfirmbtn.setDisable(false);
            tableToReserve=tableNo;
        }else {
            resConfirmbtn.setDisable(true);
            tableToReserve=0;
        }
        System.out.println(file.getRestaurant().getTables().getTables().get(tableNo).isAvailable());
    }

    public void reservationConfirmed(ActionEvent actionEvent) {
        Customer.reserveTable(tableToReserve);
        file.getRestaurant().getTables().getTables().get(tableToReserve).setAvailable(false);
        tables.get(file.getRestaurant().getTables().getTables().get(tableToReserve).getNumber()-1).setRipplerFill(Paint.valueOf("#ff0000"));
        resConfirmbtn.setDisable(true);
        mTable.setText("Table Number "+(tableToReserve+1));
    }

    public void confirmPlaceOrder(ActionEvent actionEvent) {
        Dishes dishes = new Dishes();
        for(dish plate : file.getRestaurant().getDishes().getDishes()){
            if(plate.getQuantity()>0){
                dishes.getDishes().add(plate);
            }
        }
        Customer.MakeOrder(dishes,file.getRestaurant().getDishes().calculatePriceWithTaxes());
        Customer.printOrder();
    }
}
