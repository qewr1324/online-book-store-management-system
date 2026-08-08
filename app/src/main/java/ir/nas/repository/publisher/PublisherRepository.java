package ir.nas.repository.publisher;


import java.util.Optional;

import ir.nas.model.Publisher;
import ir.nas.repository.RepositoryImpl;

public abstract class PublisherRepository extends RepositoryImpl<Publisher, Long>
{
    public PublisherRepository()
    {
        super(Publisher.class);
    }
    
    public abstract Optional<Publisher> findPublisherByCompanyName(String companyName);
    
    public abstract Optional<Publisher> findPublisherByEmail(String email);
    
    public abstract Optional<Publisher> findPublisherByNationalId(String nationalId);
}
