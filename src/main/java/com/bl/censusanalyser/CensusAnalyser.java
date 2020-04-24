package com.bl.censusanalyser;
import com.bl.censusanalyser.exception.CensusAnalyserException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

public class CensusAnalyser<E>
{
    // welcome message
    public static void main(String[] args)
    {
        System.out.println("Welcome To Indian State Censes Analyser");
    }

    ///Read State Census Data CSV file
    //Iterable is interface allow object to make use of for each loop it does internally by calling iterator methode object
    //spliterator() It helps in processing the collection data in parallel
    public int readFile(String filePath, Object E)
    {
        //int noOfRecords = 0;
        try
        {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            ICSVBuilder icsvBuilder=CSVBuilderFactory.createCSVBuilder();
            List<E> censusCSVlist=icsvBuilder.getCSVFileList(reader,E.getClass());
            return censusCSVlist.size();
        }
        catch (IOException e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, "Enter Correct File And Type For State Censes Data");
        }
        catch (RuntimeException  e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, "Check Delimiter And Header For State Censes Data");
        }

    }
    private <E> int getCount(Iterator<E> iterator)
    {
        Iterable<E> csviterable=()->iterator;
        int numberOfEntries=(int)StreamSupport.stream(csviterable.spliterator(),false).count();
        return numberOfEntries;
    }
}
