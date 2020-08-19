package com.selenium.Mysel.java_selenium;

public class product {
    private int Rowno;
    private String Prodname;
    private String Colour;
    private String Size;
    private String Sku;
    private String Qty;
    private String Price;

    public product(int rowno, String prodname, String colour, String size, String sku, String qty, String price) {
        Rowno = rowno;
        Prodname = prodname;
        Colour = colour;
        Size = size;
        Sku = sku;
        Qty = qty;
        Price = price;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getRowno() {
        return Rowno;
    }

    public void setRowno(int rowno) {
        Rowno = rowno;
    }

    public String getProdname() {
        return Prodname;
    }

    public void setProdname(String prodname) {
        Prodname = prodname;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getSku() {
        return Sku;
    }

    public void setSku(String sku) {
        Sku = sku;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }
}
