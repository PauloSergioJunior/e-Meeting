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

/**
 *
 * @author Paulo
 */
public class GestorRecursosDao {
    
    private final ConexaoSQLite conexaoSQLite;

    public GestorRecursosDao(ConexaoSQLite uConexaoSQLite) {
        this.conexaoSQLite = uConexaoSQLite;
    }

    public void criarTabelaGestorRecurso() {

        String sql = "CREATE TABLE IF NOT EXISTS gestorRecurso"
                + "("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "descricao text NOT NULL,"
                + "data text NOT NULL,"
                + "horaInicio text NOT NULL,"
                + "horaFim text NOT NULL,"
                + "proprietario text NOT NULL,"
                + "sala text NOT NULL"
                + ");";

        //executando o sql de criar tabelas
        boolean conectou = false;

        try {
            conectou = this.conexaoSQLite.conectar();

            Statement stmt = this.conexaoSQLite.criarStatement();

            stmt.execute(sql);

            System.out.println("Tabela GestorRecurso criada!");

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

    public void inserirGestorRecurso(Reuniao r) {

        String sqlInsert = " INSERT INTO gestorRecurso ("
                + "descricao,"
                + "data,"
                + "horaInicio,"
                + "horaFim,"
                + "sala,"
                + "proprietario"
                + ") VALUES(?,?,?,?,?,?)"
                + ";";

        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);

        try {

            preparedStatement.setString(1, r.getDescricao());
            preparedStatement.setString(2, r.getDataReuniao());
            preparedStatement.setString(3, r.getHorarioInicio());
            preparedStatement.setString(4, r.getHorarioFim());
            preparedStatement.setString(5, r.getLocal());
            preparedStatement.setString(6, r.getProprietario());

            int resultado = preparedStatement.executeUpdate();

            if (resultado == 1) {
                System.out.println("gestorRecurso inserida!");
            } else {
                System.out.println("gestorRecurso não inserido! =[");
            }

        } catch (SQLException e) {
            System.out.println("gestorRecurso não inserida!" + e);
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

    public ArrayList<Reuniao> listarTodasReunioesGestorR() {
 ArrayList<Reuniao> listR = new ArrayList<Reuniao>();
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conexaoSQLite.conectar();

        String query = "SELECT * FROM gestorRecurso;";


        try {
            stmt = conexaoSQLite.criarPreparedStatement(query);
            resultSet = stmt.executeQuery();
            
            while (resultSet.next()) {
                Reuniao r = new Reuniao();
                r.setId(resultSet.getInt("id"));
                r.setDescricao(resultSet.getString("descricao"));
                r.setDataReuniao(resultSet.getString("data"));
                r.setHorarioInicio(resultSet.getString("horaInicio"));
                r.setHorarioFim(resultSet.getString("horaFim"));
                r.setProprietario(resultSet.getString("proprietario"));
                r.setLocal(resultSet.getString("sala")); 
                listR.add(r);
                        
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
        return listR;
    }
    
     public Reuniao gerarNConfirmadas(String id) {

        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();

        conexaoSQLite.conectar();

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * "
                + " FROM gestorRecurso"
                + " WHERE id = ?;";

        try {


            preparedStatement = conexaoSQLite.criarPreparedStatement(sql);
            preparedStatement.setString(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
               Reuniao r = new Reuniao();
                r.setId(resultSet.getInt("id"));
                r.setDescricao(resultSet.getString("descricao"));
                r.setDataReuniao(resultSet.getString("data"));
                r.setHorarioInicio(resultSet.getString("horaInicio"));
                r.setHorarioFim(resultSet.getString("horaFim"));
                r.setLocal(resultSet.getString("sala")); 
                r.setProprietario(resultSet.getString("proprietario")); 
                return r;

            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                conexaoSQLite.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
     
     public boolean deleteConf(String id) {

        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();

        conexaoSQLite.conectar();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE"
                + " FROM gestorRecurso"
                + " WHERE id = ?;";

        try {
            preparedStatement = conexaoSQLite.criarPreparedStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Deletado!");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                preparedStatement.close();
                conexaoSQLite.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
}
