package com.indianStateCensesAnalyzer;

public class CensusAnalyserException extends Exception
{
    public enum ExceptionType
    {
        FILE_NOT_FOUND,WRONG_DELIMITER;
    }
    public ExceptionType type;
    public CensusAnalyserException(ExceptionType type,String message)
    {
        super(message);
        this.type=type;
        System.out.println(message);
    }

}
