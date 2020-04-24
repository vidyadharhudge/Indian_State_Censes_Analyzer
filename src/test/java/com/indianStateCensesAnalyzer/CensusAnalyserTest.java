package com.indianStateCensesAnalyzer;
import com.bl.censusanalyser.CensusAnalyser;
import com.bl.censusanalyser.exception.CensusAnalyserException;
import com.bl.censusanalyser.model.IndianStateCensesAnalyzer;
import com.bl.censusanalyser.model.IndianStateCode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.indianStateCensesAnalyzer.ConstantsPaths.*;
public class CensusAnalyserTest
{
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
            int noOfRecords=censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH,IndianStateCensesAnalyzer.class);
            Assert.assertEquals(29,noOfRecords);
        }
        // e.printStackTrace(); it is methode of java Throwable class
        catch (CensusAnalyserException e)
        {
            e.printStackTrace();
        }
    }
    /* T.C 1.2 :Given State Censes Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongFile_ThenShouldThrowException()
    {
        try
        {
            censusAnalyser.readFile(WRONG_CSV_FILE_PATH,IndianStateCensesAnalyzer.class);
        }
        // Handling Exception "Enter Correct File And Type" ;
        //e.type=FILE_NOT_FOUND;
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.type);
        }
    }
    /* T.C 1.3 :Given State Censes Csv Type Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongType_ThenShouldThrowException()
    {
        try
        {
            censusAnalyser.readFile(WRONG_CSV_FILE_TYPE,IndianStateCensesAnalyzer.class);
        }
        // Handling Exception "Enter Correct File And Type" ;
        //e.type=FILE_NOT_FOUND;
        catch (CensusAnalyserException e) // Handling Exception "Enter Correct File And Type"
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.type);
        }
    }
    /* T.C 1.4 :Given State Censes Csv file Is Correct But With Wrong Delimiter Should Rhrow Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongDelimiter_ThenShouldThrowException()
    {
        try
        {
            censusAnalyser.readFile(WRONG_DELIMITER_FILE,IndianStateCensesAnalyzer.class);
        }
        // Handling Exception "Check Delimiter And Header" ;
        //e.type=WRONG_DELIMITER;
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER,e.type);
        }
    }
    /* T.C 1.5 :Given State Censes Csv file Is Correct But With Wrong Header Should Rhrow Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongHeader_ThenShouldThrowException()
    {
        try
        {
            censusAnalyser.readFile(WRONG_DELIMITER_FILE,IndianStateCensesAnalyzer.class);
        }
        // Handling Exception "Check Delimiter And Header" ;
        //e.type=WRONG_DELIMITER;
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER,e.type);
        }
    }
    /* Tc 2.1 :Given The State code Csv File, Check To Ensure The Number Of Record Matches */
    @Test
    public void givenFilePathOfStateCode_WhenNoOfRecordMatches_ThenReturnTrue()
    {
        try
        {
            int noOfRecords=censusAnalyser.readFile(STATE_CODE_CSV_FILE, IndianStateCode.class);
            Assert.assertEquals(37,noOfRecords);
        }
        catch (CensusAnalyserException e)
        {
            e.printStackTrace();
        }
    }
    /* T.C 2.2 :Given State Code Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongFile_ThenShouldThrowException()
    {
        try
        {
            censusAnalyser.readFile(WRONG_CSV_FILE_PATHS,IndianStateCode.class);
        }
        // Handling Exception "Enter Correct File And Type" ;
        //e.type=FILE_NOT_FOUND;
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.type);
        }
    }
    /* T.C 2.3 :Given State Code Csv Type Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongType_ThenShouldThrowException()
    {
        try
        {
            censusAnalyser.readFile(WRONG_CSV_FILE_TYPES,IndianStateCode.class);
        }
        // Handling Exception "Enter Correct File And Type" ;
        //e.type=FILE_NOT_FOUND;
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.type);
        }
    }

    /* T.C 2.4 :Given State Code Csv file Is Correct But With Wrong Delimiter Should Throw Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongDelimiter_ThenShouldThrowException()
    {
        try
        {
            censusAnalyser.readFile(WRONG_DELIMITER_FILES,IndianStateCode.class);
        }
        // Handling Exception "Check Delimiter And Header" ;
        //e.type=WRONG_DELIMITER;
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER,e.type);
        }
    }
    /* T.C 2.5 :Given State Code Csv file Is Correct But With Wrong Header Should Rhrow Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongHeader_ThenShouldThrowException()
    {
        try
        {
            censusAnalyser.readFile(WRONG_DELIMITER_FILES,IndianStateCode.class);
        }
        // Handling Exception "Check Delimiter And Header" ;
        //e.type=WRONG_DELIMITER;
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER,e.type);
        }
    }
}



