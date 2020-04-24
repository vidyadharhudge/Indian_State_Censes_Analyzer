package com.bl.censusanalyser.opencsv;
import com.bl.censusanalyser.ICSVBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.util.Iterator;

public class OpenCsv implements ICSVBuilder
{
    @Override
    public Iterator<ICSVBuilder> getCSVfile(BufferedReader reader, Class csvClass)
    {
        CsvToBeanBuilder<ICSVBuilder> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<ICSVBuilder> csvToBean = csvToBeanBuilder.build();
        return csvToBean.iterator();
    }
}

