package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.GerenciadorReuniao;
import model.Reuniao;
import model.Usuario;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Usuario us = new Usuario(0, "Paulo", 7035064,"123", "junior@gmail.com", "Alina");
		Usuario us2 = new Usuario(1, "Junior", 55555,"321", "Paulo@gmail.com", "Saraiva");
		Usuario us3 = new Usuario(2, "Paul", 55555,"32144", "Paul@gmail.com", "Oliveira");
		Usuario us4 = new Usuario(3, "Oliveira", 55555,"32155", "Oliveira@gmail.com", "Saraiva");
		ArrayList <Usuario> u = new ArrayList <Usuario>();
		ArrayList <Usuario> u1 = new ArrayList <Usuario>();
		ArrayList <Reuniao> r = new ArrayList <Reuniao>();
		
                u.add(us);
                u.add(us2);
                u1.add(us3);
                u1.add(us4);
                
                //System.out.println(u);
                
                GerenciadorReuniao gr = new GerenciadorReuniao();
                Reuniao r1 = gr.criarReuniao(u, "Rua numero 0", "2019", "Assunto desconhecido");
                Reuniao r2 = gr.criarReuniao(u1, "Rua numero 10", "2019", "Assunto conhecido");
                
                r.add(r1);
                r.add(r2);
                
                gr.listarReunioes(r);
                
                //System.out.println( gr.criarReuniao(u, "Rua numero 0", "2019", "Assunto desconhecido"));
                //System.out.println(gr.editarAta(gr.criarReuniao(u, "Rua numero 0", "2019", "Assunto desconhecido"), "Assunto conhecido"));
	}      

}
