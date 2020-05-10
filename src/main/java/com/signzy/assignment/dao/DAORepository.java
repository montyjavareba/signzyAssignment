package com.signzy.assignment.dao;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author amangupta
*/

public interface DAORepository<T, I> {
	/**
	 * create the <code>T</code>
	 *
	 * @param i
	 */
	public void create(T i);

	/**
	 * get the <code>T</code>
	 *
	 * @param i
	 * @return
	 */
	public T get(I i);

	/**
	 * update the <code>T</code>
	 *
	 * @param i
	 */
	public void update(T i);

	/**
	 * update the <code>T</code>
	 *
	 * @param i
	 */
	public void delete(I i);

	/**
	 * create the <code>T</code>
	 *
	 * @param i
	 */
	public default void create(List<T> i) {
		i.forEach(this::create);
	}

	/**
	 * get the <code>T</code>
	 *
	 * @param i
	 * @return
	 */
	public default List<T> get(List<I> i) {
		return i.stream().map(this::get).collect(Collectors.toList());
	}

	/**
	 * update the <code>T</code>
	 *
	 * @param i
	 */
	public default void update(List<T> i) {
		i.forEach(this::update);
	}

	/**
	 * update the <code>T</code>
	 *
	 * @param i
	 */
	public default void delete(List<I> i) {
		i.forEach(this::delete);
	}

}

