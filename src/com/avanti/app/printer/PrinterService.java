/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avanti.app.printer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Avanti Premium
 */
public class PrinterService {

    public static void main(String[] args) {

        final String IMPRESSORA = "\\\\localhost\\EPSON";
        final String LINE_FEED = "LF";
        final String RETURN = "CR";
        final String INIT_END = "ESC @";
        final String END_PAGE = "FF";
        FileOutputStream printer;
        PrintStream printStream;

        try {
            printer = new FileOutputStream(IMPRESSORA);
            printStream = new PrintStream(printer);

            printStream.print(INIT_END);
            printStream.print(RETURN);
            printStream.print(INIT_END);

            System.out.println("Entrou na classe.");
            printer.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao conectar a impressora!\nMostre esse erro ao responsável: " + ex);
        }

    }

}
