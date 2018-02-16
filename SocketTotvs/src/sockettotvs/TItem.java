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
public class TItem {
    private String cod_item;
    private String descricao;
    private String unid_medida;
    private String val_unit;
    private String quantidade;
    private String num_ordem;

    public TItem() {}
    
    public TItem(String cod_item, String descricao, String unid_medida, String val_unit, String quantidade, String num_ordem) {
        this.cod_item = cod_item;
        this.descricao = descricao;
        this.unid_medida = unid_medida;
        this.val_unit = val_unit;
        this.quantidade = quantidade;
        this.num_ordem = num_ordem;
    }

    public String getNum_ordem() {
        return num_ordem;
    }

    public void setNum_ordem(String num_ordem) {
        this.num_ordem = num_ordem;
    }
    
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getCod_item() {
        return cod_item;
    }

    public void setCod_item(String cod_item) {
        this.cod_item = cod_item;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnid_medida() {
        return unid_medida;
    }

    public void setUnid_medida(String unid_medida) {
        this.unid_medida = unid_medida;
    }

    public String getVal_unit() {
        return val_unit;
    }

    public void setVal_unit(String val_unit) {
        this.val_unit = val_unit;
    }

    @Override
    public String toString() {
//        return cod_item + "|" + descricao + "|" + unid_medida + "|" + val_unit + "|" + quantidade + "|" + num_ordem;
        return num_ordem + "|" + cod_item +  "|" + descricao + "|" + quantidade + "|" + val_unit + "|" + unid_medida;
    }   
}
