package com.bl.censusanalyser.exception;

public class CensusAnalyserException extends RuntimeException
{
    public enum ExceptionType
    {
        FILE_NOT_FOUND,WRONG_DELIMITER,NO_CENSUS_DATA;
    }
    public ExceptionType type;
    public CensusAnalyserException(ExceptionType type, String message)
    {
        super(message);
        this.type=type;
        System.out.println(message);
    }
}
