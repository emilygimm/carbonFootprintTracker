package edu.matc.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


/**
 * Represents a carbon footprint entry for a user.
 */
@Entity
    @Table(name = "carbon_footprint")
    public class CarbonFootprint {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;

        @Column(name = "category", nullable = false)
        private String category;  // e.g., "Transport", "Electricity", "Food"

        @Column(name = "amount", nullable = false)
        private double amount; // in kg CO2e

        @Column(name = "entry_date", nullable = false)
        private LocalDate entryDate;

    /**
     * Instantiates a new Carbon footprint.
     */
    public CarbonFootprint() {
        }

    /**
     * Instantiates a new Carbon footprint.
     *
     * @param user      the user
     * @param category  the category
     * @param amount    the amount
     * @param entryDate the entry date
     */
    public CarbonFootprint(User user, String category, double amount, LocalDate entryDate) {
            this.user = user;
            this.category = category;
            this.amount = amount;
            this.entryDate = entryDate;
        }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
            return id;
        }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
            this.id = id;
        }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
            return user;
        }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
            this.user = user;
        }

    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
            return category;
        }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
            this.category = category;
        }


    /**
     * Gets amount.
     *
     * @return the amount
     */
    public double getAmount() {
            return amount;
        }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(double amount) {
            this.amount = amount;
        }


    /**
     * Gets entry date.
     *
     * @return the entry date
     */
    public LocalDate getEntryDate() {
            return entryDate;
        }

    /**
     * Sets entry date.
     *
     * @param entryDate the entry date
     */
    public void setEntryDate(LocalDate entryDate) {
            this.entryDate = entryDate;
        }

    @Override
    public String toString() {
        return "CarbonFootprint{" +
                "id=" + id +
                ", user=" + user +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", entryDate=" + entryDate +
                '}';
    }
}

