package com.anatolii;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class Formatter {
    private List<ProductForReport> allProducts;

    public Formatter(List<ProductForReport> allProducts) {
        this.allProducts = allProducts;
    }

    public String printReport(){
        ProductForReport result = Collections.max(allProducts);
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return String.format("%s %s %s", result.getName(), result.getLastDateSold().format(DATE_FORMATTER), result.getAllProceeds());
    }
}
