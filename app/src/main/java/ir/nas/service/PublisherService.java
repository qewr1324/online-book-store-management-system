package ir.nas.service;

import java.util.List;

import ir.nas.exception.repository.ModelNotFoundException;
import ir.nas.model.Publisher;
import ir.nas.repository.publisher.PublisherRepository;
import ir.nas.repository.publisher.PublisherRepositoryImpl;

public final class PublisherService
{
    private final PublisherRepository pRepository;

    public PublisherService(final PublisherRepositoryImpl pRepository)
    {
        this.pRepository = pRepository;
    }

    private final void validatePublisher(final Publisher publisher)
    {
        // TODO validate
    }

    private final void validatePublisherId(final Long id)
    {
        // TODO validate
    }

    public final Publisher addPublisher(final Publisher auhtor)
    {
        this.validatePublisher(auhtor);
        return this.pRepository.create(auhtor);
    }

    public final Publisher findPublisherById(final Long id)
    {
        this.validatePublisherId(id);
        return this.pRepository.findById(id).orElseThrow(() -> {
            throw new ModelNotFoundException("Author Not Found By This Id [%d]".formatted(id));
        });
    }

    public final Publisher updatePublisher(final Publisher auhtor)
    {
        this.validatePublisher(auhtor);
        return this.pRepository.update(auhtor);
    }

    public final Publisher deletePublisher(final Long id)
    {
        this.validatePublisherId(id);
        return this.pRepository.delete(id);
    }

    public final List<Publisher> findAllPublisher()
    {
        return this.pRepository.findAll();
    }

    public final Publisher findPublisherByCompanyName(final String comapnyName)
    {
        return this.pRepository.findPublisherByCompanyName(comapnyName).orElseThrow(() -> {
            throw new ModelNotFoundException("Publisher Not Found By This Company Name [%s]".formatted(comapnyName));
        });
    }

    public final Publisher findPublisherByEmail(final String email)
    {
        return this.pRepository.findPublisherByEmail(email).orElseThrow(() -> {
            throw new ModelNotFoundException("Publisher Not Found By This Email [%s]".formatted(email));
        });
    }

    public final Publisher findPublisherByNationalId(final String nationalId)
    {
        return this.pRepository.findPublisherByNationalId(nationalId).orElseThrow(() -> {
            throw new ModelNotFoundException("Publisher Not Found By This National Id [%s]".formatted(nationalId));
        });
    }
}
