package ir.nas.service;

import java.util.List;

import ir.nas.exception.repository.ModelNotFoundException;
import ir.nas.model.Author;
import ir.nas.repository.author.AuthorRepository;
import ir.nas.repository.author.AuthorRepositoryImpl;
import ir.nas.util.Validation;

public final class AuthorService
{
    private final AuthorRepository aRepository;

    public AuthorService(final AuthorRepositoryImpl pRepository)
    {
        this.aRepository = pRepository;
    }

    private final void validateAuthor(final Author auhtor)
    {
        final int PHONE_NUMBER_LENGTH = 11;
        Validation.of()
                .requireNotNull(auhtor)
                .requireString(auhtor.getFirstName())
                .requireString(auhtor.getLastName())
                .requireString(auhtor.getPhoneNumber())
                .requireNotNegative(auhtor.getAge())
                .requireTrueLength(auhtor.getPhoneNumber(), PHONE_NUMBER_LENGTH)
                .requireNotNull(auhtor.getAddress())
                .requireString(auhtor.getAddress().getCountry())
                .requireString(auhtor.getAddress().getProvince())
                .requireString(auhtor.getAddress().getCity())
                .requireString(auhtor.getAddress().getPostalCode())
                .validate();
    }

    private final void validateAuthorId(final Long id)
    {
        Validation.of()
                .requireNotNegative(id)
                .validate();
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
