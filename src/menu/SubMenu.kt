package menu

import java.lang.IllegalStateException
import java.lang.NumberFormatException
import javax.swing.JOptionPane

class SubMenu(var manager: Manage? = null, var entity: String = "") {
    private fun selectedOptions(): Int {
        val options = """
            Choose an option
            1. Register an $entity
            2. Show ${entity}s
            3. Modify $entity
            4. Delete $entity
            5. GO Back
            """.trimEnd()
        return try {
            Integer.parseInt(JOptionPane.showInputDialog(null, ""))
        } catch (e: NumberFormatException) {
            return 0
        }

    }

    fun show() {
        var option: Int
        var id: String
        do {
            option = selectedOptions()
            when (option) {
                1 -> {
                    try {
                        if (manager?.register() == true) {
                            JOptionPane.showMessageDialog(null, "$entity added successfully")
                        } else {
                            JOptionPane.showMessageDialog(null, "$entity successfully")
                        }
                    } catch (e: IllegalStateException){
                        JOptionPane.showMessageDialog(null, "Operation cancelled")

                    }
                }
                2 ->{
                    manager?.show()
                }
                3 ->{
                    try{
                        id = JOptionPane.showInputDialog(null, "Input $entity ID")
                        if(manager?.modify(id) == true){
                            JOptionPane.showMessageDialog(null, "$entity successfully")
                        }else{
                            JOptionPane.showMessageDialog(null, "$entity does not exists")
                        }
                    }catch (e: IllegalStateException){
                        JOptionPane.showMessageDialog(null, "Operation cancelled")

                    }
                }
                4 ->{
                    try{
                        id = JOptionPane.showInputDialog(null, "Input $entity ID")
                        if(manager?.modify(id) == true){
                            JOptionPane.showMessageDialog(null, "$entity successfully")
                        }else{
                            JOptionPane.showMessageDialog(null, "$entity does not exists")
                        }
                    }catch (e: IllegalStateException){
                        JOptionPane.showMessageDialog(null, "Operation cancelled")

                    }
                }
                0, 5 -> {
                    return
                }
                else{
                    JOptionPane.showMessageDialog(null, "Input a valid option")
                }
            }
            while (option != 5 && option != 0)

        }
    }

}