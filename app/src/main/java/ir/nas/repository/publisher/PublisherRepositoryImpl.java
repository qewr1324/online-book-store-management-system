package ir.nas.repository.publisher;

import java.util.Optional;

import ir.nas.model.Publisher;
import ir.nas.util.HibernateUtil;
import jakarta.persistence.TypedQuery;

public class PublisherRepositoryImpl extends PublisherRepository
{
    @Override
    public Optional<Publisher> findPublisherByCompanyName(final String companyName)
    {
        final String FIND_PUBLISHER_BY_COMPANY_NAME_QUERY_STRING = "FROM Publisher p WHERE p.companyName = :publisher_companyname";
        return Optional.ofNullable(HibernateUtil.startWithQuery(em -> {

            TypedQuery<Publisher> findedPublisher = em.createQuery(
                    FIND_PUBLISHER_BY_COMPANY_NAME_QUERY_STRING,
                    Publisher.class);

            findedPublisher.setParameter("publisher_companyname", companyName);
            return findedPublisher.getSingleResult();

        }));
    }

    @Override
    public Optional<Publisher> findPublisherByEmail(final String email)
    {
        final String FIND_PUBLISHER_BY_EMAIL_QUERY_STRING = "FROM Publisher p WHERE p.email = :publisher_email";
        return Optional.ofNullable(HibernateUtil.startWithQuery(em -> {

            TypedQuery<Publisher> findedPublisher = em.createQuery(
                    FIND_PUBLISHER_BY_EMAIL_QUERY_STRING,
                    Publisher.class);

            findedPublisher.setParameter("publisher_email", email);
            return findedPublisher.getSingleResult();

        }));
    }

    @Override
    public Optional<Publisher> findPublisherByNationalId(final String nationalId)
    {
        final String FIND_PUBLISHER_BY_NATIONAL_ID_QUERY_STRING = "FROM Publisher p WHERE p.nationalId = :publisher_nationalid";
        return Optional.ofNullable(HibernateUtil.startWithQuery(em -> {

            TypedQuery<Publisher> findedPublisher = em.createQuery(
                    FIND_PUBLISHER_BY_NATIONAL_ID_QUERY_STRING,
                    Publisher.class);

            findedPublisher.setParameter("publisher_nationalid", nationalId);
            return findedPublisher.getSingleResult();

        }));
    }

    @Override
    public Publisher updateAllSetter(final Publisher src, final Publisher target)
    {
        src.setCompanyName(target.getCompanyName());
        src.setEmail(target.getEmail());
        src.setNationalId(target.getNationalId());
        src.setCompanyType(target.getCompanyType());
        src.setRegisterDate(target.getRegisterDate());
        src.setWebsite(target.getWebsite());

        src.getAddress().setCountry(target.getAddress().getCountry());
        src.getAddress().setProvince(target.getAddress().getProvince());
        src.getAddress().setCity(target.getAddress().getCity());
        src.getAddress().setPostalCode(target.getAddress().getPostalCode());

        return src;
    }
}
