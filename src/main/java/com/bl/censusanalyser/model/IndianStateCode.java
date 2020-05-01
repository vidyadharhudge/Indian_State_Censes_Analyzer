package com.bl.censusanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCode {
    @CsvBindByName(column = "SrNo", required = true)
    public int srNo;

    @CsvBindByName(column = "StateName", required = true)
    public String stateName;

    @CsvBindByName(column = "TIN", required = true)
    public int tin;

    @CsvBindByName(column = "StateCode", required = true)
    public String stateCode;

    public int getSrNo() {
        return srNo;
    }
    public String getStateName() {
        return stateName;
    }
    public int getTin() {
        return tin;
    }
    public String getStateCode() {
        return stateCode;
    }

    @Override
    public String toString() {
        return "IndianStateCode{" +
                "srNo=" + srNo +
                ", stateName='" + stateName + '\'' +
                ", tin=" + tin +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
