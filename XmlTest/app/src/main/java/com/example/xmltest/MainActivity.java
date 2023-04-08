package com.example.xmltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.txtResult);
        try {
            InputStream is = getAssets().open("file.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            // Query by tag name
            StringBuilder str = new StringBuilder();
            NodeList empNodesList = doc.getElementsByTagName("contacts");

            for (int i = 0; i < empNodesList.getLength(); i++) {

                Element empItem = (Element) empNodesList.item(i);
                NodeList empItemChildNodes = empItem.getChildNodes();

                for (int j = 0; j < empItemChildNodes.getLength(); j++) {
                    Node childNode = empItemChildNodes.item(j);

                    if (childNode.getNodeType() == Node.ELEMENT_NODE && "name".equals(childNode.getNodeName())) {
                        str.append(childNode.getFirstChild().getNodeValue() + "\n");

                    }
                    if (childNode.getNodeType() == Node.ELEMENT_NODE && "phone".equals(childNode.getNodeName())) {
                        str.append(childNode.getFirstChild().getNodeValue() + "\n");

                    }
                    if (childNode.getNodeType() == Node.ELEMENT_NODE && "email".equals(childNode.getNodeName())) {
                        str.append(childNode.getFirstChild().getNodeValue() + "\n");

                    }


                }//end of for loop
                str.append("-----------------------\n");
            }
            tv1.setText(str.toString());
        } catch (Exception e) {e.printStackTrace();}
    }

}