package models

class Patient(
    var birthPLace: String="",
    override var id: String="",
    override var firstName: String="",
    override var lastName: String="",
    override var gender: String="",
    override var: Int=0
): PersonImpl(){
    override fun toString(): String {
        return super.toString() + "Birth Place: $birthPlace"
    }

}