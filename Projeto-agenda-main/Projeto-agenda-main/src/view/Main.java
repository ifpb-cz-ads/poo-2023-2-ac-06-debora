package view;

import model.Agenda;
import model.Usuario;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static ArrayList<Agenda> Usuario;
    private static String email;
    private static String file;

    public static void main(String[] args) {
        Usuario = new ArrayList<>();
        operacoes();
    }
    private static void operacoes() {
            int operacao = Integer.parseInt(JOptionPane.showInputDialog("------SELECIONE UMA OPERAÇÃO------\n" +
                            "| 1- CRIAR USUÁRIO |\n" +
                            "| 2- LISTAR USUÁRIOS |\n" +
                            "| 3- BUSCAR POR EMAIL |\n" +
                            "| 4- SAIR |\n" +
                            "----------------"));
            switch (operacao) {
                case 1:
                    int retorno = JOptionPane.showConfirmDialog(null,
                            "Deseja continuar?", "Mensagem do sistema",
                            JOptionPane.YES_NO_OPTION);
                    criarUsuario();
                    break;
                case 2:
                    int retorno2 = JOptionPane.showConfirmDialog(null,
                            "Deseja continuar?", "Mensagem do sistema",
                            JOptionPane.YES_NO_OPTION);
                    List<model.Usuario> usuarios = listarUsuarios();
                    break;
                case 3:
                    int retorno3 = JOptionPane.showConfirmDialog(null,
                            "Deseja continuar?", "Mensagem do sistema",
                            JOptionPane.YES_NO_OPTION);
                    buscarPorEmail();
                    break;
                case 4:
                    int retorno4 = JOptionPane.showConfirmDialog(null,
                            "Deseja continuar?", "Mensagem do sistema",
                            JOptionPane.YES_NO_OPTION);
                    JOptionPane.showMessageDialog(null, "---Obrigado por utilizar o sistema!---");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Erro, opção invalida!");
                    operacoes();
                    break;
            }
        }

    private static void criarUsuario() {
        Usuario usuario = new Usuario();

        usuario.setNome(JOptionPane.showInputDialog("Nome: "));
        usuario.setEmail(JOptionPane.showInputDialog("Email:"));
        usuario.setSenha(JOptionPane.showInputDialog("Senha:"));
        Agenda agenda = new Agenda(usuario);
        Usuario.add(agenda);
        JOptionPane.showMessageDialog(null, "Usuario criado!");
        operacoes();
    }



    public static List<Usuario> listarUsuarios(){
        if(file.length()>0){
            try{
                ObjectInputStream in = new ObjectInputStream(
                        new FileInputStream(file)
                );
                List<Usuario> lista = (List<Usuario>) in.readObject();
                return lista;
            }catch (IOException exception){
                JOptionPane.showMessageDialog(null, exception);
            }catch (ClassNotFoundException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }
        return new ArrayList<>();
    }
    public static Usuario buscarPorEmail(){
        List<Usuario> usuarios = listarUsuarios();
        for(Usuario usuario : usuarios){
            if(usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }
}




