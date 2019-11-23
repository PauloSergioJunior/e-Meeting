package model;

import java.util.ArrayList;

public class Reuniao {

    private int id;
    private String descricao;
    private String dataReuniao;
    private String horarioInicio;
    private String horarioFim;
    private String local;
    private boolean proprietario;
    private ArrayList<Usuario> participantes;
    private boolean verificado;

    public Reuniao(int id, String ata, String dataReuniao, String local) {
        this.id = id;
        this.descricao = ata;
        this.dataReuniao = dataReuniao;
        this.local = local;

    }

    public Reuniao() {
        this.setVerificado(false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public boolean isProprietario() {
        return proprietario;
    }

    public void setProprietario(boolean proprietario) {
        this.proprietario = proprietario;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(String horarioFim) {
        this.horarioFim = horarioFim;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    
    
    @Override
    public String toString() {
        return "Reuniao{" + "Ata=" + descricao + ", dataReuniao=" + dataReuniao + ", horarioInicio=" + horarioInicio + ", horarioFim=" + horarioFim + ", local=" + local + ", participantes=" + participantes + '}';
    }

}
