/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tipos;

/**
 *
 * @author fernando.reis
 */
public class TelCorp {
    private String imeiChip;
    private String linha;
    private Usuario usuario;

    public TelCorp() {
    }

    public TelCorp(String imeiChip, String linha, Usuario usuario) {
        this.imeiChip = imeiChip;
        this.linha = linha;
        this.usuario = usuario;
    }

    public String getImeiChip() {
        return imeiChip;
    }

    public void setImeiChip(String imeiChip) {
        this.imeiChip = imeiChip;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void setTelCorp(TelCorp tel){
        this.imeiChip = tel.getImeiChip();
        this.linha = tel.getLinha();
        this.usuario = tel.getUsuario();
    }
}
