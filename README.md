# 📚 Online Book Store Management System

# System Requirement

- Java 25+
- Gradle 9.7.0+
- VSCode or IntelliJ

# How To Use

```bash
# Clone Project In Github: SSH
git clone git@github.com:qewr1324/online-book-store-management-system

# or: HTTPS
git clone https://github.com/qewr1324/online-book-store-management-system.git

# Go TO Project
cd online-book-store-management-system

# Install Dependencies: gradle
gradle build

# or: gradle wrapper
./gradlew build

# Run Application
gradle run
```

# Project Structure

```text
online-book-store-management-system
├─ README.md
├─ app
│  └─ src
│     ├─ main
│     │  ├─ java
│     │  │  └─ ir
│     │  │     └─ nas
│     │  │        ├─ App.java
│     │  │        ├─ Examples.java
│     │  │        ├─ exception
│     │  │        │  ├─ BusinessException.java
│     │  │        │  ├─ db
│     │  │        │  │  └─ DBConnectionException.java
│     │  │        │  ├─ repository
│     │  │        │  │  └─ ModelNotFoundException.java
│     │  │        │  └─ util
│     │  │        │     └─ InvalidInputException.java
│     │  │        ├─ model
│     │  │        │  ├─ Author.java
│     │  │        │  ├─ Book.java
│     │  │        │  ├─ Profile.java
│     │  │        │  ├─ Publisher.java
│     │  │        │  ├─ base
│     │  │        │  │  └─ BaseModel.java
│     │  │        │  ├─ embeddable
│     │  │        │  │  └─ Address.java
│     │  │        │  └─ enums
│     │  │        │     └─ CompanyType.java
│     │  │        ├─ repository
│     │  │        │  ├─ Repository.java
│     │  │        │  ├─ RepositoryImpl.java
│     │  │        │  ├─ author
│     │  │        │  │  ├─ AuthorRepository.java
│     │  │        │  │  └─ AuthorRepositoryImpl.java
│     │  │        │  ├─ book
│     │  │        │  │  ├─ BookRepository.java
│     │  │        │  │  └─ BookRepositoryImpl.java
│     │  │        │  ├─ profile
│     │  │        │  │  ├─ ProfileRepository.java
│     │  │        │  │  └─ ProfileRepositoryImpl.java
│     │  │        │  └─ publisher
│     │  │        │     ├─ PublisherRepository.java
│     │  │        │     └─ PublisherRepositoryImpl.java
│     │  │        ├─ service
│     │  │        │  ├─ AuthorService.java
│     │  │        │  ├─ BookService.java
│     │  │        │  ├─ ProfileService.java
│     │  │        │  └─ PublisherService.java
│     │  │        └─ util
│     │  │           ├─ ColorCMD.java
│     │  │           ├─ HibernateUtil.java
│     │  │           └─ Validation.java
│     │  └─ resources
│     │     ├─ META-INF
│     │     │  └─ persistence.xml
│     │     └─ db
│     │        └─ db.sql
│     └─ test
│        ├─ java
│        │  └─ ir
│        │     └─ nas
│        │        └─ AppTest.java
│        └─ resources
│           └─ META-INF
│              └─ persistence.xml
├─ gradle
│  ├─ libs.versions.toml
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradle.properties
├─ gradlew
└─ gradlew.bat
```

