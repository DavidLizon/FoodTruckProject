# Food Truck Project

## Description
This app asks a user to input the name, food type, and a rating for up to 5 food trucks. The user is able to stop entering trucks by naming the next truck quit at which point the user is offered a menu from which to choose from. If the user reviews 5 trucks the app automatically steps into the next section and displays the same menu as previously mentioned. The user can choose to view the info for the trucks that they entered, the average rating of all of the trucks entered, the highest rated truck, or quit the program.

## Lessons Learned
This program wasn't too difficult figuring out how to translate what was required into actionable steps; The problem was figuring out and putting into consistent thought what each piece of the code does and how it fits into the bigger picture. This is getting easier and easier with each new project. I had a semi-difficult time figuring out how to loop through the array and not print the elements of the array that were null. The biggest problem I ran into with this project ware the constructors in the second file that created the trucks. One of the truck fields was supposed to create a unique truck ID when the truck object was created but I could not figure out why each truck was creating the same ID. After going through the code over and over I realized that I was building the truck object too soon and assigning the required variables to the truck using the default/no-arg constructor. That constructor did not have the unique truck identifier code in it. That code was in the overloaded constructor. When I realized that, I refactored the code to get the user input first and then assign the values into the correct attribute locations. I also realized I could put the code for the unique identifier in an initializer block before the constructors.


## Technologies Used
Java, Eclipse, Git/GitHub
