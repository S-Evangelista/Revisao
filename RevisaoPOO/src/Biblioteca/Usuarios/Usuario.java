package Biblioteca.Usuarios;

import Biblioteca.Midia;
import Biblioteca.Midias.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    //Armazenar todos os usuários do sistema, independente da tipagem.
    private final static List<Usuario> usuarios = new ArrayList<>();

    private String nome;
    private String usuario;
    private String senha;
    protected ArrayList<Midia> emprestimos;

    public Usuario(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
     public void alterarSenha(String senha){
        this.senha = senha;
     }
     public void alterarNome(String nome){
        this.nome = nome;
     }
     public String getNome(){
        return nome;
     }

     public static void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
     }
     public static void removeUsuario(Usuario usuario){
        usuarios.remove(usuario);
     }

    public static Usuario login(String user, String senha){
         for (Usuario userProcurado: usuarios) {
             if(userProcurado.usuario.equals(user) &&
             userProcurado.senha.equals(senha)){
                 return userProcurado;
             }
         }
         return null;
     }

    protected abstract boolean addEmprestimo(Midia midia);

    protected int analalisarQuantidade(Midia midia){
        int qtd = 0;
        for (Midia midiaAnalise:
                emprestimos) {
            if(midiaAnalise instanceof DVD && midia instanceof DVD){
                qtd++;
            }
            if(midiaAnalise instanceof Livro && midia instanceof Livro){
                qtd++;
            }
            if(midiaAnalise instanceof Revista && midia instanceof Revista){
                qtd++;
            }
            if(midiaAnalise instanceof Jornal && midia instanceof Jornal){
                qtd++;
            }
        }
        return qtd;
    }

    public String consultarMidia(int codigo) {
        Midia midia = Midia.procurarMidia(codigo);
        if (midia == null) {
            return ("Mídia não encontrada");
        }
        return midia.toString();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", usuario='" + usuario + '\'' +
                ", emprestimos=" + emprestimos +
                '}';
    }

    public ArrayList<Midia> getEmprestimos() {
        return emprestimos;
    }
}
