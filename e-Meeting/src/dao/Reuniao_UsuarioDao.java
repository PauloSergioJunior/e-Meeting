/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConexaoSQLite;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Reuniao;

/**
 *
 * @author Paulo
 */
public class Reuniao_UsuarioDao {
    
        private final ConexaoSQLite conexaoSQLite;

    public Reuniao_UsuarioDao(ConexaoSQLite uConexaoSQLite) {
        this.conexaoSQLite = uConexaoSQLite;
    }

    public void criarTabelaReuniao_Usuario() {

        String sql = "CREATE TABLE IF NOT EXISTS reuniao_usuario"
                + "("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "idusuario integer references usuario(id),"
                + "idreuniao integer references reuniao(id)"
                + ");";

        //executando o sql de criar tabelas
        boolean conectou = false;

        try {
            conectou = this.conexaoSQLite.conectar();

            Statement stmt = this.conexaoSQLite.criarStatement();

            stmt.execute(sql);

            System.out.println("Tabela reuniao_usuario criada!");

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

    public void inserirReuniao_Usuario(int idusuario, int idreuniao) {

        String sqlInsert = " INSERT INTO reuniao_usuario ("
                + "idusuario,"
                + "idreuniao"
                + ") VALUES(?,?)"
                + ";";

        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);

        try {

            preparedStatement.setInt(1, idusuario);
            preparedStatement.setInt(2, idreuniao);
           

            int resultado = preparedStatement.executeUpdate();

            if (resultado == 1) {
                System.out.println("Usuario_Reuniao inserida!");
            } else {
                System.out.println("Usuario_Reuniao não inserido! =[");
            }

        } catch (SQLException e) {
            System.out.println("Usuario_reuniao não inserida!");
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
    
    
}
