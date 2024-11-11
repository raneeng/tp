# Project Portfolio Page (PPP)

## Overview
**FlashBang** is a CLI app designed to provide students with a smart way of studying for their modules. The app will manage a limited number of flashcards for a small number of modules, optimized for users who prefer a CLI.

## Summary of Contributions

### Code Contributed
[RepSense Link](https://nus-cs2113-ay2425s1.github.io/tp-dashboard/?search=raneeng&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2024-09-20&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

### Enhancements Implemented
1. **Command Classes:**
    - **What**: Developed various command classes to handle user input and execute corresponding actions.
    - **How**: Implemented classes such as `AddCommand`, `DeleteCommand`, `FlashBangCommand`, etc.
    - **Why**: These classes are essential for the app's functionality, ensuring that user commands are processed accurately and efficiently.

2. **Command Class Testing:**
    - **What**: Created unit tests for command classes to ensure they work correctly.
    - **How**: Used JUnit framework to write tests covering different scenarios and edge cases.
    - **Why**: Ensures the reliability and correctness of command implementations, leading to a robust application.

3. **Show FlashBang Percentage:**
    - **What**: Implemented a feature to show the percentage of correctly answered flashcards.
    - **How**: Added methods to calculate and display the percentage based on user performance.
    - **Why**: Provides users with immediate feedback on their study progress, enhancing the learning experience.

4. **Show FlashBang Mistakes:**
    - **What**: Added functionality to display the mistakes made by users during flashcard sessions.
    - **How**: Implemented methods to track incorrect answers and present them to the user.
    - **Why**: Helps users identify areas that need improvement, fostering more effective studying.

### Contributions to User Guide (UG)
[UG](https://ay2425s1-cs2113-t11-2.github.io/tp/UserGuide.html)
- Wrote feature sections: `add`, `delete`, `flashbang`
    - **Add**: Detailed instructions on how users can add new flashcards.
    - **Delete**: Explained the process for removing flashcards.
    - **FlashBang**: Provided a comprehensive guide on using the flashbang feature.

### Contributions to Developer’s Guide (DG)
[DG](https://ay2425s1-cs2113-t11-2.github.io/tp/DeveloperGuide.html)
- Wrote ‘Parser component’ section:
    - Explained the role and functionality of the parser in interpreting user commands.
- Made Parser Partial Class Diagram:
    - Created a visual representation of the parser structure.
- Made Parser Delete Sequence Diagram:
    - Illustrated the sequence of operations for the delete command.

### Contributions to Team-Based Tasks
1. **Conducting Code Reviews and Providing Feedback:**
    - Reviewed pull requests to ensure code quality and adherence to project standards.
    - Provided constructive feedback to team members, facilitating improvements and learning.

2. **Maintaining the Issue Tracker:**
    - Managed the issue tracker by organizing and prioritizing tasks.
    - Ensured that issues were addressed promptly and efficiently.

3. **Updating User Docs:**
    - Documented the target user profile and other essential information for user documentation.
    - Ensured that the documentation was clear, concise, and helpful for end-users.

### Review/Mentoring Contributions:
[Example 1](https://github.com/AY2425S1-CS2113-T11-2/tp/pull/160)
[Example 2](https://github.com/AY2425S1-CS2113-T11-2/tp/pull/146)

### Contributions Beyond the Project Team
[Bugs reported in other team's products](https://github.com/raneeng/ped/issues)

## DG Extract

#### Structure
Below is a partial class diagram showing the interactions of the `Parser` class.
![Parser class diagram](./docs/diagrams/ParserPartialClassDiagram.jpg)

The sequence diagram below illustrates the interactions taking `parseCommand(“delete --m cs2113 --i 1”)` as an example.
![Sample delete call sequence diagram](./docs/diagrams/ParserDeleteSequenceDiagram.png)

#### Example
How the `Parser` component works:
1. The `Parser` receives the command input.
2. It identifies the command type using `parseCommandType`.
3. Depending on the command type, it creates the corresponding command object (e.g., `AddCommand`).
4. The created command is executed, producing a `CommandResult`.
5. The `CommandResult` is then used by `Ui` to provide feedback to the user.

