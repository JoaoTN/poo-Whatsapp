package exec;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import model.Grupo;
import model.Usuario;


public class Principal{
    public static Scanner tc = new Scanner(System.in);
    public static void main(String args[]){
        String opcao = "";
        List<Usuario> lista = new ArrayList<Usuario>();
        List<Grupo> lista2 = new LinkedList<Grupo>();
        while(!opcao.equals("sair")){
            System.out.println("Digite uma opção ou digite ajuda");
            opcao = tc.nextLine();
            String escolha[] = opcao.split(" ");
            switch(escolha[0]){
                case "ajuda":
                    String ajuda = "Bem-vindo a Central de Tira Dúvidas! Você pode fazer as seguintes opções:\n"
                                + "         1 - Adicionar usuário: addUser _nomeUsuario; \n"
                                + "         2 - Listar Todos os usuários: allUsers; \n"
                                + "         3 - Adicionar um novo grupo: newChat _nomeUsuario _nomeGrupo;\n"
                                + "         4 - Listar grupos: chats _nomeUsuário; \n"
                                + "         5 - Sair de um grupo: leave _nomeUsuário _nomeGrupo; \n"
                                + "         6 - Convidar para um grupo: invite _nomeUsuárioQueConvidou _nomeUsuárioConvidado _nomeGrupo; \n"
                                + "         7 - Usuários de um grupo: users _nomeGrupo; \n"
                                + "         8 - Enviar mensagem para um grupo: zap _nomeUsuário _nomeGrupo; \n"
                                + "         8.1 - Escrever a mensagem; \n"
                                + "         9 - Ler mensagens de um grupo: ler _nomeUsuario _nomeGrupo; \n"
                                + "         10 - Sair do programa: sair;";
                    System.out.println(ajuda);
                case "sair":
                    break;
                case "addUser":
                    Usuario novo = new Usuario(escolha[1]);
                    lista.add(novo);
                    System.out.println("done");
                    break;
                case "allUsers":
                    System.out.println(lista.toString());
                    System.out.println("done");
                    break;
                case "newChat":
                    int b = 0;
                    boolean teste = true;
                    for(int i = 0; i < lista2.size(); i++){
                        if(escolha[2].equals(lista2.get(i).getNome())){
                            teste = false;
                            break;
                        }
                    }
                    if(teste){
                        Usuario novou = new Usuario(escolha[1]);
                        Grupo cria = new Grupo(novou, escolha[2]);
                        lista2.add(cria);
                        Grupo adiciona = new Grupo(escolha[2]);
                        for(int i = 0; i < lista.size(); i++){
                            if(escolha[1].equals(lista.get(i).getNome())){
                                b = i;
                                break;
                            }
                        }
                        lista.get(b).novoChat(adiciona);
                        System.out.println("done");
                    }
                    else{
                        System.out.println("fail: chat " + escolha[2] + " ja existe!");
                    }
                    break;
                case "chats":
                    int a = 0;
                    for(int i = 0; i < lista.size(); i++){
                        if(escolha[1].equals(lista.get(i).getNome())){
                            a = i;
                            break;
                        }
                    }
                    lista.get(a).mostrarChats();
                    System.out.println("done");
                    break;
                case "invite":
                    int c = 0;
                    int d = 0;
                    boolean testeUser = false;
                    for(int i = 0; i < lista.size(); i++){
                        if(escolha[2].equals(lista.get(i).getNome())){
                            c = i;
                            break;
                        }
                    }
                    for(int i = 0; i < lista2.size(); i++){
                        if(escolha[3].equals(lista2.get(i).getNome())){
                            d = i;
                            break;
                        }
                    }
                    testeUser = lista2.get(d).verificarUser(escolha[1]);
                    if(testeUser){
                        Grupo adicionado = new Grupo(escolha[3]);
                        lista.get(c).adicionaGrupo(adicionado);
                        Usuario adicionou = new Usuario(escolha[2]);
                        lista2.get(d).adicionaParticipante(adicionou);
                        System.out.println("done");
                    }
                    else{
                        System.out.println("fail: user " + escolha[1] + " não está esm chat " + escolha[3]);
                    }
                    break;
                case "users":
                    int e = 0;
                    for(int i = 0; i < lista2.size(); i++){
                        if(escolha[1].equals(lista2.get(i).getNome())){
                            e = i;
                        }
                    }
                    lista2.get(e).mostrarUsuario();
                    System.out.println("done");
                    break;
                case "leave":
                    int x = 0;
                    int z = 0;
                    for(int i = 0; i < lista.size(); i++){
                        if(escolha[1].equals(lista.get(i).getNome())){
                            x = i;
                            break;
                        }
                    }
                    Grupo apagar = new Grupo(escolha[2]);
                    lista.get(x).apagarGrupo(apagar);
                    for(int i = 0; i < lista2.size(); i++){
                        if(escolha[2].equals(lista2.get(i).getNome())){
                            z = i;
                            break;
                        }
                    }
                    Usuario apagado = new Usuario(escolha[1]);
                    lista2.get(z).apagarPessoa(apagado);
                    System.out.println("done");
                    break;
                case "zap":
                    int t = 0;
                    String mensagem = "";
                    String nomes;
                    boolean verifico = false;
                    System.out.println("Digite a mensagem!");
                    mensagem = tc.nextLine();
                    for(int i = 0; i < lista2.size(); i++){
                        if(escolha[2].equals(lista2.get(i).getNome())){
                            t = i;
                            break;
                        }
                    }
                    verifico = lista2.get(t).verificarUser(escolha[1]);
                    if(verifico){
                        nomes = lista2.get(t).listar();
                        String users[] = nomes.split(" ");
                        for(int i = 0; i < users.length; i++){
                            for(int j = 0; j < lista.size(); j++){
                                if(users[i].equals(lista.get(j).getNome()) && !(users[i].equals(escolha[1]))){
                                    lista.get(j).adicionarMsg(mensagem, escolha[1], escolha[2]);
                                    break;
                                }
                            }
                        }
                        System.out.println("done");
                    }
                    else{
                        System.out.println("O usuário " + escolha[1] + " não pode enviar mensagens para o grupo " + escolha[2]);
                    }
                    break;
                case "ler":
                    int h = 0;
                    int m = 0;
                    String texto = "";
                    boolean testando = false;
                    for(int i = 0; i < lista2.size(); i++){
                        if(escolha[2].equals(lista2.get(i).getNome())){
                            h = i;
                            break;
                        }
                    }
                    testando = lista2.get(h).verificarUser(escolha[1]);
                    if(testando){
                        for(int i = 0; i < lista.size(); i++){
                            if(escolha[1].equals(lista.get(i).getNome())){
                                m = i;
                            }
                        }
                        lista.get(m).lerMsg(escolha[2]);
                    }
                    else{
                        System.out.println("fail: user " + escolha[1] +" não está no chat " + escolha[2]);
                    }
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
}