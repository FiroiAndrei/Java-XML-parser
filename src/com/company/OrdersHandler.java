package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdersHandler extends DefaultHandler {
    private static final String ORDERS = "orders";
    private static final String ORDER = "order";
    private static final String PRODUCT = "product";
    private static final String DESCRIPTION = "description";
    private static final String GTIN = "gtin";
    private static final String PRICE = "price";
    private static final String SUPPLIER = "supplier";


    private Orders orders;
    private StringBuilder elementValue;
    private String currency = "USD";

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        orders = new Orders();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case ORDERS:
                orders.setOrderList(new ArrayList<Order>());
                break;
            case ORDER:
                orders.getOrderList().add(new Order(attr.getValue(0), attr.getValue(1)));
                break;
            case PRODUCT:
                latestOrder().getProducts().add(new Product());
                break;
            case DESCRIPTION:
                elementValue = new StringBuilder();
            case GTIN:
                elementValue = new StringBuilder();
            case PRICE:
                currency = attr.getValue(0);
                elementValue = new StringBuilder();
            case SUPPLIER:
                elementValue = new StringBuilder();
                break;


        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case DESCRIPTION:
                latestProduct().setDescription(elementValue.toString());
                break;
            case GTIN:
                latestProduct().setGtin(elementValue.toString());
                break;
            case PRICE:
                latestProduct().setCurrency(currency);
                latestProduct().setPrice(Float.parseFloat(elementValue.toString()));
                break;
            case SUPPLIER:
                latestProduct().setSupplier(elementValue.toString());
                break;

        }
    }

    private Order latestOrder() {
        List<Order> orderList = orders.getOrderList();
        int latestOrderIndex = orders.getOrderList().size() - 1;
        return orders.getOrderList().get(latestOrderIndex);
    }

    private Product latestProduct() {
       return latestOrder().getProducts().get(latestOrder().getProducts().size()-1);
    }

    public Orders getOrders() {
        return orders;
    }
}