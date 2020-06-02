package com.indianStateCensesAnalyzer;

import com.bl.censusanalyser.CensusAnalyser;
import com.bl.censusanalyser.model.IndianStateCensesAnalyzer;
import com.bl.censusanalyser.model.IndianStateCode;
import com.bl.censusanalyser.model.USCensusData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.bl.censusanalyser.ConstantForFileLocation.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CensusAnalyserUnitTest {
    CensusAnalyser censusAnalyser;


    @Before
    public void setup() {
        censusAnalyser = mock(CensusAnalyser.class);
    }

    @Test
    public void givenFilePathOfStateCode_WhenNoOfRecordMatches_ThenReturnTrue() {
        CensusAnalyser censusAnalyser = mock(CensusAnalyser.class);
        when(censusAnalyser.readFile(STATE_CODE_CSV_FILE, IndianStateCode.class)).thenReturn(37);
        int noOfRecords = censusAnalyser.readFile(STATE_CODE_CSV_FILE, IndianStateCode.class);
        Assert.assertEquals(37, noOfRecords);
    }

    @Test
    public void givenFilePath_WhenNoOfRecordMatches_ThenReturnTrue() {
        CensusAnalyser censusAnalyser = mock(CensusAnalyser.class);
        when(censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH, IndianStateCensesAnalyzer.class)).thenReturn(29);
        int noOfRecords = censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH, IndianStateCensesAnalyzer.class);
        Assert.assertEquals(29, noOfRecords);
    }

    @Test
    public void givenFilePathForUSCensus_WhenNoOfRecordMatches_ThenReturnTrue() {
        CensusAnalyser censusAnalyser = mock(CensusAnalyser.class);
        when(censusAnalyser.readFile(US_CENSUS_CSV_FILE_PATH, USCensusData.class)).thenReturn(51);
        int noOfRecords = censusAnalyser.readFile(US_CENSUS_CSV_FILE_PATH, USCensusData.class);
        Assert.assertEquals(51, noOfRecords);
    }

}
