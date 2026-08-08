package ir.nas.service;

import java.util.List;

import ir.nas.exception.repository.ModelNotFoundException;
import ir.nas.model.Book;
import ir.nas.repository.book.BookRepository;
import ir.nas.repository.book.BookRepositoryImpl;

public final class BookService
{
    private final BookRepository bRepository;

    public BookService(final BookRepositoryImpl bRepository)
    {
        this.bRepository = bRepository;
    }

    private final void validateBook(final Book book)
    {
        // TODO validate
    }

    private final void validateBookId(final Long id)
    {
        // TODO validate
    }

    public final Book addBook(final Book book)
    {
        this.validateBook(book);
        return this.bRepository.create(book);
    }

    public final Book findBookById(final Long id)
    {
        this.validateBookId(id);
        return this.bRepository.findById(id).orElseThrow(() -> {
            throw new ModelNotFoundException("Book Not Found By This Id [%d]".formatted(id));
        });
    }

    public final Book updateBook(final Book book)
    {
        this.validateBook(book);
        return this.bRepository.update(book);
    }

    public final Book deleteBook(final Long id)
    {
        this.validateBookId(id);
        return this.bRepository.delete(id);
    }

    public final List<Book> findAllBook()
    {
        return this.bRepository.findAll();
    }

    public final Book findBookByTitle(final String title)
    {
        return this.bRepository.findBookByTitle(title).orElseThrow(() -> {
            throw new ModelNotFoundException("Book Not Found By This Title [%s]".formatted(title));
        });
    }

    public final Book findBookByISBN(final String ISBN)
    {
        return this.bRepository.findBookByISBN(ISBN).orElseThrow(() -> {
            throw new ModelNotFoundException("Book Not Found By This ISBN [%s]".formatted(ISBN));
        });
    }
}
