package com.anatolii;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private String name;
    private LocalDate dateSold;
    private int proceeds;

    public Product(String name, LocalDate dateSold, int proceeds) {
        this.name = name;
        this.dateSold = dateSold;
        this.proceeds = proceeds;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateSold() {
        return dateSold;
    }

    public int getProceeds() {
        return proceeds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
