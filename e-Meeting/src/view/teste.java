package view;

import java.util.ArrayList;
import model.GerenciadorReuniao;
import model.Usuario;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Usuario us = new Usuario(0, "Paulo", 7035064, "Psjr", "123", "junior@gmail.com", "Alina");
		Usuario us2 = new Usuario(0, "Junior", 55555, "Jr", "321", "Paulo@gmail.com", "Saraiva");
		ArrayList <Usuario> u = new ArrayList <Usuario>(50);
		
                u.add(us);
                u.add(us2);
                
                System.out.println(u);
                
                GerenciadorReuniao gr = new GerenciadorReuniao();
                
                System.out.println( gr.criarReuniao(u, "Rua numero 0", "2019", "Assunto desconhecido"));
                System.out.println(gr.editarAta(gr.criarReuniao(u, "Rua numero 0", "2019", "Assunto desconhecido"), "Assunto conhecido"));
	}      

}
