package ir.nas.repository.author;

import java.util.Optional;

import ir.nas.model.Author;
import ir.nas.repository.RepositoryImpl;

public abstract class AuthorRepository extends RepositoryImpl<Author, Long>
{
    public AuthorRepository()
    {
        super(Author.class);
    }
    
    public abstract Optional<Author> findAuthorByFirstName(String firstName);
    
    public abstract Optional<Author> findAuthorByLastName(String lastName);

    public abstract Optional<Author> findAuthorByPhoneNumber(String phoneNumber);
}
