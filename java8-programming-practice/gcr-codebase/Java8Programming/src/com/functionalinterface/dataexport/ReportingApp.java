package com.functionalinterface.dataexport;
public class ReportingApp {
    public static void main(String[] args) {
        Exporter basic = new ReportExporter();
        Exporter advanced = new AdvancedReportExporter();
        basic.exportToJSON();     // default method
        advanced.exportToJSON();  // overridden method
    }
}