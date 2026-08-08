package ir.nas.repository.book;

import java.util.Optional;

import ir.nas.model.Book;
import ir.nas.repository.RepositoryImpl;

public abstract class BookRepository extends RepositoryImpl<Book, Long>
{
    public BookRepository()
    {
        super(Book.class);
    }
    
    public abstract Optional<Book> findByTitle(String title);
    
    public abstract Optional<Book> findByISBN(String ISBN);
}
