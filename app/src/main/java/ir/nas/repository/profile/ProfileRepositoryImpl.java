package ir.nas.repository.profile;

import java.util.Optional;

import ir.nas.model.Profile;
import ir.nas.util.HibernateUtil;
import jakarta.persistence.TypedQuery;

public final class ProfileRepositoryImpl extends ProfileRepository
{
    @Override
    public Optional<Profile> findProfileByEmail(final String email)
    {
        final String FIND_PROFILE_BY_EMAIL_QUERY_STRING = "FROM Profile p WHERE p.email = :profile_email";
        return Optional.ofNullable(HibernateUtil.startWithQuery(em -> {

            TypedQuery<Profile> findedProfile = em.createQuery(
                    FIND_PROFILE_BY_EMAIL_QUERY_STRING,
                    Profile.class);

            findedProfile.setParameter("profile_email", email);
            return findedProfile.getSingleResult();

        }));
    }

    @Override
    public Optional<Profile> findProfileByUsername(final String username)
    {
        final String FIND_PROFILE_BY_USERNAME_QUERY_STRING = "FROM Profile p WHERE p.username = :profile_username";
        return Optional.ofNullable(HibernateUtil.startWithQuery(em -> {

            TypedQuery<Profile> findedProfile = em.createQuery(
                    FIND_PROFILE_BY_USERNAME_QUERY_STRING,
                    Profile.class);

            findedProfile.setParameter("profile_username", username);
            return findedProfile.getSingleResult();

        }));
    }

    @Override
    public Profile updateAllSetter(final Profile src, final Profile target)
    {
        src.setBiography(target.getBiography());
        src.setEmail(target.getEmail());
        src.setUsername(target.getUsername());
        src.setPassword(target.getPassword());

        return src;
    }
}
