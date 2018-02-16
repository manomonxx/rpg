/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettotvs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.Date;

/**
 *
 * @author fernando.reis
 */
public class SocketTotvs {

    private static final String PATH = "logserver.txt";

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        try (ServerSocket listener = new ServerSocket(2223)) {
            while (true) {
                Socket socket = listener.accept();
                System.out.println("Nova conexão com o cliente "
                        + socket.getInetAddress().getHostAddress()
                );
                try {
                    BufferedReader in;
                    try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                        in = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));
                        String mensagem = in.readLine();
                        out.println(distribuiMensagem(mensagem));
                    }
                    in.close();
                } finally {
                    socket.close();
                }
            }
        }
    }

    public static String distribuiMensagem(String msg) {

        String[] parts = msg.split(Pattern.quote("|"));

        System.err.println(parts.length);
        if (parts.length <= 1) {
            saveLog("Comando inválido."); //Item pode ser: Cnpj etc.
            return "99";
        }

        if (!isNumero(parts[0])) {
            saveLog("Operação inválida.");
            return "99";
        }

        Integer op = Integer.parseInt(parts[0]);

        if (!isNumero(parts[1])) { //Item pode ser: Cnpj etc.
            saveLog("Item inválido.");
            return op + "|99";
        }

        System.out.println();
        System.out.println("Opção: " + op);

        String result = decideMetodo(parts);

        System.out.println(op + "|" + result);

        return (op + "|" + result); //retorna Operação|resultado
    }

    public static String decideMetodo(String[] parts) {
        Database db = new Database();
        String cod_emit;
        String num_oc;

        switch (Integer.parseInt(parts[0])) {

            case 1:
                System.out.println("cnjp: " + parts[1]);
                int result = db.getData(parts[1]);

                if ("99".equals(result)) {
                    saveLog("Erro no banco de dados.");
                    return "99";
                }

                return result + "";
            case 2:
                cod_emit = db.getCodEmit(parts[1]);
                num_oc = parts[2];

                System.out.println("cnjp: " + cod_emit);

                if ("99".equals(cod_emit)) {
                    saveLog("Erro na obtenção do código do emitente.");
                    return "99";
                }

//                ArrayList<String> result2 = db.getNumOC(cod_emit); //pega o número das OCs.
                Integer result2 = db.existeOC(num_oc, cod_emit);

                if (result2 == null) {
                    saveLog("Banco de dados: Erro na obtenção da lista de OCs.");
                    return "99";
                }

//                return join_OC(result2); //retorna no formato de lista
                return result2 + ""; //retorna se existe ou não
            case 3:
                // 3|900226|00880832000220  891752 891859 898060 900463
                // 3|887828|52898913000170
                num_oc = parts[1]; //numoc

                System.out.println("num-oc: " + parts[1]);

                cod_emit = db.getCodEmit(parts[2]); //cod emit

                System.out.println("cod-emitente: " + cod_emit);

                if ("99".equals(cod_emit)) {
                    saveLog("Erro na obtenção do código do emitente.");
                    return "99";
                }

                ArrayList<TItem> result3 = db.getItens(num_oc, cod_emit);

                if (result3 == null) {
                    saveLog("Lista de OCs vazia.");
                    return "99";
                }

                return join_(result3);
            case 4:
                // 4|896783|34151100000483
                num_oc = parts[1];
                String cod_comprador = db.getCodComprador(num_oc);

                if ("99".equals(cod_comprador)) {
                    saveLog("Erro na obtenção do código do Comprador.");
                    return "99";
                }

                String email = db.getEmailComprador(cod_comprador);

                if ("99".equals(email)) {
                    saveLog("Erro na obtenção do email do Comprador.");
                    return "99";
                }

                cod_emit = db.getCodEmit(parts[2]);

                if ("99".equals(cod_emit)) {
                    saveLog("Erro na obtenção do código do emitente.");
                    return "99";
                }

                String email_forn = db.getEmailFornecedor(cod_emit);

                if ("99".equals(email_forn)) {
                    saveLog("Erro na obtenção do código do email do Fornecedor.");
                    return "99";
                }

                System.out.println(email_forn);

                return formataDados(email, email_forn);
            case 5:
                System.out.println(parts[1]);
                System.out.println(parts[2]);
                System.out.println(parts[3]);

                String num_nota = "";
                //formata para que se for um número ele tenha 7 digitos acrescentando zeros.
                if (isNumero(parts[2])) {
                    num_nota = parseNota(parts[2]);
                } else {
                    saveLog("Número de nota inválida.");
                    return "99";
                }

//                String num_serie = "";
////                Integer num_nota_aux = 0;
//                //formata para que se for um número ele tenha 7 digitos acrescentando zeros.
//                if(isNumero(parts[3])){
//                    Integer num_serie_aux = Integer.parseInt(parts[3]);
//                    num_serie = num_serie_aux + "";
//                }else{
//                    num_serie = parts[3];
//                }
                cod_emit = db.getCodEmit(parts[1]);

                if (cod_emit.equals("2")) {
                    return "2"; //CNPJ não cadastrado!
                }

                if (cod_emit.equals("99")) {
                    return "99"; // Erro na conexão do banco
                }

                Integer isOk = db.isClosed(cod_emit, num_nota, parts[3]);

                return isOk + "";
            case 6:
                System.out.println(parts[1]);

                if (parts[1].length() == 0) {
                    return "99";
                }

                return db.getDadosOC(parts[1]);
            case 7: //retorna OC dada a chave de acesso da NFe
                if (parts[1].length() == 0) {
                    return "99";
                }

                return db.getOcTotvsByChave(parts[1]);
            case 8: //retorna email fornecedor dado cnpj
                if (parts[1].length() == 0) {
                    return "0";
                }
                
                cod_emit = db.getCodEmit(parts[1]);

                if (cod_emit.equals("99")) {
                    return "0"; // Erro na conexão do banco
                }
                
                System.out.println("Código do Emitente: "+cod_emit);
                
                return db.getEmailFornecedor(cod_emit);
            default:
                saveLog("Opção inválida. Esta operação ainda não foi implementada.");
                return "99";
        }
    }

    public static String formataDados(String email_usu, String email_forn) {
        return "<" + email_usu + "|" + email_forn + ">";
    }

    public static String join(ArrayList<String> list) {
        String listString = "<";

        int i = 0;
        for (String s : list) {
            listString += "<" + (++i) + "|" + s + ">";
        }

        listString += ">";

        return listString;
    }

    public static String join_OC(ArrayList<String> list) {
        String listString = "";

        if (list.size() <= 0) {
            saveLog("Lista de OCs vazia.");
            return "99";
        }

        listString = list.get(0);

        for (int j = 1; j < list.size(); j++) {
            listString += "," + list.get(j);
        }

        return listString;
    }

    public static String join_(ArrayList<TItem> list) {
        String listString = "<";

        for (TItem s : list) {
            listString += "<" + s.toString() + ">";
        }

        listString += ">";

        return listString;
    }

    public static boolean isNumero(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void saveLog(String erro) {
        BufferedWriter buffWrite;
        try {
            buffWrite = new BufferedWriter(new FileWriter(PATH, true));
            buffWrite.append("Erro: " + erro + " Data: " + getDateTime() + "\n");
            buffWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketTotvs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private static String parseNota(String part) {
        Integer num_digits = part.length();
        String result = "";

        for (int i = 0; i < 7 - num_digits; i++) {
            result += "0";
        }

        return result + part;
    }

}
