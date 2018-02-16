package sockettotvs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Trivial client for the date server.
 */
public class Client {

    /**
     * Runs the client as an application. First it displays a dialog box asking
     * for the IP address or hostname of a host running the date server, then
     * connects to it and displays the date that it serves.
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

//        try (Socket s = new Socket("130.100.10.165"
        try (Socket s = new Socket("130.100.15.19"
                + "", 2223)) {

            try (PrintStream saida = new PrintStream(s.getOutputStream())) {
                saida.println(teclado.nextLine());

                try (BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
                    String answer = input.readLine();
                    System.out.println(answer);
                    saida.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            teclado.close();
        }

//        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }
}
