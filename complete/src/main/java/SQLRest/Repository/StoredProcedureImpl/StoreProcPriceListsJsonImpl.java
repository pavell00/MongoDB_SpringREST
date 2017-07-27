package SQLRest.Repository.StoredProcedureImpl;

import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class StoreProcPriceListsJsonImpl {

    public String getPriceLists_sp() throws SQLException {
        String queryResult = "";

        Connection con = DriverManager.getConnection(
                "jdbc:sqlserver://172.16.13.66\\\\SQL2:51880;databaseName=DGMZ2_DC3",
                "sa",
                "Radeon223245");
        try {
            CallableStatement proc = con.prepareCall("{ call dbo.sp_search_pricelists() }");
            proc.executeQuery();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()){
                queryResult += resultSet.getString(1);
            }

            if (resultSet != null) resultSet.close();
            if (proc != null) proc.close();
            if (con != null) proc.close();
            return queryResult;
        } catch (Exception ex) {
            Logger.getLogger(SessionProperties.Jdbc.class.getName()).log(Level.SEVERE, "error in " +
                    "getPriceLists_sp method, in class - StoreProcPriceListsJsonImpl ", ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLDataException ex) {
                    Logger.getLogger(SessionProperties.Jdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return "";
        }
    }
}
