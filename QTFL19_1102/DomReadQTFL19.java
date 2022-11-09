import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomReadKFR {
	public static void main(String argv[]) throws SAXException,
	IOException, ParserConfigurationException {
	//XML file megnyit�sa
	File xmlFile = new File("users.xml");

	//p�ld�nyos�tjuk a DocumentBuilderFactory oszt�lyt a statikus newInst
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder ***
	}

	//DOM fa el��ll�t�sa
	Document doc = dBuilder.parse(xmlFile);
	//A parse() met�dus elemzi az XML f�jlt a document

	doc.getDocumentElement().normalize();

	***

	System.out.println("Root element: "+ doc.DocumentElement().getNodeName())***

	NodeList nList = doc.getElementsBy***

	for(int i = 0; i < nList.getLength(); i++) {
		Node nNode = nList.item(i);
		System.out.println("\nCurrent Element: " + nNode.getNodeName());

		if(nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");

			Node node1 = elem.getElementsByTagName("filename").item();
			String fname = node1.getTextContent();

			Node node2 = elem.getElementsByTagName("filename").item();
			String fname = node2.getTextContent();

			Node node3 = elem.getElementsByTagName("filename").item();
			String fname = node3.getTextContent();

			System.out.println("User id: " + uid);
			System.out.println("FirstName: " + fname);
			System.out.println("LastName: " + lname);
			System.out.println("Profession: " + pname);
		}
	}

}