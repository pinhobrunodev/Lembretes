package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.LembreteBeans;
import connection.SingleConnection;
import exception.DbException;
import exception.DbIntegrityException;

public class LembreteDAO {

	public void adicionarLembrete(LembreteBeans lb) {
		try {
			Connection con = SingleConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into mensagemlembrete (TITULO,MENSAGEM) values (?,?)");
			ps.setString(1, lb.getTitulo());
			ps.setString(2, lb.getMsg());
			ps.executeUpdate();
			SingleConnection.closePrepareStatement(ps);
			SingleConnection.closeConnection(con);

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	public ArrayList<LembreteBeans> listarLembretes() {
		ArrayList<LembreteBeans> list = new ArrayList<>();
		try {
			Connection con = SingleConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from mensagemlembrete order  by IDLEMBRETE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String titulo = rs.getString(2);
				String msg = rs.getString(3);
				list.add(new LembreteBeans(id, titulo, msg));
			}
			SingleConnection.closePrepareStatement(ps);
			SingleConnection.closeResulstSet(rs);
			SingleConnection.closeConnection(con);
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	public void removerLembrete(LembreteBeans lb) {
		try {
			Connection con = SingleConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from mensagemlembrete where IDLEMBRETE = ? ");
			ps.setString(1, lb.getId());
			ps.executeUpdate();
			SingleConnection.closePrepareStatement(ps);
			SingleConnection.closeConnection(con);
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}

	}

	public void selecionarLembrete(LembreteBeans lb) {
		try {
			Connection con = SingleConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from mensagemlembrete where IDLEMBRETE = ? ");
			ps.setString(1, lb.getId());
			// ID QUE SERA SELECIONADO
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// VOU SETAR CADA VALOR DA COLUNA NOS ATRIBUTOS DO MEU LEMBRETEBEANS
				lb.setId(rs.getString(1));
				lb.setTitulo(rs.getString(2));
				lb.setMsg(rs.getString(3));
			}
			SingleConnection.closePrepareStatement(ps);
			SingleConnection.closeResulstSet(rs);
			SingleConnection.closeConnection(con);
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	public void atualizarLembrete(LembreteBeans lb) {
		try {
			Connection con = SingleConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update mensagemlembrete set TITULO = ? , MENSAGEM = ? WHERE IDLEMBRETE = ? ");
			ps.setString(1, lb.getTitulo());
			ps.setString(2, lb.getMsg());
			ps.setString(3, lb.getId());
			ps.executeUpdate();
			SingleConnection.closePrepareStatement(ps);
			SingleConnection.closeConnection(con);
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
}
