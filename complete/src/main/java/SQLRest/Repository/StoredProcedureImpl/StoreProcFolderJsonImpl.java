package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class StoreProcFolderJsonImpl {
    @Autowired
    private ApplicationConfiguration appConfig;
    public String getFolder_sp(Long rootid, String typefolder, Long roleid) throws SQLException {

        String queryResult = "";
        String sql="";
        Connection con = DriverManager.getConnection(
                appConfig.appJdbcProp().get("url"),
                appConfig.appJdbcProp().get("username"),
                appConfig.appJdbcProp().get("password"));
        try {
            switch (typefolder) {
                case "document_type":
                    sql = "{ call acs.sp_FoldersDocsJSON(?, ?, ?) }";
                    break;
                case "account_type":
                    sql = "{ call acs.sp_FoldersAccountsJSON(?, ?, ?) }";
                    break;
                case "agent_type":
                    sql = "{ call acs.sp_FoldersAgentsJSON(?, ?, ?) }";
                    break;
                case "entity_type":
                    sql = "{ call acs.sp_FoldersEntitiesJSON(?, ?, ?) }";
                    break;
                case "misc_type":
                    sql = "{ call acs.sp_FoldersMiscsJSON(?, ?, ?) }";
                    break;
                case "binder_type":
                    sql = "{ call acs.sp_FoldersBindersJSON(?, ?, ?) }";
                    break;
                case "template_type":
                    sql = "{ call acs.sp_FoldersTemplatesJSON(?, ?, ?) }";
                    break;
                default:
                    sql = "{ call acs.sp_FoldersDocsJSON(?, ?, ?) }";
                    break;
            }
            CallableStatement proc = con.prepareCall(sql);
            //Задаём входные параметры
            proc.setLong(1, rootid);
            proc.setString(2, typefolder);
            proc.setLong(3, roleid);
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
                            "getFolder_sp method, in class - StoreProcFolderJsonImpl ",
                    ex + ", with params "+sql+", rootid=" + rootid+ ", typefolder="
                            + typefolder+", roleid"+roleid);
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
