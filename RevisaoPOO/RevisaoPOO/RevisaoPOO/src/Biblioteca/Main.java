package Biblioteca;

import Biblioteca.Usuarios.Bibliotecario;
import Biblioteca.Usuarios.Funcionario;
import Biblioteca.Usuarios.Usuario;
import Biblioteca.Usuarios.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    private static final Scanner sc = new Scanner(System.in);

    private static  Usuario usuarioLogado;



    public static void main(String[] args) {
         Usuario fulano = new Bibliotecario("fulano", "fulano", "1234");
         Usuario.addUsuario(fulano);

        do {

            System.out.printf("Bem vindo à Biblioteca ");
            System.out.printf("""
                    1- Cadastro de Usuário
                    2- Login
                    3- Sair
                    """);
            int escolha = sc.nextInt();

            switch (escolha) {
                case 1 -> cadastroUsuario();
                case 2 -> login();
                case 3 -> System.exit(0);
            }
        }while (true);
    }

    private static void cadastroUsuario() {
        System.out.printf("Digite o nome:");
        String nome = sc.next();

        System.out.printf("Digite o nome de usuario:");
        String nomeUser = sc.next();

        System.out.printf("Defina uma senha:");
        String senha = sc.next();

        Usuario usuario = new Cliente( nomeUser, nome, senha);
        Usuario.addUsuario(usuario);
    }

    private static void login() {
        do {
            System.out.printf("Usuario: ");
            String usuario = sc.next();
            System.out.println("Senha: ");
            String senha = sc.next();

            usuarioLogado = Usuario.login(usuario, senha);

        } while (usuarioLogado == null);
        menuUsuario();
    }

    private static void logout(){
        usuarioLogado = null;
    }

    private static void menuUsuario() {
        do {
            System.out.printf("""
                    1- Alterar nome
                    2- Alterar senha
                    3- Ver emprestimos
                    4- Ver perfil
                    5- Consultar disponibilidade de mídia
                    """);
            if (usuarioLogado instanceof Funcionario) {
                System.out.printf("""
                        6- Cadastrar cliente 
                        7- Remover Usuário
                        8- Emprestar mídia
                        9- Devolver midia
                        10- Ver midias
                        """);
                if (usuarioLogado instanceof Bibliotecario) {
                    System.out.printf("""
                            11- Cadastrar midias
                            12- Remover midia
                                                    
                            """);
                }
            }
            System.out.printf("0- Logout");

            System.out.println("Digite sua escolha: ");
            int opcao = sc.nextInt();

            switch(opcao){

                case 1 -> alterarNome();
                case 2 -> alterarSenha();
                case 3 -> verEmprestimos();
                case 4-> verPerfil();
                case 5 -> consultarMidia();
                case 7 -> removerUsuario();
                case 8 -> emprestarMidia();


            }

        }while (usuarioLogado != null);
    }

    public static void alterarNome(){
        System.out.println("Digite o novo nome: ");
        String novoNome = sc.next();

        usuarioLogado.alterarNome(novoNome);
    }
    public static void alterarSenha(){
        System.out.println("Digite a nova senha: ");
        String novaSenha = sc.next();

        usuarioLogado.alterarSenha(novaSenha);
    }

    public static void verEmprestimos(){
        System.out.println(usuarioLogado.getEmprestimos());
    }

    public static void verPerfil(){
        System.out.println(usuarioLogado.toString());
    }

    public static void consultarMidia(){
        System.out.println("Digite a midia desejada: ");
        String nomeMidia = sc.next();
    }

    public static void removerUsuario(){
        System.out.println("Digite o usuario que deseja remover: ");
        String userRemovido = sc.next();


    }

    public static void emprestarMidia(){
        System.out.println("Digite o código da midia: ");
        int nomeMidia = sc.nextInt();

    }





}