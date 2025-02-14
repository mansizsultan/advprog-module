# Advanced Programming Module Tutorial

| NAME               | ID         | ADVPROG CLASS |
| ------------------ | ---------- | ------------- |
| Sultan Ibnu Mansiz | 2306275840 | B             |

# Module 01: Coding Standards

### Reflection 1: Clean Code and Secure Coding Practices

#### **Clean Code Principles**
1. **Meaningful Names**: Use descriptive names like `findById` and `productId` for clarity.
2. **Single Responsibility**: Methods should focus on one task, e.g., deleting a product and redirecting.
3. **Encapsulation**: Use classes like `Product` to group related logic and ensure valid data.
4. **Error Handling**: Display clear error messages instead of failing silently.

#### **Secure Coding Practices**
1. **Input Validation**: Use annotations like `@NotBlank` and `@Min` to validate user input.
2. **Output Encoding**: Encode data (e.g., with Thymeleaf’s `th:text`) to prevent XSS attacks.

---

### Reflection 2: Unit Testing

#### **Unit Testing Principles**
1. **Importance**: Unit tests ensure code quality, prevent regressions, and build confidence.
2. **Test Coverage**: Focus on key scenarios like edge cases, errors, and integrations, not just line coverage.
3. **Code Cleanliness**: Avoid duplication by:
   - Creating a **Base Test Class** for shared setup.
   - Using the **Page Object Pattern** for UI interactions.
   - Adding **Helper Methods** for reusable actions like waiting.

These practices improve readability, maintainability, and scalability of tests.