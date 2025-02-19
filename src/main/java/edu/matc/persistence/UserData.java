package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Access users in the user table.
 *
 * @author egimm
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
                User user = createUserFromResults(results);
                users.add(user);
            }
            database.disconnect();
        } catch (SQLException sqle) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: " + sqle);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;
    }
    /**
     * Create a User object from a ResultSet
     * @param rs The result set from the SQL query
     * @return A populated User object
     * @throws SQLException If there is an error reading from the result set
     */
    private User createUserFromResults(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setUserName(rs.getString("user_name"));
        return user;
    }

}
