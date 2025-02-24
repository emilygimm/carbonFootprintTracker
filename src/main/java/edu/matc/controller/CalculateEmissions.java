

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


    /**
     * Instantiates a new constructor for Transportation.
     *
     * @param milesPerGallon    the miles per gallon
     * @param milesDrivenWeekly the miles driven weekly
     */
    public CalculateEmissions(double milesPerGallon, double milesDrivenWeekly) {
        this.milesDrivenWeekly = milesDrivenWeekly;
        this.milesPerGallon = milesPerGallon;
    }


    /**
     * Constructor for home energy emissions
     *
     * @param averageMonthlyElectricBill the average monthly electric bill
     */
    public CalculateEmissions(double averageMonthlyElectricBill, double pricePerKWh) {
        this.averageMonthlyElectricBill = averageMonthlyElectricBill;
        this.pricePerKWh = pricePerKWh;
    }


    /**
     * Constructor for both Transportation and Home Energy emissions.
     *
     * @param milesPerGallon    the miles per gallon
     * @param milesDrivenWeekly the miles driven weekly
     * @param averageMonthlyElectricBill the average monthly electric bill
     * @param pricePerKWh       the price per kWh
     */
    public CalculateEmissions(double milesPerGallon, double milesDrivenWeekly, double averageMonthlyElectricBill, double pricePerKWh) {
        this(milesPerGallon, milesDrivenWeekly);
        this.averageMonthlyElectricBill = averageMonthlyElectricBill;
        this.pricePerKWh = pricePerKWh;
    }


    /**
     * Calculate fuel consumption double.
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

    /* Add calculation of emissions of greenhouse gasses other than CO2 */


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


        // If user uses green power, multiply by percentage of green power used

        // does your house use green power? what portion of your households total purchased electricity uses green power
    }

// 822 lbs is the average for 1 person

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

