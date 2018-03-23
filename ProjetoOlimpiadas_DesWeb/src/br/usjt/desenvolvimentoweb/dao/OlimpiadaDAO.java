package br.usjt.desenvolvimentoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.desenvolvimentoweb.model.Olimpiada;

public class OlimpiadaDAO {
	public void criar(Olimpiada olimpiada) {
		String sqlInsert = "insert into olimpiada(ano, tipo) values (?,?,?)";
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, olimpiada.getAno());
//			stm.setEnum(2, olimpiada.getTipo());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					olimpiada.setIdOlimpiada(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualiza(Olimpiada olimpiada) {
		String sqlUpdate = "UPDATE olimpiada SET ano=?, tipo=? WHERE id_olimpiada=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, olimpiada.getAno());
//			stm.setLong(2, olimpiada.getTipo());
			stm.setInt(4, olimpiada.getIdOlimpiada());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Olimpiada olimpiada) {
		String sqlDelete = "DELETE FROM olimpiada WHERE id_olimpiada = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, olimpiada.getIdOlimpiada());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void carregar(Olimpiada olimpiada) {
		String sqlSelect = "SELECT ano, tipo FROM pais WHERE olimpiada.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, olimpiada.getIdOlimpiada());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					olimpiada.setAno(rs.getInt("ano"));
					// enum ???
					
				} else {
					olimpiada.setIdOlimpiada(-1);
					// ???
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

	}
}
