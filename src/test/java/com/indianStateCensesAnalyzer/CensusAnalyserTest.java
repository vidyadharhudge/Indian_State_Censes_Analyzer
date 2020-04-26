package com.indianStateCensesAnalyzer;
import com.bl.censusanalyser.CensusAnalyser;
import com.bl.censusanalyser.exception.CensusAnalyserException;
import com.bl.censusanalyser.model.IndianStateCensesAnalyzer;
import com.bl.censusanalyser.model.IndianStateCode;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.indianStateCensesAnalyzer.ConstantsPaths.*;
public class CensusAnalyserTest {
    CensusAnalyser censusAnalyser;

    @Before
    public void setup()
    {
        censusAnalyser = new CensusAnalyser();
    }

    /* Tc 1.1 :Given The State Census Csv File, Check To Ensure The Number Of Record Matches */
    @Test
    public void givenFilePath_WhenNoOfRecordMatches_ThenReturnTrue() {
        try {
            int noOfRecords = censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH, IndianStateCensesAnalyzer.class);
            Assert.assertEquals(29, noOfRecords);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();

        }
    }

    /* T.C 1.2 :Given State Censes Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongFile_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_CSV_FILE_PATH, IndianStateCensesAnalyzer.class);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.type);
        }
    }

    /* T.C 1.3 :Given State Censes Csv Type Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongType_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_CSV_FILE_TYPE, IndianStateCensesAnalyzer.class);
        } catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.type);
        }
    }

    /* T.C 1.4 :Given State Censes Csv file Is Correct But With Wrong Delimiter Should Rhrow Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongDelimiter_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_DELIMITER_FILE, IndianStateCensesAnalyzer.class);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, e.type);
        }
    }

    /* T.C 1.5 :Given State Censes Csv file Is Correct But With Wrong Header Should Rhrow Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongHeader_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_DELIMITER_FILE, IndianStateCensesAnalyzer.class);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, e.type);
        }
    }

    /* Tc 2.1 :Given The State code Csv File, Check To Ensure The Number Of Record Matches */
    @Test
    public void givenFilePathOfStateCode_WhenNoOfRecordMatches_ThenReturnTrue() {
        try {
            int noOfRecords = censusAnalyser.readFile(STATE_CODE_CSV_FILE, IndianStateCode.class);
            Assert.assertEquals(37, noOfRecords);
        } catch (CensusAnalyserException e) {
        }
    }

    /* T.C 2.2 :Given State Code Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongFile_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_CSV_FILE_PATHS, IndianStateCode.class);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.type);
        }
    }

    /* T.C 2.3 :Given State Code Csv Type Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongType_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_CSV_FILE_TYPES, IndianStateCode.class);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.type);
        }
    }

    /* T.C 2.4 :Given State Code Csv file Is Correct But With Wrong Delimiter Should Throw Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongDelimiter_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_DELIMITER_FILES, IndianStateCode.class);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, e.type);
        }
    }

    /* T.C 2.5 :Given State Code Csv file Is Correct But With Wrong Header Should Rhrow Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongHeader_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_DELIMITER_FILES, IndianStateCode.class);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, e.type);
        }
    }

    /* T.C 3.1 :Indian Census Data In Sorted Form  */
    @Test
    public void givenIndianCensusData_WhenSorted_ThenShouldReturnSortedDataStartStateAndEndState()
    {
        try
        {
            censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH, IndianStateCensesAnalyzer.class);
            String sortedData = censusAnalyser.getStateWiseSortedData(IndianStateCensesAnalyzer.class);
            IndianStateCensesAnalyzer[] indianStateCensesAnalyzers = new Gson().fromJson(sortedData, IndianStateCensesAnalyzer[].class);
            Assert.assertEquals("Andhra Pradesh", indianStateCensesAnalyzers[0].getState());
            Assert.assertEquals("West Bengal", indianStateCensesAnalyzers[29].getState());
        } catch (CensusAnalyserException e)
        {
            e.printStackTrace();
        }
    }
    /* T.C 4.1 :Indian Code In Sorted Form  */
    @Test
    public void givenIndianCensusCode_WhenSorted_ThenShouldReturnSortedDataStartStateAndEndState() {
        try {
            censusAnalyser.readFile(STATE_CODE_CSV_FILE, IndianStateCode.class);
            String sortedData = censusAnalyser.getStateWiseSortedCode(IndianStateCode.class);
            IndianStateCode[] indianStateCodes = new Gson().fromJson(sortedData, IndianStateCode[].class);
            Assert.assertEquals("AD", indianStateCodes[0].getStateCode());
            Assert.assertEquals("WB", indianStateCodes[36].getStateCode());
        } catch (CensusAnalyserException e) {
            e.printStackTrace();

        }
    }
}