 package converter;

import org.json.JSONObject;
import org.json.XML;

public class XmlToJson {

    public static String convertFromString(String xml, boolean removeRoot) throws Exception {

        if (xml == null || xml.trim().isEmpty()) {
            throw new Exception("Le XML est vide");
        }
        
        JSONObject json = XML.toJSONObject(xml);

        if (removeRoot && json.has("root")) {
            json = json.getJSONObject("root");
        }

        return json.toString(4);  // pour ajouter les espaces pour l'optimisation de Json file 
    }
}
 
    

