package com.bl.censusanalyser;

import com.bl.censusanalyser.exception.CensusAnalyserException;
import com.bl.censusanalyser.model.IndianStateCensesAnalyzer;
import com.bl.censusanalyser.model.IndianStateCode;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser
{
    // welcome message
    public static void main(String[] args)
    {
        System.out.println("Welcome To Indian State Censes Analyser");
    }
    ///Read State Census Data CSV file
    //Iterable is interface allow object to make use of for each loop it does internally by calling iterator methode object
    //spliterator() It helps in processing the collection data in parallel
    public Integer readFile(String filePath)
    {
        int noOfRecords = 0;
        try
        {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            Iterator<IndianStateCensesAnalyzer> stateCensesAnalyzerIterator = this.getCSVfile(reader, IndianStateCensesAnalyzer.class);
            Iterable<IndianStateCensesAnalyzer> StateCensesAnalyzerIterable = () -> stateCensesAnalyzerIterator;
            noOfRecords=(int) StreamSupport.stream(StateCensesAnalyzerIterable.spliterator(), false).count();
            return noOfRecords;
        }
        catch (IOException e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, "Enter Correct File And Type For State Censes Data");
        }
        catch (RuntimeException e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, "Check Delimiter And Header For State Censes Data");
        }
    }

    // Read State Code Data CSV file
    public int loadIndianStateCodes(String StateCodefilePath)
    {
        int countRecords = 0;
        try
        {
            BufferedReader reader = Files.newBufferedReader(Paths.get(StateCodefilePath));
            Iterator<IndianStateCode> indianStateCodeIterator = this.getCSVfile(reader, IndianStateCode.class);
            Iterable<IndianStateCode> iterableIndianStateCode = () -> indianStateCodeIterator;
            countRecords = (int) StreamSupport.stream(iterableIndianStateCode.spliterator(), false).count();
            return countRecords;
        }
        catch (IOException e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, "Enter Correct File And Type For State Code Data");
        }
        catch (RuntimeException e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, "Check Delimiter And Header For State Code Data");
        }
    }
    // Open Csv Code
    private <E> Iterator<E> getCSVfile(BufferedReader reader, Class<E> csvClass)
    {
        CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<E>(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvToBeanBuilder.build();
        return csvToBean.iterator();
    }
}