> ---
>
> Scenario
> You are developing a simple Online Book Store Management System using
> Hibernate/JPA.
> The system manages:
>
>- Books
>- Authors
>- Publishers
>- Author Profiles
>
> Each Book contains:
>
>- title
>- ISBN
>- price
>
> Each Author has a Profile containing:
>
>- biography
>- email
>
> The system must represent the relationships between these entities according to
> the business requirements.
> The system should allow navigation between related entities where required.
>
> ## Domain Model and Association Analysis
>
> ### 1.1 Create the Entity Classes
>
> Design the following JPA entities with appropriate fields and annotations
> (tables, columns, etc.):
>
>- Book
>- Author
>- Publisher
>- Profile (author profile)
>
> ### 1.2 Analyse the Relationships
>
> Before implementing, determine for each relationship:
>
>- Role (what each side represents)
>- Directionality (unidirectional / bidirectional)
>- Cardinality (1:1, 1:N, N:1, N:M)
>- Owner side (the side that owns the foreign key or join table)
>- Inverse side (the side that uses mappedBy)
>
> Relationships derived from the scenario:
>
> #### 1. Author ↔ Profile
>
> Each author has exactly one profile, and each profile belongs to exactly one author.
> → One-to-One (bidirectional recommended)
>
> #### 2. Author ↔ Book
>
> Each author can write many books; each book can have one or more authors.
>
>- → Many-to-Many (bidirectional)
>
> #### 3. Publisher ↔ Book
>
> One publisher can publish many books; each book is published by exactly one publisher.
>
>- → Many-to-One
>
> (unidirectional from Book to Publisher, or bidirectional if needed)
>
> ## 3. JPA Association Mapping
>
> Implement the relationships using the appropriate JPA annotations:
>
>- @OneToOne
>- @OneToMany
>- @ManyToOne
>- @ManyToMany
>
> For bidirectional relationships:
>
>- Clearly identify the owner side (where the foreign key / join table is defined)
>- Use mappedBy on the inverse side
>- Explain why you chose each owner/inverse side
>
> After running Hibernate, examine the generated database schema and be able to:
>
>- Locate foreign keys
>- Locate junction (join) tables
>- Explain why a foreign key or a join table is used for each relationship
>
> ## 3. Persistence Layer and Transaction
>
> Management
>
> ### 3.1 Infrastructure
>
> Create a reusable persistence infrastructure:
>
>- A single EntityManagerFactory (created once)
>- A thread-local EntityManager or a utility class that provides an
>
> EntityManager
>
> ### 3.2 Transaction Handling
>
> Design a transaction management mechanism that:
>
>- Avoids code duplication
>- Handles begin(), commit(), and rollback() consistently
>
> ### 3.3 Repository Layer
>
> Implement a Repository for each entity or a generic repository that provides:
>
>- save(Entity) – persists a new entity
>- findById(Class, id) – retrieves an entity
>- update(Entity) – updates a detached or managed entity
>- delete(Entity) – removes an entity
>
> The repository must not contain business logic – only persistence operations.
>
> ## 4. Persistence Operations (Data Population)
>
> Store the following data in the database:
>
>- At least two different authors, each with a profile
>- At least one publisher
>- At least two books, with correct relationships to authors and the publisher
>
> Use:
>
>- EntityManager.persist()
>- Inside transactions
>
> Commit successfully
>
> After persisting, verify that:
>
>- Books, authors, publishers, and profiles are stored correctly
>- Association data (foreign keys / join tables) is correctly populated
>
> During code review, be prepared to explain:
>
>- How entities are persisted
>- How transactions work
>- Why transaction management is required
>- How Hibernate manages the persistence context
>
> ## 5. TDD and Unit Testing
>
> Use Test-Driven Development (Red → Green → Refactor) to write tests for
> the core behaviour.
>
> ### 5.1 Test Structure
>
> Every test must follow the:
> Arrange → Act → Assert pattern.
>
> ### 5.2 Required Tests
>
> Write unit tests that verify:
>
> - A book can be created correctly
> - The book contains the expected information
> - Relationships between objects are correctly established
> - Entities contain valid required information (e.g., non-null ISBN, positive price)
>
> Use the following JUnit assertions where appropriate:
>
> - assertEquals
> - assertTrue
> - assertFalse
> - assertNotNull
> - assertNull
>
> Also use:
>
> - @BeforeAll
> - @BeforeEach
> - @DisplayName
>
> Create at least:
>
>- One parameterised test using @CsvSource
>
> ## 6. Main Application
>
> Create a Main class that demonstrates the full system.
> Your program should:
>
> ### 1. Create the required entities
>
>- o At least 3 authors
>- o Their profiles
>- o 2 publisher
>- o 4 books
>
> ##### 1. Establish the required relationships
>
> ##### 2. Persist all objects into the database
>
> ##### 3. Retrieve one book by its ID
>
> ##### 4. Update some information of the retrieved book (for example: change its price)
>
> ##### 5. Save the changes
>
> ##### 6. Delete one book
>
> ##### 7. Display the created objects and their relationships (for example: print to console)
>
> ##### 8. Verify the final database state (by querying and showing results)
