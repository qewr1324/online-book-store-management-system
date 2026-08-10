-- Active: 1780413880560@@127.0.0.1@5432@arash
CREATE DATABASE online_book_store_management_system;

DROP DATABASE online_book_store_management_system;

SELECT * FROM authors;

SELECT * FROM books;

SELECT * FROM publishers;

SELECT bo.*, au.first_name || ' ' || au.last_name
FROM books bo
    INNER JOIN authors au ON bo.id = au.book_id;

-- books, authors(book_id), profiles(author_id), publishers(author_id)