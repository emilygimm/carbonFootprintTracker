package edu.matc.controller;

/**
 * The CalculateEmissions class calculates emissions for transportation, home energy, and waste.
 *
 * @author egimm
 */
public class CalculateEmissions {
    private double milesPerGallon;
    private double milesDrivenWeekly;
    private static final double CO2_EMISSIONS_PER_GALLON = 18.73;
    private double averageMonthlyElectricBill;
    private double pricePerKWh;
    private static final double ELECTRICITY_EMISSION_FACTOR = 0.92; // check for exact emission factor
    private static final int MONTHS_IN_A_YEAR = 12;

    // Private constructor to prevent direct instantiation
    private CalculateEmissions(double milesPerGallon, double milesDrivenWeekly, double averageMonthlyElectricBill, double pricePerKWh) {
        this.milesPerGallon = milesPerGallon;
        this.milesDrivenWeekly = milesDrivenWeekly;
        this.averageMonthlyElectricBill = averageMonthlyElectricBill;
        this.pricePerKWh = pricePerKWh;
    }

    // Factory method for transportation emissions
    public static CalculateEmissions createForTransportation(double milesPerGallon, double milesDrivenWeekly) {
        return new CalculateEmissions(milesPerGallon, milesDrivenWeekly, 0, 0); // Transportation only
    }

    // Factory method for home energy emissions
    public static CalculateEmissions createForHomeEnergy(double averageMonthlyElectricBill, double pricePerKWh) {
        return new CalculateEmissions(0, 0, averageMonthlyElectricBill, pricePerKWh); // Home energy only
    }

    // Factory method for both transportation and home energy emissions
    public static CalculateEmissions createForBoth(double milesPerGallon, double milesDrivenWeekly, double averageMonthlyElectricBill, double pricePerKWh) {
        return new CalculateEmissions(milesPerGallon, milesDrivenWeekly, averageMonthlyElectricBill, pricePerKWh); // Both
    }

    /**
     * Calculate fuel consumption in gallons.
     *
     * @return the double
     */
    public double calculateFuelConsumption() {
        return milesDrivenWeekly / milesPerGallon;
    }

    /**
     * Calculate emissions of gas car.
     *
     * @return the CO2 emissions in lbs
     */
    public double calculateEmissionsOfGasCar() {
        return calculateFuelConsumption() * CO2_EMISSIONS_PER_GALLON;
    }

    /**
     * Calculate home energy consumption emissions.
     *
     * @return the CO2 emissions in lbs
     */
    public double calculateHomeEnergyConsumption() {
        if (pricePerKWh == 0) {
            throw new IllegalArgumentException("Price per kWh cannot be zero.");
        }
        return (averageMonthlyElectricBill / pricePerKWh) * ELECTRICITY_EMISSION_FACTOR * MONTHS_IN_A_YEAR;
    }

    /**
     * Calculate total average waste emissions.
     *
     * @return the CO2 emissions from waste in lbs.
     */
    public double calculateTotalAverageWasteEmissions() {
        final int TOTAL_WASTE_EMISSIONS_BEFORE_RECYCLING = 822;
        final int EMISSIONS_FROM_NEWSPAPER = 119;
        final int EMISSIONS_FROM_ALUM = 121;
        final int EMISSIONS_FROM_PLASTIC = 73;
        final int EMISSIONS_FROM_GLASS = 19;
        final int EMISSIONS_FROM_MAGAZINES = 85;

        return TOTAL_WASTE_EMISSIONS_BEFORE_RECYCLING
                + EMISSIONS_FROM_NEWSPAPER
                + EMISSIONS_FROM_ALUM
                + EMISSIONS_FROM_PLASTIC
                + EMISSIONS_FROM_GLASS
                + EMISSIONS_FROM_MAGAZINES;
    }
}
