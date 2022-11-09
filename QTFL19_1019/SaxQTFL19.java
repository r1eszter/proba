//plusz feladat old meg, hogy az adatok egym�s mell� (egy sorba ker�ljenek)!

package SaxQTFL191019;

inport java.io.File;
import java.io.IOException;

import java.xml.parsers.ParserConfigurationException;
import java.xml.parsers.SAXParser;
import java.xml.parser.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxQTFL19 {

	public static void main(String[] args){
		try{
			// Dokumentumolvas� l�trehoz�sa 
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

			// p�ld�nyos�tja a SAX �rtelmez�t 
			SAXParser saxParser = saxParserFactory.newSAXParser();

			// saj�t esem�nykezel� objektum l�trehoz�sa
			SaxHandler handler = new SaxHandler();

			// dokumentum �rtelmez�si folyamat�nak elindit�sa
			// a parse met�dus els� param�tere a beolvasand� XML f�jl neve
			//AZ .xml F�JLNAK A GY�K�RBEN KELL LENNIE!!
			saxParser.parse(new File("RE_kurzusfelvetel.xml"), handler);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}

//tartalomkezel� keret l�trehoz�sa + esem�ny- �s hibakezel� met�dus
class SaxHandler extends DefaultHandler {
	private int indent = 0;

	private String formatAttributes(Attributes attributes) {
		int attrLength = attributes.getLength();
		if(attrLength == 0) {
			return "";
		}
	StringBuilder sb = new StringBuilder(", {");
	for (int i = 0; i < attrLength; i++) {
		sb.append(attributes.getLocalName(i) + "=" + attributes.getValue(i));
		if(i < attrLength - 1) {
			sb.append(", ");
		}
	}
	sb.append("}");
	return sb.toString();
}

private void indent() {
	for (int i = 0; i < indent; i++) {
		System.out.print(" ");
	}
}


// esem�ny kezel� met�dusok l�trehoz�sa, startElement met�dus

//elem kezdete �s v�ge
@Override
public void startElement(String uri, String localName, String qName, Attributes attributes) {
	indent++; //beh�z mindent
	indent(); //start h�zza be
	System.out.println(qName + formatAttributes(attributes) + " start");
}

//endElement met�dust �jraimplement�ljuk
@Override
public void endElement(String uri, String localName, String qName) {
	indent(); //end h�zza be
	indent --; //beh�z�s cs�kkent�se
	System.out.println(qName + " end");
}

//sz�vegelem feldolgoz�sa, characters met�dust �jraimplement�ljuk
@Override
public void characters(char ch[], int start, int length) {
	String chars = new String(ch, start, length).trim();
	if(!chars.isEmpty()) {
		indent++; //beh�z mindent
		indent(); //karakter beh�z�s
		indent--; //beh�z�s cs�kkent�se
		System.out.println(chars);
		}
	}
}