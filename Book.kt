package `gks-u`

class Book(
    val title: String,
    val author: String,
    val pubYear: Int,
    val genre: String,
    val isbn: String,
    val code: String
) {
    fun showInfoBook() {
        println("\n\n----- Book Information -----")
        println("Title : $title")
        println("Author : $author")
        println("Publication Year : $pubYear")
        println("Genre : $genre")
        println("ISBN : $isbn")
        println("Book Code : $code")
    }

    companion object {
        fun inputBook(): Book {
            print("\nEnter Book Title : ")
            val title = readLine()!!.toString()
            print("Enter Book Author : ")
            val author = readLine()!!.toString()
            print("Enter Book Publication Year : ")
            val pubYear = readLine()!!.toInt()
            print("Enter Book Genre : ")
            val genre = readLine()!!.toString()
            print("Enter Book ISBN : ")
            val isbn = readLine()!!.toString()
            print("Enter Book Code : ")
            val code = readLine()!!.toString()
            return Book(title, author, pubYear, genre, isbn, code)
        }
    }
}