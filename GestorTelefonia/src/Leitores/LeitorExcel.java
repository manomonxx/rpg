/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leitores;

import Tipos.TelCorp;
import Tipos.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author fernando.reis
 */
public class LeitorExcel {

    private static final Map<String, TelCorp> mapa_usu = new HashMap<>();

    public LeitorExcel() {
    }

    //"planilhas\\Vivo_Fevereiro.xls"
    public void leitor(String path) throws BiffException, WriteException, Exception {
        try {
            WorkbookSettings ws = new WorkbookSettings();
            ws.setEncoding("Cp1252");
            
            Workbook workbook = Workbook.getWorkbook(new File(path), ws);
            
            Sheet sheet = workbook.getSheet(0);
            int linhas = sheet.getRows();

            System.out.println("Iniciando a leitura da planilha XLS:");

            for (int i = 2; i < linhas; i++) {

                //Obtém os dados da planilha               
                Cell a1 = sheet.getCell(0, i);
                Cell a2 = sheet.getCell(1, i);
                Cell a3 = sheet.getCell(2, i);
                Cell a4 = sheet.getCell(3, i);
                Cell a5 = sheet.getCell(4, i);
                Cell a6 = sheet.getCell(5, i);
                Cell a7 = sheet.getCell(6, i);
                Cell a8 = sheet.getCell(7, i);

                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();
                String as5 = a5.getContents();
                String as6 = a6.getContents();
                String as7 = a7.getContents();
                String as8 = a8.getContents();

                //contrói o item que receberá as informações de cada linha
                Usuario usu = new Usuario();
                usu.setNome(as3);//
                usu.setCargo(as4);
                usu.setSecao(as5);
                usu.setDepto(as6);
                usu.setArea(as7);
                usu.setGrupo(as8);

                TelCorp tTel = new TelCorp();
                tTel.setImeiChip(as1);
                tTel.setLinha(as2);
                tTel.setUsuario(usu);

                //System.out.println(tTel.getUsuario().getSecao());  
                addLinha(tTel);
            }
        
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addLinha(TelCorp tel) {

        TelCorp aux = new TelCorp();

        if (mapa_usu.containsKey(tel.getLinha())) {
            aux = mapa_usu.get(tel.getLinha());
            aux.setTelCorp(tel);
        } else {
            aux.setTelCorp(tel);
        }

        mapa_usu.put(tel.getLinha(), aux);
    }
    
    public void updateLinha(TelCorp tel) {

        TelCorp aux = new TelCorp();

        if (mapa_usu.containsKey(tel.getLinha())) {
            aux = mapa_usu.get(tel.getLinha());
            aux.setTelCorp(tel);            
        } else {
            aux.setTelCorp(tel);
        }

        mapa_usu.put(tel.getLinha(), aux);
    }

    public void printItens() {
        for (String key : mapa_usu.keySet()) { //Capturamos o valor a partir da chave 
            TelCorp value = mapa_usu.get(key);
            System.out.println("\n" + value.getImeiChip() + " - " + value.getLinha() + " - " + value.getUsuario().getNome()
                    + " - " + value.getUsuario().getCargo() + " - " + value.getUsuario().getSecao() + " - " + value.getUsuario().getDepto()
                    + " - " + value.getUsuario().getArea() + " - " + value.getUsuario().getGrupo());
        }
    }

    public void save() throws IOException, WriteException {

        String path = "planilhas\\new_usu.xls";
        WritableWorkbook workbook = Workbook.createWorkbook(new File(path));

        //WritableSheet sheet = workbook.getSheet(0);
        WritableSheet sheet = workbook.createSheet("Geral", 0);

        //tel desc valor
        Label lbImei = new Label(0, 0, "IMEI CHIP");
        sheet.addCell(lbImei);

        Label lbLinha = new Label(1, 0, "LINHA");
        sheet.addCell(lbLinha);

        Label lbNome = new Label(2, 0, "USUÁRIO");
        sheet.addCell(lbNome);

        Label lbCargo = new Label(3, 0, "CARGO");
        sheet.addCell(lbCargo);

        Label lbSecao = new Label(4, 0, "SEÇÃO");
        sheet.addCell(lbSecao);

        Label lbDepto = new Label(5, 0, "DEPTO");
        sheet.addCell(lbDepto);

        Label lbArea = new Label(6, 0, "ÁREA");
        sheet.addCell(lbArea);

        Label lbGrupo = new Label(7, 0, "GRUPO");
        sheet.addCell(lbGrupo);

        int i = 1;

        for (String key : mapa_usu.keySet()) { //Capturamos o valor a partir da chave 
            TelCorp value = mapa_usu.get(key);

            Label imei = new Label(0, i, value.getImeiChip());
            sheet.addCell(imei);

            Label linha = new Label(1, i, value.getLinha());
            sheet.addCell(linha);

            Label nome = new Label(2, i, value.getUsuario().getNome());
            sheet.addCell(nome);

            Label cargo = new Label(3, i, value.getUsuario().getCargo());
            sheet.addCell(cargo);

            Label secao = new Label(4, i, value.getUsuario().getSecao());
            sheet.addCell(secao);

            Label depto = new Label(5, i, value.getUsuario().getDepto());
            sheet.addCell(depto);

            Label area = new Label(6, i, value.getUsuario().getArea());
            sheet.addCell(area);

            Label grupo = new Label(7, i++, value.getUsuario().getGrupo());
            sheet.addCell(grupo);
        }

        workbook.write();

        workbook.close();

        System.out.println("Arquivo salvo com Sucesso!!!");
    }

    public static String toUTF8(String text) throws Exception {
        byte p[] = text.getBytes("ISO-8859-1");
        return new String(p, 0, p.length, "UTF-8");
    }
}
