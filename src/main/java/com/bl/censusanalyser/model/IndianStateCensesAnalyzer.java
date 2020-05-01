package com.bl.censusanalyser.model;
import com.opencsv.bean.CsvBindByName;

public class IndianStateCensesAnalyzer
{
    @CsvBindByName(column="State")
    public String State;

    @CsvBindByName (column ="Population")
    public int population;

    @CsvBindByName(column = "AreaInSqKm")
    public int area;

    @CsvBindByName (column = "DensityPerSqKm")
    public int density;

    public String getState() {
        return State;
    }
    public int getPopulation() {
        return population;
    }
    public int getArea() {
        return area;
    }
    public int getDensity() {
        return density;
    }
    @Override
    public String toString() {
        return "IndianStateCensesAnalyzer{" +
                "State='" + State + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", density=" + density +
                '}';
    }
}
