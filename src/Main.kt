fun main() {
    val userInputList = mutableListOf<String>()
    var numberTasks = 0
    while (true) {
        println("\n❔ Choose an option:")
        println("1. Add Task")
        println("2. List Tasks")
        println("3. Remove Tasks")
        println("4. Exit")
        print("👉 Enter your choice: ")
        when (readLine()?.toIntOrNull()) {
          1 -> {
              print("✍ Enter input: ")
              val userTask = readLine()?.trim()
              val task = userTask?.let { AddTask(it) }
              if (task != null) {
              println(task.newTask)
                  userInputList.add(task.newTask)
                  numberTasks++
              }
              else {
                    println("❌ Input cannot be empty.")
                }
    }
            2 -> {
                if (userInputList.isEmpty()) {
                    noInputs()
                } else {
                    println("\n📜 Saved Inputs:")
                    userInputList.forEachIndexed { index, input -> println("$index. $input") }
                    println("Number of Tasks: $numberTasks")
                }
            }
            3 -> {
                if (userInputList.isEmpty()) {
                   noInputs()
                } else {
                    println("\n🗑 Remove Input:")
                    userInputList.forEachIndexed { index, input -> println("$index. $input") }
                    print("Enter index to remove: ")
                    val index = readLine()?.toIntOrNull()
                    if (index != null && index in userInputList.indices) {
                        userInputList.removeAt(index)
                        println("✅ Input removed!")
                        numberTasks-1
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
    println("❌ No inputs found.")
}