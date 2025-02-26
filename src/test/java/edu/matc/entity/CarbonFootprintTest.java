package edu.matc.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

class CarbonFootprintEntryTest {

    private CarbonFootprintEntry carbonFootprintEntry;
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
        carbonFootprintEntry.setId(3);
        assertEquals(3, carbonFootprintEntry.getId());

    }

    @Test
    void setId() {
        carbonFootprintEntry.setId(5);
        assertEquals(5, carbonFootprintEntry.getId());
    }

    @Test
    void getUser() {
        assertEquals(user, carbonFootprintEntry.getUser());

    }

    @Test
    void setUser() {
        User newUser = new User();
        newUser.setId(2);
        carbonFootprintEntry.setUser(newUser);
        assertEquals(newUser, carbonFootprintEntry.getUser());
    }

    @Test
    void getCategory() {

        assertEquals("Transportation", carbonFootprintEntry.getCategory());
    }

    @Test
    void setCategory() {
        carbonFootprintEntry.setCategory("Energy");
        assertEquals("Energy", carbonFootprintEntry.getCategory());
    }

    @Test
    void getAmount() {
        assertEquals(12.5, carbonFootprintEntry.getAmount());

    }

    @Test
    void setAmount() {
        carbonFootprintEntry.setAmount(20.0);
        assertEquals(20.0, carbonFootprintEntry.getAmount());
    }

    @Test
    void getEntryDate() {

        assertEquals(entryDate, carbonFootprintEntry.getEntryDate());
    }

    @Test
    void setEntryDate() {
        LocalDate newDate = LocalDate.of(2025, 3, 15);
        carbonFootprintEntry.setEntryDate(newDate);
        assertEquals(newDate, carbonFootprintEntry.getEntryDate());
    }

}