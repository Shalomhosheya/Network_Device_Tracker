package lk.Ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lk.Ijse.Model.LoginModel;
import lk.Ijse.Model.RegisterationModel;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterationController {
    public TextField R_textUsername;
    public TextField R_textPassword;
    public TextField R_textEmail;
    public DatePicker DateText;
    public TextField R_textNic;
    public ImageView rootnode;

    public RegisterationModel registerationModel = new RegisterationModel();

    public void RegisterBtn(ActionEvent actionEvent) throws IOException, SQLException {
        boolean checkSave = registerationModel.RegisterationProcess(R_textUsername,R_textPassword,R_textEmail,DateText,R_textNic);
        boolean Regex = duplicationProcess();
        if (Regex){
            if (checkSave){
                Parent parent = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
                Stage stage = (Stage) rootnode.getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setTitle("Main Form");
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Fill all the blacks").show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Fill all the blacks").show();
        }
    }

    private boolean duplicationProcess() {
       return true;
    }
}
