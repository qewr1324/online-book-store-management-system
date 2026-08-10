package ir.nas.repository.book;

import java.util.Optional;

import ir.nas.model.Book;
import ir.nas.util.HibernateUtil;
import jakarta.persistence.TypedQuery;

public final class BookRepositoryImpl extends BookRepository
{
    @Override
    public Optional<Book> findBookByISBN(final String ISBN)
    {
        final String FIND_BOOK_BY_ISBN_QUERY_STRING = "FROM Book b WHERE b.ISBN = :book_isbn";
        return Optional.ofNullable(HibernateUtil.startWithQuery(em -> {

            TypedQuery<Book> findedBook = em.createQuery(
                    FIND_BOOK_BY_ISBN_QUERY_STRING,
                    Book.class);

            findedBook.setParameter("book_isbn", ISBN);
            return findedBook.getSingleResult();

        }));
    }

    @Override
    public Optional<Book> findBookByTitle(final String title)
    {
        final String FIND_BOOK_BY_ISBN_QUERY_STRING = "FROM Book b WHERE b.title = :book_title";
        return Optional.ofNullable(HibernateUtil.startWithQuery(em -> {

            TypedQuery<Book> findedBook = em.createQuery(
                    FIND_BOOK_BY_ISBN_QUERY_STRING,
                    Book.class);

            findedBook.setParameter("book_title", title);
            return findedBook.getSingleResult();

        }));
    }

    @Override
    public Book updateAllSetter(final Book src, final Book target)
    {
        src.setTitle(target.getTitle());
        src.setISBN(target.getISBN());
        src.setPrice(target.getPrice());

        src.setAuthors(target.getAuthors());
        src.setPublisher(target.getPublisher());

        return src;
    }
}
