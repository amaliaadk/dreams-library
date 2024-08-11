package `gks-u`

class Staff(val name: String) {
    companion object {
        fun inputStaff(): Staff {
            print("Enter Staff Name : ")
            val name = readLine()!!.toString()
            return Staff(name)
        }
    }
}