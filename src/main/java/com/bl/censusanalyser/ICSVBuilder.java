package com.bl.censusanalyser;

import com.bl.censusanalyser.exception.CsvBuilderException;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder<E>
{
     public Iterator<E> getCSVfile(BufferedReader reader, Class<E> csvClass) throws CsvBuilderException;
     public List<E>getCSVFileList(BufferedReader reader, Class<E> csvClass)throws CsvBuilderException;

}