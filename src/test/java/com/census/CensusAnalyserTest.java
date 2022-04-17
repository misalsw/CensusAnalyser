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

    private static final String INDIA_STATE_CODE_CSV_FILE = "./src/test/resources/IndiaStateCode.csv";
    private static final String WRONG_STATE_CODE_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String WRONG_STATE_CODE_FILE_TYPE = "./src/test/resources/IndiaStateCode.txt";
    private static final String INDIA_STATE_CODE_WRONG_DELIMITER = "/src/test/resources/IndiaStateCodeWrongDelimiter.csv";
    private static final String INDIA_STATE_CODE_WRONG_HEADER = "/src/test/resources/IndiaStateCodeWrongHeader";


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

    // UC2 TC 1.2
    @Test
    public void givenIndiaStateCodeData_withWrongFile_shouldThrowException() {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CsvException.class);
            censusAnalyser.loadIndiaStateCode(WRONG_STATE_CODE_FILE_PATH);
        } catch (CSVException e) {
            Assert.assertEquals(CSVException.ExceptionType.STATE_CODE_FILE_PROBLEM, e.type);
        }
    }

    // UC2 TC 1.3
    @Test
    public void givenIndiaStateCodeData_withWrongFileType_shouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CsvException.class);
            censusAnalyser.loadIndiaStateCode(WRONG_STATE_CODE_FILE_TYPE);
        } catch (CSVException e) {
            Assert.assertEquals(CSVException.ExceptionType.STATE_CODE_FILE_PROBLEM, e.type);
        }
    }

    // TC 1.4
    @Test
    public void givenIndiaStateCodeData_withWrongDelimiterFile_shouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVException.class);
            censusAnalyser.loadIndiaStateCode(INDIA_STATE_CODE_WRONG_DELIMITER);
        } catch (CSVException e) {
            Assert.assertEquals(CSVException.ExceptionType.STATE_CODE_FILE_PROBLEM, e.type);
        }
    }

    // TC 1.5 (Wrong header)
    @Test
    public void givenIndiaStateCode_withWrongHeader_shouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVException.class);
            censusAnalyser.loadIndiaStateCode(INDIA_STATE_CODE_WRONG_HEADER);
        } catch (CSVException e) {
            Assert.assertEquals(CSVException.ExceptionType.STATE_CODE_FILE_PROBLEM, e.type);
        }
    }
}