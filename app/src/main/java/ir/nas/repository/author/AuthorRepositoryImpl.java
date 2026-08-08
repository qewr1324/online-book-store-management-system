package ir.nas.repository.author;

import java.util.Optional;

import ir.nas.model.Author;
import ir.nas.util.HibernateUtil;
import jakarta.persistence.TypedQuery;

public class AuthorRepositoryImpl extends AuthorRepository
{
    @Override
    public Optional<Author> findByFirstName(final String firstName)
    {
        final String FIND_AUTHOR_BY_FIRST_NAME_QUERY_STRING = "FROM Author a WHERE a.firstName = :author_firstname";
        return Optional.ofNullable(HibernateUtil.startWithQuery(em -> {

            TypedQuery<Author> findedAuthor = em.createQuery(
                    FIND_AUTHOR_BY_FIRST_NAME_QUERY_STRING,
                    Author.class);

            findedAuthor.setParameter("author_firstname", firstName);
            return findedAuthor.getSingleResult();

        }));
    }

    @Override
    public Optional<Author> findByLastName(String lastName)
    {
        final String FIND_AUTHOR_BY_LAST_NAME_QUERY_STRING = "FROM Author a WHERE a.lastName = :author_lastname";
        return Optional.ofNullable(HibernateUtil.startWithQuery(em -> {

            TypedQuery<Author> findedAuthor = em.createQuery(
                    FIND_AUTHOR_BY_LAST_NAME_QUERY_STRING,
                    Author.class);

            findedAuthor.setParameter("author_lastname", lastName);
            return findedAuthor.getSingleResult();

        }));
    }

    @Override
    public Optional<Author> findByPhoneNumber(String phoneNumber)
    {
        final String FIND_AUTHOR_BY_PHONE_NUMBER_QUERY_STRING = "FROM Author a WHERE a.phoneNumber = :author_phonenumber";
        return Optional.ofNullable(HibernateUtil.startWithQuery(em -> {

            TypedQuery<Author> findedAuthor = em.createQuery(
                    FIND_AUTHOR_BY_PHONE_NUMBER_QUERY_STRING,
                    Author.class);

            findedAuthor.setParameter("author_phonenumber", phoneNumber);
            return findedAuthor.getSingleResult();

        }));
    }

    @Override
    public Author updateSetter(Author src, Author target)
    {
        src.setFirstName(target.getFirstName());
        src.setLastName(target.getLastName());
        src.setPhoneNumber(target.getPhoneNumber());

        src.getAddress().setCountry(target.getAddress().getCountry());
        src.getAddress().setProvince(target.getAddress().getProvince());
        src.getAddress().setCity(target.getAddress().getCity());
        src.getAddress().setPostalCode(target.getAddress().getPostalCode());

        return src;
    }
}
