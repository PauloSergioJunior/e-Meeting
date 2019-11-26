/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConexaoSQLite;
import java.sql.SQLException;
import java.sql.Statement;

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
}
