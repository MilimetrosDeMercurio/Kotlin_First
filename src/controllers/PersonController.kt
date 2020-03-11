package controllers

import models.Person
import javax.swing.JOptionPane

abstract class PersonController(
    private var people: ArrayList<Person> = ArrayList()
) : Manage {


    override fun register(): Boolean {
        val person = new()
        getDataFromKeyboard(person, true)
        val personExits = people.find {
            it.id == person.id
        }
        personExits?.let {
            return false
        }
        people.add(person)
        return true
    }

    override fun modify(id: String): Boolean {
        people.forEach {
            if (it.id == id) {
                getDataFromKeyboard(it)
                return true
            }
        }
        return false
    }

    override fun delete(id: String): Boolean {
        people.forEachIndexed { index, person ->
            if (person.id == id) {
                people.removeAt(index)
                return true
            }
        }
        return false
    }

    override fun exists(id: String): Boolean {
        people.forEach {
            if (it.id == id) {
                return true
            }
        }
        return false
    }

    override fun show() {
        if (people.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nothing here")
        } else {
            var personData: String = ""
            people.forEach {
                personData += it

            }
            JOptionPane.showMessageDialog(null, personData)
        }
    }

    abstract fun new(): Person

    abstract fun getDataFromKeyboard(person: Person, new: Boolean = false)


}