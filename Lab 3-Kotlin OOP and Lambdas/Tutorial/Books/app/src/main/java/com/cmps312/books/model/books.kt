package com.cmps312.books.model

open class Book(var name: String, var author: String, var yearOfPublication: Int) {
    override fun toString(): String {
        return """
            
            Name   : $name
            Author : $author
            Year   : $yearOfPublication
        """.trimIndent()
    }
}

class PaperBook(
    name: String,
    author: String,
    yearOfPublication: Int,
    var publisher: String,
    var isbn: String) : Book(name, author, yearOfPublication) {

    override fun toString(): String {
        return """
                ${super.toString()}
    Publisher   :$publisher
    Isbn : $isbn
        """.trimIndent()
    }
}

class AudioBook(
    name: String,
    author: String,
    yearOfPublication: Int,
    var size: Int,
    var length: Int,
    var artistName: String) : Book(name, author, yearOfPublication) {

    override fun toString(): String {
        return """
            
            ${super.toString()}
            Size   :$size
            Length : $length
            Artist : $artistName
        """.trimIndent()
    }
}


fun main() {

    var book = Book("The Seven Habits of Effective People", "Stephens", 1989)

    var audioBook1 = AudioBook(
        "The Seven Habits of Effective People V1",
        "Stephens",
        1989,
        1222,
        100,
        "Ali")
    var audioBook2 = AudioBook(
        "The Seven Habits of Effective People V2",
        "Stephens",
        1990,
        1222,
        100,
        "Ali")

    var paperBook1 = PaperBook(
        "The Seven Habits of Effective People V3",
        "Stephens",
        1992,
        "Amazon",
        "100002",
        )
    var paperBook2 = PaperBook(
        "The Seven Habits of Effective People V2",
        "Stephens",
        1995,
        "Oriely",
        "100001")

    //collections
    var books = arrayListOf<Book>(audioBook1, audioBook2)
    books.add(paperBook1)
    books.add(paperBook2)

    //display them using the foreach
    books.forEach(::println)  // little bit advance

    books.forEach {println(it)}

    books.forEach { book-> println(book)  }




}