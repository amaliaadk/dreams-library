package `gks-u`

fun main() {
    val lib = Library("Dream's Library", "Jl. Merdeka No. 1")
    lib.addStaff(Staff("Admin"))  /* Add staff for initial login, & have to write "Admin" */
    lib.showMenu()
}
