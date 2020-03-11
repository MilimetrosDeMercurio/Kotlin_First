package controllers

import models.Patient
import models.Person
import java.awt.JobAttributes
import java.lang.IllegalStateException
import java.lang.NumberFormatException
import javax.swing.JOptionPane

class PatientController(): PersonController() {

    override fun new(): Person {
        return Patient()
    }

    override fun getDataFromKeyboard(person: Person, new: Boolean) {
        val newPerson = person as Patient
        try{
            if(new){
                newPerson.id = JOptionPane.showInputDialog((null, "Input patient ID")
            }
            newPerson.firstName = JOptionPane.showInputDialog(null, "Input patient firstName")
            newPerson.lastName = JOptionPane.showInputDialog(null, "Input patient lastName")
            newPerson.gender = JOptionPane.showInputDialog(null, "Input patient age")
            person.birthPLace = JOptionPane.showInputDialog(null, "Input patient birth place")

        }catch (e: IllegalStateException){
            throw e
        }
        var age = -1
        while (age<0 || age>100){
            try {
                age = Integer.parseInt(JOptionPane.showInputDialog(null, "Input patient age"))
                if(age<0 || age>100){
                    JOptionPane.showMessageDialog(null,"Corresponda a la edad")
                }

            }catch (e: IllegalStateException){
                throw e

            }catch (e: NumberFormatException){
                JOptionPane.showMessageDialog(null, "Age must be a number")
            }
        }
        newPerson.age = age
    }
}