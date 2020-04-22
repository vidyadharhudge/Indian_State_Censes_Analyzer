package com.indianStateCensesAnalyzer;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCensesAnalyzer
{
    @CsvBindByName(column="State")
    public String state;

    @CsvBindByName (column ="Population")
    public String population;

    @CsvBindByName(column = "AreaInSqKm")
    public String area;

    @CsvBindByName (column = "DensityPerSqKm")
    public String density;


    @Override
    public String toString() {
        return "IndianStateCensesAnalyzer{" +
                "state='" + state + '\'' +
                ", population='" + population + '\'' +
                ", area='" + area + '\'' +
                ", density='" + density + '\'' +
                '}';
    }
}
