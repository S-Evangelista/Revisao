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

        do {

            System.out.printf("Bem vindo à Biblioteca");
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
        System.out.printf("");
        Usuario usuario = new Cliente("", "","");
        Usuario.addUsuario(usuario);
    }

    private static void login() {
        do {
            System.out.printf("Usuario: ");
            String usuario = sc.next();
            System.out.println("Senha: ");
            String senha = sc.next();

            usuarioLogado = Usuario.login("", "");

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
        }while (usuarioLogado != null);
    }
}
