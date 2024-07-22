package lk.Ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lk.Ijse.Model.LoginModel;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    public TextField L_textname;
    public TextField L_textPassword;
    public TextField L_textemail;
    public ImageView rootnode;

    LoginModel loginModel = new LoginModel();

    public void Login(ActionEvent actionEvent) throws SQLException, IOException {
        boolean chrck = loginModel.checkCrenditials(L_textname,L_textPassword,L_textemail);
        if (chrck){
            Parent parent = FXMLLoader.load(getClass().getResource("/view/dashBoard.fxml"));
            Stage stage = (Stage) rootnode.getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setTitle("DashBoard Form");
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Password or Username incorrect").show();
        }
    }

    public void registerationDirect(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/Registeration.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setTitle("Registeration Form");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
}