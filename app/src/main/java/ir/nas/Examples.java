package ir.nas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import ir.nas.model.Author;
import ir.nas.model.Book;
import ir.nas.model.Profile;
import ir.nas.model.Publisher;
import ir.nas.model.embeddable.Address;
import ir.nas.model.enums.CompanyType;

public final class Examples
{
    public final Address addressTehran = Address.builder()
            .country("Iran")
            .province("Tehran")
            .city("Tehran")
            .postalCode("1234567890")
            .build();

    public final Address addressIsfahan = Address.builder()
            .country("Iran")
            .province("Isfahan")
            .city("Isfahan")
            .postalCode("9876543210")
            .build();

    public final Address addressShiraz = Address.builder()
            .country("Iran")
            .province("Fars")
            .city("Shiraz")
            .postalCode("1122334455")
            .build();

    public final Address addressMashhad = Address.builder()
            .country("Iran")
            .province("Khorasan Razavi")
            .city("Mashhad")
            .postalCode("5544332211")
            .build();

    public final Address addressValiasr = Address.builder()
            .country("Iran")
            .province("Tehran")
            .city("Tehran")
            .postalCode("6677889900")
            .build();

    public final Address addressMotehari = Address.builder()
            .country("Iran")
            .province("Tehran")
            .city("Tehran")
            .postalCode("9988776655")
            .build();

    public final Publisher publisher1 = Publisher.builder()
            .companyName("Danesh Publications")
            .email("info@danesh-pub.ir")
            .nationalId("1234567890")
            .companyType(CompanyType.PRIVATE_JOINT_STOCK)
            .registerDate(LocalDate.of(2006, 5, 1))
            .website("www.danesh-pub.ir")
            .address(addressTehran)
            .build();

    public final Publisher publisher2 = Publisher.builder()
            .companyName("Aftab Publications")
            .email("info@aftab-pub.ir")
            .nationalId("9876543210")
            .companyType(CompanyType.LIMITED_LIABILITY)
            .registerDate(LocalDate.of(2011, 10, 7))
            .website("www.aftab-pub.ir")
            .address(addressIsfahan)
            .build();

    public final Author author1 = Author.builder()
            .firstName("Ali")
            .lastName("Rezaee")
            .phoneNumber("09121234567")
            .age(45)
            .address(addressValiasr)
            // .publisher(publisher1)
            .build();

    public final Author author2 = Author.builder()
            .firstName("Sara")
            .lastName("Karimi")
            .phoneNumber("09129876543")
            .age(38)
            .address(addressShiraz)
            // .publisher(publisher2)
            .build();

    public final Author author3 = Author.builder()
            .firstName("Mohammad")
            .lastName("Norouzi")
            .phoneNumber("09123334455")
            .age(52)
            .address(addressMashhad)
            // .publisher(publisher2)
            .build();

    public final Author author4 = Author.builder()
            .firstName("Narges")
            .lastName("Ahmadi")
            .phoneNumber("09127778899")
            .age(29)
            .address(addressMotehari)
            // .publisher(publisher2)
            .build();

    public final Profile profile1 = Profile.builder()
            .biography(
                    "PhD in Software Engineering from University of Tehran with 20 years of teaching experience. Author of several best-selling programming books.")
            .email("a.rezaee@email.com")
            .username("alirezaee")
            .password("Reza@1234")
            // .author(author1)
            .build();

    public final Profile profile2 = Profile.builder()
            .biography(
                    "Graduate in Persian Literature and bestselling fiction author. Winner of the National Book Award 2020.")
            .email("s.karimi@email.com")
            .username("sarak")
            .password("Sara#5678")
            // .author(author2)
            .build();

    public final Profile profile3 = Profile.builder()
            .biography(
                    "Researcher in Iranian history and culture. Published over 30 academic papers on ancient Persian civilization.")
            .email("m.norouzi@email.com")
            .username("mohammadn")
            .password("Moha*9012")
            // .author(author3)
            .build();

    public final Profile profile4 = Profile.builder()
            .biography(
                    "Graduate in Psychology and interested in social stories. First-time author with a unique perspective on human emotions.")
            .email("n.ahmadi@email.com")
            .username("narges_a")
            .password("Narges!3456")
            // .author(author4)
            .build();

    public final Book book1 = Book.builder()
            .title("Java Programming Basics")
            .ISBN("978-964-123-001-1")
            .price(new BigDecimal("350000.00"))
            // .publisher(publisher1)
            // .authors(new ArrayList<>(Arrays.asList(author1)))
            .build();

    public final Book book2 = Book.builder()
            .title("Data Structures and Algorithms")
            .ISBN("978-964-123-002-9")
            .price(new BigDecimal("480000.00"))
            // .publisher(publisher1)
            // .authors(new ArrayList<>(Arrays.asList(author1, author2)))
            .build();

    public final Book book3 = Book.builder()
            .title("Secrets of a Rainy Night")
            .ISBN("978-600-456-101-5")
            .price(new BigDecimal("250000.00"))
            // .publisher(publisher2)
            // .authors(new ArrayList<>(Arrays.asList(author2, author4)))
            .build();

    public final Book book4 = Book.builder()
            .title("Wordless Melodies")
            .ISBN("978-600-456-102-3")
            .price(new BigDecimal("190000.00"))
            // .publisher(publisher2)
            // .authors(new ArrayList<>(Arrays.asList(author3)))
            .build();

    public Examples()
    {
        // // Authors (set profiles)
        // author1.setProfile(profile1);
        // author2.setProfile(profile2);
        // author3.setProfile(profile3);
        // author4.setProfile(profile4);

        // // Authors (set books)
        // author1.setBooks(new ArrayList<>(Arrays.asList(book1, book2)));
        // author2.setBooks(new ArrayList<>(Arrays.asList(book2, book3)));
        // author3.setBooks(new ArrayList<>(Arrays.asList(book4)));
        // author4.setBooks(new ArrayList<>(Arrays.asList(book3)));

        // // Publishers (set books)
        // publisher1.setBooks(new ArrayList<>(Arrays.asList(book1, book2)));
        // publisher2.setBooks(new ArrayList<>(Arrays.asList(book3, book4)));

        // // Publishers (set authors)
        // publisher1.setAuthors(new ArrayList<>(Arrays.asList(author1)));
        // publisher2.setAuthors(new ArrayList<>(Arrays.asList(author2, author3, author4)));
    }
}
