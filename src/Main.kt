fun main() {
    //List and number of tasks variables
    val userInputList = mutableListOf<String>()
    var numberTasks = 0
    //The start of the loop
    while (true) {
        println("\n❔ Choose an option:")
        println("1. Add Task")
        println("2. List Tasks")
        println("3. Remove Tasks")
        println("4. Exit")
        print("👉 Enter your choice: ")
        // Reads the input and selects the number given
        when (readLine()?.toIntOrNull()) {
          //Add task selection
            1 -> {
              print("✍ Enter input: ")
              val userTask = readLine()?.trim()
              val task = userTask?.let { AddTask(it) }
              if (task != null) { //if input given is not empty
              println(task.newTask) //prints the task and calls the AddTask class
                  userInputList.add(task.newTask) // adds it to the list and calls the AddTask class
                  numberTasks++ //+1 to the task counter
              }
              else {
                    println("❌ Input cannot be empty.")
                }
    }
            //Lists all the tasks
            2 -> {
                if (userInputList.isEmpty()) {
                    noInputs()
                } else {
                    println("\n📜 Saved Inputs:")
                    //Iterates through each of the tasks and displays them w/ index
                    userInputList.forEachIndexed { index, input -> println("$index. $input") }
                    println("Number of Tasks: $numberTasks") // Provides the number of tasks
                }
            }
            //Deletes the task selected
            3 -> {
                if (userInputList.isEmpty()) {
                   noInputs()
                } else {
                    println("\n🗑 Remove Task:")
                    userInputList.forEachIndexed { index, input -> println("$index. $input") }
                    print("Enter index to remove: ")
                    val index = readLine()?.toIntOrNull()
                    if (index != null && index in userInputList.indices) {
                        userInputList.removeAt(index) //Selects the task to remove using the index of the task
                        println("✅ Input removed!")
                        numberTasks-1 //-1 to the task counter
                    } else {
                        println("❌ Invalid index.")
                    }
                }
            }
            4 -> {
                println("👋 Exiting... Goodbye!")
                break
            }
            else -> println("❌ Invalid choice, please try again.")
        }
    }
}
fun noInputs() {
    println("❌ No inputs found.") //Will display the texts if there are no inputs found:)
}