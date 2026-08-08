package ir.nas.repository.profile;

import java.util.Optional;

import ir.nas.model.Profile;
import ir.nas.repository.RepositoryImpl;

public abstract class ProfileRepository extends RepositoryImpl<Profile, Long>
{
    public ProfileRepository()
    {
        super(Profile.class);
    }

    public abstract Optional<Profile> findByEmail(String email);

    public abstract Optional<Profile> findByUsername(String username);
}
