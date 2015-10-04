package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {
    private double avgTemp;
	private double devTemp;
	private double minTemp;
	private double maxTemp;

	public TempSummaryStatistics (double inputAvgTemp, double inputDevTemp,
	double inputMinTemp, double inputMaxTemp) {
		avgTemp = inputAvgTemp;
		devTemp = inputDevTemp;
		minTemp = inputMinTemp;
		maxTemp = inputMaxTemp;
	}

	public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }
}
