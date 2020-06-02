package com.bl.censusanalyser.dao;

import com.bl.censusanalyser.model.IndianStateCensesAnalyzer;

public class IndiaCensusDAO<E>
{
    public String State;
    public int population;
    public int area;
    public int density;
    public String stateCode;
    public int srNo;
    public String stateName;
    public int tin;
    public String StateId;
    public String HousingUnits;
    public String TotalArea;
    public String WaterArea;
    public String LandArea;
    public String PopulationDensity;
    public String HousingDensity;

    public IndiaCensusDAO(IndianStateCensesAnalyzer indianStateCensesAnalyzer)
    {
        State = indianStateCensesAnalyzer.getState();
        population = indianStateCensesAnalyzer.getPopulation();
        area = indianStateCensesAnalyzer.getArea();
        density = indianStateCensesAnalyzer.getDensity();
    }

    public String getState ()
    {
        return State;
    }
    public String getTotalArea()
    {
        return TotalArea;
    }
    public String getPopulationDensity()
    {
        return PopulationDensity;
    }

    @Override
    public String toString() {
        return srNo +
                "," + State +
                "," + population +
                "," + area +
                "," + tin +
                "," + stateCode +
                "," + density +
                "," + stateName +
                "," + TotalArea +
                "," + StateId+
                "," + HousingUnits +
                "," + area +
                "," + WaterArea +
                "," + PopulationDensity +
                "," + LandArea +
                "," + HousingDensity ;
    }
}
