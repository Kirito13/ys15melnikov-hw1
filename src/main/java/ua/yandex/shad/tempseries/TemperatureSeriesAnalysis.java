package ua.yandex.shad.tempseries;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {    
	
	private double[] temperatureSeries;
	private int arrayLenght;

	public double[] getTemperatureSeries() {
		double[] resultArray = new double[temperatureSeries.length];
        for (int i = 0; i < temperatureSeries.length; i++) {
            resultArray[i] = temperatureSeries[i];
        }
        return resultArray;
	}
	
    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[0];
		arrayLenght = 0;
    }
    
    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
		arrayLenght = temperatureSeries.length;
		this.temperatureSeries = new double [arrayLenght];
        for (int i = 0; i < arrayLenght; i++) {
			this.temperatureSeries[i] = temperatureSeries[i];
		}
    }
    
    public double average(){
		if (arrayLenght == 0){
			throw new IllegalArgumentException();
		}
		else {
			double sum = 0;
			for (int i = 0; i < arrayLenght; i++)
				sum = sum + temperatureSeries[i];
			sum = sum/temperatureSeries.length;
			return sum;
		}
    }    
    
    public double deviation(){
		if (arrayLenght == 0){
			throw new IllegalArgumentException();
		}
		else {
			double sum = 0;
			for (int i = 0; i < arrayLenght; i++){
				sum = sum + Math.pow((temperatureSeries[i] - average()),2);
			}
			sum = sum/temperatureSeries.length;
			double deviation = Math.sqrt(sum);
			return deviation;
		}
    }
    
    public double min(){
		if (arrayLenght == 0){
			throw new IllegalArgumentException();
		}
		else {
			double min = temperatureSeries[0];
			for (int i = 0; i < arrayLenght; i++){
				if (min <= temperatureSeries[i]) continue;
				else min = temperatureSeries[i];
			}
			return min;
		}
    }
	
    public double max(){
   		if (arrayLenght == 0){
			throw new IllegalArgumentException();
		}
		else {
			double max = -273;
			for (int i = 0; i < arrayLenght; i++){
				if (max >= temperatureSeries[i]) continue;
				else max = temperatureSeries[i];
			}
			return max;
		}
    }
    
    public double findTempClosestToZero(){
        if (arrayLenght == 0){
			throw new IllegalArgumentException();
		}
		else {
			double ClosestToZero = temperatureSeries[0];
			double absClosestToZero = Math.abs(temperatureSeries[0]);
			for (int i = 1; i < arrayLenght; i++){
				if (absClosestToZero > Math.abs(temperatureSeries[i])){
					absClosestToZero = Math.abs(temperatureSeries[i]);
					ClosestToZero = temperatureSeries[i];
				}
				else {
					if (absClosestToZero == Math.abs(temperatureSeries[i])){
						if (temperatureSeries[i] >= 0){
							absClosestToZero = Math.abs(temperatureSeries[i]);
							ClosestToZero = temperatureSeries[i];
						}
					}
					else continue;
				}
			}
			return ClosestToZero;
		}
    }
    
    public double findTempClosestToValue(double tempValue){
        if (arrayLenght == 0){
			throw new IllegalArgumentException();
		}
		else {
			double ClosestToValue = temperatureSeries[0];
			double absClosestToValue = Math.abs(tempValue - temperatureSeries[0]);
			for (int i = 1; i < arrayLenght; i++){
				if (absClosestToValue > Math.abs(tempValue - temperatureSeries[i])){
					absClosestToValue = Math.abs(tempValue - temperatureSeries[i]);
					ClosestToValue = temperatureSeries[i];
				}
				else {
					if (absClosestToValue == Math.abs(tempValue - temperatureSeries[i])){
						if (temperatureSeries[i] >= 0){
							absClosestToValue = Math.abs(tempValue - temperatureSeries[i]);
							ClosestToValue = temperatureSeries[i];
						}
					}
					else continue;
				}
			}
			return ClosestToValue;
		}
	}
    
    public double[] findTempsLessThen(double tempValue){
		if (arrayLenght == 0){
			throw new IllegalArgumentException();
		}
		double[] TempsLessValue = new double[arrayLenght];
		int count = 0;
		for (int i = 0; i < arrayLenght; i++){
			if (temperatureSeries[i] < tempValue) {
				TempsLessValue[count] = temperatureSeries[i];
				count++;
			}
		}
		double[] ResultLessValue = new double[count];
		for (int i = 0; i < count; i++){
			ResultLessValue[i] = TempsLessValue[i];
		}
		return ResultLessValue;
    }
    
    public double[] findTempsGreaterThen(double tempValue){
        if (arrayLenght == 0){
			throw new IllegalArgumentException();
		}
		double[] TempsGreaterThen = new double[arrayLenght];
		int count = 0;
		for (int i = 0; i < arrayLenght; i++){
			if (temperatureSeries[i] >= tempValue){
				TempsGreaterThen[count] = temperatureSeries[i];
				count++;
			}
		}
		double[] ResultGreaterThen = new double[count];
		for (int i = 0; i < count; i++) {
			ResultGreaterThen[i] = TempsGreaterThen[i];
		}
		return ResultGreaterThen;
    }
    
    public TempSummaryStatistics summaryStatistics(){
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }
    
    public int addTemps(double ... temps){
		for (int i = 0; i < temps.length; i++){
			if (temps[i] < -273) {
				throw new InputMismatchException();
			}
		}
		int dynamicLength = temperatureSeries.length;
		// змінити довжину у два ризи коли довжина 0 не вийде
		if (dynamicLength == 0){
			dynamicLength = temps.length;
		}
		while (arrayLenght + temps.length > dynamicLength){
			dynamicLength = dynamicLength*2;
		}
		double[] resultArray = new double[dynamicLength];
		for (int i = 0; i < arrayLenght; i++) {
			resultArray[i] = temperatureSeries[i];
		}
		for (int i = arrayLenght; i < arrayLenght + temps.length; i++){
			resultArray[i] = temps[i - arrayLenght];
		}
		this.arrayLenght = arrayLenght + temps.length;
		this.temperatureSeries = resultArray;
		return arrayLenght;
    }
}
