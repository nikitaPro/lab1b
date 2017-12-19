package domain;

import java.util.List;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookRepositoryImpl implements BookRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Book getBook(Long id) {
		Book b = entityManager.find(Book.class, id);
		return b;
	}
	/**
	 * Method creates a new book
	 * @param bookEntity this book entity will be written in data base
	 * */
	public void createBook(Book bookEntity) {
		entityManager.persist(bookEntity);
	}
	/**
	 * Method deletes book
	 * @param bookEntity this book entity will be removed from data base
	 * @return true if it is ok, false in otherwise
	 * */
	public boolean removeBook(Book bookEntity) {
		if(bookEntity != null){
			entityManager.remove(bookEntity);
			return true;
		}
		return false;
	}
	/**
	 * Method reads all books from data base and return its like a <code>List&lt Book&gt</code>
	 * @return List of Books
	 * */
	@SuppressWarnings("unchecked")
	public List<Book> getBooks() {
		List<Book> books = entityManager.createQuery("SELECT b FROM Book b").getResultList();
		return books;
	}
}
