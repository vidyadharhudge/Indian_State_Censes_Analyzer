package com.indianStateCensesAnalyzer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CensusAnalyserTest
{
    private static final String INDIA_CENSUS_CSV_FILE_PATH="C:/Users/Er. Sandesh Bora/shell-Problmes-Statments/Indian_State_Censes_Analyzer/StateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH="C:/Users/Er. Sandesh Bora/shell-Problmes-Statment/Indian_State_Censes_Analyzer/StateCensusData.csv";
    CensusAnalyser censusAnalyser;

    @Before
    public void setup()
    {
        censusAnalyser=new CensusAnalyser();
    }

    /* Tc 1.1 :Given The State Census Csv File, Check To Ensure The Number Of Record Matches */
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

    /* T.C 1.2 :Given Indian State Censes Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenIndianCensusData_WithWongFile_ShouldThrowException()
    {
        try
        {
            CensusAnalyser.readFile(WRONG_CSV_FILE_PATH);
        }
        // Handling Exception "Enter Correct File And Type" ;
        //e.type=FILE_NOT_FOUND;
        catch (CensusAnalyserException e) // Handling Exception "Enter Correct File And Type"
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.type);
        }

    }

}
