package com.realdolmen.education;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class BookServiceTest {
    @Autowired(required = false)
    private BookService bookService;

    @Test
    public void bookServiceExists() {
        assertNotNull("You should create a book service in the application context", bookService);
    }

    @Test
    public void bookStoreNameIsFilledIn() throws Exception {
        assertEquals("Night's Watch Bookstore", bookService.getBookStoreName());
    }

    @Test
    public void bookStoreManagersAreCorrect() throws Exception {
        Iterator<String> iterator = bookService.getManagers().iterator();
        assertEquals("John Snow", iterator.next());
        assertEquals("Sansa Stark", iterator.next());
    }

    @Test
    public void findBookByIsbnIsCorrect() throws Exception {
        String title = bookService.findBookTitleByIsbn("0000000000001");
        assertEquals("A Game Of Thrones", title);
    }

    @Test
    public void findAllBooksReturnsAllBooks() throws Exception {
        assertEquals(3, bookService.findAllBooks().size());
    }
}
