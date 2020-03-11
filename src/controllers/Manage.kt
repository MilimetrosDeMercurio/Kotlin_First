package controllers

interface Manage {

    fun register(): Boolean
    fun modify(id: String): Boolean
    fun delete(id: String): Boolean
    fun exists(id: String): Boolean
    fun show()
}