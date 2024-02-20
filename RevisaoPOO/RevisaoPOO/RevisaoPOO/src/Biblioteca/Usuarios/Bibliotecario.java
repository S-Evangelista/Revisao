package Biblioteca.Usuarios;

import Biblioteca.Midia;

public class Bibliotecario extends Funcionario{
    public Bibliotecario(String nome, String usuario, String senha) {
        super(nome, usuario, senha);
    }
    @Override
    public void cadastrarUsuario(Usuario usuario){
        if(!(usuario instanceof Bibliotecario)) {
            Usuario.addUsuario(usuario);
        }
    }
    @Override
    public void removerUsuario(Usuario usuario) {
        if(!(usuario instanceof Bibliotecario)) {
            Usuario.removeUsuario(usuario);
        }
    }

    public void cadastrarMidia(Midia midia){
        Biblioteca.Midia.addMidia(midia);
    }

    public void removeMidia(int codigo){
        Midia.removerMidia(codigo);
    }


}