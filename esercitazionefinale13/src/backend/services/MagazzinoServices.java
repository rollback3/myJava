package backend.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import common.interfaces.IMagazzinoServices;
import common.javabeans.Magazzino;

public class MagazzinoServices implements IMagazzinoServices {
	
	@Override
	public void insertMagazzino(Magazzino magazzino) {

		insInMagazzino(magazzino.getNomeProdotto(), magazzino.getDescrizione(), magazzino.getLivelloScorte(),
				magazzino.getLivelloMinimoScorte());

	}

	private void insInMagazzino(String nomeProdotto, String descrizione, int livelloScorte, int livelloMinimoScorte) {

		String sqlInsert = ("INSERT INTO magazzino(nomeProdotto, descrizione, livelloScorte, livelloMinimoScorte)"
				+ "VALUES(?, ?, ?, ?)");

		PreparedStatement ps = null;
		try {
			ps = ConnectionManager.getConnection().prepareStatement(sqlInsert);
			ps.setString(1, nomeProdotto);
			ps.setString(2, descrizione);
			ps.setInt(3, livelloScorte);
			ps.setInt(4, livelloMinimoScorte);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Magazzino> listaMagazzino() {

		ResultSet rs = selectMagazzino();

		return getListaMagazzino(rs);
	}

	// esecuzione query ResultSet
	private ResultSet selectMagazzino() {

		Statement stmt;
		Connection con = null;
		ResultSet rs = null;
		String selectMagazzino = "SELECT * FROM magazzino";
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectMagazzino);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	private List<Magazzino> getListaMagazzino(ResultSet rs) {

		List<Magazzino> lista = new ArrayList<>();
		try {
			while (rs.next()) {
				Magazzino M = new Magazzino(rs.getInt("id"), rs.getString("nomeProdotto"), rs.getString("descrizione"),
						rs.getInt("livelloScorte"));
				lista.add(M);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public void updateMagazzino(Magazzino magazzino) {

		updateFromMagazzino(magazzino.getId(), magazzino.getNomeProdotto(), magazzino.getDescrizione());

	}

	private void updateFromMagazzino(int id, String nomeProdotto, String descrizione) {

		String sqlUPDATE = "UPDATE magazzino SET nomeProdotto = ?, ?  WHERE id =  ?";
		PreparedStatement ps = null;
		try {
			ps = ConnectionManager.getConnection().prepareStatement(sqlUPDATE);
			ps.setString(1, nomeProdotto);
			ps.setString(2, descrizione);
			ps.setInt(3, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMagazzino(Magazzino magazzino) {

		deleteFromMagazzino(magazzino.getId());

	}

	private void deleteFromMagazzino(int id) {

		String sqlDELETE = "DELETE FROM magazzino WHERE id = ? ";
		PreparedStatement ps = null;
		try {
			ps = ConnectionManager.getConnection().prepareStatement(sqlDELETE);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void increaseScorte(Magazzino magazzino) {

		increaseMagazzino(magazzino.getId(), magazzino.getEditScorte());

	}

	private void increaseMagazzino(int id, int addedScorte) {

		String sqlUPDATE = "UPDATE magazzino SET livelloScorte = (livelloScorte + ?)  WHERE id = ?";

		PreparedStatement ps = null;
		try {
			ps = ConnectionManager.getConnection().prepareStatement(sqlUPDATE);
			ps.setInt(1, addedScorte);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void decreaseScorte(Magazzino magazzino) {

		decreaseMagazzino(magazzino.getId(), magazzino.getEditScorte());

	}

	private void decreaseMagazzino(int id, int subtractedScorte) {

		String sqlUPDATE = "UPDATE magazzino SET livelloScorte = (livelloScorte - ?)  WHERE id =  ?";

		PreparedStatement ps = null;
		try {
			ps = ConnectionManager.getConnection().prepareStatement(sqlUPDATE);
			ps.setInt(1, subtractedScorte);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int controlloScorte(Magazzino magazzino) {

		int valoreScorte = valoreAttualeScorte(magazzino.getId());
		return valoreScorte;

	}

	private int valoreAttualeScorte(int id) {

		PreparedStatement ps = null;
		int valoreScorte = 0;
		ResultSet rs = null;
		String sqlSELECT = "SELECT * FROM magazzino WHERE id = ? ";

		try {
			ps = ConnectionManager.getConnection().prepareStatement(sqlSELECT);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				valoreScorte = rs.getInt(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valoreScorte;

	}

	@Override
	public int livelloScorteMinime(Magazzino magazzino) {

		int livelloMinScorte = valoreMinimoScorte(magazzino.getId());
		return livelloMinScorte;
	}

	private int valoreMinimoScorte(int id) {

		PreparedStatement ps = null;
		int valoreMinScorte = 0;
		ResultSet rs = null;
		String sqlSELECT = "SELECT * FROM magazzino WHERE id = ? ";

		try {
			ps = ConnectionManager.getConnection().prepareStatement(sqlSELECT);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				valoreMinScorte = rs.getInt(5);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valoreMinScorte;

	}

}