package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Usuario{
    private String nome;
    private List<Grupo> grupos = new LinkedList<>();;
    private List<Msg> mensagens = new ArrayList<>();;
    
    public Usuario(String nome){
        this.nome = nome;
    }
    
    public List<Grupo> getGrupos(){
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public List<Msg> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Msg> mensagens) {
        this.mensagens = mensagens;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void mostrarChats(){
        for(int i = 0; i < grupos.size(); i++){
            System.out.println(this.grupos.get(i));
        }
    }
    
    public void novoChat(Grupo a){
        this.grupos.add(a);
    }
    public void adicionaGrupo(Grupo a){
        this.grupos.add(a);
    }
    public void apagarGrupo(Grupo b){
        this.grupos.remove(b);
        
    }
    public void adicionarMsg(String mensagem, String autorMsg, String grupo){
        Msg msg = new Msg(mensagem, autorMsg, grupo);
        this.mensagens.add(msg);
        System.out.println(mensagens.toString());
    }
    public void lerMsg(String procura){
        Msg aux;
        for(int i = 0; i < this.mensagens.size(); i++){
            if(procura.equals(mensagens.get(i).getNomeGrupo())){
                System.out.println(mensagens.get(i).toString());
                aux = new Msg(mensagens.get(i).getMensagem());
                this.mensagens.remove(aux);
                break;
            }
        }
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.nome);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
	String res = "";
        res = nome;
        return res;
    }
}