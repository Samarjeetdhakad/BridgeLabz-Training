package com.reflection.intermediatelevel.retrieveannotationsatruntime;
public class ReadAnnotation {

    public static void main(String[] args) {
        Class<Book> clss = Book.class;
        if (clss.isAnnotationPresent(Author.class)) {
            Author author = clss.getAnnotation(Author.class);
            System.out.println("Author Name " + author.name());
            System.out.println("Author Value" + author.value());
        }
    }
}