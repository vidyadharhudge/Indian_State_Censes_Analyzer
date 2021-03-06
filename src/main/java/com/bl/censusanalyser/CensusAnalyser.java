package com.bl.censusanalyser;
import com.bl.censusanalyser.dao.IndiaCensusDAO;
import com.bl.censusanalyser.exception.CensusAnalyserException;
import com.bl.censusanalyser.model.IndianStateCensesAnalyzer;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CensusAnalyser<E>
{
    List<E>censusCSVlist=null;
    Map<Object,E> censusMap;

    public static void main(String[] args) {
        System.out.println("Welcome To Indian State Censes Analyser"); }

    public CensusAnalyser() {
        censusMap=new HashMap<>(); }
        public int readFile(String filePath, Class<E>csvClass) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            ICSVBuilder icsvBuilder=CSVBuilderFactory.createCSVBuilder();
            Iterator<E>censusCsvIterator=icsvBuilder.getCSVfile(reader,csvClass);
            Iterable<E>iterable=()->censusCsvIterator;
            while (censusCsvIterator.hasNext()) {
                IndiaCensusDAO value=new IndiaCensusDAO((IndianStateCensesAnalyzer)censusCsvIterator.next());
                this.censusMap.put(value.getState(),(E)value);
                censusCSVlist=censusMap.values().stream().collect(Collectors.toList()); }
                int noOfRecords=censusMap.size();
                return noOfRecords;
        }
        catch (IOException e) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, "Enter Correct File And Type For State Censes Data"); }
        catch (RuntimeException  e) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, "Check Delimiter And Header For State Censes Data"); }
    }

    // State Wise Sorted Code
    public String SortedCode(int Numbers,Object E) {
        if (censusCSVlist.size()==0 || censusCSVlist==null) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.NO_CENSUS_DATA,"No Data Is Prsent"); }
        Comparator<E>indianStateCodeComparator=Comparator.comparing(censusCsv->E.toString());
        this.sort(Numbers,censusCSVlist);
        String sortedCensusJson=new Gson().toJson(censusCSVlist);
        return sortedCensusJson; }

    // Sorting Methode
    public void sort(int numbers,List<E>censusCSVlist) {
        for (int i = 0; i<censusCSVlist.size(); i++) {
            for (int j=0;j<censusCSVlist.size()-i-1; j++) {
                String censesAnalyzer1[]=censusCSVlist.get(i).toString().split(",");
                 String censesAnalyzer2[]=censusCSVlist.get(j).toString().split(",");
                if(censesAnalyzer1[1].compareToIgnoreCase(censesAnalyzer2[1])<0) {
                    E Data=censusCSVlist.get(i);
                    E Data1=censusCSVlist.get(j);
                    censusCSVlist.set(j,Data);
                    censusCSVlist.set(i,Data1); }
            }
        }
    }
}
