package com.bl.censusanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class USCensusData
{
    @CsvBindByName(column = "State Id", required = true)
    public String StateId;

    @CsvBindByName(column = "State", required = true)
    private String State;

    @CsvBindByName(column = "Population", required = true)
    public String Population;

    @CsvBindByName(column = "Housing units", required = true)
    public String HousingUnits;

    @CsvBindByName(column = "Total area", required = true)
    public String TotalArea;

    @CsvBindByName(column = "Water area", required = true)
    public String WaterArea;

    @CsvBindByName(column = "Land area", required = true)
    public String LandArea;

    @CsvBindByName(column = "Population Density", required = true)
    public String PopulationDensity;

    @CsvBindByName(column = "Housing Density", required = true)
    public String HousingDensity;


    public String getStateId() { return StateId; }
    public String getState() {
        return State;
    }
    public String getPopulation() {
        return Population;
    }
    public String getHousingUnits() {
        return HousingUnits;
    }
    public String getTotalArea() {
        return TotalArea;
    }
    public String getWaterArea() {
        return WaterArea;
    }
    public String getLandArea() {
        return LandArea;
    }
    public String getPopulationDensity() {
        return PopulationDensity;
    }
    public String getHousingDensity() {
        return HousingDensity;
    }

    @Override
    public String toString() {
        return "USCensusData{" +
                "StateId='" + StateId + '\'' +
                ", State='" + State + '\'' +
                ", Population='" + Population + '\'' +
                ", HousingUnits='" + HousingUnits + '\'' +
                ", TotalArea='" + TotalArea + '\'' +
                ", WaterArea='" + WaterArea + '\'' +
                ", LandArea='" + LandArea + '\'' +
                ", PopulationDensity='" + PopulationDensity + '\'' +
                ", HousingDensity='" + HousingDensity + '\'' +
                '}';
    }
}
