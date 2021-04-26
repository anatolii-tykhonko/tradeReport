package com.anatolii;

import java.time.LocalDate;

public class ProductForReport implements Comparable<ProductForReport> {
    private String name;
    private LocalDate lastDateSold;
    private int allProceeds;

    public ProductForReport(Product product) {
        name = product.getName();
        lastDateSold = product.getDateSold();
        allProceeds = product.getProceeds();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLastDateSold() {
        return lastDateSold;
    }

    public void setLastDateSold(LocalDate dateSold) {
        if(dateSold.compareTo(lastDateSold) > 0){
            lastDateSold = dateSold;
        }
    }

    public int getAllProceeds() {
        return allProceeds;
    }

    public void setAllProceeds(int value) {
        allProceeds += value;
    }

    @Override
    public int compareTo(ProductForReport o) {
        if(this.allProceeds == o.getAllProceeds()){
            return 0;
        }
        return this.allProceeds > o.getAllProceeds()  ? 1 : -1;
    }
}
