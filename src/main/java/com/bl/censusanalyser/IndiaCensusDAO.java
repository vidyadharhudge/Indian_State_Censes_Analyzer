package com.bl.censusanalyser;
import com.bl.censusanalyser.model.IndianStateCensesAnalyzer;
import com.bl.censusanalyser.model.IndianStateCode;

public class IndiaCensusDAO
{
    public String state;
    public int population;
    public int area;
    public int density;
    public String stateCode;
    public IndiaCensusDAO(IndianStateCensesAnalyzer indianStateCensesAnalyzer)
    {
        state=indianStateCensesAnalyzer.getState();
        population=indianStateCensesAnalyzer.getPopulation();
        area=indianStateCensesAnalyzer.getArea();
        density=indianStateCensesAnalyzer.getDensity();
    }
    public IndiaCensusDAO(IndianStateCode indianStateCode)
    {
        stateCode=indianStateCode.getStateCode();
    }
}
