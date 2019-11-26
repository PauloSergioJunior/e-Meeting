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
import model.Reuniao;

/**
 *
 * @author Paulo
 */
public class ReuniaoDao {
    
    private final ConexaoSQLite conexaoSQLite;

    public ReuniaoDao(ConexaoSQLite uConexaoSQLite) {
        this.conexaoSQLite = uConexaoSQLite;
    }

    public void criarTabelaReuniao() {

        String sql = "CREATE TABLE IF NOT EXISTS reuniao"
                + "("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "descricao text NOT NULL,"
                + "data text NOT NULL,"
                + "horaInicio text NOT NULL,"
                + "horaFim text NOT NULL,"
                + "idsala integer references sala(id)"
                + ");";

        //executando o sql de criar tabelas
        boolean conectou = false;

        try {
            conectou = this.conexaoSQLite.conectar();

            Statement stmt = this.conexaoSQLite.criarStatement();

            stmt.execute(sql);

            System.out.println("Tabela reuniao criada!");

        } catch (SQLException e) {
            //mensagem de erro na criação da tabela
            System.out.println(e);
            System.out.println("Não criou!!");
        } finally {
            if (conectou) {
                this.conexaoSQLite.desconectar();
            }
        }

    }

    public void inserirReuniao(Reuniao r) {

        String sqlInsert = " INSERT INTO reuniao ("
                + "descricao,"
                + "data,"
                + "horaInicio,"
                + "horaFim,"
                + "sala"
                + ") VALUES(?,?,?,?,?)"
                + ";";

        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);

        try {

            preparedStatement.setString(1, r.getDescricao());
            preparedStatement.setString(2, r.getDataReuniao());
            preparedStatement.setString(3, r.getHorarioInicio());
            preparedStatement.setString(4, r.getHorarioFim());
            preparedStatement.setString(5, r.getLocal().getNome());

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

    public void listarTodasReunioes() {

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
}
