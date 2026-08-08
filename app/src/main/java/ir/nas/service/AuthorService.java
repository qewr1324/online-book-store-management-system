package ir.nas.service;

import java.util.List;

import ir.nas.exception.repository.ModelNotFoundException;
import ir.nas.model.Author;
import ir.nas.repository.author.AuthorRepository;
import ir.nas.repository.author.AuthorRepositoryImpl;

public final class AuthorService
{
    private final AuthorRepository aRepository;

    public AuthorService(final AuthorRepositoryImpl pRepository)
    {
        this.aRepository = pRepository;
    }

    private final void validateAuthor(final Author auhtor)
    {
        // TODO validate
    }

    private final void validateAuthorId(final Long id)
    {
        // TODO validate
    }

    public final Author addAuthor(final Author auhtor)
    {
        this.validateAuthor(auhtor);
        return this.aRepository.create(auhtor);
    }

    public final Author findAuthorById(final Long id)
    {
        this.validateAuthorId(id);
        return this.aRepository.findById(id).orElseThrow(() -> {
            throw new ModelNotFoundException("Author Not Found By This Id [%d]".formatted(id));
        });
    }

    public final Author updateAuthor(final Author auhtor)
    {
        this.validateAuthor(auhtor);
        return this.aRepository.update(auhtor);
    }

    public final Author deleteAuthor(final Long id)
    {
        this.validateAuthorId(id);
        return this.aRepository.delete(id);
    }

    public final List<Author> findAllAuthor()
    {
        return this.aRepository.findAll();
    }

    public final Author findAuthorByFirstname(final String firstName)
    {
        return this.aRepository.findAuthorByFirstName(firstName).orElseThrow(() -> {
            throw new ModelNotFoundException("Author Not Found By This First Name [%s]".formatted(firstName));
        });
    }

    public final Author findAuthorByLastName(final String lastName)
    {
        return this.aRepository.findAuthorByLastName(lastName).orElseThrow(() -> {
            throw new ModelNotFoundException("Author Not Found By This Last Name [%s]".formatted(lastName));
        });
    }

    public final Author findAuthorByPhoneNumber(final String phoneNumber)
    {
        return this.aRepository.findAuthorByPhoneNumber(phoneNumber).orElseThrow(() -> {
            throw new ModelNotFoundException("Author Not Found By This Phone Number [%s]".formatted(phoneNumber));
        });
    }
}
