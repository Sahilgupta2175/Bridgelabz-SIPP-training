public class TemperatureConverter {
    public double celsiusToFahrenheit(double c) {
        return c * 9.0 / 5.0 + 32.0;
    }

    public double fahrenheitToCelsius(double f) {
        return (f - 32.0) * 5.0 / 9.0;
    }
}
