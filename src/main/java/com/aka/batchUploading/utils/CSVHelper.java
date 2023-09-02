package com.aka.batchUploading.utils;

import com.aka.batchUploading.entity.Employee;
import org.apache.commons.csv.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {

    public static String TYPE = "text/csv";
    public static Logger logger = LoggerFactory.getLogger(CSVHelper.class);

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static List<Employee> csvToEmployees(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Employee> tutorials = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Employee employee = new Employee(
                        csvRecord.get("FirstName"),
                        csvRecord.get("LastName"),
                        csvRecord.get("StartDate"),
                        csvRecord.get("ExitDate"),
                        csvRecord.get("Title"),
                        csvRecord.get("Supervisor"),
                        csvRecord.get("ADEmail"),
                        csvRecord.get("BusinessUnit"),
                        csvRecord.get("EmployeeStatus"),
                        csvRecord.get("EmployeeType"),
                        csvRecord.get("PayZone"),
                        csvRecord.get("EmployeeClassificationType"),
                        csvRecord.get("TerminationType"),
                        csvRecord.get("TerminationDescription"),
                        csvRecord.get("DepartmentType"),
                        csvRecord.get("Division"),
                        csvRecord.get("DOB"),
                        csvRecord.get("State"),
                        csvRecord.get("JobFunctionDescription"),
                        csvRecord.get("GenderCode"),
                        csvRecord.get("LocationCode"),
                        csvRecord.get("RaceDesc"),
                        csvRecord.get("MaritalDesc"),
                        csvRecord.get("Performance Score"),
                        csvRecord.get("Current Employee Rating"));


                tutorials.add(employee);
            }

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream employeesToCSV(List<Employee> employees) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Employee employee : employees) {
                List<String> data = Arrays.asList(
                        String.valueOf(employee.getEmail()),
                        employee.getTitle(),
                        employee.getEmployeeType(),
                        employee.getDob());

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }

}
