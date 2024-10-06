package org.micalculadora;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable{

    private final Calculadora calculadora = new Calculadora();

    @FXML
    private TextField pantalla;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Enlazar la pantalla de la calculadora con el TextField
        pantalla.textProperty().bind(calculadora.pantallaProperty());
    }

    @FXML
    private void manejarBoton(ActionEvent event) {
        Button boton = (Button) event.getSource();
        String textoBoton = boton.getText();

        switch (textoBoton) {
            case "CE":
                calculadora.borrarTodo();
                break;
            case "C":
                calculadora.borrar();
                break;
            case "+":
                calculadora.operar(Calculadora.SUMAR);
                break;
            case "-":
                calculadora.operar(Calculadora.RESTAR);
                break;
            case "*":
                calculadora.operar(Calculadora.MULTIPLICAR);
                break;
            case "/":
                calculadora.operar(Calculadora.DIVIDIR);
                break;
            case "=":
                calculadora.operar(Calculadora.IGUAL);
                break;
            case ".":
                calculadora.insertarComa();
                break;
            default:
                if (Character.isDigit(textoBoton.charAt(0))) {
                    calculadora.insertar(textoBoton.charAt(0));
                }
                break;
        }
    }
}
