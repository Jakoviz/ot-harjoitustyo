/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetwars.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import sun.security.util.Password;

/**
 *
 * @author jaakkpaa
 */
public class PlayerDao implements Dao<Player, String> {
	private Database database;
			
	public PlayerDao(Database database) {
		this.database = database;
	}
		
    public Player findOne(String username) throws SQLException, Exception {
        try (Connection conn = database.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
				"Select * FROM Player WHERE username = ?");
			stmt.setString(1, username);
			ResultSet result = stmt.executeQuery();
			if (!result.next()) {
				throw new Exception("Wrong username.");
			}
			return new Player(result.getString("username"), result.getString("password"),
					result.getInt("points"), result.getInt("level"));
		}
    }

    public void saveOrUpdate(Player player) throws SQLException, Exception {
        try (Connection conn = database.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
				"SELECT * FROM Player WHERE username = ?");
			stmt.setString(1, player.getUsername());
			ResultSet result = stmt.executeQuery();
			if (!result.next()) {
				stmt = conn.prepareStatement(
					"INSERT INTO Player (username, password, points, level) VALUES (?, ?, ?, ?)");
				stmt.setString(1, player.getUsername());
				stmt.setString(2, player.getPassword());
				stmt.setInt(3, player.getPoints());
				stmt.setInt(4, player.getLevel());
				stmt.executeUpdate();
				stmt = conn.prepareStatement(
					"SELECT * FROM Player WHERE username = ?");
				stmt.setString(1, player.getUsername());
				result = stmt.executeQuery();
			}
			if(!result.next()) {
				throw new Exception("Saving player failed.");
			}
        }
    }
}