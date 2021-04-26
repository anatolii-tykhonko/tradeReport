package com.anatolii;

public class Application {
    public static void main(String[] args) {
        ReportCreator test = new ReportCreator("src/main/resources/input.txt");

        Formatter result = new Formatter(test.createReport());
        System.out.println(result.printReport());
    }
}
