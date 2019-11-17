package model;

import java.util.ArrayList;

public class GerenciadorReuniao {

	
	
	public Reuniao criarReuniao(ArrayList<Usuario> usuarios,String local,String dataRe,String ata) {
		
		Reuniao r = new Reuniao();
		r.setAta(ata);
		r.setDataReuniao(dataRe);
		r.setLocal(local);
		r.setParticipantes(usuarios);
		return r;
	}
	
	public Reuniao editarAta(Reuniao r,String ata) {
		
		r.setAta(ata);
		return r;
		
	}
        
        public void listarReunioes(ArrayList<Reuniao> listaR){
            
            for (Reuniao r : listaR) {
                
                System.out.println(r);
                
            }
            
        }
	
}
