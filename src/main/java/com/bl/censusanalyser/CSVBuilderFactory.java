package com.bl.censusanalyser;

import com.bl.censusanalyser.opencsv.OpenCsv;

public class CSVBuilderFactory
{
    public static ICSVBuilder createCSVBuilder()
    {
        return new OpenCsv();
    }
}
