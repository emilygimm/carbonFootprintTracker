package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public List<User> getAllUserEntries() {
        List<User> users = new ArrayList<>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM user";
        logger.info("Heres the select sql" + sql);

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException sqle) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: " + sqle);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;
    }


}
