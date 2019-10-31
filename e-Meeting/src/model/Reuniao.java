package model;

import java.util.ArrayList;

public class Reuniao {

	private int id;
	private String ata;
	private String dataReuniao;
	private String local;
        private ArrayList <Usuario> participantes;
	
	public Reuniao(int id, String ata, String dataReuniao, String local) {
		this.id = id;
		this.ata = ata;
		this.dataReuniao = dataReuniao;
		this.local = local;
		
	}

	public Reuniao() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAta() {
		return ata;
	}

	public void setAta(String ata) {
		this.ata = ata;
	}

	public String getDataReuniao() {
		return dataReuniao;
	}

	public void setDataReuniao(String dataReuniao) {
		this.dataReuniao = dataReuniao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

        public ArrayList<Usuario> getParticipantes() {
            return participantes;
        }

        public void setParticipantes(ArrayList<Usuario> participante) {
            this.participantes = participante;
        }

    @Override
    public String toString() {
        return "Reuniao{" + "id=" + id + ", ata=" + ata + ", dataReuniao=" + dataReuniao + ", local=" + local + ", participante=" + participantes + '}';
    }

        
		
	
}
