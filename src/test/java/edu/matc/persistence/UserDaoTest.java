package edu.matc.persistence;
import edu.matc.entity.User;
import edu.matc.test.util.Database;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao userDao;

//    @BeforeEach
//    void setUp() {
//        //userDao = new UserDao();
//        Database database = Database.getInstance();
//        database.runSQL("cleanDB.sql");
//
//
//    }

//    @Test
//    void save() {
//        userDao = new UserDao();
//        User userToSave = userDao.save(user);
//        assertNotNull(userToSave);
//        assertEquals("John", retrievedUser.getFirstName());
//    }

    @Test
    void getByIdSuccess() {
        userDao = new UserDao();
        User retrievedUser = userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Joe", retrievedUser.getFirstName());

    }

    @Test
    void updateSuccess() {
        userDao = new UserDao();
        User userToUpdate = userDao.getById(1);
        userToUpdate.setLastName("Smith");
        userDao.update(userToUpdate);

        // retrieve the user and check that the name change worked
        User actualUser = userDao.getById(1);
        assertEquals("Smith", actualUser.getLastName());

    }

    @Test
    void insertSuccess() {
        userDao = new UserDao();
        User userToInsert = new User("Kia", "Yang", "ky001", "password123", LocalDate.of(1995, 5, 15));
        int insertedUserId = userDao.insert(userToInsert);
        assertNotEquals(0, insertedUserId);
        User insertedUser = userDao.getById(insertedUserId);
        assertEquals("Kia", insertedUser.getFirstName());

    }

    @Test
    void delete() {
        userDao = new UserDao();
        userDao.delete(userDao.getById(2));
        assertNull(userDao.getById(2));
    }

    @Test
    void getAll() {
        userDao = new UserDao();
        List<User> users = userDao.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void getByPropertyEqual() {
        userDao = new UserDao();
        List<User> users = userDao.getByPropertyLike("lastName", "Yang");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getId());
    }

    @Test
    void getByPropertyLike() {
        userDao = new UserDao();
        List<User> users = userDao.getByPropertyLike("lastName", "s");
        assertEquals(1, users.size());
    }
}