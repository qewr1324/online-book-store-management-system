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
    
    public abstract Optional<Author> findByFirstName(String firstName);
    
    public abstract Optional<Author> findByLastName(String lastName);

    public abstract Optional<Author> findByPhoneNumber(String phoneNumber);
}
