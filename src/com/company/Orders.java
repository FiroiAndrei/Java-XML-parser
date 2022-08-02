package com.company;

import java.util.*;

public class Orders {
    private List<Order> orderList;

    private HashMap<String, List<Product>> supplierProducts;

    public HashMap<String, List<Product>> getSupplierProducts() {
        return supplierProducts;
    }

    public void setSupplierProducts(HashMap<String, List<Product>> supplierProducts) {
        this.supplierProducts = supplierProducts;
    }

    public void putSupplierProducts ()
    {
        supplierProducts = new HashMap<String, List<Product>>();
        for (Order order : this.orderList)
        {
            for (Product p : order.getProducts())
            {
                p.setOrderId(order.getOrderId());
                supplierProducts.putIfAbsent(p.getSupplier(), new ArrayList<Product>());
                supplierProducts.get(p.getSupplier()).add(p);

            }
        }
    }


    public void sortListByDate()
    {
        Collections.sort(orderList, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.getOrderCreated().compareTo(o1.getOrderCreated());
            }
        });


    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
