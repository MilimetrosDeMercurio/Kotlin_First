package models

interface Person{
    var id: String
    var firstName: String
    var lastName: String
    var gender: String
    var age: Int
}

open class PersonImpl(
    override var id: String="",
    override var firstName: String="",
    override var lastName: String="",
    override var gender: String="",
    override var: Int=0
): Person{

    override fun toString(): String {
        return """
            ID: $id
            Name: $firstName $lastName
            Gender: $gender
            Age: $age
            """.trimIndent()
    }


}