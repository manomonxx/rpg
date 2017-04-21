/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortelefonia;

import Leitores.LeitorExcel;
import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import jxl.read.biff.BiffException;

import Leitores.Vivo;
import Leitores.Titem;
import Tipos.TelCorp;
import Tipos.Usuario;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;
import sun.misc.VM;

/**
 *
 * @author fernando.reis
 */
public class GestorTelefonia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BiffException, WriteException, Exception {
        // TODO code application logic here

//        TpServico Oi = new TpServico("TELEMAR NORTE LESTE S/A", "33.000.118/0009-26", " 15.068.543-2", 17432, 1302);
//        TpServico Embratel = new TpServico("TELEMAR NORTE LESTE S/A", "33.000.118/0009-26", " 15.068.543-2", 17432, 1302);
//        TpServico Claro = new TpServico("TELEMAR NORTE LESTE S/A", "33.000.118/0009-26", " 15.068.543-2", 17432, 1302);
//        TpServico Vivo = new TpServico("TELEMAR NORTE LESTE S/A", "33.000.118/0009-26", " 15.068.543-2", 17432, 1302);
//        TpServico Tim = new TpServico("TELEMAR NORTE LESTE S/A", "33.000.118/0009-26", " 15.068.543-2", 17432, 1302);
//        
//        FactoryOperadora factory = new FactoryOperadora();
//        
//        factory.getOperadora("Oi");
//        try {
//
//            Workbook workbook = Workbook.getWorkbook(new File("planilhas\\Vivo_Fevereiro.xls"));
//
//            Sheet sheet = workbook.getSheet(0);
//            int linhas = sheet.getRows();
//
//            System.out.println("Iniciando a leitura da planilha XLS:");
//
//            Vivo contavivo = new Vivo();
//            ArrayList<Titem> itens = new ArrayList<>();
//
//            for (int i = 3; i < linhas; i++) {
//
//                //Obtém os dados da planilha               
//                Cell a1 = sheet.getCell(2, i);
//                Cell a2 = sheet.getCell(4, i);
//                Cell a3 = sheet.getCell(19, i);
//
//                String as1 = a1.getContents();
//                String as2 = a2.getContents();
//                String as3 = a3.getContents();
//
//                //contrói o item que receberá as informações de cada linha
//                Titem item = new Titem();
//                item.setDesc_servico(as2);
//
//                String auxValor = as3.substring(5, as3.length()).trim();
//                System.out.println();
//
//                //formata para double o valor de cada serviço
//                try {
//                    NumberFormat nf = NumberFormat.getInstance();
//                    double val = nf.parse(auxValor).doubleValue();
//                    item.setValor(val);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//
//                //adiciona o item à lista de itens
//                itens.add(item);
//                //System.out.println(Long.parseLong(as1));
//                contavivo.setItens(Long.parseLong(as1), item);
//            }
//
//            save(contavivo.getItens());
//            //Imprime os itens
//            //contavivo.printItens();
//
//            System.out.println(contavivo.total());
//            Long auxLong = Long.parseUnsignedLong("2034463514");
//            System.out.println(contavivo.totalPorCelular(auxLong));
//            
//            workbook.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        LeitorExcel leitor = new LeitorExcel();
        //leitor.leitor("planilhas\\usu_corp.xls");
        
        TelCorp newPerson = new TelCorp();
        newPerson.setImeiChip("0000 0000 0000 0000");
        newPerson.setLinha("99999999999");
        
        Usuario usuario = new Usuario("Teste2", "teste@gmail.com", "Teste", "GGGG", "GGG", "GG", "EST");
        
        newPerson.setUsuario(usuario);
        
        leitor.updateLinha(newPerson);
        
        leitor.printItens();
        leitor.save();
    }

    public static void save(Map<Long, ArrayList<Titem>> itens) throws IOException, WriteException {

        String path = "planilhas\\Vivo_resultado.xls";
        WritableWorkbook workbook = Workbook.createWorkbook(new File(path));

        //WritableSheet sheet = workbook.getSheet(0);
        WritableSheet sheet = workbook.createSheet("Geral", 0);

        //tel desc valor
        Label lbCelular = new Label(0, 0, "Celular");
        sheet.addCell(lbCelular);

        Label lbDesc = new Label(1, 0, "Descrição");
        sheet.addCell(lbDesc);

        Label lbValor = new Label(2, 0, "Valor");
        sheet.addCell(lbValor);
        int i = 1;
        
        for (Long key : itens.keySet()) { //Capturamos o valor a partir da chave 
            ArrayList<Titem> value = itens.get(key);

            for (Titem titem : value) {
                Label celular = new Label(0, i, key + "");
                sheet.addCell(celular);

                Label desc = new Label(1, i, titem.getDesc_servico());
                sheet.addCell(desc);

                Label valor = new Label(2, i++, titem.getValor() + "");
                sheet.addCell(valor);
            }
        }

        workbook.write();

        workbook.close();

        System.out.println("Arquivo salvo com Sucesso!!!");
    }

}
