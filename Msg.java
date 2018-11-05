package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Msg{
    private String mensagem;
    private String donoMsg;
    private String nomeGrupo;

    public Msg(String mensagem, String donoMsg, String nomeGrupo){
        this.mensagem = mensagem;
        this.donoMsg = donoMsg;
        this.nomeGrupo = nomeGrupo;
    }
    public Msg(String mensagem){
        this.mensagem = mensagem;
    }
    public String getDonoMsg() {
        return donoMsg;
    }

    public void setDonoMsg(String donoMsg) {
        this.donoMsg = donoMsg;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }
            
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.mensagem);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Msg other = (Msg) obj;
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        return true;
    }
    
    public String toString(){
	String res = "";
        res = donoMsg + ": " + mensagem;
        return res;
    }
}