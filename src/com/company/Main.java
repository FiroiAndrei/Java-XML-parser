package com.company;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {


        public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            OrdersHandler ordersHandler = new OrdersHandler();
            String dir = System.getProperty("user.dir");


            try
            {
                File f = new File(dir + "/src/com/company/Orders XML files");
                for (String path : f.list())
                {

                    if (path.matches("orders[0-9][0-9].xml"))
                    {

                    saxParser.parse(dir + "/src/com/company/Orders XML files/" + path, ordersHandler);

                    ordersHandler.getOrders().sortListByDate();

                    WriteXML write = new WriteXML();


                        ordersHandler.getOrders().putSupplierProducts();

                        HashMap<String, List<Product>> orders = ordersHandler.getOrders().getSupplierProducts();

                        for (String supplier : ordersHandler.getOrders().getSupplierProducts().keySet())
                        {

                            write.writeXML(ordersHandler.getOrders(), dir + "/src/com/company/Supplier XML files/" + path.replaceFirst("orders", supplier) , supplier);
                        }

                    }
                }

            } catch (Exception e)
            {
                e.printStackTrace();
            }

//            for (int i = 0; i < ordersHandler.getOrders().getOrderList().size(); i++)
//            {
//                for (int j = 0; j <ordersHandler.getOrders().getOrderList().get(i).getProducts().size(); j++)
//                System.out.println(ordersHandler.getOrders().getOrderList().get(i).getProducts().get(j).getSupplier());
//
//            }
        }
    }

