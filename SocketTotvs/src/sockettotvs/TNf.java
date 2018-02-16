/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettotvs;

/**
 *
 * @author fernando.reis
 */
public class TNf {
    private String cod_emit;
    private String nro_docto;
    private String serie_docto;
    private String nat_operacao;
    
    public TNf() {}

    public TNf(String cod_emit, String nro_docto, String serie_docto, String nat_operacao) {
        this.cod_emit = cod_emit;
        this.nro_docto = nro_docto;
        this.serie_docto = serie_docto;
        this.nat_operacao = nat_operacao;
    }

    public String getCod_emit() {
        return cod_emit;
    }

    public void setCod_emit(String cod_emit) {
        this.cod_emit = cod_emit;
    }

    public String getNro_docto() {
        return nro_docto;
    }

    public void setNro_docto(String nro_docto) {
        this.nro_docto = nro_docto;
    }

    public String getSerie_docto() {
        return serie_docto;
    }

    public void setSerie_docto(String serie_docto) {
        this.serie_docto = serie_docto;
    }

    public String getNat_operacao() {
        return nat_operacao;
    }

    public void setNat_operacao(String nat_operacao) {
        this.nat_operacao = nat_operacao;
    }
    
    @Override
    public String toString() {
        return cod_emit + "|" + nro_docto +  "|" + serie_docto + "|" + nat_operacao;
    }   
}
