package SQLRest.Repository;

import SQLRest.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class StoreProcAddAdminAccessElementJsonImpl {
    @Autowired
    private ApplicationConfiguration appConfig;
    public String saveAdminAccessToInterface(String operation) throws SQLException {
        String queryResult = "";
        Connection con = DriverManager.getConnection(
                appConfig.appJdbcProp().get("url"),
                appConfig.appJdbcProp().get("username"),
                appConfig.appJdbcProp().get("password"));
        try {
            CallableStatement proc = con.prepareCall("{ call acs.sp_admin_setAccessToInterface(?) }");
            //Задаём входные параметры
            proc.setString(1, operation);
            proc.executeQuery();
            ResultSet resultSet = proc.getResultSet();
            //установим указатель на первый елемент
            resultSet.next();
            queryResult = resultSet.getString(1);
            if (resultSet != null) resultSet.close();
            if (proc != null) proc.close();
        } catch (Exception ex) {
            queryResult = "";
            Logger.getLogger(SessionProperties.Jdbc.class.getName()).log(Level.SEVERE, "error in " +
                    "saveAdminAccessToInterface method, in class - saveAdminAccessToInterface() ");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLDataException ex) {
                    Logger.getLogger(SessionProperties.Jdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return queryResult;
        }
    }
}
