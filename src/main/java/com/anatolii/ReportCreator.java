package com.anatolii;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreator {
    private final String pathToData;
    private final FileReader readDateFromFile;

    public ReportCreator(String pathToData) {
        this.pathToData = pathToData;
        readDateFromFile = new FileReader();
    }
    public List <ProductForReport> createReport(){
        List<Product> allSales = readDateFromFile.readFileToList(pathToData).stream().
                map(this::parseProduct).collect(Collectors.toList());
        Map<String, ProductForReport> productMap = new HashMap<>();
        allSales.forEach(p -> productMap.merge(p.getName(), parseProductForReport(p), this::updateProductForReport));
        return new ArrayList<>(productMap.values());
    }

    private Product parseProduct(String productInfo) {
        String[] splitProductInfo = productInfo.split("#");
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return new Product(splitProductInfo[0],
                LocalDate.parse(splitProductInfo[1], DATE_FORMATTER),
                Integer.parseInt(splitProductInfo[2]));
    }

    private ProductForReport parseProductForReport(Product product){
        return new ProductForReport(product);
    }

    private ProductForReport updateProductForReport(ProductForReport oldValue, ProductForReport newValue){
        oldValue.setLastDateSold(newValue.getLastDateSold());
        oldValue.setAllProceeds(newValue.getAllProceeds());
        return oldValue;
    }
}
