/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettotvs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.reis
 */
public class Database {

    public Database() {
    }

    //verifica se esta ordem de compra existe e está em aberto
    public Integer existeOC(String num_oc, String cod_emit) {
        Connection con;

        try {
            con = DatabaseConnect_mgmov.getConnection();

            ResultSet result;
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"numero-ordem\" FROM PUB.\"ordem-compra\" WHERE \"cod-emitente\" = '" + cod_emit + "' and \"situacao\" <> 4 and \"situacao\" <> 6 and \"numero-ordem\" = '" + num_oc + "' WITH (NOLOCK) ";
                result = statement.executeQuery(sql);
                while (result.next()) {
                    System.out.println("num_ordem: " + result.getString("numero-ordem"));
                    result.close();
                    return 1; //existe
                }
            }

            result.close();
            return 0; //não existe

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return 99; //erro ao conectar com o banco de dados
    }

    //verifica se esta ordem de compra existe e está em aberto
    public String getDadosOC(String num_oc) {
        Connection con;

        try {
            con = DatabaseConnect_mgmov.getConnection();

            ResultSet result;
            ArrayList<String> lista = new ArrayList<String>();
            String resposta = "0";
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"it-codigo\", \"qt-solic\", \"num-pedido\", \"preco-unit\", \"aliquota-ipi\", \"numero-ordem\" FROM PUB.\"ordem-compra\" WHERE \"numero-ordem\" = '" + num_oc + "' WITH (NOLOCK)";
//                String sql = "SELECT \"cod-emitente\" FROM PUB.\"ordem-compra\" WHERE PUB.\"ordem-compra\".\"numero-ordem\" = '1011722' and \"situacao\" = 2";
                
                System.out.println(sql);
                result = statement.executeQuery(sql);
                while (result.next()) {
                    System.out.println("Get Dados OC: OK! - OC: " + result.getString("numero-ordem"));

                    lista.add(result.getString("it-codigo"));
                    lista.add(result.getString("qt-solic"));
                    lista.add(result.getString("num-pedido"));
                    lista.add(result.getString("preco-unit"));
                    lista.add(result.getString("aliquota-ipi"));

                    ArrayList<String> unid = this.getOther(result.getString("it-codigo"));
                    
                    lista.add(unid.get(1));
                    
                    resposta = this.toStr(lista);
                }
            }

            result.close();
            return resposta; //não existe

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return "99"; //erro ao conectar com o banco de dados
    }

    private String toStr(ArrayList<String> lista) {
        
        if(lista.isEmpty()){
            return "0"; //lista vazia
        }
        
        String resposta = "";

        for (String string : lista) {
            resposta += string + "|";
        }

        int tamanho = resposta.length();
        resposta = resposta.substring(0, tamanho - 1);

        return resposta;
    }
    
