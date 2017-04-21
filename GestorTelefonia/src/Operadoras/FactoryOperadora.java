/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operadoras;

/**
 *
 * @author fernando.reis
 */
public class FactoryOperadora {

    public Operadora getOperadora(String operadora) {

        switch (operadora) {
            case "Oi":
                return new Oi(operadora);
            case "Claro":
                return new Claro(operadora);
            case "Vivo":
                return new Vivo(operadora);
            case "Tim":
                return new Tim(operadora);
        }

        return null;
    }
}
