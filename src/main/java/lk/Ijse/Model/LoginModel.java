package lk.Ijse.Model;

import javafx.scene.control.TextField;
import lk.Ijse.DB.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    public boolean checkCrenditials(TextField l_textname, TextField l_textPassword, TextField l_textemail) throws SQLException {
        Connection connection = DbConnection.getInstance().getConection();
        String sql = "SELECT username,passowrd,email from Registeration where username =? and passowrd = ? and email = ?";

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,l_textname.getText());
            pstm.setString(2,l_textPassword.getText());
            pstm.setString(3,l_textemail.getText());


            try (ResultSet resultSet = pstm.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
