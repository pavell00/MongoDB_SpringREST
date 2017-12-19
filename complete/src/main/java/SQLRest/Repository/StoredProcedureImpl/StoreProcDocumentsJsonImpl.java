package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class StoreProcDocumentsJsonImpl {
    @Autowired
    private ApplicationConfiguration appConfig;
    public String getDocument_sp(Long rootid, LocalDate startdate, LocalDate enddate, String typedir, Long roleid) throws SQLException {

        String queryResult = "";
        String sql="";
        Connection con = DriverManager.getConnection(
                appConfig.appJdbcProp().get("url"),
                appConfig.appJdbcProp().get("username"),
                appConfig.appJdbcProp().get("password"));
        try {
            switch (typedir) {
                case "document_type":
                    sql = "{ call acs.sp_DocListDocumentsJSON(?, ?, ?, ?, ?) }";
                    break;
                case "account_type":
                    sql = "{ call acs.sp_DocListAccountsJSON(?, ?, ?, ?, ?) }";
                    break;
                case "agent_type":
                    sql = "{ call acs.sp_DocListAgentsJSON(?, ?, ?, ?, ?) }";
                    break;
                case "entity_type":
                    sql = "{ call acs.sp_DocListEntitiesJSON(?, ?, ?, ?, ?) }";
                    break;
                case "misc_type":
                    sql = "{ call acs.sp_DocListMiscsJSON(?, ?, ?, ?, ?) }";
                    break;
                case "binder_type":
                    sql = "{ call acs.sp_DocListBindersJSON(?, ?, ?, ?, ?) }";
                    break;
                case "template_type":
                    sql = "{ call acs.sp_DocListTemplatesJSON(?, ?, ?, ?, ?) }";
                    break;
                default:
                    sql = "{ call acs.sp_DocListDocumentsJSON(?, ?, ?, ?, ?) }";
                    break;
            }
            CallableStatement proc = con.prepareCall(sql);
            //Задаём входные параметры
            proc.setLong(1, rootid);
            //proc.setString(2, startdate.toString());
            //proc.setString(3, enddate.toString());
            proc.setDate(2, java.sql.Date.valueOf(startdate));
            proc.setDate(3, java.sql.Date.valueOf(enddate));
            proc.setString(4, typedir);
            proc.setLong(5, roleid);
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
                            "getDocument_sp method, in class - StoreProcDocumentsJsonImpl");
        } finally {
            /*Logger.getLogger(SessionProperties.Jdbc.class.getName()).log(Level.WARNING, "rootid=" + rootid+
                    ", startdate="+startdate+", enddate="+enddate+", typedir="+typedir+", roleid="+roleid);*/
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
