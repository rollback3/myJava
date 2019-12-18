package backend.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.interfaces.IUserServices;
import common.javabeans.Utente;

public class UserServices implements IUserServices {

	@Override
	public void registraUtente(Utente utente) {

		insInDBUser(utente.getNome(), utente.getCognome(), utente.getVia(), utente.getEmail(), utente.getUserName(),
				utente.getPassword());

	}

	private static void insInDBUser(String nome, String cognome, String via, String email, String username,
			String password) {

		String sqlInsert = ("INSERT INTO utenti(nome, cognome, via, email, username, password)"
				+ "VALUES(?, ?, ?, ?, ?, ?)");
		PreparedStatement ps = null;
		try {
			ps = ConnectionManager.getConnection().prepareStatement(sqlInsert);
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, via);
			ps.setString(4, email);
			ps.setString(5, username);
			ps.setString(6, password);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean login(String username, String password) {

		String passFound = passwordFinder(username);

		return passwordMatching(passFound, password);
	}

	public String passwordFinder(String username) {

		String password = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectPassword = "SELECT password FROM utenti WHERE username = ?";
		try {
			ps = ConnectionManager.getConnection().prepareStatement(selectPassword);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				password = rs.getString("PASSWORD");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
	}

	public boolean passwordMatching(String passFound, String passSent) {
		boolean res = false;
		if (passFound != null && passSent != null) {
			// metodo .equals non è nullSafe. In caso passFound fosse null >
			// nullPointerException. Evitato con l'if su != null
			if (passFound.equals(passSent)) {
				res = true;
			}
		}
		return res;
	}

}
