# DESIGN PATTERN


# 1.Creational Pattern
  * Singleton Pattern
    * Ensures a class has only one instance and provides a global access point.
    * Usage: Database connection pool, Logger instance.
    
  * Factory Pattern
    * Creates objects without exposing the instantiation logic to the client.
    * Usage: Used in scenarios where a class cannot anticipate the type of objects it needs to create.

  * Builder Pattern
    * Allows for step-by-step object creation, especially useful for creating complex objects.
    * Usage: Constructing immutable objects like HttpRequest in Java.
      
# 2.Structural Pattern
  * Adapter Pattern
    * Converts the interface of a class into another interface that the client expects.
    * Usage: Integration with third-party libraries, legacy code support.
  
  * Decorator Pattern
    * Allows for dynamic addition of behavior to objects.
    * Usage: Adding features like encryption, logging without altering the core class.

  * Facade Pattern
    * Provides a simplified interface to a complex subsystem.
    * Usage: Simplifying interactions with a complex library.

# 3. Behavioral Patterns
 * Observer Pattern
   * Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified.
   * Usage: Event handling in GUI frameworks, Pub-Sub systems.

 * Strategy Pattern
   * Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
   * Usage: Payment strategies (CreditCard, PayPal).

* Command Pattern
  * Encapsulates a request as an object, allowing for parameterization of clients.
  * Usage: Undo/Redo operations in software.

  
