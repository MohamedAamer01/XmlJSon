 package converter;

import org.json.JSONObject;
import org.json.XML;

public class XmlToJson {

    /**
     * Convertit un XML (texte) en JSON
     * @param xml contenu XML saisi par l'utilisateur
     * @param removeRoot supprimer la racine <root> si true
     * @return JSON formaté
     */
    public static String convertFromString(String xml, boolean removeRoot) throws Exception {

        if (xml == null || xml.trim().isEmpty()) {
            throw new Exception("Le XML est vide");
        }

        JSONObject json = XML.toJSONObject(xml);

        if (removeRoot && json.has("root")) {
            json = json.getJSONObject("root");
        }

        return json.toString(4);
    }
}
 
    

