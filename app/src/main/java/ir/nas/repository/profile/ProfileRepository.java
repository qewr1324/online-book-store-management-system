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

    public abstract Optional<Profile> findProfileByEmail(String email);

    public abstract Optional<Profile> findProfileByUsername(String username);
}
