/*
 *
Copyright (c) 2006-2007, Giovanni Martina
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that 
the following conditions are met:

- Redistributions of source code must retain the above copyright notice, this list of conditions and the 
following disclaimer.

- Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the 
following disclaimer in the documentation and/or other materials provided with the distribution.

-Neither the name of Drayah, Giovanni Martina nor the names of its contributors may be used to endorse or 
promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED 
WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A 
PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY 
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH 
DAMAGE.
 *
 * MatrixMain.java
 *
 * Created on 4 de Setembro de 2006, 16:22
 *
 * @author giovanni <gio@drayah.net>
 * Copyright � 2006 G.M. Martina
 *
 * Main class for matrix printer tests
 *
 */
package com.avanti.app.printer;

public class MatrixMain {

    public static void main(String[] args) {
        ESCPrinter escp = new ESCPrinter("\\\\localhost\\EPSON", false); //create ESCPrinter on network location \\computer\sharename, 9pin printer
        if (escp.initialize()) {
            //escp.select10CPI();//15 characters per inch printing

            //valor
            escp.advanceVertical(0); //go down 5cm
            escp.setAbsoluteHorizontalPosition(12); //5cm to the right
            escp.print("800,00");

            //valor por extenso
            escp.advanceVertical(0.9f); //go down 5cm
            escp.setAbsoluteHorizontalPosition(2.5f); //5cm to the right
            escp.print("OITOCENTOS REAIS");

            //benificiario
            escp.advanceVertical(1.6f); //go down 5cm
            escp.setAbsoluteHorizontalPosition(1); //5cm to the right
            escp.print("MARCOS BENEVIDES");

//            //cidade
            escp.advanceVertical(0.9f); //go down 5cm
            escp.setAbsoluteHorizontalPosition(7.3f); //5cm to the right
            escp.print("BELO HORIZONTE");

            //dia
            escp.advanceVertical(0); //go down 5cm
            escp.setAbsoluteHorizontalPosition(10.7f); //5cm to the right
            escp.print("31");
            //mês
            escp.advanceVertical(0); //go down 5cm
            escp.setAbsoluteHorizontalPosition(12.5f); //5cm to the right
            escp.print("OUTUBRO");
            //ano
            escp.advanceVertical(0); //go down 5cm
            escp.setAbsoluteHorizontalPosition(15.5f); //5cm to the right
            escp.print("17");

            //bom para
            escp.advanceVertical(1.8f); //go down 5cm
            escp.setAbsoluteHorizontalPosition(8); //5cm to the right
            escp.print("BOM PARA: 31/10/17");
            //escp.bold(false);
            //escp.advanceVertical(1);
            //escp.setAbsoluteHorizontalPosition(5); //back to 5cm on horizontal axis
            //escp.print("Very simple and easy!"); 
            escp.formFeed(); //eject paper
            escp.endWork();
            escp.close(); //close stream
        } else {
            System.out.println("Couldn't open stream to printer");
        }
    }
}
