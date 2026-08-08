package ir.nas.service;

import java.util.List;

import ir.nas.exception.repository.ModelNotFoundException;
import ir.nas.model.Publisher;
import ir.nas.repository.publisher.PublisherRepository;
import ir.nas.repository.publisher.PublisherRepositoryImpl;
import ir.nas.util.Validation;

public final class PublisherService
{
    private final PublisherRepository pRepository;

    public PublisherService(final PublisherRepositoryImpl pRepository)
    {
        this.pRepository = pRepository;
    }

    private final void validatePublisher(final Publisher publisher)
    {
        Validation.of()
                .requireNotNull(publisher)
                .requireString(publisher.getCompanyName())
                .requireString(publisher.getEmail())
                .requireString(publisher.getNationalId())
                .requireString(publisher.getWebsite())
                .requireNotNull(publisher.getCompanyType())
                .requireNotNull(publisher.getRegisterDate())
                .requireNotNull(publisher.getAddress())
                .requireString(publisher.getAddress().getCountry())
                .requireString(publisher.getAddress().getProvince())
                .requireString(publisher.getAddress().getCity())
                .requireString(publisher.getAddress().getPostalCode())
                .validate();
    }

    private final void validatePublisherId(final Long id)
    {
        Validation.of()
                .requireNotNegative(id)
                .validate();
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
