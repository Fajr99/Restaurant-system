package RestaurantGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import restaurant.User;
import restaurant.Users;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public TextField usernameTxt,usernameFieldSignup,nameField,roleCode;
    public PasswordField passwordTxt,passwordFieldSignup;

    public Button logInBtn;
    public Label signInLbl;
    public Label errorLbl;
    public label signUpErrorLbl;
    public ComboBox accountChoicebox;
    public Group loginLayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountChoicebox.getItems().addAll("Customer","Manager","Waiter","Cook");
        accountChoicebox.setValue("Customer");
    }

    public void goToReservation(ActionEvent actionEvent) throws IOException, JAXBException {
        Stage loggedinWindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        if(usernameTxt.textProperty().get().equals("") && passwordTxt.textProperty().get().equals("") )
            errorLbl.setText("Please Enter Your Username and Password");
        else if(usernameTxt.textProperty().get().equals(""))
            errorLbl.setText("Please Enter Your Username");
       else if(passwordTxt.textProperty().get().equals(""))
            errorLbl.setText("Please Enter Your Password");
       else{
        int userType = Users.checkUsernameAndPassword(usernameTxt.textProperty().get(),passwordTxt.textProperty().get());
        if(userType==1)
        {
            errorLbl.setText("");
            Parent loggedinParent = FXMLLoader.load(getClass().getResource("CustomerWindow.fxml"));
            Scene loggedinScene = new Scene(loggedinParent);
            loggedinWindow.setScene(loggedinScene);
            loggedinWindow.show();
        }else if(userType>1){
            errorLbl.setText("");
            Parent loggedinParent = FXMLLoader.load(getClass().getResource("EmployeesWindow.fxml"));
            Scene loggedinScene = new Scene(loggedinParent);
            loggedinWindow.setScene(loggedinScene);
            loggedinWindow.show();
        }else if (userType == 0)
        {
            errorLbl.setText("Incorrect Username Or Password");
        }
       }
    }

//    public void goToManager() throws IOException {
//        Parent loggedinParent = FXMLLoader.load(getClass().getResource("EmployeesWindow.fxml"));
//        Scene loggedinScene = new Scene(loggedinParent);
//    }

    public void goToSignUp(ActionEvent actionEvent) {
        loginLayer.setVisible(false);
    }

    public void goToLogin(ActionEvent actionEvent) {
        loginLayer.setVisible(true);
    }

    public void resetButton(ActionEvent actionEvent) {

    }

    public void newAccount(ActionEvent actionEvent) throws IOException, JAXBException {
        if(nameField.textProperty().get.equals("")
                || usernameFieldSignup.textProperty().get.equals("")
                || passwordFieldSignup.textProperty().get.equals("")
                || accountChoicebox.getSelectionModel().getSelectedItem().toString().equals("")){
            signUpErrorLbl.setText("Please Fill In The Empty Fields")
        }
        else{
        User user = new User(nameField.textProperty().get().toString(),
                usernameFieldSignup.textProperty().get().toString(),
                passwordFieldSignup.textProperty().get().toString(),
                accountChoicebox.getSelectionModel().getSelectedItem().toString());

        file.getRestaurant().getUsers().getUsers().add(user);
        file.saveFile();

        Stage loggedinWindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        switch (user.getRole()){
            case "Client":
                Customer.setName(user.getName());
                Parent loggedinParent = FXMLLoader.load(getClass().getResource("CustomerWindow.fxml"));
                Scene loggedinScene = new Scene(loggedinParent);
                loggedinWindow.setScene(loggedinScene);
                loggedinWindow.show();
                break;
            case "Manager":
            case "Waiter":
            case "Cooker":
                Employee.setRole(user.getRole());
                Parent loggedinparent = FXMLLoader.load(getClass().getResource("EmployeesWindow.fxml"));
                Scene loggedinscene = new Scene(loggedinparent);
                loggedinWindow.setScene(loggedinscene);
                loggedinWindow.show();
                break;
        }
        }
    }
}
