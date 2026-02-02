package com.functionalinterface.dataexport;
public class AdvancedReportExporter implements Exporter {

    public void exportToCSV() {
        System.out.println("Exporting report to CSV");
    }

    public void exportToPDF() {
        System.out.println("Exporting report to PDF");
    }

    // custom JSON logic
    public void exportToJSON() {
        System.out.println("Exporting report to JSON");
    }
}