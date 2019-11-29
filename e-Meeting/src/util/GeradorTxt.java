/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.Reuniao;
/**
 *
 * @author Paulo
 */
public class GeradorTxt {
 
  public void gerarTxt(Reuniao r) throws IOException {
    
 
    FileWriter arq = new FileWriter("Ata"+r.getProprietario()+".txt");
    PrintWriter gravarArq = new PrintWriter(arq);
 
    gravarArq.printf("Ata da reuniao: "+r.getDescricao()+"%n");
    gravarArq.printf("A data: "+r.getDataReuniao()+"%n");
    gravarArq.printf("O horaria de inicio: "+r.getHorarioInicio()+"%n");
    gravarArq.printf("Horario de termino: "+r.getHorarioFim()+"%n");
    gravarArq.printf("A sala: "+r.getLocal()+"%n");
    gravarArq.printf("Proprietario da Reuniao: "+r.getProprietario()+"%n");
    
//    gravarArq.printf("+--Resultado--+%n");
//    for (i=1; i<=10; i++) {
//      gravarArq.printf("| %2d X %d = %2d |%n", i, n, (i*n));
//    }
//    gravarArq.printf("+-------------+%n");
 
    arq.close();
 
      JOptionPane.showMessageDialog(null, "Txt criado com sucesso");
    System.out.printf("Criado com Sucesso!!");
  }
 
}

    
    

