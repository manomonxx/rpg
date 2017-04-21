/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leitores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author fernando.reis
 */
public class Vivo {

    private final Map<Long, ArrayList<Titem>> itens;

    public Vivo() {
        this.itens = new HashMap<>();
    }

    public ArrayList<Titem> getItem(Long celular) {
        return this.itens.get(celular);
    }

    public void setItens(Long celular, Titem param) {
        ArrayList<Titem> aux = new ArrayList<>();

        if (itens.containsKey(celular)) {
            aux = itens.get(celular);
            aux.add(param);
        } else {
            aux.add(param);
        }

        this.itens.put(celular, aux);
    }

    public void printItens() {
        for (Long key : itens.keySet()) { //Capturamos o valor a partir da chave 
            ArrayList<Titem> value = itens.get(key);
            System.out.println("\n" + key + ":");

            for (Titem titem : value) {
                System.out.println("Descrição: " + titem.getDesc_servico() + "\t Valor: " + titem.getValor());
            }
        }
    }

    public Double total() {
        Double vl_total = 0.0;
        for (Long key : itens.keySet()) { //Capturamos o valor a partir da chave 
            ArrayList<Titem> value = itens.get(key);
            for (Titem titem : value) {
                vl_total += titem.getValor();
            }
        }

        return vl_total;
    }

    public Double totalPorCelular(Long celular) {
        Double vl_total = 0.0;
        for (Long key : itens.keySet()) { //Capturamos o valor a partir da chave 

            if (!Objects.equals(key, celular)) {
                continue;
            } else {
                ArrayList<Titem> value = itens.get(key);
                for (Titem titem : value) {
                    vl_total += titem.getValor();
                }
            }
        }

        return vl_total;
    }

    //retorna a MAP com todos os itens
    public Map<Long, ArrayList<Titem>> getItens() {
        return itens;
    }
}
