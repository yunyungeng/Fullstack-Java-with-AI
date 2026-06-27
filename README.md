# Day 4
## Exercise 01
**What is one difference between a Java object and a JavaScript object?**
- A Java object cannot exist without a pre-defined class (a blueprint). JavaScript object can be created instantly out of thin air as a raw key-value pair (called an object literal) without needing any class blueprint at all.

## Exercise 02
**How is a JavaScript array similar to Java ArrayList?**
- Java ArrayList and JavaScript Arrays are both dynamic arrays. This means they both automatically grow and shrink in your computer's memory on the fly as you add or remove elements.

## Exercise 03
**Why are arrow functions important before learning React?**
- Arrow functions are important before React because React uses a lot of callbacks, event handlers, and map() functions, and arrow functions make those patterns easier to read and write.

## Exercise 04
**1. What is the difference between filter, find, and map?**
- `filter`: Evaluates all items and returns a new array containing every item that matches the condition.
- `find`: Searches through the items and returns only the first single object that matches the condition (or `undefined` if no match is found).
- `map`: Transforms every item in the collection and returns a new array containing those changed values (holding the exact same length as the original array).

**2. Which four array methods change the original array?**
- `push`, `pop`, `shift`, `unshift`

**3. What does push return?**
- It returns a number representing the new total length of the array after the item has been appended.

**4. What does pop return?**
- It returns the actual element/object that was just removed from the very end of the array.

**5. What is the difference between shift and unshift?**
- `shift`: Removes an item from the beginning (index `0`) of the array.
- `unshift`: Adds a new item to the beginning (index `0`) of the array.

## Exercise 05
**What does the DOM allow JavaScript to do?**
- The DOM (Document Object Model) acts as a live programmatic bridge connecting your code to the browser layout. It allows JavaScript to dynamically look up elements, create new components on the fly, alter styles, update text blocks, or delete structures dynamically inside the HTML viewport page without ever requiring a heavy hard-refresh reload of the entire website.

## Exercise 06
**How is JavaScript filter used in a search feature?**
- In a search feature, `filter` scans your data list. It loops over the entire array, takes the search text you typed, and uses a condition like `.includes()` to check if that text matches each name. Every student object that matches is copied into a brand-new filtered array, which is then handed over to your display code to immediately update what the user sees on the screen.

## Exercise 07
**1. What does async mean?**
- It explicitly flags a function as asynchronous, letting the JavaScript runtime engine know that the function is going to handle multi-step actions that won't complete instantly (like loading external data assets). It allows the application to keep running other processes background tasks instead of locking up or freezing the screen while waiting.

**2. What does await do?**
- It pauses the line-by-step execution inside an `async` function until an ongoing asynchronous operation completes. It forces JavaScript to wait for a specific download or data conversion to finish successfully before trying to read variables on the lines below it.

**3. What does fetch do?**
- It initiates an asynchronous HTTP network payload web request to grab data from an external target resource, such as a file path link on the current disk storage or a remote server endpoint URL database.

**4. Why do we use fetch before connecting to a real backend API?**
- Using a static JSON file simulates an actual server connection without dealing with live server bugs, complex framework dependencies, network lag, or security firewalls. This allows you to verify that your front-end looping layout rules are fully correct first.

**5. Why should this exercise be run using Live Server?**
- Modern web browsers use a security checkpoint mechanism called CORS (Cross-Origin Resource Sharing) that blocks web applications from reading files directly out of raw local machine folders (`file://`). Running your code inside Live Server hosts the code inside a standard virtual development domain (`http://localhost`), bypassing the local security sandbox.