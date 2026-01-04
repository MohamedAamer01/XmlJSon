// without API
package converter;
public class JsonToXml {
    public static String convert(String json) {
        try {
            // Nettoyer et parser manuellement (version simplifiée)
            json = json.trim();
            
            // Supprimer les accolades extérieures
            if (json.startsWith("{") && json.endsWith("}")) {
                json = json.substring(1, json.length() - 1).trim();
            }
            
            StringBuilder xml = new StringBuilder();
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xml.append("<root>\n");
            
            // Séparer les paires clé-valeur
            String[] pairs = json.split(",");
            for (String pair : pairs) {
                pair = pair.trim();
                if (!pair.isEmpty()) {
                    // Trouver le premier ':' pour séparer clé et valeur
                    int colonIndex = pair.indexOf(':');
                    if (colonIndex > 0) {
                        String key = pair.substring(0, colonIndex).trim();
                        String value = pair.substring(colonIndex + 1).trim();
                        
                        // Nettoyer les guillemets
                        key = key.replaceAll("^\"|\"$", "");
                        value = value.replaceAll("^\"|\"$", "");
                        
                        xml.append("  <").append(key).append(">")
                           .append(value)
                           .append("</").append(key).append(">\n");
                    }
                }
            }
            
            xml.append("</root>");
            return xml.toString();
        } catch (Exception e) {
            return "Erreur lors de la conversion : " + e.getMessage();
        }
    }
}