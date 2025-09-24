package com.sheridan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestInventoryManagement {

    @Test
    public void testForAddingNewBookToInventoryIfBookExists(){
        InventoryManagement manager = new InventoryManagement();
        Book book = new Book("Goosebumps", "Scary stories for kids", "Some Author", "1002");
        assertTrue(manager.addNewBook(book));
    };
    @Test
    public void testForAddingBookToInventoryThatIsAlreadyInInventory(){
        InventoryManagement manager = new InventoryManagement();
        Book book = new Book("Goosebumps", "Scary stories for kids", "Some Author", "1002");
        manager.addNewBook(book);
        assertFalse(manager.addNewBook(book));
    };    
    @Test
    public void testForAddingNewBookToInventoryIfBookDoesNotExist(){
        InventoryManagement manager = new InventoryManagement();
        Book book = null;
        assertFalse(manager.addNewBook(book));
    };    
    //Get book
    @Test
    public void testForSearchingABookThatExists(){
        InventoryManagement manager = new InventoryManagement();
        Book book = new Book("Goosebumps", "Scary stories for kids", "Some Author", "1002");
        manager.addNewBook(book);
        Book retrievedBook = manager.searchForBook(book.getIsbn());
        assertNotNull(retrievedBook);
        assertEquals(retrievedBook.getTitle(), "Goosebumps");
    }
    @Test
    public void testForSearchingABookThatDoesNotExist(){
        InventoryManagement manager = new InventoryManagement();
        Book book = new Book("Goosebumps", "Scary stories for kids", "Some Author", "1002");
        manager.addNewBook(book);
        Book retrievedBook = manager.searchForBook("1083838");
        assertNull(retrievedBook);
    }    
    //Update a book ==> method updateBook
    @Test
      public void testForUpdatingAnyFieldOfABookInInventory(){
        InventoryManagement manager = new InventoryManagement();
        Book book = new Book("Goosebumps", "Scary stories for kids", "Some Author", "1002");
        manager.addNewBook(book);
        book.setAuthor( "Various Authors");
        assertTrue(manager.updateBook(book));
        assertEquals(manager.searchForBook(book.getIsbn()).getAuthor(),"Various Authors");

    }   
    //delete a book
    @Test
    public void testForDeletingBookFromInventory(){
        InventoryManagement manager = new InventoryManagement();
        Book book = new Book("Goosebumps", "Scary stories for kids", "Some Author", "1002");
        manager.addNewBook(book);
        assertTrue(manager.deleteBook(book));        
    }
}
