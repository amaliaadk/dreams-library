package `gks-u`

open class Library(val name: String, val adrs: String) {

    var bookList = mutableListOf<Book>()
    val borrowerList = mutableListOf<Borrower>()
    val staffList = mutableListOf<Staff>()
    private var loggedInStaff: Staff? = null

    fun addBook(book: Book) {
        bookList.add(book)
        println("Book '${book.title}' has been added.")
    }

    fun addBorrower(borrower: Borrower) {
        borrowerList.add(borrower)
        println("Borrower '${borrower.name}'has been added.")
    }

    fun addStaff(staff: Staff) {
        staffList.add(staff)
        println("Staff '${staff.name}' has been added.")
    }

    fun loginStaff() {
        println("----- Login Staff -----")
        var staff: Staff?
        do {
            print("Enter Staff Name : ")
            val name = readLine()!!.toString()
            staff = staffList.find { it.name == name }
            if (staff != null) {
                loggedInStaff = staff
                println("Staff '${staff.name}' successfully logged in.")
            } else {
                println("Staff with name '$name' not found. Please try again..")
            }
        } while (staff == null)
    }

    fun logoutStaff() {
        loggedInStaff = null
        println("Staff successfully logged out.")
    }

    fun showMenu() {
        if (loggedInStaff == null) {
            loginStaff()
        }

        var repeat: String
        do {
            println("\n\n---- WELCOME TO SMART LIBRARY ----")
            println("1. Add Book")
            println("2. Add Borrower")
            println("3. Borrowing Books")
            println("4. Returning Books")
            println("5. Show Borrower Data")
            println("6. Logout Staff")
            println("7. All Logout")
            print("Select Menu : ")
            when (readLine()!!.toInt()) {
                1 -> {
                    val book = Book.inputBook()
                    addBook(book)
                }
                2 -> {
                    val borrower = Borrower.inputBorrower()
                    addBorrower(borrower)
                }
                3 -> {
                    if (borrowerList.isNotEmpty() && bookList.isNotEmpty()) {
                        print("\nEnter Borrower's NIM : ")
                        val nim = readLine()!!
                        val borrower = borrowerList.find { it.nim == nim }
                        if (borrower != null) {
                            println("Available Book List :")
                            bookList.forEachIndexed { index, book -> println("${index + 1}. ${book.title}") }
                            print("Enter the Book Number You Want to Borrow : ")
                            val index = readLine()!!.toInt() - 1
                            if (index in bookList.indices) {
                                borrower.borrowBook(bookList[index], bookList)
                            } else {
                                println("Invalid book number.")
                            }
                        } else {
                            println("Borrower with NIM '$nim' not found.")
                        }
                    } else {
                        println("Borrower list or empty book.")
                    }
                }
                4 -> {
                    if (borrowerList.isNotEmpty()) {
                        print("Enter Borrower's NIM : ")
                        val nim = readLine()!!
                        val borrower = borrowerList.find { it.nim == nim }
                        if (borrower != null) {
                            println("Daftar Buku Dipinjam:")
                            borrower.borrowedBook.forEachIndexed { index, book -> println("${index + 1}. ${book.title}") }
                            print("Enter the Book Number You Want to Return : ")
                            val index = readLine()!!.toInt() - 1
                            if (index in borrower.borrowedBook.indices) {
                                borrower.returnBook(borrower.borrowedBook[index], bookList)
                            } else {
                                println("Invalid book number.")
                            }
                        } else {
                            println("Borrower with NIM '$nim' not found.")
                        }
                    } else {
                        println("The borrower list is empty.")
                    }
                }
                5 -> {
                    if (borrowerList.isNotEmpty()) {
                        for (borrower in borrowerList) {
                            borrower.showData()
                            borrower.showInfo()
                        }
                    } else {
                        println("Borrower list is empty.")
                    }
                }
                6 -> {
                    logoutStaff()
                    loginStaff()
                }
                7 -> {
                    println("\n---- Thank you for using Smart Library! ----")
                    return
                }
                else -> println("\nInvalid selection. Please try again!")
            }
            print("\nBack to Main Menu [Y/N]? ")
            repeat = readLine()!!.toString()
        } while (repeat.equals("Y", ignoreCase = true))
        println("\n---- Thank you for using Smart Library! ----")
    }
}
