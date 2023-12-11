# Common mistakes 

1. **Avoid redundant empty lines.**
    - Bad example:
      ```kotlin
      class Main {
 
          fun main() {
              
              println("Hello world!")
          }
      }
      ```
    - Improved example:
      ```kotlin
      class Main {
          fun main() {
              println("Hello world!")
          }
      }
      ```

2. **Don't create temporary variables if you can directly return the value.**
    - Bad example:
      ```kotlin
      fun createUser(name: String, age: Int): User {
          val user = User(name, age)
          return user
      }
      ```
    - Improved example:
      ```kotlin
      fun createUser(name: String, age: Int): User = User(name, age)
      ```

3. **Avoid static methods; prefer creating instances.**
    - Bad example:
      ```kotlin
      class UserService {
          companion object {
              fun findByEmail(email: String): User {
                  // some implementation
              }
          }
      }
 
      fun main() {
          val user = UserService.findByEmail("email@gmail.com")
      }
      ```
    - Improved example:
      ```kotlin
      class UserService {
          fun findByEmail(email: String): User {
              // some implementation
          }
      }
 
      fun main() {
          val userService = UserService()
          val user = userService.findByEmail("email@gmail.com")
      }
      ```

4. **Reuse instances instead of creating several for the same purpose.**
    - Bad example:
      ```kotlin
      fun main() {
          val emails = arrayOf("myEmail@gmail.com", "not@Valid@.g.com")
          for (email in emails) {
              if (EmailValidator().isValid(email)) {
                  println("Email $email is valid")
              }
          }
      }
      ```
    - Improved example:
      ```kotlin
      fun main() {
          val emails = arrayOf("myEmail@gmail.com", "not@Valid@.g.com")
          val emailValidator = EmailValidator()
          for (email in emails) {
              if (emailValidator.isValid(email)) {
                  println("Email $email is valid")
              }
          }
      }
      ```

5. **Choose appropriate scope for variables.**
    - Bad example:
      ```kotlin
      class AccountService {
          fun calculateTax(income: Int): Int {
              val taxService = TaxService()
              val tax = taxService.getTax()
              return income * tax / 100
          }
      }
      ```
    - Improved example:
      ```kotlin
      class AccountService {
          private val taxService = TaxService()
 
          fun calculateTax(income: Int): Int {
              val tax = taxService.getTax()
              return income * tax / 100
          }
      }
      ```

6. **Use loops for creating multiple objects.**
    - Bad example:
      ```kotlin
      class Main {
          companion object {
              private const val NUMBER_OF_USERS = 3
          }
 
          fun main() {
              val users = arrayOfNulls<User>(NUMBER_OF_USERS)
              val firstUser = User()
              val secondUser = User()
              val thirdUser = User()
              users[0] = firstUser
              users[1] = secondUser
              users[2] = thirdUser
          }
      }
      ```
    - Improved example:
      ```kotlin
      class Main {
          companion object {
              private const val NUMBER_OF_USERS = 3
          }
 
          fun main() {
              val users = Array<User>(NUMBER_OF_USERS) { User() }
          }
      }
      ```

7. **Use constants for magic numbers.**
    - Bad example:
      ```kotlin
      class FigureSupplier {
          private val random = Random()
      
          fun getRandomFigure(): Figure {
              val figureNumber = random.nextInt(5)
              // generate a specific figure based on the `figureNumber` value
          }
      }
      ```
    - Improved example:
      ```kotlin
      class FigureSupplier {
          companion object {
              private const val FIGURE_COUNT = 5
          }
          private val random = Random()
      
          fun getRandomFigure(): Figure {
              val figureNumber = random.nextInt(FIGURE_COUNT)
              // generate a specific figure based on the `figureNumber` value
          }
      }
      ```

8. **Use `name` for the String representation of enum constants.**
    - Use `enumConstant.name` instead of `enumConstant.toString()` for a reliable String representation.

9. Don't forget how to name constants according to [style guide](https://mate-academy.github.io/style-guides/java/java.html#s5.2.4-constant-names). We have only Java style guide for now, so feel free to use it

10. **Write informative commit messages and PR descriptions.**
    - Avoid vague or generic messages. Be specific about the changes you made.
    - Bad example of commit/PR message: `done`/`fixed`/`commit`/`solution`/`added homework`/`my solution` and other one-word, abstract or random messages.
