# TODO, by Yashwant Kumar
TODO is a Command Line application Using Java, Which helps in manage Daily Work.

1. Install Java: Setup java environment.
2. Source code Written the code in `Todo.java` file.
3. Compile Code with `javac Todo.java`.
4. Run Application with `java Todo`.
5. The app will read from and write to a `todo.txt` text file. Each todo item occupies a single line in this file. Here is an example file that has 2 todo items.

```txt
Call Mom
Message Saurav
```

6.  When a todo item is completed, it will be removed from `todo.txt` and added to the `done.txt` text file. This file has a different format:

    ```txt
    x 2020-06-12 the text contents of the todo item
    ```

    1. the letter x
    2. the date in `yyyy-mm-dd` format, when todo completed
    3. the original todo

## Usage

### 1. Help/Usage

Executing the command without any arguments, or with a single argument `help` prints the CLI usage.

```
$ java Todo help
Usage :-
$ java Todo add "todo item"  # Add a new todo
$ java Todo ls               # Show remaining todos
$ java Todo del NUMBER       # Delete a todo
$ java Todo done NUMBER      # Complete a todo
$ java Todo help             # Show usage
$ java Todo report           # Statistics
```

### 2. List all pending todos

Use the `ls` command to see all the todos that are not yet complete. The most recently added todo will be displayed first.

```
$ java Todo ls
[2] Message Saurav
[1] Call Mom
```

### 3. Add a new todo

Use the `add` command. The text of the todo item should be enclosed within double quotes (otherwise only the first word is considered as the todo text, and the remaining words are treated as different arguments).

```
$ java Todo add "Message Saurav"
Added todo: "Message Saurav"
```

### 4. Delete a todo item

Use the `del` command to remove a todo item by its number.

```
$ java Todo del 2
Deleted todo #2
```

Attempting to delete a non-existent todo item should display an error message.

```
$ java Todo del 5
Error: todo #5 does not exist. Nothing deleted.
```

### 5. Mark a todo item as completed

Use the `done` command to mark a todo item as completed by its number.

```
$ java Todo done 1
Marked todo #1 as done.
```

Attempting to mark a non-existed todo item as completed will display an error message.

```
$ java Todo done 5
Error: todo #5 does not exist.
```

### 6. Generate a report

Use the `report` command to see the latest tally of pending and completed todos.

```
$ java Todo report
yyyy-mm-dd Pending : 0 Completed : 1
```


Note: `todo.txt` contain all panding todos and `done.txt` contain all completed todos with date of completation.

Note: This is orignal code written by Yashwant Kumar, you can't use this code for your requirement without informing me. you can contact me by email: `yashwant.kumar.310@gmail.com`.
