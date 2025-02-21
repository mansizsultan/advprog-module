# Advanced Programming Module Tutorial

| NAME               | ID         | ADVPROG CLASS |
| ------------------ | ---------- | ------------- |
| Sultan Ibnu Mansiz | 2306275840 | B             |


# Module 02: CI/CD & DevOps

### Reflection 1: Fixing Issues, Continuous Integration and Continuous Deployment

### **1. Code Quality Improvements and Strategy**  
   - **Eliminating Duplicated String Literals**  
     - **Problem**: The strings `"product"` and `"redirect:/product/list"` were repeated multiple times in `ProductController.java`.  
     - **Solution**: Introduced constants (`PRODUCT_ATTRIBUTE` and `REDIRECT_LIST`) to replace the repeated values, enhancing maintainability.  
     - **Why?** Using constants makes the code cleaner, easier to update, and reduces the risk of errors.  
   
   - **Empty Test Method in `EshopApplicationTests.java`**  
     - **Problem**: SonarCloud flagged `contextLoads` as an empty method, suggesting either documentation or an exception.  
     - **Solution**: Added a comment to clarify its purpose.  
     - **Why?** This aligns with unit testing best practices, improving code readability for future developers.  

   - **Unused Import in `ProductService.java`**  
     - **Problem**: The import `java.util.Optional` was present but not used.  
     - **Solution**: Removed the unnecessary import.  
     - **Why?** Cleaning up unused imports reduces code clutter and improves readability.  

---

### **2. CI/CD Analysis**  
   - **Continuous Integration (CI) Successfully Implemented**  
     - Automated tests run with every push to ensure code correctness.  
     - Static code analysis via SonarCloud maintains code quality.  
     - The pipeline helps detect potential bugs and security issues early in development.  

   - **Continuous Deployment (CD) is Partially Implemented**  
     - Instead of using a GitHub Actions workflow for deployment, **Koyeb’s Autodeployment** feature was enabled, allowing automatic deployment when code is pushed.  
     - While deployment is automated, integrating a push-based GitHub Action could further optimize the process.  
     - However, due to limitations in Koyeb’s free plan, a fully integrated GitHub Action workflow is not feasible.  
     - The current setup ensures that any commit merged into the `main` branch automatically updates the production environment.

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