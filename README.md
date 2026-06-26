# Reflection

## Exercise 01
When `getCourseById("C004")` is called, which file does the request go to first, second, and third?
1. The request goes to the `CourseService` class first, which handles the business logic and v`alidation.
2. The request then goes to the `InMemoryCourseRepository` class, which is responsible for managing the data storage and retrieval of course information.
3. Finally, the request goes to the `Course` class, which represents the course entity and contains the course data.

## Exercise 02
Why is `InMemoryCourseRepository` temporary storage?
- `InMemoryCourseRepository` is temporary storage because it stores data in memory using a Java Collection (`LinkedHashMap`).
- Memory is volatile and will be lost when the application stops running.

What would probably replace it later when we use MongoDB?
- It will be replaced by MongoDB database service that is running on hard disk drive.
- Because a hard drive is permanent (non-volatile) storage, any data you save will stay perfectly intact, even if you turn off your application or shut down your computer for weeks.