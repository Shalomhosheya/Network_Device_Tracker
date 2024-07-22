package lk.Ijse.Model;

import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lk.Ijse.DB.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class RegisterationModel {
    public boolean RegisterationProcess(TextField r_textUsername, TextField r_textPassword, TextField r_textEmail, DatePicker dateText, TextField r_textNic) throws SQLException {
        Connection connection = DbConnection.getInstance().getConection();
        String sql = "INSERT INTO Registeration VALUES(?,?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, r_textUsername.getText());
        pstm.setString(2, r_textPassword.getText());
        pstm.setString(3, r_textEmail.getText());

        LocalDate localDate = dateText.getValue();
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        pstm.setDate(4, sqlDate);

        pstm.setString(5, r_textNic.getText());
        return  pstm.executeUpdate() != 0;
    }
}