    public void close_conn() {
        Connection con = DatabaseConnect.getConnection();
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getData(String query) {
        Connection con;
        String name = "Erro";

        try {
            con = DatabaseConnect.getConnection();

            ResultSet result;
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"cod-emitente\", \"nome-emit\", \"cgc\", \"e-mail\" FROM PUB.\"emitente\" WHERE \"cgc\" = '" + query + "' and \"flag-pag\" = 1 WITH (NOLOCK)";
                result = statement.executeQuery(sql);
                while (result.next()) {
                    name = result.getString("nome-emit");
                    System.out.println("nome: " + name);
                }
            }
            result.close();
            return name.equals("Erro") ? 0 : 1;

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return 99;
    }

    public String getCodEmit(String cnpj) {
        Connection con;
        String cod_emit = "2";

        try {
            con = DatabaseConnect.getConnection();

            ResultSet result;
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"cod-emitente\" FROM PUB.\"emitente\" WHERE \"cgc\" = '" + cnpj + "' and \"flag-pag\" = 1 WITH (NOLOCK)";
                result = statement.executeQuery(sql);
                while (result.next()) {
                    cod_emit = result.getString("cod-emitente");
                }
            }
            result.close();
            return cod_emit;

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return "99";
    }

    public ArrayList<String> getOther(String cod_item) {
        Connection con;
        String desc;
        String unid;
        ArrayList<String> itens = new ArrayList<>();
        try {
            con = DatabaseConnect_ems2mult.getConnection();

            ResultSet result;
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"desc-item\", \"un\" "
                        + "FROM PUB.\"ITEM\" WHERE "
                        + "\"it-codigo\" = '" + cod_item + "' WITH (NOLOCK)";
                result = statement.executeQuery(sql);
                while (result.next()) {
                    desc = result.getString("desc-item");
//                    System.out.println("desc-item: " + desc);
                    unid = result.getString("un");
//                    System.out.println("un: " + unid);

                    itens.add(desc);
                    itens.add(unid);
                }
            }
            result.close();
            return itens;

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<TItem> getItens(String num_oc, String cod_emit) {
        Connection con;
        ArrayList<TItem> listaItens = new ArrayList<>();

        try {
            con = DatabaseConnect_mgmov.getConnection();

            ResultSet result;
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"it-codigo\", \"qt-solic\", \"numero-ordem\", \"preco-unit\" "
                        + "FROM PUB.\"ordem-compra\" WHERE "
                        + "\"cod-emitente\" = '" + cod_emit + "' and \"numero-ordem\" = '" + num_oc + "' and \"situacao\" = 2 WITH (NOLOCK)";
                result = statement.executeQuery(sql);

                while (result.next()) {
                    TItem item = new TItem();
                    item.setCod_item(result.getString("it-codigo"));
                    item.setQuantidade(result.getString("qt-solic"));
                    item.setNum_ordem(result.getString("numero-ordem"));
                    item.setVal_unit(result.getString("preco-unit"));

                    ArrayList<String> itens = getOther(item.getCod_item());
                    item.setDescricao(itens.get(0));
                    item.setUnid_medida(itens.get(1));

                    listaItens.add(item);
                }
            }

            result.close();
            return listaItens;

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<String> getNumOC(String cod_emit) {
        Connection con;
        ArrayList<String> numoc = new ArrayList<>();

        try {
            con = DatabaseConnect_mgmov.getConnection();

            ResultSet result;
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"numero-ordem\" FROM PUB.\"ordem-compra\" WHERE \"cod-emitente\" = '" + cod_emit + "' and \"situacao\" = 2 WITH (NOLOCK)";
                result = statement.executeQuery(sql);
                while (result.next()) {
                    numoc.add(result.getString("numero-ordem"));
                    System.out.println("num_ordem: " + result.getString("numero-ordem"));
                }
            }

            result.close();
            return numoc;

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return null;
    }

    public Integer isClosed(String cod_emit, String num_nota, String num_serie) {
        Connection con;
        String item = "";
        try {
            con = DatabaseConnect_mgmov.getConnection();

            ResultSet result;
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"cod-emitente\" FROM PUB.\"docum-est\" WHERE \"cod-emitente\" = '" + cod_emit + "' and \"nro-docto\" = '" + num_nota + "' and \"serie-docto\" = '" + num_serie + "' and \"ap-atual\" = '1' WITH (NOLOCK)";
                System.out.println(sql);

                result = statement.executeQuery(sql);
                while (result.next()) {
                    item = result.getString("cod-emitente");
                    System.out.println("cod_emitente: " + result.getString("cod-emitente"));
                }

                //se não encontrar o código do emitente é porque está vazio
                if (empty(item)) {
                    return 0;
                }
            }

            result.close();
            return 1;

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return 99;
    }
    
    /*TODO Novo!*/
    public TNf getDadosTotvsByChave(String chave_acess) {
        Connection con;        
        TNf item = new TNf();
        try {
            con = DatabaseConnect_mgmov.getConnection();

            ResultSet result;
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"cod-emitente\", \"nro-docto\", \"serie-docto\", \"nat-operacao\" FROM PUB.\"docum-est\" WHERE \"cod-chave-aces-nf-eletro\" = '" + chave_acess + "' WITH (NOLOCK) ";
                
                result = statement.executeQuery(sql);
                while (result.next()) {                    
                    item.setCod_emit(result.getString("cod-emitente"));
                    item.setNat_operacao(result.getString("nat-operacao"));
                    item.setNro_docto(result.getString("nro-docto"));
                    item.setSerie_docto(result.getString("serie-docto"));
                }
            }

            result.close();            
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return item;
    }
    
    /*TODO Novo!*/
    public String getOcTotvsByChave(String chave_acess) {
        Connection con;        
                
        TNf item = getDadosTotvsByChave(chave_acess);
        
        if(empty(item.getCod_emit())){
            return "0"; //Não encontrou documento
        }
        
        try {
            con = DatabaseConnect_mgmov.getConnection();

            ResultSet result;
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"numero-ordem\", \"qt-do-forn\" FROM PUB.\"item-doc-est\" "
                        + "WHERE \"cod-emitente\" = '" + item.getCod_emit() + "' and \"nro-docto\" = '"+item.getNro_docto()+"' and \"serie-docto\" = '"+item.getSerie_docto()+"' "
                        + "and \"nat-operacao\" = '"+item.getNat_operacao()+"' WITH (NOLOCK) ";
                
                result = statement.executeQuery(sql);
                while (result.next()) {                    
                    return result.getString("numero-ordem"); //número da OC
                }
            }

            result.close();            
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return "99"; //algum erro de conexão
    }

    public static boolean empty(final String s) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }

    public ArrayList<String> getDescForn(String ord_compra) {
        ArrayList<String> listadados = new ArrayList<>();

        return listadados;
    }

    public String getCodComprador(String num_ordem) {
        Connection con;
        String cod_comprador = "99";
        try {
            con = DatabaseConnect_mgmov.getConnection();

            ResultSet result;
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"cod-comprado\" FROM PUB.\"ordem-compra\" WHERE \"numero-ordem\" = '" + num_ordem + "' and \"situacao\" = 2 WITH (NOLOCK)";
                result = statement.executeQuery(sql);
                while (result.next()) {
                    cod_comprador = result.getString("cod-comprado");
                    System.out.println("cod-comprado: " + result.getString("cod-comprado"));
                }
            }
            result.close();
            return cod_comprador;

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return "99";
    }

    public String getEmailComprador(String cod_comprador) {
        Connection con;
        String email = "99";

        try {
            con = DatabaseConnect_ems2mult.getConnection();

            ResultSet result;
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"e-mail\" "
                        + "FROM PUB.\"usuar-mater\" WHERE "
                        + "\"cod-usuario\" = '" + cod_comprador + "'";
                result = statement.executeQuery(sql);
                while (result.next()) {
                    email = result.getString("e-mail");
                    System.out.println("e-mail: " + email);
                }
            }
            result.close();
            return email;

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return "99";
    }

    public String getEmailFornecedor(String cod_emit) {
        Connection con;
        String email = "0";
        //cod_emit = "23176";
        try {
            con = DatabaseConnect.getConnection();

            ResultSet result;
            try (Statement statement = con.createStatement()) {
                String sql = "SELECT \"e-mail\" FROM PUB.\"cont-emit\" WHERE \"cod-emitente\" = '" + cod_emit + "' WITH (NOLOCK) ";
                result = statement.executeQuery(sql);
                while (result.next()) {
                    
                    if(isNullOrBlank(result.getString("e-mail"))){
                        continue;
                    }
                    
                    if (email.equals("0")) {
                        email = result.getString("e-mail");
                    } else {
                        email += ", " + result.getString("e-mail");
                    }
                    
                }
            }
            
            result.close();
            
            if(isNullOrBlank(email)){
                return "0";
            }
            
            return email;

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        return "0";
    }

    public static boolean isNullOrBlank(String s) {
        return (s == null || s.trim().equals(""));
    }
}
