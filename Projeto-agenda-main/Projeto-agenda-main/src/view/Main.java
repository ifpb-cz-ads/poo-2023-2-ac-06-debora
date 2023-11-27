package view;

import dao.UsuarioDao;
import model.Agenda;
import model.Usuario;
import javax.swing.*;
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
        UsuarioDao dao = new UsuarioDao();
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
                    List<Usuario> usuarios = dao.listarUsuarios();
                    JOptionPane.showMessageDialog(null,
                            usuarios, "MENSAGEM DO SISTEMA",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    String email = (String) JOptionPane.showInputDialog("DIGITE O EMAIL QUE DESEJA ACESSAR:");
                    Usuario usuario = dao.buscarPorEmail(email);
                    if(usuario != null){
                        JOptionPane.showMessageDialog(null,
                                usuario, "LISTAGEM",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,
                                "USUÁRIO NÃO EXISTE!", "MENSAGEM DO SISTEMA",
                                JOptionPane.ERROR_MESSAGE);
                    }
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
        JOptionPane.showMessageDialog(null, "USUÁRIO CRIADO!");
        operacoes();
    }

}





