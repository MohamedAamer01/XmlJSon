package app;

import converter.XmlToJson;
import converter.JsonToXml;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        TextArea input = new TextArea();
        TextArea output = new TextArea();

        input.setPromptText("Collez ici le XML ou le JSON...");
        output.setPromptText("Résultat...");

        Button xmlToJson = new Button("XML → JSON");
        Button jsonToXml = new Button("JSON → XML");

        Button clearInput = new Button("Effacer Entrée");
        Button clearOutput = new Button("Effacer Résultat");
        Button copyOutput = new Button("Copier Résultat");

        // XML -> JSON
        xmlToJson.setOnAction(e -> {
            try {
                output.setText(XmlToJson.convertFromString(input.getText(), true));
            } catch (Exception ex) {
                output.setText("Erreur : " + ex.getMessage());
            }
        });

        // JSON -> XML
        jsonToXml.setOnAction(e -> {
            output.setText(JsonToXml.convert(input.getText()));
        
        });

        // Effacer les zones
        clearInput.setOnAction(e -> input.clear());
        clearOutput.setOnAction(e -> output.clear());

        // Copier résultat
        copyOutput.setOnAction(e -> {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(output.getText());
            clipboard.setContent(content);
        });

        HBox buttons1 = new HBox(10, xmlToJson, jsonToXml);
        HBox buttons2 = new HBox(10, clearInput, clearOutput, copyOutput);

        VBox root = new VBox(10, input, buttons1, buttons2, output);

        stage.setScene(new Scene(root, 700, 550));
        stage.setTitle("XML ↔ JSON Converter");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
