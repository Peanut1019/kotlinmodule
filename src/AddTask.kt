

class AddTask(task : String = "A Task"){
    val newTask : String = task
    init {
        println("Task Added") //Prints before the new task is displayed
    }
}