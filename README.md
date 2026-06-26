# Reflection

## Exercise 01
When `getCourseById("C004")` is called, which file does the request go to first, second, and third?
1. The request goes to the `CourseService` class first, which handles the business logic and validation.
2. The request then goes to the `InMemoryCourseRepository` class, which is responsible for managing the data storage and retrieval of course information.
3. Finally, the request goes to the `Course` class, which represents the course entity and contains the course data.

## Exercise 02
Why is `InMemoryCourseRepository` temporary storage?
- `InMemoryCourseRepository` is temporary storage because it stores data in memory using a Java Collection (`LinkedHashMap`).
- Memory is volatile and will be lost when the application stops running.

What would probably replace it later when we use MongoDB?
- It will be replaced by MongoDB database service that is running on hard disk drive.
- Because a hard drive is permanent (non-volatile) storage, any data you save will stay perfectly intact, even if you turn off your application or shut down your computer for weeks.

## Exercise 03
Why is throwing CourseNotFoundException better than printing inside CourseService?
- A service's responsibility is executing and processing business rules. It shouldn't dictate how errors are displayed to an end-user.
- Printing `System.out.println()` only works in a terminal-based Console Application. By throwing a native exception instead, the service becomes adaptable to any user interface. For example:
    - A **Console** application can catch it and display custom text in the terminal.
    - **Web API Controller** can intercept it and automatically map it into a standardized 404 Not Found JSON payload response.
    - **Frontend application** can take that network error payload and display a styled error card or an alert toast message.

## Exercise 04
Why is CourseOffering a better design than putting start date, end date, and capacity directly inside Course?
- By using `CourseOffering`, the `Course` class stays clean as a reusable blueprint. 
- You can schedule multiple live intakes (`OFF001`, `OFF003`) at different times, with different capacities, or even swap instructors per cohort without modifying `Course` class.

## Exercise 05
Which version is easier to understand: loop or stream? Why?
- The loop version is easier to understand because it explicitly shows step-by-step instructions (creating an empty array list, manually evaluating an `if` condition, and physically appending the item). However, the stream version becomes easier once you are familiar with it because it reads like a natural English sentence and avoids boilerplate setup code.

What does `filter()` do in a stream?
- It acts as a conditional check gatekeeper (like an `if` statement). It looks at each individual item traveling down the data pipeline and tests it against a boolean statement; only items that evaluate to `true` are allowed to pass through to the next stage.