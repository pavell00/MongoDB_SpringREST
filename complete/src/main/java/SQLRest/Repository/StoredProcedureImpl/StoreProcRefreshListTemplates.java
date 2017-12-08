package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class StoreProcRefreshListTemplates {
    @Autowired
    private ApplicationConfiguration appConfig;
    public String getTemplateList_sp(String listRootTemplates, String roleid) throws SQLException {

        String queryResult = "";
        Connection con = DriverManager.getConnection(
                appConfig.appJdbcProp().get("url"),
                appConfig.appJdbcProp().get("username"),
                appConfig.appJdbcProp().get("password"));
        try {
            CallableStatement proc = con.prepareCall("{ call acs.sp_admin_getListTmplates(?, ?) }");
            //Задаём входные параметры
            proc.setString(1, listRootTemplates);
            proc.setString(2, roleid);
            proc.executeQuery();

            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()){
                queryResult += resultSet.getString(1);
            }
            if (queryResult.length() == 0) queryResult = "[]";
            if (resultSet != null) resultSet.close();
            if (proc != null) proc.close();
        } catch (Exception ex) {
            queryResult = "";
            Logger.getLogger(SessionProperties.Jdbc.class.getName()).log(Level.SEVERE, "error in " +
                            "getTemplateList_sp method, in class - StoreProcRefreshListTemplates ",
                    ex + ", with params listRootTemplates="+listRootTemplates);
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
