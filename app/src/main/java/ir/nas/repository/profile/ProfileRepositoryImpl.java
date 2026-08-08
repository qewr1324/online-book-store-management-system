package ir.nas.repository.profile;

import java.util.Optional;

import ir.nas.model.Profile;
import ir.nas.util.HibernateUtil;
import jakarta.persistence.TypedQuery;

public final class ProfileRepositoryImpl extends ProfileRepository
{
    @Override
    public Optional<Profile> findByEmail(final String email)
    {
        final String FIND_PROFILE_BY_EMAIL_QUERY_STRING = "FROM Profile b WHERE b.email = :profile_email";
        return Optional.ofNullable(HibernateUtil.startWithQuery(em -> {

            TypedQuery<Profile> findedProfile = em.createQuery(
                    FIND_PROFILE_BY_EMAIL_QUERY_STRING,
                    Profile.class);

            findedProfile.setParameter("profile_email", email);
            return findedProfile.getSingleResult();

        }));
    }

    @Override
    public Optional<Profile> findByUsername(final String username)
    {
        final String FIND_PROFILE_BY_USERNAME_QUERY_STRING = "FROM Profile b WHERE b.username = :profile_username";
        return Optional.ofNullable(HibernateUtil.startWithQuery(em -> {

            TypedQuery<Profile> findedProfile = em.createQuery(
                    FIND_PROFILE_BY_USERNAME_QUERY_STRING,
                    Profile.class);

            findedProfile.setParameter("profile_username", username);
            return findedProfile.getSingleResult();

        }));
    }

    @Override
    public Profile updateSetter(final Profile src, final Profile target)
    {
        src.setBiography(target.getBiography());
        src.setEmail(target.getEmail());
        src.setUsername(target.getUsername());
        src.setPassword(target.getPassword());

        return src;
    }
}
