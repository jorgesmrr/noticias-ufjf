package br.ufjf.dcc.pesquisa.util;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

public class WebHelper {

    public static FeedHandler readFeed(String url) throws IOException, SAXException, ParserConfigurationException {
        InputStream inputXml = null;
        try {
            inputXml = new URL(url).openConnection().getInputStream();

            Reader reader = new InputStreamReader(inputXml, "UTF-8");

            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            FeedHandler parser = new FeedHandler();
            SAXParserFactory.newInstance().newSAXParser().parse(is, parser);
            return parser;
        } finally {
            try {
                if (inputXml != null)
                    inputXml.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
