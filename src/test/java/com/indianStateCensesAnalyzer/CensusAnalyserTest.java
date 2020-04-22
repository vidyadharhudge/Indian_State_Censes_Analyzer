package com.indianStateCensesAnalyzer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CensusAnalyserTest
{
    private static final String INDIA_CENSUS_CSV_FILE_PATH="C:/Users/Er. Sandesh Bora/shell-Problmes-Statments/Indian_State_Censes_Analyzer/StateCensusData.csv";
    CensusAnalyser censusAnalyser;
    @Before
    public void setup()
    {
        censusAnalyser=new CensusAnalyser();
    }
    @Test
    public void givenFilePath_WhenNoOfRecordMatches_ThenReturnTrue()
    {
        try
        {
            int noOfRecords=censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,noOfRecords);

        }
        catch (CensusAnalyserException e)
        {
            e.printStackTrace();
        }
    }

}
