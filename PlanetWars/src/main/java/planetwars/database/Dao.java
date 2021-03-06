/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetwars.database;

import java.sql.SQLException;

/**
 * The interface determining how all Dao's should look like.
 * @author jaakkpaa
 */
public interface Dao<T, K> {
	T findOne(K key) throws SQLException, Exception;
	void saveOrUpdate(T element) throws SQLException, Exception;
	void createTableIfNotExist();
	void delete(K key) throws SQLException, Exception;
}
