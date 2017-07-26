package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.test;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.io.InputStream;
import java.sql.*;
import java.util.List;

@Repository
public class StoreProcTestImpl {

    public String getTest_sp() throws SQLException {

        String queryResult;
        Connection con = DriverManager.getConnection(
                "jdbc:sqlserver://172.16.13.66\\\\SQL2:51880;databaseName=DGMZ2_DC3",
                "sa",
                "Radeon223245");
        CallableStatement proc = con.prepareCall("{ call dbo.sp_search_pricelists3() }");
        proc.executeQuery();
        ResultSet resultSet = proc.getResultSet();
        if (resultSet.next()){
            queryResult = resultSet.getString(1);
            System.out.println(queryResult.length());
            System.out.println(queryResult);

            /*Clob clob = resultSet.getClob(1);
            InputStream is = clob.getAsciiStream();*/
        } else {
            return queryResult = "";
        }

        if(resultSet != null) resultSet.close();
        if(proc != null) proc.close();
        if (con != null) proc.close();
        return queryResult;
    }
}
