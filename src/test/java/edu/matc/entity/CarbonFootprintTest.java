package edu.matc.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

class CarbonFootprintTest {

    private CarbonFootprint carbonFootprint;
    private User user;
    private LocalDate entryDate;

//    @BeforeEach
//    void setUp() {
//
//        Database database = Database.getInstance();
//        database.runSQL("cleanDB.sql");
//
//
//    }

    @Test
    void testGetById() {
        carbonFootprint.setId(3);
        assertEquals(3, carbonFootprint.getId());

    }

    @Test
    void setId() {
        carbonFootprint.setId(5);
        assertEquals(5, carbonFootprint.getId());
    }

    @Test
    void getUser() {
        assertEquals(user, carbonFootprint.getUser());

    }

    @Test
    void setUser() {
        User newUser = new User();
        newUser.setId(2);
        carbonFootprint.setUser(newUser);
        assertEquals(newUser, carbonFootprint.getUser());
    }

    @Test
    void getCategory() {

        assertEquals("Transportation", carbonFootprint.getCategory());
    }

    @Test
    void setCategory() {
        carbonFootprint.setCategory("Energy");
        assertEquals("Energy", carbonFootprint.getCategory());
    }

    @Test
    void getAmount() {
        assertEquals(12.5, carbonFootprint.getAmount());

    }

    @Test
    void setAmount() {
        carbonFootprint.setAmount(20.0);
        assertEquals(20.0, carbonFootprint.getAmount());
    }

    @Test
    void getEntryDate() {

        assertEquals(entryDate, carbonFootprint.getEntryDate());
    }

    @Test
    void setEntryDate() {
        LocalDate newDate = LocalDate.of(2025, 3, 15);
        carbonFootprint.setEntryDate(newDate);
        assertEquals(newDate, carbonFootprint.getEntryDate());
    }

//    @Test
//    void testToString() {
//        String expected = "CarbonFootprint{" +
//                "id=0, " +
//                "user=" + user + ", " +
//                "category='Transportation', " +
//                "amount=12.5, " +
//                "entryDate=" + entryDate +
//                '}';
//        assertEquals(expected, carbonFootprint.toString());
//    }
}