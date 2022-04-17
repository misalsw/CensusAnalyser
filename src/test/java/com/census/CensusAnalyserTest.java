package com.census;

import com.opencsv.exceptions.CsvException;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_FILE_TYPE = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INDIA_CENSUS_CSV_WRONG_DELIMITER = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INDIA_CENSUS_CSV_WRONG_HEADER = "./src/main/resources/IndiaStateCensusData.csv";
    CensusAnalyser censusAnalyser = new CensusAnalyser();

    // TC 1.1

    @Test
    void givenIndianCensusCSVFile_returnsCorrectRecords() throws CensusAnalyserException {
        int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
        Assert.assertEquals(29, numOfRecords);
    }
    
    //TC 1.2
    @Test
    public void  givenIndiaCensusData_withWrongFile_shouldThrowException() throws CensusAnalyserException {
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CsvException.class);
        censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
    }

    //TC 1.3

    @Test
    public void givenIndiaCensusData_withWrongFileType_shouldThrowException() throws CensusAnalyserException {
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CsvException.class);
        censusAnalyser.loadIndiaCensusData(WRONG_FILE_TYPE);
    }
    
    //TC 1.4

    @Test
    public void givenIndiaCensusData_withWrongDelimiterFile_shouldThrowException() throws CensusAnalyserException {
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CsvException.class);
        censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_WRONG_DELIMITER);
    }
    
    // TC 1.5

    @Test
    public void givenIndiaCensusData_withWrongHeader_shouldThrowException() throws CensusAnalyserException {
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CsvException.class);
        censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_WRONG_HEADER);

    }
}