package edu.matc.controller;

/**
 * The type Transportation.
 *
 * @author egimm
 */
public class Transportation {
    private double milesPerGallon;
    private double milesDrivenWeekly;
    private static final double CO2_EMISSIONS_PER_GALLON = 18.73;


    /**
     * Instantiates a new Transportation.
     *
     * @param milesPerGallon    the miles per gallon
     * @param milesDrivenWeekly the miles driven weekly
     */
    public Transportation(double milesPerGallon, double milesDrivenWeekly) {
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

// Add calculation of emissions of greenhouse gasses other than CO2



}

