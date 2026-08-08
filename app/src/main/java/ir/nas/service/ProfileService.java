package ir.nas.service;

import java.util.List;

import ir.nas.exception.repository.ModelNotFoundException;
import ir.nas.model.Profile;
import ir.nas.repository.profile.ProfileRepository;
import ir.nas.repository.profile.ProfileRepositoryImpl;

public final class ProfileService
{
    private final ProfileRepository pRepository;

    public ProfileService(final ProfileRepositoryImpl pRepository)
    {
        this.pRepository = pRepository;
    }

    private final void validateProfile(final Profile profile)
    {
        // TODO validate
    }

    private final void validateProfileId(final Long id)
    {
        // TODO validate
    }

    public final Profile addProfile(final Profile profile)
    {
        this.validateProfile(profile);
        return this.pRepository.create(profile);
    }

    public final Profile findProfileById(final Long id)
    {
        this.validateProfileId(id);
        return this.pRepository.findById(id).orElseThrow(() -> {
            throw new ModelNotFoundException("Profile Not Found By This Id [%d]".formatted(id));
        });
    }

    public final Profile updateProfile(final Profile auhtor)
    {
        this.validateProfile(auhtor);
        return this.pRepository.update(auhtor);
    }

    public final Profile deleteProfile(final Long id)
    {
        this.validateProfileId(id);
        return this.pRepository.delete(id);
    }

    public final List<Profile> findAllProfile()
    {
        return this.pRepository.findAll();
    }

    public final Profile findAuthorByUsername(final String username)
    {
        return this.pRepository.findProfileByUsername(username).orElseThrow(() -> {
            throw new ModelNotFoundException("Profile Not Found By This Username [%s]".formatted(username));
        });
    }

    public final Profile findProfileByEmail(final String email)
    {
        return this.pRepository.findProfileByEmail(email).orElseThrow(() -> {
            throw new ModelNotFoundException("Profile Not Found By This Email [%s]".formatted(email));
        });
    }
}
