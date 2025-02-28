# Advanced Programming Module Tutorial

| NAME               | ID         | ADVPROG CLASS |
| ------------------ | ---------- | ------------- |
| Sultan Ibnu Mansiz | 2306275840 | B             |

# Module 03: Maintainability & OO Principles

## Reflection 1: Implementing SOLID Principles

### 1. Application of SOLID Principles in the Project

- **Single Responsibility Principle (SRP):**  
  Each class is designed to focus on a single responsibility.  
  **Example:**
     - `MainController.java` is responsible solely for handling the homepage:
       ```java
       @Controller
       public class MainController {
           @GetMapping("")
           public String mainPage() {
               return "homePage";
           }
       }
       ```
     - `ProductController.java` and `CarController.java` each manage distinct business operations related to products and cars.

- **Open-Closed Principle (OCP):**  
  The code is structured to allow extension without modifying existing implementations.  
  **Example:**
     - The use of generic interfaces like `BaseService<T>` and `BaseRepository<T>` makes it possible to add new entities without altering pre-existing logic.

- **Liskov Substitution Principle (LSP):**  
  Subclasses should seamlessly replace their parent classes without introducing errors.  
  **Example:**
     - `CarServiceImpl` implements `CarService`, ensuring that any code expecting `CarService` functions correctly with `CarServiceImpl`:
       ```java
       public class CarServiceImpl implements CarService { … }
       ```

- **Interface Segregation Principle (ISP):**  
  Interfaces are kept specific to prevent clients from depending on unnecessary methods.  
  **Example:**
     - Instead of a large, general interface, separate ones like `ProductService` and `CarService` extend `BaseService<T>` for better modularity:
       ```java
       public interface ProductService extends BaseService<Product> { … }
       ```

- **Dependency Inversion Principle (DIP):**  
  High-level modules rely on abstractions rather than concrete implementations.  
  **Example:**
     - Controllers inject dependencies through interfaces, increasing flexibility and testability. In `ProductController`, `ProductService` is injected:
       ```java
       @Autowired
       private ProductService productService;
       ```

### 2. Benefits of Applying SOLID Principles

- **Easier Maintenance: **
     - **SRP:** Changes related to a particular functionality are limited to a single class.
     - **Example:** Updating validation logic in `ProductServiceImpl` does not require modifications in `ProductController`.

- **Improved Scalability:**
     - **OCP:** New functionalities can be added without modifying existing code.
     - **Example:** Introducing a new entity, such as `Order`, only requires implementing a new service extending `BaseService<Order>`.

- **Better Testability:**
     - **DIP:** Using interfaces rather than concrete classes makes unit testing more straightforward.
     - **Example:** `ProductControllerTest` utilizes a mock `ProductService` to test controller behavior independently.

- **Greater Flexibility and Reliability:**
     - **LSP:** Swapping out one implementation for another does not cause issues.
     - **ISP:** Small, well-defined interfaces ensure that components only interact with necessary methods.

### 3. Consequences of Not Following SOLID Principles

- **Tightly Coupled Code:**
     - Without **DIP**, controllers might be directly tied to implementations, making modifications cumbersome and error-prone.
     - **Example:** If `ProductController` were to instantiate `ProductServiceImpl` directly, altering the service would require changes in multiple places.

- **Overly Complex Classes:**
     - Without **SRP**, a single class may handle multiple concerns, making the code harder to read and maintain.
     - **Example:** A controller managing both product and car logic introduces unnecessary dependencies and complexity.

- **Lack of Flexibility:**
     - Without **OCP**, adding new features often requires altering existing code, increasing the risk of regressions.
     - **Example:** Expanding business logic in a monolithic service could unintentionally disrupt existing functionality.

- **Challenges in Testing:**
     - Without **ISP**, large interfaces force implementations to handle unrelated methods, complicating testing.
     - **Example:** If a service interface combined product, car, and order operations, unit testing product-specific logic would require unnecessary dependencies.

---

# Module 02: CI/CD & DevOps

## Reflection 1: Fixing Issues, Continuous Integration, and Continuous Deployment

### 1. Code Quality Improvements and Strategy

- **Eliminating Duplicated String Literals:**
     - **Problem:** The strings `"product"` and `"redirect:/product/list"` were repeated multiple times in `ProductController.java`.
     - **Solution:** Introduced constants (`PRODUCT_ATTRIBUTE` and `REDIRECT_LIST`) to replace the repeated values, enhancing maintainability.
     - **Why?** Using constants makes the code cleaner, easier to update, and reduces the risk of errors.

- **Empty Test Method in `EshopApplicationTests.java`:**
     - **Problem:** SonarCloud flagged `contextLoads` as an empty method, suggesting either documentation or an exception.
     - **Solution:** Added a comment to clarify its purpose.
     - **Why?** This aligns with unit testing best practices, improving code readability for future developers.

- **Unused Import in `ProductService.java`:**
     - **Problem:** The import `java.util.Optional` was present but not used.
     - **Solution:** Removed the unnecessary import.
     - **Why?** Cleaning up unused imports reduces code clutter and improves readability.

### 2. CI/CD Analysis

- **Continuous Integration (CI) Successfully Implemented:**
     - Automated tests run with every push to ensure code correctness.
     - Static code analysis via SonarCloud maintains code quality.
     - The pipeline helps detect potential bugs and security issues early in development.

- **Continuous Deployment (CD) is Partially Implemented:**
     - Instead of using a GitHub Actions workflow for deployment, **Koyeb’s Autodeployment** feature was enabled, allowing automatic deployment when code is pushed.
     - While deployment is automated, integrating a push-based GitHub Action could further optimize the process.
     - However, due to limitations in Koyeb’s free plan, a fully integrated GitHub Action workflow is not feasible.
     - The current setup ensures that any commit merged into the `main` branch automatically updates the production environment.

---

# Module 01: Coding Standards

## Reflection 1: Clean Code and Secure Coding Practices

### Clean Code Principles

1. **Meaningful Names:** Use descriptive names like `findById` and `productId` for clarity.
2. **Single Responsibility:** Methods should focus on one task, e.g., deleting a product and redirecting.
3. **Encapsulation:** Use classes like `Product` to group related logic and ensure valid data.
4. **Error Handling:** Display clear error messages instead of failing silently.

### Secure Coding Practices

1. **Input Validation:** Use annotations like `@NotBlank` and `@Min` to validate user input.
2. **Output Encoding:** Encode data (e.g., with Thymeleaf’s `th:text`) to prevent XSS attacks.

---

## Reflection 2: Unit Testing

### Unit Testing Principles

1. **Importance:** Unit tests ensure code quality, prevent regressions, and build confidence.
2. **Test Coverage:** Focus on key scenarios like edge cases, errors, and integrations, not just line coverage.
3. **Code Cleanliness:** Avoid duplication by:
     - Creating a **Base Test Class** for shared setup.
     - Using the **Page Object Pattern** for UI interactions.
     - Adding **Helper Methods** for reusable actions like waiting.

These practices improve readability, maintainability, and scalability of tests.