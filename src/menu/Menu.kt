package menu

import controllers.DoctorController
import controllers.PatientController
import models.Doctor
import java.lang.NumberFormatException
import javax.swing.JOptionPane

object Menu {
    private val patientController = PatientController()
    private val doctorController = controllers.DoctorController()

    private fun selectedOptions(): Int{
        val options = """
            What you want to do?
            1. Manage Patient
            2. Manage Doctors
            3. Exit
        """.trimIndent()
        return try{
            Integer.parseInt(JOptionPane.showInputDialog(null, "Options"))
        }catch (e: NumberFormatException){
            return 0

        }
    }

    fun show(){
        val subMenu = subMenu()
        var option: Int
        do{
            option = selectedOptions()
            when(option){
                1 -> {
                    subMenu.entity = "patient"
                    subMenu.manager = patientController
                    subMenu.show()
                }
                2 -> {
                    subMenu.entity = "Doctor"
                    subMenu.manager = doctorController
                    subMenu.show()
                }
                0, 3 -> {
                    JOptionPane.showMessageDialog(null, "BYE")
                }
                else{
                    JOptionPane.showMessageDialog(null, "Bye")
                }
            }
        }while (option!=3 && option!=0)
    }
}