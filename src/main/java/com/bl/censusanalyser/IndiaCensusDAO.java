package com.bl.censusanalyser;
import com.bl.censusanalyser.model.IndianStateCensesAnalyzer;
import com.bl.censusanalyser.model.IndianStateCode;
import com.bl.censusanalyser.model.USCensusData;

public class IndiaCensusDAO<E> {
    private String state;
    private int population;
    private int area;
    private int density;
    private String stateCode;
    private int srNo;
    private String stateName;
    private int tin;
    public String State;//
    public String StateId;
    public String Population;
    public String HousingUnits;
    public String TotalArea;
    public String WaterArea;
    public String LandArea;
    public String PopulationDensity;
    public String HousingDensity;
    IndianStateCensesAnalyzer indianStateCensesAnalyzer;
    IndianStateCode indianStateCode;
    USCensusData usCensusData;

    public IndiaCensusDAO(IndianStateCensesAnalyzer indianStateCensesAnalyzer) {
        state = indianStateCensesAnalyzer.getState();
        population = indianStateCensesAnalyzer.getPopulation();
        area = indianStateCensesAnalyzer.getArea();
        density = indianStateCensesAnalyzer.getDensity(); }

    public IndiaCensusDAO(IndianStateCode indianStateCode) {
        stateCode = indianStateCode.getStateCode();
        srNo = indianStateCode.getSrNo();
        stateName = indianStateCode.getStateName();
        tin = indianStateCode.getTin(); }

    public IndiaCensusDAO(USCensusData usCensusData) {
        State=usCensusData.getState();
        StateId=usCensusData.getStateId();
        Population=usCensusData.getPopulation();
        HousingUnits=usCensusData.getHousingUnits();
        TotalArea=usCensusData.getTotalArea();
        WaterArea=usCensusData.getWaterArea();
        LandArea=usCensusData.getLandArea();
        PopulationDensity=usCensusData.getPopulationDensity();
        HousingDensity=usCensusData.getHousingDensity(); }

    public IndiaCensusDAO(Class<E> csvClass) {}

        public String getState () {
            return state;
        }

        public void setState (String state){
            this.state = indianStateCensesAnalyzer.getState();
        }

        public int getPopulation () {
            return population;
        }

        public void setPopulation ( int population){
            this.population=indianStateCensesAnalyzer.getPopulation();
        }

        public int getArea () {
            return area;
        }

        public void setArea ( int area){
            this.area = indianStateCensesAnalyzer.getArea();
        }

        public int getDensity () {
            return density;
        }

        public void setDensity ( int density){
            this.density = indianStateCensesAnalyzer.getDensity();
        }

        public String getStateCode () {
            return stateCode;
        }

        public void setStateCode (String stateCode){
            this.stateCode = indianStateCode.getStateCode();
        }

        public int getSrNo () {
            return srNo;
        }

        public void setSrNo ( int srNo){
            this.srNo = indianStateCode.getSrNo();
        }

        public String getStateName () {
            return stateName;
        }

        public void setStateName (String stateName){
            this.stateName = indianStateCode.getStateName();
        }

        public int getTin () {
            return tin;
        }

        public void setTin ( int tin){
            this.tin = indianStateCode.getTin();
        }

        public String getStateId() {return StateId; }

        public void setStateId(String stateId) { StateId = usCensusData.getStateId(); }

        public void setPopulation(String population) { Population = usCensusData.getPopulation(); }

        public String getHousingUnits() { return HousingUnits; }

        public void setHousingUnits(String housingUnits) { HousingUnits = usCensusData.getHousingUnits(); }

        public String getTotalArea() { return TotalArea; }

        public void setTotalArea(String totalArea) { TotalArea = usCensusData.getTotalArea(); }

        public String getWaterArea() { return WaterArea; }

        public void setWaterArea(String waterArea) { WaterArea = usCensusData.getWaterArea(); }

        public String getLandArea() { return LandArea; }

        public void setLandArea(String landArea) { LandArea = usCensusData.getLandArea(); }

        public String getPopulationDensity() { return PopulationDensity; }

        public void setPopulationDensity(String populationDensity) { PopulationDensity = usCensusData.getPopulationDensity(); }

        public String getHousingDensity() { return HousingDensity; }

        public void setHousingDensity(String housingDensity) { HousingDensity = usCensusData.getHousingDensity(); }

    }
