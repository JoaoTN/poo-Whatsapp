package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Grupo{
    private String nome;
    private List<Usuario> usuarios = new ArrayList<>();
	
    public Grupo( Usuario a, String nome){
        usuarios.add(a);
        this.nome = nome;
    }
    public Grupo(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public boolean convidar(Usuario pessoa){
        if(!usuarios.contains(pessoa)){
            usuarios.add(pessoa);
            return true;
        }
        return false;
    }
    public void adicionaParticipante(Usuario a){
        this.usuarios.add(a);
    }
    public void mostrarUsuario(){
        for(int i = 0; i < usuarios.size(); i++){
            System.out.println(this.usuarios.get(i));
        }
    }
    public void apagarPessoa(Usuario apagar){
         this.usuarios.remove(apagar);
    }
    public boolean verificarUser(String b){
        boolean teste = false;
        for(int i = 0; i < usuarios.size(); i++){
            if(b.equals(this.usuarios.get(i).getNome())){
                teste = true;
            }
        }
        return teste;
    }
    public String listar(){
        String nomes = "";
        for(int i = 0; i < usuarios.size(); i++){
            nomes = nomes + this.usuarios.get(i).getNome();
            if((i - 1) < usuarios.size()){
                nomes = nomes + " ";
            }
        }
        System.out.println(nomes);
        return nomes;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nome);
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
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    public String toString(){
	String res = "";
        res = nome;
        return res;
    }
}