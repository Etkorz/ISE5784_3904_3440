package renderer;

import geometries.Geometries;
import geometries.Sphere;
import geometries.Triangle;
import lighting.AmbientLight;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import primitives.Color;
import primitives.Double3;
import primitives.Point;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlParser {
    String filePath;
    Element root;

    public XmlParser(String name) {
        this.filePath = name;
        this.root = getRoot();
    }

    public Color getBackgroundColor() {
        return xmlToColor("background-color", root);
    }

    public AmbientLight getAmbient() {
        Node ambientLightNode = root.getElementsByTagName("ambient-light").item(0);
        return new AmbientLight(
                xmlToColor("color", ambientLightNode),
                Double3.ONE
        );
    }

    public Geometries getGeometries() {
        Geometries geometries = new Geometries();
        Node geometriesNode = root.getElementsByTagName("geometries").item(0);
        parseGeometries(geometries, geometriesNode);
        return geometries;
    }

    Element getRoot() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
//            final String FOLDER_PATH = System.getProperty("user.dir");
//            File file = new File(FOLDER_PATH + '\\' + fileName + ".xml");
            File file = new File(filePath);
            try {
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();
                return document.getDocumentElement();
            } catch (IOException | SAXException e) {
                throw new IllegalStateException("I/O error - may be missing directory " + filePath, e);
            }
        } catch (ParserConfigurationException e) {
            System.out.println("Parser configuration error");
        }
        return null;
    }

    Double3 xmlAtDouble3(String name, Element element) {
        String attributeValue = element.getAttribute(name);
        String[] values = attributeValue.split(" ");
        return new Double3(
                Double.parseDouble(values[0]),
                Double.parseDouble(values[1]),
                Double.parseDouble(values[2])
        );
    }

    Color xmlToColor(String name, Node node) {
        String attributeValue = node.getAttributes().getNamedItem(name).getTextContent();
        String[] values = attributeValue.split(" ");
        return new Color(
                Double.parseDouble(values[0]),
                Double.parseDouble(values[1]),
                Double.parseDouble(values[2])
        );
    }

    private void parseGeometries(Geometries geometries, Node geometriesNode) {
        for (int i = 0; i < geometriesNode.getChildNodes().getLength(); i++) {
            Node geometryNode = geometriesNode.getChildNodes().item(i);
            switch (geometryNode.getNodeName()) {
                case "triangle":
                    geometries.add(new Triangle(
                            new Point(xmlAtDouble3("p0", (Element) geometryNode)),
                            new Point(xmlAtDouble3("p1", (Element) geometryNode)),
                            new Point(xmlAtDouble3("p2", (Element) geometryNode))
                    ));
                    break;
                case "sphere":
                    geometries.add(new Sphere(
                            new Point(xmlAtDouble3("center", (Element) geometryNode)),
                            Double.parseDouble(geometryNode.getAttributes().getNamedItem("radius").getTextContent())
                    ));
                    break;
                case "geometries":
                    Geometries nestedGeometries = new Geometries();
                    parseGeometries(nestedGeometries, geometryNode);
                    geometries.add(nestedGeometries);
                    break;
            }
        }
    }
}




