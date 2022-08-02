package com.company;


import java.io.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class WriteXML {



    public static void writeXML(Orders orders , String dir, String key)
    {



    try {


        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = output.createXMLStreamWriter(
                new FileOutputStream(dir));



            writer.writeStartDocument();
            writer.writeStartElement("products");




            for (Product p : orders.getSupplierProducts().get(key))
            {
                writer.writeStartElement("product");


                    writer.writeStartElement("description");

                    writer.writeCharacters(p.getDescription().toString());
                    writer.writeEndElement();

                    writer.writeStartElement("gtin");
                    writer.writeCharacters(p.getGtin());
                    writer.writeEndElement();

                    writer.writeStartElement("price");
                    writer.writeAttribute("currency", p.getCurrency());
                    writer.writeCharacters(p.getPrice().toString());
                    writer.writeEndElement();

                    writer.writeStartElement("orderid");
                    writer.writeCharacters(p.getOrderId().toString());
                    writer.writeEndElement();


        }
        writer.writeEndElement();
        writer.writeEndDocument();

        writer.flush();
        writer.close();

    } catch (XMLStreamException e) {
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


    }




}


