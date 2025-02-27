package edu.matc.persistence;
import edu.matc.entity.User;

import java.time.LocalDate;
import java.util.List;

import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao userDao;

    @BeforeEach
    void setUp() {
        userDao = new UserDao();
        Database database = Database.getInstance();
        //database.runSQL("cleanDB.sql");


    }


    @Test
    void getByIdSuccess() {
        userDao = new UserDao();
        User retrievedUser = userDao.getById(6);
        assertNotNull(retrievedUser);
        assertEquals("Freddy", retrievedUser.getFirstName());

    }

    @Test
    void updateSuccess() {
        userDao = new UserDao();
        User userToUpdate = userDao.getById(6);
        userToUpdate.setLastName("Solbjerg");
        userDao.update(userToUpdate);

        // retrieve the user and check that the name change worked
        User actualUser = userDao.getById(6);
        assertEquals("Solbjerg", actualUser.getLastName());

    }

    @Test
    void insertSuccess() {
        userDao = new UserDao();
        User userToInsert = new User("John", "Doe", "johndoe", "password123", LocalDate.of(1985, 5, 15));
        //User userToInsert = new User("Kia", "Yang", "ky001", "password987", LocalDate.of(1995, 5, 15));
        int insertedUserId = userDao.insert(userToInsert);
        assertNotEquals(0, insertedUserId);
        User insertedUser = userDao.getById(insertedUserId);
        assertEquals("John", insertedUser.getFirstName());

    }

    @Test
    void delete() {
        userDao = new UserDao();
        userDao.delete(userDao.getById(1));
        assertNull(userDao.getById(1));
    }

    @Test
    void getAll() {
        userDao = new UserDao();
        List<User> users = userDao.getAll();
        System.out.println("Number of users fetched: " + users.size());
        assertEquals(2, users.size());
    }

    @Test
    void getByPropertyEqual() {
        userDao = new UserDao();
        List<User> users = userDao.getByPropertyLike("lastName", "S");
        assertEquals(1, users.size());
        assertEquals("Solbjerg", users.get(0).getLastName());
    }

    @Test
    void getByPropertyLike() {
        userDao = new UserDao();
        List<User> users = userDao.getByPropertyLike("lastName", "s");
        assertEquals(1, users.size());
    }
}