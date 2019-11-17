package model;

import java.util.ArrayList;

public class GerenciadorReuniao {

	
	
	public Reuniao criarReuniao(ArrayList<Usuario> usuario,String local,String dataRe,String ata) {
		
		Reuniao r = new Reuniao();
		r.setAta(ata);
		r.setDataReuniao(dataRe);
		r.setLocal(local);
		r.setParticipantes(usuario);
		return r;
	}
	
	public Reuniao editarAta(Reuniao r,String ata) {
		
		r.setAta(ata);
		return r;
		
	}
	
}
