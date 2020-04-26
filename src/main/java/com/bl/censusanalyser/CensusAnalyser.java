package com.bl.censusanalyser;

import com.bl.censusanalyser.exception.CensusAnalyserException;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CensusAnalyser<E>
{
    List<E>censusCSVlist=null;
    Map<String,E> censusMap;

    // welcome message
    public static void main(String[] args)
    {
        System.out.println("Welcome To Indian State Censes Analyser");
    }
    public CensusAnalyser()
    {
        censusMap=new HashMap<>();

    }

    ///Read State Census Data CSV file
    //Iterable is interface allow object to make use of for each loop it does internally by calling iterator methode object
    //spliterator() It helps in processing the collection data in parallel
    public int readFile(String filePath, Object E)
    {
        try
        {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            ICSVBuilder icsvBuilder=CSVBuilderFactory.createCSVBuilder();
            Iterator<E>censusCsvIterator=icsvBuilder.getCSVfile(reader,E.getClass());
            while (censusCsvIterator.hasNext())
            {
                E value=censusCsvIterator.next();
                this.censusMap.put(E.toString(),value);
                censusCSVlist=censusMap.values().stream().collect(Collectors.toList());
            }
            return censusMap.size();
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
    // no of entries in Csv File
    private <E> int getCount(Iterator<E> iterator)
    {
        Iterable<E> csviterable=()->iterator;
        int numberOfEntries=(int)StreamSupport.stream(csviterable.spliterator(),false).count();
        return numberOfEntries;
    }
    //Getting Data Of State
    public String getStateWiseSortedData(Object E)
    {
        if (censusCSVlist.size()==0 || censusCSVlist==null)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.NO_CENSUS_DATA,"No Data Is Prsent");
        }
        Comparator<E>indianStateCodeComparator=Comparator.comparing(IndianStateCensesAnalyzer->IndianStateCensesAnalyzer.toString());
        this.sort(indianStateCodeComparator,censusCSVlist);
        String sortedCensusJson=new Gson().toJson(censusCSVlist);
        return sortedCensusJson;
    }
    //Getting Code Of State
    public String getStateWiseSortedCode(Object E)
    {
        if (censusCSVlist.size()==0 || censusCSVlist==null)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.NO_CENSUS_DATA,"No Data Is Prsent");
        }
        Comparator<E>indianStateCodeComparator=Comparator.comparing(IndianStateCode->IndianStateCode.toString());
        this.sort(indianStateCodeComparator,censusCSVlist);
        String sortedCensusJson=new Gson().toJson(censusCSVlist);
        return sortedCensusJson;
    }

    //Function To Sorted States
    public void sort(Comparator<E>indianStateCodeComparator,List<E> censusCSVlist)
    {
        for (int i = 0; i<censusCSVlist.size()-1; i++)
        {
            for (int j=0;j<censusCSVlist.size()-i-1; j++)
            {
                E censesAnalyzer1=censusCSVlist.get(j);
                E censesAnalyzer2=censusCSVlist.get(j+1);
                if(indianStateCodeComparator.compare(censesAnalyzer1,censesAnalyzer2)>0)
                {
                    censusCSVlist.set(j,censesAnalyzer2);
                    censusCSVlist.set(j+1,censesAnalyzer1);
                }

            }
        }
    }
}
