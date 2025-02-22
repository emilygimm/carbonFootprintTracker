package edu.matc.controller;

/**
 * The type Transportation.
 *
 * @author egimm
 */
public class CalculateEmissions {
    private double milesPerGallon;
    private double milesDrivenWeekly;
    private static final double CO2_EMISSIONS_PER_GALLON = 18.73;
    private double averageMonthlyElectricBill;
    private double pricePerKWh;



    /**
     * Instantiates a new Transportation.
     *
     * @param milesPerGallon    the miles per gallon
     * @param milesDrivenWeekly the miles driven weekly
     */
    public CalculateEmissions(double milesPerGallon, double milesDrivenWeekly) {
    this.milesDrivenWeekly = milesDrivenWeekly;
    this.milesPerGallon = milesPerGallon;
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
     * Calculate emissions of gas car double.
     *
     * @return the double
     */
    public double calculateEmissionsOfGasCar() {

    return calculateFuelConsumption() * CO2_EMISSIONS_PER_GALLON;

}

    /* Add calculation of emissions of greenhouse gasses other than CO2 */


    public double calculateHomeEnergyConsumption() {

        return (averageMonthlyElectricBill / pricePerKWh) * electricityEmissionFactor * monthsInAYear;


        // If user uses green power, multiply by percentage of green power used

        // does your house use green power? what portion of your households total purchased electricity uses green power
    }


    public double calculateTotalAverageWasteEmissions() {
        const int TOTAL_WASTE_EMISSIONS_BEFORE_RECYCLING = 822;
        const int EMISSIONS_FROM_NEWSPAPER = ;
        const int EMISSIONS_FROM_ALUM = ;
        const int EMISSIONS_FROM_PLASTIC = ;
        const int EMISSIONS_FROM_GLASS = ;
        const int EMISSIONS_FROM_MAGAZINES = ;

        TOTAL_WASTE_EMISSIONS_BEFORE_RECYCLING + EMISSIONS_FROM_NEWSPAPER + EMISSIONS_FROM_ALUM
                    + EMISSIONS_FROM_PLASTIC + EMISSIONS_FROM_GLASS + EMISSIONS_FROM_MAGAZINES;
    }

}

