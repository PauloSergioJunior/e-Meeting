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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Reuniao;
import model.Sala;

/**
 *
 * @author Paulo
 */
public class SalaDao {
    
    private final ConexaoSQLite conexaoSQLite;

    public SalaDao(ConexaoSQLite uConexaoSQLite) {
        this.conexaoSQLite = uConexaoSQLite;
    }

    public void criarTabelaSala() {

        String sql = "CREATE TABLE IF NOT EXISTS sala"
                + "("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "nome text NOT NULL"
                + ");";

        //executando o sql de criar tabelas
        boolean conectou = false;

        try {
            conectou = this.conexaoSQLite.conectar();

            Statement stmt = this.conexaoSQLite.criarStatement();

            stmt.execute(sql);

            System.out.println("Tabela Sala criada!");

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
    
    public void inserirSala(Sala s) {

        String sqlInsert = " INSERT INTO sala("
                + "nome"
                + ")VALUES(?)"
                + ";";

        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);

        try {
            System.out.println(s.getNome());
            preparedStatement.setString(1, s.getNome());
            
            int resultado = preparedStatement.executeUpdate();
            if (resultado == 1) {
                System.out.println("Sala inserida!");
            } else {
                System.out.println("Sala não inserido!");
            }

        } catch (SQLException e) {
            System.out.println("Sala não inserida!");
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

    public ArrayList<Sala> listarTodasSalas() {
        ArrayList<Sala> listS = new ArrayList<Sala>();
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conexaoSQLite.conectar();

        String query = "SELECT * FROM sala;";


        try {
            stmt = conexaoSQLite.criarPreparedStatement(query);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Sala s = new Sala();
                s.setId(resultSet.getInt("id"));
                s.setNome(resultSet.getString("nome"));
                listS.add(s);
                        
            }
        } catch (SQLException esql) {
            System.out.println("Erro = " + esql);
        } finally {
            try {
                resultSet.close();
                stmt.close();
                conexaoSQLite.desconectar();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar o banco " + e);
            }

        }
        return listS;
    }
}
