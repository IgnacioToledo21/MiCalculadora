package org.micalculadora;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

/**
 * Implementación de la lógica de una calculadora.
 * Adaptada para utilizar JavaFX Properties.
 */
public class Calculadora {

    public static final char IGUAL = '=';
    public static final char SUMAR = '+';
    public static final char RESTAR = '-';
    public static final char DIVIDIR = '/';
    public static final char MULTIPLICAR = '*';
    public static final char COMA = '.';

    private DoubleProperty operando;
    private StringProperty pantalla;
    private BooleanProperty nuevoOperando;
    private char operador;

    public Calculadora() {
        operando = new SimpleDoubleProperty(0.0);
        pantalla = new SimpleStringProperty("0.0");
        nuevoOperando = new SimpleBooleanProperty(true);
        operador = IGUAL;
    }

    // Properties for binding
    public DoubleProperty operandoProperty() {
        return operando;
    }

    public StringProperty pantallaProperty() {
        return pantalla;
    }

    public BooleanProperty nuevoOperandoProperty() {
        return nuevoOperando;
    }

    /**
     * Devuelve el contenido de la pantalla de la calculadora.
     * @return StringProperty con el contenido de la pantalla de la calculadora.
     */
    public StringProperty getPantallaProperty() {
        return pantalla;
    }

    /**
     * Inicializa por completo la calculadora, borrando la información que tiene memorizada y la pantalla.
     */
    public void borrar() {
        operando.set(0.0);
        operador = IGUAL;
        borrarTodo();
    }

    /**
     * Borra lo que hay en la pantalla (el último operando introducido).
     */
    public void borrarTodo() {
        nuevoOperando.set(true);
        pantalla.set("0.0");
    }

    /**
     * Indica a la calculadora que realice la operación indicada.
     * @param operador Operación a realizar; usar una constante: IGUAL, SUMAR, RESTAR, MULTIPLCIAR, DIVIDIR.
     */
    public void operar(char operador) {
        nuevoOperando.set(true);
        double operando2 = Double.parseDouble(pantalla.get());
        switch (this.operador) {
            case SUMAR: operando.set(operando.get() + operando2); break;
            case RESTAR: operando.set(operando.get() - operando2); break;
            case MULTIPLICAR: operando.set(operando.get() * operando2); break;
            case DIVIDIR:
                if (operando2 != 0) {
                    operando.set(operando.get() / operando2);
                } else {
                    pantalla.set("Error");
                    return;
                }
                break;
            case IGUAL: operando.set(operando2); break;
        }
        this.operador = operador;
        pantalla.set(String.valueOf(operando.get()));
    }

    /**
     * Inserta una coma en el operando actual (pantalla).
     */
    public void insertarComa() {
        if (!pantalla.get().contains("" + COMA)) {
            pantalla.set(pantalla.get() + COMA);
        }
    }

    /**
     * Inserta un dígito en el operando actual (pantalla).
     * @param digito Dígito a introducir en la pantalla.
     */
    public void insertar(char digito) {
        if (digito >= '0' && digito <= '9') {
            if (nuevoOperando.get()) {
                nuevoOperando.set(false);
                pantalla.set("");
            }
            pantalla.set(pantalla.get() + digito);
        } else if (digito == COMA) {
            insertarComa();
        }
    }
}
