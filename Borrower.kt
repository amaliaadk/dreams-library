package `gks-u`

class Borrower(
    var nim: String,
    var name: String,
    var major: String,
    var cls: String,
    var year: Int
) {

    val borrowedBook = mutableListOf<Book>()

    fun showData() {
        println("\n\n----- DATA ACCOUNT-----")
        println("NIM\t\t\t\t: $nim")
        println("Name\t\t\t: $name")
        println("Major\t\t\t: $major")
        println("Class\t\t\t: $cls")
        println("Year of Entry\t: $year")
    }

    fun borrowBook(book: Book, listBooks: MutableList<Book>) {
        if (book in listBooks) {
            borrowedBook.add(book)
            listBooks.remove(book)
            println("$name borrows a book '${book.title}'")
        } else {
            println("Book '${book.title}' not available.")
        }
    }

    fun returnBook(book: Book, listBook: MutableList<Book>) {
        if (book in borrowedBook) {
            borrowedBook.remove(book)
            listBook.add(book)
            println("$name returns the book '${book.title}'")
        } else {
            println("$name did not borrow the book '${book.title}'")
        }
    }

    fun showInfo() {
        println("\n\n----- Borrower Information -----")
        println("Name\t\t\t: $name")
        println("NIM\t\t\t\t: $nim")
        println("Major\t\t\t: $major")
        println("Borrowed Books\t: ${borrowedBook.joinToString { it.title }}")
    }

    companion object {
        fun inputBorrower(): Borrower {
            print("\nEnter NIM : ")
            val nim = readLine()!!.toString()
            print("Enter Name : ")
            val name = readLine()!!.toString()
            print("Enter Major : ")
            val major = readLine()!!.toString()
            print("Enter Class : ")
            val cls = readLine()!!.toString()
            print("Enter Entry Year : ")
            val year = readLine()!!.toInt()
            return Borrower(nim, name, major, cls, year)
        }
    }
}
