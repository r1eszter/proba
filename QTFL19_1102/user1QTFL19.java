package domqtfl19;

public class DomWriteKPR {
	public static void main(String[] args) throws ParseConfigurationException,
	TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.newDocument();

		Element root = doc.createElementsNS("DOMqtfl19", "units");
		doc.appendChild(root);

		root.appendChild(createUser(doc, "1", "Eszter", "Rontó", "Telekom" ));

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transf = transformerFactory.newTransformer();

		transf.setOutputProperty(OutpurKEys.ENCODING, "UTF-8");
		transf.setOutputProperty(OutpurKEys.INDENT, "yes");
		transf.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "2");

		DOMSource source = new DOMSource(doc);

		File myFile = new File("users2.xml");

		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(myFile);

		transf.transform(source, console);
		transf.transform(source, file);
	}


	private static Node createUser(Document doc, String id, String firstName, String lastName, String profession) {
		Element user = doc.createElement("user");

		user.setAttribute("id", id);
		user.appendChild(createUserElement(doc, "firstname", firstName));
		user.appendChild(createUserElement(doc, "lastname", lastName));
		user.appendChild(createUserElement(doc, "profession", profession));

		return user;
	}


	private static Node createUserElement(Document doc, String name, String value) {
		Element node = doc.createUserElement(name);
		node.appendChild(doc.createTextNode(value));

		return node;
	}
	
}