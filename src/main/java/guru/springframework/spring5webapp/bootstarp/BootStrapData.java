package guru.springframework.spring5webapp.bootstarp;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("Wrox publishing company");
        publisher.setAddressLine1("5th st");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setZip("10124");

        publisherRepository.save(publisher);

        System.out.println("Publisher count :" + publisherRepository.count());

        Author eric= new Author("Eric","Evans");
        Book book = new Book("Domain Driven Design","121233");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(book);

        Author amit= new Author("Amit","Bhargava");
        Book book1 = new Book("My Stories","58246");
        amit.getBooks().add(book);
        book1.getAuthors().add(amit);
        authorRepository.save(amit);
        bookRepository.save(book1);
        System.out.println("Started in Bootstrap");
        System.out.println("Number of books:" + bookRepository.count());
    }
}
