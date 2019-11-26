/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConexaoSQLite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import model.UsuarioComum;

/**
 *
 * @author Paulo
 */
public class UsuarioDao {

    private final ConexaoSQLite conexaoSQLite;

    public UsuarioDao(ConexaoSQLite uConexaoSQLite) {
        this.conexaoSQLite = uConexaoSQLite;
    }

    public void criarTabelaUsuario() {

        String sql = "CREATE TABLE IF NOT EXISTS usuario"
                + "("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "nome text NOT NULL,"
                + "cpf text NOT NULL,"
                + "senha text NOT NULL,"
                + "email text NOT NULL,"
                + "endereco text NOT NULL,"
                + "tipo text NOT NULL"
                + ");";

        //executando o sql de criar tabelas
        boolean conectou = false;

        try {
            conectou = this.conexaoSQLite.conectar();

            Statement stmt = this.conexaoSQLite.criarStatement();

            stmt.execute(sql);

            System.out.println("Tabela usuario criada!");

        } catch (SQLException e) {
            //mensagem de erro na criação da tabela
            System.out.println("Não criou!!");
        } finally {
            if (conectou) {
                this.conexaoSQLite.desconectar();
            }
        }

    }

    public void inserirUsuario(Usuario u) {

        String sqlInsert = " INSERT INTO usuario ("
                + "nome,"
                + "cpf,"
                + "senha,"
                + "email,"
                + "endereco,"
                + "tipo"
                + ") VALUES(?,?,?,?,?,?)"
                + ";";

        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);

        try {

            preparedStatement.setString(1, u.getNome());
            preparedStatement.setString(2, u.getCpf());
            preparedStatement.setString(3, u.getSenha());
            preparedStatement.setString(4, u.getEmail());
            preparedStatement.setString(5, u.getEndereco());
            preparedStatement.setString(6, u.getTipo());

            int resultado = preparedStatement.executeUpdate();

            if (resultado == 1) {
                System.out.println("Usuario inserida!");
            } else {
                System.out.println("Usuario não inserido! =[");
            }

        } catch (SQLException e) {
            System.out.println("Usuario não inserida!");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conexaoSQLite.desconectar();
        }

    }

    public void listarTodosUsuarios() {

        ResultSet resultSet = null;
        Statement statement = null;
        conexaoSQLite.conectar();

        String query = "SELECT * FROM usuario;";

        statement = conexaoSQLite.criarStatement();

        try {
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Dados dos usuarios");
                System.out.println("id= " + resultSet.getInt("id"));
                System.out.println("Nome =" + resultSet.getString("nome"));
                System.out.println("Nome =" + resultSet.getString("tipo"));
            }
        } catch (SQLException esql) {
            System.out.println("Erro = " + esql);
        } finally {
            try {
                resultSet.close();
                statement.close();
                conexaoSQLite.desconectar();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar o banco " + e);
            }

        }

    }

    public boolean verificarLogin(String cpf, String senha) {

        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();

        conexaoSQLite.conectar();

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * "
                + " FROM usuario"
                + " WHERE cpf = ? AND senha = ?;";

        try {


            preparedStatement = conexaoSQLite.criarPreparedStatement(sql);
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, senha);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                
                System.out.println("PESSOA SELECIONADA");
                System.out.println("ID = " + resultSet.getInt("id"));
                System.out.println("NOME = " + resultSet.getString("nome"));
                System.out.println("CPF = " + resultSet.getString("cpf"));
                
                return true;

            }

        } catch (SQLException e) {
            return false;
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                conexaoSQLite.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
        public boolean verificarCpfExiste(String cpf) {

        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();

        conexaoSQLite.conectar();

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * "
                + " FROM usuario"
                + " WHERE cpf = ?;";

        try {


            preparedStatement = conexaoSQLite.criarPreparedStatement(sql);
            preparedStatement.setString(1, cpf);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
               
                System.out.println("Usuario Existe!!!");
                return true;

            }

        } catch (SQLException e) {
            return false;
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                conexaoSQLite.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

}
