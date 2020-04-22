package com.indianStateCensesAnalyzer;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CsvStates
{
    public Integer loadIndianStateCodes(String StateCodefilePath)
    {
        int count=0;
        try
        {
            BufferedReader reader= Files.newBufferedReader(Paths.get(StateCodefilePath));
            CsvToBean<IndianStateCode> csvToBean= new CsvToBeanBuilder(reader)
                    .withType(IndianStateCode.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IndianStateCode>indianStateCodeIterator=csvToBean.iterator();
            while (indianStateCodeIterator.hasNext())
            {
                IndianStateCode indianStateCode=indianStateCodeIterator.next();
                count++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return count;
    }

}
