package x.y.z;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.wordperfect.WordPerfectParser;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class WPDParser {

    public static void main(String[] args) throws IOException, SAXException, TikaException {
        WordPerfectParser p = new WordPerfectParser();
        p.parse(new FileInputStream("file.wpd"), new ContentHandler() {
            
            @Override
            public void startPrefixMapping(String prefix, String uri) throws SAXException {
                System.out.println(prefix);
                
            }
            
            @Override
            public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
                System.out.println(uri);
                
            }
            
            @Override
            public void startDocument() throws SAXException {
                System.out.println("start");
                
            }
            
            @Override
            public void skippedEntity(String name) throws SAXException {
                System.out.println(name);
                
            }
            
            @Override
            public void setDocumentLocator(Locator locator) {
                System.out.println(locator);
                
            }
            
            @Override
            public void processingInstruction(String target, String data) throws SAXException {
                System.out.println(target);
                
            }
            
            @Override
            public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
                System.out.println(start);
                
            }
            
            @Override
            public void endPrefixMapping(String prefix) throws SAXException {
                System.out.println(prefix);
                
            }
            
            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println(uri);
                
            }
            
            @Override
            public void endDocument() throws SAXException {
                System.out.println("end");
                
            }
            
            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println(start);
                
            }
        }, new Metadata(), new ParseContext());
    }

}
