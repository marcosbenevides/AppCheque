/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avanti.app.printer;

import java.io.FileNotFoundException;
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

    //caminho da impressora
    private final String IMPRESSORA = "\\\\localhost\\EPSON";
    //consome uma linha
    private final String LINE_FEED = "\n";
    //volta a cabeça para o inicio
    private final String RETURN = "CR";
    //reseta as configuraçoes
    private final String INIT_END = "\u001B"+"\u0040";
    //necessario em todo final de impressão
    private final String FORM_FEED = "\f";
    //configura a unidade para 1/360 polegadas
    private final String SET_UNIT = "\u001B"+"\u0028"+"\u0055" + (char) 1 + (char) 0 + (char) 10;
    //define o tamanho da pagina para 3 polegadas
    private final String PAGE_LENGTH = "\u001B"+"\u0028"+"\u0043" + (char) 2 + (char) 0 + (char) 56 + (char) 4;
    //define o tamanho da linha para 3 milimetros ou 0,119 polegadas
    private final String LINE_SPACE = "\u001B" + (char) + +(char) 43;
    private final String CHAR_P_INCH_15 = "\u001B"+"\u0050";
    private final String CHAR_TABLE = "\u001B"+"\u0028"+"\u0074" + (char) 3 + (char) 0 + (char) 0 + (char) 25 + (char) 0;
    private final String FONT = "\u001B"+"\u006B" + (char) 1;
    private final String HEAD_MOV = "\u001B"+"\u0055" + (char) 1;
    private final String V_POS = "\u001B"+"(V";
    private final String H_POS = "\u001B"+"$" + (char)5;
    private FileOutputStream printer;
    private PrintStream printStream;

    public PrinterService() {

    }

    public void prepararImpressora() {
        try {
            StringBuffer buffer = new StringBuffer();
            buffer.setLength(20);
            for (int i = 0; i < 20; i++) {
                buffer.setCharAt(i, ' ');
            }
            buffer = alinha(6, "Marcos", buffer);
            buffer = alinha(10, "Benevides", buffer);

            printer = new FileOutputStream(IMPRESSORA);
            printStream = new PrintStream(printer);

            printStream.print(INIT_END);
            printStream.print(SET_UNIT);
            printStream.print(LINE_SPACE);
            printStream.print(CHAR_P_INCH_15);
            printStream.print(PAGE_LENGTH);
            printStream.print(CHAR_TABLE);
            printStream.print(HEAD_MOV);

            printStream.print(FONT);
            printStream.print(H_POS);
            printStream.print("benevides");
            printStream.print(LINE_FEED);
            printStream.print(RETURN);

            printStream.print(FONT);
            printStream.print("marcos");
            printStream.print(LINE_FEED);
            
            printStream.print(RETURN);
            printStream.print(FORM_FEED);
            printStream.print(INIT_END);

            printer.close();
            printStream.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao conectar a impressora!\nMostre esse erro ao responsável: " + ex);
        } catch (IOException ex) {
            Logger.getLogger(PrinterService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static StringBuffer alinha(int inicio, String str, StringBuffer buffer) {
        int indexChar = 0;
        int tamanho = str.length();
        char vetorChar[] = str.toCharArray();
        for (int i = inicio; i < (inicio + tamanho); i++) {
            buffer.setCharAt(i, vetorChar[indexChar]);
            indexChar++;
        }
        return buffer;
    }

    public String getIMPRESSORA() {
        return IMPRESSORA;
    }

    public String getLINE_FEED() {
        return LINE_FEED;
    }

    public String getRETURN() {
        return RETURN;
    }

    public String getINIT_END() {
        return INIT_END;
    }

    public String getEND_PAGE() {
        return FORM_FEED;
    }

    public String getSET_UNIT() {
        return SET_UNIT;
    }

    public String getPAGE_LENGTH() {
        return PAGE_LENGTH;
    }

    public FileOutputStream getPrinter() {
        return printer;
    }

    public PrintStream getPrintStream() {
        return printStream;
    }

    public static void main(String[] args) {

        PrinterService printerService = new PrinterService();

        printerService.prepararImpressora();

    }
}
