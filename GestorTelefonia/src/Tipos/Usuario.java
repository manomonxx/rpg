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
public class Usuario {

    private String nome;
    private String email;
    private String cargo; // Gerente de área, Gerente de departamento etc...
    private String secao; // ex.: GIPE, GIBB etc ...
    private String depto; // GFI, GFA, GGG etc...
    private String area; // ex.: GO , GF, GG etc...
    private String grupo; // ex.: DO, GA, GD, GT etc..

    public Usuario() {
    }

    public Usuario(String nome, String email, String cargo, String secao, String depto, String area, String grupo) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.secao = secao;
        this.depto = depto;
        this.area = area;
        this.grupo = grupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
