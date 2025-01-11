package org.micalculadora;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable{

    private final Calculadora calculadora = new Calculadora();

    @FXML
    private Button button0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonC;

    @FXML
    private Button buttonCE;

    @FXML
    private Button buttonComa;

    @FXML
    private Button buttonDividir;

    @FXML
    private Button buttonIgual;

    @FXML
    private Button buttonMultiplicar;

    @FXML
    private Button buttonRestar;

    @FXML
    private Button buttonSumar;

    @FXML
    private TextField pantalla;

    @FXML
    private BorderPane root;

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
